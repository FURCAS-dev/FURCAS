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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


/**
 * A multi-tab preferences page for IMP-supported languages.
 * The various tabs nominally represent the same sets of preferences
 * as set on different levels (default, workspace configuration,
 * workspace instance, and project).
 * 
 * @author suttons@us.ibm.com
 */
public abstract class TabbedPreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {
	
	// To hold tabs created by specializations of this class;
	// used below in methods that respond to buttons
	PreferencesTab[] tabs = new PreferencesTab[4];

	// To be provided by a language-specific preferences page
	// that is specialized from this one
	protected IPreferencesService prefService = null;

	
	public TabbedPreferencesPage() {
		this.noDefaultAndApplyButton();
	}

	protected Control createContents(Composite parent) {
		
		// Create a tab folder to put onto the page
		final TabFolder tabFolder = new TabFolder(parent, SWT.NONE);
        final GridData gd= new GridData(SWT.FILL, SWT.CENTER, true, false);
        gd.widthHint= 0;
        gd.heightHint= SWT.DEFAULT;
        gd.horizontalSpan= 1;
        tabFolder.setLayoutData(gd);

        // Create the tabs that go into the tab folder	
        tabs = createTabs(prefService, this, tabFolder);
        setInitialStateForTabs();

        // The validity of the page depends on the validity of its tabs,
        // so refresh the valid state of the page now that all of the
        // tabs have been created
        notifyState(true);

        // Set the font on the page
		Dialog.applyDialogFont(parent);

        // If there's more than 1 tab, start out by selecting the 2nd tab
        // (usually the "Workspace" tab), rather than the "Project" tab,
        // which doesn't even show values until the user selects a project.
		if (tabs.length > 1) {
		    int idx= -1;
		    for(int i= 0; i < tabs.length; i++) {
		        if (tabs[i].getLevel().equals(IPreferencesService.INSTANCE_LEVEL)) {
		            idx= i;
		        }
		    }
		    if (idx > 0) {
		        tabFolder.setSelection(idx);
		    }
		}
		return tabFolder;
	}

	
	/**
	 * Assure that the enabled state of conditionally enabled
	 * tabs is set appropriately.
	 * 
	 * When a tab is newly created with some fields that are supposed to
	 * be enabled depending on the value of other (boolean) fields, it
	 * seems that the enabled state of the conditional fields does not
	 * get set properly.  This happens despite explicit attempts to set
	 * the appropriate enabled state (perhaps due to race conditions?).
	 * Toggling of the condition fields once the tab has been created
	 * does cause the enabled state of conditional fields to be set
	 * correctly.  This method automates that activity, which can be
	 * emulated on the default tab by restoring and applying the default
	 * field values.  However, changes on the default tab can affect
	 * lower levels in the preferences hierarchy--values inherited from
	 * the default level do not change, but the fact that the default
	 * values have been restored causes inherited values to be marked as
	 * modified.  To clear the modified marks from lower levels of the
	 * preferences hierarchy, the tabs for those levels are also applied,
	 * in a top-down order.  On the project level default values are
	 * restored before being applied; this assures that the fields are
	 * empty, as they should be, because there should be no project
	 * selected at this point.
	 *
	 */
	protected void setInitialStateForTabs() {
	    // Assure that all tabs are initialized properly
	    // and reflect an unmodified state
	    for (int i = 0; i < tabs.length; i++) {
	    	if (tabs[i] instanceof DefaultPreferencesTab) {
	    		tabs[i].performDefaults();
	    		tabs[i].performApply();
	    		break;
	    	}
	    }
	    for (int i = 0; i < tabs.length; i++) {
	    	if (tabs[i] instanceof ConfigurationPreferencesTab) {
	    		tabs[i].performApply();
	    		break;
	    	}
	    }
	    for (int i = 0; i < tabs.length; i++) {
	    	if (tabs[i] instanceof InstancePreferencesTab) {
	    		tabs[i].performApply();
	    		break;
	    	}
	    }
	    for (int i = 0; i < tabs.length; i++) {
	    	if (tabs[i] instanceof ProjectPreferencesTab) {
	    		tabs[i].performDefaults();
	    		tabs[i].performApply();
	    		break;
	    	}
	    }
	}
	
