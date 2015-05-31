package edu.train.order;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import edu.train.customer.Customer;

@Projection(name = "summary", types = Order.class)
public interface OrderSummary {

	BigDecimal getTotal();
	
	List<OrderItemSummary> getOrderItems();
	
	Customer getCustomer();
}
