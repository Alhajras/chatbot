/**
 * author: Alhajras Algdairy
 * 
 * Controller to return the page widget.html */

package com.application.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WidgetController {

	@Value("${isDemo}")
	private boolean isDemo;

	@RequestMapping("/widget")
	public ModelAndView getWidget(Model model) {
		model.addAttribute("demo", isDemo);
		return new ModelAndView("widget");
	}

}