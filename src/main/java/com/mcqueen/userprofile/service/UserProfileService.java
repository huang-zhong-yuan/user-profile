package com.mcqueen.userprofile.service;

import com.mcqueen.userprofile.domain.UserBo;
import com.mcqueen.userprofile.domain.UserInfoRequest;
import com.mcqueen.userprofile.domain.UserProfileResponse;

import java.util.List;

public interface UserProfileService {
  /**
   * 根据userName 查询用户基本信息
   * @param userName
   * @return
   */
  UserBo getUserByUserName(String userName);

  /**
   * 注册
   * @param user
   * @return
   */
  UserBo createUser(UserBo user);

  /**
   * 更新用户信息
   * @param request
   */
  void updateUser(UserInfoRequest request);

  /**
   * 删除用户
   * @param userName
   */
  void deleteUser(String userName);

  /**
   * 获取用户信息
   * @param userName
   * @return
   */
  UserProfileResponse getUserProfileByUserName(String userName);

  /**
   * 获取企业所有员工
   * @param companyId
   * @return
   */
  List<UserBo> getUsers(int companyId);
}
