package com.chennanni.controller;

import java.util.List;

import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chennanni.dao.CRUDBasic;
import com.chennanni.domain.Person;

@RestController
public class AMSController {

	CRUDBasic myService = new CRUDBasic();
	
	@RequestMapping(value="/persons", method=RequestMethod.GET, headers="Accept=application/json")
	public List<Person> getAllPersons() {
		List<Person> persons = myService.getAllPersons();
		return persons;
	}
	
	@RequestMapping(value="/persons/insert/{name}/{age}", method=RequestMethod.POST, headers="Accept=application/json")
	public List<Person> addPerson(@PathVariable String name, @PathVariable int age) throws ParseException {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		if (myService.addPerson(person))
			System.out.println("add success");
		return myService.getAllPersons();
	}
	
	@RequestMapping(value="/persons/delete/{name}/{age}", method=RequestMethod.DELETE, headers="Accept=application/json")
	public List<Person> deletePerson(@PathVariable String name, @PathVariable int age) throws ParseException {
		if (myService.deletePerson(name, age))
			System.out.println("delete success");
		return myService.getAllPersons();
	}
	
	@RequestMapping(value="/persons/update/{name}/{age}", method=RequestMethod.PUT, headers="Accept=application/json")
	public List<Person> updatePerson(@PathVariable String name, @PathVariable int age, @RequestBody Person person) throws ParseException {
		if (myService.updatePerson(name, age, person))
			System.out.println("update success");
		return myService.getAllPersons();
	}
}
