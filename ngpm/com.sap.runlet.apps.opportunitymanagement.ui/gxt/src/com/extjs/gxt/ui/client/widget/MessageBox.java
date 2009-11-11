/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.HashMap;
import java.util.Map;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.Element;

/**
 * Utility class for generating different styles of message boxes.
 * 
 * <p>
 * Note that the MessageBox is asynchronous. Unlike a regular JavaScript
 * <code>alert</code> (which will halt browser execution), showing a MessageBox
 * will not cause the code to stop.
 * </p>
 */
public class MessageBox {

  /**
   * MessageBox type enumeration.
   */
  public enum MessageBoxType {
    ALERT, CONFIRM, PROMPT, MULTIPROMPT, PROGRESSS, WAIT
  }

  /**
   * Button constant that displays a single OK button.
   */
  public static final String OK = Dialog.OK;

  /**
   * Button constant that displays a single CANCEL button.
   */
  public static final String CANCEL = Dialog.CANCEL;

  /**
   * Button constant that displays a OK and CANCEL button.
   */
  public static final String OKCANCEL = Dialog.OKCANCEL;

  /**
   * Button constant that displays a YES and NO button.
   */
  public static final String YESNO = Dialog.YESNO;

  /**
   * Button constant that displays a YES, NO, and CANCEL button.
   */
  public static final String YESNOCANCEL = Dialog.YESNOCANCEL;

  /**
   * The CSS style name that provides the INFO icon image.
   */
  public static String INFO = "ext-mb-info";

  /**
   * The CSS style name that provides the WARNING icon image.
   */
  public static String WARNING = "ext-mb-warning";

  /**
   * The CSS style name that provides the QUESTION icon image.
   */
  public static String QUESTION = "ext-mb-question";

  /**
   * The CSS style name that provides the ERROR icon image.
   */
  public static String ERROR = "ext-mb-error";

  /**
   * Displays a standard read-only message box with an OK button (comparable to
   * the basic JavaScript alert prompt).
   * 
   * @param title the title bar text
   * @param msg the message box body text
   * @param callback listener to be called when the box is closed
   * @return the new message box instance
   */
  public static MessageBox alert(String title, String msg, Listener<MessageBoxEvent> callback) {
    MessageBox box = new MessageBox();
    box.setTitle(title);
    box.setMessage(msg);
    box.callback = callback;
    box.setButtons(OK);
    box.icon = WARNING;
    box.show();
    return box;
  }
  
  /**
   * Displays a confirmation message box with Yes and No buttons (comparable to
   * JavaScript's confirm).
   * 
   * @param title the title bar text
   * @param msg the message box body text
   * @param callback the listener invoked after the message box is closed
   * @return the new message box instance
   */
  public static MessageBox confirm(String title, String msg, Listener<MessageBoxEvent> callback) {
    MessageBox box = new MessageBox();
    box.setTitle(title);
    box.setMessage(msg);
    box.callback = callback;
    box.icon = QUESTION;
    box.setButtons(YESNO);
    box.show();
    return box;
  }

  /**
   * Displays a standard read-only message box with an OK button (comparable to
   * the basic JavaScript alert prompt).
   * 
   * @param title the title bar text
   * @param msg the message box body text
   * @param callback listener to be called when the box is closed
   * @return the new message box instance
   */
  public static MessageBox info(String title, String msg, Listener<MessageBoxEvent> callback) {
    MessageBox box = new MessageBox();
    box.setTitle(title);
    box.setMessage(msg);
    box.callback = callback;
    box.setButtons(OK);
    box.icon = INFO;
    box.show();
    return box;
  }

