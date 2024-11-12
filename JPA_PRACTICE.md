# JPA Application with CRUD and Advanced Queries

## 1. Develop an Application to Perform the Following Activities

### a) Create a Product Entity Class  
Define a `Product` entity class with the following attributes:
- **id**: Unique identifier for the product.
- **name**: Name of the product.
- **price**: Price of the product.
- **expiryDate**: Expiry date of the product.

### b) Perform CRUD Operations  
Implement Create, Read, Update, and Delete (CRUD) operations for the `Product` entity.

---

## 2. Implement Entity Relationship for Book and Author

### Entity Relationship Diagram  
Below is the entity relationship diagram between `Book` and `Author`:


![image](https://github.com/user-attachments/assets/a155577b-cc19-447d-830a-6d748bef8a5c)

### Steps to Implement  
1. Identify the correct association (e.g., **One-to-Many** or **Many-to-Many**) between `Book` and `Author`.
2. Create the necessary entity classes and define the relationships using JPA annotations.

---

## Working with JPA Queries

### Queries to Implement  
Write separate methods for each of the following queries:

#### a) Query All Books in the Database  
Retrieve and display all books stored in the database.

#### b) Query All Books Written by a Given Author Name  
Find all books authored by a specific author, identified by their name.

#### c) List All Books within a Given Price Range  
Retrieve books where the price is between a specified range (e.g., between Rs. 500 and Rs. 1000).

#### d) List the Author Name for a Given Book ID  
Find the author associated with a specific book ID.

---

## Conclusion  
This project demonstrates how to use JPA for defining entity relationships and performing advanced database queries. By following the outlined steps, you can build a robust application for managing `Product` and `Book-Author` entities efficiently.
