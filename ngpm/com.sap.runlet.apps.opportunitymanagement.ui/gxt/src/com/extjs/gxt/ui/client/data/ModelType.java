/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes the fields and structure of a <code>Model</code>. Used by
 * <code>DataReaders</code> when parsing raw data.
 */
public class ModelType {

  private String root;
  private String recordName;
  private String totalName;
  private List<DataField> fields;

  /**
   * Creates a new instance.
   */
  public ModelType() {
    fields = new ArrayList<DataField>();
  }

  /**
   * Adds a field to the model.
   * 
   * @param field the field to be added
   */
  public void addField(DataField field) {
    fields.add(field);
  }

  /**
   * Adds a field to the model.
   * 
   * @param name the field name
   */
  public void addField(String name) {
    addField(new DataField(name));
  }

  /**
   * Adds a field to the model.
   * 
   * @param name the field name
   * @param map the map name
   */
  public void addField(String name, String map) {
    addField(new DataField(name, map));
  }

  /**
   * Returns the field at the given index or null if the index is out of bounds.
   * 
   * @param index the index of the field to return
   * @return the field at the given index
   */
  public DataField getField(int index) {
    if (index < 0 || index >= fields.size()) return null;
    return fields.get(index);
  }

  /**
   * Returns the field with the given name.
   * 
   * @param name the name of the field to return
   * @return the field with the given name of <code>null</code> if no match
   */
  public DataField getField(String name) {
    for (DataField field : fields) {
      if (field.getName().equals(name)) {
        return field;
      }
    }
    return null;
  }

  /**
   * Returns the number of fields.
   * 
   * @return the field count
   */
  public int getFieldCount() {
    return fields.size();
  }

  /**
   * Returns the record name.
   * 
   * @return the record name
   */
  public String getRecordName() {
    return recordName;
  }

  /**
   * Returns the root name.
   * 
   * @return the root name
   */
  public String getRoot() {
    return root;
  }

  /**
   * Returns the total name.
   * 
   * @return the total name
   */
  public String getTotalName() {
    return totalName;
  }

  /**
   * Sets the record name.
   * 
   * @param recordName the record name
   */
  public void setRecordName(String recordName) {
    this.recordName = recordName;
  }

  /**
   * Sets the root element name. When used by <code>JsonReader</code>, the root
   * is the name of the property with the array of data. When used by
   * <code>XmlReader</code>, the root is the name of the element in which the
   * total count will be retrieved from use {@link #setTotalName(String)}.
   * 
   * @param root the root name
   */
  public void setRoot(String root) {
    this.root = root;
  }

  /**
   * Sets name of the property that contains the 'total number of records'
   * value.
   * 
   * @param totalName the total name
   */
  public void setTotalName(String totalName) {
    this.totalName = totalName;
  }

}
