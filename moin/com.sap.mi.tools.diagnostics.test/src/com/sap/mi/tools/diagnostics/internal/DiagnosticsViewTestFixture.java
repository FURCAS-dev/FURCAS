package com.sap.mi.tools.diagnostics.internal;

import org.eclipse.swt.widgets.Display;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTree;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.ui.lift.NoWidgetFoundException;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.tools.diagnostics.test.DiagnosticsTestPerspective;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Helper methods for diagnostics view tests
 * 
 * @author d031150
 */
public abstract class DiagnosticsViewTestFixture extends WebDynproProjectTest {

	protected static final String DC_NAME = "test/diagview";
	private static final boolean JMX_ENABLED = System.getProperty("com.sun.management.jmxremote.port") != null;

	protected LFactory mAbbotFactory;
	protected LShell mShell;

	public DiagnosticsViewTestFixture() {
		this(DC_NAME);
	}

	public DiagnosticsViewTestFixture(String name) {
		super(name);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		assertTrue("JMX is not enabled. Set VM argument '-Dcom.sun.management.jmxremote.port'.", JMX_ENABLED);

		super.setUp();

		ActiveSWTTestSuite.requestScreenShotFor(this);

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);
		mAbbotFactory.setFindTimeOut(3000);
		mShell = mAbbotFactory.getShell(Display.getDefault());

		PDEUtil.prepareWorkbench();

		// we use an own perspective to have diag and properties view arranged
		// side by side
		PDEUtil.openPerspective(DiagnosticsTestPerspective.ID);
		// close and open view
		PDEUtil.hideView(DiagnosticsPlugin.ID_VIEW);
		mAbbotFactory.delay(500);
		PDEUtil.showView(DiagnosticsPlugin.ID_VIEW);
		mAbbotFactory.delay(500);
	}

	@Override
	protected void tearDown() throws Exception {
		// close menu in either case
		mShell.enter(mAbbotFactory.key().esc());

		super.tearDown();
	}

	/**
	 * Currently returns null in case of UI instabilities
	 */
	protected LTreeItem revealConnectionNode(Connection connection, boolean expand) throws WidgetException {
		LTreeItem moinItem = revealMoinNode(true);
		LTree tree = moinItem.getParent();

		// TreeItem "Connections"
		LTreeItem connectionsItem = mShell.treeItem().withText("/.*Connections.*/");
		tree.show(connectionsItem);
		tree.expand(connectionsItem);

		// TreeItem "<connectionId>"
		final LTreeItem connectionItem = mShell.treeItem().withText("/.*" + connection.getId() + ".*/");
		try {
			tree.show(connectionItem);
		} catch (NoWidgetFoundException e) {
			// TODO [Tests] Happens sometimes. How to avoid?
			TestUtil.printInfo(this, TestUtil.exceptionToString(e));
			return null;
		}
		if (expand)
			tree.expand(connectionItem);
		return connectionItem;
	}

	protected LTreeItem revealMoinNode(boolean expand) throws WidgetException {
		// Tree
		LTree tree = mShell.tree().withName(DiagnosticsContentProvider.NAME_DIAGNOSTICS_TREE);

		// TreeItem "Moin"
		LTreeItem moinItem = mShell.treeItem().withText("/Moin.*/");
		tree.show(moinItem);
		if (expand)
			tree.expand(moinItem);
		return moinItem;
	}

}