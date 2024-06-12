FROM openjdk:11-jdk-buster

ENV DATABASE_URL="jdbc:mysql://mysql_microservice:3306/microservice_db"
ENV DATABASE_USERNAME="root"
ENV DATABASE_PASSWORD="root"

RUN mkdir /app

# Set the working directory in the container
WORKDIR /app

COPY ./build/libs/resources-infra-1.0.0-SNAPSHOT.jar /app/spring-boot-application.jar

EXPOSE 9000

ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]
