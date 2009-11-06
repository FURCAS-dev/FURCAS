package com.sap.mi.tools.cockpit.editor.ui;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeLabelProvider;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.action.CollapseAllAction;
import com.sap.mi.tools.cockpit.editor.action.DeleteRefObjectAction;
import com.sap.mi.tools.cockpit.editor.action.IContextMenuConstants;
import com.sap.mi.tools.cockpit.editor.action.MoveModelElementToPartitionAction;
import com.sap.mi.tools.cockpit.editor.action.OpenObjectAction;
import com.sap.mi.tools.cockpit.editor.action.ReloadAction;
import com.sap.mi.tools.cockpit.editor.action.ShowLegendAction;
import com.sap.mi.tools.cockpit.editor.action.ShowPropertiesViewAction;
import com.sap.mi.tools.cockpit.editor.action.ToggleContainerPresentationToFlatAction;
import com.sap.mi.tools.cockpit.editor.action.ToggleContainerPresentationToHierachicalAction;
import com.sap.mi.tools.cockpit.editor.action.ToggleTopLevelToMetaModelNames;
import com.sap.mi.tools.cockpit.editor.action.ToggleTopLevelToPartitions;
import com.sap.mi.tools.cockpit.editor.model.RefObjectNode;
import com.sap.mi.tools.cockpit.editor.model.RefObjectNodeSearcher;
import com.sap.mi.tools.cockpit.editor.model.VIEWER_MODE;
import com.sap.mi.tools.cockpit.editor.model.properties.MOINModelBrowserPropertySourceManager;
import com.sap.mi.tools.cockpit.editor.model.properties.PropertyHelper;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserContentProvider;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserLabelProvider;
import com.sap.mi.tools.cockpit.editor.ui.listener.ModelBrowserDragSourceListener;
import com.sap.mi.tools.cockpit.editor.ui.listener.ModelBrowserDropListener;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * @author d003456
 * 
 */
public class MOINBrowserView extends ViewPart implements ISelectionListener {

