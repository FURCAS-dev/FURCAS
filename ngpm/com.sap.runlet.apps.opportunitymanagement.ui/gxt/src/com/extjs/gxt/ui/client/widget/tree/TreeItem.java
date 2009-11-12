/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.tree;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.PartFactory;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.TreeEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.tree.Tree.Joint;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.Element;

/**
 * A item in a <code>Tree</code>. All events are bubbled to the item's parent
 * tree.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeAdd</b> : TreeEvent(tree, parent, item, index)<br>
 * <div>Fires before a item is added or inserted. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>tree : the source tree</li>
 * <li>parent : this</li>
 * <li>item : the item being added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRemove</b> : TreeEvent(tree, parent, item)<br>
 * <div>Fires before a item is removed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>tree : the source tree</li>
 * <li>parent : this</li>
 * <li>item : the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeExpand</b> : TreeEvent(tree, item)<br>
 * <div>Fires before a item is expanded. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>tree : the source tree</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeCollapse</b> : TreeEvent(tree, item)<br>
 * <div>Fires before a item is collapsed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>tree : the source tree</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : TreeEvent(tree, parent, item, index)<br>
 * <div>Fires after a item has been added or inserted.</div>
 * <ul>
 * <li>tree : the source tree</li>
 * <li>parent : this</li>
 * <li>item : the item that was added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : TreeEvent(tree, parent, item)<br>
 * <div>Fires after a item has been removed.</div>
 * <ul>
 * <li>tree : the source tree</li>
 * <li>parent : this</li>
 * <li>item : the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Expand</b> : TreeEvent(tree, item)<br>
 * <div>Fires after a item has been expanded.</div>
 * <ul>
 * <li>tree : the source tree</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Collapse</b> : TreeEvent(tree, item)<br>
 * <div>Fires after a item is collapsed.</div>
 * <ul>
 * <li>tree : the source tree</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CheckChange</b> : TreeEvent(tree, item)<br>
 * <div>Fires after a check state change.</div>
 * <ul>
 * <li>tree : the source tree</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dt><b>CSS:</b></dt>
 * <dd>.my-tree-item (the item itself)</dd>
 * <dd>.my-tree-item-text span (the tree item text)</dd>
 * </dl>
 * 
 * @deprecated see {@link TreePanel}
 */
public class TreeItem extends Component {

  protected boolean childrenRendered;
  protected boolean root, expanded, checked;
  protected Tree tree;
  protected TreeItemUI ui;

  TreeItem parentItem;
  String text, iconStyle, itemStyleName;

  private List<TreeItem> children;
  private boolean expandOnRender;
  private boolean leaf = true;
  private String textStyle;

  /**
   * Creates a new tree item.
   */
  public TreeItem() {
    children = new ArrayList<TreeItem>();
  }

  /**
   * Creates a new tree item.
   * 
   * @param text the item's text
   */
  public TreeItem(String text) {
    this();
    setText(text);
  }

  /**
   * Adds a child item.
   * 
   * @param item the item to be added
   */
  public void add(TreeItem item) {
    add(item, getItemCount());
  }

