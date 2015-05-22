package edu.train.transaction;

import java.math.BigDecimal;

import lombok.Data;

import org.springframework.stereotype.Component;

@Component
@Data
public class Bank {

  private String name = "First National";
  private String routingNumber = "183492239";
  
  public boolean transfer(BigDecimal amount) {
    return true;
  }
  
}
