package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

//	@Query("select p FROM Person p WHERE p.id = ?1")
	Person findById(Long id);

}