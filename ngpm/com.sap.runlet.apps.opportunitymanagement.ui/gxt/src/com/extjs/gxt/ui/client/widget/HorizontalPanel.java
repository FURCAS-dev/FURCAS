/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.layout.TableRowLayout;
import com.google.gwt.user.client.Element;

/**
 * A {@link LayoutContainer} that lays out its children in a single row using a
 * {@link TableRowLayout}. Each child widget can control its cell's properties
 * using an associated {@link TableData} instance.
 * 
 * <p />
 * Code snippet:
 * 
 * <pre>
   HorizontalPanel hp = new HorizontalPanel();
   hp.setWidth(300);
   hp.setTableWidth(&quot;100%&quot;);
   hp.add(new Label(&quot;Aligned Center&quot;));
   TableData td = new TableData();
   td.setHorizontalAlign(HorizontalAlignment.RIGHT);
   hp.add(new Label(&quot;Aligned Right&quot;), td);
   RootPanel.get().add(hp);
 * </pre>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>LayoutContainer AfterLayout</dd>
 * <dd>ScrollContainer Scroll</dd>
 * <dd>Container BeforeAdd</dd>
 * <dd>Container Add</dd>
 * <dd>Container BeforeRemove</dd>
 * <dd>Container Remove</dd>
 * <dd>BoxComponent Move</dd>
 * <dd>BoxComponent Resize</dd>
 * <dd>Component Enable</dd>
 * <dd>Component Disable</dd>
 * <dd>Component BeforeHide</dd>
 * <dd>Component Hide</dd>
 * <dd>Component BeforeShow</dd>
 * <dd>Component Show</dd>
 * <dd>Component Attach</dd>
 * <dd>Component Detach</dd>
 * <dd>Component BeforeRender</dd>
 * <dd>Component Render</dd>
 * <dd>Component BrowserEvent</dd>
 * <dd>Component BeforeStateRestore</dd>
 * <dd>Component StateRestore</dd>
 * <dd>Component BeforeStateSave</dd>
 * <dd>Component SaveState</dd>
 * </dl>
 */
public class HorizontalPanel extends LayoutContainer {

  private String tableWidth;
  private String tableHeight;
  private HorizontalAlignment horizontalAlign = HorizontalAlignment.LEFT;
  private VerticalAlignment verticalAlign = VerticalAlignment.TOP;
  private int spacing = 0;
  private TableRowLayout layout;

  /**
   * @return the horizontalAlign
   */
  public HorizontalAlignment getHorizontalAlign() {
    return horizontalAlign;
  }

  /**
   * Returns the table's height.
   * 
   * @return the table height
   */
  public String getTableHeight() {
    return tableHeight;
  }

  /**
   * @return the tableWidth
   */
  public String getTableWidth() {
    return tableWidth;
  }

  /**
   * Returns the panel's vertical alignment.
   * 
   * @return the vertical aignment
   */
  public VerticalAlignment getVerticalAlign() {
    return verticalAlign;
  }

  /**
   * The horizontal cell alignment (defaults to LEFT).
   * 
   * @param horizontalAlign horizontal alignment
   */
  public void setHorizontalAlign(HorizontalAlignment horizontalAlign) {
    this.horizontalAlign = horizontalAlign;
  }

  /**
   * Sets the panel's spacing.
   * 
   * @param spacing the spacing
   */
  public void setSpacing(int spacing) {
    this.spacing = spacing;
    if (layout != null) {
      layout.setCellSpacing(spacing);
    }
  }

  /**
   * Sets the table's height.
   * 
   * @param tableHeight the table height
   */
  public void setTableHeight(String tableHeight) {
    this.tableHeight = tableHeight;
  }

  /**
   * Sets the width of the internal table.
   * 
   * @param tableWidth the table width
   */
  public void setTableWidth(String tableWidth) {
    this.tableWidth = tableWidth;
  }

  /**
   * Sets the panel' vertical alignment.
   * 
   * @param verticalAlign the vertical alignment
   */
  public void setVerticalAlign(VerticalAlignment verticalAlign) {
    this.verticalAlign = verticalAlign;
  }

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    setStyleAttribute("overflow", "visible");
    layout = new TableRowLayout();
    layout.setCellHorizontalAlign(horizontalAlign);
    layout.setCellVerticalAlign(verticalAlign);
    layout.setCellSpacing(spacing);
    layout.setCellPadding(0);
    layout.setWidth(tableWidth);
    layout.setHeight(tableHeight);
    setLayout(layout);
    layout();
  }

}
