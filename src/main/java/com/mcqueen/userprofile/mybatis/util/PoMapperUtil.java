package com.mcqueen.userprofile.mybatis.util;

import com.google.common.collect.Maps;
import com.mcqueen.userprofile.annotations.BusinessKey;
import com.mcqueen.userprofile.exception.UserProfileException;
import com.mcqueen.userprofile.mybatis.entity.BasePo;
import com.mcqueen.userprofile.mybatis.entity.PoColumnProp;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PoMapperUtil {
  
  private static Map<Class<? extends BasePo>, List<PoColumnProp>> columnMap = Maps.newConcurrentMap();

  /**
   * 根据@Table 注解获取表名
   * @param clazz
   * @return
   */
  public static String getTableName(final Class<? extends BasePo> clazz) {
    Table table = clazz.getAnnotation(Table.class);
    if (table != null) {
      return StringUtils.isEmpty(table.name()) ? clazz.getSimpleName() : table.name();
    } else {
      throw new UserProfileException("Undefined PO @Table, need Table name: " + clazz);
    }
  }

  /**
   * 根据@Id获取id
   * @param clazz
   * @return
   */
  public static PoColumnProp getId(final Class<? extends BasePo> clazz) {
    for (Field field : clazz.getDeclaredFields()) {
      if (field.isAnnotationPresent(Id.class)) {
        return new PoColumnProp(field);
      }
    }
    throw new UserProfileException("Undefine PO @Id: " + clazz);
  }

  /**
   * 根据@BusinessKey获取business key
   * @param clazz
   * @return
   */
  public static PoColumnProp getBusinessKey(Class<? extends BasePo> clazz) {
    for (Field field : clazz.getDeclaredFields()) {
      if (field.isAnnotationPresent(BusinessKey.class)) {
        return new PoColumnProp(field);
      }
    }
    throw new UserProfileException("Undefine PO @BusinessKey: " + clazz);
  }

  /**
   * 获取所有的列
   * @param clazz
   * @return
   */
  public static List<PoColumnProp> getColumnList(final Class<? extends BasePo> clazz) {
    if (columnMap.containsKey(clazz)) {
      return columnMap.get(clazz);
    }
    Field[] fields = clazz.getDeclaredFields();
    return Arrays.stream(fields).filter(field -> field.isAnnotationPresent(Column.class))
        .map(field -> new PoColumnProp(field)).collect(Collectors.toList());
  }
  
  public static String getSelectColumnNames(final Class<? extends BasePo> clazz) {
    return getColumnList(clazz).stream().map(PoColumnProp::getSelectStr).collect(Collectors.joining(","));
  }
  
}
