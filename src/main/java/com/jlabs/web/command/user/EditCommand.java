package com.jlabs.web.command.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlabs.dao.UserDaoFactory;
import com.jlabs.model.User;
import com.jlabs.web.UserMapper;
import com.jlabs.web.command.Command;

public class EditCommand implements Command {
	
	private HttpServletRequest request;

	private HttpServletResponse response;
	
	public EditCommand(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}

	@Override
	public void execute() throws ServletException, IOException {

		if (request.getParameter("id") != null) {		
			User user = UserDaoFactory.getInstance().getDao().get( new UserMapper().keyFrom( request ) );
			request.setAttribute("user", user);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/user/edit.jsp" );
		dispatcher.forward( request, response );
	}

}
