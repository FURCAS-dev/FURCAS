/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treegrid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.TreeGridEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.store.TreeStoreEvent;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.GridView;
import com.extjs.gxt.ui.client.widget.treepanel.TreeStyle;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.Joint;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * A hierarchical tree grid bound to a <code>TreeStore</code>.
 * 
 * <p />
 * A <code>TreeGridCellRenderer</code> can be assigned to the
 * <code>ColumnConfig</code> in which the tree will be displayed.
 * 
 * @param <M> the model type
 */
public class TreeGrid<M extends ModelData> extends Grid<M> {

  public class TreeNode {

    protected M m;
    protected String id;
    protected Element joint, check, text;
    private boolean expanded = false;
    private boolean expand;
    private boolean leaf = true;
    private boolean childrenRendered;
    private boolean loaded;

    public TreeNode(String id, M m) {
      this.id = id;
      this.m = m;
      if (loader != null && !loaded) {
        leaf = !loader.hasChildren(m);
      }
    }

    public int getItemCount() {
      return treeStore.getChildCount(m);
    }

    public M getModel() {
      return m;
    }

    public TreeNode getParent() {
      M p = treeStore.getParent(m);
      return findNode(p);
    }

    public int indexOf(TreeNode child) {
      M c = child.getModel();
      return store.indexOf(c);
    }

    public boolean isExpanded() {
      return expanded;
    }

    public boolean isLeaf() {
      return !hasChildren(m);
    }

    public void setExpanded(boolean expand) {
      TreeGrid.this.setExpanded(m, expand);
    }
  }

  protected Map<String, TreeNode> nodes = new FastMap<TreeNode>();
  protected Map<M, String> cache = new HashMap<M, String>();
  protected TreeStore<M> treeStore;
  protected TreeLoader<M> loader;
  protected TreeGridView treeGridView;

  private ModelIconProvider<M> iconProvider;
  private TreeStyle style = new TreeStyle();
  private boolean autoLoad, filtering;
  private boolean caching = true;
  private StoreListener<M> storeListener = new StoreListener<M>() {
    @Override
    public void storeAdd(StoreEvent<M> se) {
      onAdd((TreeStoreEvent<M>) se);
    }

    @Override
    public void storeClear(StoreEvent<M> se) {
      onDataChanged((TreeStoreEvent<M>) se);
    }

    @Override
    public void storeDataChanged(StoreEvent<M> se) {
      onDataChanged((TreeStoreEvent<M>) se);
    }

    @Override
    public void storeFilter(StoreEvent<M> se) {
      onFilter((TreeStoreEvent<M>) se);
    }

    @Override
    public void storeRemove(StoreEvent<M> se) {
      onRemove((TreeStoreEvent<M>) se);
    }

    @Override
    public void storeUpdate(StoreEvent<M> se) {
      onUpdate((TreeStoreEvent<M>) se);
    }
  };

  private ListStore<M> listStore = new ListStore<M>() {
    public Record getRecord(M model) {
      return treeStore.getRecord(model);
    };

    public boolean hasRecord(M model) {
      return treeStore.hasRecord(model);

    };

  };

  @SuppressWarnings("unchecked")
  public TreeGrid(TreeStore store, ColumnModel cm) {
    this.store = listStore;
    this.cm = cm;
    this.view = new GridView();
    focusable = true;
    baseStyle = "x-grid-panel";
    setSelectionModel(new GridSelectionModel<M>());

    this.treeStore = store;
    this.loader = treeStore.getLoader();

    addStyleName("x-treegrid");

    treeStore.addStoreListener(storeListener);

    treeGridView = new TreeGridView();
    setView(treeGridView);

    setSelectionModel(new TreeGridSelectionModel<M>());
  }

  /**
   * Returns the tree style.
   * 
   * @return the tree style
   */
  public TreeStyle getStyle() {
    return style;
  }

