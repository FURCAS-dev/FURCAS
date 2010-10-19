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
package org.eclipse.emf.query2.exception;

import java.text.MessageFormat;
import java.util.Locale;

import org.eclipse.emf.query2.internal.localization.MoinLocaleProvider;


/**
 * Thrown if a required parameter is null
 */
public class IllegalNullArgumentException extends ParameterizedIllegalArgumentException {

	private static final long serialVersionUID = 1L;

	private final Object[] myParameterName;

	/**
	 * Message: "Parameter "{0}" must not be null"
	 * 
	 * @param parameterName
	 *            argument 0
	 */
	public IllegalNullArgumentException(String parameterName) {

		super(ExceptionWrapperMessages.PARAMETERMUSTNOTBENULL.format(parameterName));
		this.myParameterName = new Object[] { parameterName };

	}

	@Override
	public String getLocalizedMessage() {

		Locale locale = MoinLocaleProvider.getInstance().getCurrentLocale();
		MessageFormat format = new MessageFormat(ExceptionWrapperMessages.PARAMETERMUSTNOTBENULL.getLocalizedMessage(locale), locale);
		return format.format(this.myParameterName);
	}

	/**
	 * See
	 * {@link org.eclipse.emf.query2.exception.LocalizedBaseException#toString()}
	 * for an explanation of this
	 */
	@Override
	public String toString() {

		String s = getClass().getName();
		String message = getMessage();
		return (message != null) ? (s + ": " + message) : s; //$NON-NLS-1$
	}

	/**
	 * Convenience method for checking if a parameter is <code>null</code>.
	 * 
	 * @param parameterName
	 *            the name of the parameter
	 * @param parameter
	 *            the parameter to be checked
	 * @throw {@link IllegalNullArgumentException} if <code>parameter</code>
	 *        is <code>null</code>
	 */
	public static final void check(String parameterName, Object parameter) {

		if (parameter == null) {
			throw new IllegalNullArgumentException(parameterName);
		}
	}
}
