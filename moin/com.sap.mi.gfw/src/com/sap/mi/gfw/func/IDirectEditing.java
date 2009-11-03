package com.sap.mi.gfw.func;

import com.sap.mi.gfw.features.context.IDirectEditingContext;

/**
 * The Interface IDirectEditing.
 */
public interface IDirectEditing {

	/**
	 * no spcial UI is wanted for editing.
	 */
	static final int TYPE_NONE = 0;

	/**
	 * text field is wanted for editing.
	 */
	static final int TYPE_TEXT = 1;

	/**
	 * color chooser is wanted for editing.
	 */
	static final int TYPE_COLOR = 2;

	/**
	 * combo box is wanted for editing.
	 */
	static final int TYPE_DROPDOWN = 3;

	/**
	 * check box is wanted for editing.
	 */
	static final int TYPE_CHECK = 4;

	/**
	 * multi line text box is wanted for editing.
	 */
	static final int TYPE_MULTILINETEXT = 5;

	/**
	 * dialog is wanted for editing.
	 */
	static final int TYPE_DIALOG = 9;

	/**
	 * Framework calls this method to decide which UI to show up.
	 * 
	 * @return the editing type
	 */
	int getEditingType();

	/**
	 * Checks if the feature can perform direct editing on the context handed over.
	 * 
	 * @param context
	 *            the context
	 * @return This method is equivalent to
	 * @see IDirecEditingFeature.canExecute()
	 */
	public boolean canDirectEdit(IDirectEditingContext context);

	/**
	 * Provides the initial value for the opened text editing UI component.
	 * 
	 * @param context
	 *            the context
	 * @return the initial value
	 */
	String getInitialValue(IDirectEditingContext context);

	/**
	 * This value will be used if the cell editor is a combo box. (IDirectEditingFeature.TYPE_DROPDOWN)
	 * 
	 * @param context
	 *            the context
	 * @return the possible values for the combo box.
	 */
	String[] getPossibleValues(IDirectEditingContext context);

	/**
	 * This proposals will be used for the completion list of a simple text cell editor.
	 * 
	 * @param value
	 *            current value
	 * @param caretPosition
	 *            current cursor position
	 * @param context
	 *            the context
	 * @return the proposed values
	 */
	String[] getValueProposals(String value, int caretPosition, IDirectEditingContext context);

	/**
	 * Framework calls this method to let the feature calculate the new value.
	 * 
	 * @param value
	 *            current value
	 * @param caretPosition
	 *            current cursor position
	 * @param choosenValue
	 *            value choosen by user
	 * @param context
	 *            the context
	 * @return the new value
	 */
	String completeValue(String value, int caretPosition, String choosenValue, IDirectEditingContext context);

	/**
	 * Checks if completion is available.
	 * 
	 * @return true if completion is / proposals are available at all
	 */
	boolean isCompletionAvailable();

	/**
	 * Checks if auto completion is enabled.
	 * 
	 * @return true, if proposals should appear automatically
	 */
	boolean isAutoCompletionEnabled();

	/**
	 * Stretch textfield to fit text.
	 * 
	 * @return true if the text field should exactly fit the inserted text (applies only to TYPE_TEXT)
	 */

	boolean stretchTextfieldToFitText();

	/**
	 * This method will be called by clients many times to see if current value is valid and could be set.
	 * 
	 * @param value
	 *            the value
	 * @param context
	 *            the context
	 * @return null if value is okay and could be set; any text means value is not valid; text is reason for invalidality
	 */
	String checkValueValid(String value, IDirectEditingContext context);

	/**
	 * Set the new value. The value comes from the text editing UI component.
	 * 
	 * @param value
	 *            the value
	 * @param context
	 *            the context
	 */
	void setValue(String value, IDirectEditingContext context);
}
