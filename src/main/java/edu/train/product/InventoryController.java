package edu.train.product;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
  protected final Log logger = LogFactory.getLog(getClass());
  
  private ProductRepository productRepository;
  
  @RequestMapping(method=RequestMethod.GET)
  public Iterable<Product> getAllProducts() {
    return productRepository.findAll();
  }
  
  @RequestMapping(value="/add", method=RequestMethod.PUT)
  public Iterable<Product> addProducts(@RequestBody Product product) {
    productRepository.save(product);
    return productRepository.findAll();
  }
  
  @RequestMapping(value="/search", method=RequestMethod.GET)
  public Iterable<Product> searchProducts(@RequestParam("searchTerm") String searchTerm,
                               @RequestParam(value="sortBy", defaultValue="name") String sortBy) {
    return productRepository.findByNameMatching(searchTerm, new Sort(sortBy));
  }
  
  @RequestMapping(value="/{index}", method=RequestMethod.DELETE)
  public Iterable<Product> deleteProductByIndex(@PathVariable Integer index) {
    List<Product> products = (List<Product>) productRepository.findAll();
    Product productToDelete = products.remove(index.intValue());
    productRepository.delete(productToDelete);
    return products;
  }
  
  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

}
