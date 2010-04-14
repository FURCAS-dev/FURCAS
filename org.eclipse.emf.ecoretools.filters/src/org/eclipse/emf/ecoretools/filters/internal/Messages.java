/***********************************************************************
 * Copyright (c) 2007, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: Messages.java,v 1.4 2008/04/29 07:28:53 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal;

import org.eclipse.osgi.util.NLS;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 13 nov. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.emf.ecoretools.filters.internal.messages"; //$NON-NLS-1$

	public static String ConfigureFilter_Dialog_message;

	public static String ConfigureFilter_Dialog_title;

	public static String FilterDiagramCommand_FilterDiagram;

	public static String FilterPlugin_NoDetailsAvailable;

	public static String FilterPlugin_UnableCreateExtension;

	public static String FilterSelectionCommand_FilterSelection;

	public static String FilterSemanticSelectionCommand_FilterSemantic;

	public static String FilterTypeSelectionCommand_FilterType;

	public static String ApplyFilterDiagramAction_ApplyFilter;

	public static String ApplyFilterDiagramAction_ApplyFilter_tooltip;

	public static String ConfigureFilterDiagramAction_Configure;

	public static String ConfigureFilterDiagramAction_Configure_tooltip;

	public static String DiagramFilterActionMenu_FilterElements;

	public static String DiagramFilterActionMenu_FilterElements_tooltip;

	public static String HideInheritanceTypeAction_HideInheritanceLinks;

	public static String HideInheritanceTypeAction_HideInheritanceLinks_tooltip;

	public static String HideReferenceTypeAction_HideReferenceLinks;

	public static String HideReferenceTypeAction_HideReferenceLinks_tooltip;

	public static String HideSelectionAction_HideSelection;

	public static String HideSelectionAction_HideSelection_tooltip;

	public static String HideSemanticAction_HideSemanticModel;

	public static String HideSemanticAction_HideSemanticModel_tooltip;

	public static String HideTypeAction_HideVisualType;

	public static String HideTypeAction_HideVisualType_tooltip;

	public static String ShowHiddenPartAction_ShowAllHiddenParts;

	public static String ShowHiddenPartAction_ShowAllHiddenParts_tooltip;

	public static String ShowHiddenPartsCommand_ShowHiddenParts;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
