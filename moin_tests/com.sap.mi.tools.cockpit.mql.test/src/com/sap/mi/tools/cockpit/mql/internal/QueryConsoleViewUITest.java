package com.sap.mi.tools.cockpit.mql.internal;

import java.io.File;
import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

import abbot.WaitTimedOutError;
import abbot.swt.Robot;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LCCombo;
import com.sap.ide.junit.ui.lift.LControl;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LLabel;
import com.sap.ide.junit.ui.lift.LMenu;
import com.sap.ide.junit.ui.lift.LMenuItem;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTableItem;
import com.sap.ide.junit.ui.lift.LText;
import com.sap.ide.junit.ui.lift.LTree;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.ui.lift.LShell.AsyncWaiter;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.tools.cockpit.mql.preferences.MQLPreferencesHelper;
import com.sap.mi.tools.cockpit.mql.search.MQLSearchResult;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPageContentProvider;
import com.sap.mi.tools.cockpit.mql.ui.view.QueryConsoleView;
import com.sap.tc.moin.repository.mql.MQLResultSet;

/**
 * @author d003456
 * 
 */
public class QueryConsoleViewUITest extends ProjectBasedTest {

	private static final String DC_NAME = "testproject-MqlConsoleUITest"; //$NON-NLS-1$

	private static final String COCKPIT_PERSPECTIVE_ID = "com.sap.mi.tools.cockpit.editor.perspective.CockpitPerspective"; //$NON-NLS-1$

	private static final String QUERY_CONSOLE_VIEW_ID = "com.sap.mi.tools.cockpit.mql.ui.view.QueryConsoleView"; //$NON-NLS-1$

	private static final String SEARCH_VIEW_ID = "org.eclipse.search.ui.views.SearchView"; //$NON-NLS-1$

	private static final String LIFT_FILE_DIALOG_WIDGET_NAME = "com.sap.mi.tools.cockpit.mql.ui.search.action.FileDialog"; //$NON-NLS-1$

	private static final String LIFT_TEXT_WIDGET_QUERY_TEMPLATE_NAME = "com.sap.mi.tools.cockpit.mql.wizard.queryTemplateNameText"; //$NON-NLS-1$

	private static final String LIFT_BUTTON_WIDGET_ADD = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.addButton"; //$NON-NLS-1$

	private static final String LIFT_TEXT_WIDGET_NAME = "com.sap.mi.tools.cockpit.mql.ui.search.dialog.LimitText"; //$NON-NLS-1$

	private static final String LIFT_TEXT_WIDGET_QUERY_TEMPLATE_NAME_ON_DETAILS = "com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.queryTemplateNameText"; //$NON-NLS-1$

	private static final String LIFT_BUTTON_WIDGET_RESET = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.resetButton"; //$NON-NLS-1$

	private static final String LIFT_BUTTON_WIDGET_UP = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.upButton"; //$NON-NLS-1$

	private static final String LIFT_BUTTON_WIDGET_DOWN = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.downButton"; //$NON-NLS-1$

	private static final String LIFT_BUTTON_WIDGET_DELETE = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.deleteButton"; //$NON-NLS-1$

	private static final String LIFT_TREE_WIDGET = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.tree"; //$NON-NLS-1$

	private static final String LIFT_HYPERLINK_WIDGET_PREFERENCES = "com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.openpreferencepageHyperlink"; //$NON-NLS-1$

	private static final String LIFT_TEXT_WIDGET_URL = "com.sap.mi.tools.cockpit.mql.preferences.MQLPreferencePage.teamserverurl"; //$NON-NLS-1$

	private final static String CREATE_TEMPLATE_DIALOG_TITLE = "Create New Query Template"; //$NON-NLS-1$

	private final static String TEST_URL = "http://vemoin666.dhcp.wdf.sap.corp:50000/QueryService/QueryImplBean?wsdl"; //$NON-NLS-1$

	private static final String MSG_METAMODELS_NOT_DEPLOYED = "Metamodels are not deployed."; //$NON-NLS-1$

	private static final String MSG_PROJECT_NOT_CREATED = "Project not created."; //$NON-NLS-1$

	private static final String MSG_METAMODELMANAGER_NOT_INSTANTIATED = "Meta Model Manager is not instantiated."; //$NON-NLS-1$

	private static final String METAMODEL_WSDL2 = "sap.com/tc/esmp/model/wsdl2"; //$NON-NLS-1$

