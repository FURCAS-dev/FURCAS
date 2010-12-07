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

import org.eclipse.emf.query2.exception.LocalizedString;


/**
 * <p>
 * <p>
 * Localized Messages in alphabetical order:
 * <ol>
 * <li>LocaleProviderInitializedOnce_XMSG: MoinLocaleProvider can only be
 * initialized once</li>
 * <li>TypeNotDirectSubtype_XMSG: Type "{0}" is not a direct subtype of "{1}"</li>
 * <li>TypeIsNotDirectSubtype_XMSG: Type '{0}' is not direct subtype of '{1}'</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from MoinApiMessages.properties
 */

public enum MoinApiMessages implements LocalizedString {

	/**
	 * Message: "MoinLocaleProvider can only be initialized once"
	 */
	LOCALEPROVIDERINITIALIZEDONCE("LocaleProviderInitializedOnce_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Type '{0}' is not direct subtype of '{1}'"
	 */
	TYPEISNOTDIRECTSUBTYPE("TypeIsNotDirectSubtype_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Type "{0}" is not a direct subtype of "{1}""
	 */
	TYPENOTDIRECTSUBTYPE("TypeNotDirectSubtype_XMSG"); //$NON-NLS-1$

	private final static class LocalizedResourceBundleAccessor {

		private final String resourceBundleName;

		private final HashMap<Locale, ResourceBundle> bundles = new HashMap<Locale, ResourceBundle>(2);

		private final ClassLoader classLoader;

		/**
		 * @param accessorClass
		 */
		@SuppressWarnings("unchecked")
		LocalizedResourceBundleAccessor(Class accessorClass) {

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
		String getMessageText(Locale locale, String bundleKey) {

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
		String format(String bundleKey, Object... args) {

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

	private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor(MoinApiMessages.class);

	private final String myKey;

	private MoinApiMessages(String bundleKey) {

		this.myKey = bundleKey;
	}

	public String format(Object... args) {

		return ACCESSOR.format(this.myKey, args);
	}

	public String getLocalizedMessage(Locale locale) {

		try {
			return ACCESSOR.getMessageText(locale, this.myKey);
		} catch (RuntimeException e) {
			return "Localization failed for ResourceBundle " + MoinApiMessages.class.getName() + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
		}
	}

}