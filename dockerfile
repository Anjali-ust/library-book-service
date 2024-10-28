FROM openjdk:17-oracle
COPY ./target/Book-service-0.0.1-SNAPSHOT.jar Book-service.jar
CMD ["java","-jar","Book-service.jar"]