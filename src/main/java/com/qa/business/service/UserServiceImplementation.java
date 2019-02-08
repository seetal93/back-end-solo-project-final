package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserRepository;
import com.qa.util.JSONUtil;

public class UserServiceImplementation implements UserService {
	@Inject
	private UserRepository repo;
	@Inject
	private JSONUtil util;

	String[] noAdmin = new String[] { "admin" };

	public String getAllUsers() {
		return repo.getAllUsers();
	}

	public String addUser(String user) {
		User checkUser = util.getObjectForJSON(user, User.class);
		String numRegex = ".*[0-9].*";
		String lowerCaseRegex = ".*[a-z]*";

		for (int i = 0; i < noAdmin.length; i++) {
			if (checkUser.getUserName().equals(noAdmin[i])) {
				return "Unable to create account";
			} else if (checkUser.getUserName().length() < 4 || checkUser.getUserName().length() < 10) {
				return "Username should be between 4 and 9 characters";
			} else {
				if (!(checkUser.getPassword().matches(numRegex) && (checkUser.getPassword().matches(lowerCaseRegex)))) {
					return "Password should contain a combination of numbers and lower case letters.";
				}
			}
		}

		return repo.addUser(user);
	}

	public String deleteUser(String userName) {
		return repo.deleteUser(userName);
	}

	public String updateUser(String userName, String user) {
		return repo.updateUser(userName, user);
	}
}
