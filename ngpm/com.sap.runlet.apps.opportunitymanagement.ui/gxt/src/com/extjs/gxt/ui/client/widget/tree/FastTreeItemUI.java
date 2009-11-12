/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.tree;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.tree.Tree.Joint;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;


/**
 * @deprecated see {@link TreePanel}
 */
public class FastTreeItemUI extends DefaultTreeItemUI {

  public FastTreeItemUI() {
    styleTreeJointOver = "x-ftree-ec-over";
    styleTreeOver = "x-ftree-node-over";
    styleTreeSelected = "x-ftree-selected";
  }

  public void afterRender() {
    if (item.root) return;

    itemEl = item.getElement().getFirstChild().cast();
    jointEl = itemEl.getFirstChild().cast();

    iconEl = jointEl.getNextSibling().cast();
    textEl = iconEl.getNextSibling().cast();
    containerEl = new El((Element) itemEl.getNextSibling().cast());
    containerEl.setVisible(false);
    
//    item.updateJointStyle();
//    item.disableTextSelection(true);
  }

  @Override
  public Element getJointElement() {
    return jointEl;
  }

  @Override
  public native String getTemplate(String id, String text, String iconStyle, int joint, int level) /*-{
     var j = "";
     switch (joint) {
       case(1):
        j = "x-ftree-joint-plus";
        break;
        case(2):
        j = "x-ftree-joint-minus";
        break;
     
     }
     return ['<div id=' + id + ' class="x-tree-item x-ftree-arrows">',
               '<div class="x-ftree-node x-ftree-collapsed">',
               '<img src="gxt/images/default/shared/clear.gif" class="x-ftree-joint ' + j + '"></img><img src="gxt/images/default/shared/clear.gif" class="x-ftree-icon ' + iconStyle + '"></img><span class="x-ftree-text">' + text + '</span>',
               '</div>',
               '<div class="x-ftree-el-ct" style="margin-left: 18px"/></div>',
             '</div>'].join("");
   }-*/;

  @Override
  public boolean isSelectableTarget(Element target) {
    if (DOM.isOrHasChild(jointEl, target)) {
      return false;
    }
    return true;
  }
  
  @Override
  public void onIconStyleChange(String style) {
    if (style != null) {
      fly(iconEl).setStyleAttribute("display", "");
      fly(iconEl).setStyleName("x-ftree-icon " + style);
    } else {
      fly(iconEl).setStyleAttribute("display", "none");
    }
  }
  
  @Override
  public void onIndentChange(int indent) {

  }

  @Override
  public void onJointChange(Joint joint) {
    switch (joint) {
      case NONE:
        jointEl.setClassName("x-ftree-joint");
        break;
      case EXPANDED:
        jointEl.setClassName("x-ftree-joint x-ftree-joint-minus");
        break;
      case COLLAPSED:
        jointEl.setClassName("x-ftree-joint x-ftree-joint-plus");
        break;

    }
  }

  @Override
  public void onSelectedChange(boolean selected) {
    if (item.isRendered()) {
      fly(itemEl).setStyleName(styleTreeSelected, selected);
      if (!selected) {
        onOverChange(false);
      }
    }
  }

}
