FROM eclipse-temurin:21-jdk

VOLUME /app

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "./app.jar"]