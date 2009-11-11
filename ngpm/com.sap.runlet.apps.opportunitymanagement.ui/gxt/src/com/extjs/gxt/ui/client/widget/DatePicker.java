/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.Date;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.Direction;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.core.CompositeElement;
import com.extjs.gxt.ui.client.core.CompositeFunction;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.DatePickerEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FxEvent;
import com.extjs.gxt.ui.client.event.IconButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.messages.XMessages;
import com.extjs.gxt.ui.client.util.DateWrapper;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.IconButton;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.constants.DateTimeConstants;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Grid;

/**
 * Simple date picker.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Select</b> : DatePickerEvent(datePicker, date)<br>
 * <div>Fires when a date is selected.</div>
 * <ul>
 * <li>datePicker : this</li>
 * <li>date : the selected date</li>
 * </ul>
 * </dd> 
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>BoxComponent Move</dd>
 * <dd>BoxComponent Resize</dd>
 * <dd>Component Enable</dd>
 * <dd>Component Disable</dd>
 * <dd>Component BeforeHide</dd>
 * <dd>Component Hide</dd>
 * <dd>Component BeforeShow</dd>
 * <dd>Component Show</dd>
 * <dd>Component Attach</dd>
 * <dd>Component Detach</dd>
 * <dd>Component BeforeRender</dd>
 * <dd>Component Render</dd>
 * <dd>Component BrowserEvent</dd>
 * <dd>Component BeforeStateRestore</dd>
 * <dd>Component StateRestore</dd>
 * <dd>Component BeforeStateSave</dd>
 * <dd>Component SaveState</dd>
 * </dl>
 */
public class DatePicker extends BoxComponent {

  /**
   * DatePicker messages.
   */
  public class DatePickerMessages {
    private String todayText;
    private String okText = "&#160;OK&#160;";
    private String cancelText;
    private String todayTip;
    private String minText;
    private String maxText;
    private String prevText;
    private String nextText;
    private String monthYearText;

    /**
     * Sets the text to display on the cancel button.
     * 
     * @return the cancel button text
     */
    public String getCancelText() {
      return cancelText;
    }

    /**
     * Returns the max text.
     * 
     * @return the max text
     */
    public String getMaxText() {
      return maxText;
    }

    /**
     * Returns the min text.
     * 
     * @return the min text
     */
    public String getMinText() {
      return minText;
    }

    /**
     * Returns the month year text.
     * 
     * @return the month year text
     */
    public String getMonthYearText() {
      return monthYearText;
    }

    /**
     * Returns the next text.
     * 
     * @return the next text
     */
    public String getNextText() {
      return nextText;
    }

    /**
     * Returns the ok text.
     * 
     * @return the ok text
     */
    public String getOkText() {
      return okText;
    }

    /**
     * Returns the prev text.
     * 
     * @return the prev text
     */
    public String getPrevText() {
      return prevText;
    }

    /**
     * Returns the today text.
     * 
     * @return the today text
     */
    public String getTodayText() {
      return todayText;
    }

    /**
     * Returns the today tip.
     * 
     * @return the tip
     */
    public String getTodayTip() {
      return todayTip;
    }

    /**
     * Sets the cance text (default to "Cancel").
     * 
     * @param cancelText the cancel text
     */
    public void setCancelText(String cancelText) {
      this.cancelText = cancelText;
    }

    /**
     * Sets the error text to display if the maxDate validation fails (defaults
     * to "This date is after the maximum date").
     * 
     * @param maxText the max error text
     */
    public void setMaxText(String maxText) {
      this.maxText = maxText;
    }

    /**
     * Sets the error text to display if the minDate validation fails (defaults
     * to "This date is before the minimum date").
     * 
     * @param minText the min error text
     */
    public void setMinText(String minText) {
      this.minText = minText;
    }

    /**
     * Sets the header month selector tooltip (defaults to 'Choose a month
     * (Control+Up/Down to move years)').
     * 
     * @param monthYearText the month year text
     */
    public void setMonthYearText(String monthYearText) {
      this.monthYearText = monthYearText;
    }

