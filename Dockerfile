# Usa a imagem do Java 17 como base
FROM azul/zulu-openjdk:17 as builder

# Cria o diretório app dentro do contêiner
WORKDIR /app

# Copia o arquivo .war para o contêiner
COPY ./target/techchallange01-0.0.1-SNAPSHOT.war /app/tech-challenge.war

# Multi-stage build: segunda etapa
FROM azul/zulu-openjdk:17

# Cria o diretório app dentro do contêiner
WORKDIR /app

# Copia o arquivo .war da primeira etapa para a segunda etapa
COPY --from=builder /app/tech-challenge.war /app/tech-challenge.war

# Define o ponto de entrada para a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/tech-challenge.war"]
