How tos:

Run full build (unit tests, deploy app and functional tests):
mvn clean install

Generating html reports for test failure:
mvn surefire-report:report-only

Run unit tests:
mvn clean install -P unit-tests

Deploy app and start server:
mvn clean install -P deploy-apps
mvn cargo:run -pl :wildfly-setup

Run functional tests:
mvn clean install -P deploy-apps
mvn cargo:run -pl :wildfly-setup
mvn clean install -P functional-tests

Run individual functional test in IDE:
mvn clean install -P deploy-apps
mvn cargo:run -pl :wildfly-setup
Then go to individual functional test and run from IDE



