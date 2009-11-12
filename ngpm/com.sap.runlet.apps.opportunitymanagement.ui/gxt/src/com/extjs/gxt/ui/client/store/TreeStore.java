/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ChangeEvent;
import com.extjs.gxt.ui.client.data.ChangeEventSource;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.SortInfo;
import com.extjs.gxt.ui.client.data.TreeLoadEvent;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.event.LoadListener;
import com.extjs.gxt.ui.client.util.Util;

/**
 * A store for hierarchical data.
 * 
 * <p/>
 * The parent child relationships are handled internally by the store. It is
 * important to note that the store does not use the the parent and children of
 * any TreeModel instances added to the store.
 * 
 * <p/>
 * It is important to note the sorting behavior when working with TreeStore.
 * When a sorter is set, it is applied to all existing models in the cache and
 * the Sort event is fired. At this point, the sorter is enabled and active. All
 * sorter will be applied to all inserts into the store.
 * 
 * <p/>
 * Remote sorting is not supported with TreeStore.
 * 
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Store.BeforeDataChanged</b> : TreeStoreEvent(store)<br>
 * <div>Fires before the store's data is changed. Apply applies when a store is
 * bound to a loader.</div>
 * <ul>
 * <li>store : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.DataChange</b> : TreeStoreEvent(store)<br>
 * <div>Fires when the data cache has changed, and a widget which is using this
 * Store as a Model cache should refresh its view.</div>
 * <ul>
 * <li>store : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Filter</b> : TreeStoreEvent(store)<br>
 * <div>Fires when filters are applied and removed from the store.</div>
 * <ul>
 * <li>store : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Add</b> : TreeStoreEvent(store, parent, child)<br>
 * <div>Fires when models have been added to the store.</div>
 * <ul>
 * <li>store : this</li>
 * <li>parent : the parent</li>
 * <li>children : this list of model(s) added</li>
 * <li>index : the insert index</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Remove</b> : TreeStoreEvent(store, parent, child)<br>
 * <div>Fires when a model has been removed from the store.</div>
 * <ul>
 * <li>store : this</li>
 * <li>parent : the parent</li>
 * <li>child : the removed child</li>
 * <li>children : all the children of the removed item</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Update</b> : TreeStoreEvent(store, model, record)<br>
 * <div>Fires when a model has been updated via its record.</div>
 * <ul>
 * <li>store : this</li>
 * <li>model : the model that was updated</li>
 * <li>record : the record that was updated</li>
 * <li>operation : the update operation being performed.</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Clear</b> : TreeStoreEvent(store)<br>
 * <div>Fires when the data cache has been cleared.</div>
 * <ul>
 * <li>store : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Sort</b> : TreeStoreEvent(store)<br>
 * <div>Fires after a sorter is applied to the store.</div>
 * <ul>
 * <li>store : this</li>
 * </ul>
 * </dd>
 * 
 * </dt>
 */
public class TreeStore<M extends ModelData> extends Store<M> {

  protected Map<M, TreeModel> modelMap = new HashMap<M, TreeModel>();
  protected Map<TreeModel, M> wrapperMap = new HashMap<TreeModel, M>();
  protected BaseTreeModel rootWrapper = new BaseTreeModel();

  protected TreeLoader<M> loader;

  /**
   * Creates a new tree store.
   */
  public TreeStore() {
    super();
  }

  /**
   * Creates a new tree store.
   * 
   * @param loader the tree loader
   */
  public TreeStore(TreeLoader<M> loader) {
    this.loader = loader;
    loader.addLoadListener(new LoadListener() {

      public void loaderBeforeLoad(LoadEvent le) {
        onBeforeLoad(le);
      }

      public void loaderLoad(LoadEvent le) {
        onLoad((TreeLoadEvent) le);
      }

      public void loaderLoadException(LoadEvent le) {
        onLoadException(le);
      }

    });
  }

  /**
   * Adds the models to the root of the store and fires the <i>Add</i> event.
   * 
   * @param models the models to be added
   * @param addChildren true to recursively add all children
   */
  public void add(List<M> models, boolean addChildren) {
    insert(models, rootWrapper.getChildCount(), addChildren);
  }

  /**
   * Adds the items to the store and fires the <i>Add</i> event.
   * 
   * @param item the item to add
   * @param addChildren true to recursively add all children
   */
  @SuppressWarnings("unchecked")
  public void add(M item, boolean addChildren) {
    add(Util.createList(item), addChildren);
  }

