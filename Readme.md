## Summary
This is a Java base-project, that means I created this as a base for something bigger. Here you can find:
* A rest API
* A mySql connection
* Unit tests
* Dependency injection (Spring)
* JPA transactions
* A very simple docker file
* Flyway

## APIs:
* status: GET <url>/api/ping
* get all: GET <url>/api/products
* read: GET <url>/api/products/{id}
* create: POST <url>/api/products

## How to run the project with docker:
* Download docker
* Download only the docker file: Test/Dockerfile
* and run:
```
docker build -t imagen .
docker run -p 8080:8080 imagen
```
