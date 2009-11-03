package com.sap.mi.tools.mmdeploy.internal.view;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetNewWizard;
import org.eclipse.ui.part.ViewPart;

import com.sap.mi.fwk.services.local.help.MiHelp;
import com.sap.mi.fwk.ui.mm.MetamodelManagerUI;
import com.sap.mi.tools.mmdeploy.internal.MmDeploymentHelpContext;
import com.sap.mi.tools.mmdeploy.internal.MmDeploymentPlugin;
import com.sap.mi.tools.mmdeploy.internal.messages.MmDeploymentMessages;
import com.sap.mi.tools.mmdeploy.internal.view.MmSorter.MmSortListener;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;

/**
 * The deployment view
 * 
 * @author d031150
 */
public final class MmDeploymentView extends ViewPart {

	private static final String GROUP_EDIT = "group.edit"; //$NON-NLS-1$
	private static final String GROUP_END = "group.end"; //$NON-NLS-1$
	private static final String GROUP_FILTER = "group.filter"; //$NON-NLS-1$
	private static final String[] COLUMNS = new String[] { MmDeploymentMessages.view_column_label,
			MmDeploymentMessages.view_column_containerName, MmDeploymentMessages.view_column_plugin,
			MmDeploymentMessages.view_column_version, MmDeploymentMessages.view_column_status };
	private static final int[] WIDTHS = new int[] { 170, 240, 250, 50, 100 };
	// attached at widgets referenced by UI tests
	private static final String WIDGET_DATA_NAME = "name"; //$NON-NLS-1$

	private TreeViewer mViewer;

	private IPropertyChangeListener mWorkingSetListener = new WorkingSetListener();

	public MmDeploymentView() {
	}

