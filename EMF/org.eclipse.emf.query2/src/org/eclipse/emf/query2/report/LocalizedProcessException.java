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
package org.eclipse.emf.query2.report;

import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.exception.LocalizedString;

/**
 * Used to report problems
 */
public class LocalizedProcessException extends LocalizedBaseRuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param localizable
	 * @param parameters
	 */
	public LocalizedProcessException(LocalizedString localizable, Object... parameters) {

		super(localizable, parameters);
	}

}
