package edu.train.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

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
	public void testFindAll() {
		List<Store> allStores = storeRepository.findAll();
		assertTrue(allStores.size() > 1);
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
	public void testLastUpdateDate() throws InterruptedException {
		Store savedStore = storeRepository.save(buildFakeStore());
		Date initialUpdateDate = savedStore.getLastUpdateDate();
		savedStore.setOwner("New Tester");

		// Sleep to make sure the timestamps are different
		Thread.sleep(10L);
		savedStore = storeRepository.save(savedStore);
		entityManager.flush();
		assertTrue(initialUpdateDate.compareTo(savedStore.getLastUpdateDate()) < 0);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testNameCannotBeNull() {
		Store newStore = buildFakeStore();
		newStore.setName(null);
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testNameCannotBeEmpty() {
		Store newStore = buildFakeStore();
		newStore.setName("");
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testNameCannotBeBlank() {
		Store newStore = buildFakeStore();
		newStore.setName(" ");
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testNameCannotBeTooShort() {
		Store newStore = buildFakeStore();
		newStore.setName("1");
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testNameCannotBeTooLong() {
		Store newStore = buildFakeStore();
		newStore.setName("12345678901234567890123456789012345678901");
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testOwnerCannotBeNull() {
		Store newStore = buildFakeStore();
		newStore.setOwner(null);
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testOwnerCannotBeEmpty() {
		Store newStore = buildFakeStore();
		newStore.setOwner("");
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testOwnerCannotBeBlank() {
		Store newStore = buildFakeStore();
		newStore.setOwner(" ");
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testOwnerCannotBeTooLong() {
		Store newStore = buildFakeStore();
		newStore.setOwner("12345678901234567890123456789012345678901");
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testWebsiteCannotBeNull() {
		Store newStore = buildFakeStore();
		newStore.setWebsite(null);
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testWebsiteCannotBeEmpty() {
		Store newStore = buildFakeStore();
		newStore.setWebsite("");
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testWebsiteCannotBeBlank() {
		Store newStore = buildFakeStore();
		newStore.setWebsite(" ");
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testWebsiteCannotBeTooLong() {
		Store newStore = buildFakeStore();
		newStore.setWebsite("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testOpenCannotBeNull() {
		Store newStore = buildFakeStore();
		newStore.setOpen(null);
		storeRepository.save(newStore);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testAddressCannotBeNull() {
		Store newStore = buildFakeStore();
		newStore.setAddress(null);
		storeRepository.save(newStore);
	}
	
	@Test
	public void testFindByNameWithWildcard() {
		List<Store> storesByWildcard = storeRepository.findByNameWithWildcard("Joe%");
		assertEquals(1, storesByWildcard.size());
	}
	
	@Test
	public void testFindByNameWithWildcardMatchAll() {
		List<Store> allStores = storeRepository.findAll();
		List<Store> storesByWildcard = storeRepository.findByNameWithWildcard("%");
		assertEquals(allStores.size(), storesByWildcard.size());
	}
	
	@Test
	public void testFindByNameAndOwner() {
		Store joesSportsStore = storeRepository.findByNameAndOwner("Joe's Sports Store", "Joe");
		assertNotNull(joesSportsStore);
	}
	
	@Test
	public void testCountStoresByStatus() {
		List<Store> allStores = storeRepository.findAll();
		long openStoreCount = storeRepository.countStoresByStatus(StoreStatus.OPEN);
		long closedStoreCount = storeRepository.countStoresByStatus(StoreStatus.CLOSED);
		assertEquals(allStores.size(), openStoreCount + closedStoreCount);
	}
	
	@Test
	public void testFindStoresCreatedToday() {
		List<Store> storesCreatedToday = storeRepository.findStoresCreatedToday();
		assertEquals(1, storesCreatedToday.size());
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
