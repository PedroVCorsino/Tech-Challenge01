FROM azul/zulu-openjdk-alpine:17 as builder

WORKDIR /app

COPY ./target/techchallange01-0.0.1-SNAPSHOT.war /app/tech-challenge.war

FROM azul/zulu-openjdk-alpine:17

WORKDIR /app

COPY --from=builder /app/tech-challenge.war /app/tech-challenge.war

ENTRYPOINT ["java", "-jar", "/app/tech-challenge.war"]
