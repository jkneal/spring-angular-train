package edu.train.order;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Table(name="ORDER_T")
@SequenceGenerator(name="ORDER_SEQ_GEN", sequenceName="ORDER_SEQ")
@Data
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ORDER_SEQ_GEN")
  private int id;
  
  @Column(name="TOTAL", scale=2, precision=19)
  private BigDecimal total;
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="CREATE_DT", nullable=false)
  private Date createDate;
  
  @Transient
  private int quantity;
  
  @Version
  private int version;

}
