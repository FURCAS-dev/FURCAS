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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.imp.preferences.PreferencesUtilities.PreferenceChangeListener;
import org.eclipse.imp.preferences.fields.BooleanFieldEditor;
import org.eclipse.imp.preferences.fields.ColorFieldEditor;
import org.eclipse.imp.preferences.fields.ComboFieldEditor;
import org.eclipse.imp.preferences.fields.FontFieldEditor;
import org.eclipse.imp.preferences.fields.RadioGroupFieldEditor;
import org.eclipse.imp.preferences.fields.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.osgi.service.prefs.Preferences;

public abstract class ProjectPreferencesTab extends PreferencesTab {
    protected List<Link> detailsLinks = new ArrayList<Link>();

    protected IProject fProject = null;

    protected Combo selectedProjectCombo;

    public ProjectPreferencesTab(IPreferencesService prefService, boolean noDetails) {
        super(IPreferencesService.PROJECT_LEVEL, noDetails);
        this.fPrefService = prefService;
        fPrefUtils = new PreferencesUtilities(prefService);
    }

	@Override
    public Composite createTabContents(TabbedPreferencesPage page, final TabFolder tabFolder) {
		fPrefPage = page;

        int numColumns= getNoDetails() ? 1 : 2;

		GridLayout layout = null;
		
		final Composite composite= new Composite(tabFolder, SWT.NONE);
	        composite.setFont(tabFolder.getFont());
	        final GridData gd= new GridData(SWT.FILL, SWT.CENTER, true, false);
	        gd.widthHint= 0;
	        gd.heightHint= SWT.DEFAULT;
	        gd.horizontalSpan= 1;
	        composite.setLayoutData(gd);
		
		layout = new GridLayout();
		layout.numColumns = numColumns;
		composite.setLayout(layout);
		
		// The "tab" on the tab folder
		fTabItem = new TabItem(tabFolder, SWT.NONE);	
		fTabItem.setText("Project");
		fTabItem.setControl(composite);	
		PreferencesTab.TabSelectionListener listener = 
			new PreferencesTab.TabSelectionListener(fPrefPage, fTabItem);
		tabFolder.addSelectionListener(listener);
		
		/*
		 * Add the elements relating to preferences fields and their associated "details" links.
		 */
		fFields = createFields(page, composite);


		// Clear some space
		PreferencesUtilities.fillGridPlace(composite, numColumns);

		// Disable the details links since no project is selected at the start	
		for (int i = 0; i < detailsLinks.size(); i++) {
			((Link)detailsLinks.get(i)).setEnabled(false);
		}	
		
		PreferencesUtilities.fillGridPlace(composite, 2);

		// Being newly loaded, the fields may be displayed with some
		// indication that they have been modified.  This should reset
		// that marking.
		clearModifiedMarksOnLabels();
		
		/*
		 * Put in the elements related to selecting a project
		 */
		Group groupHolder = new Group(composite, SWT.SHADOW_ETCHED_IN);
		groupHolder.setText("Project selection");
		groupHolder.setLayout(new GridLayout(2, false));
		groupHolder.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Label projLabel= new Label(groupHolder, SWT.LEFT);
        projLabel.setText("Project:");

        selectedProjectCombo= new Combo(groupHolder, SWT.DROP_DOWN | SWT.READ_ONLY);
		final Combo projCombo= selectedProjectCombo;
		IProject[] pluginProjects= ResourcesPlugin.getWorkspace().getRoot().getProjects();

		projCombo.add("none selected");
		for(int i= 0; i < pluginProjects.length; i++) {
            projCombo.add(pluginProjects[i].getName());
        }
		projCombo.addSelectionListener(new SelectionListener() {
            public void widgetDefaultSelected(SelectionEvent e) { }

            public void widgetSelected(SelectionEvent e) {
                String projName= projCombo.getText();
                ProjectPreferencesTab.this.fPrefService.setProjectName(projName);
            }
		});
		projCombo.setSize(150, 24);
		Label pad = new Label(groupHolder, SWT.NONE);

		// Clear these here in case there are any saved from a previous interaction with the page
		// (assuming that we should start each  new page with no project selected)
		fPrefService.clearPreferencesAtLevel(IPreferencesService.PROJECT_LEVEL);

		addProjectSelectionListener(composite);
				
		PreferencesUtilities.fillGridPlace(composite, 3);
		
		/*
		 * Put explanatory notes toward the bottom
		 * (not sure whether WRAP is helpful here; can manually
		 * wrap text in labels with '\n')
		 */
		
		final Composite bottom = new Composite(composite, SWT.BOTTOM | SWT.WRAP);
        layout = new GridLayout();
        bottom.setLayout(layout);
        bottom.setLayoutData(new GridData(SWT.BOTTOM));
        
        Label bar = new Label(bottom, SWT.WRAP);
        GridData data = new GridData();
        data.verticalAlignment = SWT.WRAP;
        bar.setLayoutData(data);
        bar.setText("Preferences are shown here only when a project is selected.\n\n" +
        			"Preferences shown with a white background are set on this level.\n\n" +
        			"Preferences shown with a colored background are inherited from a higher level.\n\n" +
        			Markings.MODIFIED_NOTE + "\n\n" +
        			Markings.TAB_ERROR_NOTE);
        
		PreferencesUtilities.fillGridPlace(bottom, 1);

		/*
		 * Put Restore Defaults and Apply buttons at the very bottom,
		 * disabled if (as expected) there is no project selected and
		 * the tab is otherwise mainly disabled
		 */
        fButtons = fPrefUtils.createDefaultAndApplyButtons(composite, this);
        if (fPrefService.getProject() == null) {
        	for (int i = 0; i < fButtons.length; i++) 
        		fButtons[i].setEnabled(false);
        }
		return composite;
	}

	
	private void addProjectSelectionListener(Composite composite)
	{
		fPrefService.addProjectSelectionListener(new ProjectSelectionListener(composite));
	}
	


