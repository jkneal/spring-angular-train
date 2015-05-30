package edu.train.customer;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Customer {

	@Id
	private int id;

	private String username;
	
	
}
