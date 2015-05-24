package edu.train.address;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data 
@Embeddable
public class Address {

  @Column(name="ADDR_LINE1")
  private String line1;
  
  @Column(name="ADDR_CITY")
  private String city;
  
  @Column(name="ADDR_ST")
  private String state;
  
  @Column(name="ADDR_POST_CD")
  private String postalCode;
  
  public String getFullAddress() {
    return String.format("%s %s, %s %s", line1, city, state, postalCode);
  }
}
