/**
 * author: Alhajras Algdairy
 * 
 * Controller to return the page widget.html */

package com.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WidgetController {

	@RequestMapping("/widget.html")
	public ModelAndView firstPage() {
		return new ModelAndView("widget");
	}

}