package edu.train.product;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.train.BooleanToStringAttributeConverter;
import edu.train.GenericEntity;

@Entity
@Table(name="PRODUCT_T")
@Data
@EqualsAndHashCode(callSuper=true)
public class Product extends GenericEntity {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="NAME")
  private String name;
  
  @Column(name="QTY")
  private int quantity;
  
  @Column(name="BACKORDER_AVAILABLE")
  @Convert(converter = BooleanToStringAttributeConverter.class)
  private boolean backorderAvailable;

}
