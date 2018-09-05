package com.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.application.model.Article;
import com.application.model.Keyword;
import com.application.repositories.ArticleRepository;
import com.application.repositories.KeywordRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private KeywordRepository keywordRepository;

	@Override
	public Article createArticle(Article Article) {
		return articleRepository.save(Article);
	}

	@Override
	public Article getArticle(Long id) {
		return articleRepository.findById(id);
	}

	@Override
	public Article editArticle(Article Article) {
		return articleRepository.save(Article);
	}

	@Override
	public void deleteArticle(Article Article) {
		articleRepository.delete(Article);
	}

	@Override
	public void deleteArticle(Long id) {
		articleRepository.delete(id);
	}

	@Override
	public List<Article> getAllArticles(int pageNumber, int pageSize) {
		return articleRepository.findAll(new PageRequest(pageNumber, pageSize)).getContent();
	}

	@Override
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	@Override
	public long countArticles() {
		return articleRepository.count();
	}

	@Override
	public List<Keyword> getKeywords(Article article) {
		return keywordRepository.findByArticle(article);
	}

}