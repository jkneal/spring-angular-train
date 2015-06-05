package edu.train.customer;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import edu.train.address.Address;
import edu.train.name.Name;

@Entity
@Table(name="CUSTOMER_T")
@Data
public class Customer {

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

}
