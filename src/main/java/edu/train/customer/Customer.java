package edu.train.customer;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CUSTOMER_T")
@Data
public class Customer {

	@Id
	@Column(name="id")
	private int id;

	@Column(name="username")
	private String username;
	
	@Embedded
	private Name name;

}
