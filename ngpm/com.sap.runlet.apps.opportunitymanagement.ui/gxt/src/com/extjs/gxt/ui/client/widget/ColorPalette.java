/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.event.ColorPaletteEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * Basic color component.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeSelect</b> : ColorPaletteEvent(colorPalette, color)<br>
 * <div>Fires before a color selected.</div>
 * <ul>
 * <li>colorPalette : this</li>
 * <li>color : the selected color</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Select</b> : ColorPaletteEvent(colorPalette, color)<br>
 * <div>Fires when a color is selected.</div>
 * <ul>
 * <li>colorPalette : this</li>
 * <li>color : the selected color</li>
 * </ul>
 * </dd>
 * 
 * </dl>
 */
public class ColorPalette extends Component {

  private boolean allowReselect;
  private String[] colors = new String[] {
      "000000", "993300", "333300", "003300", "003366", "000080", "333399", "333333",
      "800000", "FF6600", "808000", "008000", "008080", "0000FF", "666699", "808080",
      "FF0000", "FF9900", "99CC00", "339966", "33CCCC", "3366FF", "800080", "969696",
      "FF00FF", "FFCC00", "FFFF00", "00FF00", "00FFFF", "00CCFF", "993366", "C0C0C0",
      "FF99CC", "FFCC99", "FFFF99", "CCFFCC", "CCFFFF", "99CCFF", "CC99FF", "FFFFFF"};
  private XTemplate template;

  private String value;

  /**
   * Creates a new color palette.
   */
  public ColorPalette() {
    baseStyle = "x-color-palette";
  }

  /**
   * Returns the colors.
   * 
   * @return the colors
   */
  public String[] getColors() {
    return colors;
  }

  /**
   * Returns the xtemplate.
   * 
   * @return the template
   */
  public XTemplate getTemplate() {
    return template;
  }

  /**
   * Returns the current selected color.
   * 
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Returns true if re-selections are allowed.
   * 
   * @return the true if re-selections are allowed.
   */
  public boolean isAllowReselect() {
    return allowReselect;
  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    switch (ce.getEventTypeInt()) {
      case Event.ONCLICK:
        onClick(ce);
        break;
      case Event.ONMOUSEOVER:
        onMouseOver(ce);
        break;
      case Event.ONMOUSEOUT:
        onMouseOut(ce);
        break;
    }
  }

  protected void onMouseOut(ComponentEvent ce) {
    El target = ce.getTarget("a", 3);
    if(target != null){
      target.removeStyleName("x-color-palette-hover");
    }
  }

  protected void onMouseOver(ComponentEvent ce) {
    El target = ce.getTarget("a", 3);
    if(target != null){
      target.addStyleName("x-color-palette-hover");
    }
  }

  /**
   * Selects the color.
   * 
   * @param color the color
   */
  public void select(String color) {
    color = color.replace("#", "");
    ColorPaletteEvent ce = new ColorPaletteEvent(this);
    ce.setColor(color);
    if (!fireEvent(Events.BeforeSelect, ce)) {
      return;
    }
    if (!color.equals(value) || allowReselect) {
      if (getValue() != null) {
        el().child("a.color-" + getValue()).removeStyleName("x-color-palette-sel");
        el().child("a.color-" + getValue()).removeStyleName("x-color-palette-hover");
      }
      el().child("a.color-" + color).addStyleName("x-color-palette-sel");
      value = color;
      fireEvent(Events.Select, ce);
    }
  }

  /**
   * True to fire a select event if the current selected value is selected again
   * (default to false).
   * 
   * @param allowReselect true to fire select events if re-selected
   */
  public void setAllowReselect(boolean allowReselect) {
    this.allowReselect = allowReselect;
  }

  /**
   * Sets the colors for the palette.
   * 
   * @param colors the colors to set
   */
  public void setColors(String[] colors) {
    this.colors = colors;
  }

  /**
   * Optionally, sets the xtemplate to be used to render the component.
   * 
   * @param template the xtemplate
   */
  public void setTemplate(XTemplate template) {
    this.template = template;
  }

  /**
   * Sets the selected color.
   * 
   * @param value the value to set
   */
  public void setValue(String value) {
    value = value.replace("#", "");
    this.value = value;
    if (rendered) {
      select(value);
    }
  }

  @Override
  protected void afterRender() {
    super.afterRender();
    if (value != null) {
      String s = getValue();
      value = null;
      select(s);
    }
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new ColorPaletteEvent(this, event);
  }

  protected void onClick(ComponentEvent ce) {
    ce.preventDefault();
    if (!disabled) {
      El aElement = ce.getTarget("a", 3);
      String className = aElement.getStyleName();
      if (className.indexOf("color-") != -1) {
        select(className.substring(className.indexOf("color-") + 6,
            className.indexOf("color-") + 12));
      }
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    super.onRender(target, index);

    if (template == null) {
      String html = "<tpl for=\".\"><a href=\"#\" class=\"color-{.}\"><em><span style=\"background:#{.}\" unselectable=\"on\">&#160;</span></em></a></tpl>";
      setTemplate(XTemplate.create(html));
    }

    JavaScriptObject toJavaScriptArray = JsUtil.toJavaScriptArray(getColors());
    getTemplate().overwrite(el().dom, toJavaScriptArray);
    sinkEvents(Event.ONCLICK|Event.ONMOUSEOVER|Event.ONMOUSEOUT);
  }

}
