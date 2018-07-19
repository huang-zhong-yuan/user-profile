package com.mcqueen.userprofile.controller;

import com.mcqueen.userprofile.domain.UserBo;
import com.mcqueen.userprofile.domain.UserInfoRequest;
import com.mcqueen.userprofile.domain.UserProfileResponse;
import com.mcqueen.userprofile.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserProfileController {  
  @Autowired
  private UserProfileService userProfileService;
  
  @RequestMapping("/")
  String home() {
    return "Hello World!";
  }
  
  @GetMapping(value = "/v1/users/{userName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public UserBo getUser(@PathVariable String userName) {
    return userProfileService.getUserByUserName(userName);
  }

  @GetMapping(value = "/v1/users-profiles/{userName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public UserProfileResponse getUserProfiles(@PathVariable String userName) {
    return userProfileService.getUserProfileByUserName(userName);
  }
  
  @PostMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public UserBo createUser(@RequestBody final UserBo user) {
    return userProfileService.createUser(user);
  }
  
  @PutMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void updateUser(@RequestBody final UserInfoRequest request) {
    userProfileService.updateUser(request);
  }

  @GetMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<UserBo> getUsers(@RequestParam final int companyId) {
    return userProfileService.getUsers(companyId);
  }
  
  @DeleteMapping(value = "/v1/users/{userName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteUser(@PathVariable final String userName) {
    userProfileService.deleteUser(userName);
  }
}