	/**
	 * Create the tabs that represent the different levels of preferences
	 * shown on this page.  Nominally these are the default, workspace configuraiton,
	 * workspace instance, and project levels.
	 * 
	 * @param prefService	The service that manages the preferences by level
	 * @param page			The page on which the tabs are to be created (that is, this page)
	 * @param tabFolder		The tab folder, on this page, that will contain the created tabs
	 * @return				An array containing the created tabs
	 */
	protected abstract PreferencesTab[] createTabs(
			IPreferencesService prefService, TabbedPreferencesPage page, TabFolder tabFolder);	 
	

	
	/**
	 * 
	 */
	public boolean notifyState(boolean state) {
		boolean allValid = true;
		for (int i = 0; i < tabs.length && allValid; i++) {
			allValid = allValid && tabs[i] != null && tabs[i].isValid();
		}
		setValid(allValid);
		return allValid;
	}
	
	
	/*
	 * The following four operations provide a page-level response to the pressing of
	 * buttons on the page.  Note, though, that a preference page may not have all of
	 * these buttons--buttons not present on the page may instead be present on individual
	 * tabs on the page.
	 */
	

	/**
	 * Respond to pressing of the Apply button by saving the prevailing preferences.
	 * 
	 * Note:  In a system of multiple preference levels with preference-value
	 * inheritance, this may only save values on the levels on which they
	 * are stored, i.e., not on levels where they apply through inheritance only.
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performApply()
	 */
	public void performApply()
	{
		for (int i = 0; i < tabs.length; i++) {
			tabs[i].performApply();
		}
	}
	
	
	/**
	 * Respond to pressing of Cancel button by cancelling in-progress
	 * preference updates on each level.
	 * 
	 * @see org.eclipse.jface.preference.IPreferencePage#performCancel()
	 */
    public boolean performCancel()
    {
    	// SMS 4 Dec 2006
    	// Previously just used to return true; now trying to
    	// allow for a negative return
    	boolean result = true;
		for (int i = 0; i < tabs.length; i++) {
		    // If there was a problem initializing the tabs, one or more might be null now.
			if (tabs[i] != null) {
				result = result && tabs[i].performCancel();
			}
		}

        return result;
    }

    
    /**
     * Respond to pressing of Restore Defaults button by restoring default
     * values on each level.
     * 
     * Note:  In a system of multiple preference levels with preference-value
     * inheritance, the default value on levels other than the default level
     * may be considered to be the level inherited from the next higher level,
     * so this may entail removing the preferences stored on each level other
     * than the default level.  On the default level, the programmed default
     * values should be restored.
     * 
     * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
     */
	public void performDefaults()
	{
		// SMS 4 Dec 2006
		// Need to check visibility of a composite that contains the tab;
		// be sure that the right one is checked here ...
		for (int i = 0; i < tabs.length; i++) {
			if (tabs[i].getTabItem().getControl().isVisible())
				tabs[i].performDefaults();
		}	

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
		// SMS 4 Dec 2006
		// Not sure of the effect of returning false, but
		// should probably allow for that	
		boolean result = true;
		for (int i = tabs.length-1; i >= 0; i--) {
			result = result && tabs[i].performOk();
		}
		
		return result;
	}
	

	
	/**
	 * For IWorkbenchPreferencePage
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	
	/**
	 * Get the tabs used on this preference page
	 * 
	 * @return	The tabs used on this preference page
	 */
	protected PreferencesTab[] getTabs() {
		return tabs;
	}

	
	
	/**
	 * Should be overridden in language-specific tabbed preferences page
	 * to make use of language-specific preference initializer.
	 * 
	 * @return 	The preference initializer to be used to initialize
	 * 			preferences in this tab
	 */
	// TODO:  Probably should make this an abstract method
	public PreferencesInitializer getPreferenceInitializer() {
		// TODO:  Override in subclass where the language-specific
		// initializer should be known
		System.out.println("TabbedPreferencesPage.getPreferenceInitializar():  unimplemented; should be overridden with language-specific implementation");
		return null;
	}



}
