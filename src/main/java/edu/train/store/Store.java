package edu.train.store;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import edu.train.address.Address;

@Entity
@Table(name="STORE_T")
@IdClass(StorePK.class)
@Data
public class Store {
  
  public enum StoreStatus {OPEN, CLOSED}

  @Id
  private String name;
  
  @Id
  private String owner;
  
  @Column(name="WEBSITE")
  private String website;
  
  @Enumerated(EnumType.STRING)
  private StoreStatus open;
  
  @Embedded
  private Address address;

}
