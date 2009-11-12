/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treetable;

import com.extjs.gxt.ui.client.widget.tree.TreeItemUI;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * RootTreeTableItem.
 * 
 * @deprecated see {@link TreeGrid}
 */
public class RootTreeTableItem extends TreeTableItem {

  public RootTreeTableItem(TreeTable treeTable) {
    super(new String[0]);
    this.tree = treeTable;
    getTreeItemUI();
  }

  @Override
  protected TreeItemUI getTreeItemUI() {
    ui = new TreeTableItemUI(this);
    ((TreeTableItemUI) ui).setContainer(getElement());
    setData("loaded", "true");
    return ui;
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
  }

  @Override
  protected void renderChildren() {
    if (!childrenRendered) {
      super.renderChildren();
    }
  }

}