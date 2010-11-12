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
 * $Id: RegistrationDialog.java,v 1.2 2010/04/08 06:25:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.ui.properties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.CommonUIPlugin;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.RegisteredPackageDialog;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.ocl.examples.modelregistry.environment.ModelSerializationRegistry;
import org.eclipse.ocl.examples.modelregistry.model.AccessorRegistry;
import org.eclipse.ocl.examples.modelregistry.model.ModelSerialization;
import org.eclipse.ocl.examples.modelregistry.model.ProjectRegistry;
import org.eclipse.ocl.examples.modelregistry.model.Registration;
import org.eclipse.ocl.examples.modelregistry.ui.ModelRegistryUIPlugin;
import org.eclipse.ocl.examples.modelregistry.ui.help.ModelRegistryHelpIds;
import org.eclipse.ocl.examples.modelregistry.ui.help.ModelRegistryHelper;
import org.eclipse.ocl.examples.modelregistry.ui.ripoffs.StatusInfo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Dialog to enter/edit a registration
 */
public class RegistrationDialog extends StatusDialog
{	
	private final AccessorRegistry<?> accessorRegistry;
	private final Registration<?> registration;
	private final List<Registration<?>> currentRegistrationModel;
//	private final List<String> existingNames;
	private final FileHandle fileHandle;
	private Text accessorNameText;
	private Text modelURIText;
	private Combo serializationCombo;
	private String accessorName = null;
	private String resourceURI = null;
	private String serialization = null;
		
	public RegistrationDialog(Shell parent, AccessorRegistry<?> accessorRegistry, Registration<?> registration, List<Registration<?>> currentRegistrationModel, FileHandle fileHandle) {
		super(parent);
		this.accessorRegistry = accessorRegistry;
		this.registration = registration;
		this.currentRegistrationModel = currentRegistrationModel;
		this.fileHandle = fileHandle;		
		if (registration == null) {
			setTitle(PreferencesMessages.RegistrationDialog_new_title); 
		} else {
			setTitle(PreferencesMessages.RegistrationDialog_edit_title); 
		}
	}