  /**
   * Displays a message box with a progress bar. This message box has no buttons
   * and is not closeable by the user. You are responsible for updating the
   * progress bar as needed via {@link MessageBox#updateProgress}
   * 
   * @param title the title bar text
   * @param msg the message box body text
   * @param progressText the text to display inside the progress bar
   * @return the new message box
   */
  public static MessageBox progress(String title, String msg, String progressText) {
    MessageBox box = new MessageBox();
    box.setTitle(title);
    box.setMessage(msg);
    box.setType(MessageBoxType.PROGRESSS);
    box.setProgressText(progressText);
    box.setButtons("");
    box.setClosable(false);
    box.show();
    return box;
  }

  /**
   * Displays a message box with OK and Cancel buttons prompting the user to
   * enter some text (comparable to JavaScript's prompt).
   * 
   * @param title the title bar text
   * @param msg the message box body text
   * @return the new message box
   */
  public static MessageBox prompt(String title, String msg) {
    return prompt(title, msg, false, null);
  }
  
  /**
   * Displays a message box with OK and Cancel buttons prompting the user to
   * enter some text (comparable to JavaScript's prompt).
   * 
   * @param title the title bar text
   * @param msg the message box body text
   * @param multiline true for a multi-line text aread
   * @return the new message box
   */
  public static MessageBox prompt(String title, String msg, boolean multiline) {
    return prompt(title, msg, multiline, null);
  }

  /**
   * Displays a message box with OK and Cancel buttons prompting the user to
   * enter some text (comparable to JavaScript's prompt).
   * 
   * @param title the title bar text
   * @param msg the message box body text
   * @param multiline true for a multi-line text aread
   * @return the new message box
   */
  public static MessageBox prompt(String title, String msg, boolean multiline, Listener<MessageBoxEvent> callback) {
    MessageBox box = new MessageBox();
    box.setTitle(title);
    box.setMessage(msg);
    box.setType(MessageBoxType.PROMPT);
    box.setButtons(Dialog.OKCANCEL);
    box.setType(multiline ? MessageBoxType.MULTIPROMPT : MessageBoxType.PROMPT);
    if (callback != null) {
      box.addCallback(callback);
    }
    box.show();
    return box;
  }
  
  /**
   * Displays a message box with OK and Cancel buttons prompting the user to
   * enter some text (comparable to JavaScript's prompt).
   * 
   * @param title the title bar text
   * @param msg the message box body text
   * @param callback the callback
   * @return the new message box
   */
  public static MessageBox prompt(String title, String msg, Listener<MessageBoxEvent> callback) {
    return prompt(title, msg, false, callback);
  }

  /**
   * Displays a message box with an infinitely auto-updating progress bar. This
   * can be used to block user interaction while waiting for a long-running
   * process to complete that does not have defined intervals. You are
   * responsible for closing the message box when the process is complete.
   * 
   * @param title the title bar text
   * @param msg the message box body text
   * @param progressText the text to display inside the progress bar
   * @return the new message box instance
   */
  public static MessageBox wait(String title, String msg, String progressText) {
    MessageBox box = new MessageBox();
    box.setTitle(title);
    box.setMessage(msg);
    box.setType(MessageBoxType.WAIT);
    box.setProgressText(progressText);
    box.setButtons("");
    box.setClosable(false);
    box.show();
    return box;
  }

  private Listener<MessageBoxEvent> callback;
  private String icon = "";
  private MessageBoxType type;
  private int defaultTextHeight = 75;
  private int maxWidth = 600;
  private int minWidth = 100;
  private boolean modal = true;
  private String progressText = "";
  private int minProgressWidth = 250;
  private String message = "&#160;";
  private boolean closable;
  private String title;
  private String buttons = OK;
  private Dialog dialog;
  private Element iconEl;
  private Element msgEl;
  private ProgressBar progressBar;
  private TextField<String> textBox;
  private TextArea textArea;
  private Map<EventType, Listener<MessageBoxEvent>> listeners;

