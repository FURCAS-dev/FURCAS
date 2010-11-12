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
 * $Id: ConfigurationBlock.java,v 1.3 2010/04/08 06:25:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.ui.properties;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;
import org.eclipse.ocl.examples.modelregistry.model.Accessor;
import org.eclipse.ocl.examples.modelregistry.model.AccessorRegistry;
import org.eclipse.ocl.examples.modelregistry.model.FileHandleRegistry;
import org.eclipse.ocl.examples.modelregistry.model.ModelNameAccessor;
import org.eclipse.ocl.examples.modelregistry.model.ProjectRegistry;
import org.eclipse.ocl.examples.modelregistry.model.Registration;
import org.eclipse.ocl.examples.modelregistry.ui.help.ModelRegistryHelpIds;
import org.eclipse.ocl.examples.modelregistry.ui.help.ModelRegistryHelper;
import org.eclipse.ocl.examples.modelregistry.ui.icons.Icons;
import org.eclipse.ocl.examples.modelregistry.ui.icons.ModelRegistryIcons;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
  */
public class ConfigurationBlock
{
	public class RegistrationLabelComparator extends ViewerComparator
	{
		@Override public int compare(Viewer viewer, Object e1, Object e2) {
			return ((Registration<?>)e1).compareTo((Registration<?>)e2);
		}
	}

	private class RegistrationLabelProvider extends LabelProvider implements ITableLabelProvider, IColorProvider
	{
		public Color getBackground(Object element) {
			Registration<?> registration = (Registration<?>) element;
			if (!fileHandle.equals(registration.getFileHandle()))
				return shell.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
			return null;
		}
		
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO show a warning decoration (via Problems Page) if serialization factory does not exist 
			// TODO invoke a builder on the .settings file to show if serialization factory does not exist
			if (columnIndex != 0)
				return null;
			Registration<?> registration = (Registration<?>) element;
			FileHandle lineHandle = registration.getFileHandle();
			Enum<?> imageIcon = null;
			Enum<?> overlayIcon = null;
			Enum<?> underlayIcon = null;
			if (lineHandle.isFile() != null)
				imageIcon = ModelRegistryIcons.FILE;
			else if (lineHandle.isFolder() != null)
				imageIcon = ModelRegistryIcons.FOLDER;
			else if (lineHandle.isProject() != null)
				imageIcon = ModelRegistryIcons.PROJECT;
			try {
				File file = ModelRegistryEnvironment.getInstance().getFile(registration.getURI());
			    if ((file == null) || !file.exists())
			    	overlayIcon = ModelRegistryIcons.WITH_WARNING;
			} catch (Exception e) {
		    	overlayIcon = ModelRegistryIcons.WITH_ERROR;
			}
		    if (!isVisible(registration))
		    	underlayIcon = ModelRegistryIcons.OCCLUDED;
			return Icons.getImage(imageIcon, overlayIcon, underlayIcon);			
		}

		public String getColumnText(Object element, int columnIndex) {
			Registration<?> registration = (Registration<?>) element;
			switch (columnIndex) {
				case 0: return registration.getFileHandle().getName();
				case 1: return registration.getAccessorName();
				case 2: return registration.getURIString();
				case 3: return registration.getModelKindName();
				default: return null;
			}	
		}

		public Color getForeground(Object element) {
			return null;
		}
		
		@Override public Image getImage(Object element) {
			return null;
		}

		@Override public String getText(Object element) {
			return getColumnText(element, 1);
		}
	}
	
