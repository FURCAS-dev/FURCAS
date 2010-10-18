/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.jmx;

import java.io.IOException;

import javax.management.openmbean.TabularData;

/**
 * The JMX instrumentation of {@link QueryProcessor} instances.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MqlProcessorMBean {

	/**
	 * The QUERY_PREPARE_START notification.
	 */
	public static final String QUERY_PREPARE_START = "QUERY_PREPARE_START"; //$NON-NLS-1$

	/**
	 * The QUERY_PREPARE_END notification.
	 */
	public static final String QUERY_PREPARE_END = "QUERY_PREPARE_END"; //$NON-NLS-1$

	/**
	 * The QUERY_EXECUTE_START notification.
	 */
	public static final String QUERY_EXECUTE_START = "QUERY_EXECUTE_START"; //$NON-NLS-1$

	/**
	 * The QUERY_EXECUTE_END notification.
	 */
	public static final String QUERY_EXECUTE_END = "QUERY_EXECUTE_END"; //$NON-NLS-1$

	/**
	 * The LEAF_QUERY_EXECUTED notification.
	 */
	public static final String LEAF_QUERY_EXECUTED = "LEAF_QUERY_EXECUTED"; //$NON-NLS-1$

	/**
	 * The MQL_FORMAT_ERROR notification.
	 */
	public static final String MQL_FORMAT_ERROR = "MQL_FORMAT_ERROR"; //$NON-NLS-1$

	/**
	 * All available notifications of this MBean.
	 */
	public static final String[] ALL_NOTIFICATION_TYPES = new String[] { QUERY_PREPARE_START, QUERY_PREPARE_END, QUERY_EXECUTE_START,
			QUERY_EXECUTE_END, LEAF_QUERY_EXECUTED, MQL_FORMAT_ERROR };

	/**
	 * Starts the MQL trace.
	 * 
	 * @throws IOException
	 *             in case of network communication issues
	 */
	@Description("Starts the MQL trace.")
	public void startNotifications() throws IOException;

	/**
	 * Returns whether the MQL trace is currently started.
	 * 
	 * @return whether the MQL trace is currently started
	 * @throws IOException
	 *             in case of network communication issues
	 */
	@Description("Returns whether the MQL trace is currently started.")
	public boolean notificationsStarted() throws IOException;

	/**
	 * Stops the MQL trace.
	 * 
	 * @throws IOException
	 *             in case of network communication issues
	 */
	@Description("Stops the MQL trace.")
	public void stopNotifications() throws IOException;

	/**
	 * Executes an MQL query given as a concrete syntax String.
	 * 
	 * @param mqlString
	 *            the query to execute given as a concrete syntax String
	 * @return a TabularData instance representing either the
	 *         {@link ResultSet} or the error reported by the
	 *         {@link QueryProcessor}
	 * @throws IOException
	 *             in case of network communication issues
	 */
	@Description("Executes an MQL query given as a concrete syntax String.")
	public TabularData query(@ParameterName("mqlConcreteSyntax") String mqlString) throws IOException; //$NON-NLS$
}