	private class ProjectSelectionListener implements PreferencesService.IProjectSelectionListener
	{
		Composite composite = null;
		IEclipsePreferences.IPreferenceChangeListener currentListener = null;

		ProjectSelectionListener(Composite composite) {
			this.composite = composite;
		}
			
		/**
		 * Notification that a project was selected for inclusion in the preferences hierarchy.
		 * The given event must not be <code>null</code>.
		 * 
		 * @param event an event specifying the details about the new node
		 * @see IEclipsePreferences.NodeChangeEvent
		 * @see IEclipsePreferences#addNodeChangeListener(IEclipsePreferences.INodeChangeListener)
		 * @see IEclipsePreferences#removeNodeChangeListener(IEclipsePreferences.INodeChangeListener)
		 */
		public void selection(IPreferencesService.ProjectSelectionEvent event) {
			addressProjectSelection(event, composite);
		}
	}
	

	protected List<PreferenceChangeListener>  currentListeners = new ArrayList<PreferenceChangeListener>();
	protected List<IEclipsePreferences> 	currentListenerNodes = new ArrayList<IEclipsePreferences>();
	
	
	protected void addressProjectSelection(IPreferencesService.ProjectSelectionEvent event, Composite composite) {
		// TODO: Override in subtype with a real implementation
//      System.err.println("ProjectPreferencesTab.addressProjectSelection(..): unimplemented");

		// SMS 20 Jun 2007
		// Adding code from JikesPG project tab implementation to try
		// to flesh out a skeleton (field-independent) implementation)
		// just to see what there may be of that
		boolean haveCurrentListeners = false;
		
		Preferences oldeNode = event.getPrevious();
		Preferences newNode = event.getNew();
		
		if (oldeNode == null && newNode == null) {
			// This is what happens for some reason when you clear the project selection.
			// Nothing, really, to do in this case ...
			return;
		}

		// If oldeNode is not null, we want to remove any preference-change listeners from it
		if (oldeNode != null && oldeNode instanceof IEclipsePreferences && haveCurrentListeners) {
			removeProjectPreferenceChangeListeners();
			haveCurrentListeners = false;
		} else {	
			// Print an advisory message if you want to
		}

		// If we have a new project preferences node, then do various things
		// to set up the project's preferences
		if (newNode != null && newNode instanceof IEclipsePreferences) {
			// If the containing composite is not disposed, then set the fields' values
			// and make them enabled and editable (as appropriate to the type of field)
			
			if (!composite.isDisposed()) {		
				// Note:  Where there are toggles between fields, it is a good idea to set the
				// properties of the dependent field here according to the values they should have
				// based on the independent field.  There should be listeners to take care of 
				// that sort of adjustment once the tab is established, but when properties are
				// first initialized here, the properties may not always be set correctly through
				// the toggle.  I'm not entirely sure why that happens, except that there may be
				// a race condition between the setting of the dependent values by the listener
				// and the setting of those values here.  If the values are set by the listener
				// first (which might be surprising, but may be possible) then they will be
				// overwritten by values set here--so the values set here should be consistent
				// with what the listener would set.
				
				// Used in setting enabled and editable status
//				boolean enabledState = false;
				
				// Example:
//				// Pretend field1 is a boolean field (checkbox)
//				prefUtils.setField(field1, field1.getHolder());
//				field1.getChangeControl().setEnabled(true);
//				
//				// Pretend field2 is a text-based field
//				prefUtils.setField(field2, field2.getHolder());
//				// field2 enabled iff field1 not checked
//				enabledState = !field1.getBooleanValue();
//				field2.getTextControl().setEditable(enabledState);
//				field2.getTextControl().setEnabled(enabledState);
//				field2.setEnabled(enabledState, field2.getParent());
	
				// And so on for other fields
				
				clearModifiedMarksOnLabels();
			}

			// Add property change listeners
			// Example
//			if (field1.getHolder() != null) addProjectPreferenceChangeListeners(field1, PreferenceConstants.P_FIELD_1, field1.getHolder());
//			if (field2.getHolder() != null) addProjectPreferenceChangeListeners(fieldw, PreferenceConstants.P_FIELD_2, field2.getHolder());
			// And so on for other fields ...

			haveCurrentListeners = true;
		}
		
		// Or if we don't have a new project preferences node ...
		if (newNode == null || !(newNode instanceof IEclipsePreferences)) {
			// May happen when the preferences page is first brought up, or
			// if we allow the project to be deselected
			
			// Clear the preferences from the store
			fPrefService.clearPreferencesAtLevel(IPreferencesService.PROJECT_LEVEL);
			
			// Disable fields and make them non-editable
			if (!composite.isDisposed()) {
				// Example:
//				field1.getChangeControl().setEnabled(false);
//
//				field2.getTextControl(field2.getHolder()).setEnabled(false);
//				field2.getTextControl(field2.getHolder()).setEditable(false);
			}

			// Remove listeners
			removeProjectPreferenceChangeListeners();
			haveCurrentListeners = false;
		}
	}
	

	
	protected void addProjectPreferenceChangeListeners(BooleanFieldEditor field, String key, Composite composite)
	{
		IEclipsePreferences[] nodes = fPrefService.getNodesForLevels();
		for (int i = IPreferencesService.PROJECT_INDEX; i < nodes.length; i++) {
			if (nodes[i] != null) {
				PreferencesUtilities.BooleanPreferenceChangeListener listener = 
					fPrefUtils.new BooleanPreferenceChangeListener(field, key, composite);
				nodes[i].addPreferenceChangeListener(listener);
				currentListeners.add(listener);
				currentListenerNodes.add(nodes[i]);
			} else {
				//System.err.println("ProjectPreferencesTab.addPropertyChangeListeners(..):  no listener added at level = " + i + "; node at that level is null");
			}
		}	
	}
	
	
    protected void addProjectPreferenceChangeListeners(FontFieldEditor field, String key, Composite composite)
    {
        IEclipsePreferences[] nodes = fPrefService.getNodesForLevels();
        for (int i = IPreferencesService.PROJECT_INDEX; i < nodes.length; i++) {
            if (nodes[i] != null) {
                PreferencesUtilities.FontPreferenceChangeListener listener = 
                    fPrefUtils.new FontPreferenceChangeListener(field, key, composite);
                nodes[i].addPreferenceChangeListener(listener);
                currentListeners.add(listener);
                currentListenerNodes.add(nodes[i]);
            } else {
                //System.err.println("ProjectPreferencesTab.addPropertyChangeListeners(..):  no listener added at level = " + i + "; node at that level is null");
            }
        }   
    }
    
    
    protected void addProjectPreferenceChangeListeners(ColorFieldEditor field, String key, Composite composite)
    {
        IEclipsePreferences[] nodes = fPrefService.getNodesForLevels();
        for (int i = IPreferencesService.PROJECT_INDEX; i < nodes.length; i++) {
            if (nodes[i] != null) {
                PreferencesUtilities.ColorPreferenceChangeListener listener = 
                    fPrefUtils.new ColorPreferenceChangeListener(field, key, composite);
                nodes[i].addPreferenceChangeListener(listener);
                currentListeners.add(listener);
                currentListenerNodes.add(nodes[i]);
            } else {
                //System.err.println("ProjectPreferencesTab.addPropertyChangeListeners(..):  no listener added at level = " + i + "; node at that level is null");
            }
        }   
    }
    
    
	protected void addProjectPreferenceChangeListeners(ComboFieldEditor field, String key, Composite composite)
	{
		IEclipsePreferences[] nodes = fPrefService.getNodesForLevels();
		for (int i = IPreferencesService.PROJECT_INDEX; i < nodes.length; i++) {
			if (nodes[i] != null) {
				PreferencesUtilities.ComboPreferenceChangeListener listener = 
					fPrefUtils.new ComboPreferenceChangeListener(field, key, composite);
				nodes[i].addPreferenceChangeListener(listener);
				currentListeners.add(listener);
				currentListenerNodes.add(nodes[i]);
			} else {
				//System.err.println("ProjectPreferencesTab.addPropertyChangeListeners(..):  no listener added at level = " + i + "; node at that level is null");
			}
		}	
	}
	
	
	protected void addProjectPreferenceChangeListeners(RadioGroupFieldEditor field, String key, Composite composite)
	{
		IEclipsePreferences[] nodes = fPrefService.getNodesForLevels();
		for (int i = IPreferencesService.PROJECT_INDEX; i < nodes.length; i++) {
			if (nodes[i] != null) {
				PreferencesUtilities.RadioGroupPreferenceChangeListener listener = 
					fPrefUtils.new RadioGroupPreferenceChangeListener(field, key, composite);
				nodes[i].addPreferenceChangeListener(listener);
				currentListeners.add(listener);
				currentListenerNodes.add(nodes[i]);
			} else {
				//System.err.println("ProjectPreferencesTab.addPropertyChangeListeners(..):  no listener added at level = " + i + "; node at that level is null");
			}
		}	
	}
	
