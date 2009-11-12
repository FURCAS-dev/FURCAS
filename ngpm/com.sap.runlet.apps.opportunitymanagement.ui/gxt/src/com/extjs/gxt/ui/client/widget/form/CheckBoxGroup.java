/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import java.util.ArrayList;
import java.util.List;

/**
 * A group of CheckBox's.
 */
public class CheckBoxGroup extends MultiField<CheckBox> {

  /**
   * Creates a new check box group.
   */
  public CheckBoxGroup() {
    setSpacing(5);
  }

  /**
   * Returns the first checked check box.
   */
  @Override
  public CheckBox getValue() {
    for (Field<?> f : fields) {
      if (f instanceof CheckBox) {
        CheckBox check = (CheckBox) f;
        if (check.getValue()) {
          return check;
        }
      }
    }
    return null;
  }

  /**
   * Returns a list of all selected check boxes.
   * 
   * @return the list
   */
  public List<CheckBox> getValues() {
    List<CheckBox> values = new ArrayList<CheckBox>();
    for (Field<?> f : fields) {
      if (f instanceof CheckBox) {
        CheckBox check = (CheckBox) f;
        if (check.getValue()) {
          values.add(check);
        }
      }
    }
    return values;

  }

}
