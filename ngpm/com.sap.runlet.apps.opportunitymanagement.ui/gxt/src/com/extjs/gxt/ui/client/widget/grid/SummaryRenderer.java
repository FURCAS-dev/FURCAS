/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import java.util.Map;

/**
 * Returns the rendered content for a summary row.
 */
public interface SummaryRenderer {

  /**
   * Returns the html content for the summary row.
   * 
   * @param value the summary calculation
   * @param data the data for the group
   * @return the html content
   */
  public String render(Number value, Map<String, Number> data);

}
