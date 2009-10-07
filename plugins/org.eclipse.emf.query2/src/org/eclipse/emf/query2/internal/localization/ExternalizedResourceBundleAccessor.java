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
package org.eclipse.emf.query2.internal.localization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.eclipse.emf.query2.exception.ExternalizedString;


/**
 * A class loader-backed ResourceBundle access class
 * <p>
 * This is tailored for use in generated {@link ExternalizedString}
 * implementations and holds a reference to the English bundle
 */
public class ExternalizedResourceBundleAccessor {

	private final String resourceBundleName;

	private ResourceBundle myBundle;

	private final ClassLoader classLoader;

	/**
	 * @param accessorClass
	 */
	@SuppressWarnings("unchecked")
	public ExternalizedResourceBundleAccessor(Class accessorClass) {

		this.resourceBundleName = accessorClass.getName();
		this.classLoader = accessorClass.getClassLoader();
	}

	/**
	 * Formats the message using {@link Locale#ENGLISH}.
	 * <p>
	 * There is no Exception handling in this method.
	 * 
	 * @param bundleKey
	 * @param args
	 * @return the formatted message
	 */
	public String format(String bundleKey, Object... args) {

		// TODO is this the right way for synchronization?
		synchronized (this) {

			if (this.myBundle == null) {

				this.myBundle = ResourceBundle.getBundle(this.resourceBundleName, Locale.ENGLISH, this.classLoader);

			}
			String pattern = this.myBundle.getString(bundleKey);

			if (args != null && args.length > 0) {
				MessageFormat format = new MessageFormat(pattern, Locale.ENGLISH);
				return format.format(args);
			}
			return pattern;
		}

	}

	/**
	 * Return the unformatted message
	 * 
	 * @param bundleKey
	 * @return the message
	 */
	public String getMessageText(String bundleKey) {

		// TODO is this the right way for synchronization?
		synchronized (this) {

			if (this.myBundle == null) {

				this.myBundle = ResourceBundle.getBundle(this.resourceBundleName, Locale.ENGLISH, this.classLoader);

			}
			return this.myBundle.getString(bundleKey);

		}

	}
}
