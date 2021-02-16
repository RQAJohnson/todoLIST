# Getting Started
Coverage: 74%
# Project Title: To Do List Web Application
**Project Description:** A To Do List Web Application, which allows a user to input data to create, read, edit and delete an entry.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine 
for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
See Admin folder for ERD,UML and Sonarqube diagrams.

### Prerequisites
What things you need to install the software and how to install them

Spring Tool Suite, 
Java, 
Postman, 
Sonarqube,
Selenium, 
Maven.

### Installing
A step by step series of examples that tell you how to get a development env running

Spring Tool Suite: https://spring.io/tools#suite-three

Sonarqube: https://www.sonarqube.org/downloads/ (to close out of Sonarqube ctrl + c)

Selenium: https://www.selenium.dev/selenium-ide/ (A small icon should appear in the top right corner of your 
browser window. After clicking on the icon a pop up should appear where you can begin recording your web page,
after providing the necessary details 'title' of project and 'URL' to test.

Maven: https://maven.apache.org/download.cgi

Postman: https://www.postman.com/downloads/

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


## Running the tests
How they work:
### Unit & Integration Tests 

**Junit, Mockito** - Junit is an opened source testing framework used to test units of code within Java. 
It is used to enusre that each line of code within the application is performing as expected. Mockito is used,
to efficiently write out the unit tests by mocking the behaviour of an interface so that dummy functionality 
can be used.

Within Spring in order to run this test you will need to begin by annotating your test class with **@SpringBootTest**,
the **MockBean** annotation will allow you to create a mock instance of the class you wish, where you will be able to mock 
the components which you are not testing.

### Automated Tests 
**Selenium** - Selenium is an opened source automated testing framework for web applications.It can be used on several browsers
and supported by a variety of languages. 
Using Selenium IDE will allow you to record and playback interactions from your desired site by 

## Deployment
Add additional notes about how to deploy this on a live system

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning
We use [SemVer](http://semver.org/) for versioning.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/#build-image)
* [Validation](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-validation)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-developing-web-applications)


## Authors
* **Rianna Johnson** - *Initial work* - [Rianna Johnson](https://github.com/RQAJohnson)
## License
This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 
*For help in [Choosing a license](https://choosealicense.com/)*
## Acknowledgments
* Hat tip to anyone whose code was used
* Inspiration
* etc
