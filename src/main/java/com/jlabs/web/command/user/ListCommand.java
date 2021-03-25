package com.jlabs.web.command.user;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlabs.dao.UserDaoFactory;
import com.jlabs.model.User;
import com.jlabs.web.command.Command;

public class ListCommand implements Command {
	
	private HttpServletRequest request;

	private HttpServletResponse response;
	
	public ListCommand(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	@Override
	public void execute() throws ServletException, IOException {
		
		Collection<User> list = UserDaoFactory.getInstance().getDao().list();
		request.setAttribute( "users", list );
		
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/user/list.jsp" );
		dispatcher.forward( request, response );
	}
}
