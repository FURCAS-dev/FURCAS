/**
 * <copyright>
 * 
 * Copyright (c) 2008 Zeligsoft Inc. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Zeligsoft - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: Messages.java,v 1.1 2008/11/26 18:33:55 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.internal.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * Localized messages for the examples plug-in.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.emf.ocl.examples.internal.l10n.messages"; //$NON-NLS-1$

	public static String AbstractExampleWizard_unzipping;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		super();
	}
}
