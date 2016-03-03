package com.wait.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//teraz bedzie d:\+kursy\spring framework 4\building-framework\04 Online Music Store Website Part 1 - Landing Page, Product Model and Product List\004 Adding the Product Domain Model.mp4

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	 @RequestMapping("/")
	 public String home() {
		 logger.info("Metoda glowna home");
		 return "home";
	 }
}
