# Práctica 6: Testing de una aplicación de Spring Boot

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/javierjg001/PAT-Practicas-Testing)

## Objetivo de la práctica

Dado un desarrollo de Spring Boot, es necesario anhadir tests a las siguientes clases:

- DNI & Telefono (Unit Tests) (Cada clase tiene un metodo y varias casuisticas para probar)
- ProcessController (E2E Tests) (2 endpoints)

```
mvn clean spring-boot:run

curl -v -X POST http://localhost:8080/api/v1/process-step1-legacy \
   -H "Content-Type: application/x-www-form-urlencoded" \
   -d "fullName=Juan%20Antonio%20Brena%20Moral&dni=12345678Z&telefono=%2B34%20600903434"

curl -v -X POST http://localhost:8080/api/v1/process-step1 \
   -H 'Content-Type: application/json' \
   -d '{"fullName":"Juan Antonio Brena Moral","dni":"12345678Z", "telefono":"+34 600903434"}'
```

## References

- https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/boot-features-testing.html
- https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/web/client/TestRestTemplate.html
- https://www.urlencoder.org/
