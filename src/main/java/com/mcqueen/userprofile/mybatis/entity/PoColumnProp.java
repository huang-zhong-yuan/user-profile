package com.mcqueen.userprofile.mybatis.entity;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import java.lang.reflect.Field;

@Data
public class PoColumnProp {
  private Field field;
  private String columnName;
  
  public PoColumnProp(final Field field) {
    String tmpColumnName = field.getAnnotation(Column.class).name();
    this.field = field;
    this.columnName = StringUtils.isEmpty(tmpColumnName) ? field.getName() : tmpColumnName;
  }
  
  public String getSelectStr() {
    return String.format("%s as %s", columnName, field.getName());
  }
  
  public String getValueSettingStr() {
    return String.format("%s=#{%s}", columnName, field.getName());
  }
  
  public String getValueDefineStr() {
    return String.format("#{%s}", field.getName());
  }
}
