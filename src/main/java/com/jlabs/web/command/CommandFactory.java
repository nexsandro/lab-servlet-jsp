package com.jlabs.web.command;

import java.lang.reflect.Constructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlabs.web.utils.StringUtils;

public class CommandFactory {

	private static final CommandFactory instance = new CommandFactory();
	
	private CommandFactory() {
		super();
	}
	
	public static CommandFactory getInstance() {
		return instance;
	}
	
	/**
	 * Define command class name evaluating the request, load and instantiate the class 
	 * calling it's constructor accepting request and response.
	 * @param request the http request
	 * @param response the http response
	 * @return the instantiated command
	 */
	public Command createCommand(HttpServletRequest request, HttpServletResponse response) {
		
		StringBuilder builder = new StringBuilder(50);

		String commandName = request.getParameter( "command" );
		if ( commandName == null || commandName.isBlank()) {
			commandName = "list";
		}
		
		String modulePath = request.getRequestURI().substring( request.getContextPath().length()).replaceAll("/", ".");

		builder
			.append( Command.class.getPackageName())
			.append(modulePath)
			.append('.')
			.append( StringUtils.kebabToCapitalizeCamelCase(commandName) )
			.append( "Command" );

		Class<?> commandClass;
		Command commandInstance = null;
		
		try {
			commandClass = Thread.currentThread().getContextClassLoader().loadClass( builder.toString() );
			Constructor<?> constructor = commandClass.getConstructor( HttpServletRequest.class, HttpServletResponse.class );			
			commandInstance = (Command) constructor.newInstance( request, response );
		} catch (Exception e) {
			throw new RuntimeException("Error constructing command: " + e.getMessage(), e);
		}

		return commandInstance;
	}
}