	private static final String METAMODEL_XSD1 = "sap.com/tc/esmp/model/xsd1"; //$NON-NLS-1$

	private static final String METAMODEL_GALAXY = "sap.com/glx/ide"; //$NON-NLS-1$

	private static final String QUERY_NAME_MRI = "select xsd, xsd.name from XSD1::XsdComplexTypeDefinition as xsd"; //$NON-NLS-1$

	private static final String MENU_TEXT_COPY = "/.*Copy.*/"; //$NON-NLS-1$

	private static final String MENU_SHOW_IN_MODEL_BROWSER = "/.*Show In Model Browser.*/"; //$NON-NLS-1$

	private static final String REMOVE_All_ELEMENTS = "/.*Remove All Elements.*/"; //$NON-NLS-1$

	/**
	 * Relativ path to zip file with partitions
	 */
	private static final String QueryConsole_TEST_DATA = "/resources/QueryConsoleTestData.zap"; //$NON-NLS-1$

	protected MetamodelManager metaModelManager = null;

	private LFactory abbotFactory;

	private Display display;

	private QueryConsoleView viewer;

	private IViewPart part;

	private LShell shell;

	private LTreeItem projectNode;

	private LTreeItem currNode;

	private LTree modelTree;

	private MQLSearchResultPage activePage;

