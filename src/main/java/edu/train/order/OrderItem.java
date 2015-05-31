package edu.train.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.train.GenericEntity;

@Entity
@Table(name="ORDER_ITEM_T")
@Data
@EqualsAndHashCode(callSuper=true)
public class OrderItem extends GenericEntity {

	@Id
	private int id;
	
	@Column(name = "QTY")
	private int quantity;
	
}
