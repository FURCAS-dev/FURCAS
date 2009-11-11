/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Params;

/**
 * Configuation settings for {@link Info}.
 */
public class InfoConfig {

  /**
   * The info title (defaults to null).
   */
  public String title;

  /**
   * The info text (defaults to null).
   */
  public String text;

  /**
   * The index or key based substitution values.
   */
  public Params params;

  /**
   * The time in milliseconds to display a message (defaults to 2500).
   */
  public int display = 2500;

  /**
   * The info width (defaults to 225).
   */
  public int width = 225;

  /**
   * The info height (defaults to 75).
   */
  public int height = 75;

  /**
   * Listener to be notified when the info is displayed (defaults to null).
   */
  public Listener<ComponentEvent> listener;

  public InfoConfig(String title, String text) {
    this.title = title;
    this.text = text;
  }

  public InfoConfig(String title, String text, Params params) {
    this.title = title;
    this.text = text;
    this.params = params;
  }
}
