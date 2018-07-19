package com.mcqueen.userprofile.repo;

import com.mcqueen.userprofile.entity.UserPo;
import com.mcqueen.userprofile.entity.UserProfilePo;
import com.mcqueen.userprofile.exception.UserProfileException;
import com.mcqueen.userprofile.mapper.UserMapper;
import com.mcqueen.userprofile.mapper.UserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class UserRepo {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserProfileMapper userProfileMapper;
  
  public UserPo getUserByUserName(String userName) {
    UserPo userPo = userMapper.findById(userName, UserPo.class);
    if (Objects.isNull(userPo)) {
      throw new UserProfileException("Cannot find user with userName: " + userName);
    }
    return userPo;
  }
  
  public UserProfilePo getUserProfileById(int userId) {
    return userProfileMapper.findById(userId, UserProfilePo.class);
  }
  
}
