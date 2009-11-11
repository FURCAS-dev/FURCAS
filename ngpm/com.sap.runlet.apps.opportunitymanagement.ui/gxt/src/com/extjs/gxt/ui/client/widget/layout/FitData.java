/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.util.Margins;

/**
 * Layout data for <code>FitLayout</code>
 */
public class FitData extends MarginData {

  public FitData() {
    super();
  }

  public FitData(int top, int right, int bottom, int left) {
    super(top, right, bottom, left);
  }

  public FitData(int margin) {
    super(margin);
  }

  public FitData(Margins margins) {
    super(margins);
  }

}
