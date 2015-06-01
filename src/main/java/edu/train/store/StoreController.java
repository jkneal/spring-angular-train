package edu.train.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
public class StoreController {
  
  private StoreRepository storeRepository;
  
  @RequestMapping(value="/{name}/{owner}", method=RequestMethod.GET)
  public Store getStore(@PathVariable String name, @PathVariable String owner) {
    return storeRepository.findByNameAndOwner(name, owner);
  }
  
  @Autowired
  public void setStoreRepository(StoreRepository storeRepository){
    this.storeRepository = storeRepository;
  }
  
}
