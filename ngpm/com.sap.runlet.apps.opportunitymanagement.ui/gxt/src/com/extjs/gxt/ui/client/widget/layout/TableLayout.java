/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.Layout;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * <code>TableLayout</code> allows you to easily render content into an HTML
 * table. The total number of columns can be specified.
 * 
 * <p />
 * Rather than explicitly creating and nesting rows and columns as you would in
 * HTML, you simply specify the total column count and start adding widgets in
 * their natural order from left to right, top to bottom. The layout will
 * automatically figure out, based on the column count how to position each
 * panel within the table.
 */
public class TableLayout extends Layout {

  protected TableElement table;
  protected Element tbody;

  protected int currentColumn;
  protected int currentRow;
  protected HorizontalAlignment cellHorizontalAlign;
  protected VerticalAlignment cellVerticalAlign;

  protected List<List<Boolean>> cells;

  int cellPadding = 0;
  int cellSpacing = 0;
  String width;
  String height;
  private boolean insertSpacer;
  private int columns = 1;
  private int border = 0;
  private String tableStyle;

  /**
   * Creates a new table layout.
   */
  public TableLayout() {

  }

  /**
   * Creates a new table layout.
   * 
   * @param columns the number of columns
   */
  public TableLayout(int columns) {
    this.setColumns(columns);
  }

  /**
   * Returns the border width.
   * 
   * @return the border width
   */
  public int getBorder() {
    return border;
  }

  /**
   * Returns the cell horizontal alignment.
   * 
   * @return the cell horizontal alignment
   */
  public HorizontalAlignment getCellHorizontalAlign() {
    return cellHorizontalAlign;
  }

  /**
   * Returns the table cell's padding.
   * 
   * @return the cell padding
   */
  public int getCellPadding() {
    return cellPadding;
  }

  /**
   * Returns the cell's vertical alignment.
   * 
   * @return the vertical alignment
   */
  public VerticalAlignment getCellVerticalAlign() {
    return cellVerticalAlign;
  }

  /**
   * Returns the number of columns.
   * 
   * @return the column count
   */
  public int getColumns() {
    return columns;
  }

  /**
   * Returns the table's height.
   * 
   * @return the table height
   */
  public String getHeight() {
    return height;
  }

  /**
   * Returns true if spacers are being inserted.
   * 
   * @return the insert spacer state
   */
  public boolean getInsertSpacer() {
    return insertSpacer;
  }

  /**
   * Returns the table style.
   * 
   * @return the table style
   */
  public String getTableStyle() {
    return tableStyle;
  }

  /**
   * Returns the table's width.
   * 
   * @return the table width
   */
  public String getWidth() {
    return width;
  }

  /**
   * Sets the table's border property (defaults to 0).
   * 
   * @param border the border
   */
  public void setBorder(int border) {
    this.border = border;
  }

  /**
   * Sets the cell's horizontal alignment. If specifed, the value will be
   * applied to all cell's without a horizontal alignment specified.
   * 
   * @param cellHorizontalAlign the horizontal alignment
   */
  public void setCellHorizontalAlign(HorizontalAlignment cellHorizontalAlign) {
    this.cellHorizontalAlign = cellHorizontalAlign;
  }

  /**
   * Sets the amount that will be applied to each table cell. This method does
   * not change the table's cellpadding attribute.
   * 
   * @param padding the cell padding
   */
  public void setCellPadding(int padding) {
    this.cellPadding = padding;
  }

  /**
   * Sets the table's cell spacing.
   * 
   * @param spacing the cell spacing
   */
  public void setCellSpacing(int spacing) {
    this.cellSpacing = spacing;
    if (table != null) {
      table.setCellSpacing(spacing);
    }
  }

  /**
   * Sets the cell's vertical alignment. If specified, the value will be applied
   * to all cell's without a horizontal alignment specified.
   * 
   * @param cellVerticalAlign the vertical alignment
   */
  public void setCellVerticalAlign(VerticalAlignment cellVerticalAlign) {
    this.cellVerticalAlign = cellVerticalAlign;
  }

  /**
   * Sets the number of columns (defaults to 1).
   * 
   * @param columns the number of columns
   */
  public void setColumns(int columns) {
    this.columns = columns;
  }

  /**
   * Sets the table's height.
   * 
   * @param height the table height
   */
  public void setHeight(String height) {
    this.height = height;
  }

  /**
   * True to insert a spacer cell into each row with 100% width so that all
   * other cells are right aligned (defaults to false).
   * 
   * @param insertSpacer true to add a spacer
   */
  public void setInsertSpacer(boolean insertSpacer) {
    this.insertSpacer = insertSpacer;
  }

