package edu.train.order;

import lombok.Data;
import edu.train.product.Product;

@Data
public class OrderDetail {
  
  private int id;
  private int quantity;
  private Product product;
  private Order order;
}
