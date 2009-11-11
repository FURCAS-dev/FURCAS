/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.binder;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.tree.TreeItem;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treetable.TreeTable;
import com.extjs.gxt.ui.client.widget.treetable.TreeTableItem;

/**
 * A <code>StoreBinder</code> implementation for <code>TreeTable</code>.
 * 
 * @param <M> the model type
 * 
 * @deprecated see @link {@link TreeGrid}
 */
public class TreeTableBinder<M extends ModelData> extends TreeBinder<M> {

  protected TreeTable treeTable;

  /**
   * Creates a new tree table binder.
   * 
   * @param treeTable the tree table
   * @param store the store
   */
  public TreeTableBinder(TreeTable treeTable, TreeStore<M> store) {
    super(treeTable, store);
    this.treeTable = treeTable;
  }

  @Override
  public Component findItem(M model) {
    for (TreeItem item : treeTable.getAllItems()) {
      if (store.getModelComparer().equals(item.<M>getModel(), model)) {
        return item;
      }
    }
    return null;
  }

  @Override
  protected void createAll() {
    TreeTableItem root = (TreeTableItem) treeTable.getRootItem();
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
      treeTable.getRootItem().add(item);

      if (autoLoad && item != null) {
        item.setData("force", true);
        loadChildren(item, false);
      }
    }
    fireEvent(Events.Refresh);
  }

  protected TreeItem createItem(M model) {
    int cols = treeTable.getColumnCount();
    TreeTableItem item = new TreeTableItem(new Object[cols]);
    setModel(item, model);
    updateItemValues(item);
    updateItemStyles(item);

    String txt = getTextValue(model, displayProperty);
    if (txt == null && displayProperty != null) {
      txt = model.get(displayProperty);
    } else {
      txt = model.toString();
    }

    String icon = getIconValue(model, displayProperty);

    item.setIconStyle(icon);
    item.setText(txt);

    if (loader != null) {
      item.setLeaf(!loader.hasChildren(model));
    } else {
      item.setLeaf(!hasChildren(model));
    }

    return item;
  }

  protected String getColumnId(int column) {
    return treeTable.getColumn(column).getId();
  }

  protected boolean hasChildren(M parent) {
    return store.getChildCount(parent) != 0;
  }

  @Override
  protected void update(M model) {
    TreeTableItem item = (TreeTableItem) findItem(model);
    if (item != null) {
      setModel(item, model);
      updateItemValues(item);
      updateItemStyles(item);

      String icon = getIconValue(model, displayProperty);
      String style = (styleProvider == null) ? null : styleProvider.getStringValue(model,
          displayProperty);

      item.setTextStyle(style);
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

  private void updateItemStyles(TreeTableItem item) {
    M model = item.<M>getModel();
    int cols = treeTable.getColumnCount();
    for (int i = 0; i < cols; i++) {
      String id = getColumnId(i);
      String style = (styleProvider == null) ? null : styleProvider.getStringValue(model, id);
      item.setCellStyle(i, style == null ? "" : style);
    }
  }

  private void updateItemValues(TreeTableItem item) {
    M model = item.<M>getModel();
    int cols = treeTable.getColumnCount();
    for (int j = 0; j < cols; j++) {
      String id = getColumnId(j);
      Object val = getTextValue(model, id);
      if (val == null) val = model.get(id);
      item.setValue(j, val);
    }
  }

}
