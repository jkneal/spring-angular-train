package edu.train.customer;

import org.springframework.data.rest.core.config.Projection;

import edu.train.address.Address;
import edu.train.name.Name;

@Projection(name = "summary", types = Customer.class)
public interface CustomerSummary {

	String getUsername();
	
	Name getName();
	
	Address getAddress();

}
