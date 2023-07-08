FROM azul/zulu-openjdk:17 as builder

WORKDIR /app

COPY ./target/tech-challenge-0.0.1-SNAPSHOT.war /app/tech-challenge.jar

RUN java -techchallange01-0.0.1-SNAPSHOT.war

FROM azul/zulu-openjdk:17

WORKDIR /app

COPY --from=builder /app/dependencies/ ./
COPY --from=builder /app/spring-boot-loader/ ./
COPY --from=builder /app/snapshot-dependencies/ ./
COPY --from=builder /app/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
