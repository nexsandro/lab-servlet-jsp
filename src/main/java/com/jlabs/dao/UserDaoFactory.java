package com.jlabs.dao;

import com.jlabs.dao.mem.UserDaoImpl;

public class UserDaoFactory {

	private static final UserDaoFactory instance = new UserDaoFactory();

	private UserDao userDao = new UserDaoImpl();
	
	private UserDaoFactory() {
		super();
	}

	public static UserDaoFactory getInstance() {
		return instance;
	}
	
	public UserDao getDao() {
		return userDao;
	}
}
