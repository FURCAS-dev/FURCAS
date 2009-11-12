/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.util.Format;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.i18n.client.constants.NumberConstants;
import com.google.gwt.user.client.Element;

/**
 * Numeric text field that provides automatic keystroke filtering and numeric
 * validation.
 * 
 * <p>
 * When the field wraps any thing other than Double, either
 * {@link #setPropertyEditorType(Class)} or
 * {@link #setPropertyEditor(PropertyEditor)} should be called with the
 * appropriate number type.
 * 
 * <code><pre>
 * NumberField&lt;Integer&gt; field = new NumberField&lt;Integer&gt;;
 * field.setPropertyEdtiorType(Integer.class);
 * </pre></code>
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
 * </dl>
 */
public class NumberField extends TextField<Number> {

  /**
   * NumberField messages.
   */
  public class NumberFieldMessages extends TextFieldMessages {
    private String maxText;
    private String minText;
    private String nanText;
    private String negativeText = GXT.MESSAGES.numberField_negativeText();
    
    /**
     * Returns the max error text.
     * 
     * @return the error text
     */
    public String getMaxText() {
      return maxText;
    }

    /**
     * Returns the minimum error text.
     * 
     * @return the minimum error text
     */
    public String getMinText() {
      return minText;
    }
    
    /**
     * Returns the not a number error text.
     * 
     * @return the not a number error text
     */
    public String getNanText() {
      return nanText;
    }

    /**
     * Returns the negative error text.
     * 
     * @return the error text
     */
    public String getNegativeText() {
      return negativeText;
    }

    /**
     * Error text to display if the maximum value validation fails (defaults to
     * "The maximum value for this field is {maxValue}").
     * 
     * @param maxText the max error text
     */
    public void setMaxText(String maxText) {
      this.maxText = maxText;
    }

    /**
     * Sets the Error text to display if the minimum value validation fails
     * (defaults to "The minimum value for this field is {minValue}").
     * 
     * @param minText min error text
     */
    public void setMinText(String minText) {
      this.minText = minText;
    }

    /**
     * Sets the error text to display if the value is not a valid number. For
     * example, this can happen if a valid character like '.' or '-' is left in
     * the field with no number (defaults to "{value} is not a valid number").
     * 
     * @param nanText the not a number text
     */
    public void setNanText(String nanText) {
      this.nanText = nanText;
    }

    /**
     * Sets the negative error text (defaults to 'The value must be greater or
     * equal to 0').
     * 
     * @param negativeText the error text
     */
    public void setNegativeText(String negativeText) {
      this.negativeText = negativeText;
    }
  }

  private boolean allowDecimals = true;
  private List<Character> allowed;
  private boolean allowNegative = true;
  private String baseChars = "0123456789";
  private NumberConstants constants = (NumberConstants) GWT.create(NumberConstants.class);
  private String decimalSeparator = ".";
  private int lastKeyCode;
  private Number maxValue = Double.MAX_VALUE;
  private Number minValue = Double.NEGATIVE_INFINITY;

  /**
   * Creates a new number field.
   */
  public NumberField() {
    messages = new NumberFieldMessages();
    propertyEditor = new NumberPropertyEditor();
    decimalSeparator = constants.decimalSeparator();
  }

  /**
   * Returns true of decimal values are allowed.
   * 
   * @return the allow decimal state
   */
  public boolean getAllowDecimals() {
    return allowDecimals;
  }

  /**
   * Returns true if negative values are allowed.
   * 
   * @return the allow negative value state
   */
  public boolean getAllowNegative() {
    return allowNegative;
  }

  /**
   * Returns the base characters.
   * 
   * @return the base characters
   */
  public String getBaseChars() {
    return baseChars;
  }

  /**
   * Returns the field's number format.
   * 
   * @return the number format
   */
  public NumberFormat getFormat() {
    return getPropertyEditor().getFormat();
  }

  /**
   * Returns the fields max value.
   * 
   * @return the max value
   */
  public Number getMaxValue() {
    return maxValue;
  }

  @Override
  public NumberFieldMessages getMessages() {
    return (NumberFieldMessages) messages;
  }

  /**
   * Returns the field's minimum value.
   * 
   * @return the min value
   */
  public Number getMinValue() {
    return minValue;
  }

  @Override
  public NumberPropertyEditor getPropertyEditor() {
    return (NumberPropertyEditor) propertyEditor;
  }

  /**
   * Returns the number property editor number type.
   * 
   * @see NumberPropertyEditor#setType(Class)
   * @return the number type
   */
  public Class<?> getPropertyEditorType() {
    return getPropertyEditor().getType();
  }

