package edu.train.transaction;

import lombok.Data;
import edu.train.name.Name;

@Data
public class CreditAuthorizer {
  
  private String name;
  private String authorizeEndpoint;
  
  public CreditAuthorizer(String name, String authorizeEndpoint) {
    super();
    this.name = name;
    this.authorizeEndpoint = authorizeEndpoint;
  }
  
  public boolean isAuthorized(Name customerName, String cardNumber) {
    return ("CreditOnline".equals(name)) ? true : false;
  }

}
