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

import com.extjs.gxt.ui.client.core.DomQuery;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

/**
 * A <code>DataReader</code> implementation that reads XML data using a
 * <code>ModelType</code> definition and produces a set of
 * <code>ModelData</code> instances.
 * 
 * <p />
 * Subclasses can override {@link #createReturnData(Object, List, int)} to
 * control what object is returned by the reader. Subclass may override
 * {@link #newModelInstance()} to return any model data subclass.
 * 
 * <p />
 * <code><pre>
 *  // defines the xml structure
 *  ModelType type = new ModelType();
 *  type.setRecordName("record"); // The repeated element which contains row information
 *  type.setRoot("records"); // the optional root element that contains the total attribute (optional)
 *  type.setTotalName("total"); // The element which contains the total dataset size (optional)
 * </pre></code>
 * 
 * @param <D> the type of data being returned by the reader
 */
public class XmlReader<D> implements DataReader<D> {

  private ModelType modelType;

  /**
   * Creates a new xml reader instance.
   * 
   * @param modelType the model type
   */
  public XmlReader(ModelType modelType) {
    this.modelType = modelType;
  }

  @SuppressWarnings("unchecked")
  public D read(Object loadConfig, Object data) {
    Document doc = XMLParser.parse((String) data);

    NodeList list = doc.getElementsByTagName(modelType.getRecordName());
    ArrayList<ModelData> records = new ArrayList<ModelData>();
    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      Element elem = (Element) node;
      ModelData model = newModelInstance();
      for (int j = 0; j < modelType.getFieldCount(); j++) {
        DataField field = modelType.getField(j);
        Class type = field.getType();
        String name = field.getName();
        String map = field.getMap() != null ? field.getMap() : field.getName();
        String v = getValue(elem, map);

        if (type != null) {
          if (type.equals(Integer.class)) {
            model.set(name, Integer.parseInt(v));
          } else if (type.equals(Long.class)) {
            model.set(name, Long.parseLong(v));
          } else if (type.equals(Float.class)) {
            model.set(name, Float.parseFloat(v));
          } else if (type.equals(Double.class)) {
            model.set(name, Double.parseDouble(v));
          } else if (type.equals(Date.class)) {
            if (field.getFormat().equals("timestamp")) {
              Date d = new Date(Long.parseLong(v) * 1000);
              model.set(name, d);
            } else {
              DateTimeFormat format = DateTimeFormat.getFormat(field.getFormat());
              Date d = format.parse(v);
              model.set(name, d);
            }
          }
        } else {
          model.set(field.getName(), v);
        }

      }
      records.add(model);
    }

    int totalCount = records.size();
    Node root = doc.getElementsByTagName(modelType.getRoot()).item(0);
    if (root != null && modelType.getTotalName() != null) {
      String tot = getValue((Element)root, modelType.getTotalName());
      if (tot != null) {
        totalCount = Integer.parseInt(tot);
      }
    }

    return (D) createReturnData(loadConfig, records, totalCount);
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

  protected native JavaScriptObject getJsObject(Element elem) /*-{
         return elem.@com.google.gwt.xml.client.impl.DOMItem::getJsObject()();
       }-*/;

  protected String getValue(Element elem, String name) {
    return DomQuery.selectValue(name, getJsObject(elem));
  }

  /**
   * Returns the new model instances. Subclasses may override to provide a model
   * data subclass.
   * 
   * @return the new model data instance
   */
  protected ModelData newModelInstance() {
    return new BaseModelData();
  }

}
