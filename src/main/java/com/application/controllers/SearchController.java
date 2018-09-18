/**
 * author: Alhajras Algdairy
 * 
 * Controller for serving the request of the user in the chatbot
 */

package com.application.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.application.exceptions.authorityException;
import com.application.model.Article;
import com.application.services.ArticleServiceImpl;
import com.google.common.collect.HashBiMap;

@Controller
public class SearchController {

	@Autowired
	private ArticleServiceImpl articleServiceImpl;

//	Key to use for the API
	@Value("${security.key}")
	private String key;

	@GetMapping("{authinticationKey}/search/{text}")
	public String search(@PathVariable String text, @PathVariable String authinticationKey) throws authorityException {

		if (!authinticationKey.equals(key)) {
			throw new authorityException("Security exception, the key is invalid!");
		}
		HashMap<Integer, Article> articlesPoints = new HashMap<Integer, Article>();

//
//		List<Article> articles = articleServiceImpl.getAllArticles();
//		int score = 0;
//		articles.forEach(article -> {
//			score = 0;
//			if (article.getKeywords().contains(arg0)) {
//				System.out.println(item);
//			}
//		});
//
//		for (Article article : articles) {
//
//		}
//
//		System.err.println(text);
		return "widget";
	}

}