Maven Wildfly plugin commands:

Simple command:
mvn clean install

Use run goal to keep the server running:
mvn clean install -Dwildfly.goal=run

Start server in debug mode on debug port 8887:
mvn clean install -Dwildfly2.debug.param=-agentlib:jdwp=transport=dt_socket,address=8887,server=y,suspend=n

Start server in port offset of 100:
mvn clean install -Dwildfly2.port.management=10090 -Dwildfly2.port.offset=100