package com.sap.mi.tools.cockpit.editor.ui.dialog.select;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.tools.cockpit.editor.MOINBrowser;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.model.ProjectRootNode;
import com.sap.mi.tools.cockpit.editor.model.properties.PropertyHelper;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;

/**
 * @author d003456
 * 
 */
public class SelectRefObjectDialog extends FilteredItemsSelectionDialog {

	private static final String PROGRESS_MONITOR_BEGIN_TASK = Messages.SelectRefObjectDialog_0_xhed;

	private static final String UNKNOWN_OBJECT = Messages.SelectRefObjectDialog_1_xfld;

	private static final String SETTINGS = SelectRefObjectDialog.class.getCanonicalName();

	private final List<ProjectRootNode> rootNodes;

	private ModelAdapterUI modelAdapter = null;

	private final ListLabelProvider listLabelProvider;

	private static PropertyHelper propertyHelper;

	/**
	 * Creates {@link SelectRefObjectDialog}.
	 * 
	 * @param shell
	 * @param multi
	 * @param rootNodes
	 * @param aboveButtons
	 */
	public SelectRefObjectDialog(Shell shell, boolean multi, final List<ProjectRootNode> rootNodes) {

		super(shell, multi);
		Assert.isNotNull(shell);
		Assert.isLegal(rootNodes != null && !rootNodes.isEmpty());
		this.rootNodes = rootNodes;
		this.modelAdapter = ModelAdapterUI.getInstance();
		this.listLabelProvider = new ListLabelProvider();
		SelectRefObjectDialog.propertyHelper = new PropertyHelper();
		setListLabelProvider(this.listLabelProvider);
		setListSelectionLabelDecorator(this.listLabelProvider);
		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public Image getImage(Object element) {

				Image image;
				if (element instanceof RefObject) {
					image = MOINBrowser.getDefault().getImage(MOINBrowser.OBJECT_IMAGE);
				} else {
					image = MOINBrowser.getDefault().getImage(MOINBrowser.UNKNOWN_OBJECT_IMAGE);
				}
				return image;
			}

			@Override
			public String getText(Object element) {

				String text = SelectRefObjectDialog.UNKNOWN_OBJECT;
				if (element instanceof RefObject) {
					final RefObject refObject = (RefObject) element;
					final IProject project = SelectRefObjectDialog.this.modelAdapter.getProject(refObject);
					text = SelectRefObjectDialog.propertyHelper.getQualifiedName(refObject)
							+ " - " + getDecoratedProjectName(project) + " - " + SelectRefObjectDialog.propertyHelper.getPartitionName(refObject); //$NON-NLS-1$ //$NON-NLS-2$
				}
				return text;
			}
		});

		setSelectionHistory(new SelectionHistory() {

			private final String key = SelectRefObjectDialog.class.getCanonicalName() + "MofId"; //$NON-NLS-1$

			@Override
			protected void storeItemToMemento(Object item, IMemento memento) {

				final RefObject refObject = (RefObject) item;
				memento.putString(this.key, ((Partitionable) refObject).get___Mri().getLri().toString());
			}

			@Override
			protected Object restoreItemFromMemento(IMemento memento) {

				try {
					final Connection connection = (Connection) rootNodes.get(0).getAdapter(Connection.class);
					final RefBaseObject element = connection.getElement(ModelManager.getInstance().getMoinInstance().createLri(
							memento.getString(this.key)));
					return element;
				}
				catch (final Exception e) {
					final String unresolvedObject = memento.getString(this.key);
					if (unresolvedObject != null) {
						remove(unresolvedObject);
					}
				}
				return null;
			}
		});
		setInitialPattern("?"); //$NON-NLS-1$
		scheduleProgressMessageRefresh();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createExtendedContentArea(org.eclipse.swt.widgets.Composite)
	 */
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

				if (item instanceof RefObject) {
					final RefObject modelPartition = (RefObject) item;
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
	 * @seeorg.eclipse.ui.dialogs.FilteredItemsSelectionDialog#fillContentProvider(org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.
	 * AbstractContentProvider, org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {

		int size = 0;
		for (final ProjectRootNode projectRootNode : this.rootNodes) {
			size = size + projectRootNode.getAllElementsOfProject().size();
		}

		progressMonitor.beginTask(SelectRefObjectDialog.PROGRESS_MONITOR_BEGIN_TASK, size);

		for (final ProjectRootNode projectRootNode : this.rootNodes) {
			final Collection<Partitionable> elements = projectRootNode.getAllElementsOfProject();
			for (final Partitionable partitionable : elements) {
				contentProvider.add(partitionable, itemsFilter);
				progressMonitor.worked(1);
			}
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

		IDialogSettings settings = MOINBrowser.getDefault().getDialogSettings().getSection(SelectRefObjectDialog.SETTINGS);
		if (settings == null) {
			settings = MOINBrowser.getDefault().getDialogSettings().addNewSection(SelectRefObjectDialog.SETTINGS);
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

		String text = SelectRefObjectDialog.UNKNOWN_OBJECT;
		if (item instanceof RefObject) {
			text = getLabel((RefObject) item);
		}
		return text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getItemsComparator()
	 */
	@Override
	protected Comparator<RefObject> getItemsComparator() {

		return new Comparator<RefObject>() {
			public int compare(RefObject o1, RefObject o2) {

				return getLabel(o1).compareTo(getLabel(o2));
			}
		};
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

	private static String getLabel(RefObject element) {

		String finalName = SelectRefObjectDialog.propertyHelper.getQualifiedName(element);
		final String name = SelectRefObjectDialog.propertyHelper.tryGetUsefulName(element);
		if (!name.equals("")) { //$NON-NLS-1$
			finalName = finalName + name;
		}

		return finalName; // + " " +((RefObjectNode)element).getModelElement().refMofId();
	}

	private String getDecoratedProjectName(IProject project) {

		final String decoratedProjectName = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator().decorateText(
				project.getName(), project);

		if (decoratedProjectName != null && decoratedProjectName.length() > 0) {
			return decoratedProjectName;
		}
		return project.getName();
	}

	/**
	 * @author d003456
	 * 
	 */
	private static class ListLabelProvider extends LabelProvider implements ILabelDecorator, IStyledLabelProvider {

		private final PropertyHelper propertyHelper;

		/**
		 * Creates {@link ListLabelProvider}.
		 */
		public ListLabelProvider() {

			this.propertyHelper = new PropertyHelper();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
		 */
		@Override
		public Image getImage(Object element) {

			Image image;
			if (element instanceof RefObject) {
				image = MOINBrowser.getDefault().getImage(MOINBrowser.OBJECT_IMAGE);
			} else {
				image = MOINBrowser.getDefault().getImage(MOINBrowser.UNKNOWN_OBJECT_IMAGE);
			}
			return image;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object element) {

			String text = SelectRefObjectDialog.UNKNOWN_OBJECT;
			if (element instanceof RefObject) {
				final RefObject refObject = (RefObject) element;
				text = getLabel(refObject);
			}
			return text;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider#getStyledText(java.lang.Object)
		 */
		public StyledString getStyledText(Object element) {

			final String text = getText(element);
			final StyledString styledString = new StyledString(text);
			if (element instanceof RefObject) {
				final int index = text.indexOf(": "); //$NON-NLS-1$
				if (index != -1) {
					styledString.setStyle(index, text.length() - index, StyledString.DECORATIONS_STYLER);
				}
				final RefObject refObject = (RefObject) element;
				final ModelElement modelElement = this.propertyHelper.getMetaClass((RefObject) element);
				if (modelElement != null) {
					styledString.append(getStyledType(modelElement));
					styledString.append(getStyledMetaModel(refObject));
				} else {
					styledString.append(getStyledMetaModel(refObject));
				}
			}
			return styledString;
		}

		@SuppressWarnings("nls")
		private StyledString getStyledType(ModelElement modelElement) {

			final StyledString styledString = new StyledString("  <- Type=", StyledString.DECORATIONS_STYLER);
			styledString.append(modelElement.getName(), StyledString.QUALIFIER_STYLER);
			return styledString;
		}

		@SuppressWarnings("nls")
		private StyledString getStyledMetaModel(RefObject refObject) {

			final StyledString styledString = new StyledString(" <- MMName=", StyledString.DECORATIONS_STYLER);
			styledString.append(this.propertyHelper.getMetaModelName(refObject), StyledString.QUALIFIER_STYLER);
			return styledString;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ILabelDecorator#decorateImage(org.eclipse.swt.graphics.Image, java.lang.Object)
		 */
		public Image decorateImage(Image image, Object element) {

			return image;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ILabelDecorator#decorateText(java.lang.String, java.lang.Object)
		 */
		public String decorateText(String text, Object element) {

			return getText(element);
		}

	}
}
