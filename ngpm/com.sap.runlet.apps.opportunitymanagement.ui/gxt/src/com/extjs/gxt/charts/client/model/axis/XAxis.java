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
 * OFC x-axis.
 */
public class XAxis extends AbstractAxis {

  /**
   * Class for an OFC x-axis label.
   */
  public class XLabels extends Label {
    /**
     * Creates a new labels.
     * 
     * @param list the labels
     */
    public XLabels(List<String> list) {
      Collection<Object> labels = checkLabels();
      labels.addAll(list);
    }

    /**
     * Creates a new labels.
     * 
     * @param labels the labels
     */
    public XLabels(String... labels) {
      addLabels(labels);
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
    public void addLabels(String... list) {
      Collection<Object> labels = checkLabels();
      labels.addAll(Arrays.asList(list));
    }

    /**
     * Returns the colour.
     * 
     * @return the colour
     */
    public String getColour() {
      return (String)get("colour");
    }

    /**
     * Returns the labels.
     * 
     * @return the labels
     */
    @SuppressWarnings("unchecked")
    public Collection<Object> getLabels() {
      return (Collection)get("labels");
    }

    /**
     * Returns the rotation.
     * 
     * @return the rotation
     */
    public Rotation getRotation() {
      return (Rotation)get("rotate");
    }

    /**
     * Returns the size.
     * 
     * @return the size
     */
    public int getSize() {
      return (Integer)get("size");
    }

    /**
     * Returns the steps.
     * 
     * @return the steps
     */
    public int getSteps() {
      return (Integer)get("steps");
    }

    /**
     * Returns the visible state.
     * 
     * @return true if visible
     */
    public boolean isVisible() {
      return (Boolean)get("visible");
    }

    /**
     * Sets the colour in HTML hex format (#ffffff).
     * 
     * @param colour the colour
     */
    public void setColour(String colour) {
      set("colour", colour);
    }

    /**
     * Sets the rotation.
     * 
     * @param rotate the rotate
     */
    public void setRotation(Rotation rotate) {
      set("rotate", rotate);
    }

    /**
     * Sets the size.
     * 
     * @param size the size
     */
    public void setSize(int size) {
      set("size", size);
    }

    /**
     * Sets the steps.
     * 
     * @param steps the new steps
     */
    public void setSteps(int steps) {
      set("steps", steps);
    }

    /**
     * Sets the visible state.
     * 
     * @param visible true for visible
     */
    public void setVisible(boolean visible) {
      set("visible", visible);
    }

    protected Collection<Object> checkLabels() {
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
  public void addLabels(Label... labels) {
    checkXLabels().addLabels(labels);
  }

  /**
   * Adds the labels.
   * 
   * @param labels the labels
   */
  public void addLabels(List<Label> labels) {
    checkXLabels().addLabels(labels);
  }

  /**
   * Adds the labels.
   * 
   * @param labels the labels
   */
  public void addLabels(String... labels) {
    checkXLabels().addLabels(labels);
  }

  /**
   * Returns the labels.
   * 
   * @return the labels
   */
  public XLabels getLabels() {
    return checkXLabels();
  }

  /**
   * Returns the tick height.
   * 
   * @return the tick height
   */
  public Integer getTickHeight() {
    return (Integer)get("tick-height");
  }

  /**
   * Sets the labels.
   * 
   * @param labels the new labels
   */
  public void setLabels(List<String> labels) {
    set("labels", new XLabels(labels));
  }

  /**
   * Sets the labels.
   * 
   * @param labels the new labels
   */
  public void setLabels(String... labels) {
    set("labels", new XLabels(labels));
  }

  /**
   * Sets the x axis labels.
   * 
   * @param labels the new x axis labels
   */
  public void setLabels(XLabels labels) {
    set("labels", labels);
  }

  /**
   * Sets the tick height.
   * 
   * @param tickHeight the new tick height
   */
  public void setTickHeight(Integer tickHeight) {
    set("tick-height", tickHeight);
  }

  private XLabels checkXLabels() {
    XLabels labels = get("labels");
    if (labels == null) {
      labels = new XLabels();
      set("labels", labels);
    }
    return labels;
  }
}
