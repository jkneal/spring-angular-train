package edu.train.store;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.stereotype.Repository;

import edu.train.store.Store.StoreStatus;

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
	public List<Store> findAll() {
		TypedQuery<Store> query = entityManager.createNamedQuery("findAllStores", Store.class);
		return query.getResultList();
	}

	@Override
	public Store findByNameAndOwner(String name, String owner) {
		log.info("Searching for store by name and owner: " + name + ", " + owner);
		TypedQuery<Store> query = entityManager.createQuery("SELECT s FROM Store s WHERE s.name = :name AND s.owner = :owner", Store.class);
		query.setParameter("name", name);
		query.setParameter("owner", owner);
		return query.getSingleResult();
	}

	@Override
	public List<Store> findByNameWithWildcard(String name) {
		log.info("Searching for store by name with wildcard: " + name);
		TypedQuery<Store> query = entityManager.createQuery("SELECT s FROM Store s WHERE s.name LIKE :name", Store.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public long countStoresByStatus(StoreStatus open) {
		log.info("Counting stores with status: " + open);
		TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(s) FROM Store s WHERE s.open = :status", Long.class);
		query.setParameter("status", open);
		Long count = query.getSingleResult();
		return count == null ? 0 : count;
	}

	@Override
	public List<Store> findStoresCreatedToday() {
		log.info("Searching for stores created today");
		TypedQuery<Store> query = entityManager.createQuery("SELECT s FROM Store s WHERE s.createDate > CURRENT_DATE AND s.createDate < CURRENT_DATE + 1", Store.class);
		return query.getResultList();
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
