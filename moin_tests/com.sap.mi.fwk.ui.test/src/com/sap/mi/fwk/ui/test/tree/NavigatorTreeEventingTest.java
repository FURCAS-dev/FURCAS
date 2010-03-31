package com.sap.mi.fwk.ui.test.tree;

import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Display;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeLabelProvider;
import com.sap.tc.moin.nwdi.dctype.MoinTestDcType;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for StructuredViewer based event adapters. This test class contains
 * tests that ensure that a viewer refresh is triggered in different model
 * change scenarios.
 * 
 * TODO: Currently the test testProjectEventAdapterUsingDifferentDC is based on
 * corresponding projects in the workspace, we should also check whether the
 * refresh happens if the used DC is only available as archive (build of used DC
 * and project close required in this scenario)
 * 
 * @author d022960
 */
public class NavigatorTreeEventingTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/navigatortreeeventing";
	private static final String DC_NAME_USED = "test/navigatortreeeventing/used";
	private static final IPath SOURCE_FOLDER = new Path("src");
	private static final IPath PARTITION_NAME = SOURCE_FOLDER.append("com").append("sap").append("TESTPROJECT-TreeEventingTest.xmi");

	private Connection connection;
	private Connection defaultConnection;
	private Connection connectionUsed;
	private PartitionService partitionService;
	private LFactory factory = null;
	private LShell shell = null;
	private RefreshMonitor monitor;

	public NavigatorTreeEventingTest() {
		super(DC_NAME);
		partitionService = ModelManager.getPartitionService();
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected InputStream getProjectContentAsStream() {
		return NavigatorTreeEventingTest.class.getResourceAsStream("/com/sap/mi/fwk/ui/test/tree/TreeEventingTestData.zap");
	}

	@Override
	protected void setUp() throws Exception {
		// delete used project here as weel to be symmetric
		// with other/using project
		deleteUsedProject();
		super.setUp();
		factory = FactoryBuilder.newAbbotFactory();
		monitor = new RefreshMonitor();

		// wait 3 sec for editor startup
		factory.setWaitTimeout(3000);
		shell = factory.getShell(Display.getDefault());
		PDEUtil.prepareWorkbench();
		// disable OCL Constraint Checker
		PDEUtil.setAutoBuilding(false);
	}

	@Override
	protected void tearDown() throws Exception {
		if (connectionUsed != null && connectionUsed.isAlive()) {
			connectionUsed.close();
		}
		if (connection != null && connection.isAlive()) {
			connection.close();
		}
		if (defaultConnection != null && defaultConnection.isAlive()) {
			defaultConnection.close();
		}
		// delete used project here as weel to be symmetric
		// with other/using project
		deleteUsedProject();

		super.tearDown();
	}

	@Override
	public void dispose() throws Exception {
		super.dispose();
		// delete used project here as we try to be symmetric
		// with other/using project
		deleteUsedProject();
	}

	@Override
	protected boolean deleteProjectOnTearDown() {
		return true;
	}

	/**
	 * Test for StructuredProjectViewerEventAdapterImpl. This test ensures that
	 * modifying the content via a connection (default connection) which is
	 * identical with the connection used to display the content in the tree
	 * viewer. The viewer is refreshed immediately after modification.
	 */
	public void testProjectEventAdapterUsingSameConnection() throws Exception {
		defaultConnection = ModelManager.getConnectionManager().getOrCreateDefaultConnection(getProject());
		LShell lDialog = null;

		try {
			// use default connection for initialization of TreeViewer as the
			// correct EventAdapter implementation
			// is determined by the connection type
			lDialog = createTestDialog(defaultConnection, getProject(), monitor);
			monitor.start();

			// modify model content using same connection
			createComponent(defaultConnection);

			factory.delay(1000);
			assertTrue("Number of tree viewer refreshs does not match the expected value - expected 1 refresh, triggered refreshs "
					+ monitor.getRefreshCount(), monitor.getRefreshCount() > 0);
			System.out.println("Number of tree viewer refreshs " + monitor.getRefreshCount());
		} finally {
			if (lDialog != null) {
				lDialog.close();
			}
		}
	}

	/**
	 * Test for StructuredProjectViewerEventAdapterImpl. This test ensures that
	 * modifying the content via a different connection triggers a tree refresh
	 * of the viewer which displays model content based on the default
	 * connection. The tree viewer is refreshed after the save operation via a
	 * PartitionChange Event.
	 */
	public void testProjectEventAdapterUsingDifferentConnection() throws Exception {
		defaultConnection = ModelManager.getConnectionManager().getOrCreateDefaultConnection(getProject());
		LShell lDialog = null;

		try {
			// use default connection for initialization of TreeViewer as the
			// correct EventAdapter implementation
			// is determined by the connection type
			lDialog = createTestDialog(defaultConnection, getProject(), monitor);

			// modify model content using different connection
			connection = createConnection();
			Component component = createComponent(connection);
			ModelPartition partition = partitionService.getPartition(connection, getProject(), PARTITION_NAME);
			partition.assignElement(component);

			// refresh has to be triggered on save
			monitor.start();
			connection.save();
			factory.delay(1000);
			assertTrue("Number of tree viewer refreshs does not match the expected value - expected 1 refresh, triggered refreshs "
					+ monitor.getRefreshCount(), monitor.getRefreshCount() > 0);
			System.out.println("Number of tree viewer refreshs " + monitor.getRefreshCount());
		} finally {
			if (lDialog != null) {
				lDialog.clickOn(lDialog.button().ok());
				lDialog.waitForClosed();
			}
		}
	}

	/**
	 * Test for StructuredProjectViewerEventAdapterImpl. This test ensures that
	 * modifying the content of a used DC triggers a refresh of the tree which
	 * displays the content (using the default connection) of the using DC. For
	 * this it creates a connection for the used DC, modifies the content. The
	 * tree content of the viewer displayed in the dialog is based on the
	 * default connection of the using DC. The tree viewer is refreshed after
	 * saving the modified content of the used DC.
	 */
	public void testProjectEventAdapterUsingDifferentDC() throws Exception {
		defaultConnection = ModelManager.getConnectionManager().getOrCreateDefaultConnection(getProject());
		createUsedDc();
		LShell lDialog = null;

		try {
			// use default connection for initialization of TreeViewer as the
			// correct EventAdapter implementation
			// is determined by the connection type
			lDialog = createTestDialog(defaultConnection, getProject(), monitor);

			// modify model content of used DC
			Component component = createComponent(connectionUsed);
			IProject usedProject = ModelAdapter.getInstance().getProject(connectionUsed);
			PRI pri = getPri(usedProject, new Path("src/com/sap/test/used/Component"));
			ModelPartition partition = connectionUsed.getPartition(pri);
			if (partition != null)
				partition.delete();
			partition = connectionUsed.createPartition(pri);
			partition.assignElementIncludingChildren(component);
			usedProject.refreshLocal(IProject.DEPTH_INFINITE, null);

			// refresh has to be triggered on save
			monitor.start();
			connectionUsed.save();

			factory.delay(1000);
			assertTrue("Number of tree viewer refreshs does not match the expected value - expected 1 refresh, triggered refreshs "
					+ monitor.getRefreshCount(), monitor.getRefreshCount() > 0);
			System.out.println("Number of tree viewer refreshs " + monitor.getRefreshCount());
		} finally {
			if (lDialog != null) {
				lDialog.clickOn(lDialog.button().ok());
				lDialog.waitForClosed();
			}
		}
	}

	private LShell createTestDialog(final Connection connection, final Object input, final ViewerTestDialog.IRefreshMonitor monitor)
			throws WidgetException {
		shell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				ViewerTestDialog dialog = new ViewerTestDialog(shell.getWidget(), "Tree Eventing Test", connection, monitor,
						new NavigatorTreeContentProvider(), new TreeNodeLabelProvider() {
							@Override
							public String getText(Object element) {
								String text = super.getText(element);
								if (text == null) {
									text = element.toString();
								}
								return text;
							}
						});
				dialog.setInput(input);
				dialog.open();
				return null;
			}
		});

		LShell lDialog = shell.waitForShowing(shell.childShell().withName(ViewerTestDialog.class.getName()));
		return lDialog;
	}

	private void createUsedDc() throws Exception {
		IProject projectUsed = TestUtil.createLocalMoinDCProject(DC_NAME_USED, MoinTestDcType.getDcType());
		connectionUsed = ConnectionManager.getInstance().createConnection(projectUsed);
		TestUtil.addPublicPartDependency(getProject(), DC_NAME_USED, MoinProject.VENDOR_SAP, MoinTestDcType.PP_NAME_COMPILATION, true,
				false, false);
	}

	private Component createComponent(Connection connection) {
		Component component = connection.createElementInPartition(Component.CLASS_DESCRIPTOR, null);
		component.setName("newComp");
		return component;
	}

	private void deleteUsedProject() {
		IProject usedProject = TestUtil.getLocalMoinDCProject(DC_NAME_USED);
		if (usedProject != null)
			TestUtil.deleteLocalMoinDCProject(usedProject);
	}

	static class RefreshMonitor implements ViewerTestDialog.IRefreshMonitor {
		int noOfRefreshs = 0;
		boolean initialization = true;

		public void refresh(Object element, boolean updateLabels) {
			if (!initialization) {
				synchronized (this) {
					noOfRefreshs++;
					System.out.println("Tree refresh triggered");
				}
			}
		}

		void start() {
			initialization = false;
		}

		int getRefreshCount() {
			return noOfRefreshs;
		}
	};

}
