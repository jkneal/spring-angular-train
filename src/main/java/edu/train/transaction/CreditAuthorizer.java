package edu.train.transaction;

import lombok.Data;
import edu.train.name.Name;

@Data
public class CreditAuthorizer {
  
  private Name name;
  private String authorizeEndpoint;
  
  public CreditAuthorizer(Name name, String authorizeEndpoint) {
    super();
    this.name = name;
    this.authorizeEndpoint = authorizeEndpoint;
  }
  
  public boolean isAuthorized(String cardNumber, String customerName) {
    return ("CreditOnline".equals(name)) ? true : false;
  }

}