  /**
   * Custom CSS styles to be applied to the table in the format expected by
   * {@link El#applyStyles}.
   * 
   * @param tableStyle the table style
   */
  public void setTableStyle(String tableStyle) {
    this.tableStyle = tableStyle;
  }

  /**
   * Sets the table's width.
   * 
   * @param width the table width
   */
  public void setWidth(String width) {
    this.width = width;
  }

  protected Element getNextCell(Component widget) {
    if (cells == null) {
      cells = new ArrayList<List<Boolean>>();
    }

    TableData data = (TableData) getLayoutData(widget);
    if (data == null) {
      data = new TableData();
      setLayoutData(widget, data);
    }

    TableCellElement td = DOM.createTD().cast();
    td.setClassName("x-table-layout-cell");
    int[] cell = getNextNonSpan(currentColumn, currentRow);
    int curCol = currentColumn = cell[0];
    int curRow = currentRow = cell[1];
    setupList(curRow);
    for (int rowIndex = curRow; rowIndex < curRow
        + (data.getRowspan() != -1 ? data.getRowspan() : 1); rowIndex++) {
      setupList(rowIndex);
      for (int colIndex = curCol; colIndex < curCol
          + (data.getColspan() != -1 ? data.getColspan() : 1); colIndex++) {
        cells.get(rowIndex).set(colIndex, true);
      }
    }

    if (data.getColspan() != 1) {
      td.setColSpan(data.getColspan());
    }

    if (data.getRowspan() != 1) {
      td.setRowSpan(data.getRowspan());
    }

    if (data.getPadding() > 0) {
      td.getStyle().setPropertyPx("padding", data.getPadding());
    } else if (cellPadding > 0) {
      td.getStyle().setPropertyPx("padding", cellPadding);
    }

    if (data.getStyleName() != null) {
      fly(td).addStyleName(data.getStyleName());
    }

    if (data.horizontalAlign != null) {
      td.setAlign(data.horizontalAlign.name());
    } else if (cellHorizontalAlign != null) {
      td.setAlign(cellHorizontalAlign.name());
    }

    if (data.verticalAlign != null) {
      td.setVAlign(data.verticalAlign.name());
    } else if (cellVerticalAlign != null) {
      td.setVAlign(cellVerticalAlign.name());
    }

    if (data.getHeight() != null) {
      td.setAttribute("height", data.getHeight());
    }
    if (data.getWidth() != null) {
      td.setAttribute("width", data.getWidth());
    }

    if (data.getStyle() != null) {
      fly(td).applyStyles(data.getStyle());
    }
    getRow(curRow).dom.appendChild(td);
    return td.cast();
  }

  protected int[] getNextNonSpan(int colIndex, int rowIndex) {
    setupList(rowIndex);
    while ((colIndex >= columns)
        || (cells.get(rowIndex) != null && cells.get(rowIndex).get(colIndex))) {
      if (colIndex >= columns) {
        rowIndex++;
        setupList(rowIndex);
        colIndex = 0;
      } else {
        colIndex++;
      }
    }
    return new int[] {colIndex, rowIndex};
  }

  protected void setupList(int rowIndex) {
    for (int i = cells.size(); i <= rowIndex; i++) {
      List<Boolean> l = new ArrayList<Boolean>();
      for (int j = 0; j < columns; j++) {
        l.add(false);
      }
      cells.add(l);
    }
  }

  protected El getRow(int index) {
    Element row = DOM.getChild(tbody, index);
    if (row == null) {
      row = DOM.createTR();
      DOM.appendChild(tbody, row);
    }
    return new El(row);
  }

  @Override
  protected boolean isValidParent(Element elem, Element parent) {
    return false;
  }

  @Override
  protected void onLayout(Container<?> container, El target) {
    currentColumn = 0;
    currentRow = 0;
    cells = null;
    target.removeChildren();

    table = DOM.createTable().cast();

    if (tableStyle != null) {
      El.fly((Element) table.cast()).applyStyles(tableStyle);
    }

    if (cellSpacing != -1) {
      table.setCellSpacing(cellSpacing);
    }

    if (border > 0) {
      table.setBorder(border);
    }

    if (width != null) {
      table.setWidth(width);
    }

    if (height != null) {
      table.setAttribute("height", height);
    }

    tbody = DOM.createTBody();

    table.appendChild(tbody);
    target.dom.appendChild(table);

    renderAll(container, target);
  }

  @Override
  protected void renderComponent(Component c, int index, El target) {
    Element td = getNextCell(c);
    if (c.isRendered()) {
      td.appendChild(c.getElement());
    } else {
      c.render(td);
    }

  }

}
