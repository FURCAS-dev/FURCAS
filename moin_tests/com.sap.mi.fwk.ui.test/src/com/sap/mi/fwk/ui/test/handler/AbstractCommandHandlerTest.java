package com.sap.mi.fwk.ui.test.handler;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.handler.AbstractCommandHandler;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

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
 * @author d024127
 */
public class AbstractCommandHandlerTest extends ProjectBasedTest {

	private static final String DC_NAME = "test/" + AbstractCommandHandlerTest.class.getName();

	private Connection connection;
	private LFactory factory = null;
	private LShell shell = null;
	private Display display;

	public AbstractCommandHandlerTest() {
		super(DC_NAME);
	}

	protected void setUp() throws Exception {
		// delete used project here as well to be symmetric
		// with other/using project
		deleteUsedProject();
		super.setUp();

		factory = FactoryBuilder.newAbbotFactory();

		// wait 3 sec for editor startup
		factory.setWaitTimeout(3000);
		display = Display.getDefault();
		shell = factory.getShell(display);

		PDEUtil.closeWelcomePage();
		PDEUtil.prepareWorkbench();
		PDEUtil.maximizeWorkbenchAndRequestFocus();
		PDEUtil.assertDisplayIsActiveWindow();

		// disable OCL Constraint Checker
		PDEUtil.setAutoBuilding(false);
	}

	public void testGetConnection() {
		final TestHandler th = new TestHandler();
		final Connection[] cons = new Connection[1];

		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				cons[0] = (Connection) runNonPublicMethod(th, "getOrCreateDefaultConnection", new Class[] { IProject.class },
						new Object[] { getProject() });
				return null;
			}
		};

		try {
			shell.syncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		Connection probe = ConnectionManager.getInstance().getExistingDefaultConnection(getProject());
		assertEquals(probe, cons[0]);
	}

	public void testExecute() {
		Connection conn = createConnection();
		final TestCommand tc = new TestCommand(conn);
		final TestHandler th = new TestHandler();

		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				runNonPublicMethod(th, "execute", new Class[] { Command.class }, new Object[] { tc });
				return null;
			}
		};

		try {
			shell.syncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		assertTrue("Command not executed", tc.executed);

		conn.close();
	}

	public void testSetProgressMonitor() {
		TestHandler th = new TestHandler();
		connection = createConnection();
		th.setProMon(connection, new NullProgressMonitor());
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return true;
	}

	@Override
	protected boolean deleteProjectOnTearDown() {
		return true;
	}

	@Override
	protected void tearDown() throws Exception {
		if (connection != null && connection.isAlive()) {
			connection.close();
		}
		super.tearDown();
	}

	@Override
	public void dispose() throws Exception {
		super.dispose();
		// delete used project here as we try to be symmetric
		// with other/using project
		deleteUsedProject();
	}

	private void deleteUsedProject() {
		IProject usedProject = TestUtil.getLocalMoinDCProject(DC_NAME);
		if (usedProject != null)
			TestUtil.deleteLocalMoinDCProject(usedProject);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	private static final class TestHandler extends AbstractCommandHandler {

		public Object execute(ExecutionEvent event) throws ExecutionException {
			return null;
		}

		public void setProMon(final Connection connection, final IProgressMonitor monitor) {
			setProgressMonitor(connection, monitor);
		}
	}

	private static final class TestCommand extends Command {

		public boolean executed = false;
		private long delay = 0;

		protected TestCommand(Connection connection) {
			super(connection);
		}

		protected TestCommand(Connection connection, long delay) {
			super(connection);
			this.delay = delay;
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			executed = true;
			if (delay > 0) {
				long start = System.currentTimeMillis();
				while ((System.currentTimeMillis() - start) < delay) {

				}
			}
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			return null;
		}

	}
}