  /**
   * Adds a listener that will be called when the message box is closed. Note
   * that the listener will be based a MessageBoxEvent.
   * 
   * @param listener the callback listener
   */
  public void addCallback(Listener<MessageBoxEvent> listener) {
    if (dialog == null) {
      if (listeners == null) listeners = new HashMap<EventType, Listener<MessageBoxEvent>>();
      listeners.put(Events.Hide, listener);
    } else {
      dialog.addListener(Events.Hide, listener);
    }
  }

  /**
   * Convenience method to add a listener to the underlying dialog instance.
   * 
   * @param event the event type
   * @param listener the listener
   */
  public void addListener(EventType event, Listener<MessageBoxEvent> listener) {
    if (dialog == null) {
      if (listeners == null) listeners = new HashMap<EventType, Listener<MessageBoxEvent>>();
      listeners.put(event, listener);
    } else {
      dialog.addListener(event, listener);
    }
  }

  /**
   * Closes the message box.
   */
  public void close() {
    if (dialog.isVisible()) {
      dialog.hide();
    }
  }

  /**
   * Returns the buttons.
   * 
   * @return the buttons
   */
  public String getButtons() {
    return buttons;
  }

  /**
   * Returns the default text height.
   * 
   * @return the height
   */
  public int getDefaultTextHeight() {
    return defaultTextHeight;
  }

  /**
   * Returns the underlying window.
   * 
   * @return the window
   */
  public Dialog getDialog() {
    if (dialog == null) {
      dialog = new Dialog() {
        
        @Override
        protected void afterRender() {
          super.afterRender();
          addStyleName("x-window-dlg");

          El body = new El(dialog.getElement("body"));

          String html = "<div class='ext-mb-icon x-hidden'></div><div class=ext-mb-content><span class=ext-mb-text></span><br /></div>";
          body.dom.setInnerHTML(html);

          iconEl = body.firstChild().dom;
          Element contentEl = body.dom.getChildNodes().getItem(1).cast();
          msgEl = contentEl.getFirstChild().cast();
          msgEl.setInnerHTML(message);

          if (type == MessageBoxType.PROMPT) {
            textBox = new TextField<String>();
            dialog.setFocusWidget(textBox);
            textBox.render(contentEl, 2);
            textBox.el().setWidth(GXT.isIE ? "100%" : "90%");
            icon = null;
          }

          if (type == MessageBoxType.MULTIPROMPT) {
            textArea = new TextArea();
            textArea.render(contentEl, 2);
            textArea.el().setWidth(GXT.isIE ? "100%" : "90%");
            dialog.setFocusWidget(textArea);
            icon = null;
          }

          if (type == MessageBoxType.PROGRESSS || type == MessageBoxType.WAIT) {
            progressBar = new ProgressBar();
            progressBar.render(body.dom);
            if (type == MessageBoxType.WAIT) {
              progressBar.auto();
            }
            if (getProgressText() != null) {
              progressBar.updateText(getProgressText());
            }
            icon = null;
          }

          MessageBox.this.setIcon(icon);
        }
        
        @Override
        protected void doAttachChildren(){
          super.doAttachChildren();
          if (type == MessageBoxType.PROMPT) {
            ComponentHelper.doAttach(textBox);
          } else if (type == MessageBoxType.MULTIPROMPT) {
            ComponentHelper.doAttach(textArea);
          } else if(type == MessageBoxType.PROGRESSS || type == MessageBoxType.WAIT) {
            ComponentHelper.doAttach(progressBar);
          }
        }
        
        @Override
        protected void doDetachChildren(){
          super.doDetachChildren();
          if (type == MessageBoxType.PROMPT) {
            ComponentHelper.doDetach(textBox);
          } else if (type == MessageBoxType.MULTIPROMPT) {
            ComponentHelper.doDetach(textArea);
          } else if(type == MessageBoxType.PROGRESSS || type == MessageBoxType.WAIT) {
            ComponentHelper.doDetach(progressBar);
          }
        }
        
        @Override
        protected void initTools() {
          setClosable(closable);
          super.initTools();
        }

        @Override
        protected ComponentEvent previewEvent(EventType type, ComponentEvent ce) {
          if (ce instanceof WindowEvent) {
            WindowEvent we = (WindowEvent) ce;
            MessageBoxEvent e = new MessageBoxEvent(MessageBox.this, this, we.getButtonClicked());
            if (type == Events.Hide || type == Events.BeforeHide) {
              if (textBox != null) {
                e.setValue(textBox.getValue());
              } else if (textArea != null) {
                e.setValue(textArea.getValue());
              }

            }
            return e;
          }
          return super.previewEvent(type, ce);
        }

      };
      dialog.setData("messageBox", true);
      dialog.setHeading(getTitle());
      dialog.setResizable(false);
      dialog.setConstrain(true);
      dialog.setMinimizable(false);
      dialog.setMaximizable(false);
      dialog.setMinWidth(minWidth);
      dialog.setClosable(false);
      dialog.setModal(modal);
      dialog.setButtonAlign(HorizontalAlignment.CENTER);
      dialog.setMinHeight(80);
      dialog.setPlain(true);
      dialog.setFooter(true);
      dialog.setButtons(getButtons());
      dialog.setHideOnButtonClick(true);
      if (callback != null) {
        dialog.addListener(Events.Hide, callback);
      }
      if (getButtons() != null) {
        if (getButtons().contains(Dialog.YES)) {
          dialog.setFocusWidget(dialog.getButtonBar().getItemByItemId(Dialog.YES));
        } else if (getButtons().contains(Dialog.OK)) {
          dialog.setFocusWidget(dialog.getButtonBar().getItemByItemId(Dialog.OK));
        }
      }

      if (listeners != null) {
        for (EventType type : listeners.keySet()) {
          dialog.addListener(type, listeners.get(type));
        }
      }
    }
    return dialog;
  }

