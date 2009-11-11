/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.extjs.gxt.charts.client.model.PieDataProvider;

/**
 * OFC Pie Chart.
 */
public class PieChart extends ChartConfig {

  public static class Slice extends DataConfig {

    /**
     * Creates a new slice.
     * 
     * @param value the value
     * @param label the label
     */
    public Slice(Number value, String label) {
      this(value, label, null);
    }

    /**
     * Creates a new slice.
     * 
     * @param value the value
     * @param label the label
     * @param text the text
     */
    public Slice(Number value, String label, String text) {
      super(value);
      setValue(value);
      if (label != null) setLabel(label);
      if (text != null) setText(text);
    }

    /**
     * Returns the font size.
     * 
     * @return the font size
     */
    public String getFontSize() {
      return get("font-size");
    }

    /**
     * Returns the text.
     * 
     * @return the text
     */
    public String getLabel() {
      return get("label");
    }

    /**
     * Returns the label colour.
     * 
     * @return the label colour
     */
    public String getLabelColour() {
      return get("label-colour");
    }

    /**
     * Returns the text.
     * 
     * @return the text
     */
    public String getText() {
      return get("text");
    }

    /**
     * Returns the value.
     * 
     * @return the value
     */
    public Number getValue() {
      return (Number) get("value");
    }

    /**
     * Sets the font size.
     * 
     * @param fontSize the new font size
     */
    public void setFontSize(String fontSize) {
      set("font-size", fontSize);
    }

    /**
     * Sets the label.
     * 
     * @param label the label
     */
    public void setLabel(String label) {
      set("label", label);
    }

    /**
     * Sets the label colour.
     * 
     * @param labelColour the new label colour
     */
    public void setLabelColour(String labelColour) {
      set("label-colour", labelColour);
    }

    /**
     * Sets the text.
     * 
     * @param text the text
     */
    public void setText(String text) {
      set("text", text);
    }

    /**
     * Sets the value.
     * 
     * @param value the value
     */
    public void setValue(Number value) {
      set("value", value);
    }

    @Override
    protected Number getFirstValue() {
      return getValue();
    }

  }

  /**
   * Creates a new pie chart.
   */
  public PieChart() {
    super("pie");
  }

  /**
   * Adds a slice.
   * 
   * @param value the value
   * @param text the text
   */
  public void addSlice(Number value, String text) {
    addSlices(new Slice(value, text));
  }

  /**
   * Adds slices.
   * 
   * @param slices the slices
   */
  public void addSlices(List<Slice> slices) {
    getValues().addAll(slices);
  }

  /**
   * Adds slices.
   * 
   * @param slice the slice
   */
  public void addSlices(Slice... slice) {
    getValues().addAll(Arrays.asList(slice));
  }

  /**
   * Adds the values.
   * 
   * @param values the values
   */
  public void addValues(List<Number> values) {
    for (Number n : values) {
      addSlices(new Slice(n, ""));
    }
  }

  /**
   * Adds the values.
   * 
   * @param values the values
   */
  public void addValues(Number... values) {
    for (Number n : values) {
      addSlices(new Slice(n, ""));
    }
  }

  /**
   * Returns the alpha.
   * 
   * @return the alpha
   */
  public float getAlpha() {
    return (Float) get("alpha");
  }

  /**
   * Returns the border.
   * 
   * @return the border
   */
  public int getBorder() {
    return (Integer) get("border");
  }

  /**
   * Returns the colours.
   * 
   * @return the colours
   */
  public Collection<String> getColours() {
    return checkColours();
  }

  /**
   * Returns the radius.
   * 
   * @return the radius
   */
  public Integer getRadius() {
    return (Integer) get("radius");
  }

  /**
   * Returns the start angle.
   * 
   * @return the start angle
   */
  public Integer getStartAngle() {
    return (Integer) get("start-angle");
  }

  /**
   * Returns true if slice alpha highlighting is enabled, otherwise slice
   * animates.
   * 
   * @return true if alpha highlight is enabled
   */
  public boolean isAlphaHighlightEnabled() {
    String h = (String) get("highlight");
    if (h != null) return h.equals("alpha");
    return false;
  }

  /**
   * Returns true if the pie has animation enabled
   * 
   * @return true if animations are enabled.
   */
  public boolean isAnimationEnabled() {
    return (Boolean) get("animate");
  }

  /**
   * Returns true if pie slices are to be gradient filled.
   * 
   * @return true if gradient fill is enabled
   */
  public boolean isGradientFillEnabled() {
    return (Boolean) get("gradient-fill");
  }

  /**
   * Returns true if pie slices are not to have labels.
   * 
   * @return true if no labels is enabled
   */
  public boolean isNoLabelsEnabled() {
    return (Boolean) get("no-labels");
  }

  /**
   * Sets the alpha.
   * 
   * @param alpha the alpha
   */
  public void setAlpha(Float alpha) {
    set("alpha", alpha);
  }

  /**
   * Sets alpha colour toggle as the highlight, or slice slide out animation.
   * 
   * @param alphaHighlight true or false
   */
  public void setAlphaHighlight(boolean alphaHighlight) {
    if (alphaHighlight) {
      set("highlight", "alpha");
    } else {
      remove("highlight");
    }
  }

  /**
   * Sets if animation of slice rotation build is enabled.
   * 
   * @param animate true or false
   */
  public void setAnimate(boolean animate) {
    set("animate", animate);
  }

  /**
   * Sets the border.
   * 
   * @param border the new border
   */
  public void setBorder(int border) {
    set("border", border);
  }

  /**
   * Sets colours in HTML hex format (#ffffff)
   * 
   * @param colours the new colours
   */
  public void setColours(Collection<String> colours) {
    set("colours", colours);
  }

  /**
   * Sets colours in HTML hex format (#ffffff)
   * 
   * @param list the new colours
   */
  public void setColours(String... list) {
    set("colours", Arrays.asList(list));
  }

  /**
   * Sets the charts data provider.
   * 
   * @param dataProvider the data provider
   */
  public void setDataProvider(PieDataProvider dataProvider) {
    super.setDataProvider(dataProvider);
  }

  /**
   * Sets the gradient fill.
   * 
   * @param gradientFill true or false
   */
  public void setGradientFill(boolean gradientFill) {
    set("gradient-fill", gradientFill);
  }

  /**
   * True to hide labels.
   * 
   * @param nolabels true to hide labels
   */
  public void setNoLabels(boolean nolabels) {
    set("no-labels", nolabels);
  }

  /**
   * Sets the radius.
   * 
   * @param radius the radius to set
   */
  public void setRadius(Integer radius) {
    set("radius", radius);
  }

  /**
   * Sets the start angle.
   * 
   * @param startAngle the new start angle
   */
  public void setStartAngle(Integer startAngle) {
    set("start-angle", startAngle);
  }

  private Collection<String> checkColours() {
    Collection<String> colours = get("colours");
    if (colours == null) {
      colours = new ArrayList<String>();
      set("colours", colours);
    }
    return colours;
  }
}
