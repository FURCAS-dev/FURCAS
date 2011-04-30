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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public abstract class DefaultPreferencesTab extends PreferencesTab
{	

	public DefaultPreferencesTab(IPreferencesService prefService, boolean noDetails) {
	    super(IPreferencesService.DEFAULT_LEVEL, noDetails);
		this.fPrefService = prefService;
		fPrefUtils = new PreferencesUtilities(prefService);
	}
	
	@Override
	public Composite createTabContents(TabbedPreferencesPage page, final TabFolder tabFolder) {
		
		fPrefPage = page;
		
        int numColumns= getNoDetails() ? 1 : 2;

        final Composite composite = new Composite(tabFolder, SWT.NONE);
        composite.setFont(tabFolder.getFont());
        final GridData gd= new GridData(SWT.FILL, SWT.CENTER, true, false);
        gd.widthHint= 0;
        gd.heightHint= SWT.DEFAULT;
        gd.horizontalSpan= 1;
        composite.setLayoutData(gd);
		
		GridLayout gl = new GridLayout();
		gl.numColumns = numColumns;
		composite.setLayout(gl);
		
		fTabItem = new TabItem(tabFolder, SWT.NONE);
		fTabItem.setText("Default");
		fTabItem.setControl(composite);
		PreferencesTab.TabSelectionListener listener = 
			new PreferencesTab.TabSelectionListener(fPrefPage, fTabItem);
		tabFolder.addSelectionListener(listener);


		// Don't want newly created fields to be flagged as modified
		// page, this, prefService, "default", 	
		fFields = createFields(page, composite);
		

		// Being newly loaded, the fields may be displayed with some
		// indication that they have been modified.  This should reset
		// that marking.
		clearModifiedMarksOnLabels();
		
		PreferencesUtilities.fillGridPlace(composite, numColumns);
		
		// Put notes on bottom
	
		final Composite bottom = new Composite(composite, SWT.BOTTOM | SWT.WRAP);
        GridLayout layout = new GridLayout();
        bottom.setLayout(layout);
        bottom.setLayoutData(new GridData(SWT.BOTTOM));

        Label bar = new Label(bottom, SWT.WRAP);
        GridData data = new GridData();
        data.verticalAlignment = SWT.WRAP;
        bar.setLayoutData(data);
        bar.setText("These preferences are set programmatically and are not stored\n" +
        			"persistently.  Changes made here apply only to the current execution.\n\n" +
        			"Preferences on the default level cannot be removed.\n\n" +
        			Markings.MODIFIED_NOTE + "\n\n" +
        			Markings.TAB_ERROR_NOTE);
        
        PreferencesUtilities.fillGridPlace(bottom, 1);
 
        // Put buttons on the bottom
        fButtons = fPrefUtils.createDefaultAndApplyButtons(composite, this);
        
		return composite;
	}

	
	
	/**
	 * Should be overridden in language-specific default preferences tab
	 * to make use of language-specific preference initializer.
	 * 
	 * @return 	The preference initializer to be used to initialize
	 * 			preferences in this tab
	 */
//	public AbstractPreferenceInitializer getPreferenceInitializer() {
//		// TODO:  Override in subclass where the language-specific
//		// initializer should be known
//		System.out.println("DefaultPreferencesTab.getPreferenceInitializar():  unimplemented; should be overridden with language-specific implementation");
//		return null;
//	}

	

//	public void performApply()
//	{	
//		for (int i = 0; i < fields.length; i++) {
//			fields[i].store();
//			fields[i].clearModifyMarkOnLabel();
//		}
//	}
	
		
	public void performDefaults() {
		// Clear all preferences for this page at this level and reload
		// them into the preferences store
		//fPrefService.clearPreferencesAtLevel(IPreferencesService.DEFAULT_LEVEL);
		PreferencesInitializer initializer = fPrefPage.getPreferenceInitializer();
		if (initializer != null) {
			initializer.clearPreferencesOnLevel(IPreferencesService.DEFAULT_LEVEL);
			initializer.initializeDefaultPreferences();
		}
		// Example:  reload each preferences field
		for (int i = 0; i < fFields.length; i++) {
			fFields[i].load();
		}
	}

//	public boolean performOk() {
//		// Example:  Store each field
//		for (int i = 0; i < fields.length; i++) {
//			fields[i].store();
//		}
//		return true;
//	}
	
	
}
