package edu.train.shop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.h2.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.train.category.Category;
import edu.train.category.CategoryRepository;
import edu.train.product.Product;
import edu.train.product.ProductRepository;
import edu.train.store.StoreRepository;

@Controller
@RequestMapping("/shop")
public class ShopController {
  
  private StoreRepository storeRepository;
  private ProductRepository productRepository;
  private CategoryRepository categoryRepository;
  
  @ModelAttribute("shoppingOptions")
  public List<String> shoppingOptions() {
     List<String> options = new ArrayList<String>();
     options.add("In Store");
     options.add("Online");
     options.add("Order");
     return options;
  }
  
  @ModelAttribute("categories")
  public Iterable<Category> categories() {
     return categoryRepository.findAll();
  }
  
  @RequestMapping(method=RequestMethod.GET)
  public String getAllProducts(HttpServletRequest request, Model model) {
    model.addAttribute("browsing", Boolean.valueOf(request.getParameter("browsing")));
    model.addAttribute("store", storeRepository.find("Joe's Sports Store", "Joe"));
    model.addAttribute("products", productRepository.findAll());
    return "shop/index";
  }
  
  @RequestMapping(value="/add", method=RequestMethod.GET)
  public String getAddProduct(Model model) {
    model.addAttribute("product", new Product());
    return "shop/add-product";
  }
  
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String addProduct(@Valid Product product, BindingResult result) {
    if (result.hasErrors()) {
      return "shop/add-product";
    }
    productRepository.save(product);
    return "redirect:/shop";
  }
  
  @RequestMapping(value="/newsletter", method=RequestMethod.GET)
  public void getNewsletter(HttpServletResponse httpServletResponse) {
    Resource resource = new ClassPathResource("public/newsletter.pdf");
    try {
      InputStream inputStream = resource.getInputStream();
      OutputStream outputStream = httpServletResponse.getOutputStream();
      IOUtils.copy(inputStream, outputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  
  @RequestMapping(value="/back", method=RequestMethod.GET)
  public String back() {
    return "redirect:/";
  }
  
  @RequestMapping(value="/products/{id}", method=RequestMethod.GET)
  public @ResponseBody Product getProduct(@PathVariable Integer id) {
    return productRepository.findOne(id);
  }
  
  @RequestMapping(value="/order", method=RequestMethod.GET)
  public String getOrder() {
    return "shop/order";
  }

  @Autowired
  public void setStoreRepository(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Autowired
  public void setCategoryRepository(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }
  
}