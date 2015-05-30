package edu.train.customer;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.train.GenericEntity;
import edu.train.address.Address;
import edu.train.name.Name;

@Entity
@Table(name="CUSTOMER_T")
@Data
@EqualsAndHashCode(callSuper=true)
public class Customer extends GenericEntity {

	@Id
	@Column(name="id")
	private int id;

	@Column(name="username")
	private String username;
	
	@Embedded
	private Name name;
	
	@Embedded
	private Address address;

}
