package com.sap.mi.fwk;

import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.tc.moin.repository.Connection;

/**
 * An operation that runs with a {@link Connection MOIN connection}
 * 
 * @author d031150
 */
public interface IRunnableWithConnection {

	/**
	 * Performs the operation
	 * 
	 * @param connection
	 *            the connection to run the operation with
	 * @param monitor
	 *            to provide progress
	 */
	void run(Connection connection, IProgressMonitor monitor);
}