package edu.train.store;

import lombok.Data;
import edu.train.address.Address;

@Data
public class Store {

  private int id;
  private String name;
  private Address address;
  private boolean open;
}
