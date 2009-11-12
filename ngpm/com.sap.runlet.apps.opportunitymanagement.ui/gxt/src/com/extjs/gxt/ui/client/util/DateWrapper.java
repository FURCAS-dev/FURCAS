/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import java.util.Date;

import com.extjs.gxt.ui.client.GXT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * Provides a useful set of date related functions without using any deprecated
 * APIs.
 * 
 * Instances of this class are immutable and as such any mutation methods return
 * new DateWrapper instances.
 */
public class DateWrapper {

  /**
   * Represents the different unit values that the
   * {@link DateWrapper#add(Unit, int)} method takes
   */
  public enum Unit {
    MILLI("ms"), SECOND("s"), MINUTE("mi"), HOUR("h"), DAY("d"), MONTH("mo"), YEAR("y");
    private final String jsCode;

    private Unit(String jsCode) {
      this.jsCode = jsCode;
    }
  }

  static {
    GXT.init();
  }

  protected static String format(float date, String format) {
    long d = new Float(date).longValue();
    return DateTimeFormat.getFormat(format).format(new Date(d));
  }

  /**
   * GWT introduced long emulation to support true 64 bit longs, however this
   * means that long can't be used over jsni.. must use double
   */
  private static native JavaScriptObject createDate(double time) /*-{
       return new Date(time);
     }-*/;

  /**
   * GWT introduced long emulation to support true 64 bit longs, however this
   * means that long can't be used over jsni.. must use double
   */
  private static native JavaScriptObject createDate(int year, int month, int day) /*-{
     return new Date(year, month, day);
   }-*/;

  // the wrapped javascript Date instance
  final JavaScriptObject jsDate;

  /**
   * Creates a new instance with the current time.
   */
  public DateWrapper() {
    this(System.currentTimeMillis());
  }

  /**
   * Creates a new instance with the given date.
   * 
   * @param date the date
   */
  public DateWrapper(Date date) {
    this(date.getTime());
  }

  /**
   * Creates a new instance with the given values.
   * 
   * @param year the year
   * @param month the month
   * @param day the day
   */
  public DateWrapper(int year, int month, int day) {
    this(createDate(year, month, day));
  }

  /**
   * Creates a new instance with the given time in milliseconds.
   * 
   * @param time the time in milliseconds
   */
  public DateWrapper(long time) {
    this(createDate(time));
  }

  private DateWrapper(JavaScriptObject jso) {
    jsDate = jso;
  }

  /**
   * Provides a convenient method of performing basic date arithmetic. This
   * method does not modify the DateWrapper instance being called - it creates
   * and returns a new DateWrapper instance containing the resulting date value.
   * 
   * @see #addMillis(int)
   * @see #addSeconds(int)
   * @see #addMinutes(int)
   * @see #addHours(int)
   * @see #addDays(int)
   * @see #addMonths(int)
   * @see #addYears(int)
   * 
   * @param unit the {@link Unit}
   * @param quantity the quantity to add
   * 
   * @return the new DateWrapper
   */
  public DateWrapper add(Unit unit, int quantity) {
    return new DateWrapper(addInternal(unit.jsCode, quantity));
  }

  /**
   * Returns a new DateWrapper with days added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with days added
   */
  public DateWrapper addDays(int days) {
    return add(Unit.DAY, days);
  }

  /**
   * Returns a new DateWrapper with hours added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with hours added
   */
  public DateWrapper addHours(int hours) {
    return add(Unit.HOUR, hours);
  }

  /**
   * Returns a new DateWrapper with millis added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with millis added
   */
  public DateWrapper addMillis(int millis) {
    return add(Unit.MILLI, millis);
  }

  /**
   * Returns a new DateWrapper with minutes added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with minutes added
   */
  public DateWrapper addMinutes(int minutes) {
    return add(Unit.MINUTE, minutes);
  }

  /**
   * Returns a new DateWrapper with months added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with months added
   */
  public DateWrapper addMonths(int months) {
    return add(Unit.MONTH, months);
  }

  /**
   * Returns a new DateWrapper with seconds added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with seconds added
   */
  public DateWrapper addSeconds(int seconds) {
    return add(Unit.SECOND, seconds);
  }

  /**
   * Returns a new DateWrapper with years added
   * 
   * @see #add(DateWrapper.Unit, int)
   * @return a new DateWrapper with years added
   */
  public DateWrapper addYears(int years) {
    return add(Unit.YEAR, years);
  }

