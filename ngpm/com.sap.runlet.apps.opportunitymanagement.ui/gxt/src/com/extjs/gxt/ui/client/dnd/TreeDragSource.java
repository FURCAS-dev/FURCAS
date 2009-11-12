/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.dnd;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.binder.TreeBinder;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.dnd.DND.Operation;
import com.extjs.gxt.ui.client.dnd.DND.TreeSource;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.widget.tree.Tree;
import com.extjs.gxt.ui.client.widget.tree.TreeItem;

/**
 * A <code>DragSource</code> implementation for Trees.
 * 
 * @deprecated {@link TreePanelDragSource}
 */
public class TreeDragSource extends DragSource {

  protected Tree tree;
  protected TreeSource treeSource = TreeSource.BOTH;
  protected TreeBinder<ModelData> binder;

  /**
   * Creates a new drag source instance. The default code will set the selected
   * TreeItems as the data being dragged.
   * 
   * @param tree the source tree
   */
  public TreeDragSource(Tree tree) {
    super(tree);
    this.tree = tree;
    setStatusText("{0} items selected");
  }

  /**
   * Creates a new drag source instance. The default code will set a list of
   * TreeModels as the data being dragged. Each TreeModel instance is retrieved
   * from the {@link TreeStore#getModelState(ModelData)}.
   * 
   * @param binder the tree binder
   */
  public TreeDragSource(TreeBinder<ModelData> binder) {
    this(binder.getTree());
    this.binder = binder;
  }

  /**
   * Returns the type if items that can be dragged.
   * 
   * @return the tree source type
   */
  public TreeSource getTreeSource() {
    return treeSource;
  }

  /**
   * Sets witch tree items can be dragged (defaults to BOTH).
   * 
   * @param treeSource the tree source type
   */
  public void setTreeSource(TreeSource treeSource) {
    this.treeSource = treeSource;
  }

  @Override
  protected void onDragDrop(DNDEvent event) {
    if (event.getOperation() == Operation.MOVE) {
      if (binder != null) {
        List<TreeModel> sel = event.getData();
        for (TreeModel tm : sel) {
          ModelData m = (ModelData)tm.get("model");
          ModelData p = binder.getTreeStore().getParent(m);
          if (p != null) {
            binder.getTreeStore().remove(p, m);
          } else {
            binder.getTreeStore().remove(m);
          }
        }
      } else {
        List<TreeItem> sel = event.getData();
        for (TreeItem item : sel) {
          TreeItem p = item.getParentItem();
          if (p != null) {
            p.remove(item);
          }
        }
      }
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  protected void onDragStart(DNDEvent e) {
    TreeItem item = tree.findItem(e.getTarget());
    if (item == null || e.getTarget(".my-tree-joint", 3) != null) {
      e.setCancelled(true);
      return;
    }

    boolean leaf = treeSource == TreeSource.LEAF || treeSource == TreeSource.BOTH;
    boolean node = treeSource == TreeSource.NODE || treeSource == TreeSource.BOTH;

    List<TreeItem> sel = tree.getSelectionModel().getSelectedItems();
    if (sel.size() > 0) {
      boolean ok = true;
      for (TreeItem ti : sel) {
        if ((leaf && ti.isLeaf()) || (node && !ti.isLeaf())) {
          continue;
        }
        ok = false;
        break;
      }

      if (ok) {
        if (sel.get(0).getModel() != null) {
          List models = new ArrayList();
          for (TreeItem ti : sel) {
            models.add(binder.getTreeStore().getModelState((ModelData)ti.getModel()));
          }
          e.setData(models);
        } else {
          e.setData(sel);
        }
        e.setCancelled(false);
        e.getStatus().update(Format.substitute(getStatusText(), sel.size()));

      } else {
        e.setCancelled(true);
      }

    } else {
      e.setCancelled(true);
    }
  }

}
