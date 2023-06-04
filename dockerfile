FROM openjdk:8
WORKDIR /app

COPY target/microclasse.jar /app
CMD ["java","-jar","microclasse.jar"]