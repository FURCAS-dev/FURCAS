/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;

/**
 * MessageBox event type.
 * 
 * <p />
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see MessageBox
 */
public class MessageBoxEvent extends WindowEvent {

  private Dialog dialog;
  private MessageBox messageBox;
  private String value;

  public MessageBoxEvent(MessageBox messageBox, Dialog window, Button buttonClicked) {
    super(window, buttonClicked);
    this.messageBox = messageBox;
    this.dialog = window;
  }

  /**
   * Returns the source dialog.
   * 
   * @return the source dialog
   */
  public Dialog getDialog() {
    return dialog;
  }

  /**
   * The source message box.
   * 
   * @return the message box
   */
  public MessageBox getMessageBox() {
    return messageBox;
  }

  /**
   * Returns the value.
   * 
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the source dialog.
   * 
   * @param dialog the source dialog
   */
  public void setDialog(Dialog dialog) {
    this.dialog = dialog;
  }

  /**
   * Sets the source message box.
   * 
   * @param messageBox the message box
   */
  public void setMessageBox(MessageBox messageBox) {
    this.messageBox = messageBox;
  }

  /**
   * Sets the field value. Only applies to prompt and multi-prompt message
   * boxes.
   * 
   * @param value the value
   */
  public void setValue(String value) {
    this.value = value;
  }

}
