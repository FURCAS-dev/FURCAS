/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.button;

import com.extjs.gxt.ui.client.util.TextMetrics;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Element;

/**
 * A specialized content panel for showing groups of buttons, typically used
 * with ToolBar.
 * 
 * @see ToolBar
 */
public class ButtonGroup extends ContentPanel {

  /**
   * Creates a new button group.
   * 
   * @param columns the number of columns
   */
  public ButtonGroup(int columns) {
    super();
    baseStyle = "x-btn-group";
    frame = true;
    setLayout(new TableLayout(columns));
  }

  @Override
  protected void onAfterLayout() {
    TextMetrics.get().bind(head.el().selectNode("span"));
    int tw = TextMetrics.get().getWidth(getHeading()) + getFrameWidth();
    int bodyWidth = body.getFrameWidth("lr") + body.firstChild().getWidth();
    if (bodyWidth > 0) { // display none
      if (tw > bodyWidth) {
        bodyWidth = tw;
      }
      body.setWidth(bodyWidth);
      el().setWidth(bodyWidth + getFrameWidth());
    }
  }

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    if (getHeading() == null || (getHeading() != null && getHeading().equals("&#160;"))) {
      addStyleName("x-btn-group-notitle");
    }
  }
}