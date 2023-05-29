FROM maven:3.8.2-jdk-8

WORKDIR /BookStore
COPY . .
COPY pom.xml .
RUN mvn clean package  -Dmaven.test.skip

CMD mvn spring-boot:run
