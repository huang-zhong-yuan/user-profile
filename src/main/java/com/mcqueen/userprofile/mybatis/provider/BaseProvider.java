package com.mcqueen.userprofile.mybatis.provider;

import com.mcqueen.userprofile.mybatis.entity.BasePo;
import com.mcqueen.userprofile.mybatis.entity.PoColumnProp;
import com.mcqueen.userprofile.mybatis.util.PoMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import javax.persistence.Table;
import java.util.List;

@Slf4j
public class BaseProvider<T extends BasePo> {
  
  public String findFirst(final T obj) {
    final List<PoColumnProp> columnList = obj.getColumnList();
    
    return new SQL() {
      {
        SELECT(obj.selectColumnNames());
        FROM(obj.tableName());
        for (PoColumnProp columnProp : columnList) {
          if (!obj.isNull(columnProp.getField())) {
            WHERE(columnProp.getValueSettingStr());
          }
        }
      }
    }.toString();
  }
  
  public <E> String findById(final E id, final Class<T> clazz) {
    final String columnNames = PoMapperUtil.getSelectColumnNames(clazz);
    final String tableName = clazz.getAnnotation(Table.class).name();
    PoColumnProp idColumn = PoMapperUtil.getId(clazz);
    return new SQL() {
      {
        SELECT(columnNames);
        FROM(tableName);
        WHERE(idColumn.getColumnName() + "=#{id}");
      }
    }.toString();
  }
  
  public <E> String findByBusinessKey(final E businessKey, final Class<T> clazz) {
    final String columnNames = PoMapperUtil.getSelectColumnNames(clazz);
    final String tableName = clazz.getAnnotation(Table.class).name();
    PoColumnProp businessKeyColumn = PoMapperUtil.getBusinessKey(clazz);
    return new SQL() {
      {
        SELECT(columnNames);
        FROM(tableName);
        WHERE(businessKeyColumn.getColumnName() + "=#{businessKey}");
      }
    }.toString();
  }
  
  public String insert(final T obj) {
    final List<PoColumnProp> columnList = obj.getColumnList();
    return new SQL() {
      {
        INSERT_INTO(obj.tableName());
        for (PoColumnProp columnProp : columnList) {
          VALUES(columnProp.getColumnName(), columnProp.getValueDefineStr());
        }
      }
    }.toString();
  }
  
  public String update(final T obj) {
    PoColumnProp id = obj.id();
    List<PoColumnProp> columnList = obj.getColumnList();
    
    return new SQL() {
      {
        UPDATE(obj.tableName());
        for (PoColumnProp poColumnProp : columnList) {
          if (!obj.isNull(poColumnProp.getField())) {
            SET(poColumnProp.getValueSettingStr());
          }
        }
        WHERE(id.getValueSettingStr());
      }
    }.toString();
  }
  
  public String delete(final T obj) {
    PoColumnProp id = obj.id();
    
    return new SQL() {
      {
        DELETE_FROM(obj.tableName());
        WHERE(id.getValueSettingStr());
      }
    }.toString();
  }
}
