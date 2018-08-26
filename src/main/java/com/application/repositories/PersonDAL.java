package com.application.repositories;

import java.util.List;

import com.application.model.Person;

public interface PersonDAL {
	List<Person> fuzzySearchPerson(String term);

	List<Person> wildCardSearchPerson(String term);
}