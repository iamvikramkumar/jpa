package com.mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

	@Id
	private long acntNo;
	private double balance;
	private String acntType;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(long acntNo, double balance, String acntType) {
		super();
		this.acntNo = acntNo;
		this.balance = balance;
		this.acntType = acntType;
	}

	public long getAcntNo() {
		return acntNo;
	}

	public void setAcntNo(long acntNo) {
		this.acntNo = acntNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAcntType() {
		return acntType;
	}

	public void setAcntType(String acntType) {
		this.acntType = acntType;
	}

	@Override
	public String toString() {
		return "Account [acntNo=" + acntNo + ", balance=" + balance + ", acntType=" + acntType + "]";
	}

}
