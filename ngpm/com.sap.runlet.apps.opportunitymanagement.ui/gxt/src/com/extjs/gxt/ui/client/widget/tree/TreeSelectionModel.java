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

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.widget.Items;
import com.extjs.gxt.ui.client.widget.selection.AbstractSelectionModel;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;

/**
 * Tree single-select selection model.
 * 
 * @deprecated see {@link TreePanel}
 */
@SuppressWarnings("unchecked")
public class TreeSelectionModel extends AbstractSelectionModel<Tree, TreeItem> {

  public TreeSelectionModel() {
    super();
  }

  public TreeSelectionModel(SelectionMode mode) {
    super(mode);
  }

  /**
   * Selects the item below the selected item in the tree, intelligently walking
   * the nodes.
   */
  public void selectNext() {
    TreeItem next = next();
    if (next != null) {
      doSelect(new Items(next), false, false);
    }
  }

  /**
   * Selects the item above the selected item in the tree, intelligently walking
   * the nodes.
   */
  public void selectPrevious() {
    TreeItem previous = previous();
    if (previous != null) {
      doSelect(new Items(previous), false, false);
    }
  }

  @Override
  protected void doMultiSelect(TreeItem item, ContainerEvent ce) {
    if (locked) return;
    if (ce.isShiftKey() && selectedItem != null) {
      List<TreeItem> items = new ArrayList<TreeItem>();
      if(selectedItem==item)
        return;
      if (selectedItem.getAbsoluteTop() < item.getAbsoluteTop()) {
        TreeItem next = next();
        while (next != null) {
          items.add(next);
          selectedItem = next;
          if (next == item) break;
          next = next();
        }
      } else {
        TreeItem prev = previous();
        while (prev != null) {
          items.add(prev);
          selectedItem = prev;
          if (prev == item) break;
          prev = previous();
        }
      }
      doSelect(new Items(items), true, false);
    } else {
      if (ce.isControlKey() && isSelected(item)) {
        deselect(item);
      } else {
        doSelect(new Items(item), ce.isControlKey(), false);
      }
    }
  }

  protected void ensureExpanded(TreeItem item) {
    List<TreeItem> stack = new ArrayList<TreeItem>();
    item = item.getParentItem();
    while (item != null) {
      if (!item.isRoot()) {
        stack.add(item);
      }
      item = item.getParentItem();
    }

    for (int i = stack.size() - 1; i >= 0; i--) {
      TreeItem ti = stack.get(i);
      ti.setExpanded(true);
    }
  }

  @Override
  protected TreeItem next() {
    TreeItem sel = selectedItem;
    if (sel == null) {
      return null;
    }
    if (sel.firstChild() != null && sel.isExpanded()) {
      return sel.firstChild();
    } else if (sel.nextSibling() != null) {
      return sel.nextSibling();
    } else if (sel.getParentItem() != null) {
      TreeItem p = sel.getParentItem();
      while (p != null) {
        if (p.nextSibling() != null) {
          return p.nextSibling();
        }
        p = p.getParentItem();
      }
    }
    return null;
  }

  @Override
  protected void onKeyDown(ContainerEvent ce) {
    super.onKeyDown(ce);
  }

  @Override
  protected void onKeyLeft(ContainerEvent ce) {
    ce.preventDefault();
    if (selectedItem == null) return;
    if (!selectedItem.isLeaf() && selectedItem.isExpanded()) {
      selectedItem.setExpanded(false);
    } else if (selectedItem.getParentItem() != null
        && !selectedItem.getParentItem().isRoot()) {
      doSelect(new Items(selectedItem.getParentItem()), false, false);
    }
  }

  @Override
  protected void onKeyRight(ContainerEvent ce) {
    ce.preventDefault();
    if (selectedItem == null) return;
    if (!selectedItem.isLeaf()) {
      if (!selectedItem.isExpanded()) {
        selectedItem.setExpanded(true);
        return;
      }
    }
    selectNext();
  }

  @Override
  protected void onKeyUp(ContainerEvent ce) {
    super.onKeyUp(ce);
  }

  @Override
  protected void onMouseDown(ContainerEvent ce) {
    if (ce.isRightClick()) {
      return;
    }
    TreeItem item = (TreeItem)ce.getItem();
    if (item != null) {
      if (!item.getUI().isSelectableTarget(ce.getTarget())) {
        return;
      }
    }
    super.onMouseDown(ce);
  }

  @Override
  protected void onSelectChange(TreeItem item, boolean select) {
    if (locked) return;
    if (!container.isRendered()) {
      hookPreRender(item, select);
      return;
    }
    if (select) {
      ensureExpanded(item);
    }
    item.getUI().onSelectedChange(select);
  }

  @Override
  protected TreeItem previous() {
    TreeItem sel = selectedItem;
    if (sel == null) {
      return null;
    }

    if (sel.previousSibling() != null) {
      TreeItem prev = sel.previousSibling();
      if ((!prev.isExpanded() || prev.getItemCount() < 1)) {
        return prev;
      } else {
        TreeItem lastChild = prev.lastChild();
        while (lastChild != null && lastChild.getItemCount() > 0
            && lastChild.isExpanded()) {
          lastChild = lastChild.lastChild();
        }
        return lastChild;
      }
    } else if (sel.getParentItem() != null && !sel.getParentItem().isRoot()) {
      return sel.getParentItem();
    }
    return null;
  }

}
