package com.sap.mi.fwk.ui.internal.editor;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Control;

/**
 * Allows for additional actions in case of errors during editor initialization
 * 
 * @author d031150
 */
public interface IRunnableWithError extends Runnable {

	/**
	 * Implementors may perform special actions for visualizing the given error
	 * UI. Multipage editors may e.g. embed the control as a separate page.
	 * 
	 * @param errorUI
	 *            the control that shows the error
	 * @param reason
	 *            the error itself
	 */
	void initWithError(Control errorUI, IStatus reason);

}
