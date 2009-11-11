/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.dnd;

import java.util.List;

import com.extjs.gxt.ui.client.binder.TreeBinder;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.dnd.DND.Feedback;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.extjs.gxt.ui.client.widget.tree.Tree;
import com.extjs.gxt.ui.client.widget.tree.TreeItem;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;

/**
 * A <code>DropTarget</code> implementation for Trees.
 * 
 * <p />
 * The implementation of onDragDrop expects either a list of TreeItems when
 * using only a Tree, or a list of TreeModel instances if using a TreeBinder.
 * 
 * @deprecated {@link TreePanelDropTarget}
 */
public class TreeDropTarget extends DropTarget {

  protected TreeBinder<ModelData> binder;
  protected Tree tree;
  protected TreeItem activeItem, appendItem;
  protected int status;
  
  private boolean allowDropOnLeaf = false;
  private boolean autoExpand = true;
  private int autoExpandDelay = 800;

  /**
   * Creates a new tree drop target.
   * 
   * @param tree the target tree
   */
  public TreeDropTarget(Tree tree) {
    super(tree);
    this.tree = tree;
  }

  /**
   * Creates a new tree drop target.
   * 
   * @param binder the target tree binder
   */
  public TreeDropTarget(TreeBinder<ModelData> binder) {
    this(binder.getTree());
    this.binder = binder;
  }

  /**
   * Returns the auto expand delay in milliseconds.
   * 
   * @return the delay
   */
  public int getAutoExpandDelay() {
    return autoExpandDelay;
  }

  /**
   * Returns the target's tree binder.
   * 
   * @return the tree binder
   */
  public TreeBinder<ModelData> getBinder() {
    return binder;
  }

  /**
   * Returns the target's tree.
   * 
   * @return the tree
   */
  public Tree getTree() {
    return tree;
  }

  /**
   * Returns whether drops are allowed on leaf nodes.
   * 
   * @return true of drops on leafs are allowed
   */
  public boolean isAllowDropOnLeaf() {
    return allowDropOnLeaf;
  }

  /**
   * Returns true if auto expand is enabled.
   * 
   * @return the auto expand state
   */
  public boolean isAutoExpand() {
    return autoExpand;
  }

  /**
   * True to allow drops on leaf nodes (defaults to false).
   * 
   * @param allowDropOnLeaf true to enable drops on leaf nodes
   */
  public void setAllowDropOnLeaf(boolean allowDropOnLeaf) {
    this.allowDropOnLeaf = allowDropOnLeaf;
  }

  /**
   * True to automatically expand the active tree item when the user hovers over
   * a collapsed item (defaults to true). Use {@link #setAutoExpandDelay(int)}
   * to set the delay.
   * 
   * @param autoExpand true to auto expand
   */
  public void setAutoExpand(boolean autoExpand) {
    this.autoExpand = autoExpand;
  }

  /**
   * Sets the delay used to auto expand items (defualts to 800).
   * 
   * @param autoExpandDelay the delay in milliseconds
   */
  public void setAutoExpandDelay(int autoExpandDelay) {
    this.autoExpandDelay = autoExpandDelay;
  }

  protected void handleAppend(DNDEvent event, final TreeItem item) {
    // clear any active append item
    if (activeItem != null && activeItem != item) {
      activeItem.el().firstChild().removeStyleName("my-tree-drop");
    }
    status = -1;

    Insert.get().hide();
    event.getStatus().setStatus(true);
    if (activeItem != null) {
      activeItem.el().firstChild().removeStyleName("my-tree-drop");
    }

    if (item != appendItem && autoExpand && !item.isExpanded()) {
      Timer t = new Timer() {
        @Override
        public void run() {
          if (item == appendItem) {
            item.setExpanded(true);
          } else {
          }
        }
      };
      t.schedule(autoExpandDelay);
    }
    appendItem = item;
    activeItem = item;
    activeItem.el().firstChild().addStyleName("my-tree-drop");
  }
  
  @SuppressWarnings("unchecked")
  protected void appendModel(ModelData p, TreeModel model, int index) {
    ModelData child = model.get("model");
    if (p == null) {
      binder.getTreeStore().insert(child, index, false);
    } else {
      binder.getTreeStore().insert(p, child, index, false);
    }
    List<TreeModel> children = (List)model.getChildren();
    for (int i = 0; i < children.size(); i++) {
      appendModel(child, children.get(i), i);
    }
  }
  @SuppressWarnings("unchecked")
  protected void handleAppendDrop(DNDEvent event, TreeItem item) {
    List sel = event.getData();
    if (sel.size() > 0) {
      if (sel.get(0) instanceof ModelData) {
        TreeModel tm = (TreeModel) sel.get(0);
        ModelData p = item.getModel();
        appendModel(p, tm, item.getItemCount());
      } else {
        for (int i = 0; i < sel.size(); i++) {
          TreeItem ti = (TreeItem) sel.get(i);
          item.add(ti);
        }
      }
    }

  }

