How tos:
===

Run full build (unit tests, deploy app and functional tests):
---
`mvn clean install`

Html report for tests (both success and failure) will be available in:
---
_{projectDirectory}/target/site/failsafe-report.html_

Run unit tests only:
---
`mvn clean install -P unit-tests`

Deploy app and start server:
---
`mvn clean install -P deploy-apps`

`mvn cargo:run -pl :wildfly-setup`

Server will be accessible at [http://localhost:8080](http://localhost:8080)

Run functional tests only:
---
`mvn clean install -P deploy-apps`

`mvn cargo:run -pl :wildfly-setup`

`mvn clean install -P functional-tests`

Run individual functional test in IDE:
---
`mvn clean install -P deploy-apps`

`mvn cargo:run -pl :wildfly-setup`

Then go to individual functional test and run from IDE

Start wildfly server in different port (to run multiple instances):
---
`mvn cargo:run -pl :wildfly-setup -DserverPortOffset=1000`

This will start server at [http://localhost:9080](http://localhost:9080) (default port + 1000)

**Note:** Server started message is not displayed, still the sever is started


