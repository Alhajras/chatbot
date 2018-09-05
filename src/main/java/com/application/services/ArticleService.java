package com.application.services;

import java.util.List;

import com.application.model.Article;
import com.application.model.Keyword;

public interface ArticleService {
	Article createArticle(Article article);

	Article getArticle(Long id);

	Article editArticle(Article article);

	void deleteArticle(Article article);

	void deleteArticle(Long id);

	List<Article> getAllArticles(int pageNumber, int pageSize);

	List<Article> getAllArticles();

	List<Keyword> getKeywords(Article article);

	long countArticles();
}