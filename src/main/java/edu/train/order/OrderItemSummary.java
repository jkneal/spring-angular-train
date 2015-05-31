package edu.train.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "summary", types = OrderItem.class)
public interface OrderItemSummary {

	int getQuantity();
	
	@Value("#{target.product?.name}")
	String getProductName();
	
}
