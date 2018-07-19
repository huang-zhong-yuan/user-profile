package com.mcqueen.userprofile.mapper;

import com.mcqueen.userprofile.entity.UserPo;
import com.mcqueen.userprofile.mybatis.mapper.BaseMapper;
import com.mcqueen.userprofile.mybatis.provider.UserProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserPo> {
  
  @SelectProvider(type = UserProvider.class, method = "findAllUserByCompanyId")
  List<UserPo> findAllUserByCompanyId(int companyId);
}
