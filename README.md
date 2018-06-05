## About the application
The application is Rest API that currently serves for:
* Returns information where and if two objects a square and a line intersect.
* Retrieves information about how many requests are currently being processed.

## Architectural overview of the application
The application is implemented based on Java Spring Boot framework as Rest API. 

It currently has two endpoints:
* POST /squareAndLineInters for calculating a single intersection;
* GET /squareAndLineInters for retrieving a list of calculations. 

The main Java libraries used for implementation:
* Spring framework libraries
* H2 database libraries
* Java persitence libraries

## Instructions on how to launch the application
* Execute command 'mvn install' from the project's main folder for building the application;
* Execute the command 'java -jar target/geoshapesintersections-0.0.1.jar' for running the application;
* Initiate intersect cacucaltion by passing the objects coordinates by the endpoint POST http://localhost:8083/squareAndLineInters  ;
* Retrieve a list of calculations by the endpoint GET http://localhost:8083/squareAndLineInters ; 
for the GET call should be passed request headers username='username' and password='pasword' ;

An example jsons could be foun at project's folder src\test\resources
