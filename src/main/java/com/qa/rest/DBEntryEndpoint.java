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

@Path("/fetch")
public class DBEntryEndpoint {
	
	@Inject
	private DBEntryService service;
	
	@Path("/getAllDBEntrys")
	@GET
	@Produces({"application/json"})
	public String getAllDBEntrys() {
		return service.getAllDBEntrys();
	}
	
	@Path("/addDBEntry")
	@POST
	@Produces({"application/json"})
	public String addDBEntry(String DBEntry) {
		return service.addDBEntry(DBEntry);
	}
	
	@Path("/updateDBEntry/{breedOfDog}")
	@PUT
	@Produces({"application/json"})
	public String upddateDBEntry(@PathParam("breedOfDog") String breedOfDog, String DBEntry) {
		return service.updateDBEntry(breedOfDog, DBEntry);
	}
	
	@Path("/deleteDBEntry/{breedOfDog}")
	@DELETE
	@Produces({"application/json"})
	public String deleteDBEntry(@PathParam("breedOfDog") String breedOfDog) {
		return service.deleteDBEntry(breedOfDog);
	}
	
	@Path("/getDBEntry/{breedOfDog}")
	@GET
	@Produces({"application/json"})
	public String getDBentry(@PathParam("breedOfDog") String breedOfDog) {
		return service.getDBEntry(breedOfDog);
	}
	
	public void setService(DBEntryService service) {
		this.service = service;
	}
	
}
