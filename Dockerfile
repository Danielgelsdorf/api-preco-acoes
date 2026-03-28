FROM eclipse-temurin:17-jre-alpine

# Cria um usuário sem privilégios de root (Boa prática de segurança/IAM)
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "/app/app.jar"]