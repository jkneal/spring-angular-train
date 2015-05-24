package edu.train.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="PRODUCT_T")
@Data
public class Product {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="NAME")
  @Size(min=1, max=20, message="{error.maxSize}")
  private String name;
  
  @Column(name="DESCR")
  private String description;
  
  @Column(name="CATEGORY")
  private String category;
  
  @Column(name="PRICE", scale=2, precision=19)
  @NotNull(message="{error.required}")
  @Digits(integer=19, fraction=2, message="{error.maxDigits}")
  private BigDecimal price;
  
  @Column(name="QTY")
  private int quantity;

}
