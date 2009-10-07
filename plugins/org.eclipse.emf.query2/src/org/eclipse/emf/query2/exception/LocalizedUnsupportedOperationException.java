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
 * The {@link UnsupportedOperationException} wrapper
 */
public class LocalizedUnsupportedOperationException extends UnsupportedOperationException {

	private static final long serialVersionUID = 1L;

	private transient LocalizedString myMessage;

	private transient Object[] myArgs;

	/**
	 * Message: "Operation "{0}" is not supported"
	 * 
	 * @param operationName
	 *            argument 0
	 */
	public LocalizedUnsupportedOperationException(String operationName) {

		super(ExceptionWrapperMessages.UNSUPPORTEDOPERATION.format(operationName));
		this.myMessage = ExceptionWrapperMessages.UNSUPPORTEDOPERATION;
		this.myArgs = new Object[] { operationName };
	}

	/**
	 * Generic constructor
	 * 
	 * @param message
	 *            {@link LocalizedString}
	 * @param args
	 *            arguments
	 */
	public LocalizedUnsupportedOperationException(LocalizedString message, Object... args) {

		super(message.format(args));
		this.myMessage = message;
		this.myArgs = args;
	}

	@Override
	public String getLocalizedMessage() {

		if (this.myMessage != null) {
			Locale locale = MoinLocaleProvider.getInstance().getCurrentLocale();
			if (this.myArgs != null && this.myArgs.length > 0) {
				MessageFormat format = new MessageFormat(this.myMessage.getLocalizedMessage(locale), locale);
				return format.format(this.myArgs);
			}
			return this.myMessage.getLocalizedMessage(locale);
		}
		return getMessage();

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

}
