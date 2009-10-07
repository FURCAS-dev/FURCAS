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
package org.eclipse.emf.query2.report;

/**
 * This class represents a warning issued during a process. Warnings are not
 * critical and will not cause the process to fail.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ProcessWarning extends ProcessMessage {

	/**
	 * @return the stack trace if it was set by the application, may be null
	 */
	public StackTraceElement[] getStackTrace();
}