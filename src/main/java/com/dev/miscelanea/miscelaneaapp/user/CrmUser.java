package com.dev.miscelanea.miscelaneaapp.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dev.miscelanea.miscelaneaapp.validation.FieldMatch;

@FieldMatch.List({
	@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmUser {

	@NotNull(message = "Obligatorio")
	@Size(min = 1, message = "Obligatorio")
	private String userName;
	
	@NotNull(message = "Obligatorio")
	@Size(min = 1, message = "Obligatorio")
	private String password;
	
	@NotNull(message = "Obligatorio")
	@Size(min = 1, message = "Obligatorio")
	private String matchingPassword;
	
	public CrmUser() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
