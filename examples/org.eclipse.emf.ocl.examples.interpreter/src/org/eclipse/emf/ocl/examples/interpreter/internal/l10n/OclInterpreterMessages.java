/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.examples.interpreter.internal.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 * 
 * @author Christian Vogt (cvogt)
 */
public class OclInterpreterMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.emf.ocl.examples.interpreter.internal.l10n.OclInterpreterMessages"; //$NON-NLS-1$

	public static String console_title;
	public static String console_noContext;
	public static String console_outputExc;
	public static String console_closeAction_label;
	public static String console_closeAction_tip;
	public static String console_evaluating;
	public static String console_results;
	public static String console_saveAction_label;
	public static String console_saveAction_tip;
	public static String console_saveDlg_title;
	public static String console_saveError_title;
	public static String console_saveWarn_title;
	public static String console_saveWarn_noExpr;
	public static String console_loadAction_label;
	public static String console_loadAction_tip;
	public static String console_loadDlg_title;
	public static String console_loadError_title;
	public static String console_loadWarn_title;
	public static String console_loadWarn_noExpr;

	static {
		NLS.initializeMessages(BUNDLE_NAME, OclInterpreterMessages.class);
	}
}
