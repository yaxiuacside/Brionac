# 使用 OpenJDK 基础镜像
FROM openjdk:11-jre-slim

# 设置工作目录
WORKDIR /app

# 将构建好的 JAR 文件复制到镜像中
COPY target/brionac-backend-1.0-SNAPSHOT.jar /app/brionac-backend.jar

ENV spring.profiles.active="dev"
# 指定容器启动时执行的命令
ENTRYPOINT ["java","-jar","brionac-backend.jar"]
