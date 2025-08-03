FROM eclipse-temurin:17 as builder

COPY src/ /src/
COPY settings.gradle .
COPY build.gradle .
COPY gradlew .
COPY ./gradle ./gradle

RUN ./gradlew build -x test

FROM builder as runner

COPY --from=builder /build/libs/*.jar /app.jar
COPY --from=builder /src/main/resources/application.properties /application.properties
COPY --from=builder /src/main/resources/application-prod.properties /application-prod.properties

EXPOSE 80

ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.profiles.active=prod"]
