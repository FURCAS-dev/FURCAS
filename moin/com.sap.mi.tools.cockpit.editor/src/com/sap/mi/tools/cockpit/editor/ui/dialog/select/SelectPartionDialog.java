/**
 * 
 */
package com.sap.mi.tools.cockpit.editor.ui.dialog.select;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.Assert;
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
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.sap.mi.tools.cockpit.editor.MOINBrowser;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.tc.moin.repository.ModelPartition;

/**
 * @author d003456
 * 
 */
public class SelectPartionDialog extends FilteredItemsSelectionDialog {

	private static final String SETTINGS = SelectPartionDialog.class.getCanonicalName();

	private static final String DIALOG_TITLE = Messages.SelectPartionDialog_0_xhed;

	private static final String PROGRESS_MONITOR_BEGIN_TASK = Messages.SelectPartionDialog_1_xtxt;

	private static final String UNKNOWN_OBJECT = Messages.SelectPartionDialog_2_xfld;

	private final TreeMap<String, ModelPartition> modelPartitions;

	private final ModelPartition sourcePartition;

	/**
	 * Creates {@link SelectPartionDialog}.
	 * 
	 * @param shell
	 * @param multi
	 * @param modelPartitions
	 */
	public SelectPartionDialog(Shell shell, boolean multi, TreeMap<String, ModelPartition> modelPartitions, ModelPartition sourcePartition) {

		super(shell, multi);
		Assert.isNotNull(shell);
		Assert.isLegal(sourcePartition != null && sourcePartition.isAlive());
		Assert.isLegal(modelPartitions != null && !modelPartitions.isEmpty());
		this.modelPartitions = modelPartitions;
		this.sourcePartition = sourcePartition;

		setTitle(SelectPartionDialog.DIALOG_TITLE);

		setListLabelProvider(new LabelProvider() {
			@Override
			public Image getImage(Object element) {

				Image image = MOINBrowser.getDefault().getImage(MOINBrowser.UNKNOWN_OBJECT_IMAGE);
				if (element instanceof ModelPartition) {
					image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
				}
				return image;
			}

			@Override
			public String getText(Object element) {

				String label = SelectPartionDialog.UNKNOWN_OBJECT;
				if (element != null && element instanceof ModelPartition) {
					final ModelPartition modelPartition = (ModelPartition) element;
					label = getLabel(modelPartition);
				}
				return label;
			}

		});

		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public Image getImage(Object element) {

				Image image = MOINBrowser.getDefault().getImage(MOINBrowser.UNKNOWN_OBJECT_IMAGE);
				if (element instanceof ModelPartition) {
					image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
				}
				return image;
			}

			@Override
			public String getText(Object element) {

				String label = SelectPartionDialog.UNKNOWN_OBJECT;
				if (element != null && element instanceof ModelPartition) {
					final ModelPartition modelPartition = (ModelPartition) element;
					label = modelPartition.getPri().getPartitionName();
				}
				return label;
			}

		});
		setSelectionHistory(new SelectionHistory() {

			private final String key = SelectPartionDialog.class.getCanonicalName() + "PartitionName"; //$NON-NLS-1$

			@Override
			protected void storeItemToMemento(Object item, IMemento memento) {

				if (item != null && item instanceof ModelPartition) {
					final ModelPartition modelPartition = (ModelPartition) item;
					memento.putString(this.key, modelPartition.getPri().getPartitionName());
				}
			}

			@Override
			protected Object restoreItemFromMemento(IMemento memento) {

				try {
					ModelPartition mementoPartition = SelectPartionDialog.this.modelPartitions.get(memento.getString(this.key));
					if (mementoPartition.getPri() != SelectPartionDialog.this.sourcePartition.getPri()) {
						return mementoPartition;
					}
				}
				catch (final Exception e) {
					final String unresolvedPartition = memento.getString(this.key);
					if (unresolvedPartition != null) {
						remove(unresolvedPartition);
					}
				}
				return null;
			}
		});
		setInitialPattern("?"); //$NON-NLS-1$
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createFilter()
	 */
	@Override
	protected ItemsFilter createFilter() {

		return new ItemsFilter() {
			@Override
			public boolean matchItem(Object item) {

				if (item instanceof ModelPartition) {
					final ModelPartition modelPartition = (ModelPartition) item;
					return matches(getLabel(modelPartition));
				}
				return matches(item.toString());
			}

			@Override
			public boolean isConsistentItem(Object item) {

				return true;
			}
		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#fillContentProvider(org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.
	 * AbstractContentProvider, org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {

		progressMonitor.beginTask(SelectPartionDialog.PROGRESS_MONITOR_BEGIN_TASK, this.modelPartitions.size());

		for (final Map.Entry<String, ModelPartition> e : this.modelPartitions.entrySet()) {
			if (!e.getValue().getPri().equals(this.sourcePartition.getPri())) {
				contentProvider.add(e.getValue(), itemsFilter);
			}
			progressMonitor.worked(1);
		}
		progressMonitor.done();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getDialogSettings()
	 */
	@Override
	protected IDialogSettings getDialogSettings() {

		IDialogSettings settings = MOINBrowser.getDefault().getDialogSettings().getSection(SelectPartionDialog.SETTINGS);
		if (settings == null) {
			settings = MOINBrowser.getDefault().getDialogSettings().addNewSection(SelectPartionDialog.SETTINGS);
		}
		return settings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getElementName(java.lang.Object)
	 */
	@Override
	public String getElementName(Object item) {

		final ModelPartition modelPartition = (ModelPartition) item;
		return getLabel(modelPartition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getItemsComparator()
	 */
	@Override
	protected Comparator<ModelPartition> getItemsComparator() {

		return new Comparator<ModelPartition>() {
			public int compare(ModelPartition o1, ModelPartition o2) {

				return getLabel(o1).compareTo(getLabel(o2));
			}
		};
	}

	private String getLabel(ModelPartition modelPartition) {

		String label = ""; //$NON-NLS-1$
		if (modelPartition != null) {
			label = modelPartition.getPri().getPartitionName();
			label = label.substring(label.lastIndexOf("/") + 1); //$NON-NLS-1$
		}
		return label;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#validateItem(java.lang.Object)
	 */
	@Override
	protected IStatus validateItem(Object item) {

		return Status.OK_STATUS;
	}

}
