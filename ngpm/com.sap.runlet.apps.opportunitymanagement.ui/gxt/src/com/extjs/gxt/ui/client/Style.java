/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client;

import java.util.Comparator;

/**
 * Defines GXT public constants and enumerations.
 */
public class Style {

  /**
   * Horizontal alignment enumeration.
   */
  public enum HorizontalAlignment {
    LEFT, CENTER, RIGHT
  }

  /**
   * Vertical alignment enumerations.
   */
  public enum VerticalAlignment {
    TOP, MIDDLE, BOTTOM;
  }
  
  /**
   * Anchor enumeration.
   */
  public enum AnchorPosition {
    LEFT("left"), RIGHT("right"), TOP("top"), BOTTOM("bottom");
    private final String value;

    private AnchorPosition(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }
  }

  /**
   * Scroll enumeration.
   */
  public enum Scroll {
    AUTO("auto"), AUTOX("auto"), AUTOY("auto"), ALWAYS("scroll"), NONE("hidden");
    private final String value;

    private Scroll(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }
  }

  /**
   * Sort direction enum.
   */
  public enum SortDir {

    NONE {
      @SuppressWarnings("unchecked")
      @Override
      public Comparator comparator(Comparator c) {
        return c;
      }
    },

    ASC {
      @Override
      public <X> Comparator<X> comparator(final Comparator<X> c) {
        return new Comparator<X>() {
          public int compare(X o1, X o2) {
            return c.compare(o1, o2);
          }
        };
      }
    },

    DESC {
      @Override
      public <X> Comparator<X> comparator(final Comparator<X> c) {
        return new Comparator<X>() {
          public int compare(X o1, X o2) {
            return c.compare(o2, o1);
          }
        };
      }
    };

    public static SortDir toggle(SortDir sortDir) {
      return (sortDir == ASC) ? DESC : ASC;
    }

    /**
     * An example of how to use this :
     * 
     * List<Something> list = ...
     * 
     * Collections.sort(list, SortDir.ASC.comparator(new Comparator() { public
     * int compare(Object o1, Object o2) { return ... } });
     * 
     * 
     * @return a Comparator that wraps the specific comparator that orders the
     *         results according to the sort direction
     */
    public abstract <X> Comparator<X> comparator(Comparator<X> c);
  }

  /**
   * Layout out regions.
   */
  public enum LayoutRegion {
    NORTH, EAST, SOUTH, WEST, CENTER;
  }

  public enum Direction {
    UP, DOWN, LEFT, RIGHT;
  }

  /**
   * Scroll direction enum.
   */
  public enum ScrollDir {
    VERTICAL, HORIZONTAL;
  }

  /**
   * Selection mode enum.
   */
  public enum SelectionMode {
    SINGLE, SIMPLE, MULTI;
  }

  /**
   * Orientation enum.
   */
  public enum Orientation {
    VERTICAL, HORIZONTAL;
  }

  /**
   * HideMode enum.
   */
  public enum HideMode {
    OFFSETS, VISIBILITY, DISPLAY
  }

  /**
   * ButtonScale enum.
   */
  public enum ButtonScale {
    SMALL, MEDIUM, LARGE;
  }

  /**
   * ButtonArrowAlign enum.
   */
  public enum ButtonArrowAlign {
    RIGHT, BOTTOM
  }

  /**
   * ButtonIconAlign enum.
   */
  public enum IconAlign {
    RIGHT, BOTTOM, TOP, LEFT
  }

  /**
   * A constant known to be zero (0).
   */
  public static final int NONE = 0;

  /**
   * Indicates that a default value should be used (value is -1).
   */
  public static final int DEFAULT = -1;

  /**
   * Constant for marking a string as undefined rather than null.
   */
  public static final String UNDEFINED = "undefined";

}
