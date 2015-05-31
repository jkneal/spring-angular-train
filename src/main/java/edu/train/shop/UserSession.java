package edu.train.shop;

public class UserSession {
  
  private String userName;
  
  public UserSession(String userName) {
    super();
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

}
