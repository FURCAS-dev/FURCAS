/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;

/**
 * A column config for a column in a column model.
 * 
 * <p />
 * The column config is a configuration object that should only be used when
 * creating a column model. After the column model is created, any changes
 * should be made to the column model, not the column config.
 */
public class ColumnConfig extends BaseObservable {

  private GridCellRenderer<ModelData> renderer;
  private HorizontalAlignment alignment;
  private String toolTip;
  private String style;
  private String dataIndex;
  private String header;
  private boolean sortable = true;
  private boolean fixed;
  private boolean resizable = true;
  private boolean menuDisabled;
  private boolean hidden;
  private int width;
  private String id;
  private CellEditor editor;
  private NumberFormat numberFormat;
  private DateTimeFormat dateTimeFormat;
  private boolean groupable = true;

  /**
   * Creates a new column config.
   */
  public ColumnConfig() {

  }

  /**
   * Creates a new column config.
   * 
   * @param id the column id
   * @param width the column width
   */
  public ColumnConfig(String id, int width) {
    this.id = id;
    this.width = width;
  }

  /**
   * Creates a new column config.
   * 
   * @param id the column id
   * @param name the column name
   * @param width the column width
   */
  public ColumnConfig(String id, String name, int width) {
    this.id = id;
    this.width = width;
    this.header = name;
  }

  /**
   * Returns the column's horizontal alignment.
   * 
   * @return the horizontal alignment
   */
  public HorizontalAlignment getAlignment() {
    return alignment;
  }

  /**
   * Returns the column's data index.
   * 
   * @return the data index
   */
  public String getDataIndex() {
    if (dataIndex == null) {
      return id;
    }
    return dataIndex;
  }

  /**
   * Returns the column's data time format.
   * 
   * @return the date time format
   */
  public DateTimeFormat getDateTimeFormat() {
    return dateTimeFormat;
  }

  /**
   * Returns the column's cell editor.
   * 
   * @return the editor
   */
  public CellEditor getEditor() {
    return editor;
  }

  /**
   * Returns the column's header text.
   * 
   * @return the header text
   */
  public String getHeader() {
    return header;
  }

  /**
   * Returns the column's id.
   * 
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Returns the column's number format.
   * 
   * @return the number format
   */
  public NumberFormat getNumberFormat() {
    return numberFormat;
  }

  /**
   * Returns the column's cell renderer.
   * 
   * @return the renderer
   */
  public GridCellRenderer<ModelData> getRenderer() {
    return renderer;
  }

  /**
   * Returns the column style.
   * 
   * @return the style
   */
  public String getStyle() {
    return style;
  }

  /**
   * Returns the column's tool tip.
   * 
   * @return the tool tip
   */
  public String getToolTip() {
    return toolTip;
  }

  /**
   * Returns the column's width.
   * 
   * @return the column width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Returns true if the column size is fixed.
   * 
   * @return the fixed state
   */
  public boolean isFixed() {
    return fixed;
  }

  /**
   * Returns true if the column can be grouped.
   * 
   * @return true if groupable
   */
  public boolean isGroupable() {
    return groupable;
  }

  /**
   * Returns true if the column is hidden.
   * 
   * @return the hidden state
   */
  public boolean isHidden() {
    return hidden;
  }

  /**
   * Returns true if the column's menu is disabled.
   * 
   * @return the menu disabled state
   */
  public boolean isMenuDisabled() {
    return menuDisabled;
  }

  /**
   * Returns true if the column is resizable.
   * 
   * @return the resizable state
   */
  public boolean isResizable() {
    return resizable;
  }

  /**
   * Returns <code>true</code> if the column is sortable (pre-render).
   * 
   * @return the sortable state
   */
  public boolean isSortable() {
    return sortable;
  }

  /**
   * Sets the column's horizontal alignment.
   * 
   * @param alignment the alignment
   */
  public void setAlignment(HorizontalAlignment alignment) {
    this.alignment = alignment;
  }

  /**
   * Sets the column's data index.
   * 
   * @param dataIndex the data index
   */
  public void setDataIndex(String dataIndex) {
    this.dataIndex = dataIndex;
  }

  /**
   * Sets the column's date time format.
   * 
   * @param dateTimeFormat the date time format
   */
  public void setDateTimeFormat(DateTimeFormat dateTimeFormat) {
    this.dateTimeFormat = dateTimeFormat;
  }

  /**
   * Sets the column's cell editor.
   * 
   * @param editor the cell editor
   */
  public void setEditor(CellEditor editor) {
    this.editor = editor;
  }

  /**
   * True if the column width cannot be changed (defaults to false, pre-render).
   * 
   * @param fixed true for fixed column width
   */
  public void setFixed(boolean fixed) {
    this.fixed = fixed;
  }

  /**
   * Sets if the column is groupable (defaults to true). Only applies when using
   * a GroupingView.
   * 
   * @param groupable true to allow grouping
   */
  public void setGroupable(boolean groupable) {
    this.groupable = groupable;
  }

  /**
   * Sets the column's header text.
   * 
   * @param header the header text
   */
  public void setHeader(String header) {
    this.header = header;
  }

  /**
   * Sets whether the column is hidden.
   * 
   * @param hidden true to hide
   */
  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }

  /**
   * Sets the column's id.
   * 
   * @param id the column id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets whether the column's menu is disabled (pre-render).
   * 
   * @param menuDisabled true to disable the menu
   */
  public void setMenuDisabled(boolean menuDisabled) {
    this.menuDisabled = menuDisabled;
  }

  /**
   * Sets the column's number format.
   * 
   * @param format the number format
   */
  public void setNumberFormat(NumberFormat format) {
    this.numberFormat = format;
  }

  /**
   * Sets the column's cell renderer (pre-render).
   * 
   * @param renderer the cell renderer
   */
  @SuppressWarnings("unchecked")
  public void setRenderer(GridCellRenderer renderer) {
    this.renderer = renderer;
  }

  /**
   * Specifies if the column may be resized (defaults to true, pre-render).
   * 
   * @param resizable the resizable state
   */
  public void setResizable(boolean resizable) {
    this.resizable = resizable;
  }

  /**
   * Sets if the column can be sorted (defaults to true, pre-render).
   * 
   * @param sortable the sortable state
   */
  public void setSortable(boolean sortable) {
    this.sortable = sortable;
  }

  /**
   * Sets one to many styles.
   * 
   * <pre>
   * &lt;code&gt;
   *        setStyle(&quot;color:red;font-weight: bold&quot;);
   * &lt;/code&gt;
   * </pre>
   * 
   * @param style the style
   */
  public void setStyle(String style) {
    this.style = style;
  }

  /**
   * Sets the column's tool tip.
   * 
   * @param toolTip the tool tip
   */
  public void setToolTip(String toolTip) {
    this.toolTip = toolTip;
  }

  /**
   * Sets the column's width in pixels.
   * 
   * @param width the width
   */
  public void setWidth(int width) {
    this.width = width;
  }
}
