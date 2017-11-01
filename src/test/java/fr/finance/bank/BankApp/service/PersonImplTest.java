package fr.finance.bank.BankApp.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.finance.bank.BankApp.service.AccountsImpl;

import fr.finance.bank.BankApp.service.IBankOperationImpl;

import fr.finance.bank.BankApp.service.PersonImpl;
import  fr.finance.bank.BankApp.model.Accounts;
import  fr.finance.bank.BankApp.model.Person;

public class PersonImplTest {
	
	private static PersonImpl personService;
	private static AccountsImpl iaccount;
	private static IBankOperationImpl bankservice; 
	private static List<Accounts>listaccount;
	private static Map<Integer,Person> personsdatabse;
	private static Person p1, p2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 personService = new PersonImpl();
		 iaccount = new AccountsImpl();
		 bankservice = new IBankOperationImpl();
		 listaccount = new ArrayList<Accounts>();
		 personsdatabse= new HashMap<Integer, Person>();
     	 personsdatabse.put(3, new Person(3,"Didier"));
    	 personService.setPersons(personsdatabse);
		 p1 = new Person(1,"Nadine");
		 p2 = new Person(2,"charles");
	}

	@Test
	public void testAddPerson() {
	
	      
	     assertEquals("Nadine",personService.addPerson(p1).getName());

	}

	@Test
	public void testUpdatePerson() {
		
		
		Person p = personService.readPerson(3);
		int oldAge = p.getAge();
		p.setAge(40);
		
		assertFalse(oldAge==personService.updatePerson(p).getAge());
		
	}

	@Test
	public void testReadPerson() {
		 assertNotNull(personService.readPerson(3));
	}

	@Test
	public void testReadAllPerson() {

		 assertNotNull(personService.readAllPerson());
	}

	@Test
	public void testDeletePerson() {
		
		assertTrue(personService.deletePerson(3).isStatus());
	}

}
