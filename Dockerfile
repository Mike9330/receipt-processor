FROM openjdk:17-jdk-slim

WORKDIR /app

COPY gradlew .
COPY gradle/ gradle/
COPY . .

RUN ./gradlew build --no-daemon

RUN ls -1 build/libs/*.jar

EXPOSE 8080

SHELL ["sh", "-c"]

CMD ["sh", "-c", "java -jar $(find build/libs -name '*.jar' -type f -print -quit)"]