/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.js.JsArray;
import com.extjs.gxt.ui.client.js.JsObject;
import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.Element;

/**
 * Various utility functions.
 */
public class Util {

  @SuppressWarnings("unchecked")
  public static List subList(List list, int start, int end) {
    List temp = new ArrayList();
    for (int i = start; i < end; i++) {
      temp.add(list.get(i));
    }
    return temp;
  }

  public static native <E> E or(E s1, E s2) /*-{
    return s1 || s2;
  }-*/;

  /**
   * Constrains the value by a minimum and max value.
   * 
   * @param value the value
   * @param min the minimum
   * @param max the maximum
   * @return the adjusted value
   */
  public static int constrain(int value, int min, int max) {
    value = Math.max(value, min);
    value = Math.min(value, max);
    return value;
  }

  /**
   * Creates a Component[] from a list of Component's.
   * 
   * @param list the list
   * @return the array
   */
  public static Component[] createArray(List<Component> list) {
    int size = list.size();
    Component[] components = new Component[size];
    for (int i = 0; i < components.length; i++) {
      components[i] = (Component) list.get(i);
    }
    return components;
  }

  /**
   * Creates a new list from the given collection.
   * 
   * @param collection the collection
   * @return the list
   */
  @SuppressWarnings("unchecked")
  public static List createList(Collection collection) {
    if (collection instanceof List) {
      return (List) collection;
    }
    List list = new ArrayList();
    Iterator it = collection.iterator();
    while (it.hasNext()) {
      list.add(it.next());

    }
    return list;
  }

  /**
   * Creates a new list and adds the element(s).
   * 
   * @param element the item to add to the list
   * @return the new list
   */
  @SuppressWarnings("unchecked")
  public static List createList(Object... element) {
    List list = new ArrayList();
    fill(list, element);
    return list;
  }

  /**
   * Populates a list with an array of elements.
   * 
   * @param list the list
   * @param elements the elements to be added to the list
   */
  @SuppressWarnings("unchecked")
  public static void fill(List list, Object[] elements) {
    for (int i = 0; i < elements.length; i++) {
      list.add(elements[i]);
    }
  }

  /**
   * Returns the model's data as a javascript object.
   * 
   * @param model the model
   * @return the javascript object
   */
  public static JavaScriptObject getJsObject(ModelData model) {
    return getJsObject(model, 0);
  }

  /**
   * Returns the model's data as a javascript object.
   * 
   * @param model the model
   * @param maxDepth the maximum number of sub models to process
   * @return the javascript object
   */
  @SuppressWarnings("unchecked")
  public static JavaScriptObject getJsObject(ModelData model, int maxDepth) {
    JsObject jsObj = new JsObject();
    for (String key : model.getPropertyNames()) {
      Object value = model.get(key);
      if (value == null) continue;
      if (maxDepth > 0) {
        if (value instanceof Collection) {
          jsObj.set(key, processCollection((Collection) value, maxDepth).getJsObject());
        } else if (value instanceof Object[]) {
          jsObj.set(key, processArray((Object[]) value, maxDepth).getJsObject());
        } else if (value instanceof ModelData) {
          jsObj.set(key, getJsObject((ModelData) value, maxDepth - 1));
        } else {
          jsObj.set(key, value);
        }
      } else {
        jsObj.set(key, value);
      }
    }
    return jsObj.getJsObject();
  }

  /**
   * Iterates down into Collection, producing the required JsArray
   */
  @SuppressWarnings("unchecked")
  private static JsArray processCollection(Collection c, int maxDepth) {
    JsArray jsArray = new JsArray();
    if (maxDepth > 0) {
      for (Object obj : c) {
        if (obj instanceof ModelData) {
          jsArray.add(getJsObject((ModelData) obj, maxDepth - 1));
        } else if (obj instanceof Collection) {
          jsArray.add(processCollection((Collection) obj, maxDepth - 1).getJsObject());
        } else {
          jsArray.add(obj);
        }
      }
    }
    return jsArray;
  }

  /**
   * Iterates down into Object[], producing the required JsArray
   */
  private static JsArray processArray(Object[] c, int maxDepth) {
    JsArray jsArray = new JsArray();
    if (maxDepth > 0) {
      for (Object obj : c) {
        if (obj instanceof ModelData) {
          jsArray.add(getJsObject((ModelData) obj, maxDepth - 1));
        } else if (obj instanceof Object[]) {
          jsArray.add(processArray((Object[]) obj, maxDepth - 1).getJsObject());
        } else {
          jsArray.add(obj);
        }
      }
    }
    return jsArray;
  }

  /**
   * Returns the list of models as a javascript array.
   * 
   * @param models the list of models
   * @param maxDepth the maximum number of sub models to process
   * @return the javascript array object
   */
  public static JavaScriptObject getJsObjects(List<ModelData> models, int maxDepth) {
    JsArray js = new JsArray();
    for (ModelData m : models) {
      js.add(getJsObject(m, maxDepth));
    }
    return js.getJsObject();
  }

  /**
   * Returns the index of a object in an array.
   * 
   * @param elements the array
   * @param elem the element
   * @return the index or -1 if elem not in the array
   */
  public static int indexOf(Object[] elements, Object elem) {
    for (int i = 0; i < elements.length; i++) {
      if (elements[i] == elem) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns true if the style ends with .jpg, .gif, or .png.
   * 
   * @param style the style
   * @return true for an image path
   */
  public static boolean isImagePath(String style) {
    return style.matches(".*(jpg$|gif$|png$)");
  }

  /**
   * Tests if the value is an integer.
   * 
   * @param value the value to test
   * @return the integer state
   */
  public static boolean isInteger(String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static native int parseInt(String value, int defaultValue) /*-{
    return parseInt(value, 10) || defaultValue;
  }-*/;

  public static Element[] toElementArray(NodeList<Element> nodes) {
    Element[] e = new Element[nodes.getLength()];
    for (int i = 0; i < nodes.getLength(); i++) {
      e[i] = nodes.getItem(i);
    }
    return e;
  }

}