    /**
     * Sets the next month navigation button tooltip (defaults to 'Next Month
     * (Control+Right)').
     * 
     * @param nextText the next text
     */
    public void setNextText(String nextText) {
      this.nextText = nextText;
    }

    /**
     * Sets the text to display on the ok button.
     * 
     * @param okText the ok text
     */
    public void setOkText(String okText) {
      this.okText = okText;
    }

    /**
     * Sets the previous month navigation button tooltip (defaults to 'Previous
     * Month (Control+Left)').
     * 
     * @param prevText the prev text
     */
    public void setPrevText(String prevText) {
      this.prevText = prevText;
    }

    /**
     * Sets the text to display on the button that selects the current date
     * (defaults to "Today").
     * 
     * @param todayText the today text
     */
    public void setTodayText(String todayText) {
      this.todayText = todayText;
    }

    /**
     * Sets the tooltip to display for the button that selects the current date
     * (defaults to "{current date} (Spacebar)").
     * 
     * @param todayTip the today tool tip
     */
    public void setTodayTip(String todayTip) {
      this.todayTip = todayTip;
    }

  }

  class Header extends Component {

    protected void doAttachChildren() {
      ComponentHelper.doAttach(monthBtn);
      prevBtn.onAttach();
      nextBtn.onAttach();
    }

    protected void doDetachChildren() {
      ComponentHelper.doDetach(monthBtn);
      prevBtn.onDetach();
      nextBtn.onDetach();
    }

    @Override
    protected void onRender(Element target, int index) {
      StringBuffer sb = new StringBuffer();
      sb.append("<table width=100% cellpadding=0 cellspacing=0><tr>");
      sb.append("<td class=x-date-left></td><td class=x-date-middle align=center></td>");
      sb.append("<td class=x-date-right></td></tr></table>");

      setElement(XDOM.create(sb.toString()));
      el().insertInto(target, index);

      el().setWidth(175, true);

      String pt = messages.getPrevText() != null ? messages.getPrevText()
          : myMessages.datePicker_prevText();
      String nt = messages.getNextText() != null ? messages.getNextText()
          : myMessages.datePicker_nextText();

      monthBtn = new Button("&#160;", new SelectionListener<ButtonEvent>() {
        public void componentSelected(ButtonEvent ce) {
          showMonthPicker();
        }
      });

      monthBtn.render(el().selectNode(".x-date-middle").dom);
      monthBtn.el().child("em").addStyleName("x-btn-arrow");

      prevBtn = new IconButton("x-date-left-icon", new SelectionListener<IconButtonEvent>() {
        public void componentSelected(IconButtonEvent ce) {
          showPrevMonth();
        }
      });
      prevBtn.setToolTip(pt);
      prevBtn.render(el().selectNode(".x-date-left").dom);

      nextBtn = new IconButton("x-date-right-icon", new SelectionListener<IconButtonEvent>() {
        public void componentSelected(IconButtonEvent ce) {
          showNextMonth();
        }
      });
      nextBtn.setToolTip(nt);
      nextBtn.render(el().selectNode(".x-date-right").dom);
    }

  }

  protected Button todayBtn;

  private int firstDOW;
  private Date minDate;
  private Date maxDate;
  private int startDay;
  private long today;
  private int mpyear;
  private Grid days, grid;
  private Component header;
  private HorizontalPanel footer;
  private DateWrapper activeDate, value;
  private int mpSelMonth, mpSelYear;
  private Button monthBtn;
  private Element[] cells;
  private Element[] textNodes;
  private IconButton prevBtn, nextBtn;
  private CompositeElement mpMonths, mpYears;
  private El monthPicker;
  private DateTimeConstants constants = (DateTimeConstants) GWT.create(DateTimeConstants.class);
  private XMessages myMessages = (XMessages) GWT.create(XMessages.class);
  private DatePickerMessages messages;

  /**
   * Creates a new date picker.
   */
  public DatePicker() {
    baseStyle = "x-date-picker";
    messages = new DatePickerMessages();
  }

  @Override
  public void focus() {
    super.focus();
    {
      update(activeDate);
    }
  }

