package edu.train.customer;

import lombok.Data;
import edu.train.address.Address;

@Data
public class Customer {

  private int id;
  private String firstName;
  private String lastName;
  private Address address;
}
