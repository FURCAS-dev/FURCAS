/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.js;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.util.Params;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * JavaScript related methods.
 */
public class JsUtil {

  /**
   * Creates a new javascript object from the JSON text.
   * 
   * @param code the JSON text
   * @return the new javascript object
   */
  public static native JavaScriptObject eval(String code) /*-{
     var x = eval(code);
     return x[0];
   }-*/;

  /**
   * Returns <code>true</code> if the value is a integer.
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

  /**
   * Returns a section of the given list.
   * 
   * @param list the list
   * @param start the start index
   * @param end the end index
   * @return the sub list
   */
  public static <X> List<X> subList(List<X> list, int start, int end) {
    List<X> temp = new ArrayList<X>();
    for (int i = start; i < end; i++) {
      temp.add(list.get(i));
    }
    return temp;
  }

  /**
   * Converts a native javascript array to an element array.
   * 
   * @param jsArray the array to be converted
   * @return the element array
   */
  public static Element[] toElementArray(JavaScriptObject jsArray) {
    Element[] elems = new Element[getLength(jsArray)];
    for (int i = 0; i < elems.length; i++) {
      elems[i] = getElement(jsArray, i);
    }
    return elems;
  }

  /**
   * Converts a object array to a javascript array.
   * 
   * @param array the java array
   * @return the new javascript array
   */
  public static JavaScriptObject toJavaScriptArray(Object[] array) {
    JsArray jsArray = new JsArray();
    for (int i = 0; i < array.length; i++) {
      jsArray.add(array[i]);
    }
    return jsArray.getJsObject();

  }

  /**
   * Converts a map into a javascript object, setting all values as properties.
   * Map keys must be strings.
   * 
   * @param params the parameters
   * @return the new javascript object
   */
  public static <V> JavaScriptObject toJavaScriptObject(Map<String, V> params) {
    JsObject obj = new JsObject();
    Iterator<String> keys = params.keySet().iterator();
    while (keys.hasNext()) {
      String k = keys.next();
      Object v = params.get(k);
      if (v instanceof Params) {
        v = ((Params) v).getValues();
      } else if (v instanceof ModelData) {
        v = new Params(((ModelData) v).getProperties()).getValues();
      }
      obj.set(k, v);
    }
    return obj.getJsObject();
  }

  /**
   * Returns the element at the specified index.
   * 
   * @param jsArray the javascript array
   * @param index the index
   * @return the element
   */
  private static native Element getElement(JavaScriptObject jsArray, int index) /*-{ 
     return jsArray[index]; 
   }-*/;

  /**
   * Returns the length of a javascript array.
   * 
   * @param jsArray the natvie element
   * 
   * @return the array length
   */
  private static native int getLength(JavaScriptObject jsArray) /*-{
     return jsArray.length;
   }-*/;
}