  /**
   * Returns the field's maximum allowed date.
   * 
   * @return the max date
   */
  public Date getMaxDate() {
    return maxDate;
  }

  /**
   * Returns the data picker messages.
   * 
   * @return the date picker messages
   */
  public DatePickerMessages getMessages() {
    return messages;
  }

  /**
   * Returns the picker's minimum data.
   * 
   * @return the min date
   */
  public Date getMinDate() {
    return minDate;
  }

  /**
   * Returns the picker's start day.
   * 
   * @return the start day
   */
  public int getStartDay() {
    return startDay;
  }

  /**
   * Gets the current selected value of the date field.
   * 
   * @return the date
   */
  public Date getValue() {
    return value.asDate();
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

  /**
   * Sets the picker's maximum allowed date.
   * 
   * @param maxDate the max date
   */
  public void setMaxDate(Date maxDate) {
    if (maxDate != null) {
      maxDate = new DateWrapper(maxDate).clearTime().asDate();
    }
    this.maxDate = maxDate;
  }

  /**
   * Sets the data picker messages.
   * 
   * @param messages the date picker messages
   */
  public void setMessages(DatePickerMessages messages) {
    this.messages = messages;
  }

  /**
   * Sets the picker's minimum allowed date.
   * 
   * @param minDate the min date
   */
  public void setMinDate(Date minDate) {
    if (minDate != null) {
      minDate = new DateWrapper(minDate).clearTime().asDate();
    }
    this.minDate = minDate;
  }

  /**
   * Sets the picker's start day
   * 
   * @param startDay the start day
   */
  public void setStartDay(int startDay) {
    this.startDay = startDay;
  }

  /**
   * Sets the value of the date field.
   * 
   * @param date the date
   */
  public void setValue(Date date) {
    setValue(date, false);
  }

  /**
   * Sets the value of the date field.
   * 
   * @param date the date
   * @param supressEvent true to suppress the select event
   */
  public void setValue(Date date, boolean supressEvent) {
    this.value = new DateWrapper(date).clearTime();
    if (rendered) {
      update(value);
    }
    if (!supressEvent) {
      DatePickerEvent de = new DatePickerEvent(this);
      de.setDate(date);
      fireEvent(Events.Select, de);
    }
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    header.onAttach();
    footer.onAttach();
    ComponentHelper.doAttach(grid);
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    header.onDetach();
    footer.onDetach();
    ComponentHelper.doDetach(grid);
    monthPicker.setVisible(false);
  }

  protected void onClick(ComponentEvent be) {
    be.stopEvent();
    El target = be.getTargetEl();
    El pn = null;
    String cls = target.getStyleName();
    if (cls.equals("x-date-left-a")) {
      showPrevMonth();
    } else if (cls.equals("x-date-right-a")) {
      showNextMonth();
    }
    if ((pn = target.findParent("td.x-date-mp-month", 2)) != null) {
      mpMonths.removeStyleName("x-date-mp-sel");
      El elem = target.findParent("td.x-date-mp-month", 2);
      elem.addStyleName("x-date-mp-sel");
      mpSelMonth = pn.dom.getPropertyInt("xmonth");
    } else if ((pn = target.findParent("td.x-date-mp-year", 2)) != null) {
      mpYears.removeStyleName("x-date-mp-sel");
      El elem = target.findParent("td.x-date-mp-year", 2);
      elem.addStyleName("x-date-mp-sel");
      mpSelYear = pn.dom.getPropertyInt("xyear");
    } else if (target.is("button.x-date-mp-ok")) {
      DateWrapper d = new DateWrapper(mpSelYear, mpSelMonth, activeDate.getDate());
      update(d);
      hideMonthPicker();
    } else if (target.is("button.x-date-mp-cancel")) {
      hideMonthPicker();
    } else if (target.is("a.x-date-mp-prev")) {
      updateMPYear(mpyear - 10);
    } else if (target.is("a.x-date-mp-next")) {
      updateMPYear(mpyear + 10);
    }

    if (GXT.isSafari) {
      focus();
    }
  }

  protected void onDayClick(ComponentEvent ce) {
    ce.stopEvent();
    El target = ce.getTargetEl();
    El e = target.findParent("a", 5);
    if (e != null) {
      String dt = e.dom.getPropertyString("dateValue");
      if (dt != null) {
        handleDateClick(e, dt);
        return;
      }
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    disableTextSelection(true);
    if (messages.getMinText() == null) {
      messages.setMinText(GXT.MESSAGES.datePicker_minText());
    }
    if (messages.getMaxText() == null) {
      messages.setMaxText(GXT.MESSAGES.datePicker_maxText());
    }

    if (messages.getTodayText() == null) {
      messages.setTodayText(GXT.MESSAGES.datePicker_todayText());
    }

    header = new Header();
    header.render(getElement());

    days = new Grid(1, 7);
    days.setStyleName("x-date-days");
    days.setCellPadding(0);
    days.setCellSpacing(0);
    days.setBorderWidth(0);

    String[] dn = constants.narrowWeekdays();
    firstDOW = startDay != 0 ? startDay
        : Integer.parseInt(constants.firstDayOfTheWeek()) - 1;

    days.setHTML(0, 0, "<span>" + dn[(0 + firstDOW) % 7] + "</span>");
    days.setHTML(0, 1, "<span>" + dn[(1 + firstDOW) % 7] + "</span>");
    days.setHTML(0, 2, "<span>" + dn[(2 + firstDOW) % 7] + "</span>");
    days.setHTML(0, 3, "<span>" + dn[(3 + firstDOW) % 7] + "</span>");
    days.setHTML(0, 4, "<span>" + dn[(4 + firstDOW) % 7] + "</span>");
    days.setHTML(0, 5, "<span>" + dn[(5 + firstDOW) % 7] + "</span>");
    days.setHTML(0, 6, "<span>" + dn[(6 + firstDOW) % 7] + "</span>");

    grid = new Grid(6, 7);
    grid.setStyleName("x-date-inner");
    grid.setCellSpacing(0);
    grid.setCellPadding(0);
    grid.addClickHandler(new ClickHandler() {
    
      public void onClick(ClickEvent event) {
        Event evt = DOM.eventGetCurrentEvent();
        ComponentEvent be = new ComponentEvent(DatePicker.this, evt);
        onDayClick(be);
      }
    });

    for (int row = 0; row < 6; row++) {
      for (int col = 0; col < 7; col++) {
        grid.setHTML(row, col, "<a href=#><span></span></a>");
      }
    }

    footer = new HorizontalPanel();
    footer.setTableWidth("100%");
    footer.setHorizontalAlign(HorizontalAlignment.CENTER);

    footer.setStyleName("x-date-bottom");

    if (GXT.isIE) {
      footer.setWidth(175);
    }

    todayBtn = new Button(messages.getTodayText(), new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        selectToday();
      }
    });
    footer.add(todayBtn, new TableData(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE));

    monthPicker = new El(DOM.createDiv());
    monthPicker.dom.setClassName("x-date-mp");

    getElement().appendChild(header.getElement());
    getElement().appendChild(days.getElement());
    getElement().appendChild(grid.getElement());
    getElement().appendChild(footer.getElement());
    getElement().appendChild(monthPicker.dom);

    el().setWidth(175);

    cells = Util.toElementArray(el().select("table.x-date-inner tbody td"));
    textNodes = Util.toElementArray(el().select("table.x-date-inner tbody span"));

    activeDate = value != null ? value : new DateWrapper();
    update(activeDate);

    el().addEventsSunk(Event.ONCLICK | Event.MOUSEEVENTS);
    el().makePositionable();

  }

