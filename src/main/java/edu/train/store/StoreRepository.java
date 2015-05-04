package edu.train.store;

public interface StoreRepository {

  public Store find(String name, String owner);
  
}
