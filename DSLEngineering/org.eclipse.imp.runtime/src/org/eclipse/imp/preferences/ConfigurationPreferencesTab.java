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


public abstract class ConfigurationPreferencesTab  extends PreferencesTab
{

	public ConfigurationPreferencesTab(IPreferencesService prefService, boolean noDetails) {
	    super(IPreferencesService.CONFIGURATION_LEVEL, noDetails);
		this.fPrefService = prefService;
		fPrefUtils = new PreferencesUtilities(prefService);
	}
	
    @Override
	public Composite createTabContents(TabbedPreferencesPage page, final TabFolder tabFolder) {
		fPrefPage = page;

		int numColumns= getNoDetails() ? 1 : 2;

        final Composite composite= new Composite(tabFolder, SWT.NONE);
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
		fTabItem.setText("Configuration");
		fTabItem.setControl(composite);
		PreferencesTab.TabSelectionListener listener = 
			new PreferencesTab.TabSelectionListener(fPrefPage, fTabItem);
		tabFolder.addSelectionListener(listener);
		
		
		/*
		 * Add the elements relating to preferences fields and their associated "details" links.
		 */	
		//fields = createFields(composite);
		fFields = createFields(page, composite);
		
		PreferencesUtilities.fillGridPlace(composite, numColumns);
		
		// Don't want newly created fields to be flagged as modified
		clearModifiedMarksOnLabels();
		
		
		// Put notes on bottom
		
		final Composite bottom = new Composite(composite, SWT.BOTTOM | SWT.WRAP);
        GridLayout layout = new GridLayout();
        bottom.setLayout(layout);
        bottom.setLayoutData(new GridData(SWT.BOTTOM));
        
        Label bar = new Label(bottom, SWT.WRAP);
        GridData data = new GridData();
        data.verticalAlignment = SWT.WRAP;
        bar.setLayoutData(data);
        bar.setText("Preferences shown with a white (or neutral) background are set on this level.\n\n" +
        			"Preferences shown with a colored background are inherited from a higher level.\n\n" +
        			Markings.MODIFIED_NOTE + "\n\n" +
        			Markings.TAB_ERROR_NOTE);
        
		PreferencesUtilities.fillGridPlace(bottom, 1);
		
		
		// Put buttons on bottom
        fButtons = fPrefUtils.createDefaultAndApplyButtons(composite, this);

		return composite;
	}

	

//	public void performApply()
//	{
//		for (int i = 0; i < fields.length; i++) {
//			fields[i].store();
//			fields[i].clearModifyMarkOnLabel();
//		}
//	}	
	
	
	
	public void performDefaults() {
		// Clear all preferences for this page at this level;
		// "default" values will be set by inheritance from a higher level
		//fPrefService.clearPreferencesAtLevel(IPreferencesService.DEFAULT_LEVEL);
		PreferencesInitializer initializer = fPrefPage.getPreferenceInitializer();
		initializer.clearPreferencesOnLevel(IPreferencesService.CONFIGURATION_LEVEL);

		for (int i = 0; i < fFields.length; i++) {
			fFields[i].loadWithInheritance();
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
