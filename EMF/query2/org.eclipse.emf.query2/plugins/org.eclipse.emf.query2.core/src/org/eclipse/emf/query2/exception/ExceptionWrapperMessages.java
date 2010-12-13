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
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import org.eclipse.emf.query2.exception.LocalizedString;


/**
 * <p>
 * <p>
 * Localized Messages in alphabetical order:
 * <ol>
 * <li>IllegalArgumentValue_XMSG: Argument with name "{0}" has an illegal value
 * "{1}"</li>
 * <li>IllegalArgument_XMSG: Argument with name "{0}" is illegal</li>
 * <li>IndexOutOfBounds_XMSG: Index is outside the legal bounds</li>
 * <li>IndexOutOfBoundsParam_XMSG: Index: {0} Size: {1}</li>
 * <li>Illegal_Argument_Method_Value_XMSG: Method "{0}": Argument with name
 * "{1}" has an illegal value "{2}"</li>
 * <li>UnsupportedOperation_XMSG: Operation "{0}" is not supported</li>
 * <li>ParameterMustNotBeNull_XMSG: Parameter "{0}" must not be null</li>
 * <li>UnsupportedOperationNoArg_XMSG: The called operation is not supported</li>
 * <li>MustOverrideThisAbstractMethod_XMSG: This method must be overridden by a
 * concrete subclass</li>
 * <li>Unknown_Enum_Value_Detected_XMSG: Unable to handle unknown enumeration
 * value of type {0}: {1}</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from ExceptionWrapperMessages.properties
 */

public enum ExceptionWrapperMessages implements LocalizedString {

	/**
	 * Message: "Argument with name "{0}"  has an illegal value "{1}""
	 */
	ILLEGALARGUMENTVALUE("IllegalArgumentValue_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Argument with name "{0}" is illegal"
	 */
	ILLEGALARGUMENT("IllegalArgument_XMSG"), //$NON-NLS-1$

	/**
	 * Message:
	 * "Method "{0}": Argument with name "{1}" has an illegal value "{2}""
	 */
	ILLEGAL_ARGUMENT_METHOD_VALUE("Illegal_Argument_Method_Value_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Index: {0} Size: {1}"
	 */
	INDEXOUTOFBOUNDSPARAM("IndexOutOfBoundsParam_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Index is outside the legal bounds"
	 */
	INDEXOUTOFBOUNDS("IndexOutOfBounds_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "This method must be overridden by a concrete subclass"
	 */
	MUSTOVERRIDETHISABSTRACTMETHOD("MustOverrideThisAbstractMethod_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Parameter "{0}" must not be null"
	 */
	PARAMETERMUSTNOTBENULL("ParameterMustNotBeNull_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Unable to handle unknown enumeration value of type {0}: {1}"
	 */
	UNKNOWN_ENUM_VALUE_DETECTED("Unknown_Enum_Value_Detected_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "The called operation is not supported"
	 */
	UNSUPPORTEDOPERATIONNOARG("UnsupportedOperationNoArg_XMSG"), //$NON-NLS-1$

	/**
	 * Message: "Operation "{0}" is not supported"
	 */
	UNSUPPORTEDOPERATION("UnsupportedOperation_XMSG"); //$NON-NLS-1$

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

	private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor(ExceptionWrapperMessages.class);

	private final String myKey;

	private ExceptionWrapperMessages(String bundleKey) {

		this.myKey = bundleKey;
	}

	public String format(Object... args) {

		return ACCESSOR.format(this.myKey, args);
	}

	public String getLocalizedMessage(Locale locale) {

		try {
			return ACCESSOR.getMessageText(locale, this.myKey);
		} catch (RuntimeException e) {
			return "Localization failed for ResourceBundle " + ExceptionWrapperMessages.class.getName() + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
		}
	}

}