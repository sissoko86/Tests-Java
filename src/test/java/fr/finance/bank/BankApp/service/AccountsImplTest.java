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

public class AccountsImplTest {
	
	private static PersonImpl personService;
	private static  AccountsImpl accountImp;
	private static IBankOperationImpl bankservice; 
	private static List<Accounts>listaccount;
	private static Map<String,Accounts> accountsdatabase;
	private static Accounts acc1, acc2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		personService = new PersonImpl();
		 accountImp = new AccountsImpl();
		 bankservice = new IBankOperationImpl();
		 listaccount = new ArrayList<Accounts>();
		 accountsdatabase= new HashMap<String, Accounts>();
		 acc1 = new Accounts("Public Account",new Date(),2000);
		  acc2 = new Accounts("Public Account2",new Date(),3000);
    	 accountsdatabase.put("Private Account", new Accounts("Private Account",new Date(),5000));
    	 accountsdatabase.put(acc1.getCodeAccount(), acc1);
    	 accountImp.setAccounts(accountsdatabase);
          
	}

	@Test
	public void testAddAccount() {
		accountImp.addAccount(acc2);
		assertEquals(3,accountsdatabase.size());
	}

	@Test
	public void testUpdateAccount() {
		Accounts account = accountImp.readAccount("Private Account");
	
    	int oldbalance = account.getBalance();
    	System.out.println("Old balance"+oldbalance);
    	account.setBalance(100);
    	assertTrue(oldbalance != accountImp.updateAccount(account).getBalance() );
		
	}

	@Test
	public void testReadAccount() {
		assertNotNull(accountImp.readAccount("Private Account"));
	}

	@Test
	public void testDeleteAccount() {
		
		assertTrue(accountImp.deleteAccount("Public Account").isStatus());
	}

	@Test
	public void testReadAllAccounts() {
		assertNotNull(accountImp.getAccounts());
	}

}
