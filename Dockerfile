# 1. Usar uma imagem com Maven + JDK 17
FROM maven:3.9.2-eclipse-temurin-17 AS build

# 2. Criar diretório de trabalho
WORKDIR /app

# 3. Copiar pom.xml e baixar dependências (cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 4. Copiar o código do projeto
COPY src ./src

# 5. Build do JAR
RUN mvn clean package -DskipTests

# 6. Criar imagem final mais leve
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/medrecords-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
