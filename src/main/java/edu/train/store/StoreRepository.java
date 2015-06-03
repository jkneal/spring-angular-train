package edu.train.store;

import java.util.List;

import edu.train.store.Store.StoreStatus;


public interface StoreRepository {

  Store find(int id);
  
  Store findByNameAndOwner(String name, String owner);
  
  List<Store> findAll();
  
  List<Store> findByNameWithWildcard(String name);
  
  long countStoresByStatus(StoreStatus open);
  
  List<Store> findStoresCreatedToday();
  
  Store save(Store store);
  
  void delete(Store store);
  
}
