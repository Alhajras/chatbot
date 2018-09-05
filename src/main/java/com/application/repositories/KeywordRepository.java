package com.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Article;
import com.application.model.Keyword;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

	Keyword findById(Long id);

	List<Keyword> findByArticle(Article article);

}