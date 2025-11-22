FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copy Maven wrapper and config first (better caching)
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Ensure mvnw has execution permissions
RUN chmod +x mvnw

# Download dependencies (improves caching)
RUN ./mvnw dependency:go-offline

# Now copy the project source
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Run the app
CMD ["java", "-jar", "target/forgetmenot-backend-0.0.1-SNAPSHOT.jar"]