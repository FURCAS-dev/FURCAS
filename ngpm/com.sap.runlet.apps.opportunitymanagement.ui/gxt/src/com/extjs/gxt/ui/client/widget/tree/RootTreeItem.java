/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.tree;

import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * @deprecated see {@link TreePanel}
 */
class RootTreeItem extends TreeItem {

  public RootTreeItem(Tree tree) {
    this.tree = tree;
  }

  @Override
  protected TreeItemUI getTreeItemUI() {
    ui = new DefaultTreeItemUI() {
      @Override
      public Element getContainerElement() {
        return getElement();
      }
    };
    ui.bind(this);
    setData("loaded", true);
    setStyleName("my-root-item");
    return ui;
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    getTreeItemUI();
  }

}
