package fr.finance.bank.BankApp.service;

import java.util.List;
import java.util.Map;

import fr.finance.bank.BankApp.model.Person;

public interface IPerson {

	public  Person addPerson(Person p);
	public Person updatePerson(Person p);
	public Person readPerson(int id);
	public List<Person> readAllPerson();
	public Response deletePerson(int id);
}
