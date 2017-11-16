import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.impl.ConnectionManager;
import io.vertx.core.http.impl.Http1xPool;
import io.vertx.core.http.impl.HttpClientImpl;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.Completion;
import io.vertx.ext.unit.TestOptions;
import io.vertx.ext.unit.TestSuite;
import io.vertx.ext.unit.report.ReportOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeakTest {
    private Logger logger = LoggerFactory.getLogger(LeakTest.class);

    @Test
    public void test() throws Exception {
        Vertx vertx = Vertx.vertx();

        // Set up a server
        vertx.createHttpServer().requestHandler(request -> {
            if (request.path().equals("/leak")) {
                request.response()
                        .setStatusCode(200)
                        .putHeader("Content-Encoding", "gzip")
                        .end("long response with mismatched encoding causes connection leaks");
            } else if (request.path().equals("/no_leak")) {
                request.response()
                        .setStatusCode(200)
                        .putHeader("Content-Encoding", "gzip")
                        .end("no leaking");
            } else {
                request.response()
                        .setStatusCode(200)
                        .end("ok");
            }
        }).listen(4080);

        // Create an HTTP client
        HttpClient httpClient = vertx.createHttpClient(new HttpClientOptions()
                .setTryUseCompression(true)
                .setMaxPoolSize(5)
        );

        // Use reflection to get queueMap and connectionMap from httpClient
        Object[] maps = getInternalMaps(httpClient);

        // Start to make some requests

        // Send normal requests
        TestSuite testSuite = TestSuite.create("");
        testSuite.test("Normal", 10, testContext -> {
            Async async = testContext.async();
            makeRequestAndCheck(vertx, async, httpClient, maps, "/");
        });

        // Send requests that get responses with mismatched encoding, but no leaking
        testSuite.test("No leak", 10, testContext -> {
            Async async = testContext.async();
            makeRequestAndCheck(vertx, async, httpClient, maps, "/no_leak");
        });

        // Send requests that cause leaks
        testSuite.test("Leak", 10, testContext -> {
            Async async = testContext.async();
            makeRequestAndCheck(vertx, async, httpClient, maps, "/leak");
        });

        Completion completion = testSuite.run(new TestOptions().addReporter(new ReportOptions().setTo("console")));
        completion.awaitSuccess();
    }

    private Object[] getInternalMaps(HttpClient httpClient) throws Exception {
        HttpClientImpl httpClientImpl = (HttpClientImpl) httpClient;
        Field connectionManagerField = HttpClientImpl.class.getDeclaredField("connectionManager");
        connectionManagerField.setAccessible(true);
        ConnectionManager connectionManager = (ConnectionManager) connectionManagerField.get(httpClientImpl);
        Field requestQMField = ConnectionManager.class.getDeclaredField("requestQM");
        requestQMField.setAccessible(true);
        Object requestQM = requestQMField.get(connectionManager);

        Class QueueManager = ConnectionManager.class.getDeclaredClasses()[3];
        Field queueMapField = QueueManager.getDeclaredField("queueMap");
        queueMapField.setAccessible(true);
        Field connectionMapField = QueueManager.getDeclaredField("connectionMap");
        connectionMapField.setAccessible(true);
        return new Object[]{
                queueMapField.get(requestQM),
                connectionMapField.get(requestQM)
        };
    }

    private void makeRequestAndCheck(Vertx vertx, Async async, HttpClient httpClient, Object[] maps, String uri) {
        logger.info("Get http://localhost:4080{}", uri);
        httpClient.get(4080, "localhost", uri)
                .putHeader("Connection", "close")
                .exceptionHandler(t -> {
                    logger.warn("Request exception: {}", t.getMessage());
                }).handler(response -> {
            logger.info("Response received");
            response.exceptionHandler(t -> {
                logger.warn("Response exception: {}", t.getMessage());
            }).bodyHandler(buffer -> {
                logger.info("Response body: {}", buffer);
            });
        }).setTimeout(500).end();

        vertx.setTimer(1000, id -> {
            printConnectionStatus(maps);
            async.complete();
        });
    }

    private void printConnectionStatus(Object[] maps) {
        final Map queueMap = (Map) maps[0];
        final Map connectionMap = (Map) maps[1];
        StringBuilder sb = new StringBuilder();
        boolean leaked = false;
        try {
            if (!queueMap.isEmpty()) {
                Object connQueue = queueMap.values().toArray()[0];
                if (connQueue != null) {
                    Field poolField = ConnectionManager.ConnQueue.class.getDeclaredField("pool");
                    poolField.setAccessible(true);
                    Http1xPool pool = (Http1xPool) poolField.get(connQueue);
                    if (pool != null) {
                        Field allConnectionsField = Http1xPool.class.getDeclaredField("allConnections");
                        allConnectionsField.setAccessible(true);
                        Field availableConnectionsField = Http1xPool.class.getDeclaredField("availableConnections");
                        availableConnectionsField.setAccessible(true);
                        Set allConnections = (Set) allConnectionsField.get(pool);
                        Queue availableConnections = (Queue) availableConnectionsField.get(pool);
                        if (allConnections != null) {
                            leaked = !allConnections.isEmpty();
                            sb.append(", allConnections.size=").append(allConnections.size()).append(", ");
                        } else {
                            sb.append(", allConnections=null, ");
                        }
                        if (availableConnections != null) {
                            sb.append("availableConnections.size=").append(availableConnections.size());
                        } else {
                            sb.append("availableConnections=null");
                        }
                    } else {
                        sb.append(", pool is null");
                    }
                } else {
                    sb.append(", connQueue is null");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        logger.info("Status: queueMap.size={}, connectionMap.size={}{}", queueMap.size(), connectionMap.size(), sb);
        if (leaked) {
            logger.warn("========== LEAKING ! ==========");
        } else {
            logger.info("========== no leak   ==========");
        }
    }
}
