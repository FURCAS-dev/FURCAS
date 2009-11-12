/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.DelayedTask;
import com.extjs.gxt.ui.client.util.Format;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.impl.TextBoxImpl;

/**
 * Basic text field. <b>Code snippet</b>:
 * 
 * <pre>
 * TextField&lt;String&gt; text = new TextField&amp;ltString&gt;();
 *     text.setFieldLabel(&quot;Name&quot;);
 *     text.setEmptyText(&quot;Enter your full name&quot;);
 *     text.setAllowBlank(false);
 *     text.setMinLength(4);
 * </pre>
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
 * 
 * @param <D> the data type
 * @see NumberField
 */
public class TextField<D> extends Field<D> {

  /**
   * TextField Messages.
   */
  public class TextFieldMessages extends FieldMessages {

    private String minLengthText;
    private String maxLengthText;
    private String blankText = GXT.MESSAGES.textField_blankText();
    private String regexText = "";

    /**
     * Returns the blank text.
     * 
     * @return the blank text
     */
    public String getBlankText() {
      return blankText;
    }

    /**
     * Returns the max length text.
     * 
     * @return the max length text
     */
    public String getMaxLengthText() {
      return maxLengthText;
    }

    /**
     * Returns the minimum length text.
     * 
     * @return the minimum length text
     */
    public String getMinLengthText() {
      return minLengthText;
    }

    /**
     * Returns the regex text.
     * 
     * @return the regex text
     */
    public String getRegexText() {
      return regexText;
    }

    /**
     * Sets the error text to display if the allow blank validation fails
     * (defaults to "This field is required").
     * 
     * @param blankText the blank text
     */
    public void setBlankText(String blankText) {
      this.blankText = blankText;
    }

    /**
     * Sets the error text to display if the maximum length validation fails
     * (defaults to "The maximum length for this field is {maxLength}").
     * 
     * @param maxLengthText the max length text
     */
    public void setMaxLengthText(String maxLengthText) {
      this.maxLengthText = maxLengthText;
    }

    /**
     * Sets the error text to display if the minimum length validation fails
     * (defaults to "The minimum length for this field is {minLength}").
     * 
     * @param minLengthText the minimum length text
     */
    public void setMinLengthText(String minLengthText) {
      this.minLengthText = minLengthText;
    }

    /**
     * The error text to display if {@link #setRegexText} is used and the test
     * fails during validation.
     * 
     * @param regexText the regex text
     */
    public void setRegexText(String regexText) {
      this.regexText = regexText;
    }

  }

  protected static TextBoxImpl impl = (TextBoxImpl) GWT.create(TextBoxImpl.class);

  protected String emptyStyle = "x-form-empty-field";
  protected Validator validator;

  private boolean password;
  private boolean allowBlank = true;
  private String regex;
  private boolean selectOnFocus;
  private int minLength = 0;
  private int maxLength = Integer.MAX_VALUE;
  private DelayedTask validationTask;

  /**
   * Creates a new text field.
   */
  public TextField() {
    messages = new TextFieldMessages();
  }

  /**
   * Returns the field's allow blank state.
   * 
   * @return true if blank values are allowed
   */
  public boolean getAllowBlank() {
    return allowBlank;
  }

  /**
   * Returns the cursor position.
   * 
   * @return the cursor position
   */
  public int getCursorPos() {
    return impl.getCursorPos(getInputEl().dom);
  }

  /**
   * Returns the field's max length.
   * 
   * @return the max length
   */
  public int getMaxLength() {
    return maxLength;
  }

  @Override
  public TextFieldMessages getMessages() {
    return (TextFieldMessages) messages;
  }

  /**
   * Returns the minimum length.
   * 
   * @return the min length
   */
  public int getMinLength() {
    return minLength;
  }

  /**
   * Returns the field's regex value.
   * 
   * @return the regex value
   */
  public String getRegex() {
    return regex;
  }

  /**
   * Returns the selected text.
   * 
   * @return the selected text
   */
  public String getSelectedText() {
    int start = getCursorPos(), length = getSelectionLength();
    return getRawValue().substring(start, start + length);
  }

  /**
   * Returns the length of the current selection.
   * 
   * @return the selection length
   */
  public int getSelectionLength() {
    return impl.getSelectionLength(getInputEl().dom);
  }

  /**
   * Returns the select of focus state.
   * 
   * @return true if select on focus is enabled
   */
  public boolean getSelectOnFocus() {
    return selectOnFocus;
  }

  /**
   * Returns the field's validator instance.
   * 
   * @return the validator
   */
  public Validator getValidator() {
    return validator;
  }

  /**
   * Returns true if the field is a password field.
   * 
   * @return that password state
   */
  public boolean isPassword() {
    return password;
  }

  /**
   * Selects text in the field.
   * 
   * @param start the index where the selection should start.
   * @param length the number of characters to be selected
   */
  public void select(int start, int length) {
    impl.setSelectionRange(getInputEl().dom, start, length);
  }

  /**
   * Selects all the text.
   */
  public void selectAll() {
    int length = getRawValue().length();
    if (length > 0) {
      select(0, length);
    }
  }

  /**
   * Sets whether a field is value when its value length = 0 (default to true).
   * 
   * @param allowBlank true to allow blanks, false otherwise
   */
  public void setAllowBlank(boolean allowBlank) {
    this.allowBlank = allowBlank;
  }

