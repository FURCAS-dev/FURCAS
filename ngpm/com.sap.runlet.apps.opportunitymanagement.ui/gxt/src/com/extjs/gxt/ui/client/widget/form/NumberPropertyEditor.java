/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.i18n.client.constants.NumberConstants;

/**
 * <code>PropertyEditory</code> that uses a {@link NumberFormat}. When
 * converting a Number to a String, if a format has not been specified, toString
 * will be called on the passed Number. When converting from a String to a
 * Number, the number type ({@link #setType(Class)} will be used to determine
 * the new number instance type.
 * 
 * <pre><code>
 * NumberPropertyEditor editor = new NumberPropertyEditor(Integer.class);
 * </code></pre>
 * 
 * @see NumberFormat
 */
public class NumberPropertyEditor implements PropertyEditor<Number> {

  protected NumberConstants numbers = (NumberConstants) GWT.create(NumberConstants.class);
  protected NumberFormat format;
  protected String alpahRegex = "[a-zA-Z]";
  protected String currencySymbolRegex = "\\$";
  protected String groupSeparator = numbers.groupingSeparator();
  protected Class<?> type;

  private boolean stripCurrencySymbol;
  private boolean stripAlphas;
  private boolean stripGroupSeparator;

  /**
   * Creates a new number property editor with the default number type (Double).
   */
  public NumberPropertyEditor() {

  }

  /**
   * Creates a new number property editor.
   * 
   * @param type the number class (Short, Integer, Long, Float, Double)
   */
  public NumberPropertyEditor(Class<?> type) {
    this.type = type;
  }

  /**
   * Creates a new number property editor.
   * 
   * @param format the number format
   */
  public NumberPropertyEditor(NumberFormat format) {
    this.format = format;
  }

  /**
   * Creates a new number property editor.
   * 
   * @param pattern the number format pattern
   */
  public NumberPropertyEditor(String pattern) {
    format = NumberFormat.getFormat(pattern);
  }

  public Number convertStringValue(String value) {
    // first try to create a typed value directly from the raw text
    try {
      if (type == Short.class) {
        return Short.valueOf(value);
      } else if (type == Integer.class) {
        return Integer.valueOf(value);
      } else if (type == Long.class) {
        return Long.valueOf(value);
      } else if (type == Float.class) {
        return Float.valueOf(value);
      } else {
        return Double.valueOf(value);
      }
    } catch (Exception e) {
    }

    // second, stip all unwanted characters
    String stripValue = stripValue(value);
    try {
      if (type == Short.class) {
        return Short.valueOf(stripValue);
      } else if (type == Integer.class) {
        return Integer.valueOf(stripValue);
      } else if (type == Long.class) {
        return Long.valueOf(stripValue);
      } else if (type == Float.class) {
        return Float.valueOf(stripValue);
      } else {
        return Double.valueOf(stripValue);
      }
    } catch (Exception e) {
    }

    // third try parsing with the formatter
    if (format != null) {
      Double d = format.parse(value);
      return returnTypedValue(d);
    } else {
      Double d = NumberFormat.getDecimalFormat().parse(value);
      return returnTypedValue(d);
    }
  }

  /**
   * Returns the editor's format.
   * 
   * @return the number format
   */
  public NumberFormat getFormat() {
    return format;
  }

  public String getStringValue(Number value) {
    if (format != null) {
      return format.format(value.doubleValue());
    }
    return value.toString();
  }

  /**
   * Returns the number class.
   * 
   * @return the number class
   */
  public Class<?> getType() {
    return type;
  }

  /**
   * Returns true if alpha characters are being removed.
   * 
   * @return true if alpha characters are being removed
   */
  public boolean isStripAlphas() {
    return stripAlphas;
  }

  /**
   * Returns true if the currency symbol is being removed.
   * 
   * @return true if currency symbol is being removed
   */
  public boolean isStripCurrencySymbol() {
    return stripCurrencySymbol;
  }

  /**
   * Returns true if the group separator is being removed before parsing a
   * string value.
   * 
   * @return true if the group separator is being removed
   */
  public boolean isStripGroupSeparator() {
    return stripGroupSeparator;
  }

  /**
   * Sets the editor's format.
   * 
   * @param format the format
   */
  public void setFormat(NumberFormat format) {
    this.format = format;
  }

  /**
   * True to remove alpha characters when parsing a string value (defaults to
   * false).
   * 
   * @param stripAlphas true to remove all alpha characters
   */
  public void setStripAlphas(boolean stripAlphas) {
    this.stripAlphas = stripAlphas;
  }

  /**
   * True to remove the currency symbol when parsing a string value (defaults to
   * false).
   * 
   * @param stripCurrencySymbol true to the currency symbol
   */
  public void setStripCurrencySymbol(boolean stripCurrencySymbol) {
    this.stripCurrencySymbol = stripCurrencySymbol;
  }

  /**
   * True to remove the group separator, as defined by GWT NumberConstants, when
   * parsing a string value (defaults to false).
   * 
   * @param stripGroupSeparator true to remove the group separator
   */
  public void setStripGroupSeparator(boolean stripGroupSeparator) {
    this.stripGroupSeparator = stripGroupSeparator;
  }

  /**
   * Sets the number type used when converting a string to a number.
   * 
   * @param type the type (Short, Integer, Long, Float, Double)
   */
  public void setType(Class<?> type) {
    this.type = type;
  }

  protected Number returnTypedValue(Number number) {
    if (type == Short.class) {
      return number.shortValue();
    } else if (type == Integer.class) {
      return number.intValue();
    } else if (type == Long.class) {
      return number.longValue();
    } else if (type == Float.class) {
      return number.floatValue();
    }
    return number;
  }

  protected String stripValue(String value) {
    if (stripCurrencySymbol) {
      value = value.replaceAll(currencySymbolRegex, "");
    }
    if (stripAlphas) {
      value = value.replaceAll(alpahRegex, "");
    }
    if (stripGroupSeparator) {
      value = value.replaceAll(groupSeparator, "");
    }
    return value;
  }

}