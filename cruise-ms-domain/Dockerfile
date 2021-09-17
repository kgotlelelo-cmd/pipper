FROM openjdk:11

ARG JAR_FILE=target/*.jar

RUN mkdir -p /domain/app/

COPY ${JAR_FILE} /domain/app/

WORKDIR /domain/app/

CMD ["java", "-jar", "cruise-ms-domain-0.0.1-SNAPSHOT.jar"]