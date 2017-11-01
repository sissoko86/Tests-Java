/**
 * Implementation of person interface
 */
package fr.finance.bank.BankApp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.finance.bank.BankApp.model.Person;

public class PersonImpl implements IPerson {
	
	private  Map<Integer,Person> personDatabase;
	
	

	public  Map<Integer, Person> getPersonDatabase() {
		return personDatabase;
	}

	public  void setPersons(Map<Integer, Person> persons) {
		this.personDatabase = persons;
	}

	public PersonImpl() {
		super();
		personDatabase= new HashMap<Integer, Person>();
		
	}
    
	
	/**Description add a person
	 * @param p
	 * 
	 */
	public  Person addPerson(Person p) {
		
		if(personDatabase.get(p.getId()) !=null) {
			System.out.println("This Person Already Exists");
			  return p;
		}
		personDatabase.put(p.getId(), p);
		System.out.println("Person created successfully");
		
		return p;
	}
    
	/**
	 * Description update a person
	 * @param p
	 * 
	 */
	public Person updatePerson(Person p) {

		if(personDatabase.get(p.getId()) !=null) {
			System.out.println("Person update successfully");
			personDatabase.put(p.getId(), p);
			  return p;
		}
		
		System.out.println("Person doesn't update");
		
		return p;
	}
    
	/**
	 * Description : get a person 
	 * @param id 
	 */
	public Person readPerson(int id) {
		return personDatabase.get(id);
	}
    
	/**
	 * Description : get all persons 
	 */
	public List<Person> readAllPerson() {
		List<Person> personList = personDatabase.values().stream().collect(Collectors.toList());
		return personList;
	}
	
	/**
	 * Description : delete a person 
	 * @param id 
	 */
	public Response deletePerson(int id) {
		Response response = new Response();
		if(personDatabase.get(id) == null){
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}
		personDatabase.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}

	
	
	
}
