To build the project use the maven build tool.
command: mvn clean install

After the project is built in the target folder should be a .war file.
/Server/target/alaska-excursions.war

Use tomcat to deploy this .war file to the server in order to run the server.
http://104.131.170.128:8080/manager
username = name
password = alaska
