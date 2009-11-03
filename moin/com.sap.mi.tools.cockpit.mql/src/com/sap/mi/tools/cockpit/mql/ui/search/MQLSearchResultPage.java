package com.sap.mi.tools.cockpit.mql.ui.search;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.search.ui.IQueryListener;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.search.ui.text.AbstractTextSearchViewPage;
import org.eclipse.search.ui.text.RemoveAllEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.mi.tools.cockpit.mql.search.MQLSearchQuery;
import com.sap.mi.tools.cockpit.mql.search.MQLSearchResult;
import com.sap.mi.tools.cockpit.mql.search.MQLresultSetEvent;
import com.sap.mi.tools.cockpit.mql.ui.search.action.CopyToClipboardAction;
import com.sap.mi.tools.cockpit.mql.ui.search.action.FilterSelectionAction;
import com.sap.mi.tools.cockpit.mql.ui.search.action.RemoveAllElementsAction;
import com.sap.mi.tools.cockpit.mql.ui.search.action.RemoveSelectedElementsAction;
import com.sap.mi.tools.cockpit.mql.ui.search.action.SaveQueryResultAction;
import com.sap.mi.tools.cockpit.mql.ui.search.action.SelectAllAction;
import com.sap.mi.tools.cockpit.mql.ui.search.action.ShowInModelBrowserAction;
import com.sap.mi.tools.cockpit.mql.ui.search.action.ShowNextInModelBrowserAction;
import com.sap.mi.tools.cockpit.mql.ui.search.action.ShowPrevInModelBrowserAction;
import com.sap.mi.tools.cockpit.mql.ui.search.selectionprovider.RefObjectSelectionProviderAdapter;
import com.sap.mi.tools.cockpit.mql.ui.search.selectionprovider.SelectionChangedProviderAdapter;
import com.sap.mi.tools.cockpit.mql.ui.search.selectionprovider.SelectionProviderIntermediate;
import com.sap.tc.moin.repository.mql.MQLColumnType;
import com.sap.tc.moin.repository.mql.MQLResultException;
import com.sap.tc.moin.repository.mql.MQLResultSet;

/**
 * UI representation of the search result.
 * 
 * @author d003456
 * 
 */
public final class MQLSearchResultPage extends Page implements ISearchResultPage {

	private final static String UI_JOB_NAME = "com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage"; //$NON-NLS-1$

	private final static String MENU_ID = "com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage"; //$NON-NLS-1$

	private final static String BUSY_LABEL = Messages.MQLSearchResultPage_0_xfld;

	private final static String RESULT_LABEL = Messages.MQLSearchResultPage_1_xfld;

	//
	// important note: when MOIN terms are translated, they have to be used
	//
	private final static String COLON_SUBSTRING = ": "; //$NON-NLS-1$

	private final static String MRI_TYPE = "MRI"; //$NON-NLS-1$

	private final static String COLLECTION_TYPE = "COLLECTION"; //$NON-NLS-1$

	private final static String LIST_TYPE = "LIST"; //$NON-NLS-1$

	private final static String LT_SUBSTRING = " <"; //$NON-NLS-1$

	private final static String GT_SUBSTRING = ">"; //$NON-NLS-1$

	private final static String IS_UNIQUE = "UNIQUE"; //$NON-NLS-1$

	private final static String SEPARATOR_COMMA_SUBSTRING = ", "; //$NON-NLS-1$

	private static final String KEY_LIMIT = "com.sap.mi.tools.cockpit.mql.ui.search.limit"; //$NON-NLS-1$

	private boolean batchedRemoveRows;

	private boolean batchedRemoveAll;

	private Table table;

	private StructuredViewer viewer;

	private ISearchResultViewPart viewPart;

	private final ISearchResultListener searchResultListener;

	private IQueryListener queryListener;

	private String id;

	private IPageSite site;

	private Composite viewerContainer;

	private Control busyLabel;

	private PageBook pagebook;

	private boolean isBusyShown;

	private MQLSearchResult input;

	private final int tabeleStyle = SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION;

	private SelectionProviderIntermediate selectionProviderMediator;

	private SelectionChangedProviderAdapter viewerAdapter;

	private RefObjectSelectionProviderAdapter refObjectAdapter;

	private volatile boolean isUIUpdateScheduled = false;

	private volatile boolean scheduleEnsureSelection = false;

	private MenuManager menuMgr;

	private final Action saveResultAction;

	private final com.sap.mi.tools.cockpit.mql.ui.search.action.CopyToClipboardAction copyToClipboardAction;

	private final SelectAllAction selectAllAction;

	private final Action removeSelectedElements;