  /**
   * Returns the tree's tree store.
   * 
   * @return the tree store
   */
  public TreeStore<M> getTreeStore() {
    return treeStore;
  }

  /**
   * Returns the tree's view.
   * 
   * @return the view
   */
  public TreeGridView getTreeView() {
    return treeGridView;
  }

  /**
   * Returns true if the model is expanded.
   * 
   * @param model the model
   * @return true if expanded
   */
  public boolean isExpanded(M model) {
    TreeNode node = findNode(model);
    return node.expanded;
  }

  /**
   * Returns true if the model is a leaf node. The leaf state allows a tree item
   * to specify if it has children before the children have been realized.
   * 
   * @param model the model
   * @return the leaf state
   */
  public boolean isLeaf(M model) {
    TreeNode node = findNode(model);
    return node.isLeaf();
  }

  /**
   * Sets the item's expand state.
   * 
   * @param model the model
   * @param expand true to expand
   */
  public void setExpanded(M model, boolean expand) {
    setExpanded(model, expand, false);
  }

  /**
   * Sets the item's expand state.
   * 
   * @param model the model
   * @param expand true to expand
   * @param deep true to expand all children recursively
   */
  public void setExpanded(M model, boolean expand, boolean deep) {
    TreeNode node = findNode(model);
    if (node != null) {
      TreeGridEvent<M> tge = new TreeGridEvent<M>(this);
      tge.setModel(model);
      if (expand) {
        if (!node.isLeaf()) {
          // if we have a loader and node is not loaded make
          // load request and exit method
          if (loader != null && (!node.loaded || !caching) && !filtering) {
            treeStore.removeAll(model);
            node.expand = true;
            loader.loadChildren(model);
            return;
          }
          if (!node.expanded && fireEvent(Events.BeforeExpand, tge)) {
            node.expanded = true;

            if (!node.childrenRendered) {
              renderChildren(model);
              node.childrenRendered = true;
            }
            // expand
            treeGridView.expand(node);

            M parent = treeStore.getParent(model);
            while (parent != null) {
              TreeNode pnode = findNode(parent);
              if (!pnode.expanded) {
                setExpanded(pnode.m, true);
              }
              parent = treeStore.getParent(parent);
            }
            fireEvent(Events.Expand, tge);
          }
        }
        if (deep) {
          setExpandChildren(model, true);
        }

      } else {
        if (node.expanded && fireEvent(Events.BeforeCollapse, tge)) {
          node.expanded = false;
          // collapse
          treeGridView.collapse(node);
          fireEvent(Events.Collapse, tge);
        }
        if (deep) {
          setExpandChildren(model, false);
        }
      }
    }
  }

  /**
   * Toggles the model's expand state.
   * 
   * @param model the model
   */
  public void toggle(M model) {
    TreeNode node = findNode(model);
    if (node != null) {
      setExpanded(model, !node.expanded);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new TreeGridEvent(this, event);
  }

  protected TreeNode findNode(ModelData model) {
    if (model == null) return null;
    return nodes.get(cache.get(model));
  }

  protected boolean hasChildren(M model) {
    TreeNode node = findNode(model);
    if (loader != null && !node.loaded) {
      return loader.hasChildren(model);
    }
    if (!node.leaf || treeStore.getChildCount(model) > 0) {
      return true;
    }
    return false;
  }

  protected void onAdd(TreeStoreEvent<M> se) {

  }

  @Override
  protected void onClick(GridEvent<M> e) {
    M m = e.getModel();
    if (m != null) {
      TreeNode node = findNode(m);
      if (node != null) {
        if (e.within(treeGridView.getJointElement(node))) {
          toggle(m);
        } else {
          super.onClick(e);
        }
      }
    }
  }

  protected void onDataChanged(TreeStoreEvent<M> se) {
    if (!isRendered()) {
      return;
    }

    M p = se.getParent();
    if (p == null) {
      store.removeAll();
      nodes.clear();
      renderChildren(null);
    } else {
      TreeNode n = findNode(p);
      n.loaded = true;

      if (n.childrenRendered) {
        // n.container.setInnerHTML("");
      }

      renderChildren(p);

      if (n.expand && !n.isLeaf()) {
        n.expand = false;
        setExpanded(p, true);
      }
    }
  }

  @Override
  protected void onDoubleClick(GridEvent<M> e) {
    super.onDoubleClick(e);
    M m = e.getModel();
    if (m != null) {
      TreeNode node = findNode(m);
      setExpanded(node.m, !node.expanded);
    }
  }

  protected void onFilter(TreeStoreEvent<M> se) {

  }

  protected void onRemove(TreeStoreEvent<M> se) {
    unregister(se.getModel());
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);

    el().setTabIndex(0);
    el().setElementAttribute("hideFocus", "true");

    if (treeStore.getRootItems().size() == 0 && loader != null) {
      loader.load();
    } else {
      renderChildren(null);
    }

    sinkEvents(Event.ONCLICK | Event.ONDBLCLICK | Event.MOUSEEVENTS | Event.KEYEVENTS);
  }

