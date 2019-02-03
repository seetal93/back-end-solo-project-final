package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.DBEntry;
import com.qa.persistence.repository.DBEntryRepository;
import com.qa.util.JSONUtil;

public class DBEntryServiceImplementation implements DBEntryService {

	@Inject
	private DBEntryRepository repo;
	@Inject
	private JSONUtil util;
	
	
	public String getAllDBEntrys() {
		return repo.getAllDBEntrys();
	}

	public String addDBEntry(String DBEntry) {
		DBEntry checkDBEntry = util.getObjectForJSON(DBEntry, DBEntry.class);
		return repo.addDBEntry(DBEntry);
	}

	public String deleteDBEntry(String breedOfDog) {
		return repo.deleteDBEntry(breedOfDog);
	}

	public String updateDBEntry(String breedOfDog, String DBEntry) {
		return repo.updateDBEntry(breedOfDog, DBEntry);
	}
	
	public String getDBEntry(String breedOfDog) {
		return repo.getDBEntry(breedOfDog);
	}
	
}
