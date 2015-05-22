package edu.train.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.train.customer.Customer;

@RestController
@RequestMapping("/orders")
public class OrderController {
  
  private OrderService orderService;
  
  @RequestMapping(value="/test", method=RequestMethod.GET)
  public String testCompleteOrder() {
    Order order = new Order();
    order.setId(311);
    Customer customer = new Customer();
    customer.setName("John");
    customer.setCardNumber("1321421421");
    order.setCustomer(customer);
    
    boolean orderCompleted = orderService.completeOrder(order);
    return orderCompleted ? "Order completed successfully!" : "Order failed";
  }

  @Autowired
  public void setOrderService(OrderService orderService) {
    this.orderService = orderService;
  }
  
}
