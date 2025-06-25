FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . /app

RUN ./mvnw clean package

# Use shell form so wildcard works
CMD java -jar target/*.jar      