package com.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.services.ArticleServiceImpl;

@Controller
public class SearchController {

	@Autowired
	private ArticleServiceImpl articleServiceImpl;

	@GetMapping("/search")
	public String search() {
		System.err.println(articleServiceImpl.getArticle((long) 1).getTitle());
		return "widget";
	}

}