package com.mapping.JpaOneToOneAppWithJPQL;

import java.util.List;

import com.mapping.entity.Project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOneToOneApp");

		EntityManager em = emf.createEntityManager();

		/*
		 * em.getTransaction().begin();
		 * 
		 * Account a1 = new Account(123456, 25000.25, "savings"); Project p1 = new
		 * Project(100, "CMS", "Tarun"); Project p2 = new Project(200, "BMS", "Varun");
		 * Project p3 = new Project(300, "MMS", "Karun"); Project p4 = new Project(400,
		 * "JMS", "Charun");
		 * 
		 * List<Project> projectList = Arrays.asList(p1, p2, p3, p4);
		 * 
		 * Employ emp = new Employ(1001, "arun kumar", 45000.25); emp.setAccount(a1);
		 * emp.setProjects(projectList);
		 * 
		 * em.persist(emp);
		 * 
		 * em.getTransaction().commit();
		 * 
		 * System.out.println("employ details saved in DB");
		 */

		/*
		 * em.getTransaction().begin();
		 * 
		 * Account a2 = new Account(223456, 45000.25, "current"); Project p1 = new
		 * Project(500, "TTK", "Suhash"); Project p2 = new Project(600, "LLK",
		 * "Sushanth");
		 * 
		 * 
		 * List<Project> projectList = Arrays.asList(p1, p2);
		 * 
		 * Employ emp = new Employ(1002, "Surya", 75000.25); emp.setAccount(a2);
		 * emp.setProjects(projectList);
		 * 
		 * em.persist(emp);
		 * 
		 * em.getTransaction().commit();
		 * 
		 * System.out.println("employ details saved in DB");
		 */

//		TypedQuery<Project> typedQuery = em.createQuery("select p from Project p", Project.class);
//
//		List<Project> projectList = typedQuery.getResultList();
//
//		for (Project proj : projectList) {
//
//			System.out.println(proj);
//		}

//		TypedQuery<Project> typedQuery = em.createQuery("select p from Project p where p.name=:projName",
//				Project.class);
//
//		typedQuery.setParameter("projName", "TTK");
//
//		Project project = typedQuery.getSingleResult();
//
//		System.out.println(project);
		
//		TypedQuery<Project> typedQuery = em.createQuery("select p from Project p join Employ e on p member of e.projects where e.name=:empName", Project.class);
//
//		typedQuery.setParameter("empName", "Surya");
//		
//		List<Project> projList = typedQuery.getResultList();
//		
//		System.out.println("project is:" + projList.get(0) + " size is:" + projList.size());


		
		
		TypedQuery<Project> typedQuery = em.createQuery("select p from Project p join Employee e"
				+ " on p member of e.projects where e.name=:empName and p.name=:projName", Project.class);

		typedQuery.setParameter("empName", "Surya");
		typedQuery.setParameter("projName", "LLK");
		
		List<Project> projList = typedQuery.getResultList();
		
		System.out.println("project is:" + projList.get(0) + " size is:" + projList.size());

				
		em.close();
		emf.close();

	}
}