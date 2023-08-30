# Prueba Técnica Luis

This is a Java / Maven / SpringBoot test microservice that provides an endpoint to look up the applicable pricing rate according to certain input parameters.

Java Version = 17
Maven Version = 3.9.2
Spring Boot Version = 3.1.3

## How to Run 

This application is packaged as a war which has Tomcat embedded. You run it using the ```java -jar``` command.

* Clone this repository
* Make sure you are using JDK 17 and Maven 3.x
* You can build the project and run the tests by running ```cd prueba_tecnica_luis/code/boot``` and then  ```mvn clean package```
* Once successfully built, you can run the service by one of these three methods:
```
    java -jar target/prueba-boot-0.1.0-SNAPSHOT.jar
 or
    mvn spring-boot:run
 or 
    mvn spring-boot:run -DskipTests (to run without tests)
```
## Test Application

In the root of the project you can find a postman collection (Inditex Prueba.postman_collection.json) in which you can find the requests with the test cases



