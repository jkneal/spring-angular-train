package edu.train.store;

import java.util.List;


public interface StoreRepository {

  Store find(int id);
  
  Store findByNameAndOwner(String name, String owner);
  
  List<Store> findAll();
  
  Store save(Store store);
  
  void delete(Store store);
  
}
