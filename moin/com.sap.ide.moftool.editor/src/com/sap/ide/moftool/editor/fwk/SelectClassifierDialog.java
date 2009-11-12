package com.sap.ide.moftool.editor.fwk;

import java.util.Collection;
import java.util.Comparator;

import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.fwk.BrowseTypeControl.TypeFilter;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.tc.moin.repository.Connection;

public class SelectClassifierDialog extends FilteredItemsSelectionDialog {

	private final String DIALOG_SETTINGS; 

	private final Connection con;

	private final TypeFilter typeFilter;

	protected final RefBaseObject modelElement;

	public SelectClassifierDialog(Shell shell, final Connection con, RefBaseObject modelElement, TypeFilter typeFilter) {
		super(shell);
		this.con = con;
		this.modelElement = modelElement;
		this.typeFilter = typeFilter;
		DIALOG_SETTINGS = "com.sap.mi.fwk.ui.editor.SelectClassifierDialog." + typeFilter.toString(); //$NON-NLS-1$
		setTitle(LocalizationMessages.SelectClassifierDialog_0_XGRP);
		setListLabelProvider(new LabelProvider() {
			private final Image classImg = MOFToolEditorPlugin.imageDescriptorFromPlugin(MOFToolEditorPlugin.ID,
					"resources/icons/metamodel/Class.gif").createImage(); //$NON-NLS-1$

			@Override
			public String getText(Object element) {
				ModelElement modelElement = (ModelElement) element;
				if (modelElement != null) {
					return MofService.getQualifiedNameAsString(modelElement.getQualifiedName());
				}
				return ""; //$NON-NLS-1$
			}

			@Override
			public Image getImage(Object element) {
				return classImg;
			}

			@Override
			public void dispose() {
				super.dispose();
				classImg.dispose();
			}
		});
		// <pg101208> initially show full result
		super.setInitialPattern("?"); //$NON-NLS-1$

/*	<pg101208> removed history because it may contain wrong (foreign) objects	
		setSelectionHistory(new SelectionHistory() {

			@Override
			protected void storeItemToMemento(Object item, IMemento memento) {
				if (item instanceof ModelElement) {
					ModelElement modelElement = (ModelElement) item;
					memento.putString("mofId", ((Partitionable) modelElement).get___Mri().getLri().toString()); //$NON-NLS-1$
				}
			}

			@Override
			protected Object restoreItemFromMemento(IMemento memento) {
				try {
					RefBaseObject element = con.getElement(con.getSession().getMoin().createLri(memento.getString("mofId"))); //$NON-NLS-1$
					return element;
				} catch (Exception e) {
					// ignore
				}
				return null;
			}
		});
*/		
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	@Override
	protected ItemsFilter createFilter() {
		return new ItemsFilter() {

			@Override
			public boolean matchItem(Object item) {
				if (item instanceof ModelElement) {
					ModelElement modelElement = (ModelElement) item;
					return matches(modelElement.getName()) || matches(MofService.getQualifiedNameAsString(modelElement.getQualifiedName()));

				}
				return matches(item.toString());
			}

			@Override
			public boolean isConsistentItem(Object item) {
				return true;
			}
		};
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {
		Collection<? extends ModelElement> availableModelElement;
		if (typeFilter == TypeFilter.All) {
			availableModelElement = MofService.getAvailableClassifiers(con);
		} else if (typeFilter == TypeFilter.Class) {
			availableModelElement = MofService.getAvailableClasses(con);
		} else if (typeFilter == TypeFilter.Imports) {
			availableModelElement = MofService.getAvailablePackagesAndClassesFiltered(con, (MofPackage) ((Import) modelElement).getContainer());
		} else if (typeFilter == TypeFilter.DataTypes) {
			availableModelElement = MofService.getAvailableDatatypes(con);			
		} else {
			availableModelElement = MofService.getAvailablePrimitives(con);
		}
		for (ModelElement modelElement : availableModelElement) {
			contentProvider.add(modelElement, itemsFilter);
		}
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = MOFToolEditorPlugin.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);

		if (settings == null) {
			settings = MOFToolEditorPlugin.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
		}

		return settings;
	}

	@Override
	public String getElementName(Object item) {
		return MofService.getQualifiedNameAsString(((ModelElement) item).getQualifiedName());
	}

	@Override
	protected Comparator<ModelElement> getItemsComparator() {
		return new Comparator<ModelElement>() {
			public int compare(ModelElement o1, ModelElement o2) {
				return MofService.getQualifiedNameAsString((o1.getQualifiedName())).compareTo(
						MofService.getQualifiedNameAsString((o2.getQualifiedName())));
			}
		};
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

}