	private final Action removeAllElementsAction;

	private final Action showInModelBrowserAction;

	private final Action showNextAction;

	private final Action showPreviousAction;

	private IAction filterAction;

	private Integer elementLimit;

	private static final int DEFAULT_ELEMENT_LIMIT = 1000;

	/**
	 * Creates MQLSearchResultPage.
	 */
	public MQLSearchResultPage() {

		super();
		this.isBusyShown = true;
		this.searchResultListener = new ISearchResultListener() {
			public void searchResultChanged(SearchResultEvent e) {

				handleSearchResultChanged(e);
			}
		};
		this.batchedRemoveRows = false;
		this.saveResultAction = new SaveQueryResultAction(this);
		this.copyToClipboardAction = new CopyToClipboardAction();
		this.selectAllAction = new SelectAllAction();
		this.removeAllElementsAction = new RemoveAllElementsAction(this);
		this.removeSelectedElements = new RemoveSelectedElementsAction(this);
		this.showInModelBrowserAction = new ShowInModelBrowserAction(this);
		this.showNextAction = new ShowNextInModelBrowserAction(this);
		this.showPreviousAction = new ShowPrevInModelBrowserAction(this);
		// will be added and removed view menu explicitly
		this.filterAction = null;
		setElementLimit(MQLSearchResultPage.DEFAULT_ELEMENT_LIMIT);

	}

