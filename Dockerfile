FROM adoptopenjdk:17-jdk-hotspot as builder

WORKDIR /app

COPY ./target/tech-challenge-0.0.1-SNAPSHOT.war /app/tech-challenge.jar

RUN java -techchallange01-0.0.1-SNAPSHOT.war

FROM adoptopenjdk:17-jdk-hotspot

WORKDIR /app

COPY --from=builder /app/dependencies/ ./
COPY --from=builder /app/spring-boot-loader/ ./
COPY --from=builder /app/snapshot-dependencies/ ./
COPY --from=builder /app/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]