/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.extjs.gxt.ui.client.util.Elements;
import com.extjs.gxt.ui.client.util.Util;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Wraps an list of elements, allowing code to be applied to each element using
 * a {@link CompositeFunction}.
 */
public class CompositeElement {

  /**
   * The list of elements.
   */
  protected List<Element> items;

  /**
   * Creates a new composite element.
   */
  public CompositeElement() {
    items = new ArrayList<Element>();
  }

  /**
   * Creates a new composite element.
   * 
   * @param elements the initial elements
   */
  public CompositeElement(Element[] elements) {
    items = new ArrayList<Element>();
    Util.fill(items, elements);
  }

  /**
   * Creates a new composite element.
   * 
   * @param elements the initial elements
   */
  public CompositeElement(List<Element> elements) {
    items = elements;
  }

  /**
   * Adds an element.
   * 
   * @param elem the element to add
   */
  public void add(Element elem) {
    insert(elem, getCount());
  }

  /**
   * Adds the elements.
   * 
   * @param elements the elements to add
   */
  public void add(Elements elements) {
    if (elements.isElement()) {
      add(elements.element);
    } else if (elements.isArray()) {
      items.addAll(Arrays.asList(elements.elements));
    } else if (elements.isId()) {
      add(DOM.getElementById(elements.id));
    }
  }

  /**
   * Returns true if this composite contains the passed element.
   * 
   * @param elem the element
   * @return the contains state
   */
  public boolean contains(Element elem) {
    return indexOf(elem) != -1;
  }

  /**
   * Calls the passed function passing (el, this, index) for each element in
   * this composite.
   * 
   * @param f the function
   */
  public void each(CompositeFunction f) {
    int count = items.size();
    for (int i = 0; i < count; i++) {
      f.doFunction(item(i), this, i);
    }
  }

  /**
   * Returns the first element.
   * 
   * @return the element
   */
  public Element first() {
    return item(0);
  }

  /**
   * Returns the number of elements in this composite.
   * 
   * @return the count
   */
  public int getCount() {
    return items.size();
  }

  /**
   * Returns the element at the given index.
   * 
   * @param index the element index
   * @return the element
   */
  public Element getElement(int index) {
    return (Element) items.get(index);
  }

  /**
   * The list of elements.
   */
  public List<Element> getElements() {
    return new ArrayList<Element>(items);
  }

  /**
   * Returns the index of the given element.
   * 
   * @param elem the element
   * @return the index
   */
  public int indexOf(Element elem) {
    if (items != null) {
      for (int i = 0; i < items.size(); i++) {
        Element e = items.get(i);
        if (e == elem) {
          return i;
        }
      }
    }
    return -1;
  }

  /**
   * Inserts an element at the given index.
   * 
   * @param elem the element to add
   * @param index the insert location
   */
  public void insert(Element elem, int index) {
    items.add(index, elem);
  }

  public void insert(Element[] elems, int index) {
    items.addAll(index, Arrays.asList(elems));
  }

  /**
   * Returns true if the given element is or is a child of any contained
   * element.
   * 
   * @param elem the element to test
   * @return the is state
   */
  public boolean is(Element elem) {
    int count = items.size();
    for (int i = 0; i < count; i++) {
      Element test = getElement(i);
      if (DOM.isOrHasChild(test, elem)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the Element object at the specified index.
   * 
   * @param index the index
   * @return the element
   */
  public Element item(int index) {
    return items != null ? (Element) items.get(index) : null;
  }

  /**
   * Returns the last element.
   * 
   * @return the last element
   */
  public Element last() {
    return item(items.size() == 0 ? 0 : getCount() - 1);
  }

  /**
   * Removes an element.
   * 
   * @param element the element to remove
   */
  public void remove(Element element) {
    if (items != null) {
      items.remove(element);
    }
  }

  /**
   * Removes an element.
   * 
   * @param index the index of the element to remove
   */
  public void remove(int index) {
    if (items != null) {
      items.remove(index);
    }
  }

  /**
   * Removes all elements.
   */
  public void removeAll() {
    items.clear();
  }

  /**
   * Replaces an element.
   * 
   * @param elem the element to remove
   * @param replace the element to replace
   * @return true if the item was replaced
   */
  public boolean replaceElement(Element elem, Element replace) {
    int i = items.indexOf(elem);
    if (i != -1) {
      remove(elem);
      items.add(i, replace);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Sets the element's height.
   * 
   * @param height the height
   */
  public void setHeight(int height) {
    for (Element elem : items) {
      El.fly(elem).setHeight(height);
    }
  }

  /**
   * Sets the element's inner HTML.
   * 
   * @param html the html
   */
  public void setInnerHtml(String html) {
    for (Element elem : items) {
      elem.setInnerHTML(html);
    }
  }

  public void removeStyleName(String style) {
    for (Element elem : items) {
      El.fly(elem).removeStyleName(style);
    }
  }

  /**
   * Sets the element's width.
   * 
   * @param width the width
   */
  public void setWidth(int width) {
    for (Element elem : items) {
      El.fly(elem).setWidth(width);
    }
  }

  /**
   * Sets the element's width.
   * 
   * @param width the width
   */
  public void setWidth(String width) {
    for (Element elem : items) {
      El.fly(elem).setWidth(width);
    }
  }

}
