package edu.train.product;

import javax.servlet.http.HttpServletRequest;

public class InventoryController {
  
  public String getAllProducts(HttpServletRequest request) {
    request.setAttribute("method", "All Products");
    return "test-mappings";
  }

  public String addProducts(HttpServletRequest request) {
    request.setAttribute("method", "Add Product");
    return "test-mappings";
  }
  
  public String deleteProduct(HttpServletRequest request) {
    request.setAttribute("method", "Delete Product");
    return "test-mappings";
  }

}
