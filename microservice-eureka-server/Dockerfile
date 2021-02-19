FROM java:8-jre
MAINTAINER sx
ADD ./target/microservice-eureka-server-0.0.1-SNAPSHOT.jar /app/microservice-eureka-server.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-eureka-server.jar"]
EXPOSE 8761
