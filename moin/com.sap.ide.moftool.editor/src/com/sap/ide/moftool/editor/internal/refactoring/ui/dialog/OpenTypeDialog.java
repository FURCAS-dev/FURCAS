package com.sap.ide.moftool.editor.internal.refactoring.ui.dialog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
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

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.tc.moin.repository.Connection;

public class OpenTypeDialog extends FilteredItemsSelectionDialog {

	private static final String DIALOG_SETTINGS = "com.sap.ide.moftool.editor.refactoring.ui.OpenTypeDialog"; //$NON-NLS-1$

	public static String CONTAINERNAME_Model = "sap.com/tc/moin/mof_1.4"; //$NON-NLS-1$

	public OpenTypeDialog(Shell shell) {
		super(shell);

		// TODO: set Title
		setTitle("Open Type");
		setListLabelProvider(new LabelProvider() {
			private final Image packageImg = MOFToolEditorPlugin.imageDescriptorFromPlugin(MOFToolEditorPlugin.ID,
					"resources/icons/metamodel/Package.gif").createImage(); //$NON-NLS-1$
			private final Image classImg = MOFToolEditorPlugin.imageDescriptorFromPlugin(MOFToolEditorPlugin.ID,
					"resources/icons/metamodel/Class.gif").createImage(); //$NON-NLS-1$
			private final Image enumImg = MOFToolEditorPlugin.imageDescriptorFromPlugin(MOFToolEditorPlugin.ID,
					"resources/icons/metamodel/EnumerationType.gif").createImage(); //$NON-NLS-1$
			private final Image structImg = MOFToolEditorPlugin.imageDescriptorFromPlugin(MOFToolEditorPlugin.ID,
					"resources/icons/metamodel/StructureType.gif").createImage(); //$NON-NLS-1$
			private final Image assocImg = MOFToolEditorPlugin.imageDescriptorFromPlugin(MOFToolEditorPlugin.ID,
					"resources/icons/metamodel/Association.gif").createImage(); //$NON-NLS-1$

			@Override
			public String getText(Object element) {
				if (element instanceof ModelElement) {
					ModelElement modelElement = (ModelElement) element;
					return createFQN(modelElement);
				} else {
					return "!-> Not a ModelElement"; //$NON-NLS-1$
				}
			}

			@Override
			public Image getImage(Object element) {
				if (element instanceof MofPackage) {
					return packageImg;
				} else if (element instanceof MofClass) {
					return classImg;
				} else if (element instanceof EnumerationType) {
					return enumImg;
				} else if (element instanceof StructureType) {
					return structImg;
				} else if (element instanceof Association) {
					return assocImg;
				} else {
					return null;
				}
			}

			@Override
			public void dispose() {
				super.dispose();
				packageImg.dispose();
				classImg.dispose();
				enumImg.dispose();
				structImg.dispose();
				assocImg.dispose();
			}
		});
		// fill result screen on start
		super.setInitialPattern("?"); //$NON-NLS-1$

		/* to make the history work, we need to save the connection in the memento (for each type!) */
		// setSelectionHistory(new SelectionHistory() {
		//
		// @Override
		// protected void storeItemToMemento(Object item, IMemento memento) {
		//				memento.putString("mofId", ((Partitionable) item).get___Mri().getLri().toString()); //$NON-NLS-1$
		// }
		//
		// @Override
		// protected Object restoreItemFromMemento(IMemento memento) {
		// try {
		// ModelAdapter.getInstance().
		// Connection connection = ???
		//					RefBaseObject element = connection.getElement(connnection.getSession().getMoin().createLri(memento.getString("mofId"))); //$NON-NLS-1$
		// return element;
		// } catch (Exception e) {
		// // ignore
		// }
		// return null;
		// }
		// });
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
					return matches(createFQN(modelElement));
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

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		List<ModelElement> modelElements = new ArrayList<ModelElement>();
		for (IProject project : projects) {
			if (ModelManager.getInstance().isMoinProject(project)) {
				Connection connection = ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
				IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(connection,
						PartitionScope.VISIBLE);
				List<MofPackage> mofPackages = QueryService.getInstance().queryInstances(connection, partitionScopeProvider,
						MOFToolEditorPlugin.CONTAINERNAME_Model, new String[] { "Model", "Package" }); //$NON-NLS-1$ //$NON-NLS-2$
				modelElements.addAll(mofPackages);
				List<MofClass> mofClasses = QueryService.getInstance().queryInstances(connection, partitionScopeProvider,
						MOFToolEditorPlugin.CONTAINERNAME_Model, new String[] { "Model", "Class" }); //$NON-NLS-1$ //$NON-NLS-2$
				modelElements.addAll(mofClasses);
				List<EnumerationType> enumType = QueryService.getInstance().queryInstances(connection, partitionScopeProvider,
						MOFToolEditorPlugin.CONTAINERNAME_Model, new String[] { "Model", "EnumerationType" }); //$NON-NLS-1$ //$NON-NLS-2$
				modelElements.addAll(enumType);
				List<StructureType> structType = QueryService.getInstance().queryInstances(connection, partitionScopeProvider,
						MOFToolEditorPlugin.CONTAINERNAME_Model, new String[] { "Model", "StructureType" }); //$NON-NLS-1$ //$NON-NLS-2$
				modelElements.addAll(structType);
				List<Association> association = QueryService.getInstance().queryInstances(connection, partitionScopeProvider,
						MOFToolEditorPlugin.CONTAINERNAME_Model, new String[] { "Model", "Association" }); //$NON-NLS-1$ //$NON-NLS-2$
				modelElements.addAll(association);
			}
		}

		for (ModelElement modelElement : modelElements) {
			// OclGenerated packages
			String[] qualifiedName = modelElement.getQualifiedName().toArray(new String[0]);
			if (!qualifiedName[0].startsWith("OclGenerated")) { //$NON-NLS-1$
				contentProvider.add(modelElement, itemsFilter);
			}
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
		ModelElement modelElement = (ModelElement) item;
		return createFQN(modelElement);
	}

	String createFQN(ModelElement modelElement) {
		if (modelElement == null) {
			return ""; //$NON-NLS-1$
		}
		List<String> qualifiedName = modelElement.getQualifiedName();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < qualifiedName.size(); i++) {
			sb.append(qualifiedName.get(i));
			if (i != qualifiedName.size() - 1) {
				sb.append('.');
			}
		}
		return sb.toString();
	}

	@Override
	protected Comparator<ModelElement> getItemsComparator() {
		return new Comparator<ModelElement>() {
			public int compare(ModelElement o1, ModelElement o2) {
				return createFQN(o1).compareTo(createFQN(o2));
			}
		};
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

}
