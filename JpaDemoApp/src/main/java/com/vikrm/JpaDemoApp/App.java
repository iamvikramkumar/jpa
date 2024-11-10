package com.vikrm.JpaDemoApp;

import com.vikram.JpaDemoEntity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
        // IF you want to create object of entity manager you need entity manager factory --> Entity manager factory implemented by jpa and hibernate
       
        // How can be create an object of entity manager factory?
        // For create an object of Entity manager factory we have class Name PERSISTENCE class with method name CREATE ENTITY MANAGER FACTORY("and here we have to pass ")
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoApp");
        EntityManager em = emf.createEntityManager();

        
        Student s2 = em.find(Student.class, 2);
        
        if (s2 != null) {
            System.out.println(s2);  // Print student details
        } else {
            System.out.println("No student found with ID 2");
        }
        
        
//        em.getTransaction().begin();
//
//		Student s1 = new Student(1, "VarunKumar", "CSE");
//
//		em.persist(s1);
//
//		System.out.println("student details saved in DB");
//
//		em.getTransaction().commit();

        
        em.close();
        emf.close();
        
    }
}
