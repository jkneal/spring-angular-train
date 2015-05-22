package edu.train.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
  
  @RequestMapping(method=RequestMethod.GET)
  public String getAllProducts(HttpServletRequest request) {
    request.setAttribute("method", "All Products");
    return "test-mappings";
  }
  
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String addProducts(HttpServletRequest request) {
    request.setAttribute("method", "Add Product");
    return "test-mappings";
  }
  
  @RequestMapping(value="/delete", method=RequestMethod.POST)
  public String deleteProduct(HttpServletRequest request) {
    request.setAttribute("method", "Delete Product");
    return "test-mappings";
  }
  
  @RequestMapping(value="/search", method=RequestMethod.GET)
  public String searchProducts(@RequestParam("searchTerm") String searchTerm,
                               @RequestParam(value="sortBy", defaultValue="name") String sortBy,
                               HttpServletRequest request) {
    request.setAttribute("searchTerm", searchTerm);
    request.setAttribute("sortBy", sortBy);
    request.setAttribute("method", "Search");
    return "test-mappings";
  }
  
  @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
  public String deleteProductById(@PathVariable String id, HttpServletRequest request) {
    request.setAttribute("id", id);
    request.setAttribute("method", "Delete Product By Id");
    return "test-mappings";
  }

}
