/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.helper;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.OclEngineStatusCodes;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;


/**
 * Exception indicating that OCL parsing failed.  The status includes
 * human-presentable details.
 *
 * @author Christian W. Damus (cdamus)
 */
public class OclParsingException
	extends CoreException {

	/**
	 * Initializes me with my error message and cause.
	 * 
	 * @param message my error message
	 * @param cause my causing exception
	 */
	public OclParsingException(String message, Throwable cause) {
		super(createStatus(message, cause));
	}

	/**
	 * Initializes me with my error message.
	 * 
	 * @param message my error message
	 */
	public OclParsingException(String message) {
		this(message, null);
	}

	private static IStatus createStatus(String message, Throwable t) {
		if ((message == null) || (message.length() == 0)) {
			message = OclMessages.no_message;
		}
		
		return new Status(
			IStatus.ERROR,
			OclEnginePlugin.getPluginId(),
			OclEngineStatusCodes.ERROR,
			message,
			t);
	}
}
