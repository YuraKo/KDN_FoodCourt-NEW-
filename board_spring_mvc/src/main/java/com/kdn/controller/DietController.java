package com.kdn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DietController {
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", e.getMessage());
		model.addObject("content", "ErrorHandler.jsp"); 
		return model;
	}
	
	
}
