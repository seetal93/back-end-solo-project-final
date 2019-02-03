package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.DBEntryService;
import com.qa.business.service.UserService;

@Path("/user")
public class UserEndpoint {

	@Inject
	private UserService service;
	
	@Path("/getAllUsers")
	@GET
	@Produces({"application/json"})
	public String getAllUsers() {
		return service.getAllUsers();
	}
	
	@Path("/addUser")
	@POST
	@Produces({"application/json"})
	public String addUser(String user) {
		return service.addUser(user);
	}
	
	@Path("/updateUser/{userName}")
	@PUT
	@Produces({"application/json"})
	public String updateUser(@PathParam("userName") String userName, String user) {
		return service.updateUser(userName, user);
	}
	
	@Path("/deleteUser/{userName}")
	@DELETE
	@Produces({"application/json"})
	public String deleteUser(@PathParam("userName") String userName) {
		return service.deleteUser(userName);
	}
	
	public void setService(UserService service) {
		this.service = service;
	}
}
