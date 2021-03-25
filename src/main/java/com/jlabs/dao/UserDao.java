package com.jlabs.dao;

import java.util.Collection;

import com.jlabs.model.User;

public interface UserDao {

	User save(User user);
	
	User get(Integer id);
	
	User delete(Integer id);
	
	Collection<User> list();
	
}