  /**
   * Sets the cursor position.
   * 
   * @param pos the position
   */
  public void setCursorPos(int pos) {
    setSelectionRange(pos, 0);
  }

  @Override
  public void setEmptyText(String emptyText) {
    removeEmptyText();
    super.setEmptyText(emptyText);
    applyEmptyText();
  }

  /**
   * Sets the maximum input field length.
   * 
   * @param maxLength the max length
   */
  public void setMaxLength(int maxLength) {
    this.maxLength = maxLength;
  }

  /**
   * Minimum input field length required (defaults to 0).
   * 
   * @param minLength the minimum length
   */
  public void setMinLength(int minLength) {
    this.minLength = minLength;
  }

  /**
   * True to create the text field as a password input (defaults to false,
   * pre-render).
   * 
   * @param password the password state
   */
  public void setPassword(boolean password) {
    assertPreRender();
    this.password = password;
  }

  /**
   * Sets regular expression to be tested against the field value during
   * validation. If available, this regex will be evaluated only after the basic
   * validators all return true. If the test fails, the field will be marked
   * invalid using the regex error message.
   * 
   * @param regex the regex expression
   */
  public void setRegex(String regex) {
    this.regex = regex;
  }

  /**
   * Selects the range.
   * 
   * @param pos the position
   * @param length the range length
   */
  public void setSelectionRange(int pos, int length) {
    impl.setSelectionRange(getInputEl().dom, pos, length);
  }

  /**
   * True to automatically select any existing field text when the field
   * receives input focus (defaults to false).
   * 
   * @param selectOnFocus true to focus
   */
  public void setSelectOnFocus(boolean selectOnFocus) {
    this.selectOnFocus = selectOnFocus;
  }

  /**
   * Sets the validator instance to be called during field validation. It will
   * be called only after the basic validators all return true, and will be
   * passed the current field value and expected to return <code>null</code> if
   * the value is valid or a string error message if invalid. Default value is
   * <code>null</code>.
   * 
   * @param validator the validator
   */
  public void setValidator(Validator validator) {
    this.validator = validator;
  }

  @Override
  public void setValue(D value) {
    removeEmptyText();
    super.setValue(value);
    applyEmptyText();
  }

  protected void applyEmptyText() {
    if (rendered && !password && emptyText != null && getRawValue().length() < 1) {
      setRawValue(emptyText);
      getInputEl().addStyleName(emptyStyle);
    }
  }

  @Override
  protected void onBlur(ComponentEvent be) {
    super.onBlur(be);
    applyEmptyText();
  }

  @Override
  protected void onFocus(ComponentEvent be) {
    super.onFocus(be);
    if (emptyText != null) {
      String v = getInputEl().getValue();
      if (emptyText.equals(v)) {
        setRawValue("");
        select(0, 0);
      }
      removeEmptyText();
    }
    if (selectOnFocus) {
      selectAll();
    }
  }

  @Override
  protected void onKeyPress(FieldEvent fe) {
    super.onKeyPress(fe);

  }

  @Override
  protected void onKeyUp(FieldEvent fe) {
    super.onKeyUp(fe);
    if (validationTask != null) {
      validationTask.delay(validationDelay);
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    if (el() == null) {
      if (password) {
        setElement(DOM.createInputPassword());
      } else {
        setElement(DOM.createInputText());
      }

      el().insertInto(target, index);
    }

    super.onRender(target, index);

    if (autoValidate) {
      validationTask = new DelayedTask(new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
          validate();
        }
      });
    }

    // text cell somtimes jumps when in tabe cell on click
    if (GXT.isIE && target.getTagName().equals("TD")) {
      fly(target).makePositionable();
    }

    applyEmptyText();
  }

  protected void removeEmptyText() {
    if (rendered) {
      getInputEl().removeStyleName(emptyStyle);
      if (getRawValue() == "") {
        setRawValue("");
      }
    }
  }

  @Override
  protected boolean validateValue(String value) {
    boolean result = super.validateValue(value);
    if (!result) {
      return false;
    }
    int length = value.length();
    if (value.length() < 1 || value.equals("")) {
      if (allowBlank) {
        clearInvalid();
        return true;
      } else {
        markInvalid(getMessages().getBlankText());
        return false;
      }
    }
    if (length < minLength) {
      String error = "";
      if (getMessages().getMinLengthText() == null) {
        error = GXT.MESSAGES.textField_minLengthText(minLength);
      } else {
        error = Format.substitute(getMessages().getMinLengthText(), minLength);
      }
      markInvalid(error);
      return false;
    }

    if (length > maxLength) {
      String error = "";
      if (getMessages().getMaxLengthText() == null) {
        error = GXT.MESSAGES.textField_maxLengthText(maxLength);
      } else {
        error = Format.substitute(getMessages().getMaxLengthText(), maxLength);
      }
      markInvalid(error);
      return false;
    }

    if (validator != null) {
      String msg = validator.validate(this, value);
      if (msg != null) {
        markInvalid(msg);
        return false;
      }
    }

    if (regex != null && !value.matches(regex)) {
      markInvalid(getMessages().getRegexText());
      return false;
    }

    return true;
  }

}
