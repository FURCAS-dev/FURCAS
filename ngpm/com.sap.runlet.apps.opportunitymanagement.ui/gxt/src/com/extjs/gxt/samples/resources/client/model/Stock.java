/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.resources.client.model;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Stock extends BaseModel {

  public Stock() {
  }

  public Stock(String name, String symbol, double open, double last) {
    set("name", name);
    set("symbol", symbol);
    set("open", open);
    set("last", last);
    set("date", new Date());
    set("change", last - open);
  }

  public Stock(String name, double open, double change, double pctChange, Date date, String industry) {
    set("name", name);
    set("open", open);
    set("change", change);
    set("percentChange", pctChange);
    set("date", date);
    set("industry", industry);
  }

  public String getIndustry() {
    return get("industry");
  }

  public void setIndustry(String industry) {
    set("industry", industry);
  }

  public Date getLastTrans() {
    return (Date) get("date");
  }

  public String getName() {
    return (String) get("name");
  }

  public String getSymbol() {
    return (String) get("symbol");
  }

  public double getOpen() {
    Double open = (Double) get("open");
    return open.doubleValue();
  }

  public double getLast() {
    Double open = (Double) get("last");
    return open.doubleValue();
  }

  public double getChange() {
    return getLast() - getOpen();
  }

  public double getPercentChange() {
    return getChange() / getOpen();
  }

  public String toString() {
    return getName();
  }

}
