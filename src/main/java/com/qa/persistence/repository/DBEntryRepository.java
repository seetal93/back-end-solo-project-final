package com.qa.persistence.repository;

public interface DBEntryRepository {
	
	String getAllDBEntrys();
	String addDBEntry(String dBEntry);
	String deleteDBEntry(String breedOfDog);
	String updateDBEntry(String breedOfDog, String dBEntry);
	String getDBEntry(String breedOfDog);

}
