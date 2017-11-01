package fr.finance.bank.BankApp.service;

import java.util.List;


import fr.finance.bank.BankApp.model.Accounts;
import fr.finance.bank.BankApp.model.Person;

public interface IBankOperation {
	public Accounts withdraw(String typeAccount, int balance);
	public Accounts deposit(String typeAccount , int balance);
	public List<Accounts> getAllAccountByPersn(Person person);
	public int sumBalancesAccountsByPerson(Person person);

}