  private void createMonthPicker() {
    String ok = messages.getOkText() != null ? messages.getOkText()
        : myMessages.datePicker_okText();
    String cancel = messages.getCancelText() != null ? messages.getCancelText()
        : myMessages.datePicker_cancelText();

    StringBuffer buf = new StringBuffer();
    buf.append("<table border=0 cellspacing=0>");
    String[] monthNames = constants.shortMonths();
    for (int i = 0; i < 6; i++) {
      buf.append("<tr><td class=x-date-mp-month><a href=#>" + monthNames[i] + "</a></td>");
      buf.append("<td class='x-date-mp-month x-date-mp-sep'><a href=#>"
          + monthNames[i + 6] + "</a></td>");
      if (i == 0) {
        buf.append("<td class=x-date-mp-ybtn align=center><a class=x-date-mp-prev href=#></a></td><td class='x-date-mp-ybtn' align=center><a class='x-date-mp-next'></a></td></tr>");
      } else {
        buf.append("<td class='x-date-mp-year'><a href='#'></a></td><td class='x-date-mp-year'><a href='#'></a></td></tr>");
      }
    }
    buf.append("<tr class=x-date-mp-btns><td colspan='4'><button type='button' class='x-date-mp-ok'>");
    buf.append(ok);
    buf.append("</button><button type=button class=x-date-mp-cancel>");
    buf.append(cancel);
    buf.append("</button></td></tr></table>");

    monthPicker.update(buf.toString());

    mpMonths = new CompositeElement(Util.toElementArray(monthPicker.select("td.x-date-mp-month")));
    mpYears = new CompositeElement(Util.toElementArray(monthPicker.select("td.x-date-mp-year")));

    mpMonths.each(new CompositeFunction() {

      public void doFunction(Element elem, CompositeElement ce, int index) {
        index += 1;
        if (index % 2 == 0) {
          elem.setPropertyInt("xmonth", (int) (5 + (Math.round(index * .5))));
        } else {
          elem.setPropertyInt("xmonth", (int) (Math.round((index - 1) * .5)));
        }
      }

    });

  }

