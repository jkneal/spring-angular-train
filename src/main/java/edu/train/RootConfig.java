package edu.train;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.train.transaction.CreditAuthorizer;

@Configuration
@ComponentScan("edu.train")
public class RootConfig {

  @Bean
  public CreditAuthorizer creditOnline() {
    return new CreditAuthorizer("CreditOnline", "creditonline.com/authorize");
  }
  
  @Bean
  public CreditAuthorizer jimsCreditCheck() {
    return new CreditAuthorizer("JimsCreditCheck", "jimscreditcheck.com/authorize");
  }
}
