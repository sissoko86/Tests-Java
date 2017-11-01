/**
 * IBankImplementation
 */
package fr.finance.bank.BankApp.service;

import java.util.ArrayList;
import java.util.List;


import fr.finance.bank.BankApp.model.Accounts;
import fr.finance.bank.BankApp.model.Person;

public class IBankOperationImpl  implements IBankOperation{

	private IPerson personService;
	private IAccount accountservice;
	
	/**
	 * @param personService
	 */
	public void setpersonService(IPerson personService) {
		this.personService = personService;
	}
    
	/**
	 * 
	 * @param accountservice
	 */
	public void setAccountservice(IAccount accountservice) {
		this.accountservice = accountservice;
	}
    
	/**
	 * @param typeAccount
	 * @param balance
	 */
	public Accounts withdraw(String typeAccount, int balance) {
		
		Accounts account = accountservice.readAccount(typeAccount);
		if(account.getBalance() < balance){
			System.out.println("impossible operation ");
		}
		int newbalance = account.getBalance() - balance;
	    account.setBalance(newbalance);
		return accountservice.updateAccount(account);
	}
	
    /**Description this method allows to deposit balance in a account
     * @param codeAccount,balance
     * @return Accounts
     */
	public Accounts deposit(String codeAccount, int balance) {
		
		Accounts account = accountservice.readAccount(codeAccount);
		int newbalance=accountservice.readAccount(codeAccount).getBalance()+balance;
		account.setBalance(newbalance);
		return accountservice.updateAccount(account);
	}
  
	/**Description retun a list account of a given person
	 * @param person
	 * @return List<Accounts>
	 */
	public List<Accounts> getAllAccountByPersn(Person person) {
		
		return (List<Accounts>) personService.readPerson(person.getId()).getAccountList();
	}
    
	
	/**Description calculate sum of accounts of a person
	 * @param person
	 * @return sumbalance
	 */
	public int sumBalancesAccountsByPerson(Person person) {
		List<Accounts>listaccounts = new ArrayList<Accounts>();
		int sumBalances=0;
	     
	     listaccounts = (List<Accounts>) personService.readPerson(person.getId()).getAccountList();
	     if(listaccounts !=null) {
	    	 
	    	 for(Accounts acc: listaccounts) {
		    	 sumBalances +=acc.getBalance();
		     }
	     } else {
	    	 
	    	 sumBalances=0;
	     }
	    
		return sumBalances;
	}

	
}
