package com.diwakar.springexample.service;

import java.util.List;

import com.diwakar.springexample.model.Person;
/**
 *  @author Diwakar
 *
 * Date:  Aug 6, 2015 2015
 * File: PersonRestController.java
 */
public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	
}
