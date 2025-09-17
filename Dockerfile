# 1. Usar imagem oficial do Maven para build
FROM maven:3.9.5-eclipse-temurin-17 AS build

# 2. Definir diretório de trabalho
WORKDIR /app

# 3. Copiar arquivos do Maven para cache de dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 4. Copiar todo o código-fonte
COPY src ./src

# 5. Build do JAR
RUN mvn package -DskipTests

# 6. Usar imagem mais leve para rodar a aplicação
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# 7. Copiar o JAR gerado do stage de build
COPY --from=build /app/target/*.jar app.jar

# 8. Definir variáveis de ambiente padrão
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db.ulykguzkhtqzyctbzcty.supabase.co:5432/postgres?sslmode=require
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=Senha@123
ENV PORT=8080

# 9. Expor a porta que o Render vai usar
EXPOSE 8080

# 10. Comando para rodar o Spring Boot
ENTRYPOINT ["java","-jar","app.jar"]
