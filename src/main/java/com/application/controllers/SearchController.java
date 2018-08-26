package com.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.model.Person;
import com.application.services.PersonServiceImpl;

@Controller
public class SearchController {

	@Autowired
	private PersonServiceImpl PersonServiceImpl;

	@GetMapping("/search")
	public String search() {
//		Person person = personService.getPerson((long) 1);
		Person person2 = new Person((long) 2, "mo");
		PersonServiceImpl.createPerson(person2);
//		System.err.println(person.toString());
		return "widget";
	}

}