package com.dev.miscelanea.miscelaneaapp.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.dev.miscelanea.miscelaneaapp.entity.Usuario;
import com.dev.miscelanea.miscelaneaapp.service.UserService;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		//System.out.println("\nIn customAuthenticationSuccessHandler\n");
		
		String userName = authentication.getName();
		
		//System.out.println("userName: " + userName);
		
		Usuario theUser = userService.findByUserName(userName);
		
		// now place in the session
		HttpSession session = request.getSession();
		session.setAttribute("user", theUser);

		
		// forward to home page
		//System.out.println("Redirect URL: " + request.getContextPath() + "/");
		//response.sendRedirect(request.getContextPath() + "/welcome");
		response.sendRedirect(request.getContextPath() + "/");
	}

}