  protected void handleInsert(DNDEvent event, final TreeItem item) {
    // clear any active append item
    if (activeItem != null && activeItem != item) {
      activeItem.el().firstChild().removeStyleName("my-tree-drop");
    }

    int height = item.getOffsetHeight();
    int mid = height / 2;
    int top = item.getAbsoluteTop();
    mid += top;
    int y = event.getClientY();
    boolean before = y < mid;

    if (!item.isLeaf() || allowDropOnLeaf) {
      if ((before && y > top + 4) || (!before && y < top + height - 4)) {
        handleAppend(event, item);
        return;
      }
    }

    appendItem = null;

    status = before ? 0 : 1;

    if (activeItem != null) {
      activeItem.el().firstChild().removeStyleName("my-tree-drop");
    }

    activeItem = item;
    int idx = activeItem.getParentItem().indexOf(item);

    String status = "x-tree-drop-ok-between";
    if (before && idx == 0) {
      status = "x-tree-drop-ok-above";
    } else if (idx > 1 && !before && idx == item.getParentItem().getItemCount() - 1) {
      status = "x-tree-drop-ok-below";
    }
    event.getStatus().setStatus(true, status);

    if (before) {
      showInsert(event, item.getElement(), true);
    } else {
      showInsert(event, item.getElement(), false);
    }
  }

  @SuppressWarnings("unchecked")
  protected void handleInsertDrop(DNDEvent event, TreeItem item, int index) {
    List sel = event.getData();
    if (sel.size() > 0) {
      int idx = item.getParentItem().indexOf(item);
      idx = status == 0 ? idx : idx + 1;
      if (sel.get(0) instanceof ModelData) {
        ModelData p = item.getParentItem().getModel();
        appendModel(p, (TreeModel)sel.get(0), idx);
      } else {
        for (int i = 0; i < sel.size(); i++) {
          TreeItem ti = (TreeItem) sel.get(i);
          item.add(ti, idx);
        }
      }
    }

  }

  @Override
  protected void onDragDrop(DNDEvent event) {
    super.onDragDrop(event);

    if (activeItem != null && status == -1) {
      activeItem.el().firstChild().removeStyleName("my-tree-drop");
      if (event.getData() != null) {
        handleAppendDrop(event, activeItem);
      }
    } else if (activeItem != null && status != -1) {
      if (event.getData() != null) {
        handleInsertDrop(event, activeItem, status);
      }
    } else {
      event.setCancelled(true);
    }
  }

  @Override
  protected void onDragEnter(DNDEvent e) {
    super.onDragEnter(e);
    e.getStatus().setStatus(false);
  }

  @Override
  protected void onDragLeave(DNDEvent e) {
    super.onDragLeave(e);
    if (activeItem != null) {
      activeItem.el().firstChild().removeStyleName("my-tree-drop");
      activeItem = null;
    }
  }

  @Override
  protected void onDragMove(DNDEvent event) {
    event.setCancelled(false);
  }

  @Override
  protected void showFeedback(DNDEvent event) {
    final TreeItem item = tree.findItem(event.getTarget());
    if (item == null) {
      event.getStatus().setStatus(false);
      return;
    }
    if (event.getDropTarget().component == event.getDragSource().component) {
      Tree source = (Tree) event.getDragSource().component;
      TreeItem sel = source.getSelectedItem();
      List<TreeItem> children = sel.getItems(true);
      if (children.contains(item)) {
        event.getStatus().setStatus(false);
        return;
      }
    }

    boolean append = feedback == Feedback.APPEND || feedback == Feedback.BOTH;
    boolean insert = feedback == Feedback.INSERT || feedback == Feedback.BOTH;

    if (insert) {
      handleInsert(event, item);
    } else if ((!item.isLeaf() || allowDropOnLeaf) && append) {
      handleAppend(event, item);
    } else {
      if (activeItem != null) {
        activeItem.el().firstChild().removeStyleName("my-tree-drop");
      }
      status = -1;
      activeItem = null;
      appendItem = null;
      Insert.get().hide();
      event.getStatus().setStatus(false);
    }
  }

  private void showInsert(DNDEvent event, Element elem, boolean before) {
    Insert insert = Insert.get();
    insert.show();
    Rectangle rect = El.fly(elem).getBounds();
    int y = before ? rect.y - 2 : (rect.y + rect.height - 4);
    insert.setBounds(rect.x, y, rect.width, 6);
  }

}