  protected void onUpdate(TreeStoreEvent<M> se) {
    store.fireEvent(Store.Update, se);
  }

  protected void refresh(M model) {
    TreeNode node = findNode(model);
    if (node != null) {
      AbstractImagePrototype style = calculateIconStyle(model);
      treeGridView.onIconStyleChange(findNode(model), style);
      Joint j = calcualteJoint(model);
      treeGridView.onJointChange(node, j);
    }
  }

  protected String register(M m) {
    String id = XDOM.getUniqueId();
    if (cache.get(m) != null) {
      id = cache.get(m);
    }
    if (!nodes.containsKey(id)) {
      cache.put(m, id);
      nodes.put(id, new TreeNode(id, m));
    }
    return id;
  }

  protected void renderChildren(M parent) {
    List<M> children = parent == null ? treeStore.getRootItems() : treeStore.getChildren(parent);

    for (M child : children) {
      register(child);
    }

    if (parent == null) {
      store.add(children);
    }

    for (M child : children) {
      if (loader != null) {
        if (autoLoad) {
          if (store.isFiltered()) {
            renderChildren(child);
          } else {
            loader.loadChildren(child);
          }
        }
      }
    }
  }

  protected void unregister(M m) {
    if (m != null) {
      nodes.remove(cache.get(m));
      cache.remove(m);
    }
  }

  Joint calcualteJoint(ModelData model) {
    if (model == null) {
      return Joint.NONE;
    }
    TreeNode node = findNode(model);
    Joint joint = Joint.NONE;

    if (!node.isLeaf()) {
      boolean children = true;

      if (node.isExpanded()) {
        joint = children ? Joint.EXPANDED : Joint.NONE;
      } else {
        joint = children ? Joint.COLLAPSED : Joint.NONE;
      }
    }
    return joint;
  }

  @SuppressWarnings("unchecked")
  AbstractImagePrototype calculateIconStyle(ModelData model) {
    AbstractImagePrototype style = null;
    if (iconProvider != null) {
      AbstractImagePrototype iconStyle = iconProvider.getIcon((M) model);
      if (iconStyle != null) {
        return iconStyle;
      }
    }
    TreeNode node = findNode(model);
    TreeStyle ts = getStyle();
    if (!node.isLeaf()) {
      boolean ex = isExpanded((M) model);
      if (ex && ts.getNodeOpenIcon() != null) {
        style = ts.getNodeOpenIcon();
      } else if (ex && ts.getNodeOpenIcon() != null) {
        style = ts.getNodeCloseIcon();
      } else if (!ex) {
        style = ts.getNodeCloseIcon();
      }
    } else {
      style = ts.getLeafIcon();
    }
    return style;
  }

  private void setExpandChildren(M m, boolean expand) {
    for (M child : treeStore.getChildren(m)) {
      setExpanded(child, expand, true);
    }
  }
}
