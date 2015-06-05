package edu.train.order;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.train.GenericEntity;

@Entity
@Table(name="ORDER_T")
@SequenceGenerator(name="ORDER_SEQ_GEN", sequenceName="ORDER_SEQ")
@Data
@EqualsAndHashCode(callSuper=true)
public class Order extends GenericEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ORDER_SEQ_GEN")
  private int id;
  
  @Column(name="TOTAL", scale=2, precision=19)
  private BigDecimal total;
  
  @Transient
  private int quantity;
  
  @Version
  private int version;

}
