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

/**
 * Represents an "Externalized" String
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ExternalizedString {

	/**
	 * Simple message parameter replacement, using English locale
	 * 
	 * @param args
	 *            the arguments for parameter replacement
	 * @return the formatted String
	 */
	public String format(Object... args);
}
