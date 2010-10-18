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
 * The {@link ParameterizedIllegalArgumentException} wrapper
 */
public class ParameterizedIllegalArgumentException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	private transient LocalizedString myMessage;

	private transient Object[] myArgs;

	/**
	 * Message: {@link ExceptionWrapperMessages#ILLEGALARGUMENT}
	 * 
	 * @param argumentName
	 *            argument 0
	 */
	public ParameterizedIllegalArgumentException(String argumentName) {

		super(ExceptionWrapperMessages.ILLEGALARGUMENT.format(argumentName));
		this.myMessage = ExceptionWrapperMessages.ILLEGALARGUMENT;
		this.myArgs = new Object[] { argumentName };
	}

	/**
	 * Message: {@link ExceptionWrapperMessages#ILLEGALARGUMENT}
	 * 
	 * @param argumentName
	 *            argument 0
	 * @param illegalArgumentValue
	 *            argument 1
	 */
	public ParameterizedIllegalArgumentException(String argumentName, Object illegalArgumentValue) {

		super(ExceptionWrapperMessages.ILLEGALARGUMENT.format(argumentName, String.valueOf(illegalArgumentValue)));
		this.myMessage = ExceptionWrapperMessages.ILLEGALARGUMENT;
		this.myArgs = new Object[] { argumentName };
	}

	/**
	 * Message: {@link ExceptionWrapperMessages#ILLEGAL_ARGUMENT_METHOD_VALUE}
	 * 
	 * @param methodName
	 *            argument 0
	 * @param argumentName
	 *            argument 1
	 * @param illegalArgumentValue
	 *            argument 2
	 */
	public ParameterizedIllegalArgumentException(String methodName, String argumentName, Object illegalArgumentValue) {

		super(ExceptionWrapperMessages.ILLEGAL_ARGUMENT_METHOD_VALUE.format(methodName, argumentName, String.valueOf(illegalArgumentValue)));
		this.myMessage = ExceptionWrapperMessages.ILLEGAL_ARGUMENT_METHOD_VALUE;
		this.myArgs = new Object[] { argumentName };
	}

	/**
	 * Generic constructor
	 * 
	 * @param message
	 *            {@link LocalizedString}
	 * @param args
	 *            arguments
	 */
	public ParameterizedIllegalArgumentException(LocalizedString message, Object... args) {

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
	public ParameterizedIllegalArgumentException(Throwable rootCause, LocalizedString message, Object... args) {

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