	/**
	 * Constructor.
	 */
	public QueryConsoleViewUITest() {

		super();
		assertNotNull(QueryConsoleViewUITest.MSG_METAMODELMANAGER_NOT_INSTANTIATED, this.metaModelManager = MetamodelManager.getInstance());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#getDcName()
	 */
	@Override
	protected String getDcName() {

		return QueryConsoleViewUITest.DC_NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#getMetamodels()
	 */
	@Override
	protected String[] getMetamodels() {

		return new String[] { QueryConsoleViewUITest.METAMODEL_WSDL2, QueryConsoleViewUITest.METAMODEL_XSD1,
				QueryConsoleViewUITest.METAMODEL_GALAXY };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#getProjectContentAsStream()
	 */
	@Override
	protected InputStream getProjectContentAsStream() {

		return QueryConsoleViewUITest.class.getResourceAsStream(QueryConsoleViewUITest.QueryConsole_TEST_DATA);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#setUp()
	 */
	@Override
	protected void setUp() throws Exception {

		super.setUp();

		assertNotNull(QueryConsoleViewUITest.MSG_PROJECT_NOT_CREATED, getProject());
		assertTrue(QueryConsoleViewUITest.MSG_METAMODELS_NOT_DEPLOYED, this.metaModelManager.isMetamodelImported(getMetamodels()));

		this.abbotFactory = FactoryBuilder.newAbbotFactory();
		this.display = Display.getDefault();
		this.shell = this.abbotFactory.getShell(this.display);
		this.abbotFactory.setFindTimeOut(5000);
		this.abbotFactory.setWaitTimeout(5000);

		PDEUtil.closeWelcomePage();
		PDEUtil.openPerspective(QueryConsoleViewUITest.COCKPIT_PERSPECTIVE_ID);
		PDEUtil.maximizeWorkbenchAndRequestFocus();
		PDEUtil.assertDisplayIsActiveWindow();
		this.part = PDEUtil.showView(QueryConsoleViewUITest.QUERY_CONSOLE_VIEW_ID);
		assertTrue("View part is not an QueryConsoleView", this.part instanceof QueryConsoleView); //$NON-NLS-1$
		this.setViewer((QueryConsoleView) PDEUtil.showView(QueryConsoleViewUITest.QUERY_CONSOLE_VIEW_ID));
		final IViewPart searchViewPart = PDEUtil.showView(QueryConsoleViewUITest.SEARCH_VIEW_ID);
		assertTrue("View part is not an instance of SearchView", searchViewPart instanceof ISearchResultViewPart); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {

		for (int i = 0; i < 25; i++) {
			this.shell.enter(this.abbotFactory.key().esc());
		}
		PDEUtil.restoreCurrentView();
		this.display = null;
		this.shell = null;
		super.tearDown();
		this.abbotFactory = null;
	}

	@SuppressWarnings("nls")
	public void testExecuteButtonIsInactive() throws Exception {

		final LButton executeButton = this.shell.button().withText("Execute");
		assertFalse("Execute button must be disabled", executeButton.isEnabled());
	}

	@SuppressWarnings("nls")
	public void testQueryWithNoResult() throws Exception {

		selectConnectionInCCombo();
		pushExecuteButton();
		final MQLSearchResult query = waitForMQLSearchResult();
		assertEquals("Search result length must be 0", 0, query.getResultSize());
	}

	@SuppressWarnings("nls")
	public void testQuery() throws Exception {

		final MQLSearchResult query = executeQuery();
		assertNotNull("Could not get MQLSearchResult", query);
		validateSearchResult(query.getResult());
	}

	@SuppressWarnings("nls")
	public void testCopyAction() throws Exception {

		executeQuery();
		final LTableItem tableItem = this.shell.tableItem().withTextAtColumn("response", 1).andShows();
		this.shell.clickOn(tableItem);

		final LMenuItem copyMenuItem = getCopyMenuItem(tableItem);
		this.shell.clickOn(copyMenuItem);
		final String clipboardString = this.shell.syncExec(new LRunnable<String>() {
			public String run() throws Exception {

				final Clipboard clipboard = new Clipboard(Display.getCurrent());
				try {
					final String contents = (String) clipboard.getContents(TextTransfer.getInstance());
					return contents;
				}
				finally {
					clipboard.dispose();
				}
			}
		});
		assertTrue("Clipboard does not match with \', response\'", clipboardString.endsWith(", response"));
	}

	@SuppressWarnings("nls")
	public void testRemoveAllElementsAction() throws Exception {

		executeQuery();
		final LTableItem tableItem = this.shell.tableItem().withTextAtColumn("response", 1).andShows();
		this.shell.clickOn(tableItem);
		final LMenuItem removeAllMenuItem = getRemoveAllElementsMenuItem(tableItem);
		this.shell.clickOn(removeAllMenuItem);
		final MQLSearchResult query = waitForMQLSearchResult();
		assertEquals("Search result length must be 0", 0, query.getResultSize());

	}

	@SuppressWarnings("nls")
	public void testShowInModelBrowserAction() throws Exception {

		// precondition: search result is available in SearchView
		executeQuery();

		final LTableItem tableItem = this.shell.tableItem().withTextAtColumn("request", 1).andShows();
		this.shell.clickOn(tableItem);
		final LMenuItem showInModelBrowserMenuItem = getShowInModelBrowserMenuItem(tableItem);
		this.shell.clickOn(showInModelBrowserMenuItem);
		this.abbotFactory.delay(5000);

		getProjectNodeAndModelTree(getProject());

		try {
			this.currNode = this.projectNode.hasItem(this.shell.treeItem().withText("/.*request*./"));
			if (!this.currNode.isResolved()) {
				this.shell.waitForShowing(this.currNode);
			}
		}
		catch (final WidgetException e) {
			fail("Node \"request\" not found in model browser tree.", e);
		}
		catch (final WaitTimedOutError err) {
			fail("Timout when finding node request not found in model browser tree.", err);
		}
	}

	@SuppressWarnings("nls")
	public void testSelectAllAndDeleteAction() throws Exception {

		executeQuery();
		final LTableItem tableItem = this.shell.tableItem().withTextAtColumn("request", 1).andShows();
		this.shell.clickOn(tableItem);

		final Robot robot = new Robot(Display.getDefault());
		try {
			robot.keyPress(SWT.CTRL);
			robot.keyPress('a');
		}
		catch (final RuntimeException e) {
			fail("Could not type CTRL+a", e);
		}
		finally {
			robot.keyRelease(SWT.CTRL);
			robot.keyRelease('a');
		}
		this.shell.enter(SWT.DEL);
		final MQLSearchResult query = waitForMQLSearchResult();
		assertEquals("Search result length must be 0", 0, query.getResultSize());
	}

	@SuppressWarnings("nls")
	public void testExportAction() throws Exception {

		executeQuery();

		final AsyncWaiter waiter = this.shell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				final IViewPart searchViewPart = PDEUtil.showView(QueryConsoleViewUITest.SEARCH_VIEW_ID);
				final ISearchResultViewPart view = (ISearchResultViewPart) searchViewPart;
				QueryConsoleViewUITest.this.activePage = (MQLSearchResultPage) view.getActivePage();
				QueryConsoleViewUITest.this.activePage.getSaveResultAction().run();
				return null;
			}
		});
		final LShell dialog = this.shell.childShell().withName(QueryConsoleViewUITest.LIFT_FILE_DIALOG_WIDGET_NAME);
		waiter.waitForShowing(dialog);
		assertNotNull("MQLSearchResultPage must be visible in SearchView", this.activePage);
		dialog.resolve();
		dialog.enter(getExportFilePath().toOSString());
		this.shell.enter(SWT.CR);
		this.abbotFactory.delay(1000);

		File file = null;
		assertNotNull("Exported csv-file could not be found", file = getExportFilePath().toFile());
		try {
			file.delete();
		}
		catch (final Exception cause) {
			fail("Exported csv-file could not be deleted", cause);
		}
	}

	@SuppressWarnings("nls")
	public void testFilterAction() throws Exception {

		// precondition: active page in SearchView is MQLSearchResultPage
		executeQuery();

		final AsyncWaiter waiter = this.shell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				final IViewPart searchViewPart = PDEUtil.showView(QueryConsoleViewUITest.SEARCH_VIEW_ID);
				final ISearchResultViewPart view = (ISearchResultViewPart) searchViewPart;
				QueryConsoleViewUITest.this.activePage = (MQLSearchResultPage) view.getActivePage();
				QueryConsoleViewUITest.this.activePage.getFilterAction().run();
				return null;
			}
		});

