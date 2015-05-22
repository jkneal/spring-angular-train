package edu.train.transaction;

import lombok.Data;

@Data
public class CreditAuthorizer {
  
  private String name;
  private String authorizeEndpoint;
  
  public CreditAuthorizer(String name, String authorizeEndpoint) {
    super();
    this.name = name;
    this.authorizeEndpoint = authorizeEndpoint;
  }
  
  public boolean isAuthorized(String cardNumber, String customerName) {
    return ("CreditOnline".equals(name)) ? true : false;
  }

}
