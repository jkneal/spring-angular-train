package edu.train.product;

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
  
  @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  public void deleteProductById(@PathVariable Integer id) {
    Product product = productRepository.findOne(id);
    if (product == null) {
      throw new ProductNotFoundException();
    }
    productRepository.delete(id);
  }
  
  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

}
