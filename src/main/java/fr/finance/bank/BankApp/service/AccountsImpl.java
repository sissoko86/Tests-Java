/**
 * Implementation of Accounts interface
 */
package fr.finance.bank.BankApp.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.finance.bank.BankApp.model.Accounts;


public class AccountsImpl implements IAccount {
    
	private  Map<String, Accounts> accounts ;
	
	public  void setAccounts(Map<String, Accounts> accountsdatabase) {
		this.accounts = accountsdatabase;
	}
   
	public Map<String, Accounts> getAccounts() {
		return accounts;
	}
    
	/**Description add a account
	 * @param account
	 * 
	 */
	public Accounts addAccount(Accounts account) {
		Response response = new Response();
		if(accounts.get(account.getCodeAccount()) !=null) {
			  response.setStatus(false);
			  response.setMessage("This Account Already Exists");
			  return account;
		}
		accounts.put(account.getCodeAccount(), account);
		response.setMessage("Account created successfully");
		return account;
	}
    
	/**
	 * Description update a account
	 * @param account
	 * 
	 */
	public Accounts updateAccount(Accounts account) {
		
		if(accounts.get(account.getCodeAccount()) !=null) {
			 
			  accounts.put(account.getCodeAccount(), account);
			  System.out.println("Account update successfully");
			 return account;
		} else {
		System.out.println("Account update Aborted");
		return null;
		}
	}
    
	/**
	 * Description : get a account 
	 * @param code
	 * 
	 */
	public Accounts readAccount(String code) {
		return accounts.get(code);
	}
	
	/**
	 * Description : delete a account 
	 * @param code
	 * 
	 */
	public Response deleteAccount(String code) {
		Response response = new Response();
		if(accounts.get(code) == null){
			response.setStatus(false);
			response.setMessage("Account Doesn't Exists");
			return response;
		}
		accounts.remove(code);
		response.setStatus(true);
		response.setMessage("Account deleted successfully");
		return response;
		
	}
    
	/**
	 * Description : get all account 
	 */
	public List<Accounts> readAllAccounts() {
		
		return accounts.values().stream().collect(Collectors.toList());
	}

}