  private void handleDateClick(El target, String dt) {
    String[] tokens = dt.split(",");
    int year = Integer.parseInt(tokens[0]);
    int month = Integer.parseInt(tokens[1]);
    int day = Integer.parseInt(tokens[2]);
    Date d = new DateWrapper(year, month, day).asDate();
    if (d != null && !target.getParent().hasStyleName("x-date-disabled")) {
      setValue(d);
    }
  }

  private void hideMonthPicker() {
    monthPicker.slideOut(Direction.UP, new FxConfig(300, new Listener<FxEvent>() {
      public void handleEvent(FxEvent ce) {
        monthPicker.setVisible(false);
      }
    }));
  }

  private void onMouseOut(ComponentEvent ce) {
    El target = ce.getTarget("td.x-date-active", 3);
    if (target == null) {
      target = ce.getTarget("td.x-date-nextday", 3);
    }
    if (target == null) {
      target = ce.getTarget("td.x-date-prevday", 3);
    }
    if (target == null) {
      target = ce.getTarget("td.x-date-mp-month", 3);
    }
    if (target == null) {
      target = ce.getTarget("td.x-date-mp-year", 3);
    }
    if (target != null) {
      target.removeStyleName("x-date-active-hover");
    }

  }

  private void onMouseOver(ComponentEvent ce) {
    El target = ce.getTarget("td.x-date-active", 3);
    if (target == null) {
      target = ce.getTarget("td.x-date-nextday", 3);
    }
    if (target == null) {
      target = ce.getTarget("td.x-date-prevday", 3);
    }
    if (target == null) {
      target = ce.getTarget("td.x-date-mp-month", 3);
    }
    if (target == null) {
      target = ce.getTarget("td.x-date-mp-year", 3);
    }
    if (target != null) {
      target.addStyleName("x-date-active-hover");
    }

  }

  private void selectToday() {
    setValue(new DateWrapper().asDate());
  }

  private void setCellStyle(Element cell, Date d, long sel, long min, long max) {
    long t = d.getTime();

    DateWrapper w = new DateWrapper(d);
    int year = w.getFullYear();
    int month = w.getMonth();
    int day = w.getDate();

    String dd = year + "," + month + "," + day;

    El cellEl = new El(cell);
    cellEl.firstChild().dom.setPropertyString("dateValue", dd);
    if (t == today) {
      cellEl.addStyleName("x-date-today");
      cellEl.setTitle(messages.getTodayText());
    }
    if (t == sel) {
      cellEl.addStyleName("x-date-selected");
    }
    if (t < min) {
      cellEl.addStyleName("x-date-disabled");
      cellEl.setTitle(messages.getMinText());
    }
    if (t > max) {
      cellEl.addStyleName("x-date-disabled");
      cellEl.setTitle(messages.getMaxText());
    }
  }

