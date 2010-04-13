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

import java.util.Locale;

import org.eclipse.emf.query2.exception.LocalizedString;
import org.eclipse.emf.query2.internal.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>
 * Localized Messages in alphabetical order:
 * <ol>
 * <li>PROCESS_EXCEPTION_XMSG: An internal Exception was thrown, original
 * message "{0}"</li>
 * <li>PROCESS_ERROR_XMSG: Error : {0}</li>
 * <li>PROCESS_ERROR_LOC_XMSG: Error from line {0} and column {1} to line {2}
 * and column {3} : {4}</li>
 * <li>PROCESS_REPORT_XMSG: Finished with {0} errors and {1} warnings.</li>
 * <li>PROCESS_WARNING_XMSG: Warning : {0}</li>
 * <li>PROCESS_WARNING_LOC_XMSG: Warning from line {0} and column {1} to line
 * {2} and column {3} : {4}</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from ProcessMessages.properties
 */

public enum ProcessMessages implements LocalizedString {

	/**
	 * Message:
	 * "Error from line {0} and column {1} to line {2} and column {3} : {4}"
	 */
	PROCESS_ERROR_LOC("PROCESS_ERROR_LOC_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Error : {0}"
	 */
	PROCESS_ERROR("PROCESS_ERROR_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "An internal Exception was thrown, original message "{0}""
	 */
	PROCESS_EXCEPTION("PROCESS_EXCEPTION_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Finished with {0} errors and {1} warnings."
	 */
	PROCESS_REPORT("PROCESS_REPORT_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "Warning from line {0} and column {1} to line {2} and column {3} : {4}"
	 */
	PROCESS_WARNING_LOC("PROCESS_WARNING_LOC_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Warning : {0}"
	 */
	PROCESS_WARNING("PROCESS_WARNING_XMSG"); //$NON-NLS-1$

	private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor(ProcessMessages.class);

	private final String myKey;

	private ProcessMessages(String bundleKey) {

		this.myKey = bundleKey;
	}

	public String format(Object... args) {

		return ACCESSOR.format(this.myKey, args);
	}

	public String getLocalizedMessage(Locale locale) {

		try {
			return ACCESSOR.getMessageText(locale, this.myKey);
		} catch (RuntimeException e) {
			return "Localization failed for ResourceBundle " + ProcessMessages.class.getName() + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
		}
	}

}