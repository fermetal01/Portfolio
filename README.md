# Portfolio Web Project

This project is a basic protfolio application that connects with Mysql DB and Twitter accounts to retrieve and present data.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Clone the repository with:

```
git clone https://github.com/fermetal01/Portfolio.git
```
And run:
```
mvn clean install
```


### Prerequisites

What things you need to install the software and how to install them
- Java 11
- Maven

### Misc

![Jon](https://user-images.githubusercontent.com/17125357/79713707-3be73400-8294-11ea-87fb-a562e4c45908.PNG)


## Deployment

run `mvn clean install` and then `mvn spring-boot:run` to star the application in default `localhost:8080`

## RestAPI testing

Run the application and go to `http://localhost:8080/swagger-ui.html` to check and interact with all the endpoints available to retreive and manipulate data

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Framework](https://spring.io/) - Base framework for MVC pattern and Spring Boot
* [Thymeleaf](https://www.thymeleaf.org/) - Used for presentation layer
* [Lombok](https://projectlombok.org/) - Used to avoid boilerplate code at entity level
* [Model Mapper](http://modelmapper.org/) - Used to avoid boilerplate code mapping the entity to DTOs
* [Twitter4j](http://twitter4j.org/en/) - Used to connect with Twitter API and retreive data
* [MySql](https://www.mysql.com/) - Used for connect with DB
* [Log4j](https://logging.apache.org/log4j/2.x/) - Used for logging
* [Mockito](https://site.mockito.org/) - Used for testing mocks
* [JUnit](https://junit.org/junit5/) - Used for testing
* [Swagger2](https://junit.org/junit5/) - Used for presenting RestAPI data

## Development Time

This project was developed in 4 hours 30 minutes.

## Authors

* **Brayan Perez** - *Initial work* - [fermetal01](https://github.com/fermetal01)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