	public static final String ID = MOINBrowserView.class.getName();

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MODELBROWSER);

	private static final String SEARCH_VIEW_ID = "org.eclipse.search.ui.views.SearchView"; //$NON-NLS-1$

	private static final String DIALOG_TITLE_NOT_REVEALED = Messages.MOINBrowserView_0_xhed;

	private static final String SEARCH_START = "Search started for "; //$NON-NLS-1$

	public static boolean isContainerPresentationHierarchical = true;

	public static boolean isTopLevelNodePartition = true;

	private final TreeNodeLabelProvider labelProvider = new MOINBrowserLabelProvider();

	private TreeViewer treeViewer;

	private PropertySheetPage propertySheetPage;

	private Action reloadAction = null;

	private ToggleContainerPresentationToFlatAction toggleContainerPresentationToFlatAction = null;

	private ToggleContainerPresentationToHierachicalAction toggleContainerPresentationToHierarchicalAction = null;

	private ToggleTopLevelToPartitions toggleTopLevelToPartitions = null;

	private ToggleTopLevelToMetaModelNames toggleTopLevelToMetaModelNames = null;

	private Action showLegendAction = null;

	private Action collapseAllAction = null;

	private Action showPropertiesViewAction = null;

	private Action moveModelElementToPartionAction = null;
	
	private Action deleteRefObjectAction = null;
	
	private Action openObjectAction = null;

	private ModelManager modelManager = null;

	private ITreeNode<?> currSelection = null;

	private RefObjectNodeSearcher refObjectNodeSearcher;

	/**
	 * Switch used by tests to make view initialization synchronous
	 */
	private static volatile boolean synchronousInit = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {

		this.treeViewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		this.treeViewer.setUseHashlookup(true);
		this.treeViewer.addDropSupport(DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT, new Transfer[] { LocalSelectionTransfer
				.getInstance() }, new ModelBrowserDropListener(this));
		this.treeViewer.addDragSupport(DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT, new Transfer[] { LocalSelectionTransfer
				.getInstance() }, new ModelBrowserDragSourceListener(this));
		createActions();
		contributeToActionBars();
		hookContextMenu();
		hookClickAction();
		// hookDoubleClickAction();
		this.modelManager = ModelManager.getInstance();
		this.refObjectNodeSearcher = new RefObjectNodeSearcher(this);
		getSite().setSelectionProvider(this.treeViewer);
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(MOINBrowserView.SEARCH_VIEW_ID, this);

		if (MOINBrowserView.synchronousInit) {
			setBrowserRoots(ResourcesPlugin.getWorkspace().getRoot().getProjects());
		} else {
			// Load data async the first time. Otherwise, if connections are
			// created
			// in ModalContext thread, an exception is thrown on workbench
			// startup
			// since ModalContext is disabled this early.
			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {

					setBrowserRoots(ResourcesPlugin.getWorkspace().getRoot().getProjects());
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {

		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(MOINBrowserView.SEARCH_VIEW_ID, this);
		super.dispose();
	}

	/**
	 * Sets whether the view's initialization should be done synchronously. To be used by tests only.
	 */
	public static void setInitSynchronous(boolean synchronous) {

		MOINBrowserView.synchronousInit = synchronous;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {

		this.treeViewer.getControl().setFocus();
	}

	public void refresh() {

		processOutstandingEvents();
		this.treeViewer.getControl().setRedraw(false);
		this.treeViewer.refresh();
		this.treeViewer.getControl().setRedraw(true);
	}

	public void reload() {

		processOutstandingEvents();
		this.treeViewer.getControl().setRedraw(false);
		setBrowserRoots(ResourcesPlugin.getWorkspace().getRoot().getProjects());
		this.treeViewer.getControl().setRedraw(true);
	}

	public void collapseAll() {

		this.treeViewer.collapseAll();
	}

	private void processOutstandingEvents() {

		final Display display = Display.getCurrent();
		if (display != null && !display.isDisposed()) {
			display.update();
		}
	}

	public void setBrowserRoots(IProject[] projects) {

		final List<IProject> allProjects = new ArrayList<IProject>();
		for (int i = 0; i < projects.length; i++) {
			if (this.modelManager.isMoinProject(projects[i])) {
				allProjects.add(projects[i]);
			}
		}

		if (MOINBrowserView.isTopLevelNodePartition) {
			MOINBrowserView.this.treeViewer.setContentProvider(new MOINBrowserContentProvider(VIEWER_MODE.PARTITION_BASED));
		} else {
			MOINBrowserView.this.treeViewer.setContentProvider(new MOINBrowserContentProvider(VIEWER_MODE.MODEL_BASED));
		}
		MOINBrowserView.this.treeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider((IStyledLabelProvider) this.labelProvider));
		MOINBrowserView.this.treeViewer.setInput(allProjects.toArray(new IProject[allProjects.size()]));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {

		if (IPropertySheetPage.class == adapter) {

			return setupPropertyPage();
		}

		return super.getAdapter(adapter);
	}

	private IPropertySheetPage setupPropertyPage() {

		// clean up old page ...
		// this is necessary if prop view has been closed and reopened
		if (this.propertySheetPage != null) {
			this.propertySheetPage.dispose();
		}
		this.propertySheetPage = new PropertySheetPage();
		final PropertySheetEntry p = new PropertySheetEntry();

		p.setPropertySourceProvider(new MOINModelBrowserPropertySourceManager());
		this.propertySheetPage.setRootEntry(p);
		return this.propertySheetPage;

	}

	/**
	 * instantiate the static actions
	 * 
	 */
	private void createActions() {

		IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
		
		this.collapseAllAction = new CollapseAllAction(this);
		this.reloadAction = new ReloadAction(this);

		this.showLegendAction = new ShowLegendAction();

		this.toggleContainerPresentationToFlatAction = new ToggleContainerPresentationToFlatAction(this);
		this.toggleContainerPresentationToHierarchicalAction = new ToggleContainerPresentationToHierachicalAction(this);
		this.toggleContainerPresentationToHierarchicalAction.setChecked(true);

		this.toggleTopLevelToPartitions = new ToggleTopLevelToPartitions(this);
		this.toggleTopLevelToMetaModelNames = new ToggleTopLevelToMetaModelNames(this);
		this.toggleTopLevelToPartitions.setChecked(true);

		this.showPropertiesViewAction = new ShowPropertiesViewAction(this);
		this.moveModelElementToPartionAction = new MoveModelElementToPartitionAction(this);
		
		this.deleteRefObjectAction = new DeleteRefObjectAction(handlerService);
		this.openObjectAction = new OpenObjectAction(this);

	}

	private void hookClickAction() {

		this.treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {

				final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection.getFirstElement() instanceof ITreeNode) {
					MOINBrowserView.this.currSelection = (ITreeNode<?>) selection.getFirstElement(); // null
				}
			}
		});
	}

	private void createContextMenuGroups(IMenuManager menu) {

		menu.add(new Separator(IContextMenuConstants.GROUP_NEW));
		menu.add(new GroupMarker(IContextMenuConstants.GROUP_GOTO));
		menu.add(new GroupMarker(IContextMenuConstants.GROUP_OPEN));
		menu.add(new Separator(IContextMenuConstants.GROUP_SHOW));
		menu.add(new Separator(IContextMenuConstants.GROUP_EDIT));
		menu.add(new GroupMarker(IContextMenuConstants.GROUP_REMOVE_MATCHES));
		menu.add(new Separator(IContextMenuConstants.GROUP_REORGANIZE));
		menu.add(new GroupMarker(IContextMenuConstants.GROUP_GENERATE));
		menu.add(new Separator(IContextMenuConstants.GROUP_SEARCH));
		menu.add(new Separator(IContextMenuConstants.GROUP_BUILD));
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(new Separator(IContextMenuConstants.GROUP_VIEWER_SETUP));
		menu.add(new Separator(IContextMenuConstants.GROUP_PROPERTIES));
	}

	private void hookContextMenu() {

		final MenuManager menuMgr = new MenuManager("#PopupMenu"); //$NON-NLS-1$
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {

				createContextMenuGroups(manager);
				MOINBrowserView.this.fillContextMenu(manager);
			}
		});
		final Menu menu = menuMgr.createContextMenu(this.treeViewer.getControl());
		this.treeViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, this.treeViewer);
	}

	private void fillContextMenu(IMenuManager manager) {

		final IStructuredSelection sel = (IStructuredSelection) this.treeViewer.getSelection();
		if (sel.getFirstElement() instanceof RefObjectNode) {
			manager.appendToGroup(IContextMenuConstants.GROUP_SHOW, this.showPropertiesViewAction);
			manager.appendToGroup(IContextMenuConstants.GROUP_EDIT, this.deleteRefObjectAction);
			manager.appendToGroup(IContextMenuConstants.GROUP_GENERATE, this.moveModelElementToPartionAction);
		}
	}

	private void contributeToActionBars() {

		final IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalToolBar(IToolBarManager manager) {

		manager.add(this.collapseAllAction);
		manager.add(this.reloadAction);
		manager.add(this.openObjectAction);
	}

	private void fillLocalPullDown(IContributionManager manager) {

		manager.add(this.showLegendAction);
		manager.add(new Separator());
		manager.add(this.reloadAction);
		manager.add(new Separator());
		final IMenuManager subMenuTopLevelNodes = new MenuManager(Messages.MOINBrowserView_1_xmen, "TopLevelNodes"); //$NON-NLS-1$
		subMenuTopLevelNodes.add(this.toggleTopLevelToPartitions);
		subMenuTopLevelNodes.add(this.toggleTopLevelToMetaModelNames);
		manager.add(subMenuTopLevelNodes);

		final IMenuManager subMenuPresentation = new MenuManager(Messages.MOINBrowserView_2_xmen, "PartitionContainerPresentation"); //$NON-NLS-1$
		subMenuPresentation.add(this.toggleContainerPresentationToFlatAction);
		subMenuPresentation.add(this.toggleContainerPresentationToHierarchicalAction);
		manager.add(subMenuPresentation);
	}

	/**
	 * for Testing!
	 * 
	 * @param i
	 */
	public void expandToLevel(int i) {

		this.treeViewer.expandToLevel(i);
		this.treeViewer.refresh();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

		if (!selection.isEmpty() && ((IStructuredSelection) selection).getFirstElement() instanceof RefObject) {
			final RefObject refObject = (RefObject) ((IStructuredSelection) selection).getFirstElement();
			final PropertyHelper helper = new PropertyHelper();
			String msg = ""; //$NON-NLS-1$
			if (MOINBrowserView.tracer.isLoggable(Level.FINE)) {
				msg = MOINBrowserView.SEARCH_START + helper.getQualifiedName(refObject);
			}
			MOINBrowserView.tracer.logp(Level.FINE, MOINBrowserView.class.getName(), "selectionChanged", msg); //$NON-NLS-1$

			// reveal RefObject, otherwise display message
			if (!this.refObjectNodeSearcher.revealRefObjectNodeinModelTree(refObject)) {
				msg = ""; //$NON-NLS-1$
				final String name = helper.getQualifiedName(refObject);
				final String msgPattern = Messages.MOINBrowserView_3_xmsg;
				msg = MessageFormat.format(msgPattern, new Object[] { name });
				MOINBrowserView.tracer.logp(Level.FINE, MOINBrowserView.class.getName(), "selectionChanged", msg); //$NON-NLS-1$
				MessageDialog.openInformation(getTreeViewer().getControl().getShell(), MOINBrowserView.DIALOG_TITLE_NOT_REVEALED, msg);
			}
		}
	}

	/**
	 * Adapts an {@link Object} to an {@link RefObject} if possible.
	 * 
	 * @param obj
	 *            the object of type {@link Object} to adapt to type {@link RefObject}
	 * @return an object of type {@link RefObject} if adaptation is possible, otherwise <code>null</code>
	 */
	public static RefObject getRefObject(Object obj) {

		if (obj instanceof RefObject)
			return (RefObject) obj;
		if (obj instanceof TreeNodeRefObject<?>) {
			return ((TreeNodeRefObject<?>) obj).getValue();
		}
		if (obj instanceof IStructuredSelection) {
			if (((IStructuredSelection) obj).isEmpty())
				return null;
			obj = ((IStructuredSelection) obj).getFirstElement();
			return getRefObject(obj);
		}
		if ((obj instanceof TreeItem) && !(obj instanceof IAdaptable)) {
			obj = ((TreeItem) obj).getData();
		}
		if ((obj instanceof TableItem) && !(obj instanceof IAdaptable)) {
			obj = ((TableItem) obj).getData();
		}
		if (obj instanceof RefObject) {
			return (RefObject) obj;
		}
		if (obj instanceof IAdaptable) {
			final RefObject devobj = (RefObject) ((IAdaptable) obj).getAdapter(RefObject.class);
			return devobj;
		}

		return null;
	}

	public ToggleContainerPresentationToFlatAction getContainerPresentationToFlat() {

		return this.toggleContainerPresentationToFlatAction;
	}

	public ToggleContainerPresentationToHierachicalAction getContainerPresentationToHierarchical() {

		return this.toggleContainerPresentationToHierarchicalAction;
	}

	public ToggleTopLevelToMetaModelNames getToggleTopLevelToMetaModelNames() {

		return this.toggleTopLevelToMetaModelNames;
	}

	public Action getCollapseAllAction() {

		return this.collapseAllAction;
	}

	public ToggleTopLevelToPartitions getToggleTopLevelToPartitions() {

		return this.toggleTopLevelToPartitions;
	}

	public Action getShowLegendAction() {

		return this.showLegendAction;
	}

	public Action getReloadAction() {

		return this.reloadAction;
	}

	public Action getShowPropertiesViewAction() {

		return this.showPropertiesViewAction;
	}
	
	/**
	 * @return the openObjectAction
	 */
	public final Action getOpenObjectAction() {
	
		return this.openObjectAction;
	}

	/**
	 * @return the moveModelElementToPartionAction
	 */
	public final Action getMoveModelElementToPartionAction() {
	
		return this.moveModelElementToPartionAction;
	}

	/**
	 * @return the currSelection
	 */
	public ITreeNode<?> getCurrSelection() {

		return this.currSelection;
	}

	/**
	 * @param currSelection
	 *            the currSelection to set
	 */
	public void setCurrSelection(ITreeNode<?> currSelection) {

		this.currSelection = currSelection;
	}

	/**
	 * @return the treeViewer
	 */
	public TreeViewer getTreeViewer() {

		return this.treeViewer;
	}

}
