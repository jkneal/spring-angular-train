package edu.train.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.train.transaction.Bank;
import edu.train.transaction.CreditAuthorizer;

@Component
public class OrderServiceImpl implements OrderService {
  
  private Bank bank;
  private CreditAuthorizer creditAuthorizer;

  @Override
  public boolean completeOrder(Order order) {
    if (creditAuthorizer.isAuthorized(order.getCustomer().getName(), order.getCustomer().getCardNumber())) {
      return bank.transfer(order.getTotal());
    }
    return false;
  }

  @Autowired
  public void setBank(Bank bank) {
    this.bank = bank;
  }

  @Autowired
  @Qualifier("creditOnline")
  public void setCreditAuthorizer(CreditAuthorizer creditAuthorizer) {
    this.creditAuthorizer = creditAuthorizer;
  }

}
