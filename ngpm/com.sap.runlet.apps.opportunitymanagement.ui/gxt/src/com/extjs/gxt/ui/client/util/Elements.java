/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import java.util.List;

import com.google.gwt.user.client.Element;

/**
 * Utility class for identifying elements either as a single element, array of
 * elements, a id, and index.
 */
public class Elements {

  /**
   * Constant for an element array.
   */
  public static final int ARRAY = 1;

  /**
   * Constant for a single element.
   */
  public static final int ELEMENT = 0;

  /**
   * Constant for an element id.
   */
  public static final int ID = 2;

  /**
   * Constant for a element index.
   */
  public static final int INDEX = 3;

  /**
   * Single element.
   */
  public Element element;

  /**
   * Array of elements
   */
  public Element[] elements;

  /**
   * Element id.
   */
  public String id;

  /**
   * Element index.
   */
  public int index;

  private boolean isArray;
  private boolean isElement;
  private boolean isId;
  private boolean isIndex;
  private int type;

  public Elements(Element element) {
    this.element = element;
    type = ELEMENT;
    isElement = true;
  }

  public Elements(Element[] elements) {
    this.elements = elements;
    type = ARRAY;
    isArray = true;
  }

  public Elements(List<Element> elements) {
    this(elements.toArray(new Element[0]));
  }

  /**
   * Creates a new index element info.
   * 
   * @param index the index
   */
  public Elements(int index) {
    this.index = index;
    type = INDEX;
    isIndex = true;
  }

  /**
   * Creates a new id element info.
   * 
   * @param id the id
   */
  public Elements(String id) {
    this.id = id;
    type = ID;
    isId = true;
  }

  /**
   * Returns the element info type.
   * 
   * @return the type
   */
  public int getType() {
    return type;
  }

  /**
   * Returns true if the value is an array.
   * 
   * @return true if an array
   */
  public boolean isArray() {
    return isArray;
  }

  /**
   * Returns true if the value is an element.
   * 
   * @return true if an element
   */
  public boolean isElement() {
    return isElement;
  }

  /**
   * Returns true if the value is an id.
   * 
   * @return true if an id
   */
  public boolean isId() {
    return isId;
  }

  /**
   * Returns true if the value is an index.
   * 
   * @return true if an index
   */
  public boolean isIndex() {
    return isIndex;
  }

}
