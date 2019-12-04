FROM openjdk:11.0.5-jre

COPY microservice.jar microservice.jar

EXPOSE 8080

RUN chmod +x microservice.jar

CMD java -jar "microservice.jar"