package edu.train;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
  
  @ExceptionHandler(AccessException.class)
  public String handleAccessException() {
    return "access-error";
  }
}
