/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.ArrayList;
import java.util.List;

/**
 * A selection of items in a container. The selection can be specified with an
 * index, a range, a single item, an array, and a list.
 * 
 * @param <T> the child type
 */
@SuppressWarnings("unchecked")
public class Items<T extends Component> {
  private int start = -1, end = -1;
  private List<T> items = new ArrayList<T>();

  /**
   * Creates a items instance with a single item.
   * 
   * @param index the index of the item
   */
  public Items(int index) {
    this(index, index);
  }

  /**
   * Creates a items instance with a range.
   * 
   * @param start the start index
   * @param end the end index
   */
  public Items(int start, int end) {
    this.start = start;
    this.end = end;
  }

  /**
   * Creates a items instance with a list.
   * 
   * @param items the list of items
   */
  public Items(List<T> items) {
    this.items = items;
  }

  /**
   * Createa a items instance with 1 to many items.
   * 
   * @param item the varargs items
   */
  public Items(T... item) {
    if (item != null) {
      for (int i = 0; i < item.length; i++) {
        this.items.add(item[i]);
      }
    }
  }

  /**
   * Returns the first matching item from the specified container.
   * 
   * @param c the container
   * @return the matching item
   */
  public T getItem(Container c) {
    List<T> match = getItems(c);
    if (match.size() > 0) {
      return (T) getItems(c).get(0);
    }
    return null;
  }

  /**
   * Returns the matching items from the specified container.
   * 
   * @param c the container
   * @return the selected items
   */
  public List<T> getItems(Container c) {
    List temp = new ArrayList<T>();

    if (start == -1 && end == -1) {
      return items;
    }

    if (start <= end) {
      for (int i = start; i <= end; i++) {
        temp.add(c.getItem(i));
      }
    } else {
      for (int i = start; i >= end; i--) {
        temp.add(c.getItem(i));
      }
    }
    return temp;
  }

  /**
   * Returns true if there is a single selected item.
   * 
   * @return true for single, false otherwise
   */
  public boolean isSingle() {
    if (start == -1 && end == -1) {
      return items.size() == 1;
    }
    return ((end - start) == 0 || items.size() == 1);
  }
}
