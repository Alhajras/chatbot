package com.application.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Article {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private int priority;

	private String link;

	private boolean active;
	
	private long views;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Keyword> keywords;

	public Article() {
		// TODO Auto-generated constructor stub
	}
}
