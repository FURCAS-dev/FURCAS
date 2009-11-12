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

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.dnd.DND.Operation;
import com.extjs.gxt.ui.client.dnd.DND.TreeSource;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.TreeNode;

public class TreePanelDragSource extends DragSource {

  protected TreePanel<ModelData> tree;
  protected TreeSource treeSource = TreeSource.BOTH;

  @SuppressWarnings("unchecked")
  public TreePanelDragSource(TreePanel tree) {
    super(tree);
    this.tree = tree;
    setStatusText("{0} items selected");
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
      List<TreeModel> sel = event.getData();
      for (TreeModel tm : sel) {
        ModelData m = (ModelData) tm.get("model");
        ModelData p = tree.getStore().getParent(m);
        if (p != null) {
          tree.getStore().remove(p, m);
        } else {
          tree.getStore().remove(m);
        }
      }
    }
  }
  
  @Override
  @SuppressWarnings("unchecked")
  protected void onDragStart(DNDEvent e) {
    TreeNode n = tree.findNode(e.getTarget());
    ModelData m = n.getModel();
    if (!tree.getView().isSelectableTarget(m, e.getTarget())) {
      e.setCancelled(true);
      return;
    }
    
    boolean leaf = treeSource == TreeSource.LEAF || treeSource == TreeSource.BOTH;
    boolean node = treeSource == TreeSource.NODE || treeSource == TreeSource.BOTH;

    List<ModelData> sel = tree.getSelectionModel().getSelectedItems();
    if (sel.size() > 0) {
      boolean ok = true;
      for (ModelData mi : sel) {
        if ((leaf && tree.isLeaf(mi)) || (node && !tree.isLeaf(mi))) {
          continue;
        }
        ok = false;
        break;
      }
      if (ok) {
          List models = new ArrayList();
          for (ModelData mi : sel) {
            models.add(tree.getStore().getModelState(mi));
          }
          e.setData(models);
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
