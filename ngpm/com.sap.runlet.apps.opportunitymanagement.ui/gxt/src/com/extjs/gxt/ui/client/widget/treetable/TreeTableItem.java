/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treetable;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.TreeTableEvent;
import com.extjs.gxt.ui.client.widget.tips.ToolTip;
import com.extjs.gxt.ui.client.widget.tree.Tree;
import com.extjs.gxt.ui.client.widget.tree.TreeItem;
import com.extjs.gxt.ui.client.widget.tree.TreeItemUI;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * A item in a <code>TreeTable</code>. All events are bubbled to the item's
 * parent treetable.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeAdd</b> : TreeTableEvent(treeTable, item, child, index)<br>
 * <div>Fires before a item is added or inserted. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>treeTable : the tree table</li>
 * <li>item : this</li>
 * <li>child : the item being added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRemove</b> : TreeTableEvent(treeTable, item, child)<br>
 * <div>Fires before a item is removed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>treeTable : this</li>
 * <li>item : this</li>
 * <li>child : the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeExpand</b> : TreeTableEvent(treeTable, item)<br>
 * <div>Fires before a item is expanded. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>treeTable : this</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeCollapse</b> : TreeTableEvent(treeTable, item)<br>
 * <div>Fires before a item is collapsed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>treeTable : this</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : TreeTableEvent(treeTable, item, index)<br>
 * <div>Fires after a item has been added or inserted.</div>
 * <ul>
 * <li>treeTable : the tree table</li>
 * <li>item : this</li>
 * <li>child : the item that was added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : TreeEvent(treeTable, item, child)<br>
 * <div>Fires after a item has been removed.</div>
 * <ul>
 * <li>treeTable : the tree table</li>
 * <li>item : this</li>
 * <li>child : the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Expand</b> : TreeEvent(treeTable, item)<br>
 * <div>Fires after a item has been expanded.</div>
 * <ul>
 * <li>item : the item being expanded</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Collapse</b> : TreeEvent(treeTable, item)<br>
 * <div>Fires after a item is collapsed.</div>
 * <ul>
 * <li>treeTable : the tree table</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CheckChange</b> : TreeTableEvent(treeTable, item)<br>
 * <div>Fires after a check state change.</div>
 * <ul>
 * <li>treeTable : the tree table</li>
 * <li>item : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CellClick</b> : TreeTableEvent(treeTable, item, columnIndex)<br>
 * <div>Fires after a cell has been clicked.</div>
 * <ul>
 * <li>treeTable : the tree table</li>
 * <li>item : this</li>
 * <li>columnIndex : cell column index</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CellDoubleClick</b> : RowDoubleClick(treeTable, item, columnIndex)<br>
 * <div>Fires after a cell has been double clicked.</div>
 * <ul>
 * <li>treeTable : the tree table</li>
 * <li>item : this</li>
 * <li>columnIndex : cell column index</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>RowClick</b> : (treeTable, item, index)<br>
 * <div>Fires after a cell has been clicked.</div>
 * <ul>
 * <li>treeTable : the tree table</li>
 * <li>item : this</li>
 * <li>columnIndex : cell column index</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>RowDoubleClick</b> : TreeTableEvent(treeTable, item, columnIndex)<br>
 * <div>Fires after a cell has been double clicked.</div>
 * <ul>
 * <li>treeTable : the treet table</li>
 * <li>item : this</li>
 * <li>columnIndex : cell column index</li>
 * </ul>
 * </dd>
 * 
 * <dt><b>CSS:</b></dt>
 * <dd>.my-tree-item (the item itself)</dd>
 * <dd>.my-tree-item-text span (the tree item text)</dd>
 * </dl>
 * 
 * @deprecated see @link {@link TreeGrid}
 */
public class TreeTableItem extends TreeItem {

  protected TreeTable treeTable;
  protected String[] cellStyles;
  protected boolean cellsRendered;
  protected Object[] values;
  protected String[] toolTips;
  protected ToolTip cellToolTip;
  protected boolean hasWidgets;

  /**
   * Creates a new tree table item.
   * 
   * @param values the cell values
   */
  public TreeTableItem(Object[] values) {
    this.values = values;
  }

  /**
   * Creates a new tree table item.
   * 
   * @param text the text
   * @param values the values
   */
  public TreeTableItem(String text, Object[] values) {
    super(text);
    this.values = values;
  }

  /**
   * Returns the item's cell tooltip.
   * 
   * @return the tooltip
   */
  public ToolTip getCellToolTip() {
    return cellToolTip;
  }

  /**
   * Returns the item's tree table.
   * 
   * @return the tree table
   */
  public TreeTable getTreeTable() {
    return treeTable;
  }

  /**
   * Returns a cell value.
   * 
   * @param index the cell index
   * @return the value
   */
  public Object getValue(int index) {
    return values[index];
  }

  /**
   * Returns the item's values.
   * 
   * @return the values
   */
  public Object[] getValues() {
    return values;
  }

  public void onComponentEvent(ComponentEvent ce) {
    if (ui != null) {
      getUI().handleEvent((TreeTableEvent) ce);
    }
    switch (ce.getEventTypeInt()) {
      case Event.ONCLICK:
        onClick(ce);
        break;
      case Event.ONDBLCLICK:
        onDoubleClick(ce);
        break;
      case Event.ONMOUSEOVER:
        onMouseOver(ce);
        break;
    }

  }

  /**
   * Sets the style for a table cell.
   * 
   * @param index the column index
   * @param style the new style
   */
  public void setCellStyle(int index, String style) {
    if (cellStyles == null) cellStyles = new String[values.length];
    cellStyles[index] = style;
    if (isRendered()) {
      treeTable.getView().setCellStyle(this, index, style);
    }
  }

  /**
   * Returns the style for the given cell.
   * 
   * @param index the column index
   * @return the style
   */
  public String getCellStyle(int index) {
    if (cellStyles != null) {
      return cellStyles[index];
    }
    return null;
  }

  /**
   * Sets a cell tooltip.
   * 
   * @param index the column index
   * @param text the text of the tool tip
   */
  public void setCellToolTip(int index, String text) {
    if (toolTips == null) toolTips = new String[values.length];
    toolTips[index] = text;
  }

  /**
   * Sets all of the cell tooltips
   * 
   * @param toolTips the tool tips to use
   */
  public void setCellToolTips(String[] toolTips) {
    this.toolTips = toolTips;
  }

  /**
   * Sets a cell value.
   * 
   * @param index the column index
   * @param text the text
   */
  public void setText(int index, String text) {
    setValue(index, text);
  }

  /**
   * Sets a cell value.
   * 
   * @param index the column index
   * @param value the value
   */
  public void setValue(int index, Object value) {
    values[index] = value;
    if (rendered) {
      treeTable.getView().renderItemValue(this, index, value);
    }
  }

  /**
   * Sets the item's values.
   * 
   * @param values the values
   */
  public void setValues(Object[] values) {
    this.values = values;
  }

  protected String[] getRenderedValues() {
    String[] svalues = new String[values.length];
    for (int i = 0; i < values.length; i++) {
      svalues[i] = treeTable.getRenderedValue(this, i, values[i]);
    }
    return svalues;
  }

  /**
   * Subclasses may override.
   * 
   * @return the ui
   */
  @Override
  protected TreeItemUI getTreeItemUI() {
    return new TreeTableItemUI(this);
  }

  protected void onRender(Element target, int index) {
    ui = getTreeItemUI();
    //TODO fix
    ((TreeTableItemUI)ui).render(target, index);
  }

  protected void init(TreeTable treeTable) {
    this.tree = treeTable;
    this.treeTable = treeTable;
  }

  public void setElement(Element elem) {
    super.setElement(elem);
  }

  protected void onMouseOver(ComponentEvent ce) {
    onCellMouseOver(ce);
  }

  protected void onCellMouseOver(ComponentEvent ce) {
    Element target = ce.getTarget();

    int index = treeTable.getView().getCellIndex(target);
    if (index == Style.DEFAULT) {
      return;
    }
  }

  @Override
  protected void renderChildren() {
    int count = getItemCount();
    for (int i = 0; i < count; i++) {
      getItem(i).render(getContainer(), i);
    }
    childrenRendered = true;
  }

  protected void onClick(ComponentEvent ce) {
    treeTable.fireEvent(Events.CellClick, ce);
    treeTable.fireEvent(Events.RowClick, ce);
  }

  protected void onDoubleClick(ComponentEvent ce) {
    treeTable.fireEvent(Events.CellDoubleClick, ce);
    treeTable.fireEvent(Events.RowDoubleClick, ce);
  }

  protected void setTree(Tree tree) {
    super.setTree(tree);
    treeTable = (TreeTable) tree;
  }

}
