/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treegrid;

import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.grid.BufferView;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid.TreeNode;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.Joint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

@SuppressWarnings("unchecked")
public class TreeGridView extends BufferView {

  protected TreeGrid tree;
  protected TreeStore treeStore;

  private String collapseHtml = GXT.IMAGES.tree_collapsed().getHTML();
  private String expandHtml = GXT.IMAGES.tree_expanded().getHTML();

  public TreeGridView() {
    setRowSelectorDepth(20);
    setCellSelectorDepth(10);
  }

  public void collapse(TreeNode node) {
    ModelData p = node.m;
    ModelData lc = treeStore.getLastChild(p);

    if (tree.isExpanded(lc)) {
      lc = treeStore.getLastChild(lc);
    }

    int start = ds.indexOf(p);
    int end = ds.indexOf(lc);

    for (int i = end; i > start; i--) {
      ds.remove(grid.getStore().getAt(i));
    }
    tree.refresh(node.m);
  }

  public void expand(TreeNode node) {
    ModelData p = node.m;
    List<ModelData> children = treeStore.getChildren(p);
    int idx = ds.indexOf(p);

    ds.insert(children, idx + 1);

    for (ModelData child : children) {
      TreeNode cn = tree.findNode(child);
      if (cn.isExpanded()) {
        expand(cn);
      }
    }
    tree.refresh(node.m);
  }

  public Element getJointElement(TreeNode node) {
    Element row = getRowElement(node);
    if (row != null) {
      El jointEl = fly(row).selectNode(".x-tree3-el");
      return jointEl == null ? null : (Element) jointEl.dom.getChildNodes().getItem(1);
    }
    return null;
  }

  public String getTemplate(ModelData m, String id, String text,
      AbstractImagePrototype icon, boolean checkable, Joint joint, int level) {

    StringBuffer sb = new StringBuffer();
    sb.append("<div id=\"");
    sb.append(id);
    sb.append("\" class=\"x-tree3-node\">");

    sb.append("<div class=\"x-tree3-el\">");

    String h = "";
    switch (joint) {
      case COLLAPSED:
        h = collapseHtml;
        break;
      case EXPANDED:
        h = expandHtml;
        break;
      default:
        h = "<img src=\"" + GXT.BLANK_IMAGE_URL + "\" style='width: 16px'>";
    }

    sb.append("<img src=\"");
    sb.append(GXT.BLANK_IMAGE_URL);
    sb.append("\" style=\"height: 18px; width: ");
    sb.append(level * 18);
    sb.append("px;\" />");
    sb.append(h);
    if (checkable) {
      sb.append(GXT.IMAGES.unchecked().getHTML());
    } else {
      sb.append("<span></span>");
    }
    if (icon != null) {
      sb.append(icon.getHTML());
    } else {
      sb.append("<span></span>");
    }
    sb.append("<span class=\"x-tree3-node-text\">");
    sb.append(text);
    sb.append("</span>");

    sb.append("</div>");
    sb.append("</div>");

    return sb.toString();
  }

  public boolean isSelectableTarget(ModelData model, Element target) {
    TreeNode node = tree.findNode(model);
    if (node != null) {
      if (DOM.isOrHasChild(getJointElement(node), target)) {
        return false;
      }
    }
    return true;
  }

  public void onIconStyleChange(TreeNode node, AbstractImagePrototype icon) {
    El nodeEl = fly(getRowElement(node)).selectNode(".x-tree3-el");
    if (nodeEl != null) {
      Element iconEl = nodeEl.dom.getChildNodes().getItem(3).cast();
      if (iconEl != null) {
        if (icon != null) {
          iconEl.getParentElement().insertBefore(icon.createElement(), iconEl);
        } else {
          iconEl.getParentElement().insertBefore(DOM.createSpan(), iconEl);
        }
        El.fly(iconEl).remove();
      }
    }
  }

  public void onJointChange(TreeNode node, Joint joint) {
    Element jointEl = getJointElement(node);
    if (jointEl != null) {
      switch (joint) {
        case EXPANDED:
          jointEl.getParentElement().insertBefore(
              GXT.IMAGES.tree_expanded().createElement(), jointEl);
          break;
        case COLLAPSED:
          jointEl.getParentElement().insertBefore(
              GXT.IMAGES.tree_collapsed().createElement(), jointEl);
          break;
        default:
          jointEl.getParentElement().insertBefore(
              XDOM.create("<img src=\"" + GXT.BLANK_IMAGE_URL + "\" style='width: 16px'>"),
              jointEl);
      }
      El.fly(jointEl).remove();
    }
  }

  protected Element getRowElement(TreeNode node) {
    return getRow(ds.indexOf(node.m)).cast();
  }

  @Override
  protected void init(Grid grid) {
    super.init(grid);
    tree = (TreeGrid) grid;
    treeStore = tree.getTreeStore();
  }

  protected void onClick(GridEvent<ModelData> ce) {
    if (ce.getModel() != null && !isSelectableTarget(ce.getModel(), ce.getTarget())) {
      return;
    }
    super.onClick(ce);
  }

  @Override
  protected void onHeaderClick(Grid<ModelData> grid, int column) {

  }

}
