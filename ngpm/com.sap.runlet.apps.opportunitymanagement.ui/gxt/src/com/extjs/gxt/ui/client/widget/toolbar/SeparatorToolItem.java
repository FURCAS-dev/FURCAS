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
 * A tool bar separator.
 */
public class SeparatorToolItem extends Component {

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createSpan(), target, index);
    setStyleName("xtb-sep");
  }

}
