/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.PartFactory;
import com.extjs.gxt.ui.client.PartProvider;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.aria.FocusFrame;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.event.TreeEvent;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.selection.Selectable;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Accessibility;

/**
 * A standard hierarchical tree widget. The tree contains a hierarchy of
 * <code>TreeItems</code> that the user can open, close, and select.
 * 
 * <p/>
 * The root item cannot be displayed.
 * 
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeAdd</b> : TreeEvent(item, child, index)<br>
 * <div>Fires before a item is added or inserted. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>item : this</li>
 * <li>child : the item being added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRemove</b> : TreeEvent(item, child)<br>
 * <div>Fires before a item is removed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>item : this</li>
 * <li>child : the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeExpand</b> : TreeEvent(item)<br>
 * <div>Fires before a item is expanded. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeCollapse</b> : TreeEvent(item)<br>
 * <div>Fires before a item is collapsed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : TreeEvent(item, child, index)<br>
 * <div>Fires after a item has been added or inserted.</div>
 * <ul>
 * <li>item : this</li>
 * <li>child : the item that was added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : TreeEvent(tree, item, child)<br>
 * <div>Fires after a item has been removed.</div>
 * <ul>
 * <li>tree : this</li>
 * <li>item : item</li>
 * <li>child : the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeSelect</b> : TreeEvent(tree, item)<br>
 * <div>Fires before a item is selected. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>tree : this</li>
 * <li>item : the selected item</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>SelectionChange</b> : TreeEvent(tree, selected)<br>
 * <div>Fires after the tree selection changes.</div>
 * <ul>
 * <li>tree : this</li>
 * <li>selected : the selected items</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Expand</b> : TreeEvent(tree, item)<br>
 * <div>Fires after a item has been expanded.</div>
 * <ul>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Collapse</b> : TreeEvent(tree, item)<br>
 * <div>Fires after a item is collapsed.</div>
 * <ul>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CheckChange</b> : TreeEvent(tree, item)<br>
 * <div>Fires after a check state change.</div>
 * <ul>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ContextMenu</b> : TreeEvent(tree)<br>
 * <div>Fires before the tree's context menu is shown.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>KeyPress</b> : TreeEvent(tree, event)<br>
 * <div>Fires when a key is pressed.</div>
 * <ul>
 * <li>event : dom event</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>BoxComponent Move</dd>
 * <dd>BoxComponent Resize</dd>
 * <dd>Component Enable</dd>
 * <dd>Component Disable</dd>
 * <dd>Component BeforeHide</dd>
 * <dd>Component Hide</dd>
 * <dd>Component BeforeShow</dd>
 * <dd>Component Show</dd>
 * <dd>Component Attach</dd>
 * <dd>Component Detach</dd>
 * <dd>Component BeforeRender</dd>
 * <dd>Component Render</dd>
 * <dd>Component BrowserEvent</dd>
 * <dd>Component BeforeStateRestore</dd>
 * <dd>Component StateRestore</dd>
 * <dd>Component BeforeStateSave</dd>
 * <dd>Component SaveState</dd>
 * </dl>
 * 
 * <dl>
 * <dt><b>CSS:</b></dt>
 * <dd>.my-tree (the tree itself)</dd>
 * <dd>.my-tree-item-text span (the tree item text)</dd>
 * </dl>
 * 
 * @deprecated see {@link TreePanel}
 */
public class Tree extends Container<TreeItem> implements Selectable<TreeItem> {

  /**
   * Check cascade enum.
   */
  public enum CheckCascade {
    CHILDREN, NONE, PARENTS;
  }

  /**
   * Check nodes enum.
   */
  public enum CheckNodes {
    BOTH, LEAF, PARENT;
  }

  /**
   * Joint enum.
   */
  public enum Joint {
    NONE(0), COLLAPSED(1), EXPANDED(2);
    
    private int value;
    
    private Joint(int value) {
      this.value = value;
    }
    
    public int value() {
      return value;
    }
  }

  public static final String DEFAULT_TREE_ITEM_ID = "tree.item.default";
  public static final String FAST_TREE_ITEM_ID = "tree.item.fast";
  static {
    PartFactory.registerProvider(new PartProvider() {
      public Object createPart(String id) {
        if (id.equals(DEFAULT_TREE_ITEM_ID)) {
          return new DefaultTreeItemUI();
        } else if (id.equals(FAST_TREE_ITEM_ID)) {
          return new FastTreeItemUI();
        }
        return null;
      }
    });
  }

