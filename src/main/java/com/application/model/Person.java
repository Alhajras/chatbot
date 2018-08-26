package com.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	// standard getters and setters

	@Override
	public String toString() {
		return String.format("Person{id=%d, name='%s', age=%d}", id, name);

	}

	public Person(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}
}
