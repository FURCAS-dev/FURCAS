/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.preferences;


import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


/**
 * A multi-tab preferences page for Imp-supported languages.
 * The various tabs nominally represent the same sets of preferences
 * as set on different levels (default, workspace configuration,
 * workspace instance, and project).
 * 
 * @author suttons@us.ibm.com
 */
public abstract class AlternativePreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {
	
	public AlternativePreferencesPage() {
		this.noDefaultAndApplyButton();
	}

	protected Control createContents(Composite parent)
	{
		String message = getAlternativeMessage();
		Label label = new Label(parent, SWT.WRAP);
		label.setText(message);	

        // Set the font on the page
		Dialog.applyDialogFont(parent);
		
		return label;
	}
	
	
	protected abstract String getAlternativeMessage();
	
	
	/*
	 * The following operations provide a page-level response to the pressing of
	 * buttons on the page.  Note, though, that a preference page may not have all of
	 * these buttons--buttons not present on the page may instead be present on individual
	 * tabs on the page.
	 */
	

	
	/**
	 * Respond to pressing of Cancel button by cancelling in-progress
	 * preference updates on each level.
	 * 
	 * @see org.eclipse.jface.preference.IPreferencePage#performCancel()
	 */
    public boolean performCancel()
    {
    	return true;
    }

	
	/**
	 * Respond to pressing of the Save button by saving the prevailing preferences.
	 * 
	 * Note:  In a system of multiple preference levels with preference-value
	 * inheritance, this may only save values on the levels on which they
	 * are stored, i.e., not on levels where they apply through inheritance only.
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	public boolean performOk()
	{
		return true;
	}
	

	
	/**
	 * For IWorkbenchPreferencePage
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}


}
