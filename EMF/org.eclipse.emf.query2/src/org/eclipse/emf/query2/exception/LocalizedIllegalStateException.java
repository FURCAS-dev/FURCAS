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
 * Localized {@link IllegalStateException} wrapper
 */
public class LocalizedIllegalStateException extends IllegalStateException {

	private static final long serialVersionUID = 1L;

	private transient LocalizedString myMessage;

	private transient Object[] myArgs;

	/**
	 * Generic constructor
	 * 
	 * @param message
	 *            {@link LocalizedString}
	 * @param args
	 *            arguments
	 */
	public LocalizedIllegalStateException(LocalizedString message, Object... args) {

		super(message.format(args));
		this.myMessage = message;
		this.myArgs = args;
	}

	/**
	 * Generic constructor
	 * 
	 * @param rootCause
	 *            root cause
	 * @param message
	 *            {@link LocalizedString}
	 * @param args
	 *            arguments
	 */
	public LocalizedIllegalStateException(Throwable rootCause, LocalizedString message, Object... args) {

		super(message.format(args), rootCause);

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
