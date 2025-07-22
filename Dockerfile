FROM eclipse-temurin:21-jre
COPY target/vaadin-playwright-junit.jar vaadin-playwright-junit.jar
EXPOSE 40301
ENTRYPOINT ["java", "-jar", "/vaadin-playwright-junit.jar"]