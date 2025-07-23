# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application's JAR file into the container
# Replace "service1.jar" or "service2.jar" with the respective JAR file names
COPY target/service1.jar app.jar

# Expose the application's port (e.g., Service1: 8081, Service2: 8082)
EXPOSE 9001

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
