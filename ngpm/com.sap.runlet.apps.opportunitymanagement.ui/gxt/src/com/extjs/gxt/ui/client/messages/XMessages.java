/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.messages;

import com.google.gwt.i18n.client.Messages;

/**
 * GXT messages.
 */
public interface XMessages extends Messages {

  String updateManager_indicatorText();

  String grid_ddText(int rows);

  String tabPanelItem_closeText();
  
  String tabPanelItem_closeOtherText();

  String field_invalidText();

  String loadMask_msg();

  String messageBox_ok();

  String messageBox_cancel();

  String messageBox_yes();

  String messageBox_no();

  String messageBox_close();

  String datePicker_todayText();

  String datePicker_minText();

  String datePicker_maxText();

  String datePicker_disabledDaysText();

  String datePicker_disabledDatesText();

  String datePicker_nextText();

  String datePicker_prevText();

  String datePicker_monthYearText();

  String datePicker_todayTip(String date);

  String datePicker_okText();

  String datePicker_cancelText();

  String datePicker_startDay();

  String pagingToolBar_beforePageText();

  String pagingToolBar_afterPageText(int pages);

  String pagingToolBar_firstText();

  String pagingToolBar_prevText();

  String pagingToolBar_nextText();

  String pagingToolBar_lastText();

  String pagingToolBar_refreshText();

  String pagingToolBar_displayMsg(int start, int end, int total);

  String pagingToolBar_emptyMsg();

  String textField_minLengthText(int length);

  String textField_maxLengthText(int length);

  String textField_blankText();

  String textField_regexText();

  String textField_emptyText();
  
  String uploadField_browseText();

  String numberField_minText(double min);

  String numberField_maxText(double max);

  String numberField_nanText(String num);
  
  String numberField_negativeText();

  String dateField_disabledDaysText();

  String dateField_disabledDatesText();

  String dateField_minText(String min);

  String dateField_maxText(String max);

  String dateField_invalidText(String date, String format);

  String comboBox_loading();

  String listField_moveSelectedUp();

  String listField_moveSelectedDown();

  String listField_addAll();

  String listField_addSelected();

  String listField_removeAll();

  String listField_removeSelected();
  
  String htmlEditor_boldTipText();
  
  String htmlEditor_boldTipTitle();
  
  String htmlEditor_italicTipText();
  
  String htmlEditor_italicTipTitle();
  
  String htmlEditor_underlineTipText();
  
  String htmlEditor_underlineTipTitle();
  
  String htmlEditor_justifyLeftTipText();
  
  String htmlEditor_justifyLeftTipTitle();
  
  String htmlEditor_justifyCenterTipText();
  
  String htmlEditor_justifyCenterTipTitle();
  
  String htmlEditor_justifyRightTipText();
  
  String htmlEditor_justifyRightTipTitle();
  
  String htmlEditor_sourceEditTipText();
  
  String htmlEditor_sourceEditTipTitle();
  
  String htmlEditor_olTipText();
  
  String htmlEditor_olTipTitle();
  
  String htmlEditor_ulTipText();
  
  String htmlEditor_ulTipTitle();
  
  String htmlEditor_linkTipText();
  
  String htmlEditor_linkTipTitle();
  
  String htmlEditor_createLinkText();
  
  String htmlEditor_increaseFontSizeTipText();
  
  String htmlEditor_increaseFontSizeTipTitle();
  
  String htmlEditor_decreaseFontSizeTipText();
  
  String htmlEditor_decreaseFontSizeTipTitle();
  
  String htmlEditor_foreColorTipText();
  
  String htmlEditor_foreColorTipTitle();
  
  String htmlEditor_backColorTipText();
  
  String htmlEditor_backColorTipTitle();

  String gridView_sortAscText();

  String gridView_sortDescText();

  String gridView_columnsText();  

  String groupingView_emptyGroupText();

  String groupingView_groupByText();

  String groupingView_showGroupsText();

  String propertyColumnModel_nameText();

  String propertyColumnModel_valueText();

  String borderLayout_splitTip();

  String borderLayout_collapsibleSplitTip();

  String themeSelector_blueTheme();

  String themeSelector_grayTheme();

}
