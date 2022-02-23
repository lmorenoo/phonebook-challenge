# phonebook-challenge
Phonebook challenge

## Java version:
AdoptOpenJDK 11 with the vendor JVM OpenJ9 https://adoptopenjdk.net/

## Intellij pluglins
- Lombok
- PlantUML

## Unit test
```
mvn test
```

## SWAGGER

http://localhost:8887/api/swagger-ui.html

## Back-End

	The Back-End was build using Java 11, Spring-Boot.

	Download dependencies

		- mvn install

	Run app with spring-boot

		- mvn spring-boot:run -> the app will be deployed in http://localhost:8887
	
	To test the API you can run:

		- POST http://localhost:8887/api/users -> To create an user
		- GET http://localhost:8887/api/users -> To get all users
		- GET http://localhost:8887/api/users?searchValue=value -> To get all users by filter
        

