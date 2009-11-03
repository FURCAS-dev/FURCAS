package com.sap.mi.fwk.ui.editor;

/**
 * Interface is intended to be implemented by client editor which want to be
 * informed about changes in the state of the OCL error decorator configured in
 * Eclipse preferences.
 * 
 * @author d024127
 * 
 */
public interface IDecoratingModelEditor {

	/**
	 * Method is fired when the decorator state changes
	 * 
	 * @param newState
	 *            The current state, true indicates that the user switched on
	 *            the OCL error decoration
	 */
	public void decoratorStateChanged(boolean newState);
}
