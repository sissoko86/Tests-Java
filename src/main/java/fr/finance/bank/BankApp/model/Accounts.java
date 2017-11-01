/**
 * Bean Accounts
 */
package fr.finance.bank.BankApp.model;

import java.util.Date;

public  class Accounts {
    private String codeAccount;
	private Date dateCreation;
	private int balance;
	private Person person;
	
	/**
	 * Constructors
	 */
	public Accounts() {
		super();
	}
	
	
	public Accounts(String codeAccount, Date dateCreation, int balance) {
		super();
		this.codeAccount = codeAccount;
		this.dateCreation = dateCreation;
		this.balance = balance;	
	}


	/**
	 * 
	 * Getters and Setters
	 */
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	

	public String getCodeAccount() {
		return codeAccount;
	}


	public void setCodeAccount(String codeAccount) {
		this.codeAccount = codeAccount;
	}
	
	
}
