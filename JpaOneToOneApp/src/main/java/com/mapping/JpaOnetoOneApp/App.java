package com.mapping.JpaOnetoOneApp;

/**
 * Hello world!
 *
 */
import java.util.Arrays;
import java.util.List;

import com.mapping.entity.Account;
import com.mapping.entity.Employee;
import com.mapping.entity.Project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOneToOneApp");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Account a1 = new Account(123456, 25000.25, "savings");
		Project p1 = new Project(100, "CMS", "Tarun");
		Project p2 = new Project(200, "BMS", "Varun");
		Project p3 = new Project(300, "MMS", "Karun");
		Project p4 = new Project(400, "JMS", "Charun");

		List<Project> projectList = Arrays.asList(p1, p2, p3, p4);

		Employee emp = new Employee(1001, "arun kumar", 45000.25);
		emp.setAccount(a1);
		emp.setProjects(projectList);

		em.persist(emp);

		em.getTransaction().commit();

		System.out.println("employ details saved in DB");

		em.close();
		emf.close();

	}
}
