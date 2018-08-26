package com.chatbot.services;

import java.util.List;

import com.chatbot.model.Person;

public interface PersonService {
	Person createPerson(Person person);

	Person getPerson(Long id);

	Person editPerson(Person person);

	void deletePerson(Person person);

	void deletePerson(Long id);

	List<Person> getAllPersons(int pageNumber, int pageSize);

	List<Person> getAllPersons();

	long countPersons();

	List<Person> fuzzySearchPerson(String term);

	List<Person> wildCardSearchPerson(String term);
}