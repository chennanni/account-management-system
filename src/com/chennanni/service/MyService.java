package com.chennanni.service;

import java.util.List;

import com.chennanni.domain.Person;

public interface MyService {
	public List<Person> getAllPersons();

	public boolean addPerson(Person person);

	public boolean deletePerson(String name, int age);

	public boolean updatePerson(String name, int age, Person person);
}
