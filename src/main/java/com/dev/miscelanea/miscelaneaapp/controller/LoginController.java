package com.dev.miscelanea.miscelaneaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	// Aqui procesa el redireccionamiento de la clase SecurityConfig
	@GetMapping("/login")
	public String showLoginPage() {
		
		return "login/login";
	}

	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
	}
	
}
