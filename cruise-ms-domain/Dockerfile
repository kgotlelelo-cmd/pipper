FROM maven:3.8.2-jdk-11-openj9 AS builder
WORKDIR /app
COPY ./pom.xml .
RUN mvn dependency:resolve
COPY ./src ./src
RUN mvn install -DskipTests
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../../target/*.jar)

FROM adoptopenjdk/openjdk11-openj9:x86_64-alpine-jre-11.0.12_7_openj9-0.27.0
ENV DEPENDENCY=/app/build/dependency
RUN addgroup -S spring && adduser -S cruise-ms-domain-service -G spring
WORKDIR /cruise-ms-domain-service
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib ./app/lib
COPY --from=builder ${DEPENDENCY}/META-INF ./app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes ./app
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.example.cruisemsdomain.CruiseMsDomainApplication"]
