FROM openjdk:8-jdk-alpine
ADD /target/blackbox-1.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]