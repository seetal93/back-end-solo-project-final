package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserRepository;
import com.qa.util.JSONUtil;

public class UserServiceImplementation implements UserService{
	@Inject
	private UserRepository repo;
	@Inject
	private JSONUtil util;
	
	
	public String getAllUsers() {
		return repo.getAllUsers();
	}

	public String addUser(String user) {
		User checkUser = util.getObjectForJSON(user, User.class);
		return repo.addUser(user);
	}

	public String deleteUser(String userName) {
		return repo.deleteUser(userName);
	}

	public String updateUser(String userName, String user) {
		return repo.updateUser(userName, user);
	}
}
