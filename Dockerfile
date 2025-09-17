# 1. Usar JDK 17 (ou superior) como base
FROM eclipse-temurin:17-jdk-jammy

# 2. Definir diretório de trabalho
WORKDIR /app

# 3. Copiar pom.xml e baixar dependências (camada de cache)
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

# 4. Copiar o código do projeto
COPY src ./src

# 5. Construir o projeto
RUN ./mvnw clean package -DskipTests

# 6. Definir porta que o container vai expor
EXPOSE 8080

# 7. Rodar a aplicação
ENTRYPOINT ["java","-jar","target/medrecords-0.0.1-SNAPSHOT.jar"]
