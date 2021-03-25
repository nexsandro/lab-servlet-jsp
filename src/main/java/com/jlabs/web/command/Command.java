package com.jlabs.web.command;

import java.io.IOException;

import javax.servlet.ServletException;

public interface Command {

	void execute() throws ServletException, IOException;

}