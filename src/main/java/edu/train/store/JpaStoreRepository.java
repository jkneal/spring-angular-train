package edu.train.store;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.stereotype.Repository;

@Repository
@CommonsLog
public class JpaStoreRepository implements StoreRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Store find(int id) {
		log.info("Searching for store by primary key: " + id);
		return entityManager.find(Store.class, id);
	}

	@Override
	public Store findByNameAndOwner(String name, String owner) {
		log.info("Searching for store by name and owner: " + name + ", " + owner);
		// TODO Implement in future exercise
		return null;
	}

	@Override
	public List<Store> findAll() {
		// TODO Implement in future exercise
		return null;
	}

	@Override
	public Store save(Store store) {
		log.info("Saving store: " + store);
		if(store.getId() == null) {
			entityManager.persist(store);
		} else {
			entityManager.merge(store);
		}
		
		return store;
	}

	@Override
	public void delete(Store store) {
		log.info("Deleting store: " + store);
		entityManager.remove(store);
	}

}
