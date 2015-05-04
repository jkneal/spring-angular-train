package edu.train.store;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

@Repository
public class JpaStoreRepository implements StoreRepository {
  private Log log = LogFactory.getLog(JpaStoreRepository.class);
  
  @PersistenceContext
  private EntityManager em;
  
  public Store find(String name, String owner) {
    StorePK pk = new StorePK(name, owner);
    return em.find(Store.class, pk);
  }

}
