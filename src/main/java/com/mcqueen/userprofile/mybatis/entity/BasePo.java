package com.mcqueen.userprofile.mybatis.entity;

import com.mcqueen.userprofile.exception.UserProfileException;
import com.mcqueen.userprofile.mybatis.util.PoMapperUtil;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

@Data
public class BasePo implements Serializable {

  private static final long serialVersionUID = 3590914009331894130L;
  
  public String tableName() {
    return PoMapperUtil.getTableName(this.getClass());
  }
  
  public PoColumnProp id() {
    return PoMapperUtil.getId(this.getClass());
  }
  
  public PoColumnProp businessKey() {
    return PoMapperUtil.getBusinessKey(this.getClass());
  }
  
  public List<PoColumnProp> getColumnList() {
    return PoMapperUtil.getColumnList(this.getClass());
  }
  
  public String selectColumnNames() {
    return PoMapperUtil.getSelectColumnNames(this.getClass());
  }
  
  public boolean isNull(final String fieldName) {
    try {
      Field field = this.getClass().getField(fieldName);
      return isNull(field);
    } catch (final NoSuchFieldException e) {
      throw new UserProfileException("No such field: " + fieldName);
    }
  }

  public boolean isNull(final Field field) {
    field.setAccessible(true);
    try {
      return field.get(this) == null;
    } catch (IllegalAccessException e) {
      throw new UserProfileException("Failed to read field: " + field.getName());
    }
  }
}