  /**
   * Adds the models to the given parent and fires the <i>Add</i> event.
   * 
   * @param parent the parent
   * @param children the children
   * @param addChildren true to recursively add all children
   */
  public void add(M parent, List<M> children, boolean addChildren) {
    insert(parent, children, getChildCount(parent), addChildren);
  }

  /**
   * Adds the child to the parent and fires the <i>Add</i> event.
   * 
   * @param parent the parent item
   * @param item the child item
   * @param addChildren true to recursively add all children
   */
  public void add(M parent, M item, boolean addChildren) {
    insert(parent, item, getChildCount(parent), addChildren);
  }

  @Override
  public void applyFilters(String property) {
    if (filters != null && filters.size() == 0) {
      return;
    }
    filterProperty = property;
    filtersEnabled = true;

    filterTreeWrap(rootWrapper);

    fireEvent(Filter, createStoreEvent());
  }

  @Override
  public void clearFilters() {
    if (isFiltered()) {
      filtersEnabled = false;
      snapshot = null;
      for (M m : all) {
        TreeModel wrap = findWrapper(m);
        wrap.remove("filtered");
      }
      fireEvent(Filter, createStoreEvent());
    }
  }

  /**
   * Returns all the stores items. The items are not returned in any order.
   * 
   * @return the items
   */
  public List<M> getAllItems() {
    return all;
  }

  /**
   * Returns the root level child.
   * 
   * @param index the index
   * @return the child
   */
  public M getChild(int index) {
    return getFilteredChildren(rootWrapper).get(index);
  }

  /**
   * Returns the child at the given index.
   * 
   * @param parent the parent model
   * @param index the index
   * @return the child of the parent at the given index
   */
  public M getChild(M parent, int index) {
    TreeModel p = findWrapper(parent);
    if (p != null) {
      return getFilteredChildren(p).get(index);
    }
    return null;
  }

  /**
   * Returns the root level child count.
   * 
   * @return the child count
   */
  public int getChildCount() {
    return getRootItems().size();
  }

  /**
   * Returns the child count for the parent.
   * 
   * @param parent the parent
   * @return the child count or -1 if parent not found in the store
   */
  public int getChildCount(M parent) {
    TreeModel p = findWrapper(parent);
    if (p != null) {
      return getFilteredChildren(p).size();
    }
    return -1;
  }

  /**
   * Returns the children of the parent.
   * 
   * @param parent the children
   * @return the children or null if parent not found in the store
   */
  public List<M> getChildren(M parent) {
    TreeModel p = findWrapper(parent);
    if (p != null) {
      return getFilteredChildren(p);
    }
    return null;
  }

  /**
   * Returns the depth of the item.
   * 
   * @param item the item
   * @return the item's depth
   */
  public int getDepth(M item) {
    int depth = 0;
    while (item != null) {
      depth++;
      item = getParent(item);
    }
    return depth;
  }

  /**
   * Returns the fist child of the parent.
   * 
   * @param parent the parent
   * @return the first child or null if no children
   */
  public M getFirstChild(M parent) {
    if (parent == null) {
      if (getRootItems().size() > 0) {
        return getRootItems().get(0);
      }
    } else {
      if (getChildCount(parent) > 0) {
        return getChild(parent, 0);
      }
    }
    return null;
  }

  /**
   * Returns the last child of the parent.
   * 
   * @param parent the parent
   * @return the last child of null if no children
   */
  public M getLastChild(M parent) {
    List<M> children = parent == null ? getRootItems() : getChildren(parent);
    if (children.size() > 0) {
      return children.get(children.size() - 1);
    }
    return null;
  }

  /**
   * Returns the store's loader.
   * 
   * @return the loader
   */
  public TreeLoader<M> getLoader() {
    return loader;
  }

  /**
   * Returns the parent-child relationships for the given model. The actual
   * model can be retrieved in each TreeModel's "model" property using the
   * {@link TreeModel#get(String)} method. The children of each tree model
   * contains tree model instances which wrap the actual child model.
   * 
   * @param model the model
   * @return the model and it's children
   */
  public TreeModel getModelState(M model) {
    TreeModel tm = new BaseTreeModel();
    tm.set("model", model);
    int count = getChildCount(model);
    for (int i = 0; i < count; i++) {
      tm.add(getModelState(getChild(model, i)));
    }
    return tm;
  }

