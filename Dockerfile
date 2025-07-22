FROM eclipse-temurin:21-jre
COPY target/vaadin-playwright-junit.jar app.jar
EXPOSE 40301
ENTRYPOINT ["java", "-jar", "/app.jar"]