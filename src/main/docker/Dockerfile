FROM adoptopenjdk:8-jre-hotspot
EXPOSE 8080
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]