  /**
   * Returns the next sibling of the model.
   * 
   * @param item the model
   * @return the next sibling or null
   */
  public M getNextSibling(M item) {
    M parent = getParent(item);
    List<M> children = parent == null ? getRootItems() : getChildren(parent);
    int index = children.indexOf(item);
    if (children.size() > (index + 1)) {
      return children.get(index + 1);
    }
    return null;
  }

  /**
   * Returns the parent of the item.
   * 
   * @param item the item
   * @return the item's parent
   */
  public M getParent(M item) {
    TreeModel child = findWrapper(item);
    if (child != null) {
      TreeModel p = child.getParent();
      if (p != null) {
        return unwrap(p);
      }
    }
    return null;
  }

  /**
   * Returns the item's previous sibling.
   * 
   * @param item the item
   * @return the previous sibling
   */
  public M getPreviousSibling(M item) {
    M parent = getParent(item);
    List<M> children = parent == null ? getRootItems() : getChildren(parent);
    int index = children.indexOf(item);
    if (index > 0) {
      return children.get(index - 1);
    }
    return null;
  }

  /**
   * Returns the root level items.
   * 
   * @return the items
   */
  public List<M> getRootItems() {
    return unwrapChildren(rootWrapper);
  }

  /**
   * Returns the item's index in it's parent including root level items.
   * 
   * @param item the item
   * @return the index
   */
  public int indexOf(M item) {
    M parent = getParent(item);
    if (parent == null) {
      return getRootItems().indexOf(item);
    } else {
      return getChildren(parent).indexOf(item);
    }
  }

  /**
   * Inserts the models into the store and fires the <i>Add</i> event.
   * 
   * @param models the models to insert
   * @param index the insert index
   * @param addChildren true to recursively add all children
   */
  public void insert(List<M> models, int index, boolean addChildren) {
    List<TreeModel> insert = new ArrayList<TreeModel>();
    for (M model : models) {
      insert.add(wrap(model));
    }
    doInsert(rootWrapper, insert, index, addChildren, false);
  }

  /**
   * Adds the item to the store and fires the <i>Add</i> event.
   * 
   * @param item the item to insert
   * @param index the insert index
   * @param addChildren true to recursively add all children
   */
  @SuppressWarnings("unchecked")
  public void insert(M item, int index, boolean addChildren) {
    doInsert(rootWrapper, Util.createList(wrap(item)), index, addChildren, false);
  }

  /**
   * Inserts the children to the parent and fires the <i>Add</i> event.
   * 
   * @param parent the parent
   * @param children the children
   * @param index the insert index
   * @param addChildren true to recursively add all children
   */
  public void insert(M parent, List<M> children, int index, boolean addChildren) {
    TreeModel wrapper = findWrapper(parent);
    if (wrapper != null) {
      List<TreeModel> insert = new ArrayList<TreeModel>();
      for (M model : children) {
        insert.add(wrap(model));
      }
      doInsert(wrapper, insert, index, addChildren, false);
    }
  }

  /**
   * Adds the child to the parent and fires the <i>Add</i> event.
   * 
   * @param parent the parent model
   * @param model the child model
   * @param index the insert index
   * @param addChildren true to recursively add all children
   */
  @SuppressWarnings("unchecked")
  public void insert(M parent, M model, int index, boolean addChildren) {
    insert(parent, Util.createList(model), index, addChildren);
  }

  /**
   * Removes the model from the store and fires the <i>Remove</i> event.
   * 
   * @param model the item to be removed
   */
  public void remove(M model) {
    remove(rootWrapper, findWrapper(model), false);
  }

  /**
   * Removes the child from the parent and fires the <i>Remove</i> event.
   * 
   * @param parent the parent model
   * @param child the child model
   */
  public void remove(M parent, M child) {
    TreeModel p = findWrapper(parent);
    TreeModel c = findWrapper(child);
    if (p != null && c != null) {
      remove(p, c, false);
    }
  }

  @Override
  public void removeAll() {
    removeAll(false);
  }

