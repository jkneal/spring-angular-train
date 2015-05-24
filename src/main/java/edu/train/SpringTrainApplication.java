package edu.train;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import edu.train.shop.CurrencyFormatter;
import edu.train.transaction.CreditAuthorizer;

@SpringBootApplication
public class SpringTrainApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringTrainApplication.class, args);
  }

  @Bean
  public ServletRegistrationBean h2servletRegistration() {
    ServletRegistrationBean registration = new ServletRegistrationBean(
        new WebServlet());
    registration.addUrlMappings("/console/*");
    return registration;
  }
  
  @Bean
  public CreditAuthorizer creditOnline() {
    return new CreditAuthorizer("CreditOnline", "creditonline.com/authorize");
  }
  
  @Bean
  public CreditAuthorizer jimsCreditCheck() {
    return new CreditAuthorizer("JimsCreditCheck", "jimscreditcheck.com/authorize");
  }
  
  @Bean
  public CurrencyFormatter currencyFormatter() {
    return new CurrencyFormatter();
  }

}
