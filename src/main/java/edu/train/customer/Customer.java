package edu.train.customer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.train.GenericEntity;
import edu.train.order.Order;
import edu.train.address.Address;
import edu.train.name.Name;

@Entity
@Table(name="CUSTOMER_T")
@Data
@EqualsAndHashCode(callSuper=true)
public class Customer extends GenericEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="username")
	private String username;

	@Column(name="CARD_NBR")
	private String cardNumber;
	
	@Embedded
	private Name name;
	
	@Embedded
	private Address address;

  @OneToMany(mappedBy="customer")
  private List<Order> orders;
  
}
