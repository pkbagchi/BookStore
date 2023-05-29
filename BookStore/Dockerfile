FROM maven:3.8.2-jdk-slim

WORKDIR /BookStore
COPY . .
RUN mvn clean package -pl app02:app02 -am -DskipTests -e -X
CMD mvn spring-boot:run
