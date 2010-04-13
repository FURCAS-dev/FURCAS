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
package org.eclipse.emf.query2.internal.logger;


/**
 * Definition of the MOIN-relevant severities.
 * <p>
 * The MOIN severieties maps to the SAP Logging and Tracing severities. For more
 * information, see SAP Logging API and the com.sap.tc.logging.Severity class.
 * 
 * @author d029324
 */

public enum LogSeverity {
	
	/**
	 * The fatal severity.
	 * <p>
	 * The fatal severity should be used to inform about problems that make the
	 * MOIN application not usable.
	 */
	FATAL,

	/**
	 * The error severity.
	 * <p>
	 * The error severity should be used to inform about important problems /
	 * errors, for example prevent the normal execution of particular MOIN
	 * client requests.
	 */
	ERROR,

	/**
	 * The warning severity.
	 * <p>
	 * The warning severity should be used if some potential problem occurs and
	 * the administrator should be inform about this.
	 */
	WARNING,

	/**
	 * The info severity.
	 * <p>
	 * The info severity should be used to inform about some important
	 * application states, events, etc.
	 */
	INFO,

	/**
	 * The path severity.
	 * <p>
	 * The path severity can only be used for trace functionality. It should be
	 * used for messages that reports the program flow.
	 */
	PATH,

	/**
	 * The debug severity.
	 * <p>
	 * The debug severity can only be used for trace functionality. It should
	 * should be used to report messages that contains content relevant trace
	 * information.
	 */
	DEBUG;

}
