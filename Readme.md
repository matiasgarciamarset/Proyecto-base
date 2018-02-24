Este proyecto fue desarrollado para servir como base en otros proyectos. El mismo fue logrado gracias a las siguientes dos paginas que brindaron información base para la configuración de spring y hibernate respectivamente.
Spring rest full: https://dzone.com/articles/build-rest-web-service-using-spring
Hibernate: https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-maven-example/

## El proyecto fue desarrollado con:
* Java 1.8
* Maven
* Eclipse (con plugin testNG)
* Mysql (5.7.21 MySQL Community Server)

El mismo cuenta con:
* Una API rest (Spring)
* Conexión con mySql (Hibernate)
* Tests unitarios (JUnit, TestNG, Mockito)
* Inyección de dependencias (Spring)
* Una cache manual (Implementada por mi)

## Instrucciones para correr proyecto con docker:
* Descargar docker
* Descargar solo el archivo de docker: MLRequest/Dockerfile
* En la misma ruta del archivo Dockerfile ejecutar:
```
docker build -t imagen .
docker run -p 8080:8080 imagen
```
## Endpoints para utilizar:
* http://localhost:8080/api/test/create
* http://localhost:8080/api/test/count
* http://localhost:8080/api/test/ping