		final LShell dialog = this.shell.childShell().withText("MQL Search Result Limit Filter");
		waiter.waitForShowing(dialog);
		assertNotNull("MQLSearchResultPage must be visible in SearchView", this.activePage);
		final LText text = dialog.text().withName(QueryConsoleViewUITest.LIFT_TEXT_WIDGET_NAME);
		text.setText("2");
		dialog.clickOn(dialog.button().ok());
		final MQLSearchResultPageContentProvider provider = (MQLSearchResultPageContentProvider) this.activePage.getViewer()
				.getContentProvider();
		assertEquals("Search result length must be 2", 2, provider.getElements(this.activePage.getViewer().getInput()).length);
	}

	@SuppressWarnings("nls")
	public void testPreconfiguredTemplates() throws Exception {

		final LTree tree = getTemplateTree();
		assertEquals("Tree should have 6 templates", 6, tree.getItemCount());
		for (int i = 0; i < 6; i++) {
			final String expectedName = getTemplateName(i);
			checkName(tree, i, expectedName);
		}
	}

	@SuppressWarnings("nls")
	public void testDownButton() throws Exception {

		final LTree tree = getTemplateTree();
		assertEquals("Tree should have 6 templates", 6, tree.getItemCount());
		LButton downButton = getButton(QueryConsoleViewUITest.LIFT_BUTTON_WIDGET_DOWN);
		checkName(tree, 0, getTemplateName(0));

		for (int i = 0; i < 6; i++) {
			this.shell.clickOn(downButton);
			this.abbotFactory.delay(1000);
			downButton = getButton(QueryConsoleViewUITest.LIFT_BUTTON_WIDGET_DOWN);
			final int j = (i != 5) ? i + 1 : 0;
			checkName(tree, j, getTemplateName(0));
		}
	}

	@SuppressWarnings("nls")
	public void testUpButton() throws Exception {

		final LTree tree = getTemplateTree();
		assertEquals("Tree should have 6 templates", 6, tree.getItemCount());
		LButton upButton = getButton(QueryConsoleViewUITest.LIFT_BUTTON_WIDGET_UP);
		checkName(tree, 0, getTemplateName(0));

		for (int i = 0; i < 6; i++) {
			this.shell.clickOn(upButton);
			this.abbotFactory.delay(1000);
			upButton = getButton(QueryConsoleViewUITest.LIFT_BUTTON_WIDGET_UP);
			final int j = (i == 0) ? 5 : 5 - i;
			checkName(tree, j, getTemplateName(0));
		}
	}

	@SuppressWarnings("nls")
	public void testDeleteButton() throws Exception {

		final LTree tree = getTemplateTree();
		assertEquals("Tree should have 6 templates", 6, tree.getItemCount());
		LButton deleteButton = getButton(QueryConsoleViewUITest.LIFT_BUTTON_WIDGET_DELETE);
		checkName(tree, 0, getTemplateName(0));

		for (int i = 0; i < 6; i++) {
			this.shell.clickOn(deleteButton);
			this.abbotFactory.delay(1000);
			deleteButton = getButton(QueryConsoleViewUITest.LIFT_BUTTON_WIDGET_DELETE);
			assertEquals(5 - i, tree.getItemCount());
		}

		resetTemplates(tree);
	}

	@SuppressWarnings("nls")
	public void testNewTemplate() throws Exception {

		final LTree tree = getTemplateTree();
		if (tree.getItemCount() != 6) {
			resetTemplates(tree);
		}

		final LButton addButton = getButton(QueryConsoleViewUITest.LIFT_BUTTON_WIDGET_ADD);
		this.shell.clickOn(addButton);
		final LShell wizardDialog = this.shell.childShell().withText(QueryConsoleViewUITest.CREATE_TEMPLATE_DIALOG_TITLE).andShows()
				.resolve();
		final LText masterText = wizardDialog.text().withName(QueryConsoleViewUITest.LIFT_TEXT_WIDGET_QUERY_TEMPLATE_NAME).resolve();
		masterText.setText("All model classes");
		wizardDialog.clickOn(wizardDialog.button().finish());

		// postcondition
		final LText detailsText = this.shell.text().withName(QueryConsoleViewUITest.LIFT_TEXT_WIDGET_QUERY_TEMPLATE_NAME_ON_DETAILS)
				.resolve();
		assertTrue("Name of template should be \'All model classes\'", detailsText.getText().equals("All model classes"));
		assertEquals("Tree should have 7 children", 7, tree.getItemCount());
		assertNotNull("Tree node \'All model classes\' could not be resolved", tree.treeItem().withText("All model classes").resolve());

		resetTemplates(tree);
		assertEquals("Tree should have 6 children", 6, tree.getItemCount());
	}

	@SuppressWarnings("nls")
	public void testURLPreference() throws Exception {

		final LControl remoteHyperlink = this.shell.control().withName(QueryConsoleViewUITest.LIFT_HYPERLINK_WIDGET_PREFERENCES).andShows()
				.resolve();
		remoteHyperlink.forceFocus();
		this.shell.clickOn(remoteHyperlink);
		final LShell dialog = this.shell.childShell().withText("/.*Preferences.*/").andShows().resolve();
		final LText urlText = dialog.text().withName(QueryConsoleViewUITest.LIFT_TEXT_WIDGET_URL).resolve();
		urlText.setText(QueryConsoleViewUITest.TEST_URL);
		dialog.clickOn(dialog.button().ok());

		final MQLPreferencesHelper prefHelper = MQLPreferencesHelper.getInstance();
		assertEquals("Wrong TeamServer URL", QueryConsoleViewUITest.TEST_URL, prefHelper.getTeamServerUrl());
	}

	private void resetTemplates(LTree tree) throws WidgetException {

		final LButton resetButton = getButton(QueryConsoleViewUITest.LIFT_BUTTON_WIDGET_RESET);
		this.shell.clickOn(resetButton);
		this.abbotFactory.delay(1000);
	}

	private LButton getButton(String liftName) throws WidgetException {

		final LButton addButton = this.shell.button().withName(liftName).resolve();
		addButton.forceFocus();
		return addButton;
	}

	@SuppressWarnings("nls")
	private String getTemplateName(int index) {

		assertTrue("Index for template should be \'index > -1 && index < 6\'", index > -1 && index < 6);
		String name = null;
		switch (index) {
		case 0:
			name = "name from XsdSimpleTypeDefinition";
			break;
		case 1:
			name = "name 2 from XsdSimpleTypeDefinition";
			break;
		case 2:
			name = "name from Model";
			break;
		case 3:
			name = "2 names from Model";
			break;
		case 4:
			name = "name from Model multiplicity";
			break;
		case 5:
			name = "name from Model AssociationEnd";
			break;
		default:
			name = "Should never happen ERROR";
			break;
		}
		return name;
	}

	@SuppressWarnings("nls")
	private void checkName(LTree tree, int i, final String expectedName) throws WidgetException {

		final String itemName = tree.getItem(i).getText();
		assertEquals("Wrong template name at position " + i, expectedName, itemName);
	}

	private LTree getTemplateTree() throws WidgetException {

		return this.shell.tree().withName(QueryConsoleViewUITest.LIFT_TREE_WIDGET).andShows().resolve();
	}

	@SuppressWarnings("nls")
	private IPath getExportFilePath() {

		return Platform.getLocation().append("testExportAction").addFileExtension("csv");
	}

	@SuppressWarnings("nls")
	private void selectConnectionInCCombo() throws WidgetException {

		final LLabel connectionLabel = this.shell.label().withText("Connection:");
		final LCCombo connectionCCombo = this.shell.ccombo().withSibling(connectionLabel, -1).resolve();
		assertTrue("Connection CCombo is not resolved", connectionCCombo != null && connectionCCombo.isResolved());
		assertEquals("Connection CCombo should have 1 item", 1, connectionCCombo.getItemCount());
		this.shell.clickOn(connectionCCombo);
		this.shell.enter(this.abbotFactory.key().arrowDown()).andShows();
		connectionCCombo.select(0).andShows();
	}

	@SuppressWarnings("nls")
	private void pushExecuteButton() throws WidgetException {

		final LButton executeButton = this.shell.button().withText("Execute").resolve();
		assertTrue("Execute button must be enabled", executeButton.isEnabled());
		executeButton.forceFocus();
		this.shell.clickOn(executeButton);
	}

	@SuppressWarnings("nls")
	private MQLSearchResult waitForMQLSearchResult() {

		this.abbotFactory.delay(5000);
		ISearchQuery[] queries = null;
		int i = 0;
		while (queries == null && i < 15) {
			this.abbotFactory.delay(1000);
			// returns the queries in LRU order. Smaller index means more recently used
			queries = NewSearchUI.getQueries();
			if (queries != null && queries.length > 0) {
				break;
			}
			i = i + 1;
		}
		System.out.println("waitForMQLSearchResult: queries.length = " + queries.length + ", iterations = " + i);
		assertTrue("Could not get query from SearchView", queries != null);
		assertTrue("Query.length  from SearchView must be 1", queries.length > 0);
		final ISearchResult searchResult = queries[0].getSearchResult();
		assertTrue("searchResult is not of type MQLSearchResult", searchResult != null && searchResult instanceof MQLSearchResult);
		final MQLSearchResult result = (MQLSearchResult) searchResult;
		return result;
	}

	@SuppressWarnings("nls")
	private MQLSearchResult executeQuery() throws Exception {

		MQLSearchResult query = null;
		selectConnectionInCCombo();
		final LButton executeButton = this.shell.button().withText("Execute");
		final LText text = this.shell.text().withSibling(executeButton, 1).resolve();
		text.setText(QueryConsoleViewUITest.QUERY_NAME_MRI);
		pushExecuteButton();
		query = waitForMQLSearchResult();
		assertEquals("Search result length must be 15", 15, query.getResultSize());
		return query;
	}

	@SuppressWarnings("nls")
	private void validateSearchResult(MQLResultSet searchResult) {

		// values for attribute names
		assertEquals("Value \"TextVariables\" for Attribute name not retrieved from position 0", "TextVariables", searchResult
				.getAttribute(0, "xsd", "name"));
		assertEquals("Value \"TextVariables\" for Attribute name not retrieved from position 1", "TextVariables", searchResult
				.getAttribute(1, "xsd", "name"));
		assertEquals("Value \"response\" for Attribute name not retrieved from position 2", "response", searchResult.getAttribute(2, "xsd",
				"name"));
		assertEquals("Value \"request\" for Attribute name not retrieved from position 3", "request", searchResult.getAttribute(3, "xsd",
				"name"));
		assertEquals("Value \"initDBDefaults\" for Attribute name not retrieved from position 4", "initDBDefaults", searchResult
				.getAttribute(4, "xsd", "name"));
		assertEquals("Value \"initDBDefaultsResponse\" for Attribute name not retrieved from position 5", "initDBDefaultsResponse",
				searchResult.getAttribute(5, "xsd", "name"));
		assertEquals("Value \"insertLogEntry\" for Attribute name not retrieved from position 6", "insertLogEntry", searchResult
				.getAttribute(6, "xsd", "name"));
		assertEquals("Value \"insertLogEntryResponse\" for Attribute name not retrieved from position 7", "insertLogEntryResponse",
				searchResult.getAttribute(7, "xsd", "name"));
		assertEquals("Value \"createHardwareOrder\" for Attribute name not retrieved from position 8", "createHardwareOrder", searchResult
				.getAttribute(8, "xsd", "name"));
		assertEquals("Value \"createHardwareOrderResponse\" for Attribute name not retrieved from position 9",
				"createHardwareOrderResponse", searchResult.getAttribute(9, "xsd", "name"));
		assertEquals("Value \"NoSuchHardwareItemException\" for Attribute name not retrieved from position 10",
				"NoSuchHardwareItemException", searchResult.getAttribute(10, "xsd", "name"));
		assertEquals("Value \"InvalidHardwareOrderException\" for Attribute name not retrieved from position 11",
				"InvalidHardwareOrderException", searchResult.getAttribute(11, "xsd", "name"));
		assertEquals("Value \"completeOrder\" for Attribute name not retrieved from position 12", "completeOrder", searchResult
				.getAttribute(12, "xsd", "name"));
		assertEquals("Value \"completeOrderResponse\" for Attribute name not retrieved from position 13", "completeOrderResponse",
				searchResult.getAttribute(13, "xsd", "name"));
		assertEquals("Value \"OrderCompletionException\" for Attribute name not retrieved from position 14", "OrderCompletionException",
				searchResult.getAttribute(14, "xsd", "name"));

	}

	private LMenuItem getCopyMenuItem(LTableItem tableItem) throws WidgetException {

		this.shell.rightClickOn(tableItem);
		LMenuItem copyItem = this.shell.menuItem().withText(QueryConsoleViewUITest.MENU_TEXT_COPY);
		final LMenu contextMenu = this.shell.waitForShowing(this.shell.contextMenu().withItem(copyItem).andItem(
				this.shell.menuItem().withText(QueryConsoleViewUITest.MENU_SHOW_IN_MODEL_BROWSER)));
		copyItem = contextMenu.hasDirectItem(copyItem);
		return copyItem;
	}

	private LMenuItem getShowInModelBrowserMenuItem(LTableItem tableItem) throws WidgetException {

		this.shell.rightClickOn(tableItem);
		LMenuItem showItem = this.shell.menuItem().withText(QueryConsoleViewUITest.MENU_SHOW_IN_MODEL_BROWSER);
		final LMenu contextMenu = this.shell.waitForShowing(this.shell.contextMenu().withItem(showItem).andItem(
				this.shell.menuItem().withText(QueryConsoleViewUITest.MENU_TEXT_COPY)));
		showItem = contextMenu.hasDirectItem(showItem);
		return showItem;
	}

	private LMenuItem getRemoveAllElementsMenuItem(LTableItem tableItem) throws WidgetException {

		this.shell.rightClickOn(tableItem);
		LMenuItem removeAllItem = this.shell.menuItem().withText(QueryConsoleViewUITest.REMOVE_All_ELEMENTS);
		final LMenu contextMenu = this.shell.waitForShowing(this.shell.contextMenu().withItem(removeAllItem).andItem(
				this.shell.menuItem().withText(QueryConsoleViewUITest.MENU_TEXT_COPY)));
		removeAllItem = contextMenu.hasDirectItem(removeAllItem);
		return removeAllItem;
	}

	@SuppressWarnings("nls")
	private void getProjectNodeAndModelTree(IProject project) {

		this.setModelTree(null);
		this.projectNode = null;

		try {
			this.projectNode = this.shell.treeItem().withText(getProjectDisplayName(project)).andShows();
		}
		catch (final Exception e) {
			fail("The project node could not be revealed.", e);
		}
		try {
			this.setModelTree(this.projectNode.getParent());
		}
		catch (final Exception e) {
			fail("The model tree could not be obtained.", e);
		}
	}

	private String getProjectDisplayName(IProject project) {

		final String decoratedProjectName = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator().decorateText(
				project.getName(), project);

		if (decoratedProjectName != null && decoratedProjectName.length() > 0) {
			return decoratedProjectName;
		}

		return project.getName();
	}

	/**
	 * @param modelTree
	 *            the modelTree to set
	 */
	public void setModelTree(LTree modelTree) {

		this.modelTree = modelTree;
	}

	/**
	 * @return the modelTree
	 */
	public LTree getModelTree() {

		return this.modelTree;
	}

	/**
	 * @param viewer
	 *            the viewer to set
	 */
	public void setViewer(QueryConsoleView viewer) {

		this.viewer = viewer;
	}

	/**
	 * @return the viewer
	 */
	public QueryConsoleView getViewer() {

		return this.viewer;
	}
}
