package com.mcqueen.userprofile.mybatis.provider;

import com.mcqueen.userprofile.entity.UserPo;
import com.mcqueen.userprofile.mybatis.util.PoMapperUtil;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class UserProvider extends BaseProvider<UserPo> {
  public String findAllUserByCompanyId() {
    Class cl = getSimpleType();
    List columnList = PoMapperUtil.getColumnList(cl);
    
    return new SQL() {
      {
        SELECT(PoMapperUtil.getSelectColumnNames(cl));
        FROM(PoMapperUtil.getTableName(cl));
        WHERE("company_id=#{companyId}");
      }
    }.toString();
  }

  public Class getSimpleType() {
    ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
    Class cl =  (Class)parameterizedType.getActualTypeArguments()[0];
    return cl;
  }
}
