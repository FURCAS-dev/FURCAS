/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treepanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.selection.AbstractStoreSelectionModel;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.TreeNode;
import com.google.gwt.user.client.Event;

/**
 * <code>TreePanel</code> selection model.
 * 
 * @param <M> the model type
 */
@SuppressWarnings("unchecked")
public class TreePanelSelectionModel<M extends ModelData> extends AbstractStoreSelectionModel<M> implements
    Listener<TreePanelEvent> {

  protected TreePanel tree;
  protected TreeStore<M> treeStore;
  protected List<M> selectedPreRender;

  protected KeyNav<TreePanelEvent<M>> keyNav = new KeyNav<TreePanelEvent<M>>() {

    @Override
    public void onDown(TreePanelEvent<M> e) {
      onKeyDown(e);
    }

    @Override
    public void onLeft(TreePanelEvent<M> ce) {
      onKeyLeft(ce);
    }

    @Override
    public void onRight(TreePanelEvent<M> ce) {
      onKeyRight(ce);
    }

    @Override
    public void onUp(TreePanelEvent<M> e) {
      onKeyUp(e);
    }

  };

  public void bindTree(TreePanel tree) {
    if (this.tree != null) {
      this.tree.removeListener(Events.OnMouseDown, this);
      keyNav.bind(null);
      bind(null);
    }
    this.tree = tree;
    if (tree != null) {
      tree.addListener(Events.OnMouseDown, this);
      keyNav.bind(tree);
      bind(tree.getStore());
      this.treeStore = (TreeStore) tree.getStore();
    }
  }

  @Override
  public void deselect(int index) {

  }

  @Override
  public void deselect(int start, int end) {

  }

  public void handleEvent(TreePanelEvent be) {
    int type = be.getEventTypeInt();
    switch (type) {
      case Event.ONMOUSEDOWN:
        onMouseDown(be);
        break;
    }
  }

  @Override
  public boolean isSelected(M item) {
    return selected.contains(item);
  }

  @Override
  public void select(int start, int end, boolean keepExisting) {

  }

  /**
   * Selects the item below the selected item in the tree, intelligently walking
   * the nodes.
   */
  public void selectNext() {
    M next = next();
    if (next != null) {
      doSingleSelect(next, false);
    }
  }

  /**
   * Selects the item above the selected item in the tree, intelligently walking
   * the nodes.
   */
  public void selectPrevious() {
    M prev = prev();
    if (prev != null) {
      doSingleSelect(prev, false);
    }
  }

  protected void ensureExpanded(M model) {
    tree.setExpanded(treeStore.getParent(model), true);
  }

  protected void hookPreRender(M item, boolean select) {
    if (selectedPreRender == null) {
      selectedPreRender = new ArrayList<M>();
      tree.addListener(Events.Render, new Listener<ComponentEvent>() {
        public void handleEvent(ComponentEvent be) {
          tree.removeListener(Events.Render, this);
          onRender();
        }
      });
    }
    if (select && !selectedPreRender.contains(item)) {
      selectedPreRender.add(item);
    } else if (!select) {
      selectedPreRender.remove(item);
    }
  }

  protected M next() {
    M sel = lastSelected;
    if (sel == null) {
      return null;
    }
    if (treeStore.getFirstChild(sel) != null && tree.isExpanded(sel)) {
      return treeStore.getFirstChild(sel);
    } else if (treeStore.getNextSibling(sel) != null) {
      return treeStore.getNextSibling(sel);
    } else if (treeStore.getParent(sel) != null) {
      M p = treeStore.getParent(sel);
      while (p != null) {
        if (treeStore.getNextSibling(p) != null) {
          return treeStore.getNextSibling(p);
        }
        p = treeStore.getParent(p);
      }
    }

    return null;
  }

  protected void onKeyDown(TreePanelEvent<M> e) {
    e.preventDefault();
    M next = next();
    if (next != null) {
      doSingleSelect(next, false);
      tree.scrollIntoView(next);
    }
  }

  protected void onKeyLeft(TreePanelEvent<M> ce) {
    if (lastSelected == null) {
      return;
    }
    if (!tree.isLeaf(lastSelected) && tree.isExpanded(lastSelected)) {
      tree.setExpanded(lastSelected, false);
    } else if (treeStore.getParent(lastSelected) != null) {
      doSingleSelect(treeStore.getParent(lastSelected), false);
    }
  }

  protected void onKeyRight(TreePanelEvent<M> ce) {
    if (lastSelected == null) {
      return;
    }
    if (!tree.isLeaf(lastSelected)) {
      if (!tree.isExpanded(lastSelected)) {
        tree.setExpanded(lastSelected, true);
      }
    }
  }

  protected void onKeyUp(TreePanelEvent<M> e) {
    e.preventDefault();
    M prev = prev();
    if (prev != null) {
      doSingleSelect(prev, false);
      tree.scrollIntoView(prev);
    }
  }

  protected void onRender() {
    if (selectedPreRender != null) {
      for (M item : selectedPreRender) {
        onSelectChange(item, true);
      }
      selectedPreRender = null;
    }
  }

  @Override
  protected void onSelectChange(M model, boolean select) {
    if (locked) return;
    if (!tree.isRendered()) {
      hookPreRender(model, select);
      return;
    }
    if (select) {
      ensureExpanded(model);
    }

    tree.getView().onSelectChange(model, select);
  }

  protected M prev() {
    M sel = lastSelected;
    if (sel == null) {
      return sel;
    }
    if (treeStore.getPreviousSibling(sel) != null) {
      M prev = treeStore.getPreviousSibling(sel);
      if ((!tree.isExpanded(prev) || treeStore.getChildCount(prev) < 1)) {
        return prev;
      } else {
        M lastChild = treeStore.getLastChild(prev);
        while (lastChild != null && treeStore.getChildCount(lastChild) > 0 && tree.isExpanded(lastChild)) {
          lastChild = treeStore.getLastChild(lastChild);
        }
        return lastChild;
      }
    } else if (treeStore.getParent(sel) != null) {
      return treeStore.getParent(sel);
    }
    return null;
  }

  private void onMouseDown(TreePanelEvent be) {
    if (be.getItem() == null) return;

    if (!tree.getView().isSelectableTarget(be.getItem(), be.getTarget())) {
      return;
    }

    M sel = (M) be.getItem();

    switch (selectionMode) {
      case SIMPLE:
        if (isSelected(sel)) {
          deselect(sel);
        } else {
          doSelect(Util.createList(sel), true, false);
        }
        break;
      case SINGLE:
        doSingleSelect(sel, false);
        break;
      case MULTI:
        if (be.isShiftKey() && lastSelected != null) {
          List<M> items = new ArrayList<M>();
          if (lastSelected == sel) {
            return;
          }
          TreeNode selNode = tree.findNode(lastSelected);
          TreeNode itemNode = tree.findNode(sel);

          if (selNode.element != null && itemNode.element != null) {
            if (selNode.element.getAbsoluteTop() < itemNode.element.getAbsoluteTop()) {
              M next = next();
              while (next != null) {
                items.add(next);
                lastSelected = next;
                if (next == sel) break;
                next = next();
              }
            } else {
              M prev = prev();
              while (prev != null) {
                items.add(prev);
                lastSelected = prev;
                if (prev == sel) break;
                prev = prev();
              }
            }
            doSelect(items, true, false);
          }
        } else if (isSelected(sel) && be.isControlKey()) {
          doDeselect(Arrays.asList(sel), false);
        } else {
          doSelect(Arrays.asList(sel), be.isControlKey(), false);
        }
        break;
    }
  }
}
