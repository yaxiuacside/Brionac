# Step 1: 使用 Maven 进行构建
FROM maven:3.6.3-jdk-11-slim AS build

# 将工作目录设置为容器中的某个位置
WORKDIR /home/app

# 复制父项目的 pom.xml 文件和子模块的 pom.xml 文件及其源代码
COPY pom.xml .
COPY brionac-backend/pom.xml brionac-backend/
COPY brionac-backend/src brionac-backend/src/

# 构建应用
RUN mvn clean package -DskipTests

# Step 2: 创建一个轻量级的镜像来运行构建好的应用
FROM openjdk:11-jre-slim

# 设置工作目录
WORKDIR /app

# 从构建阶段复制构建好的 JAR 文件到工作目录
COPY --from=build /home/app/brionac-backend/target/brionac-backend-1.0-SNAPSHOT.jar .

# 指示 Docker 监听 9090 端口
EXPOSE 9090

# 指定容器启动时执行的命令
ENTRYPOINT ["java","-jar","brionac-backend-1.0-SNAPSHOT.jar"]
