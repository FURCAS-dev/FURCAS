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
 * Base class for all localized MOIN exceptions
 */
public abstract class LocalizedBaseException extends BaseException {

	private static final long serialVersionUID = 1L;

	/**
	 * in the case of serialization, we have to fall back on the English message
	 */
	private transient LocalizedString myLocalized;

	/**
	 * in the case of serialization, we have to fall back on the English message
	 */
	private transient Object[] myParameters = null;

	private LocalizedBaseException root;

	private MessageFormat myFormat = null;

	/**
	 * @param rootCause
	 *            see {@link Exception#getCause()}
	 */
	public LocalizedBaseException(LocalizedBaseException rootCause) {

		super(rootCause);
		this.root = rootCause;
	}

	/**
	 * @param localizable
	 *            the {@link LocalizedString}
	 * @param parameters
	 *            for replacement
	 */
	public LocalizedBaseException(LocalizedString localizable, Object... parameters) {

		super(localizable, parameters);
		this.myLocalized = localizable;
		this.myParameters = parameters;

	}

	/**
	 * @param rootCause
	 *            see {@link Throwable#initCause(Throwable)}
	 * @param localizable
	 *            the {@link LocalizedString}
	 * @param parameters
	 *            parameters for replacement
	 */
	public LocalizedBaseException(Throwable rootCause, LocalizedString localizable, Object... parameters) {

		super(rootCause, localizable, parameters);
		this.myLocalized = localizable;
		this.myParameters = parameters;
	}

	/**
	 * The corresponding interface is not yet here
	 * 
	 * @param locale
	 *            the requested {@link Locale}
	 * @return the localized message
	 */
	public String getLocalizedMessage(Locale locale) {

		if (this.myLocalized == null) {
			if (this.root == null) {
				return getMessage();
			}
			return this.root.getLocalizedMessage(locale);

		}

		String pattern = this.myLocalized.getLocalizedMessage(locale);
		if (this.myParameters == null || this.myParameters.length == 0) {
			return pattern;
		}

		if (this.myFormat == null) {
			this.myFormat = new MessageFormat(pattern, locale);
		} else {
			this.myFormat.setLocale(locale);
			this.myFormat.applyPattern(pattern);
		}
		return this.myFormat.format(this.myParameters);
	}

	@Override
	public String getLocalizedMessage() {

		return getLocalizedMessage(MoinLocaleProvider.getInstance().getCurrentLocale());
	}

	/**
	 * This is overridden, since {@link Throwable#toString()} uses
	 * {@link #getLocalizedMessage()}. As {@link #toString()} is in turn used by
	 * {@link #printStackTrace()}, we would end up with localized Stack traces
	 * otherwise.
	 */
	@Override
	public String toString() {

		String s = getClass().getName();
		String message = getMessage();
		return (message != null) ? (s + ": " + message) : s; //$NON-NLS-1$
	}

}
