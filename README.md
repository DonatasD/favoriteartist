# Favorite Artist
Interview assignment favorite artist

# Initial data
Two users with id 1 and 2 are created on application start.

User 1 has a favorite artist assigned.

# Caching
Caching is done using spring caching. Cache is cleared daily. Caching should minize calls to
 ITune services, however 100 request per hour limit most likely will be reached, due the type of
  request are executed (i.e. searching).
  
# API documentation
To generate run
```shell script
./mvnw package
```
API documentation can be found in target/generated-docs/index.html

# Database
Database can be accessed via localhost:8080/h2-console using connection url:

jdbc:h2:${pathToProject}/db/testdb;AUTO_SERVER=TRUE

N.B. replace ${pathToProject} with actual system path.

# Start application
```shell script
./mvnw spring-boot:run
```

# Testing
Both integrated and unit testing.

Run with:
```shell script
./mvnw test
```
