# lucky_draw_gaming_service

This is a sample RESTful project which provides a service for storing, updating,
retrieving and deleting Person entities.
This implementation focuses on the following aspects:
* API implementation with API first approach - Swagger
* Logging with Aspects Oriented Programming fundamentals
* Custom Error Handling using Controller Advices
* Use of Mappers for POJOs e.g. MapStruct
* Usage of In-memory database - H2
* Implementation of Lombok

## How to build the application

 to build the project and create the executable jar:

* Run the below command to build the project which would generate the required Controllers, POJOs and mapper classes.
```bash
mvn clean install
````
    
## How to access the APIs

APIs:-
1./createEvent
2./getNextEvent
3./getWinners
4./addUser
5./generateTicket
6./getTickets
7./participate