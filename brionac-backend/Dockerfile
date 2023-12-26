FROM adoptopenjdk/openjdk8-openj9:alpine-slim
WORKDIR /app
ADD target/brionac-backend-1.0-SNAPSHOT.jar .
EXPOSE 9090
ENV JAVA_OPTS="-server -Xms256m -Xmx256m"
ENTRYPOINT java -Dfile.encoding=utf-8 $JAVA_OPTS -Xshareclasses -Xquickstart -jar /app/brionac-backend-1.0-SNAPSHOT.jar
