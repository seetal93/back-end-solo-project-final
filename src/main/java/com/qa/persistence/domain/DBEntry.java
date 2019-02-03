package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DBEntry {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String breedOfDog;
	private String about;
	private String image;

	
	public DBEntry() {
		
	}
	
	public DBEntry(String breedOfDog, String about, String image) {
		this.breedOfDog = breedOfDog;
		this.about = about;
		this.image = image;
	}

	public String getBreedOfDog() {
		return breedOfDog;
	}

	public void setBreedOfDog(String breedOfDog) {
		this.breedOfDog = breedOfDog;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
