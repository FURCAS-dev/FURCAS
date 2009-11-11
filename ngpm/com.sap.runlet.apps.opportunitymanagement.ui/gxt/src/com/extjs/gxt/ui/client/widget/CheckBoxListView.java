/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.ModelData;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.Element;

public class CheckBoxListView<M extends ModelData> extends ListView<M> {

  private String checkBoxSelector = ".x-view-item-checkbox";

  public String getCheckBoxSelector() {
    return checkBoxSelector;
  }

  public List<M> getChecked() {
    List<M> l = new ArrayList<M>();
    NodeList<Element> nodes = el().select(checkBoxSelector);
    for (int i = 0; i < nodes.getLength(); i++) {
      InputElement e = nodes.getItem(i).cast();
      if (e.isChecked()) {
        l.add(getStore().getAt(i));
      }
    }
    return l;
  }

  public void setCheckBoxSelector(String checkBoxSelector) {
    this.checkBoxSelector = checkBoxSelector;
  }

  protected void onRender(Element target, int index) {
    if (getTemplate() == null) {
      String spacing = GXT.isIE ? "0" : "3";
      setTemplate(XTemplate.create("<tpl for=\".\"><div class='x-view-item x-view-item-check'><table cellspacing='" + spacing + "' cellpadding=0><tr><td><input class=\"x-view-item-checkbox\" type=\"checkbox\" /><td><td>{"
          + getDisplayProperty() + "}</td></tr></table></div></tpl>"));
    }
    super.onRender(target, index);
  }
}