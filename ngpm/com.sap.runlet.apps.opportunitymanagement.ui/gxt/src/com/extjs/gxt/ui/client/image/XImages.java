/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.image;

import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;

public interface XImages extends ImageBundle {
  @Resource("hmenu-asc.gif")
  AbstractImagePrototype grid_sortAsc();

  @Resource("hmenu-desc.gif")
  AbstractImagePrototype grid_sortDesc();

  @Resource("columns.gif")
  AbstractImagePrototype grid_columns();

  @Resource("group-by.gif")
  AbstractImagePrototype grid_groupBy();

  @Resource("checked.gif")
  AbstractImagePrototype checked();

  @Resource("unchecked.gif")
  AbstractImagePrototype unchecked();

  @Resource("group-checked.gif")
  AbstractImagePrototype group_checked();

  @Resource("exclamation.gif")
  AbstractImagePrototype field_invalid();

  @Resource("tb-bold.gif")
  AbstractImagePrototype editor_bold();

  @Resource("tb-font-color.gif")
  AbstractImagePrototype editor_font_color();

  @Resource("tb-font-decrease.gif")
  AbstractImagePrototype editor_font_decrease();

  @Resource("tb-font-highlight.gif")
  AbstractImagePrototype editor_font_highlight();

  @Resource("tb-font-increase.gif")
  AbstractImagePrototype editor_font_increase();

  @Resource("tb-italic.gif")
  AbstractImagePrototype editor_italic();

  @Resource("tb-justify-center.gif")
  AbstractImagePrototype editor_justify_center();

  @Resource("tb-justify-left.gif")
  AbstractImagePrototype editor_justify_left();

  @Resource("tb-justify-right.gif")
  AbstractImagePrototype editor_justify_right();

  @Resource("tb-link.gif")
  AbstractImagePrototype editor_link();

  @Resource("tb-ol.gif")
  AbstractImagePrototype editor_ol();

  @Resource("tb-ul.gif")
  AbstractImagePrototype editor_ul();

  @Resource("tb-source.gif")
  AbstractImagePrototype editor_source();

  @Resource("tb-underline.gif")
  AbstractImagePrototype editor_underline();

  @Resource("page-prev.gif")
  AbstractImagePrototype paging_toolbar_prev();

  @Resource("page-prev-disabled.gif")
  AbstractImagePrototype paging_toolbar_prev_disabled();

  @Resource("page-next.gif")
  AbstractImagePrototype paging_toolbar_next();

  @Resource("page-next-disabled.gif")
  AbstractImagePrototype paging_toolbar_next_disabled();

  @Resource("page-first.gif")
  AbstractImagePrototype paging_toolbar_first();

  @Resource("page-first-disabled.gif")
  AbstractImagePrototype paging_toolbar_first_disabled();

  @Resource("page-last.gif")
  AbstractImagePrototype paging_toolbar_last();

  @Resource("page-last-disabled.gif")
  AbstractImagePrototype paging_toolbar_last_disabled();

  @Resource("refresh.gif")
  AbstractImagePrototype paging_toolbar_refresh();

  @Resource("more.gif")
  AbstractImagePrototype toolbar_more();

  @Resource("folder.png")
  AbstractImagePrototype tree_folder();

  @Resource("folder-closed.png")
  AbstractImagePrototype tree_folder_closed();
  
  @Resource("tree-collapsed.png")
  AbstractImagePrototype tree_collapsed();
  
  @Resource("tree-collapsed-over.png")
  AbstractImagePrototype tree_collapsed_over();
  
  @Resource("tree-expanded.png")
  AbstractImagePrototype tree_expanded();
  
  @Resource("tree-expanded-over.png")
  AbstractImagePrototype tree_expanded_over();
  
  @Resource("wait.gif")
  AbstractImagePrototype icon_wait();

}