  protected boolean isViewer;
  protected TreeItem root;
  protected TreeSelectionModel sm;
  private boolean animate = true;
  private boolean checkable;
  private CheckNodes checkNodes = CheckNodes.BOTH;
  private CheckCascade checkStyle = CheckCascade.PARENTS;
  private int indentWidth = 18;
  private Map<String, TreeItem> nodeHash;
  private TreeStyle style = new TreeStyle();
  private String treeItemPartId = DEFAULT_TREE_ITEM_ID;
  private String itemSelector = ".x-tree-item";

  /**
   * Returns the item selector.
   * 
   * @return the item selector
   */
  public String getItemSelector() {
    return itemSelector;
  }

  /**
   * Sets the CSS selector used to retrieve tree items after bulk rendering
   * (defaults to '.x-tree-item').
   * 
   * @param itemSelector the item selector
   */
  public void setItemSelector(String itemSelector) {
    this.itemSelector = itemSelector;
  }

  /**
   * Creates a new single select tree.
   */
  public Tree() {
    attachChildren = false;
    baseStyle = "my-tree";
    focusable = true;
    createRootItem();
    root.root = true;
    nodeHash = new HashMap<String, TreeItem>();
    setSelectionModel(new TreeSelectionModel());
  }

  /**
   * Collapses all item's.
   */
  public void collapseAll() {
    boolean anim = animate;
    if (anim) animate = false;
    root.setExpanded(false, true);
    if (anim) animate = true;
  }

  /**
   * Expands all item's.
   */
  public void expandAll() {
    boolean anim = animate;
    if (anim) animate = false;
    root.setExpanded(true, true);
    if (anim) animate = true;
  }

  /**
   * Expands a specified path. A path can be retrieved from a tree item with
   * {@link TreeItem#getPath()}.
   * 
   * @param path the path to expand
   * @return <code>true</code> if all paths expanded
   */
  public boolean expandPath(String path) {
    if (path == null) return false;
    String[] ids = path.split(",");
    if (ids.length == 0) return false;
    if (ids[0].equals(root.getId())) {
      root.setExpanded(true);

      TreeItem current = root;
      for (int i = 1; i < ids.length; i++) {
        String id = ids[i];
        boolean match = false;
        for (int j = 0; j < current.getItemCount(); j++) {
          TreeItem child = current.getItem(j);
          if (!match && child.getId().equals(id)) {
            child.setExpanded(true);
            current = child;
            match = true;
            break;
          }
        }
        if (!match) {
          return false;
        }
      }

    }
    return true;
  }

  /**
   * Returns the tree whose element or child elements match the passed target.
   * 
   * @param element the target element
   * @return the matching tree item or <code>null</code> if no match
   */
  public TreeItem findItem(Element element) {
    Element elem = fly(element).findParentElement(itemSelector, 15);
    if (elem != null) {
      String id = elem.getId();
      if (id != null && !id.equals("")) {
        TreeItem item = getItemById(id);
        return item;
      }
    }
    return null;
  }

  /**
   * Returns the total number of items contained in the tree excluding the root
   * item.
   * 
   * @return the total item count
   */
  public int getAllItemCount() {
    return nodeHash.size();
  }

  /**
   * Returns all tree item's contained by the tree.
   * 
   * @return all tree item's
   */
  public List<TreeItem> getAllItems() {
    List<TreeItem> temp = new ArrayList<TreeItem>();
    temp.add(root);
    temp.addAll(nodeHash.values());
    return temp;
  }

  /**
   * Returns true if animations are enabled.
   * 
   * @return the animate state
   */
  public boolean getAnimate() {
    return animate;
  }

  /**
   * Returns true if check boxs are enabled.
   * 
   * @return the checkbox state
   */
  public boolean getCheckable() {
    return checkable;
  }

  /**
   * Returns a list of id's for all checked items.
   * 
   * @return the list of checked id's
   */
  public List<TreeItem> getChecked() {
    List<TreeItem> list = new ArrayList<TreeItem>();
    Iterator<TreeItem> it = nodeHash.values().iterator();
    while (it.hasNext()) {
      TreeItem item = it.next();
      if (item.isChecked()) {
        list.add(item);
      }
    }
    return list;
  }

  /**
   * Returns the child nodes value.
   * 
   * @return the child nodes value
   */
  public CheckNodes getCheckNodes() {
    return checkNodes;
  }

