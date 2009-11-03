package com.sap.mi.fwk.ui.internal.editor;

import org.eclipse.ui.IEditorPart;

/**
 * An operation running with an editor
 */
public interface IRunnableWithEditor {
	/**
	 * Executes the operation
	 * 
	 * @param part
	 *            the editor
	 */
	void run(IEditorPart part);

}
