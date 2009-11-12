/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 *
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.AbstractImagePrototype.ImagePrototypeElement;

/**
 * A custom component that supports an icon, text, and tool area.
 */
public class Header extends Component implements IconSupport {

  protected AbstractImagePrototype icon;

  private String textStyle;
  private El textEl;
  private List<Component> tools = new ArrayList<Component>();
  private HorizontalPanel widgetPanel;
  private String text;

  /**
   * Adds a tool.
   * 
   * @param tool the tool to be inserted
   */
  public void addTool(Component tool) {
    insertTool(tool, getToolCount());
  }

  public AbstractImagePrototype getIcon() {
    return icon;
  }

  /**
   * Returns the header's text.
   * 
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Returns the item's text style.
   * 
   * @return the textStyle the text style
   */
  public String getTextStyle() {
    return textStyle;
  }

  /**
   * Returns the tool at the given index.
   * 
   * @param index the index
   * @return the tool
   */
  public Component getTool(int index) {
    return tools.get(index);
  }

  /**
   * Returns the number of tool items.
   * 
   * @return the count
   */
  public int getToolCount() {
    return tools.size();
  }

  /**
   * Inserts a tool.
   * 
   * @param tool the tool to insert
   * @param index the insert location
   */
  public void insertTool(Component tool, int index) {
    tools.add(index, tool);
    if (rendered) {
      widgetPanel.insert((Widget) tool, index);
    }
  }

  /**
   * Removes a tool.
   * 
   * @param tool the tool to remove
   */
  public void removeTool(Component tool) {
    tools.remove(tool);
    if (rendered) {
      widgetPanel.remove(tool);
    }
  }

  /**
   * Sets the header's icon style. The style name should match a CSS style that
   * specifies a background image using the following format:
   * 
   * <pre>
   * &lt;code&gt;
   * .my-icon {
   *    background: url(images/icons/my-icon.png) no-repeat center left !important;
   * }
   * &lt;/code&gt;
   * </pre>
   * 
   * @param icon the icon
   */
  public void setIcon(AbstractImagePrototype icon) {
    if (rendered) {
      if (el().selectNode("img") != null) {
        el().selectNode("img").remove();
      }

      if (icon != null) {
        ImagePrototypeElement i = icon.createElement();
        El.fly(i).addStyleName("x-panel-inline-icon");
        El.fly(i).setStyleAttribute("cursor", "default");
        El.fly(i).setStyleAttribute("float", "left");
        el().insertChild((Element) i.cast(), 0);
      }
    }
    this.icon = icon;
  }

  public void setIconStyle(String icon) {
    setIcon(IconHelper.create(icon));
  }

  /**
   * Sets the header's text.
   * 
   * @param text the new text
   */
  public void setText(String text) {
    this.text = text;
    if (rendered) {
      textEl.dom.setInnerHTML(text == null ? "&#160;" : text);
    }
  }

  /**
   * Sets the style name added to the header's text element.
   * 
   * @param textStyle the text style
   */
  public void setTextStyle(String textStyle) {
    this.textStyle = textStyle;
    if (rendered) {
      textEl.dom.setClassName(textStyle);
    }
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    ComponentHelper.doAttach(widgetPanel);
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    ComponentHelper.doDetach(widgetPanel);
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    setElement(DOM.createDiv(), target, index);

    addStyleName("x-small-editor");
    widgetPanel = new HorizontalPanel();
    widgetPanel.setStyleName("x-panel-toolbar");
    widgetPanel.setLayoutOnChange(true);
    widgetPanel.setStyleAttribute("float", "right");

    if (tools.size() > 0) {
      for (int i = 0; i < tools.size(); i++) {
        widgetPanel.add(tools.get(i));
      }
    }

    widgetPanel.render(getElement());

    textEl = new El(DOM.createSpan());
    textEl.setId(getId() + "-label");
    getElement().appendChild(textEl.dom);

    if (textStyle != null) {
      setTextStyle(textStyle);
    }

    setText(text);

    if (icon != null) {
      setIcon(icon);
    }
  }

}
