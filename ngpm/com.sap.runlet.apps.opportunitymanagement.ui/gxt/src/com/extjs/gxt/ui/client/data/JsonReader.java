/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

/**
 * A <code>DataReader</code> implementation that reads JSON data using a
 * <code>ModelType</code> definition and produces a set of
 * <code>ModelData</code> instances.
 * 
 * <p />
 * Subclasses can override {@link #createReturnData(Object, List, int)} to
 * control what object is returned by the reader. Subclass may override
 * {@link #newModelInstance()} to return any model data subclass.
 * 
 * @param <D> the <code>ListLoadResult</code> type being returned by the reader
 */
public class JsonReader<D> implements DataReader<D> {

  private ModelType modelType;

  /**
   * Creates a new JSON reader.
   * 
   * @param modelType the model type definition
   */
  public JsonReader(ModelType modelType) {
    this.modelType = modelType;
  }

  @SuppressWarnings("unchecked")
  public D read(Object loadConfig, Object data) {
    JSONObject jsonRoot = null;
    if (data instanceof JavaScriptObject) {
      jsonRoot = new JSONObject((JavaScriptObject) data);
    } else {
      jsonRoot = (JSONObject) JSONParser.parse((String) data);
    }
    JSONArray root = (JSONArray) jsonRoot.get(modelType.getRoot());
    int size = root.size();
    ArrayList<ModelData> models = new ArrayList<ModelData>();
    for (int i = 0; i < size; i++) {
      JSONObject obj = (JSONObject) root.get(i);
      ModelData model = newModelInstance();
      for (int j = 0; j < modelType.getFieldCount(); j++) {
        DataField field = modelType.getField(j);
        String name = field.getName();
        Class type = field.getType();
        String map = field.getMap() != null ? field.getMap() : field.getName();
        JSONValue value = obj.get(map);

        if (value == null) continue;
        if (value.isArray() != null) {
          // nothing
        } else if (value.isBoolean() != null) {
          model.set(name, value.isBoolean().booleanValue());
        } else if (value.isNumber() != null) {
          if (type != null) {
            Double d = value.isNumber().doubleValue();
            if (type.equals(Integer.class)) {
              model.set(name, d.intValue());
            } else if (type.equals(Long.class)) {
              model.set(name, d.longValue());
            } else if (type.equals(Float.class)) {
              model.set(name, d.floatValue());
            } else {
              model.set(name, d);
            }
          } else {
            model.set(name, value.isNumber().doubleValue());
          }
        } else if (value.isObject() != null) {
          // nothing
        } else if (value.isString() != null) {
          String s = value.isString().stringValue();
          if (type != null) {
            if (type.equals(Date.class)) {
              if (field.getFormat().equals("timestamp")) {
                Date d = new Date(Long.parseLong(s) * 1000);
                model.set(name, d);
              } else {
                DateTimeFormat format = DateTimeFormat.getFormat(field.getFormat());
                Date d = format.parse(s);
                model.set(name, d);
              }
            }
          } else {
            model.set(name, s);
          }
        } else if (value.isNull() != null) {
          model.set(name, null);
        }
      }
      models.add(model);
    }
    int totalCount = models.size();
    if (modelType.getTotalName() != null) {
      totalCount = getTotalCount(jsonRoot);
    }
    return (D) createReturnData(loadConfig, models, totalCount);
  }

  /**
   * Responsible for the object being returned by the reader.
   * 
   * @param loadConfig the load config
   * @param records the list of models
   * @param totalCount the total count
   * @return the data to be returned by the reader
   */
  @SuppressWarnings("unchecked")
  protected Object createReturnData(Object loadConfig, List<ModelData> records,
      int totalCount) {
    return (D) records;
  }

  protected int getTotalCount(JSONObject root) {
    if (modelType.getTotalName() != null) {
      JSONValue v = root.get(modelType.getTotalName());
      if (v != null) {
        if (v.isNumber() != null) {
          return (int) v.isNumber().doubleValue();
        } else if (v.isString() != null) {
          return Integer.parseInt(v.isString().stringValue());
        }
      }
    }
    return -1;
  }

  /**
   * Returns the new model instances. Subclasses may override to provide an
   * model data subclass.
   * 
   * @return the new model data instance
   */
  protected ModelData newModelInstance() {
    return new BaseModelData();
  }
}
