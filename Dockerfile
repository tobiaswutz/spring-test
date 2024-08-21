# Verwende ein leichtgewichtiges JDK-Image als Basis, das Java 19 enthält
FROM openjdk:19-jdk-slim

# Setze das Arbeitsverzeichnis im Container
WORKDIR /app

# Kopiere die Gradle Wrapper-Dateien und die Projektdateien
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle .
COPY settings.gradle .

# Kopiere den Rest der Anwendung
COPY src/ src/

# Installiere die Abhängigkeiten und baue die Anwendung
RUN ./gradlew clean build -x test

# Überprüfe, ob die JAR-Datei existiert
RUN ls build/libs/

# Exponiere den Standardport, den Spring Boot verwendet (normalerweise 8080)
EXPOSE 8080

# Führe die erzeugte JAR-Datei aus
CMD ["java", "-jar", "build/libs/spring-test-0.0.1-SNAPSHOT.jar"]
