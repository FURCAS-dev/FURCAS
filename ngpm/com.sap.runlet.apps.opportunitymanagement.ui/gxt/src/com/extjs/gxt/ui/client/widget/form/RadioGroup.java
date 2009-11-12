/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.extjs.gxt.ui.client.GXT;

/**
 * A group of Radio's.
 * 
 * <dl>
 * <dt>Events:</dt>
 * 
 * <dd><b>Change</b> : FieldEvent(field, value, oldValue)<br>
 * <div>Fires after a child radio is selected.</div>
 * <ul>
 * <li>field : this the group, not the radio</li>
 * </ul>
 * </dd>
 * </dl>
 */
public class RadioGroup extends MultiField<Radio> {

  /**
   * TextField Messages.
   */
  public class RadioGroupMessages extends FieldMessages {
    private String selectionRequired = GXT.MESSAGES.textField_blankText();

    public String getSelectionRequired() {
      return selectionRequired;
    }

    public void setSelectionRequired(String selectionRequired) {
      this.selectionRequired = selectionRequired;
    }
  }

  private static int autoId = 0;
  private String groupName;
  private boolean selectionRequired;

  /**
   * Creates a new radio group.
   */
  public RadioGroup() {
    this("gxt.RadioGroup." + (autoId++));
  }

  /**
   * Creates a new radio group.
   * 
   * @param name the group name
   */
  public RadioGroup(String name) {
    this.groupName = name;
    messages = new RadioGroupMessages();
    setSpacing(5);
  }
  
  public void add(Radio radio) {
    super.add(radio);
    radio.group = this;
    radio.setName(groupName);
  }

  @Override
  public RadioGroupMessages getMessages() {
    return (RadioGroupMessages) messages;
  }

  /**
   * Returns the selected radio.
   */
  @Override
  public Radio getValue() {
    for (int i = 0; i < getAll().size(); i++) {
      Radio r = (Radio)getAll().get(i);
      if (r.getValue()) {
        return r;
      }
    }
    return null;
  }

  /**
   * Returns true if a selection is required.
   * 
   * @return the selection required state
   */
  public boolean isSelectionRequired() {
    return selectionRequired;
  }

  @Override
  public boolean isValid(boolean preventMark) {
    if (selectionRequired) {
      boolean sel = false;
      for (int i = 0; i < getAll().size(); i++) {
        Radio r = (Radio)getAll().get(i);
        if (r.getValue()) {
          sel = true;
        }
      }

      if (!sel) {
        boolean restore = this.preventMark;
        this.preventMark = preventMark;
        markInvalid(getMessages().getSelectionRequired());
        this.preventMark = restore;
        return false;
      }
    }
    for (int i = 0; i < getAll().size(); i++) {
      Radio radio = (Radio)getAll().get(i);
      if (!radio.isValid(preventMark)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Sets whether a selection is required when validating the group (defaults to
   * false).
   * 
   * @param selectionRequired true to require a selection
   */
  public void setSelectionRequired(boolean selectionRequired) {
    this.selectionRequired = selectionRequired;
  }

  @Override
  public void setValue(Radio value) {
    for (int i = 0; i < getAll().size(); i++) {
      Radio r = (Radio)getAll().get(i);
      if (r.equals(value)) {
        r.setValue(true);
      }
    }
  }

  protected void onRadioClick(Radio radio) {
    for (int i = 0; i < getAll().size(); i++) {
      Radio r = (Radio)getAll().get(i);
      if (r == radio) {
        r.setValue(true);
      } else {
        r.setValue(false);
      }
    }
  }

  protected void onRadioSelected(Radio radio) {
    for (int i = 0; i < getAll().size(); i++) {
      Radio r = (Radio)getAll().get(i);
      if (r != radio && r.getValue()) {
        r.setValue(false);
      }
    }
    clearInvalid();
  }

}
