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

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * OFC radar axis.
 */
public class RadarAxis extends AbstractAxis {

  /**
   * OFC radar axis label.
   */
  public class RadarLabels extends BaseModel {
   
    /**
     * Creates a new labels.
     * 
     * @param labels the labels
     */
    public RadarLabels(List<String> labels) {
      addStrings(labels);
    }

    /**
     * Creates a new labels.
     * 
     * @param labels the labels
     */
    public RadarLabels(String... labels) {
      addStrings(labels);
    }

    /**
     * Adds the labels.
     * 
     * @param list the labels
     */
    public void addLabels(Label... list) {
      Collection<Object> labels = checkLabels();
      labels.addAll(Arrays.asList(list));
    }

    /**
     * Adds the labels.
     * 
     * @param list the labels
     */
    public void addLabels(List<Label> list) {
      Collection<Object> labels = checkLabels();
      labels.addAll(list);
    }

    /**
     * Adds the labels.
     * 
     * @param list the labels
     */
    public void addStrings(List<String> list) {
      Collection<Object> labels = checkLabels();
      labels.addAll(list);
    }

    /**
     * Adds the labels.
     * 
     * @param list the labels
     */
    public void addStrings(String... list) {
      Collection<Object> labels = checkLabels();
      labels.addAll(Arrays.asList(list));
    }

    /**
     * Returns the colour.
     * 
     * @return the colour
     */
    public String getColour() {
      return get("colour");
    }

    /**
     * Returns the labels.
     * 
     * @return the labels
     */
    public Collection<?> getLabels() {
      return checkLabels();
    }

    /**
     * Sets the colour in HTML hex format (#ffffff)
     * 
     * @param colour the new colour
     */
    public void setColour(String colour) {
      set("colour", colour);
    }

    private Collection<Object> checkLabels() {
      Collection<Object> labels = get("labels");
      if (labels == null) {
        labels = new ArrayList<Object>();
        set("labels", labels);
      }
      return labels;
    }
  }

  /**
   * Adds the labels.
   * 
   * @param labels the labels
   */
  public void addLabels(String... labels) {
    checkRadarLabels().addStrings(labels);
  }

  /**
   * Adds the spoke labels.
   * 
   * @param labels the labels
   */
  public void addSpokeLabels(String... labels) {
    checkSpokeRadarLabels().addStrings(labels);
  }
  
  /**
   * Returns the labels.
   * 
   * @return the labels
   */
  public RadarLabels getLabels() {
    return (RadarLabels)get("labels");
  }

  /**
   * Returns the spoke labels.
   * 
   * @return the labels
   */
  public RadarLabels getSpokeLabels() {
    return (RadarLabels)get("spoke-labels");
  }

  /**
   * Sets the labels.
   * 
   * @param labels the new labels
   */
  public void setLabels(List<String> labels) {
    set("labels", new RadarLabels(labels));
  }

  /**
   * Sets the labels.
   * 
   * @param labels the new radar labels
   */
  public void setLabels(RadarLabels labels) {
    set("labels", labels);
  }

  /**
   * Sets the labels.
   * 
   * @param labels the new labels
   */
  public void setLabels(String... labels) {
    set("labels", new RadarLabels(labels));
  }

  /**
   * Sets the spoke labels.
   * 
   * @param labels the new spoke labels
   */
  public void setSpokeLabels(List<String> labels) {
    set("spoke-labels", new RadarLabels(labels));
  }

  /**
   * Sets the radar axis spoke labels.
   * 
   * @param labels the new radar axis spoke labels
   */
  public void setSpokeLabels(RadarLabels labels) {
    set("spoke-labels", labels);
  }

  /**
   * Sets the spoke labels.
   * 
   * @param labels the new spoke labels
   */
  public void setSpokeLabels(String... labels) {
    set("spoke-labels", new RadarLabels(labels));
  }

  private RadarLabels checkRadarLabels() {
    RadarLabels labels = get("labels");
    if (labels == null) {
      labels = new RadarLabels();
      set("labels", labels);
    }
    return labels;
  }

  private RadarLabels checkSpokeRadarLabels() {
    RadarLabels labels = get("spoke-labels");
    if (labels == null) {
      labels = new RadarLabels();
      set("spoke-labels", labels);
    }
    return labels;
  }
}
