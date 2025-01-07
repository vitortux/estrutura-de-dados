FROM maven:3-eclipse-temurin-23

WORKDIR /app

COPY pom.xml /app/
COPY src /app/src

CMD ["mvn", "test"]