/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * Interface for objects that support icons.
 */
public interface IconSupport {
  /**
   * Returns the icon.
   * 
   * @return the icon
   */
  public AbstractImagePrototype getIcon();

  /**
   * Sets the icon.
   * 
   * @param icon the icon
   */
  public void setIcon(AbstractImagePrototype icon);

  /**
   * Sets the icon style.
   * 
   * @param icon a CSS style name
   */
  public void setIconStyle(String icon);
}
