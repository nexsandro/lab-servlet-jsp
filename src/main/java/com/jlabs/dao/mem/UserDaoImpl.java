package com.jlabs.dao.mem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.jlabs.dao.UserDao;
import com.jlabs.model.User;

public class UserDaoImpl implements UserDao {

	private Integer userKeyGenerator = 1;
	
	private Map<Integer,User> repository = new HashMap<>();
	
	@Override
	public User save(User user) {

		if ( user.getId() == null) {
			user.setId( userKeyGenerator++ );
		}
		
		repository.put( user.getId(), user );
		
		return user;
	}

	@Override
	public User get(Integer id) {
		return repository.get( id );
	}

	@Override
	public Collection<User> list() {
		return repository.values();
	}

	@Override
	public User delete(Integer id) {
		return repository.remove( id );
	}

}