  /**
   * Removes all the parent's children.
   * 
   * @param parent the parent
   */
  public void removeAll(M parent) {
    TreeModel p = findWrapper(parent);
    if (p != null) {
      List<M> children = getChildren(parent);
      for (M m : children) {
        TreeModel child = findWrapper(m);
        if (child != null) {
          remove(p, child, false);
        }
      }
    }
  }

  /**
   * Sets the current sort info used when sorting items in the store.
   * 
   * @param info the sort info
   */
  public void setSortInfo(SortInfo info) {
    this.sortInfo = info;
  }

  @Override
  public void setStoreSorter(StoreSorter<M> storeSorter) {
    super.setStoreSorter(storeSorter);
    applySort(false);
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void applySort(boolean supressEvent) {
    for (TreeModel wrapper : wrapperMap.keySet()) {
      List<TreeModel> children = (List) wrapper.getChildren();
      if (children.size() > 0) {
        applySort(children);
      }
    }
    if (supressEvent) {
      fireEvent(Sort, createStoreEvent());
    }
  }

  protected void applySort(List<TreeModel> list) {
    if (storeSorter != null) {
      Collections.sort(list, new Comparator<TreeModel>() {
        public int compare(TreeModel m1, TreeModel m2) {
          return storeSorter.compare(TreeStore.this, unwrap(m1), unwrap(m2),
              sortInfo.getSortField());
        }
      });
      if (sortInfo.getSortDir() == SortDir.DESC) {
        Collections.reverse(list);
      }
    }
  }

  @Override
  protected TreeStoreEvent<M> createStoreEvent() {
    return new TreeStoreEvent<M>(this);
  }

  protected TreeModel findWrapper(M item) {
    return modelMap.get(item);
  }

  protected void onBeforeLoad(LoadEvent le) {
    fireEvent(BeforeDataChanged, createStoreEvent());
  }

  @SuppressWarnings("unchecked")
  protected void onLoad(TreeLoadEvent le) {
    if (le.parent == null) {
      removeAll(true);
      List<TreeModel> insert = new ArrayList<TreeModel>();
      for (M model : (List<M>) le.getData()) {
        insert.add(wrap(model));
      }
      doInsert(rootWrapper, insert, 0, false, true);
      fireEvent(DataChanged, new TreeStoreEvent(this));
    } else {
      TreeModel wrapper = findWrapper((M) le.parent);
      if (wrapper != null) {
        if (wrapper.getChildren().size() > 0) {
          removeAll((M) le.parent);
        }
        List<TreeModel> insert = new ArrayList<TreeModel>();
        List<M> list = (List<M>) le.getData();
        for (M model : list) {
          insert.add(wrap(model));
        }
        doInsert(wrapper, insert, 0, false, true);
        TreeStoreEvent evt = new TreeStoreEvent(this);
        evt.setParent(le.parent);
        evt.setChildren(unwrapChildren(wrapper));
        fireEvent(DataChanged, evt);
      }
    }
  }

  protected void onLoadException(LoadEvent le) {

  }

  @SuppressWarnings("unchecked")
  @Override
  protected void onModelChange(ChangeEvent ce) {
    super.onModelChange(ce);
    switch (ce.getType()) {
      case ChangeEventSource.Add: {
        if (ce.getSource() == ce.getParent()) {
          M parent = (M) ce.getParent();
          M child = (M) ce.getItem();
          insert(parent, child, ce.getIndex(), false);
        }
        break;
      }
      case ChangeEventSource.Remove: {
        if (ce.getSource() == ce.getParent()) {
          M parent = (M) ce.getParent();
          M child = (M) ce.getItem();
          remove(parent, child);
        }
        break;
      }
    }
  }

  protected List<M> unwrap(List<TreeModel> models) {
    List<M> children = new ArrayList<M>();
    if (isFiltered()) {
      for (TreeModel child : models) {
        if (!"true".equals(child.get("filtered"))) {
          children.add(unwrap(child));
        }
      }
    } else {
      for (TreeModel child : models) {
        children.add(unwrap(child));
      }
    }

    return children;
  }

  protected M unwrap(TreeModel wrapper) {
    return wrapperMap.get(wrapper);
  }

  @SuppressWarnings("unchecked")
  protected List<M> unwrapChildren(TreeModel parent) {
    return unwrap((List) parent.getChildren());
  }

  protected TreeModel wrap(M model) {
    TreeModel wrapper = new BaseTreeModel();
    modelMap.put(model, wrapper);
    wrapperMap.put(wrapper, model);
    return wrapper;
  }

  @SuppressWarnings("unchecked")
  private void doInsert(TreeModel parent, List<TreeModel> children, int index,
      boolean addChildren, boolean supressEvent) {
    if (parent != null && children != null) {
      M modelParent = unwrap(parent);
      for (int i = children.size() - 1; i >= 0; i--) {
        parent.insert(children.get(i), index);
        M m = unwrap(children.get(i));
        all.add(m);
        registerModel(m);
      }
      if (storeSorter != null) {
        applySort((List) parent.getChildren());
      }

      if (!supressEvent) {
        if (storeSorter != null) {
          for (TreeModel child : children) {
            TreeStoreEvent evt = createStoreEvent();;
            evt.setParent(modelParent);
            evt.setIndex(parent.indexOf(child));
            evt.setChildren(Util.createList(unwrap(child)));
            fireEvent(Add, evt);
          }
        } else {
          TreeStoreEvent evt = createStoreEvent();;
          evt.setParent(modelParent);
          evt.setChildren(unwrap(children));
          evt.setIndex(index);
          fireEvent(Add, evt);
        }
      }

      if (addChildren) {
        for (TreeModel sub : children) {
          M model = unwrap(sub);
          if (model instanceof TreeModel) {
            TreeModel treeSub = (TreeModel) model;
            List<TreeModel> insert = new ArrayList<TreeModel>();
            List<M> c = (List) treeSub.getChildren();
            for (M m : c) {
              insert.add(wrap(m));
            }
            doInsert(sub, insert, getChildCount(model), true, false);
            update(model);
          }
        }
      }
    }
  }

  private void filterTreeWrap(TreeModel wrap) {
    List<ModelData> children = wrap.getChildren();
    for (int i = 0, len = children.size(); i < len; i++) {
      TreeModel tm = (TreeModel) children.get(i);
      if (isOrDecendantSelected(tm, unwrap(tm))) {
        tm.set("filtered", "false");

      } else {
        tm.set("filtered", "true");
      }
      filterTreeWrap(tm);
    }
  }

  private void findChildren(M parent, List<M> children) {
    for (M child : getChildren(parent)) {
      children.add(child);
      findChildren(child, children);
    }
  }

  private List<M> getFilteredChildren(TreeModel wrap) {
    List<TreeModel> filtered = new ArrayList<TreeModel>();
    for (ModelData child : wrap.getChildren()) {
      if (!isFiltered((TreeModel) child)) {
        filtered.add((TreeModel) child);
      }
    }
    return unwrap(filtered);
  }

  private boolean isFiltered(TreeModel wrap) {
    return "true".equals(wrap.get("filtered"));
  }

  private boolean isOrDecendantSelected(TreeModel wrap, M model) {
    if (!isFiltered(model, filterProperty)) {
      return true;
    }
    List<ModelData> children = wrap.getChildren();
    for (int i = 0, len = children.size(); i < len; i++) {
      TreeModel tm = (TreeModel) children.get(i);
      boolean result = isOrDecendantSelected(tm, unwrap(tm));
      if (result) {
        return true;
      }
    }

    return false;
  }

  private void remove(TreeModel parent, TreeModel child, boolean supressEvent) {
    int index = parent.getChildren().indexOf(child);
    if (index != -1) {
      parent.remove(child);
      M model = unwrap(child);
      List<M> children = new ArrayList<M>();
      findChildren(model, children);

      for (M c : children) {
        all.remove(c);
        modelMap.remove(c);
        unregisterModel(c);
        wrapperMap.remove(findWrapper(c));
      }
      all.remove(model);
      wrapperMap.remove(child);
      modelMap.remove(model);
      unregisterModel(model);
      if (!supressEvent) {
        TreeStoreEvent<M> evt = new TreeStoreEvent<M>(this);
        evt.setParent(unwrap(parent));
        evt.setChild(model);
        evt.setChildren(children);
        evt.setIndex(index);
        fireEvent(Remove, evt);
      }
    }
  }

  private void removeAll(boolean supressEvent) {
    all.clear();
    modified.clear();
    modelMap.clear();
    wrapperMap.clear();
    rootWrapper.removeAll();
    if (!supressEvent) {
      fireEvent(Clear, createStoreEvent());
    }
  }

}
