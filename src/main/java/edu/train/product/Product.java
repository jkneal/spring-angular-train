package edu.train.product;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class Product {
	
	private int id;
	private String name;
	private BigDecimal price;
	
	private List<Category> categories;

}
