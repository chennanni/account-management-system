package com.chennanni.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.chennanni.domain.Person;
import com.chennanni.service.MyService;

public class CRUDBasic implements MyService{

	List<Person> persons = new ArrayList<Person>();
	
	public CRUDBasic() {
		Person p1 = new Person();
		p1.setName("AAA");
		p1.setAge(40);
		
		Person p2 = new Person();
		p2.setName("BBB");
		p2.setAge(35);
		
		persons.add(p1);
		persons.add(p2);
	}
	
	public List<Person> getAllPersons() {
		return persons;
	}

	public boolean addPerson(Person person) {
        Iterator<Person> fooIterator = persons.iterator();
        while (fooIterator.hasNext()) {
            Person p = (Person) fooIterator.next();
            if (p.getName().equals(person.getName()) && p.getAge() == person.getAge()) {
                return false;
            }
        }		
		persons.add(person);
        return true;
	}

	public boolean deletePerson(String name, int age) {
        Iterator<Person> fooIterator = persons.iterator();
        while (fooIterator.hasNext()) {
            Person p = (Person) fooIterator.next();
            if (p.getName().equals(name) && p.getAge() == age) {
            	persons.remove(p);
                return true;
            }
        }
        return false;
	}

	public boolean updatePerson(String name, int age, Person person) {
        Iterator<Person> fooIterator = persons.iterator();
        while (fooIterator.hasNext()) {
            Person p = (Person) fooIterator.next();
            if (p.getName().equals(name) && p.getAge() == age) {
            	p.setName(person.getName());
            	p.setAge(person.getAge());
                return true;
            }
        }
        return false;
	}
	
}