	protected void addProjectPreferenceChangeListeners(StringFieldEditor field, String key, Composite composite)
	{
		IEclipsePreferences[] nodes = fPrefService.getNodesForLevels();
		for (int i = IPreferencesService.PROJECT_INDEX; i < nodes.length; i++) {
			if (nodes[i] != null) {
				// SMS 31 Oct 2006
				//ProjectPreferenceChangeListener listener = new ProjectPreferenceChangeListener(field, key, composite);
				PreferencesUtilities.StringPreferenceChangeListener listener = 
					fPrefUtils.new StringPreferenceChangeListener(field, key, composite);
				nodes[i].addPreferenceChangeListener(listener);
				currentListeners.add(listener);
				currentListenerNodes.add(nodes[i]);
			} else {
				//System.err.println("ProjectPreferencesTab.addPropertyChangeListeners(..):  no listener added at level = " + i + "; node at that level is null");
			}
		}	
	}
	


	protected void removeProjectPreferenceChangeListeners()
	{
		// Remove all listeners from their respective nodes
		for (int i = 0; i < currentListeners.size(); i++) {
			((IEclipsePreferences) currentListenerNodes.get(i)).removePreferenceChangeListener(
					((IEclipsePreferences.IPreferenceChangeListener)currentListeners.get(i)));
		}
		// Clear the lists
		currentListeners = new ArrayList<PreferenceChangeListener>();
		currentListenerNodes = new ArrayList<IEclipsePreferences>();
	}

	
	// SMS 20 Nov 2007:  
    protected void setProjectSelectionValidator(
        	ContainerSelectionDialog dialog, boolean validateForPluginProject, boolean validateForIDEProject)
    {
//	    dialog.setValidator(new ValidationUtils.ProjectSelectionValidator());
    }

    
	public void performApply()
	{
		if (fPrefService.getProject() == null) {
			// No preferences node into which to store anything
			clearModifiedMarksOnLabels();	// just in case fields still show modified
			return;
		}
		for (int i = 0; i < fFields.length; i++) {
			fFields[i].store();
			fFields[i].clearModifiedMarkOnLabel();
		}
	}	
	
	 
	public boolean performCancel() {
		// Nullify the project in any case
		fPrefService.setProject(null);
		return true;
	}

	
	public void performDefaults() {
		if (fPrefService.getProject() == null) {
			// If no project set then there's no preferences
			// file from which to load anything	
			return;
		}
	
		// Clear all preferences for this page at this level;
		// "default" values will be set by inheritance from a higher level
		PreferencesInitializer initializer = fPrefPage.getPreferenceInitializer();
		initializer.clearPreferencesOnLevel(IPreferencesService.PROJECT_LEVEL);
		
		for (int i = 0; i < fFields.length; i++) {
			fFields[i].loadWithInheritance();
		}
	}

	
	public boolean performOk()
	{
		if (fPrefService.getProject() != null) {
			// Store each field
			for (int i = 0; i < fFields.length; i++) {
				fFields[i].store();
			}
		} else {
			// Clear preferences because we're closing up dialog;
			// note that a project preferences node will exist, if only
			// in a leftover state, even when no project is selected
			fPrefService.clearPreferencesAtLevel(IPreferencesService.PROJECT_LEVEL);
			//return true;
		}

		// Nullify the project in any case
		fPrefService.setProject(null);
		
		return true;
	}
}
