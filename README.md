
REWARDS-PROGRAM   ->  Spring Boot Web Application

Accessing API :

        To view total rewards use - GET -  http://localhost:8080/rewards/total
        To view Monthly rewards use - GET-  http://localhost:8080/rewards/monthly


Accessing the data: Data is maintained in h2 and can be accessed through - http://localhost:8080/h2-console
Currently set to default properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

Data Insertion : rewards-program\src\main\resources\data.sql



