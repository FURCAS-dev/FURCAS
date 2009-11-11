/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.binder;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.ModelComparer;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.event.CheckChangedEvent;
import com.extjs.gxt.ui.client.event.CheckChangedListener;
import com.extjs.gxt.ui.client.event.CheckProvider;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TreeEvent;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.store.TreeStoreEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.DataListItem;
import com.extjs.gxt.ui.client.widget.tree.Tree;
import com.extjs.gxt.ui.client.widget.tree.TreeItem;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;

/**
 * A <code>StoreBinder</code> implementation for Trees.
 * 
 * @param <M> the model type
 * 
 * @deprecated see {@link TreePanel}
 */
public class TreeBinder<M extends ModelData> extends StoreBinder<TreeStore<M>, Tree, M> implements
    CheckProvider<M> {

  protected Tree tree;
  protected TreeStore<M> store;
  protected TreeLoader<M> loader;
  protected String displayProperty;
  protected boolean autoLoad;

  private List<CheckChangedListener<M>> checkListeners;
  private boolean silent;
  private boolean caching = true;
  private boolean expandOnFilter = true;

  /**
   * Creates a new store binder.
   * 
   * @param tree the tree
   * @param store the tree store
   */
  public TreeBinder(final Tree tree, TreeStore<M> store) {
    super(store, tree);
    this.tree = tree;
    this.store = store;
    this.loader = store.getLoader();
  }

  public void addCheckListener(CheckChangedListener<M> listener) {
    if (checkListeners == null) {
      checkListeners = new ArrayList<CheckChangedListener<M>>();
    }
    if (!checkListeners.contains(listener)) {
      checkListeners.add(listener);
    }
  }

  @Override
  public Component findItem(M model) {
    ModelComparer<M> comparer = store.getModelComparer();
    for (TreeItem item : tree.getAllItems()) {
      if (comparer.equals(item.<M>getModel(), model)) {
        return item;
      }
    }
    return null;
  }

  public List<M> getCheckedSelection() {
    List<M> selection = new ArrayList<M>();
    for (TreeItem item : tree.getChecked()) {
      selection.add(item.<M>getModel());
    }
    return selection;
  }

  /**
   * Returns the display property.
   * 
   * @return the display property
   */
  public String getDisplayProperty() {
    return displayProperty;
  }

  /**
   * Returns the binder's tree.
   * 
   * @return the tree
   */
  public Tree getTree() {
    return tree;
  }

  /**
   * Returns the binder's tree store.
   * 
   * @return the tree store
   */
  public TreeStore<M> getTreeStore() {
    return store;
  }

  /**
   * Returns true if auto load is enabled.
   * 
   * @return the auto load state
   */
  public boolean isAutoLoad() {
    return autoLoad;
  }

  /**
   * Returns <code>true</code> if the binder is caching.
   * 
   * @return the caching state
   */
  public boolean isCaching() {
    return caching;
  }

  public boolean isChecked(M model) {
    DataListItem item = (DataListItem) findItem(model);
    if (item != null) {
      return item.isChecked();
    }
    return false;
  }

  /**
   * Returns the if expand all and collapse all is enabled on filter changes.
   * 
   * @return the expand all collapse all state
   */
  public boolean isExpandOnFilter() {
    return expandOnFilter;
  }

  public void removeCheckListener(CheckChangedListener<M> listener) {
    if (checkListeners != null) {
      checkListeners.remove(checkListeners);
    }
  }

  /**
   * Sets whether all children should automatically be loaded. Useful when using
   * filters.
   * 
   * @param autoLoad true to auto load
   */
  public void setAutoLoad(boolean autoLoad) {
    this.autoLoad = autoLoad;
  }

  /**
   * Sets whether the children should be cached after first being retrieved from
   * the store (defaults to true). When <code>false</code>, the tree items will
   * be removed when collapsed.
   * 
   * @param caching the caching state
   */
  public void setCaching(boolean caching) {
    this.caching = caching;
  }

  public void setCheckedSelection(List<M> selection) {
    silent = true;
    for (TreeItem item : tree.getChecked()) {
      if (item.isChecked()) {
        item.setChecked(false);
      }
    }

    for (M m : selection) {
      TreeItem item = (TreeItem) findItem(m);
      if (item != null) {
        item.setChecked(true);
      }
    }
    silent = false;
    fireCheckChanged(getCheckedSelection());
  }

  /**
   * Sets the display property name used to the item's text.
   * 
   * @param displayProperty the property
   */
  public void setDisplayProperty(String displayProperty) {
    this.displayProperty = displayProperty;
  }

  /**
   * Sets whether the tree should expand all and collapse all when filters are
   * applied (defaults to true).
   * 
   * @param expandOnFilter true to expand and collapse on filter changes
   */
  public void setExpandOnFilter(boolean expandOnFilter) {
    this.expandOnFilter = expandOnFilter;
  }

  protected void createAll() {
    TreeItem root = tree.getRootItem();
    root.removeAll();

    List<M> list = store.getRootItems();

    for (M element : list) {
      TreeItem item = null;
      if (store.isFiltered()) {
        if (isOrDecendantSelected(null, element)) {
          item = createItem(element);
        }
      } else {
        item = createItem(element);
      }
      tree.getRootItem().add(item);

      if (autoLoad && item != null) {
        item.setData("force", true);
        loadChildren(item, false);
      }
    }

    if (isAutoSelect() && list.size() > 0) {
      setSelection(list.get(0));
    }

  }

  protected TreeItem createItem(M model) {
    TreeItem item = new TreeItem();

    update(item, model);

    if (loader != null) {
      item.setLeaf(!loader.hasChildren(model));
    } else {
      item.setLeaf(!hasChildren(model));
    }

    setModel(item, model);
    return item;
  }

  protected void fireCheckChanged(List<M> selection) {
    if (checkListeners != null) {
      CheckChangedEvent<M> evt = new CheckChangedEvent<M>(this, selection);
      for (CheckChangedListener<M> listener : checkListeners) {
        listener.checkChanged(evt);
      }
    }
  }

  @Override
  protected List<M> getSelectionFromComponent() {
    List<TreeItem> selItems = tree.getSelectedItems();
    List<M> selected = new ArrayList<M>();
    for (TreeItem item : selItems) {
      selected.add(item.<M>getModel());
    }
    return selected;
  }

  protected boolean hasChildren(M parent) {
    return store.getChildCount(parent) != 0;
  }

  @Override
  protected void hook() {
    super.hook();
    component.setData("binder", true);
    component.addListener(Events.CheckChange, new Listener<TreeEvent>() {
      public void handleEvent(TreeEvent be) {
        if (!silent) {
          fireCheckChanged(getCheckedSelection());
        }
      }
    });
    Listener<TreeEvent> l = new Listener<TreeEvent>() {
      public void handleEvent(TreeEvent te) {
        EventType type = te.getType();
        if (type == Events.BeforeExpand) {
          onBeforeExpand(te);
        } else if (type == Events.Collapse) {
          onCollapse(te);
        }
      }
    };
    component.addListener(Events.BeforeExpand, l);
    component.addListener(Events.Collapse, l);
  }

  protected void loadChildren(final TreeItem item, boolean expand) {
    if (loader == null) {
      M model = item.<M>getModel();
      List<M> children = store.getChildren(model);
      renderChildren(model, children);
      return;
    }
    // if there is an async call out for my children already, Make
    // sure not to make another call and load the same items twice
    if (!item.isEnabled()) {
      return;
    }
    item.disable();

    if (item.isRendered() && !item.isRoot()) {
      item.getUI().onLoadingChange(true);
    }

    if (expand) {
      item.setData("expand", expand);
    }

    loader.loadChildren(item.<M>getModel());
  }

  @Override
  protected void onAdd(StoreEvent<M> se) {
    TreeStoreEvent<M> tse = (TreeStoreEvent<M>) se;
    M parent = tse.getParent();
    TreeItem item = null;
    if (parent == null) {
      item = tree.getRootItem();
    } else {
      item = (TreeItem) findItem(parent);
    }

    if (item == null) {
      return;
    }

    if (item.isRendered() && !item.isRoot()) {
      item.updateJointStyle();
      item.updateIconStyle();
    }

    if (item.isRoot() || item.getData("loaded") != null) {
      List<M> children = tse.getChildren();
      if (children.size() > 0) {
        item.setLeaf(false);
      }
      for (int i = children.size() - 1; i >= 0; i--) {
        item.add(createItem(children.get(i)), tse.getIndex());
      }
    } else if (item.getData("loaded") == null) {
      if (hasChildren(item.<M>getModel())) {
        item.setLeaf(false);
        if (item.isRendered()) {
          item.updateJointStyle();
        }
      }
    }
  }
  
  protected void onBeforeExpand(TreeEvent te) {
    TreeItem item = te.getItem();
    if (item.getData("loaded") == null) {
      item.setData("expand", true);
      te.setCancelled(true);
      loadChildren(item, true);
    }
  }

  protected void onCollapse(TreeEvent te) {
    if (!caching) {
      TreeItem item = te.getItem();
      store.removeAll(item.<M>getModel());
      item.setData("loaded", null);
      item.setLeaf(false);
      markChildrenRendered(item, false);
    }
  }

  @Override
  protected void onDataChanged(StoreEvent<M> se) {
    super.onDataChanged(se);
    TreeStoreEvent<M> te = (TreeStoreEvent<M>) se;
    if (te.getParent() == null) {
      createAll();
    } else {
      onRenderChildren(te);
    }
  }

  @Override
  protected void onFilter(StoreEvent<M> se) {
    filterItems(tree.getRootItem());
    boolean animated = tree.getAnimate();
    tree.setAnimate(false);
    if (store.isFiltered() && expandOnFilter) {
      tree.expandAll();
    } else if (!store.isFiltered() && expandOnFilter) {
      tree.collapseAll();
    }
    tree.setAnimate(animated);
  }

  @Override
  protected void onRemove(StoreEvent<M> se) {
    TreeStoreEvent<M> tse = (TreeStoreEvent<M>) se;
    TreeItem p = (TreeItem) findItem(tse.getParent());
    if (p == null) p = tree.getRootItem();
    p.remove((TreeItem) findItem(tse.getChild()));
  }

  protected void onRenderChildren(TreeStoreEvent<M> te) {
    renderChildren(te.getParent(), te.getChildren());
  }

  @Override
  protected void onSort(StoreEvent<M> se) {

  }

  @Override
  protected void onUpdate(StoreEvent<M> se) {
    update(se.getModel());
  }

  @Override
  protected void removeAll() {
    tree.removeAll();
  }

  protected void renderChildren(M parent, List<M> children) {
    TreeItem p = (TreeItem) findItem(parent);
    p.setData("loaded", true);
    p.enable();

    boolean leaf = p.isLeaf();
    p.removeAll();
    p.setLeaf(leaf);

    if (p.isRendered()) {
      p.getUI().onLoadingChange(false);
    }

    boolean f = p.getData("force") != null;
    p.setData("force", null);

    for (M child : children) {
      TreeItem item = createItem(child);
      p.add(item);
      if (f) {
        item.setData("force", true);
        loadChildren(item, false);
      }
    }

    if (!f && p.hasChildren() && p.getData("expand") != null) {
      p.setExpanded(true);
    } else if (p.isLeaf()) {
      p.setLeaf(true);
    }

    if (p.isRendered()) {
      p.updateJointStyle();
    }
    fireEvent(Events.Refresh);
  }

  @Override
  protected void setSelectionFromProvider(List<M> selection) {
    List<TreeItem> selected = new ArrayList<TreeItem>();
    for (M model : selection) {
      selected.add((TreeItem) findItem(model));
    }
    tree.setSelectedItems(selected);
  }

  @Override
  protected void update(M model) {
    update((TreeItem) findItem(model), model);
  }

  protected void update(TreeItem item, M model) {
    if (item != null) {
      setModel(item, model);
      String txt = getTextValue(model, displayProperty);
      if (txt == null && displayProperty != null) {
        txt = model.get(displayProperty);
      } else if (txt == null) {
        txt = model.toString();
      }

      String icon = getIconValue(model, displayProperty);
      String style = (styleProvider == null) ? null : styleProvider.getStringValue(model,
          displayProperty);

      item.setTextStyle(style);
      item.setText(txt);
      item.setIconStyle(icon);
    }

  }

  private void filterItems(TreeItem item) {
    if (item.isRoot() || isOrDecendantSelected(null, item.<M>getModel())) {
      item.setVisible(true);
      int count = item.getItemCount();
      for (int i = 0; i < count; i++) {
        filterItems(item.getItem(i));
      }
    } else {
      item.setVisible(false);
    }
  }

  private boolean isOrDecendantSelected(M parent, M model) {
    if (!isFiltered(parent, model)) {
      return true;
    }
    TreeItem item = (TreeItem) findItem(model);
    if (item != null) {
      for (TreeItem child : item.getItems()) {
        boolean result = isOrDecendantSelected(model, child.<M>getModel());
        if (result) {
          return true;
        }
      }
    }
    return false;
  }

  private native void markChildrenRendered(TreeItem item, boolean rendered) /*-{
     item.@com.extjs.gxt.ui.client.widget.tree.TreeItem::childrenRendered = rendered;
   }-*/;

}
