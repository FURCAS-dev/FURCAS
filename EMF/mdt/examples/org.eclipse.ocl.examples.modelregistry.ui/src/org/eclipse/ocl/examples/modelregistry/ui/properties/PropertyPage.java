/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: PropertyPage.java,v 1.2 2010/04/08 06:25:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.ui.properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.ocl.examples.modelregistry.eclipse.EclipseProjectHandle;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.modelregistry.environment.ProjectHandle;
import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.ocl.examples.modelregistry.model.Accessor;
import org.eclipse.ocl.examples.modelregistry.model.ModelNameAccessor;
import org.eclipse.ocl.examples.modelregistry.model.NamespaceRegistry;
import org.eclipse.ocl.examples.modelregistry.ui.help.ModelRegistryHelpIds;
import org.eclipse.ocl.examples.modelregistry.ui.help.ModelRegistryHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchPropertyPage;

/*
 * The page to configure the model registry
 */
public class PropertyPage extends PreferencePage implements IWorkbenchPreferencePage, IWorkbenchPropertyPage, ModelRegistryHelpIds {

	public static final String PREF_ID = "org.eclipse.ocl.examples.modelregistry.ui.preferences.ModelRegistryPreferencePage"; //$NON-NLS-1$
	public static final String PROP_ID = "org.eclipse.ocl.examples.modelregistry.ui.propertyPages.ModelRegistryPreferencePage"; //$NON-NLS-1$
	
	private FileHandle fileHandle; // resource or null
	private Combo accessorCombo = null;
	private Control fConfigurationBlockControl;
	private ConfigurationBlock configurationBlock;

	public PropertyPage() {
//		setPreferenceStore(ModelRegistryEditorPlugin.getPlugin().getPreferenceStore());
//		setDescription(PreferencesMessages.ModelRegistryPreferencePage_description); 		
		// only used when page is shown programatically
		setTitle(PreferencesMessages.ModelRegistryPreferencePage_title); 
	}
	
	@Override
	protected void contributeButtons(Composite parent) {
		createAccessorCombo(parent);
		createFiller(parent);
		int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		configurationBlock.createAddButton(parent, widthHint);
		configurationBlock.createEditButton(parent, widthHint);
		configurationBlock.createRemoveButton(parent, widthHint);
		createFiller(parent);
        parent.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		Layout layout = parent.getLayout();
		if (layout instanceof GridLayout)
			((GridLayout)layout).numColumns += 7;
		super.contributeButtons(parent);
	}

	private Combo createAccessorCombo(Composite inner) {
		NamespaceRegistry namespaceRegistry = ModelRegistryEnvironment.getInstance().getNamespaceRegistry();
		List<Accessor.Namespace<?>> kindList = new ArrayList<Accessor.Namespace<?>>(namespaceRegistry.getNamespaces());
		int iMax = kindList.size();
		String[] kindArray = new String[iMax];
		for (int i = 0; i < iMax; i++) {
			kindArray[i] = kindList.get(i).getName();
		}
		Arrays.sort(kindArray);
		Label namespaceLabel = new Label(inner, SWT.NONE);
		namespaceLabel.setText(PreferencesMessages.ModelRegistryConfigurationBlock_accessor_label); 
		accessorCombo = new Combo(inner, SWT.NONE);
		accessorCombo.setItems(kindArray);
		accessorCombo.select(accessorCombo.indexOf(ModelNameAccessor.NAMESPACE.getName()));
		accessorCombo.addSelectionListener(new SelectionAdapter() {
			@Override public void widgetSelected(SelectionEvent e) {
				if (!configurationBlock.setNamespaceName(accessorCombo.getText()))
					accessorCombo.select(accessorCombo.indexOf(configurationBlock.getNamespaceName()));
			}
		});
		ModelRegistryHelper.setHelp(namespaceLabel, ModelRegistryHelpIds.General.ACCESSOR_KIND);
		ModelRegistryHelper.setHelp(accessorCombo, ModelRegistryHelpIds.General.ACCESSOR_KIND);
		return accessorCombo;
	}

