package com.jlabs.web.command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlabs.dao.UserDaoFactory;
import com.jlabs.web.UserMapper;
import com.jlabs.web.command.Command;

public class DeleteCommand implements Command {
	
	private HttpServletRequest request;

	private HttpServletResponse response;

	public DeleteCommand(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}


	@Override
	public void execute() throws ServletException, IOException {

		UserDaoFactory.getInstance().getDao().delete( new UserMapper().keyFrom( request ) );

		response.sendRedirect( "user" );

	}

}
