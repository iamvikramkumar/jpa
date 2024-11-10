package com.vikram.JpaDemoEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//JPA WORKS WITH ENTITY
//In JPA (Java Persistence API)
//--> an entity represents a persistent object that can be stored in a database. 
// -->It is a class that is mapped to a database table, with each instance of the class corresponding to a row in the table

// Entity -> we have a class and table and in somewhere between we have an entity 
//JPA entities are managed by the EntityManager, which handles persisting, retrieving, updating, and deleting them from the database.

/*
@Entity: This annotation marks a class as a JPA entity.

@Table: This annotation specifies the name of the database table to which the entity is mapped.

@Id: This annotation marks the primary key field of the entity.

@GeneratedValue: This annotation specifies how the primary key value is generated.

@Column: This annotation maps an entity attribute to a database column.
*/


@Entity
public class Student {

	@Id
	private int id;
	private String name;
	private String tech;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", tech=" + tech + "]";
	}
	
}
