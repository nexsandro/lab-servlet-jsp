package com.jlabs.web;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import com.jlabs.model.User;

public class UserMapper {

	public User fromRequest(HttpServletRequest request) {
		
		User user = new User();
		
		
		String userId = request.getParameter("id");
		
		if (!userId.isBlank()) {
			user.setId( Integer.decode( userId) );
		}
		user.setName( request.getParameter("name"));
		user.setEmail( request.getParameter("email"));
		
		String birthDate = request.getParameter("birthDate");
		if (!birthDate.isBlank()) {
			user.setBirthDate( LocalDate.parse( birthDate));			
		}
		
		return user;
	}
	
	public Integer keyFrom(HttpServletRequest request) {
		return Integer.decode( request.getParameter("id"));
	}
}