	/*
	 * @see org.eclipse.jface.window.Window#configureShell(Shell)
	 */
	@Override protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
//		PlatformUI.getWorkbench().getHelpSystem().setHelp(newShell, IJavaHelpContextIds.TODO_TASK_INPUT_DIALOG);
	}

	protected void createAccessorNameControls(Composite parent) {
		Label accessorNameLabel = new Label(parent, SWT.NONE);
		accessorNameLabel.setText(PreferencesMessages.ModelRegistryConfigurationBlock_accessor_name_column); 
		accessorNameText = new Text(parent, SWT.BORDER);
		accessorNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		accessorNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				doValidation();
			}			
		});		
		ModelRegistryHelper.setHelp(accessorNameLabel, ModelRegistryHelpIds.General.ACCESSOR_NAME);
		ModelRegistryHelper.setHelp(accessorNameText, ModelRegistryHelpIds.General.ACCESSOR_NAME);
	}

	protected void createBrowseFileSystemButton(Composite parent) {
		Button browseFileSystemButton = new Button(parent, SWT.PUSH);
	    browseFileSystemButton.setText(CommonUIPlugin.INSTANCE.getString("_UI_BrowseFileSystem_label"));
	    browseFileSystemButton.addSelectionListener(new SelectionAdapter() {
	    	@Override public void widgetSelected(SelectionEvent ev) {
				FileDialog fileDialog = new FileDialog(getShell(), SWT.NONE);
				fileDialog.setFilterPath(fileHandle.getAbsoluteName());
				if (fileDialog.open() == null)
					return;
				String filterPath = fileDialog.getFilterPath();
				String fileName = fileDialog.getFileName();
				if (fileName == null)
					return;
				URI ecoreURI = URI.createFileURI(filterPath + File.separator + fileName);
				setResourceURI(ecoreURI);
			 }
		});
		ModelRegistryHelper.setHelp(browseFileSystemButton, ModelRegistryHelpIds.RegistrationDialog.BROWSE_FILE_SYSTEM);
	}

	protected void createBrowseRegisteredPackagesButton(Composite parent) {
		Button browseRegisteredPackagesButton = new Button(parent, SWT.PUSH);
	    browseRegisteredPackagesButton.setText(EcoreEditorPlugin.INSTANCE.getString("_UI_BrowseRegisteredPackages_label"));
		browseRegisteredPackagesButton.addSelectionListener(new SelectionAdapter() {
			@Override public void widgetSelected(SelectionEvent ev) {
				RegisteredPackageDialog registeredPackageDialog = new RegisteredPackageDialog(getShell());
				registeredPackageDialog.setMultipleSelection(false);
				registeredPackageDialog.open();
				Object[] result = registeredPackageDialog.getResult();
				if ((result == null) || (result.length < 1))
					return;
				String uriString = result[0].toString().trim();
				Map<String, URI> genModelMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
				if (genModelMap == null) {
					showError("No genmodel map error", "EcorePlugin.getEPackageNsURIToGenModelLocationMap() returned null", null);
					return;
				}
				URI genModelURI = genModelMap.get(uriString);
				if (genModelURI == null) {
					showError("No genmodel error", "No genmodel URI obtainable for '" + uriString + "'", null);
					return;
				}
				String genModelURIString = genModelURI.toString();
				if (!genModelURIString.endsWith(".genmodel")) {
					showError("Bad genmodel error", "Selected package's genmodel '" + genModelURIString + "' is not '*.genmodel'", null);
					return;
				}
				String ecoreURIString = genModelURIString.substring(0, genModelURIString.length()-9) + ".ecore";
				URI ecoreURI = URI.createURI(ecoreURIString);	// FIXME Handle multi-Ecore genmodel
				setResourceURI(ecoreURI);
			}
		});
		ModelRegistryHelper.setHelp(browseRegisteredPackagesButton, ModelRegistryHelpIds.RegistrationDialog.BROWSE_REGISTERED_PACKAGES);
	}

	protected void createBrowseWorkspaceButton(Composite parent) {
		Button browseWorkspaceButton = new Button(parent, SWT.PUSH);
	    browseWorkspaceButton.setText(CommonUIPlugin.INSTANCE.getString("_UI_BrowseWorkspace_label"));
	    browseWorkspaceButton.addSelectionListener(new SelectionAdapter() {
	    	@Override public void widgetSelected(SelectionEvent ev) {
				IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, false, new Object[] { fileHandle }, null);
			   	IFile file = files.length != 0 ? files[0] : null;
			   	if (file == null)
			   		return;
			   	String filePath = file.getFullPath().toString();
				URI ecoreURI = URI.createPlatformResourceURI(filePath, true);
				setResourceURI(ecoreURI);
			}
		});
		ModelRegistryHelper.setHelp(browseWorkspaceButton, ModelRegistryHelpIds.RegistrationDialog.BROWSE_WORKSPACE);
	}
	
	@Override protected Control createDialogArea(Composite parent) {
		int columnsPerLine = 4;
		Composite composite= (Composite) super.createDialogArea(parent);
		Composite inner = new Composite(composite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = columnsPerLine;
		inner.setLayout(layout);		
		createAccessorNameControls(inner);	
		createSerializationControls(inner);	
		createResourceURIControls(inner, columnsPerLine);	
		createBrowseFileSystemButton(inner);	
	    createBrowseRegisteredPackagesButton(inner);
		createBrowseWorkspaceButton(inner);		
//		fAccessorNameDialogField.postSetFocusOnDialogField(parent.getDisplay());		
		applyDialogFont(composite);				
		ModelRegistryHelper.setHelp(composite, ModelRegistryHelpIds.RegistrationDialog.OVERVIEW);
		if (registration != null) {
			accessorNameText.setText(registration.getAccessorName());
			modelURIText.setText(registration.getURIString());
			serializationCombo.select(serializationCombo.indexOf(registration.getSerialization().getName()));
		}
		else
			serializationCombo.select(serializationCombo.indexOf(ProjectRegistry.DEFAULT_SERIALISATION_NAME));
		doValidation();
		return composite;
	}

	protected void createResourceURIControls(Composite parent, int columnsPerLine) {
		Label modelURILabel = new Label(parent, SWT.NONE);
		modelURILabel.setText(PreferencesMessages.ModelRegistryConfigurationBlock_platform_resource_column); 
		modelURIText = new Text(parent, SWT.BORDER);
		modelURIText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, columnsPerLine-1, 1));
		modelURIText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				doValidation();
			}			
		});		
		ModelRegistryHelper.setHelp(modelURILabel, ModelRegistryHelpIds.General.MODEL_URI);
		ModelRegistryHelper.setHelp(modelURIText, ModelRegistryHelpIds.General.MODEL_URI);
	}

	protected void createSerializationControls(Composite parent) {
		Label serializationLabel = new Label(parent, SWT.NONE);
		serializationLabel.setText(PreferencesMessages.ModelRegistryConfigurationBlock_serialization_column); 
		serializationCombo = new Combo(parent, SWT.BORDER);
		ModelSerializationRegistry modelSerializationRegistry = ModelRegistryEnvironment.getInstance().getModelSerializationRegistry();
		Collection<String> serializationsList = modelSerializationRegistry.getSerializations();
		String[] serializationsArray = serializationsList.toArray(new String[serializationsList.size()]);
		Arrays.sort(serializationsArray);
		serializationCombo.setItems(serializationsArray);
		serializationCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		serializationCombo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				doValidation();
			}			
		});		
		ModelRegistryHelper.setHelp(serializationLabel, ModelRegistryHelpIds.General.SERIALIZATION);
		ModelRegistryHelper.setHelp(serializationCombo, ModelRegistryHelpIds.General.SERIALIZATION);
	}
		
	protected void doValidation() {		
		MultiStatus status = new MultiStatus(ModelRegistryUIPlugin.PLUGIN_ID, 0, "no message", null)
		{
			@Override public String getMessage() {
				IStatus[] statuses = getChildren();
				if (statuses.length <= 0)
					return super.getMessage();
				if (statuses.length == 1)
					return statuses[0].getMessage();
				StringBuffer s = new StringBuffer(statuses[0].getMessage());
				for (int i = 1; i < statuses.length; i++) {
					s.append("\n");
					s.append(statuses[i].getMessage());
				}
				return s.toString();
			}
			
		};
		accessorName = accessorNameText.getText();
		if ((accessorName == null) || (accessorName.length() == 0))
			status.add(new StatusInfo(IStatus.ERROR, PreferencesMessages.RegistrationDialog_error_enterName)); 
		else if (Character.isWhitespace(accessorName.charAt(0)) || Character.isWhitespace(accessorName.charAt(accessorName.length() - 1)))
			status.add(new StatusInfo(IStatus.ERROR, PreferencesMessages.RegistrationDialog_error_noSpace)); 
		else {
			for (Registration<?> currentRegistration : currentRegistrationModel) {
				if ((currentRegistration != null) && !currentRegistration.equals(registration)) {
					if (accessorName.equals(currentRegistration.getAccessorName())) {
						if (currentRegistration.getFileHandleRegistry().getDepth() == accessorRegistry.getFileHandleRegistry().getDepth())
							status.add(new StatusInfo(IStatus.WARNING, PreferencesMessages.RegistrationDialog_error_entryExists));
					}
				}
			}
		}
		resourceURI = modelURIText.getText();
		if ((resourceURI == null) || (resourceURI.length() == 0))
			status.add(new StatusInfo(IStatus.ERROR, PreferencesMessages.RegistrationDialog_error_enterURI)); 
		else {
			try {
				URI ecoreURI = URI.createURI(resourceURI);
				File file = ModelRegistryEnvironment.getInstance().getFile(ecoreURI);	// FIXME Avoid Files rather than URIs wherever possible
			    if ((file == null) || !file.exists())
					status.add(new StatusInfo(IStatus.WARNING, PreferencesMessages.RegistrationDialog_error_resource_exists));
			} catch (URISyntaxException e) {
				status.add(new StatusInfo(IStatus.WARNING, PreferencesMessages.RegistrationDialog_error_validURI)); 
			} catch (IOException e) {
				status.add(new StatusInfo(IStatus.WARNING, PreferencesMessages.RegistrationDialog_error_resource_exists));
			}
		}
		serialization = serializationCombo.getText();
//		if (!status.isError()) {
			ModelSerializationRegistry modelSerializationRegistry = ModelRegistryEnvironment.getInstance().getModelSerializationRegistry();
			if (modelSerializationRegistry.getSerialization(serialization) == null)
				status.add(new StatusInfo(IStatus.WARNING, PreferencesMessages.RegistrationDialog_warning_no_serialization));
//		}
		updateStatus(status);
		if (status.getChildren().length > 1) {
			Control contents = getContents();
			if (contents != null) {
				contents.pack(true);
				constrainShellSize();
			}
		}
	}

	public Registration<?> getRegistration() {
		if ((accessorName == null) || (resourceURI == null) || (serialization == null))
			return null;
		ModelSerializationRegistry modelSerializationRegistry = ModelRegistryEnvironment.getInstance().getModelSerializationRegistry();
		ModelSerialization modelSerialization = modelSerializationRegistry.getSerializationOrCreate(serialization);
		return accessorRegistry.createRegistration(accessorName, resourceURI, modelSerialization);
	}

//	@Override protected int getShellStyle() {
//		return super.getShellStyle() | SWT.RESIZE;
//	}

	private void setResourceURI(URI ecoreURI) {
		ResourceSet resourceSet = accessorRegistry.getProjectRegistry().getResourceSet();
		URIConverter uriConverter = resourceSet.getURIConverter();
		try {
			InputStream inputStream = uriConverter.createInputStream(ecoreURI);
			inputStream.close();
		} catch (IOException e) {
			showError("Bad resource error", "Selected file '" + ecoreURI.toString() + "' does not exist", e);
			return;
		}
		modelURIText.setText(ecoreURI.toString());
		doValidation();
	}

	@Override protected void setShellStyle(int newShellStyle) {
		super.setShellStyle(newShellStyle | SWT.RESIZE);
	}

	private void showError(String title, String message, Exception e) {
		IStatus status = new Status(Status.ERROR, ModelRegistryUIPlugin.PLUGIN_ID, message, e);
		ErrorDialog.openError(getShell(), "OCL Model Registry Error", title, status);
	}
}
