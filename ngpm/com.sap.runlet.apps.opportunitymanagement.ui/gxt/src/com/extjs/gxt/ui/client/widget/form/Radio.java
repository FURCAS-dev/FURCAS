/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;

/**
 * Single radio field. Same as Checkbox, but provided as a convenience for
 * automatically setting the input type. Radio grouping is handled automatically
 * by the browser if you give each radio in a group the same name.
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>Field Focus</dd>
 * <dd>Field Blur</dd>
 * <dd>Field Change</dd>
 * <dd>Field Invalid</dd>
 * <dd>Field Valid</dd>
 * <dd>Field KeyPress</dd>
 * <dd>Field SpecialKey</dd>
 * </dl>
 */
public class Radio extends CheckBox {

  protected RadioGroup group;

  /**
   * Returns the radios container group.
   * 
   * @return the group
   */
  public RadioGroup getGroup() {
    return group;
  }

  @Override
  public void setValue(Boolean value) {
    if (value == null) {
      value = new Boolean(false);
    }
    super.setValue(value);
    if (value && group != null) {
      group.onRadioSelected(this);
    }
  }

  @Override
  protected void fireChangeEvent(Object oldValue, Object value) {
    super.fireChangeEvent(oldValue, value);
    if ((Boolean) value && oldValue != value && group != null) {
      FieldEvent e = new FieldEvent(group);
      e.setOldValue(oldValue);
      e.setValue(value);
      group.fireEvent(Events.Change, e);
    }
  }

  @Override
  protected void onClick(ComponentEvent be) {
    if (readOnly) {
      be.stopEvent();
      return;
    }
    if (group != null) {
      group.onRadioClick(this);
    } else {
      setValue(true);
    }
  }

}