	/**
	 * Returns a dialog settings object for this search result page. There will be one dialog settings object per search result page id.
	 * 
	 * @return the dialog settings for this search result page
	 * @see AbstractTextSearchViewPage#getID()
	 */
	private IDialogSettings getSettings() {

		final IDialogSettings parent = QueryConsole.getDefault().getDialogSettings();
		IDialogSettings settings = parent.getSection(getID());
		if (settings == null) {
			settings = parent.addNewSection(getID());
		}
		return settings;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResultPage#setID(java.lang.String)
	 */
	public void setID(String id) {

		this.id = id;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResultPage#getID()
	 */
	public String getID() {

		return this.id;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResultPage#getLabel()
	 */
	public String getLabel() {

		int resultSize = 0;
		long duration = 0;
		String queryName = ""; //$NON-NLS-1$

		if (this.input != null) {
			if (this.input.getResultSize() > 0) {
				duration = ((MQLSearchQuery) this.input.getQuery()).getDuration();
			}
			resultSize = this.input.getResultSize();
			queryName = this.input.getLabel();
		}
		final Object[] parameters = new Object[] { queryName, resultSize, duration };
		return this.input != null ? MessageFormat.format(MQLSearchResultPage.RESULT_LABEL, parameters) : ""; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResultPage#getUIState()
	 */
	public Object getUIState() {

		return this.viewer.getSelection();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResultPage#restoreState(org.eclipse.ui.IMemento)
	 */
	public void restoreState(IMemento memento) {

		int elementLimit = MQLSearchResultPage.DEFAULT_ELEMENT_LIMIT;
		try {
			elementLimit = getSettings().getInt(MQLSearchResultPage.KEY_LIMIT);
		}
		catch (final NumberFormatException e) {
		}
		if (memento != null) {
			final Integer value = memento.getInteger(MQLSearchResultPage.KEY_LIMIT);
			if (value != null) {
				elementLimit = value.intValue();
			}
		}
		setElementLimit(new Integer(elementLimit));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResultPage#saveState(org.eclipse.ui.IMemento)
	 */
	public void saveState(IMemento memento) {

		memento.putInteger(MQLSearchResultPage.KEY_LIMIT, getElementLimit().intValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResultPage#setInput(org.eclipse.search.ui.ISearchResult, java.lang.Object)
	 */
	public void setInput(ISearchResult newSearch, Object uiState) {

		if (newSearch != null && !(newSearch instanceof MQLSearchResult)) {
			return; // nothing to do
		}
		final MQLSearchResult oldSearch = this.input;
		if (oldSearch != null) {
			disconnectViewer();
			removeFilterActionsFromViewMenu();
			oldSearch.removeListener(this.searchResultListener);
		}
		this.input = (MQLSearchResult) newSearch;

		if (this.input != null) {
			// newSearch has a result, when called from action "Show Previous Searches"
			if (this.input.getResultSize() > 0) {
				createViewerDetails();
				this.saveResultAction.setEnabled(true);
			}
			this.input.addListener(this.searchResultListener);
			connectViewer(this.input);

			if (uiState instanceof ISelection) {
				this.viewer.setSelection((ISelection) uiState, true);
				((TableViewer) this.viewer).getTable().showSelection();
			} else {
				navigateNext(true);
			}

			updateBusyLabel();
			scheduleUIUpdate();

			this.filterAction = addFilterActionsToViewMenu();
		} else {
			getViewPart().updateLabel();
		}
	}

	private void removeFilterActionsFromViewMenu() {

		final IActionBars bars = getSite().getActionBars();
		final IMenuManager menu = bars.getMenuManager();
		menu.remove(FilterSelectionAction.ACTION_ID);
	}

	private IAction addFilterActionsToViewMenu() {

		Action filterSelectionAction = null;
		final MQLSearchResult input = getInput();
		if (input == null) {
			return null;
		}

		final IActionBars bars = getSite().getActionBars();
		final IMenuManager menu = bars.getMenuManager();
		filterSelectionAction = new FilterSelectionAction(this);
		menu.prependToGroup(IContextMenuConstants.GROUP_FILTERING, filterSelectionAction);

		return filterSelectionAction;
	}

	/**
	 * Returns the currently shown result.
	 * 
	 * @return the previously set result or <code>null</code>
	 * 
	 * @see MQLSearchResultPage#setInput(ISearchResult, Object)
	 */
	public MQLSearchResult getInput() {

		return this.input;
	}

	private void connectViewer(MQLSearchResult search) {

		this.viewer.setInput(search);
	}

	private void disconnectViewer() {

		this.viewer.setInput(null);
		final TableColumn[] cols = ((TableViewer) this.viewer).getTable().getColumns();
		if (cols.length > 0) {
			for (int i = 0; i < cols.length; i++) {
				cols[i].dispose();
			}
		}
	}

	/**
	 * Returns the viewer currently used in this page.
	 * 
	 * @return the currently used viewer or <code>null</code> if none has been created yet.
	 */
	public StructuredViewer getViewer() {

		return this.viewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResultPage#setViewPart(org.eclipse.search.ui.ISearchResultViewPart)
	 */
	public void setViewPart(ISearchResultViewPart part) {

		this.viewPart = part;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.IPageBookViewPage#getSite()
	 */
	@Override
	public IPageSite getSite() {

		return this.site;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.Page#init(org.eclipse.ui.part.IPageSite)
	 */
	@Override
	public void init(IPageSite pageSite) {

		this.site = pageSite;
		super.init(pageSite);
		final IMenuManager menuManager = pageSite.getActionBars().getMenuManager();
		// addLayoutActions(menuManager);
		initActionDefinitionIDs(pageSite.getWorkbenchWindow());
		menuManager.updateAll(true);
		pageSite.getActionBars().updateActionBars();
	}

	private void initActionDefinitionIDs(IWorkbenchWindow window) {

		this.copyToClipboardAction.setActionDefinitionId(IWorkbenchActionDefinitionIds.COPY);
		this.removeSelectedElements.setActionDefinitionId(IWorkbenchActionDefinitionIds.DELETE);
		this.showNextAction.setActionDefinitionId(IWorkbenchActionDefinitionIds.FIND_NEXT);
		this.showPreviousAction.setActionDefinitionId(IWorkbenchActionDefinitionIds.FIND_PREVIOUS);
		this.selectAllAction.setActionDefinitionId(IWorkbenchActionDefinitionIds.SELECT_ALL);
	}

	private void fillToolbar(IToolBarManager toolBarManager) {

		toolBarManager.appendToGroup(IContextMenuConstants.GROUP_ADDITIONS, this.saveResultAction);
		toolBarManager.appendToGroup(IContextMenuConstants.GROUP_SHOW, this.showNextAction);
		toolBarManager.appendToGroup(IContextMenuConstants.GROUP_SHOW, this.showPreviousAction);
		toolBarManager.appendToGroup(IContextMenuConstants.GROUP_REMOVE_MATCHES, this.removeSelectedElements);
		toolBarManager.appendToGroup(IContextMenuConstants.GROUP_REMOVE_MATCHES, this.removeAllElementsAction);
		final IActionBars actionBars = getSite().getActionBars();
		if (actionBars != null) {
			actionBars.setGlobalActionHandler(ActionFactory.NEXT.getId(), this.showNextAction);
			actionBars.setGlobalActionHandler(ActionFactory.PREVIOUS.getId(), this.showPreviousAction);
			actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), this.removeSelectedElements);
			actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), this.copyToClipboardAction);
			actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(), this.selectAllAction);
		}
	}

	private void fillContextMenu(IMenuManager menuManager) {

		if (canShowInModelBrowser(getViewer().getSelection())) {
			menuManager.appendToGroup(IContextMenuConstants.GROUP_SHOW, this.showInModelBrowserAction);
			menuManager.appendToGroup(IContextMenuConstants.GROUP_SHOW, this.showNextAction);
			menuManager.appendToGroup(IContextMenuConstants.GROUP_SHOW, this.showPreviousAction);
		}
		menuManager.appendToGroup(IContextMenuConstants.GROUP_EDIT, this.copyToClipboardAction);
		menuManager.appendToGroup(IContextMenuConstants.GROUP_ADDITIONS, this.saveResultAction);
		menuManager.appendToGroup(IContextMenuConstants.GROUP_REMOVE_MATCHES, this.removeSelectedElements);
		menuManager.appendToGroup(IContextMenuConstants.GROUP_REMOVE_MATCHES, this.removeAllElementsAction);
	}

	private boolean canRemoveMatchesWith(ISelection selection) {

		return !selection.isEmpty();

	}

	@SuppressWarnings("unchecked")
	private boolean canShowInModelBrowser(ISelection selection) {

		if (selection.isEmpty()) {
			return false;
		}
		if (this.viewer instanceof TableViewer) {
			if (selection instanceof IStructuredSelection) {
				final IStructuredSelection elements = (IStructuredSelection) selection;
				if (elements.getFirstElement() instanceof ArrayList) {
					final List<?> objs = (ArrayList<?>) elements.getFirstElement();
					if (objs.size() > 0 && objs.get(0) instanceof MQLCellData) {
						final List<MQLCellData> cells = (List<MQLCellData>) objs;
						for (final MQLCellData cellData : cells) {
							if (cellData.isMRI() && cellData.isLocal() && isMriResolved(cellData)) {
								return true;
							}
						}
					}
				}
			}
		} else if (this.viewer instanceof TreeViewer) {
			// for future
		}
		return false;
	}

	private boolean isMriResolved(MQLCellData cellData) {

		boolean result = false;
		if (cellData.isMRI() && getInput() != null) {
			try {
				getInput().getResult().getRefObject(cellData.getRowIndex(), cellData.getAlias());
				cellData.setResolved(true);
				result = true;
			}
			catch (final MQLResultException e) {
				cellData.setResolved(false);
				return result;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.IPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {

		this.queryListener = createQueryListener();
		this.menuMgr = new MenuManager("#PopUpMenu"); //$NON-NLS-1$
		this.menuMgr.setRemoveAllWhenShown(true);
		this.menuMgr.setParent(getSite().getActionBars().getMenuManager());
		this.menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager menuManager) {

				createContextMenuGroups(menuManager);
				fillContextMenu(menuManager);
				// disable Show In ->
				// viewPart.fillContextMenu(menuManager);
			}
		});
		this.pagebook = new PageBook(parent, SWT.NULL);
		this.pagebook.setLayoutData(new GridData(GridData.FILL_BOTH));
		this.busyLabel = createBusyControl();
		this.viewerContainer = new Composite(this.pagebook, SWT.NULL);
		this.viewerContainer.setLayoutData(new GridData(GridData.FILL_BOTH));
		this.viewerContainer.setLayout(new FillLayout());
		this.viewerAdapter = new SelectionChangedProviderAdapter(this);
		this.refObjectAdapter = new RefObjectSelectionProviderAdapter();
		this.selectionProviderMediator = new SelectionProviderIntermediate(this.viewerAdapter);
		getSite().setSelectionProvider(this.selectionProviderMediator);
		getSite().registerContextMenu(MQLSearchResultPage.MENU_ID, this.menuMgr, this.selectionProviderMediator);
		createViewer(this.viewerContainer, this.tabeleStyle);
		showBusyLabel(this.isBusyShown);
		NewSearchUI.addQueryListener(this.queryListener);

	}

	/**
	 * Creates the groups and separators for the search view's context menu
	 * 
	 * @param menu
	 *            the context menu
	 */
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

	/**
	 * Creates the groups and separators for the search view's tool bar
	 * 
	 * @param toolbar
	 *            the toolbar
	 */
	private void createToolBarGroups(IToolBarManager toolbar) {

		toolbar.add(new Separator(IContextMenuConstants.GROUP_NEW));
		toolbar.add(new GroupMarker(IContextMenuConstants.GROUP_GOTO));
		toolbar.add(new GroupMarker(IContextMenuConstants.GROUP_OPEN));
		toolbar.add(new Separator(IContextMenuConstants.GROUP_SHOW));
		toolbar.add(new Separator(IContextMenuConstants.GROUP_BUILD));
		toolbar.add(new Separator(IContextMenuConstants.GROUP_REORGANIZE));
		toolbar.add(new Separator(IContextMenuConstants.GROUP_EDIT));
		toolbar.add(new GroupMarker(IContextMenuConstants.GROUP_REMOVE_MATCHES));
		toolbar.add(new GroupMarker(IContextMenuConstants.GROUP_GENERATE));
		toolbar.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		toolbar.add(new Separator(IContextMenuConstants.GROUP_VIEWER_SETUP));
		toolbar.add(new Separator(IContextMenuConstants.GROUP_PROPERTIES));
		toolbar.add(new Separator(IContextMenuConstants.GROUP_SEARCH));
	}

	private Control createBusyControl() {

		final Table busyLabel = new Table(this.pagebook, SWT.NONE);
		final TableItem item = new TableItem(busyLabel, SWT.NONE);
		item.setText(MQLSearchResultPage.BUSY_LABEL);
		busyLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		return busyLabel;
	}

	private void showBusyLabel(boolean shouldShowBusy) {

		if (shouldShowBusy) {
			this.pagebook.showPage(this.busyLabel);
		} else {
			this.pagebook.showPage(this.viewerContainer);
		}
	}

	private void updateBusyLabel() {

		final MQLSearchResult result = getInput();
		final boolean shouldShowBusy = result != null && NewSearchUI.isQueryRunning(result.getQuery()) && result.getResultSize() == 0;
		if (shouldShowBusy == this.isBusyShown) {
			return;
		}
		this.isBusyShown = shouldShowBusy;
		showBusyLabel(this.isBusyShown);
	}

	private void disposeViewer() {

		if (this.viewer != null) {
			this.viewer.removeSelectionChangedListener(this.refObjectAdapter);
			this.viewer.getControl().dispose();
			this.viewer = null;
		}
	}

	private void createViewer(Composite parent, int layout) {

		this.viewer = new TableViewer(parent, layout);
		configureTableViewer((TableViewer) this.viewer);
		this.copyToClipboardAction.setViewer(this.viewer);
		this.selectAllAction.setViewer(this.viewer);
		enableStandardActions(false);
		final IToolBarManager toolBarManager = getSite().getActionBars().getToolBarManager();
		toolBarManager.removeAll();
		createToolBarGroups(toolBarManager);
		fillToolbar(toolBarManager);
		toolBarManager.update(true);
		this.viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {

				markUnresolvedElement(event);
				MQLSearchResultPage.this.removeSelectedElements.setEnabled(canRemoveMatchesWith(event.getSelection()));
				MQLSearchResultPage.this.showNextAction.setEnabled(canShowInModelBrowser(event.getSelection()));
				MQLSearchResultPage.this.showPreviousAction.setEnabled(canShowInModelBrowser(event.getSelection()));
			}

			private void markUnresolvedElement(SelectionChangedEvent event) {

				if (event.getSelection() != null && !event.getSelection().isEmpty()) {
					canShowInModelBrowser(event.getSelection());
					MQLSearchResultPage.this.viewer.update(((StructuredSelection) event.getSelection()).getFirstElement(), null);
				}
			}
		});
		this.viewer.addSelectionChangedListener(this.selectionProviderMediator);
		final Menu menu = this.menuMgr.createContextMenu(this.viewer.getControl());
		this.viewer.getControl().setMenu(menu);
		getViewPart().updateLabel();
	}

	private void enableStandardActions(boolean enable) {

		this.saveResultAction.setEnabled(false);
		this.showNextAction.setEnabled(false);
		this.showPreviousAction.setEnabled(false);
		this.removeSelectedElements.setEnabled(false);
	}

	private void configureTableViewer(TableViewer viewer) {

		this.table = viewer.getTable();
		this.table.setLinesVisible(true);
		this.table.setHeaderVisible(true);
		this.viewer.setUseHashlookup(true);
		this.viewer.setContentProvider(new MQLSearchResultPageContentProvider(this));
		// addDragAdapters(this.viewer);

	}

	private void createViewerDetails() {

		final MQLResultSet resultSet = this.input.getResult();
		if (resultSet != null && resultSet.getSize() > 0) {

			final ISelection selection = this.viewer.getSelection();
			disconnectViewer();
			disposeViewer();
			createViewer(this.viewerContainer, this.tabeleStyle);
			this.viewerContainer.layout(true);
			createTableColumnsDetails(resultSet);
			connectViewer(this.input);
			this.viewer.setSelection(selection, true);
			getViewPart().updateLabel();
		}
	}

	private void createTableColumnsDetails(MQLResultSet resultSet) {

		final MQLColumnType[] queryColumnTypes = resultSet.getQueryColumnTypes();

		for (int i = 0; i < queryColumnTypes.length; i++) {

			final MQLColumnType columnType = queryColumnTypes[i];
			final TableViewerColumn column = new TableViewerColumn((TableViewer) this.viewer, SWT.NONE, i);

			if (columnType.attribute == null) {
				column.getColumn().setText(columnType.alias + MQLSearchResultPage.COLON_SUBSTRING + MQLSearchResultPage.MRI_TYPE);
				column.getColumn().setToolTipText(columnType.alias + MQLSearchResultPage.COLON_SUBSTRING + MQLSearchResultPage.MRI_TYPE);
				column.getColumn().setImage(QueryConsole.getDefault().getImage(QueryConsole.OBJECT_IMAGE));
			} else {
				if (columnType.multiValued) {
					column.getColumn().setImage(QueryConsole.getDefault().getImage(QueryConsole.ZERO_TO_UNBOUND_ATTRIBUTE_IMAGE));
					String description = null;
					if (columnType.isOrdered) {
						description = MQLSearchResultPage.LIST_TYPE + MQLSearchResultPage.LT_SUBSTRING + columnType.typeName
								+ MQLSearchResultPage.GT_SUBSTRING;
					} else {
						description = MQLSearchResultPage.COLLECTION_TYPE + MQLSearchResultPage.LT_SUBSTRING + columnType.typeName
								+ MQLSearchResultPage.GT_SUBSTRING;
						;
					}
					if (columnType.isUnique) {
						description += MQLSearchResultPage.SEPARATOR_COMMA_SUBSTRING + MQLSearchResultPage.IS_UNIQUE;
					}
					column.getColumn().setText(
							columnType.alias + "." + columnType.attribute + MQLSearchResultPage.COLON_SUBSTRING + description); //$NON-NLS-1$
					column.getColumn().setToolTipText(
							columnType.alias + "." + columnType.attribute + MQLSearchResultPage.COLON_SUBSTRING + description); //$NON-NLS-1$
				} else {
					column.getColumn().setImage(QueryConsole.getDefault().getImage(QueryConsole.ATTRIBUTE_IMAGE));
					column.getColumn().setText(
							columnType.alias + "." + columnType.attribute + MQLSearchResultPage.COLON_SUBSTRING + columnType.typeName); //$NON-NLS-1$
					column.getColumn().setToolTipText(
							columnType.alias + "." + columnType.attribute + MQLSearchResultPage.COLON_SUBSTRING + columnType.typeName); //$NON-NLS-1$
				}
			}
			column.getColumn().setWidth(calculateColumnWidth(((TableViewer) this.viewer).getTable(), queryColumnTypes.length));
			column.getColumn().setMoveable(true);
			column.getColumn().setResizable(true);
			column.setLabelProvider(new DelegatingStyledCellLabelProvider(new MQLSearchResultPageColumnLabelProvider(i)));
		}

	}

	private int calculateColumnWidth(Table table, int length) {

		int tableWidth = table.getSize().x;
		tableWidth = tableWidth - (table.getBorderWidth() * 2);
		tableWidth = tableWidth - table.getVerticalBar().getSize().x;
		return tableWidth / length;

	}

	public void navigateNext(boolean forward) {

		INavigate navigator = null;
		navigator = new TableViewerNavigator((TableViewer) getViewer());
		navigator.navigateNext(forward);

	}

	private Object getFirstSelectedElement() {

		final IStructuredSelection selection = (IStructuredSelection) getViewer().getSelection();
		if (selection.size() > 0) {
			return selection.getFirstElement();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.IPage#dispose()
	 */
	@Override
	public void dispose() {

		super.dispose();
		NewSearchUI.removeQueryListener(this.queryListener);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.IPage#getControl()
	 */
	@Override
	public Control getControl() {

		return this.pagebook;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.IPage#setActionBars(org.eclipse.ui.IActionBars)
	 */
	@Override
	public void setActionBars(IActionBars actionBars) {

		// nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.IPage#setFocus()
	 */
	@Override
	public void setFocus() {

		final Control control = this.viewer.getControl();
		if (control != null && !control.isDisposed()) {
			control.setFocus();
		}

	}

	/**
	 * Handles a search result event for the current search result. *
	 * 
	 * @param e
	 */
	protected void handleSearchResultChanged(final SearchResultEvent e) {

		if (e instanceof MQLresultSetEvent) {
			this.input = (MQLSearchResult) e.getSearchResult();
			postUpdate();
		} else if (e instanceof RemoveAllEvent) {
			this.input = (MQLSearchResult) e.getSearchResult();
			postClear();
		}
	}

	/**
	 * Removes the currently selected rows. Does nothing if no row is selected.
	 */
	@SuppressWarnings("unchecked")
	public void removeSelectedElements() {

		final MQLSearchResult result = getInput();
		if (result == null || result.getResultSize() == 0) {
			return;
		}
		final List<Integer> rowsToDelete = new ArrayList<Integer>();
		final StructuredViewer viewer = getViewer();
		final IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();

		if (selection != null && !selection.isEmpty() && selection.getFirstElement() instanceof ArrayList) {
			final List<?> objs = (ArrayList<?>) selection.getFirstElement();
			if (objs.size() > 0 && objs.get(0) instanceof MQLCellData) {
				final List<?> rowObjs = selection.toList();
				final List<List<MQLCellData>> rows = (List<List<MQLCellData>>) rowObjs;
				this.batchedRemoveRows = true;
				for (final List<MQLCellData> list : rows) {
					rowsToDelete.add(new Integer(list.get(0).getRowIndex()));
				}
				result.removeRows(rowsToDelete);
			}
		}
	}

	/**
	 * Returns the currently selected row.
	 * 
	 * @return the selected row or <code>null</code> if none are selected
	 */
	@SuppressWarnings("unchecked")
	public List<MQLCellData> getCurrentRow() {

		final Object element = getFirstSelectedElement();
		if (element != null && element instanceof ArrayList) {
			return (List<MQLCellData>) element;
		}
		return null;
	}

	/**
	 * @return the viewPart
	 */
	public ISearchResultViewPart getViewPart() {

		return this.viewPart;
	}

	private IQueryListener createQueryListener() {

		return new IQueryListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.search.ui.IQueryListener#queryAdded(org.eclipse.search.ui.ISearchQuery)
			 */
			public void queryAdded(ISearchQuery query) {

				// nothing to do
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.search.ui.IQueryListener#queryRemoved(org.eclipse.search.ui.ISearchQuery)
			 */
			public void queryRemoved(ISearchQuery query) {

				// nothing to do
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.search.ui.IQueryListener#queryStarting(org.eclipse.search.ui.ISearchQuery)
			 */
			public void queryStarting(final ISearchQuery query) {

				final Runnable queryRunnable = new Runnable() {
					public void run() {

						updateBusyLabel();
						final MQLSearchResult result = getInput();

						if (result == null || !result.getQuery().equals(query)) {
							return;
						}
						scheduleUIUpdate();
					}
				};

				asyncExec(queryRunnable);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.search.ui.IQueryListener#queryFinished(org.eclipse.search.ui.ISearchQuery)
			 */
			public void queryFinished(final ISearchQuery query) {

				// handle the end of the query in the UIUpdateJob, as UI updates
				// may not be finished here.
				postEnsureSelection();
			}
		};
	}

	/**
	 * Posts a UI update to make sure an element is selected.
	 * 
	 */
	private void postEnsureSelection() {

		this.scheduleEnsureSelection = true;
		scheduleUIUpdate();

	}

	private void asyncExec(final Runnable runnable) {

		final Control control = getControl();
		if (control != null && !control.isDisposed()) {
			final Display currentDisplay = Display.getCurrent();

			// we're not executing on the display thread of the control

			if (currentDisplay == null || !currentDisplay.equals(control.getDisplay())) {
				control.getDisplay().asyncExec(new Runnable() {
					public void run() {

						if (!control.isDisposed())
							runnable.run();
					}
				});
			} else {
				runnable.run();
			}
		}

	}

	private class UpdateUIJob extends UIJob {

		/**
		 * Creates UpdateUIJob.
		 */
		public UpdateUIJob() {

			super(MQLSearchResultPage.UI_JOB_NAME);
			setSystem(true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime.IProgressMonitor)
		 */
		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {

			final Control control = getControl();
			if (control == null || control.isDisposed()) {
				// disposed the control while the UI was posted.
				return Status.OK_STATUS;
			}
			runBatchedRemoveAllRows();
			runBatchedRemoveRows();
			if (hasMoreUpdates() || isQueryRunning()) {
				schedule(500);
			} else {
				MQLSearchResultPage.this.isUIUpdateScheduled = false;
				updateBusyLabel();
				if (MQLSearchResultPage.this.scheduleEnsureSelection) {
					MQLSearchResultPage.this.scheduleEnsureSelection = false;
					final MQLSearchResult result = getInput();
					if (result != null && MQLSearchResultPage.this.viewer.getSelection().isEmpty()) {
						createViewerDetails();

						// set selection and focus on first row
						navigateNext(true);
						final IStructuredSelection selection = (IStructuredSelection) getViewer().getSelection();
						getViewer().setSelection(selection, true);
						getViewer().getControl().setFocus();
						if (result.getResultSize() > 0) {
							MQLSearchResultPage.this.saveResultAction.setEnabled(true);
						}
					}
				}
			}
			MQLSearchResultPage.this.viewPart.updateLabel();
			return Status.OK_STATUS;
		}

		/*
		 * Undocumented for testing only. Used to find UpdateUIJobs.
		 */
		@Override
		public boolean belongsTo(Object family) {

			return family == MQLSearchResultPage.this;
		}

	}

	private boolean isQueryRunning() {

		final MQLSearchResult result = getInput();
		if (result != null) {
			return NewSearchUI.isQueryRunning(result.getQuery());
		}
		return false;

	}

	private void postClear() {

		this.batchedRemoveAll = true;
		this.batchedRemoveRows = false;
		scheduleUIUpdate();
	}

	private void postUpdate() {

		if (this.batchedRemoveRows) {
			scheduleUIUpdate();
		}
	}

	private boolean hasMoreUpdates() {

		return this.batchedRemoveAll || this.batchedRemoveRows;
	}

	private void runBatchedRemoveAllRows() {

		if (!this.batchedRemoveAll) {
			return;
		}
		this.batchedRemoveAll = false;
		updateBusyLabel();
		getViewPart().updateLabel();
		getViewer().refresh();
		enableStandardActions(false);
	}

	private void scheduleUIUpdate() {

		if (!this.isUIUpdateScheduled) {
			this.isUIUpdateScheduled = true;
			new UpdateUIJob().schedule();
		}

	}

	private void runBatchedRemoveRows() {

		if (this.batchedRemoveRows) {
			getViewer().refresh();
			navigateNext(true);
			this.batchedRemoveRows = false;
			updateBusyLabel();
			this.saveResultAction.setEnabled(getInput().getResultSize() > 0);
		}
	}

	/**
	 * Sets the maximal number of top level elements to be shown in a viewer. If <code>null</code> is set, the view page does not support to
	 * limit the elements and will not provide UI to configure it. If a non-null value is set, configuration UI will be provided. The limit
	 * value must be a positive number or <code>-1</code> to not limit top level element.
	 * 
	 * @param limit
	 *            the element limit. Valid values are:
	 *            <dl>
	 *            <li><code>null</code> to not limit and not provide configuration UI</li>
	 *            <li><code>-1</code> to not limit and provide configuration UI</li>
	 *            <li><code>positive integer</code> to limit by the given value and provide configuration UI</li>
	 *            </dl>
	 */
	public void setElementLimit(Integer elementLimit) {

		this.elementLimit = elementLimit;
		final int limit = elementLimit.intValue();
		getSettings().put(MQLSearchResultPage.KEY_LIMIT, limit);

		if (this.viewer != null) {
			this.viewer.refresh();
		}
		if (this.viewPart != null) {
			this.viewPart.updateLabel();
		}

	}

	/**
	 * Gets the maximal number of top level elements to be shown in a viewer. <code>null</code> means the view page does not limit the
	 * elements and will not provide UI to configure it. If a non-null value is set, configuration UI will be provided. The limit value must
	 * be a positive number or <code>-1</code> to not limit top level element.
	 * 
	 * @return returns the element limit. Valid values are:
	 *         <dl>
	 *         <li><code>null</code> to not limit and not provide configuration UI (default value)</li>
	 *         <li><code>-1</code> to not limit and provide configuration UI</li>
	 *         <li><code>positive integer</code> to limit by the given value and provide configuration UI</li>
	 *         </dl>
	 */
	public Integer getElementLimit() {

		return this.elementLimit;

	}

	/**
	 * @return the selectionProviderMediator
	 */
	public final SelectionProviderIntermediate getSelectionProviderMediator() {

		return this.selectionProviderMediator;
	}

	/**
	 * 
	 */
	public void setRefObjectSelectionProviderAdapter() {

		this.selectionProviderMediator.setSelectionProviderDelegate(this.refObjectAdapter);
	}

	public void setSelectionChangedProviderAdapter() {

		this.selectionProviderMediator.setSelectionProviderDelegate(this.viewerAdapter);
	}

	/**
	 * @return the showInModelBrowserAction
	 */
	public final Action getShowInModelBrowserAction() {

		return this.showInModelBrowserAction;
	}

	/**
	 * @return the saveResultAction
	 */
	public final Action getSaveResultAction() {
	
		return this.saveResultAction;
	}

	/**
	 * @return the filterAction
	 */
	public final IAction getFilterAction() {
	
		return this.filterAction;
	}
	
	/**
	 * @return the selectAllAction
	 */
	public final Action getSelectAllAction() {
	
		return this.selectAllAction;
	}

}
