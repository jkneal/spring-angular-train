package edu.train.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PRODUCT_T")
@Data
public class Product {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="NAME")
  private String name;
  
  @Column(name="DESCR")
  private String description;
  
  @Column(name="CATEGORY")
  private String category;
  
  @Column(name="PRICE", scale=2, precision=19)
  private BigDecimal price;
  
  @Column(name="QTY")
  private int quantity;

}
