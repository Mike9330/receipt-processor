FROM openjdk:17-jdk-slim

COPY gradlew .
COPY gradle/ gradle/
COPY . .

RUN ./gradlew clean

RUN ./gradlew build

RUN ./gradlew bootJar

RUN ls -1 build/libs/*.jar

EXPOSE 8080

SHELL ["sh", "-c"]

CMD ["sh", "-c", "java -jar $(find build/libs -name '*.jar' -type f -print -quit)"]