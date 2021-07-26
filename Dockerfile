FROM openjdk:11.0.1-jre-slim-stretch
EXPOSE 8090
COPY target/*.jar /payment-info-handler.jar
ENTRYPOINT ["java","-jar","/payment-info-handler.jar"]