package com.qa.persistence.repository;

public interface UserRepository {
	
	String getAllUsers();
	String addUser(String user);
	String deleteUser(String userName);
	String updateUser(String userName, String user);
	
}
