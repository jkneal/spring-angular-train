package edu.train.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import edu.train.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="STORE_T")
@IdClass(StorePK.class)
@Data
@EqualsAndHashCode(callSuper=true)
public class Store extends GenericEntity {
  
  public enum StoreStatus {OPEN, CLOSED}

  @Id
  private String name;
  
  @Id
  private String owner;
  
  @Column(name="WEBSITE")
  private String website;
  
  @Enumerated(EnumType.STRING)
  private StoreStatus open;

}
