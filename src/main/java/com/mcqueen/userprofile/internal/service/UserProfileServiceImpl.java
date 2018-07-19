package com.mcqueen.userprofile.internal.service;

import com.mcqueen.userprofile.domain.UserBo;
import com.mcqueen.userprofile.domain.UserInfoRequest;
import com.mcqueen.userprofile.domain.UserProfileResponse;
import com.mcqueen.userprofile.entity.UserPo;
import com.mcqueen.userprofile.entity.UserProfilePo;
import com.mcqueen.userprofile.enums.UserStatus;
import com.mcqueen.userprofile.mapper.UserMapper;
import com.mcqueen.userprofile.mapper.UserProfileMapper;
import com.mcqueen.userprofile.repo.UserRepo;
import com.mcqueen.userprofile.service.UserProfileService;
import com.mcqueen.userprofile.util.DozerBeanMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserRepo userRepo;
  @Autowired
  private UserProfileMapper userProfileMapper;
  
  @Override
  public UserBo getUserByUserName(String userName) {
    UserPo userPo = userRepo.getUserByUserName(userName);
    return DozerBeanMapperUtil.map(userPo, UserBo.class);
  }

  @Override
  public UserBo createUser(UserBo user) {
    UserPo userPo = userMapper.findById(user.getUserName(), UserPo.class);
    if (Objects.isNull(userPo)) {
      userPo = DozerBeanMapperUtil.map(user, UserPo.class);
      userMapper.insert(userPo);
      userPo = userRepo.getUserByUserName(user.getUserName());
    }
    return DozerBeanMapperUtil.map(userPo, UserBo.class);
  }

  @Override
  public void updateUser(UserInfoRequest request) {
    UserPo userPo = userRepo.getUserByUserName(request.getUserName());
    DozerBeanMapperUtil.copy(request, userPo);
    userMapper.update(userPo);
    UserProfilePo userProfilePo = userProfileMapper.findById(userPo.getId(), UserProfilePo.class);
    if (!Objects.isNull(userProfilePo)) {
      DozerBeanMapperUtil.copy(request, userProfilePo);
      userProfileMapper.update(userProfilePo);
    } else {
      userProfilePo = DozerBeanMapperUtil.map(request, UserProfilePo.class);
      userProfilePo.setUserId(userPo.getId());
      userProfileMapper.insert(userProfilePo);
    }
  }

  @Override
  public void deleteUser(String userName) {
    UserPo userPo = userRepo.getUserByUserName(userName);
    userPo.setStatus(UserStatus.DELETED.ordinal());
    userMapper.update(userPo);
  }

  @Override
  public UserProfileResponse getUserProfileByUserName(String userName) {
    UserPo userPo = userRepo.getUserByUserName(userName);
    UserProfileResponse response = DozerBeanMapperUtil.map(userPo, UserProfileResponse.class);
    UserProfilePo userProfile = userRepo.getUserProfileById(userPo.getId());
    if (!Objects.isNull(userProfile)) {
      DozerBeanMapperUtil.copy(userProfile, response);
    }
    response.setUserCreateDate(userPo.getCreateDate());
    response.setUserLastUpdatedDate(userPo.getLastUpdatedDate());
    return response;
  }

  @Override
  public List<UserBo> getUsers(int companyId) {
    List<UserPo> userPos = userMapper.findAllUserByCompanyId(companyId);
    List<UserBo> userBos = userPos.stream().map(userPo -> DozerBeanMapperUtil.map(userPo, UserBo.class)).collect(Collectors.toList());
    return userBos;
  }
}
