package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.DBEntry;
import com.qa.util.JSONUtil;

	@Transactional(SUPPORTS)
	@Default
	public class DBEntryDBRepository implements DBEntryRepository{
		
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;
		
		@Inject
		private JSONUtil util;
		
		public String getAllDBEntrys() {
			Query query = manager.createQuery("SELECT d FROM DBEntry d");
			Collection<DBEntry> DBEntrys = (Collection<DBEntry>)query.getResultList();
			return util.getJSONForObject(DBEntrys);
		}
		
		public String getDBEntry(String breedOfDog) {
			Query query = manager.createQuery("Select a FROM DBEntry a WHERE a.breedOfDog = :breedOfDog");
			query.setParameter("breedOfDog", breedOfDog);
			@SuppressWarnings("unchecked")
			Collection<DBEntry> entries = (Collection<DBEntry>) query.getResultList();
			return util.getJSONForObject(entries);
		}
		
		private DBEntry findDBEntry(Long id) {
			return manager.find(DBEntry.class, id);
		}
		
		public Long getIdFromDogBreed(String breedOfDog) {
			Query query = manager.createQuery("Select id FROM DBEntry a WHERE a.breedOfDog = :breedOfDog");
			query.setParameter("breedOfDog", breedOfDog);
			@SuppressWarnings("unchecked")
			List<Long> entries = (List<Long>) query.getResultList();
			long uID = entries.get(0);
			return uID;
		}
		
		
		@Transactional(REQUIRED)
		public String addDBEntry(String DBEntry) {
			DBEntry aDBEntry = util.getObjectForJSON(DBEntry, DBEntry.class) ;
			manager.persist(aDBEntry);
			return "{\"message\": \"DBEntry sucessfully added\"}";
		}
		

		@Transactional(REQUIRED)
		public String updateDBEntry(String breedOfDog, String dBEntry) {
			Long id = getIdFromDogBreed(breedOfDog);
			DBEntry foundDBEntry = findDBEntry(id);
			if(foundDBEntry!=null) {
				manager.remove(foundDBEntry);
				DBEntry entryUpdate = util.getObjectForJSON(dBEntry, DBEntry.class);
				manager.persist(entryUpdate);
			}
			return "{\"message\": \"DBEntry sucessfully updated\"}";
		}
		
		@Transactional(REQUIRED)
		public String deleteDBEntry(String breedOfDog) {
			Long id = getIdFromDogBreed(breedOfDog);
			DBEntry DBEntry = findDBEntry(id);
			if(DBEntry != null) {
			manager.remove(DBEntry);
		}
			return "{\"message\": \"DBEntry sucessfully deleted\"}";
		}
		
		public EntityManager getManager() {
			return manager;
		}

		public void setManager(EntityManager manager) {
			this.manager = manager;
		}

		public JSONUtil getUtil() {
			return util;
		}

		public void setUtil(JSONUtil util) {
			this.util = util;
		}
}
