FROM openjdk:21-ea-24-oracle

WORKDIR /app

COPY target/rol-eventgrid-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090

CMD ["java", "-jar", "app.jar"]