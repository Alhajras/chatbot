package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

	Article findById(Long id);

}