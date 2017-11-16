# connection_leak
Unit test to reproduct connection leaks in Vert.x HttpClient

```
$ mvn clean test
```

Results
```
Running LeakTest
Configuring TestNG with: org.apache.maven.surefire.testng.conf.TestNG652Configurator@6f2b958e
Begin test suite
Begin test Normal
[main] INFO LeakTest - Get http://localhost:4080/
[vert.x-eventloop-thread-2] INFO LeakTest - Response received
[vert.x-eventloop-thread-2] INFO LeakTest - Response body: ok
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
[vert.x-eventloop-thread-3] INFO LeakTest - Response body: ok
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
[vert.x-eventloop-thread-3] INFO LeakTest - Response body: ok
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
[vert.x-eventloop-thread-3] INFO LeakTest - Response body: ok
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
[vert.x-eventloop-thread-3] INFO LeakTest - Response body: ok
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
[vert.x-eventloop-thread-3] INFO LeakTest - Response body: ok
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
[vert.x-eventloop-thread-3] INFO LeakTest - Response body: ok
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
[vert.x-eventloop-thread-3] INFO LeakTest - Response body: ok
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
[vert.x-eventloop-thread-3] INFO LeakTest - Response body: ok
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
[vert.x-eventloop-thread-3] INFO LeakTest - Response body: ok
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
Passed Normal
Begin test No leak
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/no_leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:05 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Connection was closed
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/no_leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:06 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Connection was closed
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/no_leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:07 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Connection was closed
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/no_leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:08 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Connection was closed
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/no_leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:09 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Connection was closed
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/no_leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:10 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Connection was closed
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/no_leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:11 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Connection was closed
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/no_leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:12 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Connection was closed
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/no_leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:13 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Connection was closed
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/no_leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:14 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Connection was closed
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=0, connectionMap.size=0
[vert.x-eventloop-thread-3] INFO LeakTest - ========== no leak   ==========
Passed No leak
Begin test Leak
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:15 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
Nov 16, 2017 3:06:15 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=1, connectionMap.size=1, allConnections.size=1, availableConnections.size=0
[vert.x-eventloop-thread-3] WARN LeakTest - ========== LEAKING ! ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:16 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
Nov 16, 2017 3:06:16 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=1, connectionMap.size=2, allConnections.size=2, availableConnections.size=0
[vert.x-eventloop-thread-3] WARN LeakTest - ========== LEAKING ! ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:17 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
Nov 16, 2017 3:06:17 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=1, connectionMap.size=3, allConnections.size=3, availableConnections.size=0
[vert.x-eventloop-thread-3] WARN LeakTest - ========== LEAKING ! ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:18 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
Nov 16, 2017 3:06:18 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=1, connectionMap.size=4, allConnections.size=4, availableConnections.size=0
[vert.x-eventloop-thread-3] WARN LeakTest - ========== LEAKING ! ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/leak
[vert.x-eventloop-thread-3] INFO LeakTest - Response received
Nov 16, 2017 3:06:19 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
Nov 16, 2017 3:06:19 PM io.vertx.core.net.impl.ConnectionBase
SEVERE: io.netty.handler.codec.compression.DecompressionException: Input is not in the GZIP format
[vert.x-eventloop-thread-3] WARN LeakTest - Response exception: Input is not in the GZIP format
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=1, connectionMap.size=5, allConnections.size=5, availableConnections.size=0
[vert.x-eventloop-thread-3] WARN LeakTest - ========== LEAKING ! ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/leak
[vert.x-eventloop-thread-3] WARN LeakTest - Request exception: The timeout period of 500ms has been exceeded while executing GET /leak for host localhost
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=1, connectionMap.size=5, allConnections.size=5, availableConnections.size=0
[vert.x-eventloop-thread-3] WARN LeakTest - ========== LEAKING ! ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/leak
[vert.x-eventloop-thread-3] WARN LeakTest - Request exception: The timeout period of 500ms has been exceeded while executing GET /leak for host localhost
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=1, connectionMap.size=5, allConnections.size=5, availableConnections.size=0
[vert.x-eventloop-thread-3] WARN LeakTest - ========== LEAKING ! ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/leak
[vert.x-eventloop-thread-3] WARN LeakTest - Request exception: The timeout period of 500ms has been exceeded while executing GET /leak for host localhost
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=1, connectionMap.size=5, allConnections.size=5, availableConnections.size=0
[vert.x-eventloop-thread-3] WARN LeakTest - ========== LEAKING ! ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/leak
[vert.x-eventloop-thread-3] WARN LeakTest - Request exception: The timeout period of 500ms has been exceeded while executing GET /leak for host localhost
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=1, connectionMap.size=5, allConnections.size=5, availableConnections.size=0
[vert.x-eventloop-thread-3] WARN LeakTest - ========== LEAKING ! ==========
[vert.x-eventloop-thread-3] INFO LeakTest - Get http://localhost:4080/leak
[vert.x-eventloop-thread-3] WARN LeakTest - Request exception: The timeout period of 500ms has been exceeded while executing GET /leak for host localhost
[vert.x-eventloop-thread-3] INFO LeakTest - Status: queueMap.size=1, connectionMap.size=5, allConnections.size=5, availableConnections.size=0
[vert.x-eventloop-thread-3] WARN LeakTest - ========== LEAKING ! ==========
Passed Leak
End test suite  , run: 3, Failures: 0, Errors: 0
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 30.798 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```
