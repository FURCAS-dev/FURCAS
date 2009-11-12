/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.tree;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.Direction;
import com.extjs.gxt.ui.client.aria.FocusFrame;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FxEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TreeEvent;
import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.widget.tree.Tree.Joint;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Accessibility;

/**
 * Default <code>TreeItemUI</code> implementation.
 * 
 * @deprecated see {@link TreePanel}
 */
public class DefaultTreeItemUI implements TreeItemUI {

  protected int animDuration = 300;
  protected Element checkEl, checkDivEl;
  protected String classTreeClose = "my-tree-close";
  protected String classTreeOpen = "my-tree-open";
  protected El containerEl;
  protected Element iconEl, iconDivEl;
  protected Element itemEl, indentEl;
  protected TreeItem item;

  protected Element jointEl, jointDivEl;
  protected String styleTreeChecked = "my-tree-checked";
  protected String styleTreeItem = "";
  protected String styleTreeJointOver = "my-tree-joint-over";
  protected String styleTreeLoading = "my-tree-loading";
  protected String styleTreeNotChecked = "my-tree-notchecked";
  protected String styleTreeOver = "my-tree-over";
  protected String styleTreeSelected = "my-tree-sel";
  protected Element textEl, textSpanEl;
  protected String textStyle;

  public void afterRender() {
    if (item.root) return;

    itemEl = item.getElement().getFirstChild().cast();
    fly(itemEl).addStyleName(styleTreeItem);

    El el = item.el();

    Element td = el.selectNode("td:first-child").dom;
    indentEl = td.getFirstChildElement().cast();
    jointEl = td.getNextSiblingElement().cast();
    jointDivEl = jointEl.getFirstChild().cast();
    checkEl = jointEl.getNextSiblingElement().getNextSiblingElement().cast();
    checkDivEl = checkEl.getFirstChild().cast();
    iconEl = checkEl.getNextSibling().cast();
    iconDivEl = iconEl.getFirstChild().cast();
    textEl = iconEl.getNextSiblingElement().cast();
    textSpanEl = textEl.getFirstChildElement().cast();
    
    
    containerEl = el.getChild(1);
    containerEl.setVisible(false);
    containerEl.makePositionable();

    if (item.getItemStyleName() != null) {
      item.el().firstChild().addStyleName(item.getItemStyleName());
    }

    if (checkEl != null) {
      fly(checkEl).setVisible(item.tree.getCheckable());
    }
    
    item.updateIconStyle();
    item.updateJointStyle();

    if (item.getTextStyle() != null) {
      onTextStyleChange(item.getTextStyle());
    }
    if (item.isChecked()) {
      onCheckChange(true);
    }

    fly(indentEl).setWidth(item.getIndent() - 18);

    item.disableTextSelection(true);
  }
  
  public void bind(TreeItem item) {
    this.item = item;
  }

  public void collapse() {
    if (item.root) {
      return;
    }
    
    item.updateIconStyle();
    item.updateJointStyle();
    
    if (item.tree.getAnimate()) {
      animCollapse();
    } else {
      containerEl.setVisible(false);
      afterCollapse();
    }
  }

  public void expand() {
    if (item.root) {
      return;
    }
    item.updateJointStyle();
    if (item.getItemCount() == 0) {
      return;
    }

    item.updateIconStyle();
    item.updateJointStyle();
    
    if (item.tree.getAnimate()) {
      animExpand();
    } else {
      containerEl.setVisible(true);
      afterExpand();
    }
  }

  public Element getCheckElement() {
    return checkEl;
  }

  public Element getContainerElement() {
    return containerEl.dom;
  }

  public Element getJointElement() {
    return jointDivEl;
  }

  public native String getTemplate(String id, String text, String icon, int joint, int level) /*-{
    return ['<div id=' + id + ' class="my-tree-item x-tree-item" role="treeitem" aria-level="' + (++level) + '">',
             '<div class=my-treeitem-wrap>',
             '<table cellpadding=0 cellspacing=0><tbody>',
             '<tr>',
               '<td><div class="my-tree-indent"></div></td>',
               '<td class="my-tree-joint" align="center" valign="middle"><div>&nbsp;</div></td>',
               '<td class="my-tree-left"><div></div></td>',
               '<td class="my-tree-check"><div class="my-tree-notchecked"></div></td>',
               '<td class="my-tree-icon"><div>&nbsp;</div></td>',
               '<td class="my-tree-item-text"><span>' + text + '</span></td>',
               '<td class="my-tree-right"><div></div></td>',
             '</tr>',
             '</tbody>',
             '</table>',
             '</div>',
             '<div class="my-tree-ct" role="container"></div>',
             '</div>'].join("");
    }-*/;

  public void handleEvent(TreeEvent te) {
    int type = te.getEventTypeInt();
    Element target = te.getTarget();
    switch (type) {
      case Event.ONCLICK:
      case Event.ONDBLCLICK:
        if (checkEl != null && DOM.isOrHasChild(checkEl, target)) {
          te.stopEvent();
          item.setChecked(!item.isChecked());
        } else {
          handleClickEvent(te);
        }
        return;
      case Event.ONMOUSEOVER:
      case Event.ONMOUSEOUT:
        if (DOM.isOrHasChild(jointEl, target)) {
          handleJointEvent(te);
        } else if (isSelectableTarget(target)) {
          handleMouseEvent(te);
        }
        break;
    }
  }

