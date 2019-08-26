# spring-data-redis-poc
Simple Spring Data Redis POC 

# Redis

This POC has a docker-compose to start a localhost Redis via Docker.
To start it, access redis-docker folder and run:

```bash
docker-compose up
```

# POC Application

Application is started via Gradle. 
To start it, access spring-data-redis-poc folder and run:
 
```bash
gradle bootRun
```

Application uses Springfox to give you a web interface to test.
After start application, access http://localhost:8080/swagger-ui.html in your browser

# Learning More
* https://spring.io/projects/spring-data
* https://spring.io/projects/spring-data-jpa
* https://spring.io/projects/spring-data-redis
* https://spring.io/projects/spring-data-rest

