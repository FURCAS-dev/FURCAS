/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treepanel;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.Joint;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.TreeNode;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

@SuppressWarnings("unchecked")
public class TreePanelView<M extends ModelData> {

  public enum TreeViewRenderMode {
    ALL, BODY, MAIN, CONTAINER
  };

  protected TreeStore<M> treeStore;
  protected TreePanel<M> tree;
  protected TreeNode over;

  private String collapseHtml = GXT.IMAGES.tree_collapsed().getHTML();
  private String expandHtml = GXT.IMAGES.tree_expanded().getHTML();
  private int cleanDelay = 500;
  private int cacheSize = 20;
  private int scrollDelay = 0;

  public void bind(Component component, Store store) {
    this.tree = (TreePanel) component;
    this.treeStore = (TreeStore) store;
  }

  public void collapse(TreeNode node) {
    getContainer(node).getStyle().setProperty("display", "none");
    tree.refresh((M) node.m);
  }

  public void expand(TreeNode node) {
    getContainer(node).getStyle().setProperty("display", "block");
    tree.refresh((M) node.m);
  }

  public int getCacheSize() {
    return cacheSize;
  }

  public Element getCheckElement(TreeNode node) {
    if (node.check == null) {
      node.check = ((NodeList<Element>) getElementContainer(node).getChildNodes().cast()).getItem(2);
    }
    return node.check;
  }

  public int getCleanDelay() {
    return cleanDelay;
  }

  public Element getContainer(TreeNode node) {
    if (node.container == null) {
      String s = getTemplate(null, null, null, null, false, null, 0, TreeViewRenderMode.CONTAINER);
      node.container = node.getElement().appendChild(XDOM.create(s));
    }
    return node.container;
  }

  public Element getElementContainer(TreeNode node) {
    if (node.elContainer == null) {
      node.elContainer = (Element) node.getElement().getFirstChild();
    }
    return node.elContainer;
  }

  public Element getIconElement(TreeNode node) {
    if (node.icon == null) {
      node.icon = ((NodeList<Element>) getElementContainer(node).getChildNodes().cast()).getItem(3);
    }
    return node.icon;
  }

  public Element getJointElement(TreeNode node) {
    if (node.joint == null) {
      node.joint = ((NodeList<Element>) getElementContainer(node).getChildNodes().cast()).getItem(1);
    }
    return node.joint;
  }

  public int getScrollDelay() {
    return scrollDelay;
  }

  public String getTemplate(ModelData m, String id, String text, AbstractImagePrototype icon, boolean checkable,
      Joint joint, int level, TreeViewRenderMode renderMode) {
    if (renderMode == TreeViewRenderMode.CONTAINER) {
      return "<ul class=\"x-tree3-node-ct\"></ul>";
    }
    StringBuilder sb = new StringBuilder();
    if (renderMode == TreeViewRenderMode.ALL || renderMode == TreeViewRenderMode.MAIN) {
      sb.append("<li id=\"");
      sb.append(id);
      sb.append("\" class=\"x-tree3-node\">");
      sb.append("<div class=\"x-tree3-el\">");
    }
    if (renderMode == TreeViewRenderMode.ALL || renderMode == TreeViewRenderMode.BODY) {
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
        // sb.append("<input type=\"checkbox\" />");
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
    }

    if (renderMode == TreeViewRenderMode.ALL || renderMode == TreeViewRenderMode.MAIN) {
      sb.append("</div>");
      sb.append("</li>");
    }
    return sb.toString();
  }

  public Element getTextElement(TreeNode node) {
    if (node.text == null) {
      node.text = ((NodeList<Element>) getElementContainer(node).getChildNodes().cast()).getItem(4);
    }
    return node.text;

  }

  public boolean isSelectableTarget(M m, Element target) {
    TreeNode n = tree.findNode(m);
    if (n == null) {
      return false;
    }
    boolean result = getJointElement(n) != target;
    if (result && tree.isCheckable()) {
      return getCheckElement(n) != target;
    }
    return result;
  }

  public void onCheckChange(TreeNode node, boolean check) {
    Element checkEl = (Element) getCheckElement(node);
    if (checkEl != null) {
      if (check) {
        node.check = (Element) node.getElement().getFirstChild().insertBefore(GXT.IMAGES.checked().createElement(),
            checkEl);
      } else {
        node.check = (Element) node.getElement().getFirstChild().insertBefore(GXT.IMAGES.unchecked().createElement(),
            checkEl);
      }
      El.fly(checkEl).remove();
    }
  }

  public void onEvent(TreePanelEvent ce) {
    int type = ce.getEventTypeInt();
    switch (type) {
      case Event.ONMOUSEOVER:
        if (tree.isTrackMouseOver()) {
          onMouseOver(ce);
        }
        break;
      case Event.ONMOUSEOUT:
        if (tree.isTrackMouseOver()) {
          onMouseOut(ce);
        }
        break;
    }
  }

  public void onIconStyleChange(TreeNode node, AbstractImagePrototype icon) {
    Element iconEl = getIconElement(node);
    if (iconEl != null) {
      if (icon != null) {
        node.icon = (Element) node.getElement().getFirstChild().insertBefore(icon.createElement(), iconEl);
      } else {
        node.getElement().getFirstChild().insertBefore(DOM.createSpan(), iconEl);
        node.icon = null;
      }
      El.fly(iconEl).remove();
    }
  }

  public void onJointChange(TreeNode node, Joint joint) {
    Element jointEl = getJointElement(node);
    if (jointEl != null) {
      switch (joint) {
        case EXPANDED:
          node.joint = (Element) node.getElement().getFirstChild().insertBefore(
              GXT.IMAGES.tree_expanded().createElement(), jointEl);
          break;
        case COLLAPSED:
          node.joint = (Element) node.getElement().getFirstChild().insertBefore(
              GXT.IMAGES.tree_collapsed().createElement(), jointEl);
          break;
        default:
          node.joint = null;
          node.getElement().getFirstChild().insertBefore(
              XDOM.create("<img src=\"" + GXT.BLANK_IMAGE_URL + "\" style='width: 16px'>"), jointEl);
      }
      El.fly(jointEl).remove();
    }
  }

  public void onLoadingChange(TreeNode node, boolean loading) {
    onIconStyleChange(node, GXT.IMAGES.icon_wait());
    if (loading) {

    } else {

    }
  }

  public void onOverChange(TreeNode node, boolean select) {
    El.fly(getElementContainer(node)).setStyleName("x-ftree2-node-over", select);
  }

  public void onSelectChange(M model, boolean select) {
    TreeNode node = tree.findNode(model);
    if (node != null) {
      El.fly(getElementContainer(node)).setStyleName("x-ftree2-selected", select);
    }
  }

  public void onTextChange(TreeNode node, String text) {
    Element textEl = getTextElement(node);
    if (textEl != null) {
      textEl.setInnerHTML(text);
    }
  }

  public void setCacheSize(int cacheSize) {
    this.cacheSize = cacheSize;
  }

  public void setCleanDelay(int cleanDelay) {
    this.cleanDelay = cleanDelay;
  }

  public void setScrollDelay(int scrollDelay) {
    this.scrollDelay = scrollDelay;
  }

  protected int getCalculatedRowHeight() {
    return 21;
  }

  protected void onMouseOut(TreePanelEvent ce) {
    if (over != null) {
      onOverChange(over, false);
      over = null;
    }
  }

  protected void onMouseOver(TreePanelEvent ce) {
    if (ce.getNode() != null) {
      if (over != ce.getNode()) {
        onMouseOut(ce);
        over = ce.getNode();
        onOverChange(over, true);
      }
    }

  }

}
