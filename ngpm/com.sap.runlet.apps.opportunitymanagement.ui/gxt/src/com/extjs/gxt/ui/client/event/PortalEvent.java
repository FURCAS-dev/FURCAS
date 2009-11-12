/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.custom.Portal;
import com.extjs.gxt.ui.client.widget.custom.Portlet;

/**
 * Portal event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 */
public class PortalEvent extends ContainerEvent<Portal, Portlet> {

  private int column;
  private Portal portal;
  private Portlet portlet;
  private int row;
  private int startColumn;
  private int startRow;

  public PortalEvent(Portal portal) {
    super(portal);
    this.portal = portal;
  }

  public PortalEvent(Portal portal, Portlet portlet) {
    super(portal, portlet);
    this.portal = portal;
    this.portlet = portlet;
  }

  public PortalEvent(Portal portal, Portlet portlet, int startColumn, int startRow,
      int column, int row) {
    this(portal, portlet);
    this.startColumn = startColumn;
    this.startRow = startRow;
    this.column = column;
    this.row = row;
  }

  /**
   * Returns the column index.
   * 
   * @return the column index
   */
  public int getColumn() {
    return column;
  }

  /**
   * Returns the source portal.
   * 
   * @return the source portal
   */
  public Portal getPortal() {
    return portal;
  }

  /**
   * Returns the portlet.
   * 
   * @return the portlet
   */
  public Portlet getPortlet() {
    return portlet;
  }

  /**
   * Returns the row.
   * 
   * @return the row
   */
  public int getRow() {
    return row;
  }

  /**
   * Returns the start column.
   * 
   * @return the start column
   */
  public int getStartColumn() {
    return startColumn;
  }

  /**
   * Returns the start row.
   * 
   * @return the start row
   */
  public int getStartRow() {
    return startRow;
  }

  /**
   * Sets the column index.
   * 
   * @param column the column index
   */
  public void setColumn(int column) {
    this.column = column;
  }

  /**
   * Sets the source portal.
   * 
   * @param portal the portal
   */
  public void setPortal(Portal portal) {
    this.portal = portal;
  }

  /**
   * Sets the portlet.
   * 
   * @param portlet the portlet
   */
  public void setPortlet(Portlet portlet) {
    this.portlet = portlet;
  }

  /**
   * Sets the row.
   * 
   * @param row the row
   */
  public void setRow(int row) {
    this.row = row;
  }

  /**
   * Sets the start column.
   * 
   * @param startColumn the start column
   */
  public void setStartColumn(int startColumn) {
    this.startColumn = startColumn;
  }

  /**
   * Sets the start row.
   * 
   * @param startRow the start row
   */
  public void setStartRow(int startRow) {
    this.startRow = startRow;
  }

}
