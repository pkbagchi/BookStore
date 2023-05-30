FROM maven:3.8.2-jdk-8

WORKDIR /BookStore
COPY . .
COPY pom.xml .
RUN mvn clean install

CMD mvn spring-boot:run