  private void showMonthPicker() {
    createMonthPicker();

    Size s = el().getSize(true);
    s.height -= 2;
    monthPicker.setTop(1);
    monthPicker.setSize(s.width, s.height);
    monthPicker.firstChild().setSize(s.width, s.height, true);

    mpSelMonth = (activeDate != null ? activeDate : value).getMonth();

    updateMPMonth(mpSelMonth);
    mpSelYear = (activeDate != null ? activeDate : value).getFullYear();
    updateMPYear(mpSelYear);

    monthPicker.enableDisplayMode("block");
    monthPicker.makePositionable(true);
    monthPicker.slideIn(Direction.DOWN, FxConfig.NONE);

  }

  private void showNextMonth() {
    update(activeDate.addMonths(1));
  }

  private void showPrevMonth() {
    update(activeDate.addMonths(-1));
  }

  private void update(DateWrapper date) {
    DateWrapper vd = activeDate;
    activeDate = date;
    if (vd != null && el() != null) {
      if (vd.getMonth() == activeDate.getMonth()
          && vd.getFullYear() == activeDate.getFullYear()) {

      }
      int days = date.getDaysInMonth();
      DateWrapper firstOfMonth = date.getFirstDayOfMonth();
      int startingPos = firstOfMonth.getDayInWeek() - firstDOW;

      if (startingPos <= startDay) {
        startingPos += 7;
      }

      DateWrapper pm = activeDate.addMonths(-1);
      int prevStart = pm.getDaysInMonth() - startingPos;

      days += startingPos;

      DateWrapper d = new DateWrapper(pm.getFullYear(), pm.getMonth(), prevStart).clearTime();
      today = new DateWrapper().clearTime().getTime();
      long sel = activeDate.clearTime().getTime();
      long min = minDate != null ? new DateWrapper(minDate).getTime() : Long.MIN_VALUE;
      long max = maxDate != null ? new DateWrapper(maxDate).getTime() : Long.MAX_VALUE;

      int i = 0;
      for (; i < startingPos; i++) {
        fly(textNodes[i]).update("" + ++prevStart);
        d = d.addDays(1);
        cells[i].setClassName("x-date-prevday");
        setCellStyle(cells[i], d.asDate(), sel, min, max);
      }
      for (; i < days; i++) {
        int intDay = i - startingPos + 1;
        fly(textNodes[i]).update("" + intDay);
        d = d.addDays(1);
        cells[i].setClassName("x-date-active");
        setCellStyle(cells[i], d.asDate(), sel, min, max);
      }
      int extraDays = 0;
      for (; i < 42; i++) {
        fly(textNodes[i]).update("" + ++extraDays);
        d = d.addDays(1);
        cells[i].setClassName("x-date-nextday");
        setCellStyle(cells[i], d.asDate(), sel, min, max);
      }

      int month = activeDate.getMonth();
      monthBtn.setText(constants.standaloneMonths()[month] + " "
          + activeDate.getFullYear());
    }
  }

  private void updateMPMonth(int month) {
    for (int i = 0; i < mpMonths.getCount(); i++) {
      Element elem = mpMonths.item(i);
      int xmonth = elem.getPropertyInt("xmonth");
      fly(elem).setStyleName("x-date-mp-sel", xmonth == month);
    }
  }

  private void updateMPYear(int year) {
    mpyear = year;

    for (int i = 1; i <= 10; i++) {
      El td = new El(mpYears.item(i - 1));
      int y2;
      if (i % 2 == 0) {
        y2 = (int) (year + (Math.round(i * .5)));
        td.firstChild().update("" + y2);
        td.dom.setPropertyInt("xyear", y2);
      } else {
        y2 = (int) (year - (5 - Math.round(i * .5)));
        td.firstChild().update("" + y2);
        td.dom.setPropertyInt("xyear", y2);
      }
      fly(mpYears.item(i - 1)).setStyleName("x-date-mp-sel", y2 == year);
    }
  }
}
