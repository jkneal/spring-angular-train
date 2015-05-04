package edu.train.store;

import java.io.Serializable;

public class StorePK implements Serializable {
  private static final long serialVersionUID = 8198145542774035759L;
  
  private String name;
  private String owner;
  
  public StorePK() {
  }
  
  public StorePK(String name, String owner) {
    this.name = name;
    this.owner = owner;
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getOwner() {
    return owner;
  }
  
  public void setOwner(String owner) {
    this.owner = owner;
  }
  
}
