/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.DataListEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.IconButton;
import com.google.gwt.user.client.Element;

/**
 * A item contained in a <code>List</code>.
 * 
 * @see DataList
 * 
 * @deprecated see {@link ListView}
 */
public class DataListItem extends Component {

  protected DataList list;
  protected IconButton checkBtn;
  protected String iconSelector = ".x-icon-btn";
  private boolean checked;
  private String text, iconStyle, textStyle;

  /**
   * Creates a new list item.
   */
  public DataListItem() {
  }

  /**
   * Creates a new list item.
   * 
   * @param text the text
   */
  public DataListItem(String text) {
    this();
    setText(text);
  }

  /**
   * Adds a selection listener.
   * 
   * @param listener the listener
   */
  public void addSelectionListener(SelectionListener<DataListEvent> listener) {
    addListener(Events.Select, listener);
  }

  /**
   * Returns the icon style.
   * 
   * @return the icon style
   */
  public String getIconStyle() {
    return iconStyle;
  }

  /**
   * Returns the item's parent list.
   * 
   * @return the list
   */
  public DataList getList() {
    return list;
  }

  /**
   * Returns the item's text.
   * 
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Returns the item's text style.
   * 
   * @return the text style
   */
  public String getTextStyle() {
    return textStyle;
  }

  /**
   * Returns <code>true</code> if the item is checked.
   * 
   * @return the checked state
   */
  public boolean isChecked() {
    return checked;
  }

  /**
   * Removes a previously added listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeSelectionListener(SelectionListener<DataListEvent> listener) {
    removeListener(Events.Select, listener);
  }

  /**
   * Sets the item's checked state.
   * 
   * @param checked the check state
   */
  public void setChecked(boolean checked) {
    this.checked = checked;
    if (rendered) {
      list.onCheckChange(this, checked);
    }
  }

  /**
   * Sets the item's icon style. The style name should match a CSS style that
   * specifies a background image using the following format:
   * 
   * <pre><code>
   * .my-icon {
   *    background: url(images/icons/my-icon.png) no-repeat center left !important;
   * }
   * </code></pre>
   * 
   * @param iconStyle the icon style
   */
  public void setIconStyle(String iconStyle) {
    if (rendered) {
      El elem = el().selectNode(iconSelector);
      if (elem != null) {
        elem.replaceStyleName(this.iconStyle, iconStyle);
      }
    }
    this.iconStyle = iconStyle;
  }

  /**
   * Sets the item's text.
   * 
   * @param text the text
   */
  public void setText(String text) {
    this.text = text;
    if (rendered) {
      El elem = el().selectNode("." + list.itemStyle + "-text");
      elem.dom.setInnerHTML(text);
    }
  }

  /**
   * Sets the item's text style.
   * 
   * @param textStyle the text style name
   */
  public void setTextStyle(String textStyle) {
    if (!rendered) {
      this.textStyle = textStyle;
    } else {
      El elem = el().selectNode("." + list.itemStyle + "-text");
      if (this.textStyle != null) {
        elem.removeStyleName(this.textStyle);
      }
      this.textStyle = textStyle;
      elem.addStyleName(textStyle);
    }
  }

  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    list.onRenderItem(this, target, index);
  }

}
