/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.query.examples.statements.internal.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 * 
 * @author Christian Vogt (cvogt)
 */
public class QueryStatementsMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.emf.query.examples.statements.internal.l10n.QueryStatementsMessages"; //$NON-NLS-1$

	public static String title;
	public static String message_interrupted;
	public static String message_exception;
	public static String selectBooks_title;
	public static String selectBooks_inputDialog_message;
	public static String selectBooks_message_notFound;
	public static String selectWriters_title;
	public static String selectWriters_inputDialog_message;
	public static String selectWriters_inputDialog_defaultValue;
	public static String selectWriters_message_notFound;
	public static String selectLargeBooks_title;
	public static String selectLargeBooks_message_notFound;

	static {
		NLS.initializeMessages(BUNDLE_NAME, QueryStatementsMessages.class);
	}
}