  /**
   * The check style value.
   * 
   * @return the check style
   */
  public CheckCascade getCheckStyle() {
    return checkStyle;
  }

  @Override
  public Menu getContextMenu() {
    // made public
    return super.getContextMenu();
  }

  /**
   * Returns the indent width.
   * 
   * @return the indent width
   */
  public int getIndentWidth() {
    return indentWidth;
  }

  @Override
  public TreeItem getItem(int index) {
    return getRootItem().getItem(index);
  }

  /**
   * Returns the item by id.
   * 
   * @param id the id of the element to return
   * @return the item
   */
  public TreeItem getItemById(String id) {
    return nodeHash.get(id);
  }

  /**
   * Returns the item icon style.
   * 
   * @return the icon style
   * @deprecated see {@link TreeStyle#getLeafIconStyle()}
   */
  public String getItemIconStyle() {
    return style.getLeafIconStyle();
  }

  /**
   * Returns the node icon style.
   * 
   * @return the icon style
   * @deprecated see {@link TreeStyle#getNodeCloseIconStyle()}
   */
  public String getNodeIconStyle() {
    return style.getNodeCloseIconStyle();
  }

  /**
   * Returns the open node icon style.
   * 
   * @return the icon style
   * @deprecated see {@link TreeStyle#getNodeOpenIconStyle()}
   */
  public String getOpenNodeIconStyle() {
    return style.getNodeOpenIconStyle();
  }

  /**
   * Returns the tree's root item. The root item cannot be displayed.
   * 
   * @return the root item
   */
  public TreeItem getRootItem() {
    return root;
  }

  /**
   * Returns the selected item.
   * 
   * @return the item
   */
  public TreeItem getSelectedItem() {
    return (TreeItem) sm.getSelectedItem();
  }

  /**
   * Returns the selected items.
   * 
   * @return the selected items
   */
  public List<TreeItem> getSelectedItems() {
    return sm.getSelectedItems();
  }

  public SelectionMode getSelectionMode() {
    return sm.getSelectionMode();
  }

  /**
   * Returns the tree's selection model.
   * 
   * @return the selection model
   */
  public TreeSelectionModel getSelectionModel() {
    return sm;
  }

  /**
   * Returns the tree's style.
   * 
   * @return the tree style
   */
  public TreeStyle getStyle() {
    return style;
  }

  /**
   * Returns the tree item part id.
   * 
   * @return the part id
   */
  public String getTreeItemPartId() {
    return treeItemPartId;
  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    TreeEvent te = (TreeEvent) ce;
    if (te.getItem() != null) {
      te.getItem().onComponentEvent(te);
    }
    
    int type = ce.getEventTypeInt();
    switch (type) {
      case Event.ONFOCUS:
        onFocus(ce);
        break; 
    }
  }

  protected void onFocus(ComponentEvent ce) {
    FocusFrame.get().frame(this);
  }

  public void onSelectChange(TreeItem item, boolean select) {
    item.getUI().onSelectedChange(select);
  }

  @Override
  public boolean removeAll() {
    getRootItem().removeAll();
    nodeHash.clear();
    return true;
  }

  /**
   * Sets whether expand /collapse should be animated (defaults to true).
   * 
   * @param animate the animate state
   */
  public void setAnimate(boolean animate) {
    this.animate = animate;
  }

  /**
   * Sets whether checkboxes are used in the tree.
   * 
   * @param checkable true for checkboxes
   */
  public void setCheckable(boolean checkable) {
    this.checkable = checkable;
  }

  /**
   * Sets which tree items will display a check box (defaults to BOTH).
   * <p>
   * Valid values are:
   * <ul>
   * <li>BOTH - both nodes and leafs</li>
   * <li>PARENT - only nodes with children</li>
   * <li>LEAF - only leafs</li>
   * </ul>
   * 
   * @param checkNodes the child nodes value
   */
  public void setCheckNodes(CheckNodes checkNodes) {
    this.checkNodes = checkNodes;
  }

  /**
   * Sets the cascading behavior for check tree (defaults to PARENTS).
   * <p>
   * Valid values are:
   * <ul>
   * <li>NONE - no cascading</li>
   * <li>PARENTS - cascade to parents</li>
   * <li>CHILDREN - cascade to children</li>
   * </ul>
   * 
   * @param checkStyle the child style
   */
  public void setCheckStyle(CheckCascade checkStyle) {
    this.checkStyle = checkStyle;
  }

