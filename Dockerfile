# Use a base image with OpenJDK 17 pre-installed
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY ./target/Todo-0.0.1-SNAPSHOT.jar /app/Todo-0.0.1-SNAPSHOT.jar


# Define the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "Todo-0.0.1-SNAPSHOT.jar"]
