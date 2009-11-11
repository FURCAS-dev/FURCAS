package com.sap.ide.moftool.editor.internal.refactoring.ui.dialog;

import java.util.Comparator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

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

import com.sap.ide.moftool.editor.internal.LocalizationMessages;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.tc.moin.repository.Connection;

public class SelectPackageDialog extends FilteredItemsSelectionDialog {


	private static final String DIALOG_SETTINGS = "com.sap.ide.moftool.editor.refactoring.ui.SelectPackageDialog"; //$NON-NLS-1$

	public static String CONTAINERNAME_Model = "sap.com/tc/moin/mof_1.4"; //$NON-NLS-1$

	private final Connection con;

	private final IPackageFilterCallback filterCallback;

	public SelectPackageDialog(Shell shell, final Connection con, IPackageFilterCallback filterCallback) {
		super(shell);
		this.con = con;
		this.filterCallback = filterCallback;
		setTitle(LocalizationMessages.SelectPackageDialog_0_XGRP);
		setListLabelProvider(new LabelProvider() {
			private final Image packageImg = MOFToolEditorPlugin.imageDescriptorFromPlugin(MOFToolEditorPlugin.ID,
					"resources/icons/metamodel/Package.gif").createImage(); //$NON-NLS-1$

			@Override
			public String getText(Object element) {
				MofPackage pkg = (MofPackage) element;
				return createFQN(pkg);
			}

			@Override
			public Image getImage(Object element) {
				return packageImg;
			}

			@Override
			public void dispose() {
				super.dispose();
				packageImg.dispose();
			}
		});
		// <pg101208> initially show full result
		super.setInitialPattern("?"); //$NON-NLS-1$

		// TODO: Double check. Is that the way to store / restore references
		// Moin elements?
/*		<pg101208> do not show history since this leads to wrong move into foreign DC
		setSelectionHistory(new SelectionHistory() {

			@Override
			protected void storeItemToMemento(Object item, IMemento memento) {
					MofPackage pack = (MofPackage) item;
					memento.putString("mofId", ((Partitionable) pack).get___Mri().getLri().toString()); //$NON-NLS-1$
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
				if (item instanceof MofPackage) {
					MofPackage pack = (MofPackage) item;
					return matches(createFQN(pack)) && filterCallback.matches(pack);

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
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter,
			IProgressMonitor progressMonitor) throws CoreException {
		// <pg101208> use inner instead of visible scope because objects must not be moved into used (readonly) DCs
		IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(con,
				PartitionScope.INNER);
		List<MofPackage> packages = QueryService.getInstance().queryInstances(con, partitionScopeProvider,
				CONTAINERNAME_Model, new String[] { "Model", "Package" }); //$NON-NLS-1$ //$NON-NLS-2$
		for (MofPackage mofPackage : packages) {
			// <pg101208> exclude artificial OclGenerated packages
			String[] sa = mofPackage.getQualifiedName().toArray(new String[0]);
			if (!sa[0].startsWith("OclGenerated")) {	 //$NON-NLS-1$
				contentProvider.add(mofPackage, itemsFilter);
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
		MofPackage pack = (MofPackage) item;
		return createFQN(pack);
	}

	String createFQN(MofPackage pkg) {
		if (pkg == null) {
			return ""; //$NON-NLS-1$
		}
		List<String> qualifiedName = pkg.getQualifiedName();
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
	protected Comparator<MofPackage> getItemsComparator() {
		return new Comparator<MofPackage>() {
			public int compare(MofPackage o1, MofPackage o2) {
				return createFQN(o1).compareTo(createFQN(o2));
			}
		};
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

}
