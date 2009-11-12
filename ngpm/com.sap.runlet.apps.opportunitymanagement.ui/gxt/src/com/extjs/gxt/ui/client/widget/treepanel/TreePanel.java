/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treepanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.data.ModelStringProvider;
import com.extjs.gxt.ui.client.data.TreeLoadEvent;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.CheckChangedEvent;
import com.extjs.gxt.ui.client.event.CheckChangedListener;
import com.extjs.gxt.ui.client.event.CheckProvider;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.store.TreeStoreEvent;
import com.extjs.gxt.ui.client.util.DelayedTask;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanelView.TreeViewRenderMode;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * A hierarchical tree widget bound directly to a @link {@link TreeStore}.
 * <code>TreePanel</code> contains no child widgets, rather, the tree is
 * rendered based on the models contained in the tree store. Once bound, the
 * tree will remain in sync with the bound tree store.
 * 
 * <p />
 * The text of each node can be specified in a couple of different ways. First,
 * a display property can be set using {@link #setDisplayProperty(String)}. The
 * is useful when the item's text is contained within the model's data. Second,
 * a model string provider can be specified using
 * {@link #setLabelProvider(ModelStringProvider)}.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeExpand</b> : TreePanelEvent(treePanel, item)<br>
 * <div>Fires before a node is expanded. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>treePanel : the source tree</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeCollapse</b> : TreePanelEvent(treePanel, item)<br>
 * <div>Fires before a node is collapsed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>treePanel : the source tree</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Expand</b> : TreePanelEvent(treePanel, item)<br>
 * <div>Fires after a node has been expanded.</div>
 * <ul>
 * <li>treePanel : the source tree</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Collapse</b> : TreePanelEvent(treePanel, item)<br>
 * <div>Fires after a node is collapsed.</div>
 * <ul>
 * <li>treePanel : the source tree</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeCheckChange</b> : TreePanelEvent(treePanel, item)<br>
 * <div>Fires before a node's check state is changed. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>treePanel : the source tree</li>
 * <li>item : this</li>
 * <li>checked : the checked state.</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CheckChange</b> : TreePanelEvent(treePanel, item)<br>
 * <div>Fires after a item's check state changes.</div>
 * <ul>
 * <li>treePanel : the source tree</li>
 * <li>item : this</li>
 * <li>checked : the checked state.</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CheckChanged</b> : CheckChangeEvent(provider, checkedeSelection)<br>
 * <div>Fires after the tree's overall checked state changes.</div>
 * <ul>
 * <li>provider : the source tree</li>
 * <li>checkedSelection : the tree checked item</li>
 * </ul>
 * </dd>
 * 
 * </dl>
 * 
 * @param <M> the model type
 */
public class TreePanel<M extends ModelData> extends BoxComponent implements CheckProvider<M> {

  /**
   * Check cascade enum.
   */
  public enum CheckCascade {
    /**
     * Checks cascade to all child nodes.
     */
    CHILDREN,
    /**
     * Checks to not cascade.
     */
    NONE,
    /**
     * Checks cascade to all parent nodes.
     */
    PARENTS;
  }

  /**
   * Check nodes enum.
   */
  public enum CheckNodes {
    /**
     * Check boxes for both leafs and parent nodes.
     */
    BOTH,
    /**
     * Check boxes for only leaf nodes.
     */
    LEAF,
    /**
     * Check boxes for only parent nodes.
     */
    PARENT;
  }

  /**
   * Joint enum.
   */
  public enum Joint {
    COLLAPSED(1), EXPANDED(2), NONE(0);

    private int value;

    private Joint(int value) {
      this.value = value;
    }

    public int value() {
      return value;
    }
  }

  /**
   * Maintains the internal state of nodes contained in the tree. Should not
   * need to be referenced in typical usage.
   */
  public class TreeNode {

    protected Element element, container, joint, check, text, icon, elContainer;
    protected String id;
    protected M m;

    private boolean childrenRendered;
    private boolean expand, checked;
    private boolean expanded;
    private boolean leaf = true;
    private boolean loaded;

    TreeNode(String id, M m) {
      this.id = id;
      this.m = m;
      if (loader != null && !loaded) {
        leaf = !loader.hasChildren(m);
      }
    }

    public void clearElements() {
      joint = null;
      check = null;
      icon = null;
      text = null;
    }

    public Element getElement() {
      if (element == null) {
        element = (Element) Document.get().getElementById(id);
      }
      return element;
    }

    public int getItemCount() {
      return store.getChildCount(m);
    }

    public M getModel() {
      return m;
    }

    public TreeNode getParent() {
      M p = store.getParent(m);
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
      TreePanel.this.setExpanded(m, expand);
    }

    public void setLeaf(boolean leaf) {
      this.leaf = leaf;
      TreePanel.this.refresh(m);
    }
  }

  protected HashMap<M, String> cache = new HashMap<M, String>();
  protected String displayProperty;
  protected String itemSelector = ".x-tree3-node";
  protected TreeLoader<M> loader;
  protected Map<String, TreeNode> nodes = new FastMap<TreeNode>();
  protected TreePanelSelectionModel<M> sm;
  protected TreeStore<M> store;
  protected TreePanelView<M> view = new TreePanelView<M>();

  private boolean autoLoad, filtering;
  private boolean caching = true;
  private boolean checkable;
  private CheckNodes checkNodes = CheckNodes.BOTH;
  private CheckCascade checkStyle = CheckCascade.PARENTS;
  private boolean expandOnFilter = true;
  private ModelIconProvider<M> iconProvider;
  private ModelStringProvider<M> labelProvider;
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
  };
  private TreeStyle style = new TreeStyle();
  private boolean trackMouseOver = true;
  private boolean autoSelect;
  private DelayedTask updateTask, cleanTask;

  /**
   * Creates a new tree panel.
   * 
   * @param store the tree store
   */
  public TreePanel(TreeStore<M> store) {
    this.store = store;
    this.loader = store.getLoader();

    store.addStoreListener(storeListener);

    baseStyle = "x-tree3";
    setSelectionModel(new TreePanelSelectionModel<M>());
    view.bind(this, store);
  }

  public void addCheckListener(CheckChangedListener<M> listener) {
    addListener(Events.CheckChanged, listener);
  }

  /**
   * Collapses all nodes.
   */
  public void collapseAll() {
    for (M child : store.getRootItems()) {
      setExpanded(child, false, true);
    }
  }

  /**
   * Expands all nodes.
   */
  public void expandAll() {
    for (M child : store.getRootItems()) {
      setExpanded(child, true, true);
    }
  }

  /**
   * Returns the tree node for the given target.
   * 
   * @param target the target element
   * @return the tree node or null if no match
   */
  public TreeNode findNode(Element target) {
    Element item = fly(target).findParentElement(itemSelector, 4);
    if (item != null) {
      String id = item.getId();
      TreeNode node = nodes.get(id);
      if (node != null) {
        return node;
      }
    }
    return null;
  }

  public List<M> getCheckedSelection() {
    List<M> checked = new ArrayList<M>();
    for (M m : store.getAllItems()) {
      if (isChecked(m)) {
        checked.add(m);
      }
    }
    return checked;
  }

  /**
   * Returns the child nodes value which determines what node types have a check
   * box. Only applies when check boxes have been enabled (
   * {@link #setCheckable(boolean)}.
   * 
   * @return the child nodes value
   */
  public CheckNodes getCheckNodes() {
    return checkNodes;
  }

  /**
   * The check cascade style value which determines if check box changes cascade
   * to parent and children.
   * 
   * @return the check cascade style
   */
  public CheckCascade getCheckStyle() {
    return checkStyle;
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
   * Returns the model icon provider.
   * 
   * @return the icon provider
   */
  public ModelIconProvider<M> getIconProvider() {
    return iconProvider;
  }

  /**
   * Returns the tree's selection model.
   * 
   * @return the selection model
   */
  public TreePanelSelectionModel<M> getSelectionModel() {
    return sm;
  }

  /**
   * Returns the tree's store.
   * 
   * @return the store
   */
  public TreeStore<M> getStore() {
    return store;
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
   * Returns the tree's view.
   * 
   * @return the view
   */
  public TreePanelView<M> getView() {
    return view;
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
   * Returns true if select on load is enabled.
   * 
   * @return the auto select state
   */
  public boolean isAutoSelect() {
    return autoSelect;
  }

  /**
   * Returns true when a loader is queried for it's children each time a node is
   * expanded. Only applies when using a loader with the tree store.
   * 
   * @return true if caching
   */
  public boolean isCaching() {
    return caching;
  }

  /**
   * Returns true if check boxes are enabled.
   * 
   * @return the check box state
   */
  public boolean isCheckable() {
    return checkable;
  }

  public boolean isChecked(M model) {
    TreeNode node = findNode(model);
    if (node != null) {
      return node.checked;
    }
    return false;
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
   * Returns the if expand all and collapse all is enabled on filter changes.
   * 
   * @return the expand all collapse all state
   */
  public boolean isExpandOnFilter() {
    return expandOnFilter;
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
   * Returns true if nodes are highlighted on mouse over.
   * 
   * @return true if enabled
   */
  public boolean isTrackMouseOver() {
    return trackMouseOver;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    TreePanelEvent<M> tpe = (TreePanelEvent) ce;

    int type = ce.getEventTypeInt();
    switch (type) {
      case Event.ONCLICK:
        onClick(tpe);
        break;
      case Event.ONDBLCLICK:
        onDoubleClick(tpe);
        break;
      case Event.ONSCROLL:
        onScroll(tpe);
        break;
    }

    view.onEvent(tpe);
  }

  public void removeCheckListener(CheckChangedListener<M> listener) {
    removeListener(Events.CheckChanged, listener);
  }

  /**
   * Scrolls the tree to ensure the given model is visible.
   * 
   * @param model the model to scroll into view
   */
  public void scrollIntoView(M model) {
    TreeNode node = findNode(model);
    if (node != null) {
      node.getElement().scrollIntoView();
    }
  }

  /**
   * Sets whether all children should automatically be loaded recursively
   * (defaults to false). Useful when using filters. Only applies when using a
   * loader.
   * 
   * @param autoLoad true to auto load
   */
  public void setAutoLoad(boolean autoLoad) {
    this.autoLoad = autoLoad;
  }

  /**
   * True to select the first model after the store's data changes (defaults to
   * false).
   * 
   * @param autoSelect true to auto select
   */
  public void setAutoSelect(boolean autoSelect) {
    this.autoSelect = autoSelect;
  }

  /**
   * Sets whether the children should be cached after first being retrieved from
   * the store (defaults to true). When <code>false</code>, a load request will
   * be made each time a node is expanded.
   * 
   * @param caching the caching state
   */
  public void setCaching(boolean caching) {
    this.caching = caching;
  }

  /**
   * Sets whether check boxes are used in the tree.
   * 
   * @param checkable true for check boxes
   */
  public void setCheckable(boolean checkable) {
    this.checkable = checkable;
  }

  /**
   * Sets the check state of the item.
   * 
   * @param item the item
   * @param checked true for checked
   */
  public void setChecked(M item, boolean checked) {
    TreeNode node = findNode(item);
    if (node != null && node.check != null) {
      if (node.checked == checked) {
        return;
      }
      TreePanelEvent<M> evt = new TreePanelEvent<M>(this, item);
      evt.setChecked(checked);

      if (fireEvent(Events.BeforeCheckChange, evt)) {
        node.checked = checked;
        view.onCheckChange(node, checked);

        fireEvent(Events.CheckChange, evt);

        CheckChangedEvent<M> cce = new CheckChangedEvent<M>(this, getCheckedSelection());
        fireEvent(Events.CheckChanged, cce);

        switch (getCheckStyle()) {
          case PARENTS:
            if (checked) {
              M p = store.getParent(item);
              while (p != null) {
                setChecked(p, true);
                p = store.getParent(p);
              }
            } else {
              for (M child : store.getChildren(item)) {
                setChecked(child, false);
              }
            }
            break;
          case CHILDREN:
            for (M child : store.getChildren(item)) {
              setChecked(child, checked);
            }
        }
      }
    }
  }

  public void setCheckedSelection(List<M> selection) {
    getSelectionModel().deselectAll();
    for (M m : selection) {
      setChecked(m, true);
    }
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
   * Sets the display property name used to the item's text. As an alternative,
   * a <code>ModelStringProvider</code> can be specified using
   * {@link #setLabelProvider(ModelStringProvider)}.
   * 
   * @param displayProperty the property name
   */
  public void setDisplayProperty(String displayProperty) {
    this.displayProperty = displayProperty;
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
      if (!rendered) {
        node.expand = expand;
        return;
      }
      TreePanelEvent<M> tpe = new TreePanelEvent<M>(this);
      tpe.setItem(model);
      tpe.setNode(node);
      if (expand) {
        if (!node.isLeaf()) {
          // if we have a loader and node is not loaded make
          // load request and exit method
          if (loader != null && (!node.loaded || !caching) && !filtering) {
            store.removeAll(model);
            node.expand = true;
            loader.loadChildren(model);
            return;
          }
          if (!node.expanded && fireEvent(Events.BeforeExpand, tpe)) {
            node.expanded = true;

            if (!node.childrenRendered) {
              renderChildren(model);
              node.childrenRendered = true;
            }
            // expand
            view.expand(node);

            M parent = store.getParent(model);
            while (parent != null) {
              TreeNode pnode = findNode(parent);
              if (!pnode.expanded) {
                setExpanded(pnode.m, true);
              }
              parent = store.getParent(parent);
            }
            update();
            fireEvent(Events.Expand, tpe);
          }
        }
        if (deep) {
          setExpandChildren(model, true);
        }
      } else {
        if (node.expanded && fireEvent(Events.BeforeCollapse, tpe)) {
          node.expanded = false;
          // collapse
          view.collapse(node);
          List<M> l = new ArrayList<M>();
          l.add(node.m);

          update();
          cleanCollapsed(l);
          fireEvent(Events.Collapse, tpe);
        }
        if (deep) {
          setExpandChildren(model, false);
        }
      }

    }
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

  /**
   * Sets the tree's model icon provider which provides the icon style for each
   * model.
   * 
   * @param iconProvider the icon provider
   */
  public void setIconProvider(ModelIconProvider<M> iconProvider) {
    this.iconProvider = iconProvider;
  }

  /**
   * Sets the tree's model string provider for the text description of each
   * node. If a a display property has been specified, it will be pased to the
   * string provider. If a property has not been specified, <code>null</code>
   * will be passed.
   * 
   * @param labelProvider the label provider
   */
  public void setLabelProvider(ModelStringProvider<M> labelProvider) {
    this.labelProvider = labelProvider;
  }

  /**
   * Sets the item's leaf state. The leaf state allows control of the expand
   * icon before the children have been realized.
   * 
   * @param model the model
   * @param leaf the leaf state
   */
  public void setLeaf(M model, boolean leaf) {
    TreeNode t = findNode(model);
    if (t != null) {
      t.setLeaf(leaf);
    }
  }

  /**
   * Sets the tree's selection model.
   * 
   * @param sm the selection model
   */
  public void setSelectionModel(TreePanelSelectionModel<M> sm) {
    if (this.sm != null) {
      this.sm.bindTree(null);
    }
    this.sm = sm;
    if (sm != null) {
      sm.bindTree(this);
    }
  }

  /**
   * Sets the tree style.
   * 
   * @param style the tree style
   */
  public void setStyle(TreeStyle style) {
    this.style = style;
  }

  /**
   * True to highlight nodes when the mouse is over (defaults to true).
   * 
   * @param trackMouseOver true to highlight nodes on mouse over
   */
  public void setTrackMouseOver(boolean trackMouseOver) {
    this.trackMouseOver = trackMouseOver;
  }

  /**
   * Sets the tree's view. Only needs to be called when customizing the tree's
   * presentation.
   * 
   * @param view the view
   */
  public void setView(TreePanelView<M> view) {
    this.view = view;
    view.bind(this, store);
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

  protected Joint calcualteJoint(M model) {
    if (model == null) {
      return Joint.NONE;
    }
    TreeNode node = findNode(model);
    return node.isLeaf() ? Joint.NONE : node.expanded ? Joint.EXPANDED : Joint.COLLAPSED;
  }

  protected AbstractImagePrototype calculateIconStyle(M model) {
    AbstractImagePrototype style = null;
    if (iconProvider != null) {
      AbstractImagePrototype iconStyle = iconProvider.getIcon(model);
      if (iconStyle != null) {
        return iconStyle;
      }
    }
    TreeNode node = findNode(model);
    TreeStyle ts = getStyle();
    if (!node.isLeaf()) {
      if (isExpanded(model) && ts.getNodeOpenIcon() != null) {
        style = ts.getNodeOpenIcon();
      } else if (isExpanded(model) && ts.getNodeOpenIcon() != null) {
        style = ts.getNodeCloseIcon();
      } else if (!isExpanded(model)) {
        style = ts.getNodeCloseIcon();
      }
    } else {
      style = ts.getLeafIcon();
    }
    return style;
  }

  protected void clean() {
    if (cleanTask == null) {
      cleanTask = new DelayedTask(new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
          doClean();
        }
      });
    }
    cleanTask.delay(view.getCleanDelay());
  }

  protected void clear() {
    getContainer(null).setInnerHTML("");
    nodes.clear();
    cache.clear();
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    TreePanelEvent<M> tpe = new TreePanelEvent<M>(this, event);
    return tpe;
  }

  protected void doClean() {
    if (getVisibleRowCount() > 0) {
      List<M> rows = getChildModel(store.getRootItems(), true);
      int[] vr = getVisibleRows(rows);
      vr[0] -= view.getCacheSize();
      vr[1] += view.getCacheSize();

      int i = 0;

      // if first is less than 0, all rows have been rendered
      // so lets clean the end...
      if (vr[0] <= 0) {
        i = vr[1] + 1;
      }
      for (int len = rows.size(); i < len; i++) {
        // if current row is outside of first and last and
        // has content, update the innerHTML to nothing
        if (i < vr[0] || i > vr[1]) {
          cleanNode(findNode(rows.get(i)));
        }
      }
    }

  }

  protected void doUpdate() {
    if (getVisibleRowCount() > 0) {
      List<M> rootItems = store.getRootItems();
      List<M> visible = getChildModel(rootItems, true);
      int[] vr = getVisibleRows(visible);

      for (int i = vr[0]; i <= vr[1]; i++) {
        if (!isRowRendered(i, visible)) {
          M parent = store.getParent(visible.get(i));
          String html = renderChild(parent, visible.get(i), store.getDepth(parent), TreeViewRenderMode.BODY);

          findNode(visible.get(i)).getElement().getFirstChildElement().setInnerHTML(html);
        }
      }
      clean();
    }

  }

  protected TreeNode findNode(M m) {
    if (m == null) return null;
    return nodes.get(cache.get(m));
  }

  protected List<M> getChildModel(List<M> l, boolean onlyVisible) {
    List<M> list = new ArrayList<M>();
    for (M m : l) {
      list.add(m);
      if (!onlyVisible || findNode(m).isExpanded()) {
        findChildren(m, list, onlyVisible);
      }
    }
    return list;
  }

  protected Element getContainer(M model) {
    if (model == null) {
      return (Element) getElement();
    }
    TreeNode node = findNode(model);
    if (node != null) {
      return view.getContainer(node);
    }
    return null;
  }

  protected String getText(M model) {
    if (labelProvider != null) {
      return labelProvider.getStringValue(model, displayProperty);
    } else if (displayProperty != null) {
      return (String) model.get(displayProperty);
    }
    return "";
  }

  protected int getVisibleRowCount() {
    int rh = view.getCalculatedRowHeight();
    int visibleHeight = el().getHeight(true);
    return (int) ((visibleHeight < 1) ? 0 : Math.ceil(visibleHeight / rh));
  }

  protected boolean hasChildren(M model) {
    TreeNode node = findNode(model);
    if (loader != null && !node.loaded) {
      return loader.hasChildren(model);
    }
    if (!node.leaf || store.getChildCount(model) > 0) {
      return true;
    }
    return false;
  }

  protected void refresh(M model) {
    if (rendered) {
      TreeNode node = findNode(model);
      if (node != null && node.getElement() != null) {
        view.onIconStyleChange(node, calculateIconStyle(model));
        view.onJointChange(node, calcualteJoint(model));
      }
    }
  }

  protected void onAdd(TreeStoreEvent<M> se) {
    for (M child : se.getChildren()) {
      register(child);
    }
    if (rendered) {
      M parent = se.getParent();
      TreeNode pn = findNode(parent);
      if (parent == null || (pn != null && pn.childrenRendered)) {
        StringBuilder sb = new StringBuilder();

        for (M child : se.getChildren()) {
          sb.append(renderChild(parent, child, store.getDepth(parent), TreeViewRenderMode.MAIN));
        }

        Element div = DOM.createDiv();
        div.setInnerHTML(sb.toString());
        fly(getContainer(parent)).insertChild((Element) div.getFirstChildElement(), se.getIndex());

      }
      refresh(parent);
      update();
    }
  }

  protected void onBeforeLoad(TreeLoadEvent le) {

  }

  @SuppressWarnings("unchecked")
  protected void onCheckClick(TreePanelEvent tpe, TreeNode node) {
    tpe.stopEvent();
    setChecked((M) tpe.getItem(), !node.checked);
  }

  protected void onClear(TreeStoreEvent<M> se) {
    clear();
  }

  @SuppressWarnings("unchecked")
  protected void onClick(TreePanelEvent tpe) {
    TreeNode node = tpe.getNode();
    if (node != null) {
      if (tpe.within(view.getJointElement(node))) {
        toggle((M) tpe.getItem());
      }
      if (checkable && tpe.within(view.getCheckElement(node))) {
        onCheckClick(tpe, node);
      }
    }
  }

  protected void onDataChanged(TreeStoreEvent<M> se) {
    if (!isRendered()) {
      return;
    }

    M p = se.getParent();
    if (p == null) {
      clear();
      renderChildren(null);

      if (autoSelect) {
        M m = store.getChild(0);
        if (m != null) {
          List<M> sel = new ArrayList<M>();
          sel.add(m);
          getSelectionModel().setSelection(sel);
        }

      }
    } else {
      TreeNode n = findNode(p);
      n.loaded = true;

      if (n.childrenRendered) {
        getContainer(p).setInnerHTML("");
      }

      renderChildren(p);

      if (n.expand && !n.isLeaf()) {
        n.expand = false;
        setExpanded(p, true);
      }
    }
  }

  @SuppressWarnings("unchecked")
  protected void onDoubleClick(TreePanelEvent tpe) {
    TreeNode node = tpe.getNode();
    if (node != null) {
      setExpanded(node.m, !node.expanded);
    }
  }

  protected void onFilter(TreeStoreEvent<M> se) {
    filtering = store.isFiltered();
    clear();
    renderChildren(null);

    if (expandOnFilter && store.isFiltered()) {
      expandAll();
    }
  }

  protected void onRemove(TreeStoreEvent<M> se) {
    TreeNode node = findNode(se.getChild());
    if (node != null && node.getElement() != null) {
      El.fly(node.getElement()).removeFromParent();
      unregister(se.getChild());
      TreeNode p = findNode(se.getParent());
      if (p != null && p.expanded && p.getItemCount() == 0) {
        setExpanded(p.m, false);
      }
    }
    unregister(se.getChild());
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    String s = view.getTemplate(null, null, null, null, false, null, 0, TreeViewRenderMode.CONTAINER);
    setElement(XDOM.create(s), target, index);

    el().show();
    disableTextSelection(true);
    el().setStyleAttribute("overflow", "auto");
    el().setTabIndex(0);
    el().setElementAttribute("hideFocus", "true");

    if (store.getRootItems().size() == 0 && loader != null) {
      loader.load();
    } else {
      renderChildren(null);
      if (autoSelect) {
        getSelectionModel().select(0, false);
      }
    }

    sinkEvents(Event.ONSCROLL | Event.ONCLICK | Event.ONDBLCLICK | Event.MOUSEEVENTS | Event.KEYEVENTS);
  }

  protected void onResize(int width, int height) {
    super.onResize(width, height);
    update();
  }

  protected void onScroll(TreePanelEvent<M> tpe) {
    update();
  }

  protected void unregister(M m) {
    if (m != null) {
      nodes.remove(cache.get(m));
      cache.remove(m);
    }
  }

  protected String register(M m) {
    String id = cache.get(m);
    if (id == null) {
      id = XDOM.getUniqueId();
      cache.put(m, id);
      nodes.put(id, new TreeNode(id, m));
    }
    return id;
  }

  protected String renderChild(M parent, M child, int depth, TreeViewRenderMode renderMode) {
    String id = register(child);
    boolean leaf = findNode(child).isLeaf();
    boolean check = checkable;
    switch (checkNodes) {
      case LEAF:
        if (!leaf) {
          check = false;
        }
        break;
      case PARENT:
        if (leaf) {
          check = false;
        }
    }
    return view.getTemplate(child, id, getText(child), calculateIconStyle(child), check, calcualteJoint(child), depth,
        renderMode);
  }

  protected void renderChildren(M parent) {
    Element container = getContainer(parent);

    StringBuilder markup = new StringBuilder();
    int depth = store.getDepth(parent);
    List<M> children = parent == null ? store.getRootItems() : store.getChildren(parent);
    for (M child : children) {
      register(child);
    }
    List<M> rootItems = store.getRootItems();
    List<M> visible = getChildModel(rootItems, true);
    int[] vr = getVisibleRows(visible);

    for (int i = 0; i < children.size(); i++) {
      int j = visible.indexOf(children.get(i));
      if (j >= vr[0] && j <= vr[1]) {
        markup.append(renderChild(parent, children.get(i), depth, TreeViewRenderMode.ALL));
      } else {
        markup.append(renderChild(parent, children.get(i), depth, TreeViewRenderMode.MAIN));
      }
    }

    container.setInnerHTML(markup.toString());

    for (int i = 0; i < children.size(); i++) {
      M child = children.get(i);
      TreeNode node = findNode(child);

      if (node.expand && !node.isLeaf()) {
        node.expand = false;
        setExpanded(child, true);
      } else if (loader != null) {
        if (autoLoad) {
          if (store.isFiltered()) {
            renderChildren(child);
          } else {
            loader.loadChildren(child);
          }
        }
      }
    }

    TreeNode n = findNode(parent);
    if (n != null) {
      n.childrenRendered = true;
    }
  }

  protected void update() {
    if (updateTask == null) {
      updateTask = new DelayedTask(new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
          doUpdate();
        }
      });
    }
    updateTask.delay(view.getScrollDelay());
  }

  private void cleanCollapsed(final List<M> l) {
    List<M> list = store.getAllItems();
    for (M m : list) {
      TreeNode node = findNode(m);
      if (node != null && !node.isLeaf() && !node.isExpanded()) {
        for (M m2 : store.getChildren(m)) {
          cleanNode(findNode(m2));
        }
      }
    }
  }

  private void cleanNode(TreeNode node) {
    if (node != null) {
      node.clearElements();
      node.getElement().getFirstChildElement().setInnerHTML("");
    }
  }

  private void findChildren(M parent, List<M> list, boolean onlyVisible) {
    for (M child : store.getChildren(parent)) {
      list.add(child);
      if (!onlyVisible || findNode(child).isExpanded()) {
        findChildren(child, list, onlyVisible);
      }
    }
  }

  private int[] getVisibleRows(List<M> visible) {
    int count = getVisibleRowCount();
    int sc = el().getScrollTop();
    int start = (int) (sc == 0 ? 0 : Math.floor(sc / view.getCalculatedRowHeight()) - 1);
    int first = Math.max(start, 0);
    int last = Math.min(start + count + 2, visible.size() - 1);

    return new int[] {first, last};
  }

  private boolean isRowRendered(int i, List<M> visible) {
    Element e = findNode(visible.get(i)).getElement();
    return e != null && e.getFirstChild().hasChildNodes();
  }

  private void setExpandChildren(M m, boolean expand) {
    for (M child : store.getChildren(m)) {
      setExpanded(child, expand, true);
    }
  }

}
