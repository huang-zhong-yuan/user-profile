package com.mcqueen.userprofile.exception;

//import com.netflix.hystrix.exception.HystrixBadRequestException;

public class UserProfileException extends RuntimeException{// extends HystrixBadRequestException {
  
  public UserProfileException(String message) {
    super(message);
  }
}