/*	private static class RegistrationSorter extends ViewerComparator
	{
		public int compare(Viewer viewer, Object e1, Object e2) {
			return getComparator().compare(((Registration<?>) e1).getAccessorName(), ((Registration<?>) e2).getAccessorName());
		}
	} */
	
	class TableContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			return editedRegistrationModel.toArray();
		}

		public void dispose() {}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
	}
	
	protected final FileHandle fileHandle;		// File handle of selected resource
	private final ProjectRegistry projectRegistry;
	private final List<Registration<?>> editedRegistrationModel = new ArrayList<Registration<?>>();  //  Current state
	private final List<Registration<?>> uneditedRegistrationModel = new ArrayList<Registration<?>>(); // State on load/save/revert
	private String namespaceName;
	private Shell shell = null;				// Set by createContent
	private Button addButton = null;
	private Button editButton = null;
	private Button removeButton = null;
	private TableViewer tableViewer = null;

	public ConfigurationBlock(FileHandle handle) {
		this.fileHandle = handle;
		namespaceName = ModelNameAccessor.NAMESPACE.getName();
		projectRegistry = new ProjectRegistry(handle.getProjectHandle());
		projectRegistry.loadModel();
		loadEditModel();
	}

	private boolean canEdit(List<Registration<?>> selectedElements) {
		return (selectedElements.size() == 1) && fileHandle.equals(selectedElements.get(0).getFileHandle());
	}

	private boolean canRemove(List<Registration<?>> selectedElements) {
		for (Registration<?> selectedElement : selectedElements)
			if (!fileHandle.equals(selectedElement.getFileHandle()))
				return false;
		return true;
	}

	public Button createAddButton(Composite parent, int widthHint) {		
		addButton = new Button(parent, SWT.PUSH);
		addButton.setText(PreferencesMessages.ModelRegistryConfigurationBlock_markers_tasks_add_button);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		Point minButtonSize = addButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		data.widthHint = Math.max(widthHint, minButtonSize.x);
		addButton.setLayoutData(data);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override public void widgetSelected(SelectionEvent e) {
				AccessorRegistry<?> accessorRegistry = getAccessorRegistry();
				RegistrationDialog dialog = new RegistrationDialog(shell, accessorRegistry, null, editedRegistrationModel, fileHandle);
				if (dialog.open() == Window.OK) {
					editedRegistrationModel.add(dialog.getRegistration());
					updateFromEditModel();
				}
			}
		});	
		ModelRegistryHelper.setHelp(addButton, ModelRegistryHelpIds.PropertyPage.ADD);
		return addButton;
	}
	
	protected Control createContents(Composite parent) {
		shell = parent.getShell();
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 5;		
		Composite inner = new Composite(parent, SWT.NULL);
		inner.setLayout(layout);
		inner.setFont(parent.getFont());		
		Table tableControl = createTableControl(inner);
		tableControl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, layout.numColumns, 1));		
		updateFromEditModel();
