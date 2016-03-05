package com.wait.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//006 Product Admin Control - Part 3.mp4
@Controller
public class HomeController {

	
	@RequestMapping(value="/")
	public String home(){
		return "home";
		}
	
	@RequestMapping(value="/login")
	public String login(@RequestParam(value="error", required=false) String error, @RequestParam (value="logout", required=false) String logout, Model model){
		
		if(error!=null) {
			model.addAttribute("error",  "Inwalid username and password");
		}
		
		if(logout!=null) {
			model.addAttribute("msg", "You have been logged out successfuly.");
		}
		
		return "login";
	}
}
