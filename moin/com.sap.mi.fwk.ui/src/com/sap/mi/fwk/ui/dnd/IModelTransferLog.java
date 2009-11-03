package com.sap.mi.fwk.ui.dnd;

import org.eclipse.core.runtime.IStatus;

/**
 * Log available during copy/paste operations executed by {@link ModelClipboard}
 * class. Clients may add status and error information that is supposed to be
 * presented to the user at the end of the operation. <p/> Not intended to be
 * implemented or extended by clients.
 * 
 * @author d031150
 * 
 * @see IModelTransferTarget
 */
public interface IModelTransferLog {

	/**
	 * Appends the given status to this log
	 * 
	 * @param status
	 *            the status to add
	 */
	void add(IStatus status);

	/**
	 * Appends the given exception as error entry to this log
	 * 
	 * @param e
	 *            the exception to add
	 */
	void add(Throwable e);

}