  /**
   * Returns the max width.
   * 
   * @return the max width
   */
  public int getMaxWidth() {
    return maxWidth;
  }

  /**
   * Returns the message.
   * 
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Returns the min progress width.
   * 
   * @return the width
   */
  public int getMinProgressWidth() {
    return minProgressWidth;
  }

  /**
   * Returns the min width.
   * 
   * @return the min width
   */
  public int getMinWidth() {
    return minWidth;
  }

  /**
   * Returns the box's progress applies.
   * 
   * @return the progress bar
   */
  public ProgressBar getProgressBar() {
    return progressBar;
  }

  /**
   * Returns the progress text.
   * 
   * @return the progress text
   */
  public String getProgressText() {
    return progressText;
  }

  /**
   * Returns the box's text area.
   * 
   * @return the text area
   */
  public TextArea getTextArea() {
    return textArea;
  }

  /**
   * Returns the box's text box.
   * 
   * @return the text box
   */
  public TextField<String> getTextBox() {
    return textBox;
  }

  /**
   * Returns the title text.
   * 
   * @return the title text
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the message box type.
   * 
   * @return the type
   */
  public MessageBoxType getType() {
    return type;
  }

  /**
   * Hides the message box if it is displayed.
   * 
   * @deprecated use {@link #close()}
   */
  public void hide() {
    close();
  }

  /**
   * Returns true if the hide button is displayed.
   * 
   * @return the closable state
   */
  public boolean isClosable() {
    return closable;
  }

  /**
   * Returns true if modal is enabled.
   * 
   * @return the modal state
   */
  public boolean isModal() {
    return modal;
  }

  /**
   * Returns true if the message box is currently displayed.
   * 
   * @return the visible state
   */
  public boolean isVisible() {
    return dialog != null && dialog.isVisible();
  }

  /**
   * The buttons to display (defaults to OK, pre-render).
   * 
   * @param buttons the buttons
   */
  public void setButtons(String buttons) {
    this.buttons = buttons;
  }