  public int getIndent() {
    return (getDepth()) * tree.getIndentWidth();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof TreeItem) {
      return getId().equals(((TreeItem)obj).getId());
    }
    return false;
  }

  /**
   * Inserts a child item at the specified position.
   * 
   * @param item the item to be added
   * @param index index at which the specified element is to be inserted
   */
  public void add(TreeItem item, int index) {
    TreeEvent te = new TreeEvent(tree);
    te.setParent(this);
    te.setItem(item);
    te.setIndex(index);
    if (fireEvent(Events.BeforeAdd, te)) {
      if (item.parentItem != null && item.parentItem != this) {
        item.parentItem.remove(item);
      } else if (item.parentItem != null && item.parentItem == parentItem) {
        children.remove(item);
        if (childrenRendered) {
          item.el().removeFromParent();
        }
      }
      item.parentItem = this;
      item.setTree(tree);
      tree.registerItem(item);

      children.add(index, item);
      leaf = false;
      if (childrenRendered) {
        Element target = root ? getContainer() : ui.getContainerElement();
        if (item.isRendered()) {
          fly(target).insertChild(item.getElement(), index);
          item.getUI().onIndentChange(getDepth());
          List<TreeItem> list = new ArrayList<TreeItem>();
          getAllChildren(list, item);
          for (TreeItem ti : list) {
            tree.registerItem(ti);
          }
        } else {
          item.render(target, index);
        }
      }
      if (rendered && !root && children.size() == 1) {
        fly(ui.getContainerElement()).setVisible(true);
        updateJointStyle();
        ui.onIconStyleChange(getIconStyle());
      }
      fireEvent(Events.Add, te);
    }
  }

  /**
   * Returns the item's first child.
   * 
   * @return the first child or <code>null</code>
   */
  public TreeItem firstChild() {
    for (TreeItem child : getItems()) {
      if (child.isVisible()) return child;
    }
    return null;
  }

  /**
   * Returns the item's container element.
   * 
   * @return the container
   */
  public Element getContainer() {
    return root ? getElement() : ui.getContainerElement();
  }

  /**
   * Returns the item's node depth.
   * 
   * @return the depth
   */
  public int getDepth() {
    int depth = 0;
    TreeItem p = getParentItem();
    while (p != null) {
      depth++;
      p = p.getParentItem();
    }
    return depth;
  }

  /**
   * Returns the item's icon style.
   * 
   * @return the icon style
   */
  public String getIconStyle() {
    return iconStyle;
  }

  /**
   * Returns the item at the specified index.
   * 
   * @param index the index
   * @return the item at the index
   */
  public TreeItem getItem(int index) {
    if ((index < 0) || (index >= getItemCount())) return null;
    return children.get(index);
  }

  /**
   * Returns the number of child items.
   * 
   * @return the child count
   */
  public int getItemCount() {
    return children.size();
  }

  /**
   * Returns the item's children.
   * 
   * @return the children items
   */
  public List<TreeItem> getItems() {
    return new ArrayList<TreeItem>(children);
  }

  /**
   * Returns the item's children.
   * 
   * @param deep true to retrieve all the item's children
   * @return the children items
   */
  @SuppressWarnings("unchecked")
  public List<TreeItem> getItems(boolean deep) {
    if (deep) {
      List list = new ArrayList();
      getAllChildren(list, this);
      return list;
    } else {
      return getItems();
    }
  }

  /**
   * Returns the item's style name.
   * 
   * @return the style name
   */
  public String getItemStyleName() {
    return itemStyleName;
  }

  /**
   * Returns the item's parent.
   * 
   * @return the parent item
   */
  public TreeItem getParentItem() {
    return parentItem;
  }

  /**
   * Returns the path for this node. The path can be used to expand or select
   * this node programmatically.
   * 
   * @return a comma separated list of tree item id's
   */
  public String getPath() {
    StringBuffer sb = new StringBuffer();
    TreeItem p = this;
    while (p != null) {
      String id = p.getId();
      sb.insert(0, "," + id);
      p = p.getParentItem();
    }
    return sb.toString().substring(1);
  }

  /**
   * Returns the item's text.
   * 
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Returns the item's text style.
   * 
   * @return the text style
   */
  public String getTextStyle() {
    return textStyle;
  }

  /**
   * Returns the item's ui instance.
   * 
   * @return the ui instance
   */
  public TreeItemUI getUI() {
    return ui;
  }

  /**
   * Returns <code>true</code> if the item's has children.
   * 
   * @return the children state
   */
  public boolean hasChildren() {
    return getItemCount() > 0;
  }

  /**
   * Returns the index of the item or -1 if not found.
   * 
   * @param item the child item
   * @return the item's index
   */
  public int indexOf(TreeItem item) {
    return children.indexOf(item);
  }

  /**
   * Returns <code>true</code> if the item is checked.
   * 
   * @return the checked state
   */
  public boolean isChecked() {
    return checked;
  }

  /**
   * Returns <code>true</code> if the item is expanded, and <code>false</code>
   * otherwise.
   * 
   * @return the expanded state
   */
  public boolean isExpanded() {
    return expanded;
  }

  /**
   * Returns <code>true</code> if the item is a leaf, and <code>false</code>
   * otherwise. The leaf state allows a tree item to specify if it has children
   * before the children have been realized.
   * 
   * @return the leaf state
   */
  public boolean isLeaf() {
    return leaf;
  }

  /**
   * Returns <code>true</code> if the item is a root item.
   * 
   * @return the root state
   */
  public boolean isRoot() {
    return root;
  }

  /**
   * Returns the item's last child.
   * 
   * @return the last child
   */
  public TreeItem lastChild() {
    for (int i = getItemCount() - 1; i >= 0; i--) {
      TreeItem child = getItem(i);
      if (child.isVisible()) return child;
    }
    return null;
  }

  /**
   * Returns the item next sibling.
   * 
   * @return the next sibling
   */
  public TreeItem nextSibling() {
    if (parentItem == null) return null;
    int index = parentItem.indexOf(this);
    for (int i = index + 1; i < parentItem.getItemCount(); i++) {
      if (parentItem.getItem(i).isVisible()) return parentItem.getItem(i);
    }
    return null;
  }

  public void onComponentEvent(ComponentEvent ce) {
    // delegate event handling to ui
    if (ui != null) {
      ui.handleEvent((TreeEvent) ce);
    }
  }

  /**
   * Returns the item's previous sibling.
   * 
   * @return the previous sibling
   */
  public TreeItem previousSibling() {
    if (parentItem == null) return null;
    int index = parentItem.indexOf(this);
    for (int i = index - 1; i >= 0; i--) {
      if (parentItem.getItem(i).isVisible()) return parentItem.getItem(i);
    }
    return null;
  }

  /**
   * Removes a child from the item.
   * 
   * @param item the item to be removed
   */
  public void remove(TreeItem item) {
    if (!children.contains(item)) {
      return;
    }
    TreeEvent te = new TreeEvent(tree);
    te.setParent(this);
    te.setItem(item);
    if (fireEvent(Events.BeforeRemove, te)) {
      children.remove(item);
      tree.unregisterItem(item);

      item.tree = null;
      item.parentItem = null;
      if (rendered && item.rendered) {
        if (root) {
          item.el().removeFromParent();
        } else {
          ui.onRemoveChild(item);
        }
      }
      fireEvent(Events.Remove, te);
    }
  }

  /**
   * Removes all child items.
   */
  public void removeAll() {
    int count = getItemCount();
    for (int i = 0; i < count; i++) {
      remove(getItem(0));
    }
    leaf = true;
  }

  /**
   * Sets the item's checked value.
   * 
   * @param checked <code>true</code> to check
   */
  public void setChecked(boolean checked) {
    this.checked = checked;
    if (rendered) {
      if (fireEvent(Events.BeforeCheckChange, new TreeEvent(tree, this))) {
        ui.onCheckChange(checked);
        if (checked) {
          switch (tree.getCheckStyle()) {
            case PARENTS:
              TreeItem p = getParentItem();
              while (p != null && !p.root) {
                p.setChecked(true);
                p = p.getParentItem();
              }
              break;
            case CHILDREN:
              for (int i = 0; i < getItemCount(); i++) {
                getItem(i).setChecked(true);
              }
              break;
          }
        } else {
          switch (tree.getCheckStyle()) {
            case PARENTS:
              clearCheckChildren(this);
              break;
            case CHILDREN:
              for (int i = 0; i < getItemCount(); i++) {
                getItem(i).setChecked(false);
              }
              break;
          }
        }
      }
    }
  }

  @Override
  public void setElement(Element elem) {
    super.setElement(elem);
    if (!root) {
      getUI().afterRender();
      rendered = true;

      if (expandOnRender) {
        boolean anim = tree.getAnimate();
        tree.setAnimate(false);
        setExpanded(true);
        tree.setAnimate(anim);
      }
    }
  }

  public void setTreeTableElement(Element elem) {
    super.setElement(elem);
  }

  /**
   * Sets the item's expanded state.
   * 
   * @param expanded <code>true</code> to expand
   */
  public void setExpanded(boolean expanded) {
    setExpanded(expanded, false);
  }

  /**
   * Sets the item's expand state.
   * 
   * @param expanded <code>true</code> to expand
   * @param deep <code>true</code> to expand all children
   */
  public void setExpanded(boolean expanded, boolean deep) {
    if (!rendered) {
      expandOnRender = expanded;
      return;
    }

    if (expanded && root) {
      this.expanded = false;
    } else if (!expanded && root) {
      this.expanded = true;
    }

    TreeEvent te = new TreeEvent(tree, this);

    if (expanded) {
      if (!this.expanded && !isLeaf()) {
        if (fireEvent(Events.BeforeExpand, te)) {
          this.expanded = true;
          if (!childrenRendered) {
            renderChildren();
          }
          ui.expand();
          TreeItem p = parentItem;
          while (p != null && !p.root) {
            if (p.expanded == false) {
              p.setExpanded(true);
            }
            p = p.parentItem;
          }
        }
        if (deep) {
          expandChildren(deep);
        }
      } else {
        if (deep) {
          expandChildren(deep);
        }
      }
    }

    else if (this.expanded && !expanded) {
      if (fireEvent(Events.BeforeCollapse, te)) {
        this.expanded = false;
        ui.collapse();
      }
      if (deep) {
        for (int i = 0; i < getItemCount(); i++) {
          TreeItem item = getItem(i);
          item.setExpanded(false, true);
        }
      }
    }
  }

  /**
   * Sets the item's icon style. The style name should match a CSS style that
   * specifies a background image using the following format:
   * 
   * <pre><code>
   * .my-icon {
   *    background: url(images/icons/my-icon.png) no-repeat center left !important;
   * }
   * </code></pre>
   * 
   * @param style the icon style
   */
  public void setIconStyle(String style) {
    this.iconStyle = style;
    if (rendered) {
      updateIconStyle();
    }
  }

  /**
   * Sets a style name that will be added to the tree item's element, not the
   * container element.
   * 
   * @param itemStyleName the style name
   */
  public void setItemStyleName(String itemStyleName) {
    this.itemStyleName = itemStyleName;
  }

  /**
   * Sets the item's leaf state. The leaf state allows a tree item to specify if
   * it has children before the children have been realized.
   * 
   * @param leaf the state
   */
  public void setLeaf(boolean leaf) {
    this.leaf = leaf;
  }

  /**
   * Sets the item's text.
   * 
   * @param text the new text
   */
  public void setText(String text) {
    this.text = text;
    if (rendered) {
      ui.onTextChange(text);
    }
  }

  /**
   * Sets the item's text style.
   * 
   * @param style the text style
   */
  public void setTextStyle(String style) {
    this.textStyle = style;
    if (rendered) {
      getUI().onTextStyleChange(textStyle);
    }
  }

  public void setUI(TreeItemUI ui) {
    this.ui = ui;
  }

  /**
   * Toggles the item's expand state.
   */
  public void toggle() {
    setExpanded(!isExpanded());
  }

  public String toString() {
    return "tree: " + (text != null ? text : "" + " ") + el();
  }

  public void updateIconStyle() {
    String style = calculateIconStyle();
    getUI().onIconStyleChange(style);
  }

  public void updateJointStyle() {
    getUI().onJointChange(calculateJoint());
  
    Element checkEl = ui.getCheckElement();
    if (tree.getCheckable()) {
      switch (tree.getCheckNodes()) {
        case BOTH:
          fly(checkEl).setVisible(true);
          break;
        case PARENT:
          fly(checkEl).setVisible(!isLeaf());
          break;
        case LEAF:
          fly(checkEl).setVisible(isLeaf());
          break;
      }
    }
  }

  protected Joint calculateJoint() {
    if (root) {
      return Joint.NONE;
    }
  
    Joint joint = Joint.NONE;
    if (!isLeaf()) {
      boolean children = false;
      boolean binder = tree != null ? tree.getData("binder") != null : false;
      boolean loaded = getData("loaded") != null;
      if ((!binder) || (binder && !loaded) || (binder && hasChildren())) {
        children = true;
      }
      if (isExpanded()) {
        joint = children ? Joint.EXPANDED : Joint.NONE;
      } else {
        joint = children ? Joint.COLLAPSED : Joint.NONE;
      }
    } else {
        joint = Joint.NONE;
    }
    return joint;
  }

  protected String calculateIconStyle() {
    String style = null;
    if (iconStyle != null) {
      style = iconStyle;
    } else {
      TreeStyle ts = tree.getStyle();
      if (!isLeaf()) {
        if (isExpanded() && ts.getNodeOpenIconStyle() != null) {
          style = ts.getNodeOpenIconStyle();
        } else if (isExpanded() && ts.getNodeOpenIconStyle() != null) {
          style = ts.getNodeCloseIconStyle();
        } else if (!isExpanded()) {
          style = ts.getNodeCloseIconStyle();
        }
      } else {
        style = ts.getLeafIconStyle();
      }
    }
    return style;
  }

  protected boolean fireEvent(EventType type, TreeEvent te) {
    boolean result = super.fireEvent(type, te);
    if (tree != null && result) {
      return tree.fireEvent(type, te);
    }
    return result;
  }

  protected TreeItemUI getTreeItemUI() {
    return ui;
  }

  protected void onRender(Element target, int index) {
    String s = getUI().getTemplate(getId(), getText(), calculateIconStyle(), 0, getDepth());
    setElement(XDOM.create(s), target, index);

    if (textStyle != null) {
      ui.onTextStyleChange(textStyle);
    }

    if (expandOnRender) {
      boolean anim = tree.getAnimate();
      tree.setAnimate(false);
      setExpanded(true);
      tree.setAnimate(anim);
    }
  }

  protected void renderChildren() {
    int count = getItemCount();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < count; i++) {
      TreeItem child = getItem(i);
      Joint joint = child.calculateJoint();
      sb.append(child.getUI().getTemplate(child.getId(), child.getText(), child.calculateIconStyle(), joint.value(), getDepth()));
    }

    getContainer().setInnerHTML(sb.toString());
    
    NodeList<Element> elems = getContainer().getChildNodes().cast();
    for (int i = 0, len = elems.getLength(); i < len; i++) {
      TreeItem child = getItem(i);
      child.setElement(elems.getItem(i));
    }
    childrenRendered = true;
  }

  protected void setChildrenRendered(boolean rendered) {
    childrenRendered = rendered;
  }

  protected void setRoot(boolean isRoot) {
    root = isRoot;
  }

  protected void setTree(Tree tree) {
    this.tree = tree;
    ui = PartFactory.createPart(tree.getTreeItemPartId());
    ui.bind(this);
  }

  boolean isFirst() {
    if (isRoot()) return true;
    return this == parentItem.getItem(0);
  }

  boolean isLast() {
    if (isRoot()) return true;
    return this == parentItem.getItem(parentItem.getItemCount() - 1);
  }

  private void clearCheckChildren(TreeItem parent) {
    for (int i = 0; i < parent.getItemCount(); i++) {
      TreeItem sub = parent.getItem(i);
      sub.setChecked(false);
      clearCheckChildren(sub);
    }
  }

  private void expandChildren(boolean deep) {
    for (int i = 0; i < getItemCount(); i++) {
      TreeItem item = getItem(i);
      item.setExpanded(true, deep);
    }
  }

  private void getAllChildren(List<TreeItem> list, TreeItem parent) {
    list.add(parent);
    for (TreeItem child : parent.getItems()) {
      list.add(child);
      getAllChildren(list, child);
    }
  }

}
