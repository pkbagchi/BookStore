FROM maven:3.8.2-jdk-8

WORKDIR /BookStore
COPY . .
RUN mvn clean install -DskipTests=true -U
CMD mvn spring-boot:run
