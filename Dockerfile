# Verwende ein leichtgewichtiges JDK-Image als Basis
FROM openjdk:19-jdk-slim

# Setze das Arbeitsverzeichnis im Container
WORKDIR /app

# Kopiere die gesamte Anwendung in das Arbeitsverzeichnis des Containers
COPY . .

# Baue die Anwendung mit Gradle
RUN ./gradlew clean build -x check -x test

# Exponiere den Standardport, den Spring Boot verwendet (normalerweise 8080)
EXPOSE 8080

# Führe die erzeugte JAR-Datei aus
CMD ["java", "-jar", "build/libs/myapp-0.0.1-SNAPSHOT.jar"]
