### **Add dependencies to build tool**
1. Spring Boot Starter Data JPA
2. PostgreSQL JDBC Driver

**Create a new Postgres database with psql.**

### login to postgres

`$ sudo -u postgres psql`

### create a new user to own the new database

`postgres=# CREATE USER <YOUR_USERNAME> WITH PASSWORD '<YOUR_PASSWORD>';`
`postgres=# CREATE USER shrikant WITH PASSWORD 'kale';`  
`CREATE ROLE`

### create a new database for our user

`postgres=# CREATE DATABASE ultimate_db OWNER shrikant;`
`CREATE DATABASE`

### list out databases

`postgres=# \l`

### **Connect Spring Boot to Postgres database. (application.properties)**
`spring.datasource.url=jdbc:postgresql://localhost:5432/<YOUR_DATABASE_NAME>`

`spring.datasource.username=<YOUR_USERNAME>`

`spring.datasource.password=<YOUR_PASSWORD>`

`spring.jpa.hibernate.ddl-auto=<create | create-drop | update | validate | none>`

`spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialec`