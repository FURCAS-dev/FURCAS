/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treetable;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.TreeEvent;
import com.extjs.gxt.ui.client.util.Markup;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.tree.DefaultTreeItemUI;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * @deprecated see @link {@link TreeGrid}
 */
public class TreeTableItemUI extends DefaultTreeItemUI {

  boolean hovering;

  private Element tableItemEl;
  private Element rowTableEl;
  private Element rowTrEl;
  private Element[] cells;

  public TreeTableItemUI(TreeTableItem item) {
    bind(item);
    styleTreeOver = "my-treetbl-over";
    styleTreeChecked = "my-treetbl-checked";
    styleTreeNotChecked = "my-treetbl-notchecked";
    styleTreeLoading = "my-treetbl-loading";
    classTreeOpen = "my-treetbl-open";
    classTreeClose = "my-treetbl-close";
  }

  public TreeTableItem getTreeTableItem() {
    return (TreeTableItem) item;
  }

  @Override
  public void handleEvent(TreeEvent e) {
    TreeTableItem item = (TreeTableItem) e.getItem();
    Element target = e.getTarget();
    int type = e.getEventTypeInt();
    switch (type) {
      case Event.ONMOUSEOVER:
      case Event.ONMOUSEOUT:
        handleMouseEvent(e);
        break;
      case Event.ONCLICK:
      case Event.ONDBLCLICK:
        if (DOM.isOrHasChild(checkEl, target)) {
          e.stopEvent();
          item.setChecked(!item.isChecked());
        } else {
          handleClickEvent(e);
        }
        return;
    }
  }

  @Override
  public boolean isSelectableTarget(Element target) {
    if (DOM.isOrHasChild(jointEl, target)) {
      return false;
    }
    return true;
  }

  public void onMouseOut(BaseEvent be) {
    if (!item.isRoot()) {
      El.fly(tableItemEl).removeStyleName("my-treetbl-item-over");
    }
  }

  public void onMouseOver(BaseEvent be) {
    if (!item.isRoot()) {
      El.fly(tableItemEl).addStyleName("my-treetbl-item-over");
    }
  }
  
  @Override
  public void onSelectedChange(boolean selected) {
    if (item.isRendered()) {
      El.fly(tableItemEl).setStyleName("my-treetbl-item-sel", selected);
      if (!selected) {
        onMouseOut(null);
      }
    }
  }

  @Override
  public void onTextChange(String text) {
    if (!item.isRoot()) {
      textSpanEl.setInnerHTML(text);
    }
  }

  public void render(Element target, int index) {
    if (item.isRoot() == true) {
      return;
    }

    item.setTreeTableElement(DOM.createDiv());
    item.setStyleName("my-treeitem x-tree-item");
    DOM.insertChild(target, item.getElement(), index);

    TableColumnModel cm = getTreeTableItem().getTreeTable().getColumnModel();

    DOM.setInnerHTML(item.getElement(), Markup.TREETABLE_ITEM);
    tableItemEl = item.el().firstChild().dom;

    rowTableEl = DOM.getFirstChild(tableItemEl);
    rowTrEl = fly(rowTableEl).getSubChild(2);
    updateCellValues(0, DOM.getFirstChild(rowTrEl), cm.getColumn(0).getAlignment());
    itemEl = fly(rowTrEl).getSubChild(4);
    Element td = fly(itemEl).subChild(3).dom;
    indentEl = DOM.getFirstChild(td);
    jointEl = DOM.getNextSibling(td);
    jointDivEl = DOM.getFirstChild(jointEl);
    checkEl = DOM.getNextSibling(DOM.getNextSibling(jointEl));
    checkDivEl = DOM.getFirstChild(checkEl);
    iconEl = DOM.getNextSibling(checkEl);
    iconDivEl = DOM.getFirstChild(iconEl);
    textEl = DOM.getNextSibling(iconEl);
    textSpanEl = DOM.getFirstChild(textEl);
    Element tbl = DOM.getFirstChild(item.getElement());
    containerEl = new El(DOM.getNextSibling(tbl));

    int numColumns = cm.getColumnCount();
    cells = new Element[numColumns];

    for (int i = 1; i < numColumns; i++) {
      cells[i] = DOM.createTD();
      DOM.appendChild(rowTrEl, cells[i]);

      DOM.setElementProperty(cells[i], "className", "my-treetbl-cell");
      DOM.setElementAttribute(cells[i], "index", String.valueOf(i));

      Element overflowDiv = DOM.createDiv();
      DOM.setElementProperty(overflowDiv, "className", "my-treetbl-cell-overflow");
      DOM.appendChild(cells[i], overflowDiv);
      Element textDiv = DOM.createDiv();

      String textStyle = "my-treetbl-cell-text";
      if (((TreeTableItem) item).getCellStyle(i) != null) {
        textStyle += " " + ((TreeTableItem) item).getCellStyle(i);
      }
      DOM.setElementProperty(textDiv, "className", textStyle);
      DOM.appendChild(overflowDiv, textDiv);
      updateCellValues(i, cells[i], cm.getColumn(i).getAlignment());
    }

    boolean checkable = getTreeTableItem().getTreeTable().getCheckable();
    El.fly(checkEl).setVisible(checkable);

    onValuesChanged(getTreeTableItem().getTreeTable(),
        getTreeTableItem().getRenderedValues());

    item.updateIconStyle();
    item.updateJointStyle();

    if (item.isChecked()) {
      onCheckChange(true);
    }

    El.fly(indentEl).setWidth(item.getIndent());

    item.updateJointStyle();
    item.disableTextSelection(true);

  }

  public void setContainer(Element container) {
    containerEl = new El(container);
  }

  protected Element getTextCellElement(int column) {
    if (column == 0) {
      return textSpanEl;
    } else {
      return El.fly(cells[column]).getSubChild(2);
    }
  }

  @Override
  protected void handleMouseEvent(TreeEvent ce) {
    if(ce.getEvent().getTypeInt() == Event.ONMOUSEOVER) {
      if (!hovering) {
        hovering = true;
        onMouseOver(ce);
      }
    } else {
      hovering = false;
      onMouseOut(ce);
    }

  }

  protected void onValuesChanged(TreeTable table, String[] values) {
    onTextChange(values[0] != null ? values[0] : item.getText());
    for (int i = 1; i < cells.length; i++) {
      updateText(i, values[i]);
    }
  }

  protected void updateCellValues(int col, Element cell, HorizontalAlignment align) {
    String salign = "left";
    if (align == HorizontalAlignment.CENTER) {
      salign = "center";
    } else if (align == HorizontalAlignment.RIGHT) {
      salign = "right";
    }

    String widthClassName = ((TreeTableItem) item).treeTable.getId() + "-col-" + col;

    String className = cell.getClassName();
    className = (className == null) ? widthClassName : className + " " + widthClassName;
    cell.setClassName(className);

    className = DOM.getElementProperty(DOM.getFirstChild(cell), "className");
    className = (className == null) ? widthClassName : className + " " + widthClassName;
    DOM.setElementProperty(DOM.getFirstChild(cell), "className", className);

    El.fly(cell).subChild(2).setStyleAttribute("textAlign", salign);
  }

  protected void updateText(int column, String value) {
    Element textElem = getTextCellElement(column);
    if (textElem != null) {
      textElem.setInnerHTML(value);
    }
  }
}
