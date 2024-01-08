# Video management application.
The course of work on the various functionalities can be viewed in individual branches.

To run the application, you need to:
* Create a resources/application.yml(or - properties) file in the video-management-container module with the specified and updated values for omdb.api.key and for the database.
```
omdb:
  api:
    key: omdb_key
    url: https://www.omdbapi.com

spring:
  liquibase:
    change-log: classpath:db/changelog/db.changelog-master.xml

  datasource:
    url: jdbc:h2:mem:testdb
    driverClassName: org.h2.Driver
    username: db_user
    password: SuperSecurePassword
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
  h2:
    console:
      enabled: true
```
* Run com.video.management.container.VideoManagementMain or execute mvn clean install in video-management and run the container .jar file.
* The application provides API documentation located at: http://localhost:8080/swagger-ui/index.html
* The application has unit and integration tests. Unit tests are located in the service, application, and dataaccess modules. Integration tests are in the container module.
