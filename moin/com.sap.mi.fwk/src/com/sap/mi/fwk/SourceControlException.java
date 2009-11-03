package com.sap.mi.fwk;

import org.eclipse.core.runtime.IStatus;

/**
 * @author D020964
 * 
 *         The <code>SourceControlException</code> is thrown when preparing a
 *         MOIN command execution fails because source repository operations
 *         fail.
 * 
 */
public class SourceControlException extends Exception {

	/**
     * 
     */
	private static final long serialVersionUID = 6369838389570510251L;

	private IStatus status;

	public SourceControlException(IStatus status) {
		this.status = status;
	}

	/**
	 * @return The method returns a IStatus object describing what went wrong on
	 *         performing source repository operations
	 */
	public IStatus getStatus() {
		return status;
	}
}