  @Override
  public void setContextMenu(Menu menu) {
    super.setContextMenu(menu);
  }

  /**
   * Sets the number of pixels child items are indented. Default value is 18.
   * 
   * @param indentWidth the indent width
   */
  public void setIndentWidth(int indentWidth) {
    this.indentWidth = indentWidth;
  }

  /**
   * Sets the global icon style for leaf tree items. Individual tree items can
   * override this value by setting the the item's icon style.
   * 
   * @param itemImageStyle the image style
   * @deprecated see {@link TreeStyle#setLeafIconStyle(String)}
   */
  public void setItemIconStyle(String itemImageStyle) {
    style.setLeafIconStyle(itemImageStyle);
  }

  /**
   * The global icon style for tree items with children (defaults to
   * 'tree-folder'). Individual tree items can override this value by setting
   * the the item's icon style.
   * 
   * @param nodeIconStyle the node icon style
   * @deprecated see {@link TreeStyle#setNodeCloseIconStyle(String)}
   */
  public void setNodeIconStyle(String nodeIconStyle) {
    style.setNodeCloseIconStyle(nodeIconStyle);
  }

  /**
   * Sets the global icon style for expanded tree items (defaults to
   * 'tree-folder-open'). Individual tree items can override this value by
   * setting the the item's icon style.
   * 
   * @param openNodeIconStyle the open node icon style
   * @deprecated see {@link TreeStyle#setNodeOpenIconStyle(String)}
   */
  public void setOpenNodeIconStyle(String openNodeIconStyle) {
    style.setNodeOpenIconStyle(openNodeIconStyle);
  }

  public void setSelectedItem(TreeItem item) {
    sm.select(item, false);
  }

  public void setSelectedItems(List<TreeItem> items) {
    sm.select(items, false);
  }

  /**
   * Sets the table's selection mode.
   * 
   * @param mode the selection mode
   */
  public void setSelectionMode(SelectionMode mode) {
    setSelectionModel(new TreeSelectionModel(mode));
  }

  /**
   * Sets the tree's selection model.
   * 
   * @param sm the tree selection model
   */
  public void setSelectionModel(TreeSelectionModel sm) {
    assert sm != null;
    if (this.sm != null) {
      this.sm.bind(null);
    }
    this.sm = sm;
    sm.bind(this);
  }

  /**
   * Sets the part id used to obtain new tree item ui instances (defaults to
   * {@value #DEFAULT_TREE_ITEM_ID}.
   * 
   * @param treeItemPartId the tree item part id
   */
  public void setTreeItemPartId(String treeItemPartId) {
    this.treeItemPartId = treeItemPartId;
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new TreeEvent(this, event == null ? null : findItem(DOM.eventGetTarget(event)));
  }

  @Override
  @SuppressWarnings("unchecked")
  protected ContainerEvent createContainerEvent(TreeItem item) {
    return new TreeEvent(this, item);
  }

  protected void createRootItem() {
    root = new RootTreeItem(this);
    root.tree = this;
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    super.onRender(target, index);
    
    root.render(getElement());

    if (!root.childrenRendered) {
      root.renderChildren();
    }

    addStyleName("x-ftree-no-lines x-ftree-arrows");

 
    disableTextSelection(true);
    
    if (GXT.isAriaEnabled()) {
      new KeyNav<ComponentEvent>(this) {
        @Override
        public void onDown(ComponentEvent ce) {
          if (getSelectedItems().size() == 0 && getRootItem().getItemCount() > 0) {
            setSelectedItem(getRootItem().getItem(0));
          }
        }
      };
      setAnimate(false);
    }
    
    el().setTabIndex(0);
    el().setElementAttribute("hideFocus", "true");

    Accessibility.setRole(getElement(), Accessibility.ROLE_TREE);
    
    sinkEvents(Event.ONCLICK | Event.ONDBLCLICK | Event.KEYEVENTS | Event.MOUSEEVENTS | Event.FOCUSEVENTS);
  }

  void registerItem(TreeItem item) {
    nodeHash.put(item.getId(), item);
  }

  void unregisterItem(TreeItem item) {
    int count = item.getItemCount();
    for (int i = 0; i < count; i++) {
      unregisterItem(item.getItem(i));
    }
    nodeHash.remove(item.getId());
  }
}
