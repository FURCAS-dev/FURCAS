/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.dnd;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * A custom component used to display the status of the drag operation and
 * information about the data being dragged. The component is displayed next to
 * the cursor as the user drags data.
 */
public class StatusProxy extends BoxComponent {

  private static StatusProxy instance;

  /**
   * Returns the singleton instance.
   * 
   * @return the status proxy
   */
  public static StatusProxy get() {
    if (instance == null) {
      instance = new StatusProxy();
      instance.render(DOM.createDiv());
    }
    return instance;
  }

  private El ghost;
  private boolean status;
  private String dropStatus;
  protected String dropAllowed = "x-dd-drop-ok";
  protected String dropNotAllowed = "x-dd-drop-nodrop";

  StatusProxy() {
    setShadow(true);
  }

  /**
   * Updates the proxy's visual element to indicate the status of whether or not
   * drop is allowed over the current target element.
   * 
   * @param allowed true for the standard ok icon, false fo standard no icon
   */
  public void setStatus(boolean allowed) {
    setStatus(allowed, allowed ? dropAllowed : dropNotAllowed);
  }

  /**
   * Returns true if the drop is allowed.
   * 
   * @return the status
   */
  public boolean getStatus() {
    return status;
  }

  /**
   * Updates the proxy's visual element to indicate the status of whether or not
   * drop is allowed over the current target element.
   * 
   * @param cssClass cssClass the css class for the new drop status indicator
   *          image
   */
  public void setStatus(boolean status, String cssClass) {
    this.status = status;
    if (cssClass == null) {
      cssClass = dropNotAllowed;
    }
    if (dropStatus == null || !dropStatus.equals(cssClass)) {
      el().replaceStyleName(dropStatus, cssClass);
      dropStatus = cssClass;
    }
  }

  /**
   * Updates the contents of the ghost element.
   * 
   * @param element the new ghost content
   */
  public void update(Element element) {
    ghost.setInnerHtml("");
    ghost.setStyleAttribute("margin", "");
    ghost.appendChild(element);
  }

  /**
   * Updates the contents of the ghost element.
   * 
   * @param html the html that will replace the current contents of the ghost
   *          element
   */
  public void update(String html) {
    ghost.setInnerHtml(html);
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    setStyleName("x-dd-drag-proxy");

    el().createChild("<div class=x-dd-drop-icon></div>");
    ghost = el().createChild("<div class=x-dd-drag-ghost></div>");
    setStatus(false);
  }

}
