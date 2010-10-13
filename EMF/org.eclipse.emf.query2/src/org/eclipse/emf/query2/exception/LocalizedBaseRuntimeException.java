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
 * The Base class for all localized MOIN Runtime exceptions
 */
public class LocalizedBaseRuntimeException extends BaseRuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * in the case of serialization, we have to fall back on the English message
	 */
	private transient LocalizedString myLocalizable;

	/**
	 * in the case of serialization, we have to fall back on the English message
	 */
	private transient Object[] myParameters = null;

	private LocalizedBaseException myRoot;

	private LocalizedBaseRuntimeException myRtRoot;

	private transient MessageFormat myFormat = null;

	/**
	 * @param localizable
	 *            the root cause
	 */
	public LocalizedBaseRuntimeException(LocalizedBaseException localizable) {

		super(localizable);
		this.myRoot = localizable;
	}

	/**
	 * @param localizable
	 *            the root cause, see {@link Throwable#initCause(Throwable)}
	 */
	public LocalizedBaseRuntimeException(LocalizedBaseRuntimeException localizable) {

		super(localizable);
		this.myRtRoot = localizable;
	}

	/**
	 * @param localizable
	 *            the {@link LocalizedString}
	 * @param parameters
	 *            for replacement
	 */
	public LocalizedBaseRuntimeException(LocalizedString localizable, Object... parameters) {

		super(localizable, parameters);
		this.myLocalizable = localizable;
		this.myParameters = parameters;

	}

	/**
	 * @param rootCause
	 *            see {@link Throwable#initCause(Throwable)}
	 * @param localizable
	 *            the {@link LocalizedString}
	 * @param parameters
	 *            for replacement
	 */
	public LocalizedBaseRuntimeException(Throwable rootCause, LocalizedString localizable, Object... parameters) {

		super(rootCause, localizable, parameters);
		this.myLocalizable = localizable;
		this.myParameters = parameters;
	}

	/**
	 * @param locale
	 *            the requested {@link Locale}
	 * @return the localized message
	 */
	public String getLocalizedMessage(Locale locale) {

		if (this.myLocalizable == null) {
			if (this.myRoot != null) {
				this.myRoot.getLocalizedMessage(locale);
			} else if (this.myRtRoot != null) {
				this.myRtRoot.getLocalizedMessage(locale);
			}
			return getMessage();
		}

		String pattern = this.myLocalizable.getLocalizedMessage(locale);
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