  public boolean isSelectableTarget(Element target) {
    if (DOM.isOrHasChild(iconEl, target) || DOM.isOrHasChild(textEl, target)
        || (checkEl != null && DOM.isOrHasChild(checkEl, target))) {
      return true;
    }
    return false;
  }

  public void onCheckChange(boolean checked) {
    String cls = checked ? styleTreeChecked : styleTreeNotChecked;
    checkDivEl.setClassName(cls);
    item.fireEvent(Events.CheckChange, new TreeEvent(item.tree, item));
  }

  public void onDoubleClick(ComponentEvent ce) {
    item.toggle();
    ce.cancelBubble();
  }

  public void onIconStyleChange(String style) {
    if (style != null) {
      fly(iconEl).setStyleAttribute("display", "");
      fly(iconDivEl).setIconStyle(style);
    } else {
      fly(iconEl).setStyleAttribute("display", "none");
    }
  }

  public void onIndentChange(int level) {
    fly(indentEl).setWidth(item.getIndent() - 18);
    Accessibility.setState(item.getElement(), "aria-level", ++level + "");
  }

  public void onJointChange(Joint joint) {
    switch (joint) {
      case NONE:
        jointDivEl.setClassName("none");
        break;
      case EXPANDED:
        jointDivEl.setClassName("my-tree-open");
        break;
      case COLLAPSED:
        jointDivEl.setClassName("my-tree-close");
        break;
    }
  }

  public void onLoadingChange(boolean loading) {
    if (loading) {
      item.addStyleName(styleTreeLoading);
    } else {
      item.removeStyleName(styleTreeLoading);
    }
  }

  public void onOverChange(boolean over) {
    fly(itemEl).setStyleName(styleTreeOver, over);
  }

  public void onRemoveChild(TreeItem child) {
    containerEl.dom.removeChild(child.getElement());
    if (item.getItemCount() == 0) {
      boolean b = item.tree.getAnimate();
      item.tree.setAnimate(false);
      item.setExpanded(false);
      item.tree.setAnimate(b);
    }
  }

  public void onSelectedChange(boolean selected) {
    if (item.isRendered()) {
      fly(itemEl).setStyleName(styleTreeSelected, selected);
      if (!selected) {
        onOverChange(false);
      } else {
        Accessibility.setState(item.tree.getElement(), "aria-activedescendant", item.getId());
      }
    }
  }

  public void onTextChange(String text) {
    if (!item.root) {
      textSpanEl.setInnerHTML(text);
    }
  }

  public void onTextStyleChange(String style) {
    if (textStyle != null) {
      fly(textSpanEl).removeStyleName(textStyle);
    }
    textStyle = style;
    if (style != null) {
      fly(textSpanEl).addStyleName(style);
    }
  }

  public void refresh() {
    onIconStyleChange(null);
    item.updateJointStyle();
  }

  protected void afterCollapse() {
    item.tree.disableEvents(false);
    containerEl.dom.getStyle().setProperty("marginTop", "0");
    fly(itemEl).removeStyleName(styleTreeJointOver);
    if (GXT.isAriaEnabled()) {
      Accessibility.setState(item.getElement(), "aria-expanded", "false");
      FocusFrame.get().sync(item.tree);
    }
    item.fireEvent(Events.Collapse, new TreeEvent(item.tree, item));
  }

  protected void afterExpand() {
    item.tree.disableEvents(false);
    fly(itemEl).removeStyleName(styleTreeJointOver);
    if (GXT.isAriaEnabled()) {
      Accessibility.setState(item.getElement(), "aria-expanded", "true");
      FocusFrame.get().sync(item.tree);
    }
    item.fireEvent(Events.Expand, new TreeEvent(item.tree, item));
  }

  protected El fly(Element elem) {
    return El.fly(elem);
  }

  protected void handleClickEvent(TreeEvent te) {
    TreeItem item = te.getItem();
    if (te.getEventTypeInt() == Event.ONCLICK) {
      Element target = te.getTarget();
      if (target != null && te.within(item.getUI().getJointElement())) {
        item.toggle();
      }
      te.cancelBubble();
    } else if (te.getEventTypeInt() == Event.ONDBLCLICK) {
      item.toggle();
    }
  }

  protected void handleJointEvent(TreeEvent ce) {
    switch (ce.getEventTypeInt()) {
      case Event.ONMOUSEOVER:
        fly(itemEl).addStyleName(styleTreeJointOver);
        break;
      case Event.ONMOUSEOUT:
        fly(itemEl).removeStyleName(styleTreeJointOver);
        break;
    }
    ce.stopEvent();
  }

  protected void handleMouseEvent(TreeEvent ce) {
    int type = ce.getEventTypeInt();
    switch (type) {
      case Event.ONMOUSEOVER:
        onOverChange(true);
        break;
      case Event.ONMOUSEOUT:
        onOverChange(false);
        break;
    }
    ce.cancelBubble();
  }

  protected void onClick(TreeEvent te) {
    Element target = te.getTarget();
    if (target != null && isSelectableTarget(target)) {
      item.toggle();
    }
    te.cancelBubble();
  }

  private void animCollapse() {
    containerEl.slideOut(Direction.UP, new FxConfig(animDuration,
        new Listener<FxEvent>() {
          public void handleEvent(FxEvent fe) {
            afterCollapse();
          }
        }));
    item.tree.disableEvents(true);
  }

  private void animExpand() {
    containerEl.slideIn(Direction.DOWN, new FxConfig(animDuration,
        new Listener<FxEvent>() {
          public void handleEvent(FxEvent fe) {
            afterExpand();
          }
        }));
    item.tree.disableEvents(true);
  }
}
