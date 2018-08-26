package com.chatbot.repositories;

import java.util.List;

import com.chatbot.model.Person;

public interface PersonDAL {
	List<Person> fuzzySearchPerson(String term);

	List<Person> wildCardSearchPerson(String term);
}