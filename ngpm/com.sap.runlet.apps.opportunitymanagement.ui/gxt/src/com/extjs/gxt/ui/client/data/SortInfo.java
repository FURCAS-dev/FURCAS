/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.io.Serializable;

import com.extjs.gxt.ui.client.Style.SortDir;

/**
 * Aggregates sort field and sort direction.
 */
public class SortInfo implements Serializable {

  private String sortField;
  private SortDir sortDir = SortDir.NONE;

  /**
   * Creates a new sort field instance.
   */
  public SortInfo() {

  }

  /**
   * Creates a new sort info instance.
   * 
   * @param field the sort field
   * @param sortDir the sort direction
   */
  public SortInfo(String field, SortDir sortDir) {
    this.sortField = field;
    this.sortDir = sortDir;
  }

  /**
   * Returns the sort field.
   * 
   * @return the sort field
   */
  public String getSortField() {
    return sortField;
  }

  /**
   * Sets the sort field.
   * 
   * @param sortField the sort field
   */
  public void setSortField(String sortField) {
    this.sortField = sortField;
  }

  /**
   * Returns the sort direction.
   * 
   * @return the sort direction
   */
  public SortDir getSortDir() {
    return sortDir;
  }

  /**
   * Sets the sort direction.
   * 
   * @param sortDir the sort direction
   */
  public void setSortDir(SortDir sortDir) {
    this.sortDir = sortDir;
  }

}
