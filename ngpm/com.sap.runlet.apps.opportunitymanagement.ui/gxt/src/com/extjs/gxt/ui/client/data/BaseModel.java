/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <code>Models</code> are generic data structures that notify listeners when
 * changed. The structure allows a form of 'introspection' as all property names
 * and values can be queried and retrieved at runtime.
 * 
 * <p>
 * All events fired by the model will bubble to all parents.
 * </p>
 * 
 * <p>
 * Model objects implement <code>Serializable</code> and can therefore be used
 * with GWT RPC. A model's children are not marked transient and will be passed
 * in remote procedure calls.
 * </p>
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Model.Add</b> : (source, item)<br>
 * <div>Fires after the button is selected.</div>
 * <ul>
 * <li>source : this</li>
 * <li>item : add item</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Model.Insert</b> : (source, item)<br>
 * <div>Fires after the button is selected.</div>
 * <ul>
 * <li>source : this</li>
 * <li>item : insert item</li>
 * <li>index : insert index</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Model.Update</b> : (source, item)<br>
 * <div>Fires after the button is selected.</div>
 * <ul>
 * <li>source : this</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * @see ChangeListener
 * @see Serializable
 */
public class BaseModel extends BaseModelData implements Model, Serializable {

  protected transient ChangeEventSupport changeEventSupport;

  /**
   * Creates a new base model.
   */
  public BaseModel() {
    changeEventSupport = new ChangeEventSupport();
  }

  /**
   * Creates a new base model.
   * 
   * @param properties the initial values
   */
  public BaseModel(Map<String, Object> properties) {
    this();
    setProperties(properties);
  }

  /**
   * Adds a listener to receive change events.
   * 
   * @param listener the listener to be added
   */
  public void addChangeListener(ChangeListener... listener) {
    changeEventSupport.addChangeListener(listener);
  }

  /**
   * Adds the listeners to receive change events.
   * 
   * @param listeners the listeners to add
   */
  public void addChangeListener(List<ChangeListener> listeners) {
    for (ChangeListener listener : listeners) {
      changeEventSupport.addChangeListener(listener);
    }
  }

  public void notify(ChangeEvent evt) {
    changeEventSupport.notify(evt);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <X> X remove(String name) {
    if (map != null && map.containsKey(name)) {
      X oldValue = (X) super.remove(name);
      notifyPropertyChanged(name, null, oldValue);
      return oldValue;
    }
    return null;
  }

  /**
   * Removes a previously added change listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeChangeListener(ChangeListener... listener) {
    changeEventSupport.removeChangeListener(listener);
  }

  public void removeChangeListeners() {
    changeEventSupport.removeChangeListeners();
  }

  @Override
  public <X> X set(String name, X value) {
    X oldValue = super.set(name, value);
    notifyPropertyChanged(name, value, oldValue);
    return oldValue;
  }

  public void setSilent(boolean silent) {
    changeEventSupport.setSilent(silent);
  }

  protected void fireEvent(int type) {
    notify(new ChangeEvent(type, this));
  }

  protected void fireEvent(int type, Model item) {
    notify(new ChangeEvent(type, this, item));
  }

  protected void notifyPropertyChanged(String name, Object value, Object oldValue) {
    if (value == oldValue) return;
    if (value != null && value.equals(oldValue)) return;
    notify(new PropertyChangeEvent(Update, this, name, oldValue, value));
  }

}
