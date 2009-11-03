package com.sap.mi.tools.diagnostics.internal;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;

import com.sap.ide.junit.ui.lift.LMenu;
import com.sap.ide.junit.ui.lift.LMenuItem;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.tc.moin.repository.Connection;

/**
 * Tests the diagnostics view
 * 
 * @author d031150
 * @author d003456
 */
public class DiagnosticsViewTest extends DiagnosticsViewTestFixture {

	public DiagnosticsViewTest() {

		this(DC_NAME);
	}

	public DiagnosticsViewTest(String name) {

		super(name);
	}

	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testView() throws Exception {

		Connection connection = createConnection();
		mAbbotFactory.delay(2000);

		revealConnectionNode(connection, false);
	}

	@SuppressWarnings("nls")
	public void testActionDumpClipBoard() throws Exception {

		Connection connection = createConnection();

		LTreeItem connectionItem = revealConnectionNode(connection, false);
		if (connectionItem == null)
			return;

		mShell.rightClickOn(connectionItem);

		// Context menu "Dump Stack"
		LMenuItem dumpItem = getMenuItem("/.*Dump.*/", "/.*Close.*/");
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
	public void testActionDumpConsole() throws Exception {

		Connection connection = createConnection();

		LTreeItem connectionItem = revealConnectionNode(connection, false);
		if (connectionItem == null)
			return;

		mShell.rightClickOn(connectionItem);

		// Context menu "Dump Allocation Stack To"
		LMenuItem dumpItem = getMenuItem("/.*Dump Allocation Stack To.*/", "/.*Close.*/");
		mShell.clickOn(dumpItem);

		// Context menu "Console"
		LMenuItem consoleItem = mShell.menuItem().withText("/.*Console.*/");
		mShell.clickOn(consoleItem);
	}

	@SuppressWarnings("nls")
	public void testCloseAction() throws Exception {

		Connection connection = createConnection();

		LTreeItem connectionItem = revealConnectionNode(connection, false);
		if (connectionItem == null)
			return;

		mShell.rightClickOn(connectionItem);
		// Context menu "Close"
		LMenuItem closeItem = getMenuItem("/.*Close.*/", "/.*Dump.*/");
		mShell.clickOn(closeItem);
		LShell dialog = mShell.childShell().withText("Connection Close").andShows().resolve();
		dialog.clickOn(dialog.button().ok());
		
		assertEquals("Connection is not closed", false, connection.isAlive());

	}

	private LMenuItem getMenuItem(String menuText, String andText) throws WidgetException {

		LMenuItem menuItem = mShell.menuItem().withText(menuText);
		final LMenu contextMenu = mShell.waitForShowing(mShell.contextMenu().withItem(menuItem).andItem(
				mShell.menuItem().withText(andText)));
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