	public void createPartControl(Composite parent) {
		createTreeViewer(parent);

		// update action with correct state from preference
		// need to do this async since here command fwk is not fully initialized
		getSite().getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				ShowWorkingSetsAction.update(MmDeploymentView.this);
			}
		});
	}

	private void createTreeViewer(Composite parent) {
		mViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		Tree tree = mViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		tree.setData(WIDGET_DATA_NAME, "MmDeploymentView.Tree"); //$NON-NLS-1$ for testing purposes

		// Set label provider on viewer before columns are created since this
		// call
		// reset the columns' CellLabelProviders.
		mViewer.setLabelProvider(new MmLabelProvider(mViewer));

		Listener sortListener = new MmSortListener(mViewer);
		for (int i = 0; i < COLUMNS.length; i++) {
			String name = COLUMNS[i];
			TreeColumn col = new TreeColumn(tree, SWT.NONE);
			col.setText(name);
			col.setWidth(WIDTHS[i]);
			col.addListener(SWT.Selection, sortListener);
			col.setMoveable(true);
			TreeViewerColumn viewerCol = new TreeViewerColumn(mViewer, col);
			viewerCol.setLabelProvider(new MmLabelProvider(mViewer, i));
		}
		tree.setSortColumn(tree.getColumn(0));
		tree.setSortDirection(SWT.UP);

		mViewer.setContentProvider(new MmContentProvider(this));
		ColumnViewerToolTipSupport.enableFor(mViewer);
		mViewer.setComparator(new MmSorter());

		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		initDragDrop();

		getSite().setSelectionProvider(mViewer);
		PlatformUI.getWorkbench().getWorkingSetManager().addPropertyChangeListener(mWorkingSetListener);

		MiHelp.setHelp(parent, MmDeploymentHelpContext.DeploymentView);

		mViewer.setInput(getViewSite());
	}

	public void update(MmDeploymentInfo complete) {
		refresh();
	}

	public void refresh() {
		// check for not yet created or already disposed UI
		if (isDisposed())
			return;

		mViewer.refresh(true);
		expandOnlyElement();
	}

	public TreeViewer getTreeviewer() {
		return mViewer;
	}

	void expand(Object element) {
		if (isDisposed())
			return;
		mViewer.expandToLevel(element, AbstractTreeViewer.ALL_LEVELS);
	}

	TreeViewer getViewer() {
		return mViewer;
	}

	private void expandOnlyElement() {
		Tree tree = mViewer.getTree();
		TreeItem[] items = tree.getItems();
		if (items.length == 1) {
			Object element = items[0].getData();
			expand(element);
		}
	}

	public boolean isDisposed() {
		boolean disposed = mViewer == null || mViewer.getControl().isDisposed();
		return disposed;
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				MmDeploymentView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(mViewer.getControl());
		mViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, mViewer);
	}

	private void contributeToActionBars() {
		IViewSite viewSite = getViewSite();
		IActionBars bars = viewSite.getActionBars();

		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(new Separator(GROUP_EDIT));
		manager.add(new Separator());
		manager.add(new Separator(GROUP_FILTER));
		manager.add(new Separator());
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		manager.add(new Separator());
		manager.add(new Separator(GROUP_END));
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(new Separator(GROUP_EDIT));
		manager.add(new Separator());
		manager.add(new Separator(GROUP_FILTER));
		manager.add(new Separator());
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		manager.add(new Separator());
		manager.add(new Separator(GROUP_END));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(new Separator(GROUP_EDIT));
		manager.add(new Separator());
		manager.add(new Separator(GROUP_FILTER));
		manager.add(new Separator());
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		manager.add(new Separator());
		manager.add(new Separator(GROUP_END));
	}

	private void hookDoubleClickAction() {
	}

	private void initDragDrop() {
		LocalSelectionTransfer transfer = LocalSelectionTransfer.getTransfer();

		mViewer.addDragSupport(DND.DROP_MOVE | DND.DROP_COPY, new Transfer[] { transfer }, new MmDragListener(this));

		mViewer.addDropSupport(DND.DROP_MOVE | DND.DROP_COPY, new Transfer[] { transfer }, new MmDropListener(this));
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		mViewer.getControl().setFocus();
	}

	public void dispose() {
		getSite().setSelectionProvider(null);
		PlatformUI.getWorkbench().getWorkingSetManager().removePropertyChangeListener(mWorkingSetListener);
		super.dispose();
	}

	void setShowWorkingSets(boolean show) {
		MmDeploymentPlugin.setPrefShowWorkingSets(show);

		// make the changes visible
		refresh();

		if (show) {
			Tree tree = mViewer.getTree();
			TreeItem[] items = tree.getItems();

			if (items.length == 1) {
				Object element = items[0].getData();

				// If there are no working sets defined, i.e. only the "Others"
				// set is visible,
				// show the working set creation dialog.
				if (element instanceof MmWorkingSetNode) {
					MmWorkingSetNode node = (MmWorkingSetNode) element;
					if (node.isOthers()) {
						IWorkingSet newSet = showCreateWorkingSetDialog();
						if (newSet != null) {
							// save the new set
							PlatformUI.getWorkbench().getWorkingSetManager().addWorkingSet(newSet);
							// and expand it
							MmWorkingSetNode newNode = MmContentProvider.toWorkingSetNode(newSet);
							expand(newNode);
							return;
						}
					}
				}

				// otherwise expand the only element (either a custom one or
				// Others)
				expandOnlyElement();
			}
		}
	}

	static boolean showWorkingSets() {
		return MmDeploymentPlugin.getPrefShowWorkingSets();
	}

	private IWorkingSet showCreateWorkingSetDialog() {
		IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
		IWorkingSetNewWizard wizard = workingSetManager
				.createWorkingSetNewWizard(new String[] { MetamodelManagerUI.ID_METAMODEL_WORKING_SET });
		WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
		if (dialog.open() == Window.OK)
			return wizard.getSelection();
		return null;
	}

	private final class WorkingSetListener implements IPropertyChangeListener {
		public void propertyChange(PropertyChangeEvent event) {
			String property = event.getProperty();
			if (IWorkingSetManager.CHANGE_WORKING_SET_ADD.equals(property)
					|| IWorkingSetManager.CHANGE_WORKING_SET_CONTENT_CHANGE.equals(property)
					|| IWorkingSetManager.CHANGE_WORKING_SET_LABEL_CHANGE.equals(property)
					|| IWorkingSetManager.CHANGE_WORKING_SET_NAME_CHANGE.equals(property)
					|| IWorkingSetManager.CHANGE_WORKING_SET_REMOVE.equals(property)) {
				refresh();
			}
		}
	}

}