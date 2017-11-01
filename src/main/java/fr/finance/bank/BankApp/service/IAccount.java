package fr.finance.bank.BankApp.service;


import java.util.List;
import java.util.Map;

import fr.finance.bank.BankApp.model.Accounts;


public interface IAccount {
	
	public Accounts addAccount(Accounts account);
	public Accounts updateAccount(Accounts account);
	public Accounts readAccount(String code);
	public List<Accounts> readAllAccounts();
	public Response deleteAccount(String code);
}
