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
 * $Id: Messages.java,v 1.2 2009/05/06 13:54:18 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.ui.outline.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.emf.ecoretools.diagram.ui.outline.internal.messages"; //$NON-NLS-1$

	public static String AbstractDiagramsOutlinePage_CanNotOpenEditor;

	public static String AbstractDiagramsOutlinePage_LinkWithEditor;

	public static String AbstractDiagramsOutlinePage_ShowBoth;

	public static String AbstractDiagramsOutlinePage_ShowNavigator;

	public static String AbstractDiagramsOutlinePage_ShowOverview;

	public static String AbstractModelNavigator_NewChild;

	public static String AbstractModelNavigator_NewSibling;

	public static String AbstractValidationMarkerReader_MarkerNotExist;

	public static String AbstractValidationMarkerReader_ValidationProblems;

	public static String CollapseAllAction_CollapseAll;

	public static String CreateDiagramAction_CreateNewDiagram;

	public static String CreateDiagramAction_DialogCreateNewDiagram;

	public static String CreateDiagramAction_DialogDefaultDiagramName;

	public static String CreateDiagramAction_DialogDiagramName;

	public static String DeleteDiagramAction_DeleteDiagram;

	public static String DuplicateDiagramAction_Duplicated;

	public static String DuplicateDiagramAction_DuplicateDiagram;

	public static String NavigatorLabelProvider_AdditionalResources;

	public static String NavigatorLabelProvider_DiagramDefaultName;
	
	public static String RenameDiagramAction_NewName;

	public static String RenameDiagramAction_RenameDiagram;

	public static String RenameDiagramAction_RenameExistingDiagram;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
