package fr.finance.bank.BankApp.model;

import java.util.Collection;

public class Person {
	
	private int id ,age;
	private String name,firstname, address,phone;
	private Collection <Accounts> accountList;
	
	
	
	public Person() {
		super();
	}


	public Person(int id,String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	   * Getters and setters
	   */

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Collection<Accounts> getAccountList() {
		return accountList;
	}


	public void setAccountList(Collection<Accounts> accountList) {
		this.accountList = accountList;
	}
	
 
	
}
