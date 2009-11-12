/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.DateWrapper;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * Provides a time input field with a time dropdown and automatic time
 * validation.
 * 
 * <p />
 * The model used by TimeField is @link {@link Time}. An instance of Time is
 * used with {@link #setValue} and {@link #getValue}. Use
 * {@link #setDateValue(Date)} and {@link #getDateValue()} to work with Dates.
 * When using dates, the Time instance will match exact matches of hours and
 * Minutes and will match times between to entries.
 * 
 * Code Snippet.
 * 
 * <pre>
 * TimeField field = new TimeField();
 * 
 * DateWrapper wrap = new DateWrapper();
 * wrap = wrap.clearTime();
 * wrap.addHours(4);
 * 
 * field.setMinValue(wrap.asDate());
 * field.setDateValue(new Date());
 * 
 * Time time = field.getValue();
 * Date d = time.getDate();
 * 
 * Time match = field.findModel(new Date());
 * field.setValue(match);
 * </pre>
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Expand</b> : FieldEvent(field)<br>
 * <div>Fires when the dropdown list is expanded.</div>
 * <ul>
 * <li>field : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Collapse</b> : FieldEvent(field)<br>
 * <div>Fires when the dropdown list is collapsed.</div>
 * <ul>
 * <li>field : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeSelect</b> : FieldEvent(field)<br>
 * <div>Fires before a list item is selected.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Select</b> : FieldEvent(field)<br>
 * <div>Fires when a list item is selected.</div>
 * <ul>
 * <li>field : this</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>Field Focus</dd>
 * <dd>Field Blur</dd>
 * <dd>Field Change</dd>
 * <dd>Field Invalid</dd>
 * <dd>Field Valid</dd>
 * <dd>Field KeyPress</dd>
 * <dd>Field SpecialKey</dd>
 * <dd>TriggerField TriggerClick</dd>
 * </dl>
 * 
 * @see Time
 */
public class TimeField extends ComboBox<Time> {

  /**
   * TimeField error messages.
   */
  public class TimeFieldMessages extends ComboBoxMessages {

    private String minText;
    private String maxText;

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
     * Sets the error text to display when the time in the field is invalid
     * (defaults to '{value} is not a valid time - it must be in the format
     * {format}').
     * 
     * @param invalidText the invalid text
     */
    public void setInvalidText(String invalidText) {
      super.setInvalidText(invalidText);
    }

    /**
     * Sets the error text to display when the time is after maxValue (defaults
     * to 'The time in this field must be equal to or before {0}').
     * 
     * @param maxText the max text
     */
    public void setMaxText(String maxText) {
      this.maxText = maxText;
    }

    /**
     * Sets the error text to display when the date in the cell is before
     * minValue (defaults to 'The time in this field must be equal to or after
     * {0}').
     * 
     * @param minText the min text
     */
    public void setMinText(String minText) {
      this.minText = minText;
    }

  }

  /**
   * The number of minutes between each time value in the list (defaults to 15).
   */
  private int increment = 15;

  /**
   * The date time format used to format each entry (defaults to
   * {@link DateTimeFormat#getShortDateFormat()}.
   */
  private DateTimeFormat format = DateTimeFormat.getShortTimeFormat();

  private Date minValue;
  private Date maxValue;
  private boolean initialized;

  /**
   * Creates a new time field.
   */
  public TimeField() {
    setMessages(new TimeFieldMessages());
  }

  /**
   * Returns the matching Time for the given date.
   * 
   * @param date the date
   * @return the matching model or null if no match
   */
  public Time findModel(Date date) {
    if (!initialized) initList();
    DateWrapper w = new DateWrapper();
    DateWrapper w2 = new DateWrapper(date);

    w = w.clearTime();
    w = w.addHours(w2.getHours());
    w = w.addMinutes(w2.getMinutes());

    long l = w.getTime();

    List<Time> times = store.getModels();
    for (int i = 0; i < times.size(); i++) {
      Time t1 = store.getAt(i);
      Time t2 = store.getAt(i + 1);

      if (t2 == null) {
        DateWrapper temp = new DateWrapper();
        temp = temp.clearTime();
        temp = temp.addMinutes(t1.getMinutes() + increment);
        temp = temp.addHours(t1.getHour());
        t2 = new Time(temp.asDate());
      }

      long l1 = t1.getDate().getTime();
      long l2 = t2.getDate().getTime();

      if (l >= l1 && l < l2) {
        return t1;
      }
    }
    return null;
  }

  /**
   * Return the matching Time for the given time.
   * 
   * @param hours the hours
   * @param minutes the minutes
   * @return the matching model or null if no match
   */
  public Time findModel(int hours, int minutes) {
    DateWrapper w = new DateWrapper();
    w = w.clearTime();
    w = w.addHours(hours);
    w = w.addMinutes(minutes);
    return findModel(w.asDate());
  }

  /**
   * Returns the current date value.
   * 
   * @return the value
   */
  public Date getDateValue() {
    if (!initialized) initList();
    Time value = getValue();
    if (value != null) {
      return value.getDate();
    }
    return null;
  }

  /**
   * Returns the date time format.
   * 
   * @return the date time format
   */
  public DateTimeFormat getFormat() {
    return format;
  }

  /**
   * Returns the number of minutes between each time value.
   * 
   * @return the increment
   */
  public int getIncrement() {
    return increment;
  }

  /**
   * Returns the field's max value.
   * 
   * @return the max value
   */
  public Date getMaxValue() {
    return maxValue;
  }

  @Override
  public TimeFieldMessages getMessages() {
    return (TimeFieldMessages) messages;
  }

  /**
   * Returns the fields minimum value.
   * 
   * @return the min value
   */
  public Date getMinValue() {
    return minValue;
  }

  /**
   * Sets the field's value from a date.
   * 
   * @param date the date
   */
  public void setDateValue(Date date) {
    if (!initialized) initList();
    Time t = findModel(date);
    if (t != null) {
      setValue(t);
    }
  }

  /**
   * Sets the date time format used to format each entry (defaults to
   * {@link DateTimeFormat#getShortDateFormat()}.
   * 
   * @param format the date time format
   */
  public void setFormat(DateTimeFormat format) {
    this.format = format;
  }

  /**
   * Sets the number of minutes between each time value in the list (defaults to
   * 15).
   * 
   * @param increment the increment
   */
  public void setIncrement(int increment) {
    this.increment = increment;
  }

  /**
   * Sets the field's max value.
   * 
   * @param value the max value
   */
  public void setMaxValue(Date value) {
    this.maxValue = value;
  }

  /**
   * The minimum allowed time (no default value).
   * 
   * @param value the min date
   */
  public void setMinValue(Date value) {
    this.minValue = value;
  }

  @Override
  protected void initList() {
    initialized = true;
    DateWrapper min = minValue != null ? new DateWrapper(minValue) : new DateWrapper(
        1970, 1, 1);
    if (minValue == null) {
      min = min.clearTime();
    }

    DateWrapper max = maxValue != null ? new DateWrapper(maxValue) : new DateWrapper(
        1970, 1, 1);
    if (maxValue == null) {
      max = max.clearTime().addMinutes((24 * 60) - 1);
    }

    List<Time> times = new ArrayList<Time>();
    while (min.before(max)) {
      times.add(new Time(min.asDate(), getFormat().format(min.asDate())));
      min = min.addMinutes(increment);
    }

    ListStore<Time> store = new ListStore<Time>();
    store.add(times);

    setStore(store);
    setDisplayField("text");
    super.initList();
  }
}
