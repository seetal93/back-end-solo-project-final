package com.qa.business.service;

public interface UserService {
	String getAllUsers();
	String addUser(String user);
	String deleteUser(String userName);
	String updateUser(String userName, String user);
}
