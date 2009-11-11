/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.axis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * OFC y-axis.
 */
public class YAxis extends AbstractAxis {

  /**
   * Adds the labels.
   * 
   * @param list the labels
   */
  public void addLabels(List<String> list) {
    Collection<String> labels = checkLabels();
    labels.addAll(list);
  }
  /**
   * Adds the labels.
   * 
   * @param list the labels
   */
  public void addLabels(String... list) {
    Collection<String> labels = checkLabels();
    labels.addAll(Arrays.asList(list));
  }

  /**
   * Returns the labels.
   * 
   * @return the labels
   */
  public Collection<String> getLabels() {
    return checkLabels();
  }

  /**
   * Returns the tick length.
   * 
   * @return the tick length
   */
  public Integer getTickLength() {
    return (Integer)get("tick-length");
  }

  /**
   * Sets the labels.
   * 
   * @param list the new labels
   */
  public void setLabels(List<String> list) {
    Collection<String> labels = checkLabels();
    labels.clear();
    labels.addAll(list);
  }

  /**
   * Sets the labels.
   * 
   * @param labels the new labels
   */
  public void setLabels(String... labels) {
    setLabels(Arrays.asList(labels));
  }

  /**
   * Sets the tick length.
   * 
   * @param tickLength the new tick length
   */
  public void setTickLength(Integer tickLength) {
    set("tick-length", tickLength);
  }

  private Collection<String> checkLabels() {
    Collection<String> labels = get("labels");
    if (labels == null) {
      labels = new ArrayList<String>();
      set("labels", labels);
    }
    return labels;
  }
}
