/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.toolbar;

import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * A label tool item.
 */
public class LabelToolItem extends BoxComponent {

  private String label;

  /**
   * Creates a new label.
   */
  public LabelToolItem() {

  }

  /**
   * Creates a new label.
   * 
   * @param label the label
   */
  public LabelToolItem(String label) {
    this.label = label;
  }

  /**
   * Returns the item's label.
   * 
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Sets the item's label.
   * 
   * @param label
   */
  public void setLabel(String label) {
    this.label = label;
    if (rendered) {
      getElement().setInnerHTML(label);
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    addStyleName("xtb-text");
    setLabel(label);
    super.onRender(target, index);
  }
}
