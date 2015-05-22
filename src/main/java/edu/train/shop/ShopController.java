package edu.train.shop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.h2.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.train.product.ProductRepository;
import edu.train.store.StoreRepository;

@Controller
@RequestMapping("/shop")
public class ShopController {
  
  private StoreRepository storeRepository;
  private ProductRepository productRepository;
  
  @ModelAttribute("shoppingOptions")
  public List<String> shoppingOptions() {
     List<String> options = new ArrayList<String>();
     options.add("In Store");
     options.add("Online");
     options.add("Order");
     return options;
  }

  @RequestMapping(method=RequestMethod.GET)
  public String getAllProducts(Model model) {
    model.addAttribute("store", storeRepository.find("Joe's Sports Store", "Joe"));
    model.addAttribute("products", productRepository.findAll());
    return "shop";
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

  @Autowired
  public void setStoreRepository(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
  
}
