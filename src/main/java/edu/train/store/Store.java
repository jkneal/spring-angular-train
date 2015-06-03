package edu.train.store;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.validator.constraints.NotBlank;

import edu.train.GenericEntity;
import edu.train.address.Address;

@Entity
@Table(name="STORE_T")
@Data
@EqualsAndHashCode(callSuper=true)
@NamedQuery(name="findAllStores", query="SELECT s FROM Store s")
public class Store extends GenericEntity {
  
  public enum StoreStatus {OPEN, CLOSED}

  @Id
  @GeneratedValue
  private Integer id;
  
  @NotBlank(message = "The name must not be blank")
  @Size(min = 5, max = 40, message = "The store name must be between 5 and 40 characters in length")
  private String name;
  
  @NotBlank(message = "The owner must not be blank")
  @Size(min = 1, max = 40, message = "The store owner must be between 1 and 40 characters in length")
  private String owner;
  
  @Column(name="WEBSITE")
  @NotBlank(message = "The owner must not be blank")
  @Size(min = 1, max = 120, message = "The store owner must be between 1 and 120 characters in length")
  private String website;
  
  @Enumerated(EnumType.STRING)
  @NotNull(message = "The open status must not be null")
  private StoreStatus open;
  
  @Embedded
  @NotNull(message = "The store address must not be null")
  private Address address;

}
