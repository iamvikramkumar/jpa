package com.mapping.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Project {

	@Id
	private int code;
	private String name;
	private String manager;

	public Project(int code, String name, String manager) {
		super();
		this.code = code;
		this.name = name;
		this.manager = manager;
	}

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Project [code=" + code + ", name=" + name + ", manager=" + manager + "]";
	}

}