  /**
   * False to hide the top-right close button (defaults to true, pre-render).
   * Note that progress and wait dialogs will ignore this property and always
   * hide the close button as they can only be closed programmatically.
   * 
   * @param closable false to hide the top-right close button
   */
  public void setClosable(boolean closable) {
    this.closable = closable;
  }

  /**
   * The default height in pixels of the message box's multiline textarea if
   * displayed (defaults to 75, pre-render).
   * 
   * @param defaultTextHeight the default text height
   */
  public void setDefaultTextHeight(int defaultTextHeight) {
    this.defaultTextHeight = defaultTextHeight;
  }

  /**
   * Adds the specified icon to the dialog. By default, the class 'ext-mb-icon'
   * is applied for default styling, and the class passed in is expected to
   * supply the background image url. Pass in empty string ('') to clear any
   * existing icon. The following built-in icon classes are supported, but you
   * can also pass in a custom class name:
   * 
   * <pre>
   * MessageBox.INFO
   * MessageBox.WARNING
   * MessageBox.QUESTION
   * MessageBox.ERROR
   * </pre>
   * 
   * @param iconStyle the icon style
   */
  public void setIcon(String iconStyle) {
    this.icon = iconStyle;
    if (iconEl != null) {
      El el = El.fly(iconEl);
      if (iconStyle != null) {
        el.removeStyleName("x-hidden");
        el.replaceStyleName(this.icon, iconStyle);
      } else {
        el.replaceStyleName(this.icon, "x-hidden");
        icon = "";
      }
    }
  }

  /**
   * The maximum width in pixels of the message box (defaults to 600,
   * pre-render).
   * 
   * @param maxWidth the max width
   */
  public void setMaxWidth(int maxWidth) {
    this.maxWidth = maxWidth;
  }

  /**
   * A string that will replace the existing message box body text (defaults to
   * the XHTML-compliant non-breaking space character '&#160;').
   * 
   * @param message the message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * The minimum width in pixels of the message box if it is a progress-style
   * dialog. This is useful for setting a different minimum width than text-only
   * dialogs may need (defaults to 250).
   * 
   * @param minProgressWidth the min progress width
   */
  public void setMinProgressWidth(int minProgressWidth) {
    this.minProgressWidth = minProgressWidth;
  }

  /**
   * The minimum width in pixels of the message box (defaults to 100,
   * pre-render).
   * 
   * @param minWidth the min width
   */
  public void setMinWidth(int minWidth) {
    this.minWidth = minWidth;
  }

  /**
   * False to allow user interaction with the page while the message box is
   * displayed (defaults to true, pre-render).
   * 
   * @param modal true for modal
   */
  public void setModal(boolean modal) {
    this.modal = modal;
  }

  /**
   * The text to display inside the progress bar if progress = true (defaults to
   * "", pre-render).
   * 
   * @param progressText the progress text
   */
  public void setProgressText(String progressText) {
    this.progressText = progressText;
  }

  /**
   * Sets the title text (pre-render).
   * 
   * @param title the title text
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Sets the message box type (pre-render).
   * 
   * @param type the type
   */
  public void setType(MessageBoxType type) {
    this.type = type;
  }

  /**
   * Displays the message box.
   */
  public void show() {
    dialog = getDialog();
    dialog.show();
  }

  /**
   * Updates a progress-style message box's text and progress bar. Only relevant
   * on message boxes initiated via {@link #progress}.
   * 
   * @param value any number between 0 and 1 (e.g., .5)
   * @param text the progress text to display inside the progress bar or null
   * @return this
   */
  public MessageBox updateProgress(double value, String text) {
    if (progressBar != null) {
      progressBar.updateProgress(value, text);
    }
    return this;
  }

  /**
   * Updates the message box body text.
   * 
   * @param text the new text or null to clear
   * @return this
   */
  public MessageBox updateText(String text) {
    msgEl.setInnerHTML(text != null ? text : "&#160;");
    return this;
  }

}