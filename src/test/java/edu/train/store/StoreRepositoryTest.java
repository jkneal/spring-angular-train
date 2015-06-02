package edu.train.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.train.SpringTrainApplication;
import edu.train.address.Address;
import edu.train.store.Store.StoreStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTrainApplication.class)
@WebAppConfiguration
@Transactional
public class StoreRepositoryTest {

	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private EntityManager entityManager;

	@Test
	public void testFind() {
		assertNotNull(storeRepository.find(1));
	}

	@Test
	public void testCreate() {
		Store savedStore = storeRepository.save(buildFakeStore());
		assertNotNull(storeRepository.find(savedStore.getId()));
	}

	@Test
	public void testUpdate() {
		Store savedStore = storeRepository.save(buildFakeStore());

		// Now create a detached copy of the entity with the same ID and make some modifications
		Store updatedStore = buildFakeStore();
		updatedStore.setId(savedStore.getId());
		updatedStore.setOwner("New Tester");
		storeRepository.save(updatedStore);

		assertEquals(updatedStore.getOwner(), storeRepository.find(updatedStore.getId()).getOwner());
	}

	@Test
	public void testUpdateDetachedEntity() {
		Store savedStore = storeRepository.save(buildFakeStore());

		// This time use the entity manager to manually detach an entity and attempt to save a modification
		entityManager.detach(savedStore);
		savedStore.setOwner("New Tester");
		storeRepository.save(savedStore);

		assertEquals(savedStore.getOwner(), storeRepository.find(savedStore.getId()).getOwner());
	}

	@Test
	public void testDelete() {
		Store savedStore = storeRepository.save(buildFakeStore());
		storeRepository.delete(savedStore);
		assertNull(storeRepository.find(savedStore.getId()));
	}

	@Test
	public void testRefresh() {
		Store testStore = buildFakeStore();
		Store savedStore = storeRepository.save(buildFakeStore());
		savedStore.setOwner("New Tester");
		entityManager.refresh(savedStore);
		assertEquals(testStore.getOwner(), savedStore.getOwner());
	}

	@Test
	public void testRefreshAfterFlush() {
		Store testStore = buildFakeStore();
		Store savedStore = storeRepository.save(buildFakeStore());
		savedStore.setOwner("New Tester");
		// Trigger a manual flush of the entity manager which automatically saves the change since the object is attached to the entity manager
		entityManager.flush();
		entityManager.refresh(savedStore);
		// The value in the database and the original value are no longer the same
		assertFalse(testStore.getOwner().equals(savedStore.getOwner()));
	}

	@Test
	public void testCreationDateSet() {
		Store savedStore = storeRepository.save(buildFakeStore());
		assertNotNull(savedStore.getCreateDate());
	}

	@Test
	public void testLastUpdateDate() {
		Store savedStore = storeRepository.save(buildFakeStore());
		Date initialUpdateDate = savedStore.getLastUpdateDate();
		savedStore.setOwner("New Tester");
		savedStore = storeRepository.save(savedStore);
		entityManager.flush();
		assertTrue(initialUpdateDate.compareTo(savedStore.getLastUpdateDate()) < 0);
	}

	private Store buildFakeStore() {
		Address address = new Address();
		address.setLine1("1234 Test St");
		address.setCity("Testing City");
		address.setState("TDD");
		address.setPostalCode("12345");

		Store store = new Store();
		store.setName("Test Store");
		store.setOwner("Tester");
		store.setOpen(StoreStatus.OPEN);
		store.setWebsite("http://test-store.com");
		store.setAddress(address);
		return store;
	}
}
