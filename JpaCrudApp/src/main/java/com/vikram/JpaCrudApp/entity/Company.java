package com.vikram.JpaCrudApp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Use IDENTITY strategy for PostgreSQL
    @Column(name = "c_regno")  // Map regNo to the actual column name in the database
    private int regNo;

    private String name;

    private LocalDate establishedDate;

    private double capitalAmount;

    public Company() {
        // Default constructor
    }

    public Company(String name, LocalDate establishedDate, double capitalAmount) {
        this.name = name;
        this.establishedDate = establishedDate;
        this.capitalAmount = capitalAmount;
    }


    
	@Override
    public String toString() {
        return "Company [regNo=" + regNo + ", name=" + name + ", establishedDate=" + establishedDate
                + ", capitalAmount=" + capitalAmount + "]";
    }

	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(LocalDate establishedDate) {
		this.establishedDate = establishedDate;
	}

	public double getCapitalAmount() {
		return capitalAmount;
	}

	public void setCapitalAmount(double capitalAmount) {
		this.capitalAmount = capitalAmount;
	}
}
