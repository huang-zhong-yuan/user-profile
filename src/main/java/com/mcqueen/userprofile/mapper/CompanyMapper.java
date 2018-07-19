package com.mcqueen.userprofile.mapper;

import com.mcqueen.userprofile.entity.CompanyPo;
import com.mcqueen.userprofile.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper extends BaseMapper<CompanyPo> {
}
