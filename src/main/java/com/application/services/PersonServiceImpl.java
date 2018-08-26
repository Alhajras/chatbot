package com.application.services;

import java.beans.Transient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.application.model.Person;
import com.application.repositories.PersonDAL;
import com.application.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepository personRepository;
//	private final PersonDAL personDAL;
//
//	@Autowired
//	public PersonServiceImpl(PersonRepository personRepository, PersonDAL personDAL) {
//		this.personRepository = personRepository;
//		this.personDAL = personDAL;
//	}

	@Override
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person getPerson(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public Person editPerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deletePerson(Person person) {
		personRepository.delete(person);
	}

	@Override
	public void deletePerson(Long id) {
		personRepository.delete(id);
	}

	@Override
	public List<Person> getAllPersons(int pageNumber, int pageSize) {
		return personRepository.findAll(new PageRequest(pageNumber, pageSize)).getContent();
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public long countPersons() {
		return personRepository.count();
	}

	@Override
	public List<Person> fuzzySearchPerson(String term) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> wildCardSearchPerson(String term) {
		// TODO Auto-generated method stub
		return null;
	}

}