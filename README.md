## Project for retrieving previous month expenditure for all accounts of the Bank Customer

## Getting Started

This is a project built with [Spring Boot](http://projects.spring.io/spring-boot/) REST web services application.

## API Documentation

The Swagger API specification for accessing REST API exposed by this project is available at resources/public/spec-api.yml

This specification can also be accessed when the service is running at the /spec-api.yml endpoint (e.g. http://localhost:8080/spec-api.yml)

Note that an access token required by the API (for sandbox access) is obtained offline through developer registration with the bank. 

## Languages

This project is authored in Java.

## Installation

### Fork the Repository

Fork the [payment_handler project](https://github.com/bsamray/payment-info-handler.git) on GitHub.  Clone the project to the host machine.

### Dependencies

The project requires the following dependencies be installed on the host machine:

* Java Development Kit 11 or later

### Code Style

This project uses Intellij IDEA Default code styling

## Running

The project supports [Maven](http://maven.apache.org/) for managing the project lifecycle.  

### Important commands

Below maven goals are used in important commands issued at the project root directory to operate the project

#### spring-boot:run

Below command is for a non-prod environment and this launches the application on the embedded Tomcat server.
The version and artifact attributes are part of the JAR file name. 
The environment variables passed are for production environment only.
For other environments, ignore the arguments except server.port (if you wish to change the default HTTP port 8080).

For non-production environment
```
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8089 --application.endpoint.bank.baseurl=https://api-sandbox.starlingbank.com"
```

For production environment
```
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8089 --spring.profiles.active=prod --application.endpoint.bank.baseurl=https://api.starlingbank.com"
```

#### test

The command below runs the unit test suites against the main source code.  
The unit tests success should be a prerequisite in the continuous integration.

```
./mvnw clean test
```

#### package

The command below prepares the JAR deployable file in the target directory for distribution to server environments.

```
./mvnw clean package
```
The JAR file can be run using the below command at the project root. 
The version and artifact attributes are part of the JAR file name. 
The environment variables passed are for production environment only. 
For other environments, ignore the arguments except server.port (if you wish to change the port)

For non-production environment
```
java -jar target/payment-info-handler-0.0.1-SNAPSHOT.jar --server.port=8089 --application.endpoint.bank.baseurl=https://api-sandbox.starlingbank.com   
```

For production environment
```
java -jar target/payment-info-handler-0.0.1-SNAPSHOT.jar --server.port=8089 --spring.profiles.active=prod --application.endpoint.bank.baseurl=https://api.starlingbank.com   
```

## Health check and Monitoring

The actuator endpoints for health check and monitoring are available at the following endpoints

Application Health
```
http://localhost:8080/actuator/health

```
Application Information
```
http://localhost:8080/actuator/info

```
Application Information
```
http://localhost:8080/actuator/info

```
Application loggers
```
http://localhost:8080/actuator/loggers

```
## Containerisation

A docker image can be built using the Dockerfile in the project root directory using the Dockerfile provided. The tag name is provided in the command

```
./docker build . -t handb/paymentinfohandler
```
Once this successfully runs, below command can be used to see the new image in the list of docker images.
```
./docker images
```
The image can be run on a container using the below command. Spring profile name 'prod' must be mentioned when running 
the image in a production environment. 8080 is the target port, which can be changed with providing an accompanying 
server port environment variable. Please note that profiles ignored in non-prod environment.
```
./docker run  -e "SPRING_PROFILES_ACTIVE=prod” -p 8080:8080 handb/paymentinfohandler
```


