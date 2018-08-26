package com.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

@Entity
@Indexed
public class Person {

	@Id
	private Long id;

	@Field(termVector = TermVector.YES)
	private String name;

	@Field
	private int age;
	// standard getters and setters

	@Override
	public String toString() {
		return String.format("Person{id=%d, name='%s', age=%d}", id, name, age);

	}
}
