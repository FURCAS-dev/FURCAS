/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedModelUtil {

  @SuppressWarnings("unchecked")
  public static <X> X getNestedValue(ModelData model, String property) {
    List<String> paths = Arrays.asList(property.split("\\."));
    return (X) getNestedValue(model, paths);
  }

  public static Object convertIfNecessary(Object obj) {
    if (obj instanceof BeanModelTag) {
      BeanModelFactory factory = BeanModelLookup.get().getFactory(obj.getClass());
      obj = factory.createModel(obj);
    }
    return obj;
  }

  @SuppressWarnings("unchecked")
  public static <X> X getNestedValue(ModelData model, List<String> paths) {
    if (paths.size() == 1) {
      Object obj = model.get(paths.get(0));
      obj = convertIfNecessary(obj);
      return (X) obj;
    } else {
      Object obj = model.get(paths.get(0));

      obj = convertIfNecessary(obj);

      if (obj != null && obj instanceof ModelData) {
        ArrayList<String> tmp = new ArrayList<String>(paths);
        tmp.remove(0);
        return (X) getNestedValue((ModelData) obj, tmp);
      }
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  public static <X> X setNestedValue(ModelData model, String property, Object value) {
    List<String> paths = Arrays.asList(property.split("\\."));
    return (X) setNestedValue(model, paths, value);
  }

  @SuppressWarnings("unchecked")
  public static <X> X setNestedValue(ModelData model, List<String> paths, Object value) {
    if (paths.size() == 1) {
      return (X) model.set(paths.get(0), value);
    } else {
      Object data = model.get(paths.get(0));
      if (data != null && data instanceof ModelData) {
        ArrayList<String> tmp = new ArrayList<String>(paths);
        tmp.remove(0);
        return (X) setNestedValue((ModelData) data, tmp, value);
      }
    }
    return null;
  }

  public static boolean isNestedProperty(String property) {
    return property.indexOf(".") != -1;
  }
}
