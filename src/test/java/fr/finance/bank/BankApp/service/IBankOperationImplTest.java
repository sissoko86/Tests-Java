/**
 * Unit test class of Ibankoperationimpl()
 */
package fr.finance.bank.BankApp.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.finance.bank.BankApp.model.Accounts;
import fr.finance.bank.BankApp.model.Person;

public class IBankOperationImplTest {
	
	private static PersonImpl personService;
	private static AccountsImpl accountservice;
	private static List<Accounts>listaccount;
	private static Map<Integer,Person> personsdatabse;
	private static Person nadine, charles;
	private static Map<String,Accounts> accountsdatabase;
	private static Accounts accountPublic1, accountPulic2;
	private static IBankOperationImpl bankservice; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 personService = new PersonImpl();
		 accountservice = new AccountsImpl();
		 listaccount = new ArrayList<Accounts>();
		 personsdatabse= new HashMap<Integer, Person>();
    	 personsdatabse.put(3, new Person(3,"Didier"));
    	
		 nadine = new Person(1,"Nadine");
		 charles = new Person(2,"charles");
		 bankservice = new  IBankOperationImpl(); 
		 
		
		  
		  accountsdatabase= new HashMap<String, Accounts>();
		  accountPublic1 = new Accounts("Public Account",new Date(),2000);
		  accountPulic2 = new Accounts("Public Account2",new Date(),3000);
	      accountsdatabase.put("Private Account", new Accounts("Private Account",new Date(),5000));
	      accountsdatabase.put(accountPublic1.getCodeAccount(), accountPublic1);
	      accountsdatabase.put(accountPulic2.getCodeAccount(), accountPulic2);
	      accountservice.setAccounts(accountsdatabase);
	      listaccount.add(accountPublic1);
	      listaccount.add(accountPulic2);
	      nadine.setAccountList(listaccount);
	      personsdatabse.put(nadine.getId(), nadine);
	      personsdatabse.put(charles.getId(), charles);
	      personService.setPersons(personsdatabse);
	      bankservice.setAccountservice(accountservice);
	      bankservice.setpersonService(personService);
	      
	}

	@Test
	public void testWithdraw() {
		int expected= 1400;
		assertTrue(expected==bankservice.withdraw("Public Account", 600).getBalance());
	}

	@Test
	public void testDeposit() {
		int expected = 3700;
		assertTrue(expected==bankservice.deposit("Public Account2", 700).getBalance());
	}

	@Test
	public void testGetAllAccountByPersn() {
		assertEquals(2,bankservice.getAllAccountByPersn(nadine).size());
		
	}

	@Test
	public void testSumBalancesAccountsByPerson() {
		assertEquals(5000,bankservice.sumBalancesAccountsByPerson(nadine));
	}

}
