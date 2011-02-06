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

import java.util.HashSet;
import java.util.Set;

/**
 * Base exception for EMF Runtime exceptions.
 */
public abstract class BaseRuntimeException extends RuntimeException {

	private final static String ASSERT_NUMPARS = "Number of message parameters doesn't match number of arguments"; //$NON-NLS-1$

	private final static String ASSERT_NOEX = "Exceptions can not be used as message parameter"; //$NON-NLS-1$

	/**
	 * @param rootCause
	 *            see {@link RuntimeException#getCause()}
	 */
	public BaseRuntimeException(LocalizedBaseException rootCause) {

		super(rootCause);
	}

	/**
	 * @param rootCause
	 *            see {@link RuntimeException#getCause()}
	 */
	public BaseRuntimeException(LocalizedBaseRuntimeException rootCause) {

		super(rootCause);
	}

	/**
	 * @param rootCause
	 *            see {@link RuntimeException#getCause()}
	 */
	public BaseRuntimeException(BaseException rootCause) {

		super(rootCause);
	}

	/**
	 * @param message
	 *            see {@link RuntimeException#getMessage()}
	 * @param rootCause
	 *            see {@link RuntimeException#getCause()}
	 */
	public BaseRuntimeException(String message, Throwable rootCause) {

		super(message, rootCause);
	}

	/**
	 * @param message
	 *            see {@link RuntimeException#getMessage()}
	 */
	public BaseRuntimeException(String message) {

		super(message);
	}

	/**
	 * @param message
	 *            see {@link Exception#getMessage()}
	 * @param args
	 *            the arguments for message parameter replacement
	 */
	public BaseRuntimeException(ExternalizedString message, Object... args) {

		super(message.format(args));

		assert (parameterCountOk(message, args)) : ASSERT_NUMPARS;

		assert (parameterNoExceptions(args)) : ASSERT_NOEX;

	}

	/**
	 * @param cause
	 *            see {@link Exception#getCause()}
	 * @param message
	 *            see {@link Exception#getMessage()}
	 * @param args
	 *            the arguments for message parameter replacement
	 */
	public BaseRuntimeException(Throwable cause, ExternalizedString message, Object... args) {

		super(message.format(args), cause);

		assert (parameterCountOk(message, args)) : ASSERT_NUMPARS;

		assert (parameterNoExceptions(args)) : ASSERT_NOEX;

	}

	private boolean parameterCountOk(ExternalizedString message, Object... args) {

		String pattern = message.format(new Object[0]);
		int count = 0;
		int lastLeftIndex = 0;
		int index = pattern.indexOf('{', lastLeftIndex);

		Set<Integer> intSet = new HashSet<Integer>();
		// there might be {} that are not intended for parameter replacement (do not have an Integer in between)

		while (index >= 0) {
			int rightIndex = pattern.indexOf('}', index);
			String inbetween;
			try {
				inbetween = pattern.substring(index + 1, rightIndex);
				Integer parIndex = new Integer(inbetween);
				if (intSet.add(parIndex)) {
					count++;
				}
			} catch (Exception e) {
				// $JL-EXC$ we just want to check the inbetween
			}
			lastLeftIndex = index + 1;
			index = pattern.indexOf('{', lastLeftIndex);
		}

		return count == args.length;
	}

	private boolean parameterNoExceptions(Object... args) {

		for (Object arg : args) {
			if (arg instanceof Throwable) {
				return false;
			}
		}
		return true;
	}

	static final long serialVersionUID = -3387516993124229948L;
}