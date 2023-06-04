FROM openjdk:8
WORKDIR /app
EXPOSE 9001
COPY target/microclasse.jar /app
CMD ["java","-jar","microclasse.jar"]