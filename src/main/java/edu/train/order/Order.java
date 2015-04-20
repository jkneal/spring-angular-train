package edu.train.order;

import java.util.List;

import lombok.Data;
import edu.train.customer.Customer;

@Data
public class Order {

  private int id;
  private Customer customer;
  
  private List<OrderDetail> details;
}
