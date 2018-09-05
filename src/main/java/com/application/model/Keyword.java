package com.application.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JacksonInject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Keyword {

	@Id
	@GeneratedValue
	private Long id;

	private String keyword;

	@OneToOne(fetch = FetchType.LAZY)
	private Article article;

	public Keyword() {
		// TODO Auto-generated constructor stub
	}
}
