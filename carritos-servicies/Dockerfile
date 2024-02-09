FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/carritos-servicies-0.0.1.jar
COPY ${JAR_FILE} app_carritos.jar
ENTRYPOINT ["java", "-jar", "app_carritos.jar"]