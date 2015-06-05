package edu.train.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.train.BooleanToStringConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.train.GenericEntity;

@Entity
@Table(name="PRODUCT_T")
@Data
@EqualsAndHashCode(callSuper=true)
public class Product extends GenericEntity {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="NAME", nullable=false)
  private String name;

  @Column(name="DESCR")
  private String description;
  
  @Column(name="CATEGORY")
  private String category;
  
  @Column(name="PRICE", scale=2, precision=19)
  private BigDecimal price;
  
  @Column(name="QTY", nullable=false)
  private int quantity;
  
  @Column(name="BACKORDER_AVAILABLE")
  @Convert(converter = BooleanToStringConverter.class)
  private boolean backorderAvailable;

}
