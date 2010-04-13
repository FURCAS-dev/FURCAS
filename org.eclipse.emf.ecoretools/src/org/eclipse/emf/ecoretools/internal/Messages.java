/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: Messages.java,v 1.1 2008/05/19 09:26:31 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.emf.ecoretools.internal.messages"; //$NON-NLS-1$

	public static String Activator_Error;

	public static String AnalysisView_InvalidSelection;

	public static String EClassHierarchyView_Ascendant;

	public static String EClassHierarchyView_Descendant;

	public static String EClassHierarchyView_InvalidSelection;

	public static String EClassHierarchyView_RefreshHierarchy;

	public static String EReferencesView_InvalidSelection;

	public static String EReferencesView_RefreshReferences;

	public static String NewEcoreProjectWizard_CaseSensitive_warning;

	public static String NewEcoreProjectWizard_CreationProblems;

	public static String NewEcoreProjectWizard_EcoreProject_description;

	public static String NewEcoreProjectWizard_EcoreProject_title;

	public static String NewEcoreProjectWizard_InternalError;

	public static String NewEcoreProjectWizard_NewEcoreProject;

	public static String RefreshAction_Refresh;

	public static String RefreshAction_Refresh_description;

	public static String RefreshAction_Refresh_tooltip;

	public static String ToggleSynchronizeAction_Synchronize;

	public static String ToggleSynchronizeAction_Synchronize_description;

	public static String ToggleSynchronizeAction_Synchronize_tooltip;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