  /**
   * Returns a new Date instance
   * 
   * @return a new Date instance
   */
  public Date asDate() {
    return new Date(getTime());
  }

  public boolean before(DateWrapper dateWrapper) {
    return dateWrapper == null || getTime() < dateWrapper.getTime();
  }

  /**
   * Returns a new instance with the time portion
   * (hours/minutes/seconds/milliseconds) cleared.
   * 
   * @return a new instance with the time portion
   *         (hours/minutes/seconds/milliseconds) cleared.
   */
  public DateWrapper clearTime() {
    return new DateWrapper(clearTimeInternal());
  }

  public DateWrapper clone() {
    return new DateWrapper(getTime());
  }

  /**
   * Returns the day of the month
   * 
   * @return the day of the month
   */
  public int getDate() {
    return (int) call("getDate");
  }

  /**
   * Returns the day of the week
   * 
   * @return the day of the week
   */
  public int getDay() {
    return (int) call("getDay");
  }

  /**
   * Returns the day of the week
   * 
   * @return the day of the week
   */
  public int getDayInWeek() {
    return (int) call("getDay");
  }

  /**
   * Returns the day of the year
   * 
   * @return the day of the year
   */
  public int getDayOfYear() {
    return (int) call("getDayOfYear");
  }

  /**
   * Returns the number of days in the month.
   * 
   * @return the number of days in the month.
   */
  public int getDaysInMonth() {
    return (int) call("getDaysInMonth");
  }

  /**
   * Returns the first date of the month.
   * 
   * @return the first date of the month.
   */
  public DateWrapper getFirstDayOfMonth() {
    return callAndWrap("getFirstDateOfMonth");
  }

  /**
   * Returns the full year
   * 
   * @return the full year
   */
  public int getFullYear() {
    return (int) call("getFullYear");
  }

  /**
   * Returns the hour
   * 
   * @return the hour
   */
  public int getHours() {
    return (int) call("getHours");
  }

  /**
   * Returns the last date of the month.
   * 
   * @return the last date of the month.
   */
  public DateWrapper getLastDateOfMonth() {
    return callAndWrap("getLastDateOfMonth");
  }

  /**
   * Returns the milliseconds
   * 
   * @return the milliseconds
   */
  public int getMilliseconds() {
    return (int) call("getMilliseconds");
  }

  /**
   * Returns the minutes
   * 
   * @return the minutes
   */
  public int getMinutes() {
    return (int) call("getMinutes");
  }

  /**
   * Returns the month
   * 
   * @return the month
   */
  public int getMonth() {
    return (int) call("getMonth");
  }

  /**
   * Returns the seconds
   * 
   * @return the seconds
   */
  public int getSeconds() {
    return (int) call("getSeconds");
  }

  /**
   * Returns the time in milliseconds.
   * 
   * @return the time in milliseconds
   */
  public long getTime() {
    return (long) call("getTime");
  }

  @Override
  public String toString() {
    return asDate().toString();
  }

  /**
   * GWT introduced long emulation to support true 64 bit longs, however this
   * means that long can't be used over jsni.. must use double
   */
  private native JavaScriptObject addInternal(String interval, double value) /*-{
     return this.@com.extjs.gxt.ui.client.util.DateWrapper::jsDate.add(interval, value);
   }-*/;

  /**
   * GWT introduced long emulation to support true 64 bit longs, however this
   * means that long can't be used over jsni.. must use double
   */
  private native double call(String method) /*-{
     var d = this.@com.extjs.gxt.ui.client.util.DateWrapper::jsDate;
     return d[method]();
   }-*/;

  private DateWrapper callAndWrap(String method) {
    return new DateWrapper((long) callGetTime(method));
  }

  /**
   * GWT introduced long emulation to support true 64 bit longs, however this
   * means that long can't be used over jsni.. must use double
   */
  private native double callGetTime(String method) /*-{
     var d = this.@com.extjs.gxt.ui.client.util.DateWrapper::jsDate;
     return d[method]().getTime();
   }-*/;

  /**
   * GWT introduced long emulation to support true 64 bit longs, however this
   * means that long can't be used over jsni.. must use double
   */
  private native JavaScriptObject clearTimeInternal() /*-{
     return this.@com.extjs.gxt.ui.client.util.DateWrapper::jsDate.clearTime(true);
   }-*/;

}
