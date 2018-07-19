package com.mcqueen.userprofile.mapper;

import com.mcqueen.userprofile.entity.UserProfilePo;
import com.mcqueen.userprofile.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserProfileMapper extends BaseMapper<UserProfilePo> {
}
