FROM adoptopenjdk/openjdk8-openj9:alpine-slim
WORKDIR /app
ADD target/brionac-backend-1.0-SNAPSHOT.jar .
EXPOSE 9090
ENTRYPOINT ["java", "-Dfile.encoding=utf-8", "-jar", "/app/brionac-backend-1.0-SNAPSHOT.jar"]
