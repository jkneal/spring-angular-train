package edu.train.store;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.train.GenericEntity;
import edu.train.address.Address;

@Entity
@Table(name="STORE_T")
@Data
@EqualsAndHashCode(callSuper=true)
public class Store extends GenericEntity {
  
  public enum StoreStatus {OPEN, CLOSED}

  @Id
  @GeneratedValue
  private Integer id;
  
  private String name;
  
  private String owner;
  
  @Column(name="WEBSITE")
  private String website;
  
  @Enumerated(EnumType.STRING)
  private StoreStatus open;
  
  @Embedded
  private Address address;

}
