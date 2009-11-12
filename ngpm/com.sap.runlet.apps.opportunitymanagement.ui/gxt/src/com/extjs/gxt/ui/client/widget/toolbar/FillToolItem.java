/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.toolbar;

import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Fills the toolbar width, pushing any newly added items to the right.
 */
public class FillToolItem extends Component {

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
  }

}
