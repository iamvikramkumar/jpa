# JPA Setup with Hibernate

## Introduction to JPA  
The **Java Persistence API (JPA)** is a specification for managing relational data in Java applications. JPA provides a framework for mapping Java objects to relational database tables, enabling seamless interaction with databases using standard Java objects.

### Why Use JPA?  
- **Object-Relational Mapping (ORM):** Simplifies data interaction by mapping Java objects to database tables.
- **Database Independence:** Write database-agnostic code; switch between databases with minimal configuration changes.
- **Reduce Boilerplate Code:** Eliminates repetitive SQL and JDBC code by providing high-level object-oriented APIs.
- **Caching Support:** Improves performance through first and second-level caching.
- **Standardized API:** Works consistently across different JPA providers (e.g., Hibernate, EclipseLink).

### Facts About JPA  
1. **JPA is not an implementation**; it’s a specification.  
2. **Hibernate** is one of the most popular JPA implementations.  
3. JPA works with annotations to define the relationship between Java objects and database entities.  
4. It supports **query languages** like JPQL (Java Persistence Query Language) for advanced queries.  
5. JPA provides a mechanism to manage the lifecycle of entities and handle transactions effectively.

---

## Prerequisites  
Before setting up JPA with Hibernate, ensure the following tools and technologies are available:  
- Java Development Kit (JDK 8+).  
- Maven or Gradle as a build tool.  
- A relational database (e.g., MySQL, PostgreSQL, H2).  
- An IDE like IntelliJ IDEA, Eclipse, or VS Code.  

---

## Steps to Set Up JPA with Hibernate  

### 1. Add Dependencies  
Include the following dependencies in your `pom.xml` (for Maven):  

```xml
<dependencies>
    <!-- JPA API -->
    <dependency>
        <groupId>jakarta.persistence</groupId>
        <artifactId>jakarta.persistence-api</artifactId>
        <version>3.1.0</version>
    </dependency>

    <!-- Hibernate Core -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.3.1.Final</version>
    </dependency>

    <!-- H2 Database (or any preferred DB) -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <version>2.1.214</version>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

### 2. Configure `persistence.xml`  
Create a `persistence.xml` file under `src/main/resources/META-INF` for JPA configuration:  

```xml
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             version="3.0">
    <persistence-unit name="example-unit">
        <class>com.example.entity.User</class>
        <properties>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:h2:mem:testdb"/>
            <property name="jakarta.persistence.jdbc.user" value="sa"/>
            <property name="jakarta.persistence.jdbc.password" value=""/>
            <property name="jakarta.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
        </properties>
    </persistence-unit>
</persistence>
```

### 3. Create an Entity  
Define an entity class to map to a database table:  

```java
package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    // Getters and Setters
}
```

### 4. Use EntityManager  
Use JPA’s `EntityManager` to perform CRUD operations:

```java
package com.example;

import com.example.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        em.persist(user);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
```

---

## Running the Application  
1. Compile the project using Maven or your IDE.  
2. Run the `Main` class.  
3. Check the console logs to see SQL statements and data manipulation.  

---

## Conclusion  
Setting up JPA with Hibernate simplifies database operations, enabling developers to focus more on business logic than boilerplate code. It ensures scalability and flexibility while interacting with different relational databases.  


---

## IMPORTANT NOTE
In JPA, we do not use SessionFactory; it is specific to Hibernate. Here's a breakdown:

### JPA (Java Persistence API):
- JPA uses the `EntityManagerFactory` and `EntityManager` for managing persistence.
- EntityManagerFactory is similar to Hibernate's SessionFactory.
- EntityManager is equivalent to Hibernate's Session.
  
### Hibernate (as a JPA provider or standalone):
- Hibernate, when used standalone, uses SessionFactory to create and manage Session instances.
- When Hibernate is used as a JPA provider, it internally manages EntityManager and EntityManagerFactory but you, as a developer, interact with the standard JPA interfaces.

### Key Differences:
JPA: `EntityManagerFactory` → `EntityManager`
Hibernate: `SessionFactory` → `Session`