  /**
   * Sets whether decimal value are allowed (defaults to true).
   * 
   * @param allowDecimals true to allow negative values
   */
  public void setAllowDecimals(boolean allowDecimals) {
    this.allowDecimals = allowDecimals;
  }

  /**
   * Sets whether negative value are allowed.
   * 
   * @param allowNegative true to allow negative values
   */
  public void setAllowNegative(boolean allowNegative) {
    this.allowNegative = allowNegative;
  }

  /**
   * Sets the base set of characters to evaluate as valid numbers (defaults to
   * '0123456789').
   * 
   * @param baseChars the base character
   */
  public void setBaseChars(String baseChars) {
    assertPreRender();
    this.baseChars = baseChars;
  }

  /**
   * Sets the cell's number formatter.
   * 
   * @param format the format
   */
  public void setFormat(NumberFormat format) {
    getPropertyEditor().setFormat(format);
  }

  /**
   * Sets the field's max allowable value.
   * 
   * @param maxValue the max value
   */
  public void setMaxValue(Number maxValue) {
    this.maxValue = maxValue.doubleValue();
  }

  /**
   * Sets the field's minimum allowed value.
   * 
   * @param minValue the min value
   */
  public void setMinValue(Number minValue) {
    this.minValue = minValue.doubleValue();
  }

  /**
   * Specifies the number type used when converting a String to a Number
   * instance (defaults to Double).
   * 
   * @param type the number type (Short, Integer, Long, Float, Double).
   */
  public void setPropertyEditorType(Class<?> type) {
    getPropertyEditor().setType(type);
  }

  @Override
  protected void onKeyDown(FieldEvent fe) {
    super.onKeyDown(fe);
    // must key code in key code as gwt returns character in key press
    lastKeyCode = fe.getKeyCode();
  }

  @Override
  protected void onKeyPress(FieldEvent fe) {
    super.onKeyPress(fe);
    char key = (char) fe.getKeyCode();

    if (fe.isSpecialKey(lastKeyCode) || lastKeyCode == KeyCodes.KEY_BACKSPACE
        || lastKeyCode == KeyCodes.KEY_DELETE || fe.isControlKey()) {
      return;
    }

    if (!allowed.contains(key)) {
      fe.stopEvent();
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    allowed = new ArrayList<Character>();
    for (int i = 0; i < baseChars.length(); i++) {
      allowed.add(baseChars.charAt(i));
    }

    if (allowNegative) {
      allowed.add('-');
    }
    if (allowDecimals) {
      for (int i = 0; i < decimalSeparator.length(); i++) {
        allowed.add(decimalSeparator.charAt(i));
      }
    }
  }

  @Override
  protected boolean validateValue(String value) {
    // validator should run after super rules
    Validator tv = validator;
    validator = null;
    if (!super.validateValue(value)) {
      validator = tv;
      return false;
    }
    validator = tv;
    if (value.length() < 1) { // if it's blank and textfield didn't flag it then
      // its valid it's valid
      return true;
    }

    String v = value;

    Number d = null;
    try {
      d = getPropertyEditor().convertStringValue(v);
    } catch (Exception e) {
      //TODO
      System.out.println(e);
      String error = "";
      if (getMessages().getNanText() == null) {
        error = GXT.MESSAGES.numberField_nanText(v);
      } else {
        error = Format.substitute(getMessages().getNanText(), v);
      }
      markInvalid(error);
      return false;
    }
    if (d.doubleValue() < minValue.doubleValue()) {
      String error = "";
      if (getMessages().getMinText() == null) {
        error = GXT.MESSAGES.numberField_minText(minValue.doubleValue());
      } else {
        error = Format.substitute(getMessages().getMinText(), minValue);
      }
      markInvalid(error);
      return false;
    }

    if (d.doubleValue() > maxValue.doubleValue()) {
      String error = "";
      if (getMessages().getMaxText() == null) {
        error = GXT.MESSAGES.numberField_maxText(maxValue.doubleValue());
      } else {
        error = Format.substitute(getMessages().getMaxText(), maxValue);
      }
      markInvalid(error);
      return false;
    }
    
    if (!allowNegative && d.doubleValue() < 0) {
      markInvalid(getMessages().getNegativeText());
      return false;
    }
    
    if (validator != null) {
      String msg = validator.validate(this, value);
      if (msg != null) {
        markInvalid(msg);
        return false;
      }
    }

    return true;
  }
}
