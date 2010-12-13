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
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * A class loader-backed ResourceBundle access class
 * <p>
 * Keeps a Locale/ResourceBundle map to avoid repeated lookups for the same
 * Locale.
 * <p>
 * Note that this does not do any Exception handling whatsoever, so callers or
 * {@link #getMessageText(Locale, String)} should handle Exceptions by
 * themselves.
 */
public class LocalizedResourceBundleAccessor {

	private final String resourceBundleName;

	private final HashMap<Locale, ResourceBundle> bundles = new HashMap<Locale, ResourceBundle>(2);

	private final ClassLoader classLoader;

	/**
	 * @param accessorClass
	 */
	@SuppressWarnings("unchecked")
	public LocalizedResourceBundleAccessor(Class accessorClass) {

		this.resourceBundleName = accessorClass.getName();
		this.classLoader = accessorClass.getClassLoader();
	}

	/**
	 * @param locale
	 *            the requested {@link Locale}
	 * @param bundleKey
	 *            the key in the {@link ResourceBundle}
	 * @return the localized message
	 */
	public String getMessageText(Locale locale, String bundleKey) {

		synchronized (this.bundles) {

			ResourceBundle rb = this.bundles.get(locale);

			if (rb == null) {

				rb = ResourceBundle.getBundle(this.resourceBundleName, locale, this.classLoader);

				this.bundles.put(locale, rb);
				return rb.getString(bundleKey);

			}
			return rb.getString(bundleKey);

		}

	}

	/**
	 * Formats the message in English.
	 * <p>
	 * There is no Exception handling in this method.
	 * 
	 * @param bundleKey
	 * @param args
	 * @return the formatted message
	 */
	public String format(String bundleKey, Object... args) {

		synchronized (this.bundles) {

			String pattern = this.getMessageText(Locale.ENGLISH, bundleKey);

			if (args != null && args.length > 0) {
				MessageFormat format = new MessageFormat(pattern, Locale.ENGLISH);
				return format.format(args);
			}
			return pattern;
		}

	}
}
