This project is tested with the following tools and version
---
* Oracle JDK 8, build version 1.8.0_31
* Apache Maven 3, build version 3.2.5

How tos:
===

Run full build (unit tests, deploy app and functional tests):
---
`mvn clean install`

Run unit tests only:
---
`mvn clean install -P unit-tests`

Run apps in server:
---
`mvn clean install -P run-apps`

Server will be accessible at [http://localhost:8080](http://localhost:8080)

Run functional tests:
---
`mvn clean install -P functional-tests`

**To run webdriver to firefox browser**

`mvn clean install -P functional-tests -Ddriver=firefox`

Run individual functional test in IDE:
---
Go to individual functional test and run from IDE

Start wildfly server in different port (to run multiple instances):
---
`mvn clean install -P run-apps -DserverPortOffset=1000 -DserverHttpPort=9080 -DserverManagementPort=10990 -DserverDebugPort=9787`

This will start server at [http://localhost:9080](http://localhost:9080) (default port + 1000)

To generate html reports:
---
'mvn surefire-report:report-only surefire-report:failsafe-report-only'

report will be generated under

_{projectDirectory}/target/site/_




