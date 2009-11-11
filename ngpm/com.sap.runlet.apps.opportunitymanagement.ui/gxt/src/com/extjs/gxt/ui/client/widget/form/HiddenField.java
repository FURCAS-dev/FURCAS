/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Element;

/**
 * A basic hidden field for storing hidden values in forms that need to be
 * passed in the form submit.
 * 
 * @param <D> the data type
 */
public class HiddenField<D> extends Field<D> {

  @Override
  protected void onRender(Element parent, int index) {
    if (el() == null) {
      setElement((Element) Document.get().createHiddenInputElement().cast(), parent, index);
    }
    super.onRender(parent, index);
  }

  @Override
  public void clearInvalid() {
  }

  @Override
  public void markInvalid(String msg) {
  }

  @Override
  protected boolean validateValue(String value) {
    return true;
  }

  @Override
  public boolean validate(boolean silent) {
    return true;
  }

}
