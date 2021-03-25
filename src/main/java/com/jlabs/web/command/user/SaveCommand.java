package com.jlabs.web.command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlabs.dao.UserDaoFactory;
import com.jlabs.model.User;
import com.jlabs.web.UserMapper;
import com.jlabs.web.command.Command;

public class SaveCommand implements Command {
	
	private HttpServletRequest request;

	private HttpServletResponse response;
		
	public SaveCommand(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}


	@Override
	public void execute() throws ServletException, IOException {

		User user = new UserMapper().fromRequest(request);
		user = UserDaoFactory.getInstance().getDao().save( user );
		
		response.sendRedirect( "user" );

	}

}
