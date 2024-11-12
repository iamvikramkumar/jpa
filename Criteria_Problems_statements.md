# JPA Criteria API Queries

1. Create a JPA Criteria API query to retrieve all records from the `Employee` entity, which contains fields `id`, `name`, `salary`, and `department`. Use the `CriteriaBuilder` to construct this query and execute it in Hibernate to get the list of employees.
 

2. Write a Criteria API query to fetch all employees whose salary is greater than 50,000. Use predicates to apply this condition and return a list of matching employees.
   

3. Using the `Employee` entity, create a Criteria API query that retrieves all employees and sorts them by `salary` in descending order. Display the sorted list of employees.

4. Given two entities, `Department` (id, name) and `Employee` (id, name, salary, department), where `Employee` has a many-to-one relationship with `Department`, write a Criteria API query to fetch all employees along with their department names. Use a join between `Employee` and `Department`.


5.  Write a Criteria API query to find the average salary of employees in each department. Group the results by department and return the department name along with the average salary.

6. Create a Criteria API query that retrieves all employees who have a salary higher than the average salary of all employees. Use a subquery to calculate the average salary.

7.Write a utility method using Criteria API that can accept a list of filters and dynamically build a query to fetch employees based on various conditions (e.g., salary range, department, or name). The method should support multiple conditions being added or removed at runtime.
  


