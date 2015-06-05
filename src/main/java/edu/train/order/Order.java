package edu.train.order;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.train.GenericEntity;
import edu.train.customer.Customer;

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
  
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="CUSTOMER_FK", referencedColumnName="ID")
  private Customer customer;
  
  @OneToMany(mappedBy="order")
  private List<OrderItem> orderItems;

}
