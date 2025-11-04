FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/EduPlatform-1.0.jar /app/app.jar
CMD java -jar /app/app.jar
