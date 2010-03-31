package com.sap.mi.tools.diagnostics.internal.properties;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPageLayout;

import com.sap.ide.junit.ui.lift.LMenu;
import com.sap.ide.junit.ui.lift.LMenuItem;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LTree;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.ui.lift.NoWidgetFoundException;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.tools.diagnostics.internal.DiagnosticsViewTestFixture;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;

/**
 * Tests the property sheet support for nodes of diagnostics view
 * 
 * @author d031150
 */
public class DiagnosticsViewPropertiesTest extends DiagnosticsViewTestFixture {

	public DiagnosticsViewPropertiesTest() {

		this(DC_NAME);
	}

	public DiagnosticsViewPropertiesTest(String name) {

		super(name);
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		PDEUtil.showView(IPageLayout.ID_PROP_SHEET);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testPropertiesMoin() throws Exception {

		// find and select "Moin" node
		LTreeItem moinItem = revealMoinNode(false);
		mShell.clickOn(moinItem);

		// "Running at" property
		LTreeItem hostItem = mShell.treeItem().withText(MoinBeanPropertySource.PROPERTY_HOST_LABEL);
		assertTextNotEmptyAt(hostItem, 1);

		LTree propertiesTree = hostItem.getParent();

		// "Started at" property
		LTreeItem startItem = mShell.treeItem().withText(MoinBeanPropertySource.PROPERTY_STARTEDAT_LABEL);
		assertTextNotEmptyAt(startItem, 1);

		// "Uptime" property
		LTreeItem uptimeItem = mShell.treeItem().withText(MoinBeanPropertySource.PROPERTY_UPTIME_LABEL);
		assertTextNotEmptyAt(uptimeItem, 1);

		// "Version" property + children
		LTreeItem versionItem = mShell.treeItem().withText(MoinBeanPropertySource.PROPERTY_VERSION_LABEL);
		propertiesTree.expand(versionItem);
		LTreeItem commentItem = mShell.treeItem().withText(MoinVersionPropertySource.PROPERTY_VERSION_COMMENT_LABEL);
		versionItem.hasItem(commentItem);
		LTreeItem numberItem = mShell.treeItem().withText(MoinVersionPropertySource.PROPERTY_VERSION_NO_LABEL);
		versionItem.hasItem(numberItem);
		LTreeItem dateItem = mShell.treeItem().withText(MoinVersionPropertySource.PROPERTY_VERSION_DATE_LABEL);
		versionItem.hasItem(dateItem);
	}

	@SuppressWarnings("nls")
	public void testPropertiesPartitionable() throws Exception {

		Connection connection = createConnection();
		Component component = createComponent(connection);
		MRI mri = ((Partitionable) component).get___Mri();

		LTreeItem connectionItem = revealConnectionNode(connection, true);
		if (connectionItem == null)
			return;

		LTreeItem partitionableItem;
		try {
			partitionableItem = revealPartitionableItem(connection, connectionItem.getParent());
		}
		catch (NoWidgetFoundException e) {
			// Happens sometimes. How to avoid?
			TestUtil.printInfo(this, TestUtil.exceptionToString(e));
			return;
		}

		mShell.clickOn(partitionableItem);
		mAbbotFactory.delay(1000);

		// "MofId"
		LTreeItem mofIdItem = mShell.treeItem().withText(PartitionableNodePropertySource.PROPERTY_MOFID_LABEL);
		String mofIdString = assertTextNotEmptyAt(mofIdItem, 1);
		assertEquals("Property value must contain Mof Id", mri.getMofId(), mofIdString);

		LTree propertiesTree = mofIdItem.getParent();

		// "Mri"
		LTreeItem mriItem = propertiesTree.treeItem().withText(PartitionableNodePropertySource.PROPERTY_MRI_LABEL);
		String mriString = assertTextNotEmptyAt(mriItem, 1);
		assertEquals("Property value must contain MRI", mri.toString(), mriString);

		// "Type"
		LTreeItem typeItem = propertiesTree.treeItem().withText(PartitionableNodePropertySource.PROPERTY_TYPE_LABEL);
		String typeString = assertTextNotEmptyAt(typeItem, 1);
		assertEquals("Property value must contain Mof type", "WebDynpro.component.Component", typeString);

		// "Attributes" + children
		LTreeItem attsItem = propertiesTree.treeItem().withText(PartitionableNodePropertySource.PROPERTY_ATTRIBUTES_LABEL);
		propertiesTree.expand(attsItem);
		LTreeItem[] attsItems = attsItem.getItems();
		assertTrue(attsItems.length > 0);
		LTreeItem nameItem = attsItems[0].withText("name");
		assertEquals("Property value must contain 'name' attribute", component.getName(), nameItem.getText(1));
	}

	@SuppressWarnings("nls")
	public void testDumpClipBoard() throws Exception {

		Connection connection = createConnection();
		createComponent(connection);

		LTreeItem connectionItem = revealConnectionNode(connection, true);
		if (connectionItem == null)
			return;

		LTreeItem partitionItem;
		try {
			partitionItem = revealPartition(connection, connectionItem.getParent());
		}
		catch (NoWidgetFoundException e) {
			// Happens sometimes. How to avoid?
			TestUtil.printInfo(this, TestUtil.exceptionToString(e));
			return;
		}

		mShell.rightClickOn(partitionItem);

		// Context menu "Dump Contents To"
		LMenuItem dumpItem = getMenuItem("/.*Dump Contents To.*/", "/.*Copy.*/");
		mShell.clickOn(dumpItem);

		// Context menu "Clipboard"
		final Clipboard clipboard = createClipboard();
		try {
			clearClipboard(clipboard);

			LMenuItem clipboardItem = mShell.menuItem().withText("/.*Clipboard.*/");
			mShell.clickOn(clipboardItem);

			String contents = getClipboardContents(clipboard);
			assertNotNull("Clipboard content must not be null", contents);
			assertTrue("Clipboard content must not be empty", contents.length() > 0);
		}
		finally {
			mShell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {

					clipboard.dispose();
					return null;
				}
			});
		}
	}

	@SuppressWarnings("nls")
	public void testDumpConsole() throws Exception {

		Connection connection = createConnection();
		createComponent(connection);

		LTreeItem connectionItem = revealConnectionNode(connection, true);
		if (connectionItem == null)
			return;

		LTreeItem partitionItem;
		try {
			partitionItem = revealPartition(connection, connectionItem.getParent());
		}
		catch (NoWidgetFoundException e) {
			// Happens sometimes. How to avoid?
			TestUtil.printInfo(this, TestUtil.exceptionToString(e));
			return;
		}

		mShell.rightClickOn(partitionItem);

		// Context menu "Dump Contents To"
		LMenuItem dumpItem = getMenuItem("/.*Dump Contents To.*/", "/.*Copy.*/");
		mShell.clickOn(dumpItem);

		LMenuItem consoleItem = mShell.menuItem().withText("/.*Console.*/");
		mShell.clickOn(consoleItem);
	}
	
	@SuppressWarnings("nls")
	public void testCopy() throws Exception {

		Connection connection = createConnection();
		createComponent(connection);

		LTreeItem connectionItem = revealConnectionNode(connection, true);
		if (connectionItem == null)
			return;

		LTreeItem partitionItem;
		try {
			partitionItem = revealPartition(connection, connectionItem.getParent());
		}
		catch (NoWidgetFoundException e) {
			// Happens sometimes. How to avoid?
			TestUtil.printInfo(this, TestUtil.exceptionToString(e));
			return;
		}

		mShell.rightClickOn(partitionItem);

		// Context menu "Copy"
		LMenuItem dumpItem = getMenuItem("/.*Copy.*/", "/.*Dump Contents To.*/");
		mShell.clickOn(dumpItem);

		final Clipboard clipboard = createClipboard();
		try {
			clearClipboard(clipboard);
			String contents = getClipboardContents(clipboard);
			assertNotNull("Clipboard content must not be null", contents);
			assertTrue("Clipboard content must not be empty", contents.length() > 0);
		}
		finally {
			mShell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {

					clipboard.dispose();
					return null;
				}
			});
		}
	}

	private LTreeItem revealPartition(Connection connection, LTree tree) throws WidgetException {

		LTreeItem partitionItem = mShell.treeItem().withText(connection.getNullPartition().getPri().toString());
		return tree.show(partitionItem);
	}

	@SuppressWarnings("nls")
	private LTreeItem revealPartitionableItem(Connection connection, LTree tree) throws WidgetException {

		LTreeItem partitionItem = mShell.treeItem().withText(connection.getNullPartition().getPri().toString());
		tree.show(partitionItem);
		tree.expand(partitionItem);
		LTreeItem[] partitionableItems = partitionItem.getItems();
		assertEquals("Must be one partitionable child of " + partitionItem, 1, partitionableItems.length);

		LTreeItem partitionableItem = partitionableItems[0];
		return partitionableItem;
	}

	@SuppressWarnings("nls")
	private Component createComponent(Connection connection) {

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage(CONTAINER_NAME_WEBDYNPRO, PACKAGE_NAME_COMPONENT);
		Component component = (Component) compPackage.getComponent().refCreateInstance();
		component.setName("testComponent");
		assertNotNull(component);
		return component;
	}

	@SuppressWarnings("nls")
	private static String assertTextNotEmptyAt(LTreeItem item, int col) throws WidgetException {

		String text = item.getText(col);
		assertTrue("Text must not be null for tree item " + item, text != null);
		assertTrue("Text must not be empty for tree item " + item, text.length() > 0);
		return text;
	}

	private LMenuItem getMenuItem(String menuText, String andText) throws WidgetException {

		LMenuItem menuItem = mShell.menuItem().withText(menuText);
		final LMenu contextMenu = mShell.waitForShowing(mShell.contextMenu().withItem(menuItem)
				.andItem(mShell.menuItem().withText(andText)));
		menuItem = contextMenu.hasDirectItem(menuItem);
		return menuItem;
	}

	private Clipboard createClipboard() throws WidgetException {

		return mShell.syncExec(new LRunnable<Clipboard>() {
			public Clipboard run() throws Exception {

				return new Clipboard(Display.getDefault());
			}
		});
	}

	private void clearClipboard(final Clipboard clipboard) throws WidgetException {

		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				clipboard.clearContents();
				return null;
			}
		});
	}

	private String getClipboardContents(final Clipboard clipboard) throws WidgetException {

		return mShell.syncExec(new LRunnable<String>() {
			public String run() throws Exception {

				return (String) clipboard.getContents(TextTransfer.getInstance());
			}
		});
	}

}