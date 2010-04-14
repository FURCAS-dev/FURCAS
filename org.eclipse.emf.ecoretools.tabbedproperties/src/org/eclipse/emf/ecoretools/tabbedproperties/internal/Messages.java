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
 * $Id: Messages.java,v 1.2 2009/05/06 13:54:20 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.tabbedproperties.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.emf.ecoretools.tabbedproperties.internal.messages"; //$NON-NLS-1$

	public static String AbstractCollectionPropertySection_Add;

	public static String AbstractCollectionPropertySection_Down;

	public static String AbstractCollectionPropertySection_Remove;

	public static String AbstractCollectionPropertySection_Up;

	public static String AbstractDetailedObjectPropertySection_Create;

	public static String AbstractDetailedObjectPropertySection_Details;

	public static String AbstractDoublePropertySection_NotValid;

	public static String AbstractFileChooserPropertySection_NotADirectory;

	public static String AbstractFileChooserPropertySection_NotBlank;

	public static String AbstractFileChooserPropertySection_NotExist;

	public static String AbstractFontPropertySection_Change;

	public static String AbstractIntegerPropertySection_UnvalidCharacter;

	public static String AbstractStringListPropertySection_InvalidSequence;

	public static String ChooseDialog_ChooseDialog_message;

	public static String ChooseDialog_ChooseDialog_title;

	public static String EMFRecordingChangeCommand_RecordingChangeCommand;

	public static String GoToReferenceComposite_GoTo;

	public static String ReferenceViewerComposite_Select;

	public static String SearchableTree_CaseSensitive;

	public static String SearchableTree_Search;

	public static String TableObjectManager_ChooseObjectsToAdd;

	public static String TableObjectManager_NewString;

	public static String TableViewerComposite_Add;

	public static String TableViewerComposite_Remove;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