	/*
	 * @see org.eclipse.jface.preference.IPreferencePage#createContents(Composite)
	 */
	@Override protected Control createContents(Composite parent) {
		Composite composite= new Composite(parent, SWT.NONE);
		GridLayout layout= new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		composite.setFont(parent.getFont());			
		fConfigurationBlockControl = createPreferenceContent(composite);
		fConfigurationBlockControl.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
//		if (isProjectPreferencePage()) {
//			boolean useProjectSettings= hasProjectSpecificOptions(getProject());
//			enableProjectSpecificSettings(useProjectSettings);
//		}
		Dialog.applyDialogFont(composite);
		return composite;
	}
			
	/*
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override public void createControl(Composite parent) {
		configurationBlock = new ConfigurationBlock(getFileHandle());		
		super.createControl(parent);		
		ModelRegistryHelper.setHelp(getControl(), ModelRegistryHelpIds.PropertyPage.OVERVIEW);
		getDefaultsButton().setText(JFaceResources.getString("Revert"));
	}
	
	@Override protected Label createDescriptionLabel(Composite parent) {
		if (isProjectPreferencePage()) {
			Composite composite= new Composite(parent, SWT.NONE);
			composite.setFont(parent.getFont());
			GridLayout layout= new GridLayout();
			layout.marginHeight= 0;
			layout.marginWidth= 0;
			layout.numColumns= 2;
			composite.setLayout(layout);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			
			Label horizontalLine= new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
			horizontalLine.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false, 2, 1));
			horizontalLine.setFont(composite.getFont());
		}

		return super.createDescriptionLabel(parent);
    }

	private void createFiller(Composite parent) {
		Label filler = new Label(parent, SWT.NONE);
		filler.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.internal.ui.preferences.PropertyAndPreferencePage#createPreferenceContent(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createPreferenceContent(Composite composite) {
		return configurationBlock.createContents(composite);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage#dispose()
	 */
	@Override public void dispose() {
		if (configurationBlock != null)
			configurationBlock.dispose();
		super.dispose();
	}

	protected void doStatusChanged() {
//		if (!isProjectPreferencePage() || useProjectSettings()) {
//			updateStatus(fBlockStatus);
//		} else {
//			updateStatus(new StatusInfo());
//		}
	}

	public IAdaptable getElement() {
		return fileHandle;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.internal.ui.preferences.PropertyAndPreferencePage#getPreferencePageID()
	 */
	protected String getPreferencePageID() {
		return PREF_ID;
	}
	
	protected ProjectHandle getProjectHandle() {
		return fileHandle.getProjectHandle();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.internal.ui.preferences.PropertyAndPreferencePage#getPropertyPageID()
	 */
	protected String getPropertyPageID() {
		return PROP_ID;
	}
	
	protected FileHandle getFileHandle() {
		return fileHandle;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
	protected boolean isProjectPreferencePage() {
		return fileHandle != null;
	}
	
	@Override public void performApply() {
		if (configurationBlock != null)
			configurationBlock.performApply();
	}
	
	@Override protected void performDefaults() {
		super.performDefaults();
		if (configurationBlock != null)
			configurationBlock.performDefaults();
	}

	@Override public boolean performOk() {
		if ((configurationBlock != null) && !configurationBlock.performOk())
			return false;
		return super.performOk();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPropertyPage#setElement(org.eclipse.core.runtime.IAdaptable)
	 */
	public void setElement(IAdaptable element) {
		IResource resource = (IResource) element.getAdapter(IResource.class);
		if (resource != null) {
			EclipseProjectHandle projectHandle = new EclipseProjectHandle(resource.getProject());
			fileHandle = projectHandle.getFileHandle(resource);
		}
		else
			fileHandle = null;
		setDescription(null); // no description for property page
	}

	@Override public void setVisible(boolean visible) {
        if (getControl() != null)
        	super.setVisible(visible);
    }
	
	protected boolean supportsProjectSpecificOptions() {
		return getPropertyPageID() != null;
	}
}
