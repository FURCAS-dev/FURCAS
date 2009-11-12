/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import java.util.Comparator;

/**
 * Default <code>Comparator</code> implementation.
 */
public class DefaultComparator<X extends Object> implements Comparator<X> {

  public final static DefaultComparator<?> INSTANCE = new DefaultComparator<Object>();

  @SuppressWarnings("unchecked")
  public int compare(Object o1, Object o2) {
    if (o1 == null || o2 == null) {
      if (o1 == null && o2 == null) {
        return 0;
      } else {
        return (o1 == null) ? -1 : 1;
      }
    }
    if (o1 instanceof Comparable) {
      return ((Comparable) o1).compareTo(o2);
    }
    return compareStrings(o1.toString(), o2.toString());

  }

  protected int compareStrings(String s1, String s2) {
    return s1.toLowerCase().compareTo(s2.toLowerCase());
  }

}
