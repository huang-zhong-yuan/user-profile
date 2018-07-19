package com.mcqueen.userprofile.mybatis.mapper;

import com.mcqueen.userprofile.mybatis.entity.BasePo;
import com.mcqueen.userprofile.mybatis.provider.BaseProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface BaseMapper<T extends BasePo> {
  @SelectProvider(type = BaseProvider.class, method = "findFirst")
  T findFirst(T obj);
  
  @SelectProvider(type = BaseProvider.class, method = "findById")
  <M> T findById(@Param("id") M id, Class<T> clazz);
  
  @SelectProvider(type = BaseProvider.class, method = "findByBusinessKey")
  <M> T findByBusinessKey(@Param("businessKey") M businessKey, Class<T> clazz);
  
  @InsertProvider(type = BaseProvider.class, method = "insert")
  int insert(T obj);
  
  @UpdateProvider(type = BaseProvider.class, method = "update")
  int update(T obj);
  
  @DeleteProvider(type = BaseProvider.class, method = "delete")
  int delete(T obj);
}
