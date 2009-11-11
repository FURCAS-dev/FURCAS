/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.core;

import java.util.Iterator;

public class TemplatesBase implements Templates {

  public static class IterableRange<T extends Number> implements Iterable<T> {
    private T start;
    private T end;
    private int order;

    @SuppressWarnings("unchecked")
    public IterableRange(T start, T end) {
      this.start = start;
      this.end = end;
      order = ((Comparable) start).compareTo(end);
    }

    public Iterator<T> iterator() {
      return new IterableRangeIterator();
    }

    public class IterableRangeIterator implements Iterator<T> {
      private T current;
      private boolean hasNext = true;
      private int inc = 1;

      public IterableRangeIterator() {
        current = start;
        if (order > 0) {
          inc = -1;
        }
      }

      public boolean hasNext() {
        return hasNext;
      }

      @SuppressWarnings("unchecked")
      public T next() {
        if (!hasNext) {
          throw new IllegalStateException("End of iterator reached.");
        }

        T retVal = current;

        if (retVal instanceof Long) {
          long value = current.longValue();
          value += inc;
          current = (T) new Long(value);
        } else {
          int value = current.intValue();
          value += inc;
          current = (T) new Integer(value);
        }
        hasNext = inc == -1 && ((Comparable) end).compareTo(current) <= 0 || inc == 1
            && ((Comparable) end).compareTo(current) >= 0;

        return retVal;
      }

      public void remove() {
        throw new RuntimeException("remove() method not supported");
      }

    }

  }

}
