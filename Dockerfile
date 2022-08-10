FROM openjdk:8-jdk-alpine
MAINTAINER SELF-PUNNATI
VOLUME /tmp
EXPOSE 8080
COPY deploy/store-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]