package edu.train.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_T")
@SequenceGenerator(name="ORDER_SEQ_GEN", sequenceName="ORDER_SEQ")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ORDER_SEQ_GEN")
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
}
