/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.form.FormPanel;

/**
 * FormPanel event type.
 * 
 * @see FormPanel
 */
public class FormEvent extends ComponentEvent {

  private FormPanel formPanel;
  private String resultHtml;

  public FormEvent(FormPanel formPanel) {
    this(formPanel, null);
  }

  public FormEvent(FormPanel formPanel, String resultHtml) {
    super(formPanel);
    this.formPanel = formPanel;
    this.resultHtml = resultHtml;
  }

  /**
   * Returns the source form panel.
   * 
   * @return the form panel
   */
  public FormPanel getFormPanel() {
    return formPanel;
  }

  /**
   * Sets the source form panel.
   * 
   * @param formPanel the form panel
   */
  public void setFormPanel(FormPanel formPanel) {
    this.formPanel = formPanel;
  }

  /**
   * Returns the result html.
   * 
   * @return the result html
   */
  public String getResultHtml() {
    return resultHtml;
  }

  /**
   * Sets the result html.
   * 
   * @param resultHtml the result html
   */
  public void setResultHtml(String resultHtml) {
    this.resultHtml = resultHtml;
  }

}
