package com.vikram.JpaCrudApp;

import java.time.LocalDate;

import com.vikram.JpaCrudApp.entity.Company;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClientApp {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	static {

		emf = Persistence.createEntityManagerFactory("JpaCrudApp");
		em = emf.createEntityManager();

	}

	public static void addCompany(Company company) {

		em.getTransaction().begin();

		em.persist(company);
		em.getTransaction().commit();
		System.out.println("company saved in db");
	}

	public static void closeSessionWithDB() {
		em.close();
		emf.close();
	}

	public static void main(String[] args) {

		// add company details
		Company company = new Company("CpaG", LocalDate.of(1980, 12, 4), 45000.25);
		Company company2 = new Company("CTS", LocalDate.of(1982, 10, 15), 55000.25);
		Company company3 = new Company("ACC", LocalDate.of(1983, 10, 15), 65000.25);
		Company company4 = new Company("Wipro", LocalDate.of(1990, 11, 1), 85000.25);

		addCompany(company);
		addCompany(company2);
		addCompany(company3);
		addCompany(company4);

		closeSessionWithDB();
	}
}
