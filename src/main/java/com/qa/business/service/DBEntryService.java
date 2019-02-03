package com.qa.business.service;

public interface DBEntryService {
	String getAllDBEntrys();
	String addDBEntry(String dBEntry);
	String deleteDBEntry(String breedOfDog);
	String updateDBEntry(String breedOfDog, String dBEntry);
	String getDBEntry(String breedOfDog);
}
