# Nutze ein offizielles Java-Laufzeitumgebungs-Image
FROM openjdk:17-jdk-slim

# Setze das Arbeitsverzeichnis im Container
WORKDIR /app

# Kopiere die JAR-Datei ins Arbeitsverzeichnis
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponiere den Port, auf dem die Anwendung läuft
EXPOSE 8080

# Startbefehl für die Anwendung
ENTRYPOINT ["java", "-jar", "app.jar"]
