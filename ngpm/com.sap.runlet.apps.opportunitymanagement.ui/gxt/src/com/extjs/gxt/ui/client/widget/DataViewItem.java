/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.Map;

/**
 * A item in a <code>DataView</code>.
 * 
 * @deprecated see {@link ListView}
 */
public class DataViewItem extends Component {

  protected Map<String, Object> properties;

  public DataViewItem(Map<String, Object> properties) {
    this.properties = properties;
  }

  public Map<String, Object> getValues() {
    return properties;
  }

}
