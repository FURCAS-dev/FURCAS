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

package org.eclipse.emf.query.internal.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 * 
 * @author Christian Vogt (cvogt)
 */
public class QueryMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.emf.query.internal.l10n.QueryMessages"; //$NON-NLS-1$

	public static String QueryStatement_Executing_Query____1_INFO_;

	static {
		NLS.initializeMessages(BUNDLE_NAME, QueryMessages.class);
	}
}
