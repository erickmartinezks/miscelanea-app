package com.dev.miscelanea.miscelaneaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@GetMapping("/")
	public String showWelcomePage() {
		//System.out.println("/ welcome-page");
		return "welcome";
	}
	
}