//		if (dialogList.getSize() > 0) {
//			dialogList.selectFirstElement();
//		} else {
//			dialogList.enableButton(IDX_EDIT, false);
//		}
		return inner;
	}

	public Button createEditButton(Composite parent, int widthHint) {		
	    editButton = new Button(parent, SWT.PUSH);
	    editButton.setText(PreferencesMessages.ModelRegistryConfigurationBlock_markers_tasks_edit_button);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		Point minButtonSize = editButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		data.widthHint = Math.max(widthHint, minButtonSize.x);
		editButton.setLayoutData(data);
	    editButton.addSelectionListener(new SelectionAdapter() {
			@Override public void widgetSelected(SelectionEvent e) {
				List<Registration<?>> selection = getSelectedRegistrations();
				if (selection.size() > 0) {
					Registration<?> edited = selection.get(0);
					AccessorRegistry<?> accessorRegistry = getAccessorRegistry();
					RegistrationDialog dialog = new RegistrationDialog(shell, accessorRegistry, edited, editedRegistrationModel, fileHandle);
					if (dialog.open() == Window.OK) {
						editedRegistrationModel.set(editedRegistrationModel.indexOf(edited), dialog.getRegistration());
						updateFromEditModel();
					}
				}
			}
		});		
		ModelRegistryHelper.setHelp(editButton, ModelRegistryHelpIds.PropertyPage.EDIT);
		return editButton;	// FIXME editing a registration from .xml to .emof doesn't replace
	}

	public Button createRemoveButton(Composite parent, int widthHint) {
		removeButton = new Button(parent, SWT.PUSH);
		removeButton.setText(PreferencesMessages.ModelRegistryConfigurationBlock_markers_tasks_remove_button);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		Point minButtonSize = removeButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		data.widthHint = Math.max(widthHint, minButtonSize.x);
		removeButton.setLayoutData(data);
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override public void widgetSelected(SelectionEvent e) {
				List<Registration<?>> selection = getSelectedRegistrations();
				editedRegistrationModel.removeAll(selection);
				updateFromEditModel();
			}
		});
		ModelRegistryHelper.setHelp(removeButton, ModelRegistryHelpIds.PropertyPage.REMOVE);
		return removeButton;
	}

	protected Table createTableControl(Composite inner) {
		tableViewer = new TableViewer(inner);
		tableViewer.setContentProvider(new TableContentProvider());
		tableViewer.setLabelProvider(new RegistrationLabelProvider());
		tableViewer.setComparator(new RegistrationLabelComparator());
		Table tableControl = tableViewer.getTable();
		String[] columnsHeaders= new String[] {
			PreferencesMessages.ModelRegistryConfigurationBlock_container_column, 
			PreferencesMessages.ModelRegistryConfigurationBlock_accessor_name_column, 
			PreferencesMessages.ModelRegistryConfigurationBlock_platform_resource_column, 
			PreferencesMessages.ModelRegistryConfigurationBlock_serialization_column 
		};
		int[] columnWidths = { 100, 85, 400, 40 };		// FIXME do some pixel conversion
		for (int i = 0; i < columnsHeaders.length; i++) {
			TableColumn column = new TableColumn(tableControl, SWT.NONE);
			column.setText(columnsHeaders[i]);
			column.setWidth(columnWidths[i]);
		}
		tableControl.setHeaderVisible(true);
		tableControl.setLinesVisible(true);
		tableControl.addSelectionListener(new SelectionAdapter() {
			@Override public void widgetSelected(SelectionEvent e) {
				updateStatus();
			}			
		});
		ModelRegistryHelper.setHelp(tableControl, ModelRegistryHelpIds.PropertyPage.TABLE);
		return tableControl;
	}
	
	public void dispose() {}

	public String getNamespaceName() { return namespaceName; }

	private AccessorRegistry<?> getAccessorRegistry() {
		if (namespaceName == null)
			return null;
		FileHandleRegistry fileHandleRegistry = projectRegistry.getOrCreate(fileHandle);
		if (fileHandleRegistry == null)
			return null;
		AccessorRegistry<?> accessorRegistry = fileHandleRegistry.getOrCreate(namespaceName);
		return accessorRegistry;
	}
	
	private List<Registration<?>> getSelectedRegistrations() {
		ISelection selection = tableViewer.getSelection();
		if ((selection == null) || !(selection instanceof IStructuredSelection))
			return Collections.emptyList();
		return ClassUtils.asClassUnchecked(((IStructuredSelection)selection).toList(), (List<Registration<?>>)null);
	}

	public boolean isDirty() {
		if (editedRegistrationModel.size() != uneditedRegistrationModel.size())
			return true;
		int iMax = editedRegistrationModel.size();
		for (int i = 0; i < iMax; i++) {
			Registration<?> editedRegistration = editedRegistrationModel.get(i);
			Registration<?> uneditedRegistration = uneditedRegistrationModel.get(i);
			if (!editedRegistration.equals(uneditedRegistration))
				return true;
		}
		return false;
	}

	private boolean isVisible(Registration<?> candidateRegistration) {
//		int candidateDepth = candidateRegistration.getFileHandleRegistry().getDepth();
		Accessor<?> candidateAccessor = candidateRegistration.getAccessor();
		Registration<?> visibleRegistration = null;
		int visibleDepth = -1;
		int iMax = editedRegistrationModel.size();
		for (int i = 0; i < iMax; i++) {
			Registration<?> editedRegistration = editedRegistrationModel.get(i);
			if (editedRegistration.getAccessor().equals(candidateAccessor)) {
				int editedDepth = editedRegistration.getFileHandleRegistry().getDepth();
				if (editedDepth >= visibleDepth) {
					visibleRegistration = editedRegistration;
					visibleDepth = editedDepth;
				}
			}
		}
		return visibleRegistration == candidateRegistration;
	}
	
	private void loadEditModel() {
		editedRegistrationModel.clear();
		if (namespaceName != null) {
			for (FileHandle fileHandleAncestor = fileHandle; fileHandleAncestor != null; fileHandleAncestor = fileHandleAncestor.getParentFileHandle()) {
				FileHandleRegistry fileHandleRegistry = projectRegistry.get(fileHandleAncestor);
				if (fileHandleRegistry != null) {
					AccessorRegistry<?> accessorRegistry = fileHandleRegistry.getOrCreate(namespaceName);
					if (accessorRegistry != null) {
						Collection<? extends Registration<?>> fileHandleRegistrations = accessorRegistry.getRegistrations();
						if (fileHandleRegistrations != null)
							editedRegistrationModel.addAll(fileHandleRegistrations);
					}
				}
			}
		}
		uneditedRegistrationModel.clear();
		uneditedRegistrationModel.addAll(editedRegistrationModel);
	}

	public boolean performApply() {
		return saveEditModel();
	}

	public void performDefaults() {
		performRevert();	
	}

	public boolean performOk() {
		return saveEditModel();
	}

	public void performRevert() {
		editedRegistrationModel.clear();
		editedRegistrationModel.addAll(uneditedRegistrationModel);
		updateFromEditModel();
	}

	private boolean saveEditModel() {
		List<Registration<?>> newRegistrations = new ArrayList<Registration<?>>(editedRegistrationModel);
		List<Registration<?>> obsoleteRegistrations = new ArrayList<Registration<?>>(uneditedRegistrationModel);
		for (Registration<?> registration : editedRegistrationModel) {
			if (uneditedRegistrationModel.contains(registration)) {
				newRegistrations.remove(registration);
				obsoleteRegistrations.remove(registration);
			}				
		}
		for (Registration<?> obsoleteRegistration : obsoleteRegistrations)
			if (projectRegistry.remove(obsoleteRegistration) == null)
				ModelRegistryEnvironment.logError("Failed to remove registration ' " + obsoleteRegistration + "'", null);
		for (Registration<?> newRegistration : newRegistrations) {
			Registration<?> displacedRegistration = projectRegistry.add(newRegistration);
			if (displacedRegistration != null)
				ModelRegistryEnvironment.logError("Displaced '" + displacedRegistration + "' when adding '" + newRegistration + "'", null);
		}
		if (!projectRegistry.saveModel())
			return false;
		uneditedRegistrationModel.clear();
		uneditedRegistrationModel.addAll(editedRegistrationModel);
		return true;

	}
	
	public boolean setNamespaceName(String namespaceName) {
		if (!this.namespaceName.equals(namespaceName)) {
			if (isDirty()) {
				if (!MessageDialog.openConfirm(shell, "Save Changes?", "The '" + namespaceName + "' accessor has unsaved changes. Do you wish to save them?"))
					return false;
				saveEditModel();
			}
			this.namespaceName = namespaceName;
			loadEditModel();
			updateFromEditModel();
		}
		return true;
	}
	
	public void setEnabled(boolean isEnabled) {
		tableViewer.getTable().setEnabled(isEnabled);
		addButton.setEnabled(isEnabled);
		editButton.setEnabled(isEnabled);
		removeButton.setEnabled(isEnabled);
	}
	
	private void updateFromEditModel() {
		tableViewer.setInput(editedRegistrationModel);
		updateStatus();
	}
	
	protected void updateStatus() {
		List<Registration<?>> selectedElements = getSelectedRegistrations();
		if (editButton != null)
			editButton.setEnabled(canEdit(selectedElements));
		if (removeButton != null)
			removeButton.setEnabled(canRemove(selectedElements));
	}
}
