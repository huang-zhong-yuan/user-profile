package com.mcqueen.userprofile.util;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DozerBeanMapperUtil {
  
  private static DozerBeanMapper dozer = new DozerBeanMapper();
  
  static {
    dozer.setCustomFieldMapper(
        (source, destination, sourceFieldValue, classMap, fieldMapping) -> sourceFieldValue == null);
  }
  
  public static <T> T map(final Object source, final Class<T> destinationClass) {
    if (source == null) {
      return null;
    }
    T destinationObject = null;
    try {
      destinationObject = destinationClass.newInstance();
    } catch (Exception e) {
      throw new IllegalArgumentException("Cannot create new instance + " + destinationClass);
    }
    dozer.map(source, destinationObject);
    return destinationObject;
  }
  
  public static <T> List<T> mapList(final Collection<? extends Object> sourceList, final Class<T> destinationClass) {
    if (CollectionUtils.isEmpty(sourceList)) {
      return Collections.emptyList();
    }
    List<T> destinationList = Lists.newArrayList();
    for (Object sourceObject : sourceList) {
      T destinationObject = null;
      try {
        destinationObject = destinationClass.newInstance();
      } catch (Exception e) {
        throw new IllegalArgumentException("Cannot create new instance + " + destinationClass);
      }
      dozer.map(sourceObject, destinationObject);
      destinationList.add(destinationObject);
    }
    return destinationList;
  }
  
  public static void copy(final Object source, final Object destinationObject) {
    dozer.map(source, destinationObject);
  }
}
