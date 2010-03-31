package com.sap.mi.fwk.test;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.services.local.ErrorHandling;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for {@link ConnectionManager}
 * 
 * @author d031150
 */
public class ConnectionManagerTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/connectionmanager";
	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/conmgr");

	private final ConnectionManager mConnectionManager;
	private Connection mConnection;
	private Connection mCustomConnection;
	private IProject project2;

	public ConnectionManagerTest() {
		super(DC_NAME);
		mConnectionManager = ModelManager.getConnectionManager();
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setDeleteProjectOnTearDown();
		mConnection = createConnection();
	}

	@Override
	protected void tearDown() throws Exception {
		mConnection = null;
		if (mCustomConnection != null && mCustomConnection.isAlive()) {
			mCustomConnection.close();
		}
		mCustomConnection = null;

		if (project2 != null) {
			TestUtil.deleteLocalMoinDCProject(project2);
			project2 = null;
		}

		super.tearDown();
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	/**
	 * @deprecated TODO to be deleted once getDefaultConnection has been deleted
	 */
	@Deprecated
	public void testGetConnectionProject() {
		IProject project = getProject();
		Connection con2 = mConnectionManager.getDefaultConnection(project);
		Connection con3 = mConnectionManager.getDefaultConnection(project);
		assertEquals("Two calls to getDefaultConnection(project, actual) did not return same connection objects", con2,
				con3);
	}

	public void testGetOrCreateDefaultConnection() {
		IProject project = getProject();
		Connection con1 = mConnectionManager.getOrCreateDefaultConnection(project);
		Connection con2 = mConnectionManager.getOrCreateDefaultConnection(project);
		assertEquals(
				"Two calls to getOrCreateDefaultConnection(project, actual) did not return same connection objects",
				con1, con2);
	}

	public void testGetExistingDefaultConnection() {
		IProject project = getProject();
		// must return null
		Connection con1 = mConnectionManager.getExistingDefaultConnection(project);
		assertNull(
				"A call to getExistingDefaultConnection(project) must return null in case the connection has not already been created",
				con1);
		// must return a valid default connection
		con1 = mConnectionManager.getOrCreateDefaultConnection(project);
		assertNotNull("A call to getOrCreateDefaultConnection(project) must return a valid connection object", con1);
		// must return the existing default connection
		Connection con2 = mConnectionManager.getExistingDefaultConnection(project);
		assertEquals(
				"Two calls to getExistingDefaultConnection(project, actual) did not return same connection objects",
				con1, con2);
	}

	public void testCreateConnectionThrowingMoinBaseRuntimeException() throws CoreException {
		IProject project = getProject();

		// close project to produce an error condition
		project.close(null);

		{
			try {
				Connection connection = mConnectionManager.createConnection(project);
				fail("MoinBaseRuntimeException expected. Connection: " + connection);
			} catch (MoinBaseRuntimeException expected) {
			}
		}
	}

	public void testCreateConnectionThrowingIllegalStateException() {
		final IProject project = getProject();

		try {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					Connection connection = mConnectionManager.createConnection(project);
					fail("IllegalStateException expected. Connection: " + connection);
				}
			});
		} catch (IllegalStateException expected) {
		}
	}

	public void testGetOrCreateDefaultConnectionThrowingIllegalStateException() {
		final IProject project = getProject();

		try {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					Connection connection = mConnectionManager.getOrCreateDefaultConnection(project);
					fail("IllegalStateException expected, Connection: " + connection);
				}
			});
		} catch (IllegalStateException expected) {
		}
	}

	public void testCreateTransientConnection() {
		mCustomConnection = mConnectionManager.createTransientConnection();
	}

	public void testGetUndoContext() {
		IProject project = getProject();
		Connection con1 = mConnectionManager.createConnection(project);
		ModelManager.getConnectionManager().addUndoContext(con1);
		Connection con2 = mConnectionManager.createConnection(project);
		ModelManager.getConnectionManager().addUndoContext(con2);

		try {
			assertNotSame("Connections are identical. Expected to be different", con1, con2);

			IUndoContext undoContext1 = mConnectionManager.getUndoContext(con1);
			IUndoContext undoContext2 = mConnectionManager.getUndoContext(con2);

			assertNotSame("UndoContexts must be different", undoContext1, undoContext2);
		} finally {
			con1.close();
			con2.close();
		}
	}

	public void testGetProjectForDefaultConnection() {
		IProject project = getProject();
		Connection con = mConnectionManager.getOrCreateDefaultConnection(project);
		IProject probe = mConnectionManager.getProjectForDefaultConnection(con);

		assertEquals("Different default project returned", project, probe);
	}

	public void testGetConnectionsForProject() {
		IProject project = getProject();

		Connection probe = mConnectionManager.getOrCreateDefaultConnection(project);
		Collection<Connection> connections = mConnectionManager.getConnections(project);
		assertTrue("Connections " + connections.toArray() + " should contain " + probe, connections.contains(probe));
		probe = mConnection;
		connections = mConnectionManager.getConnections(project);
		assertTrue("Connections " + connections.toArray() + " should contain " + probe, connections.contains(probe));

		try {
			mConnectionManager.getConnections(null);
			fail("getConnections(null) should raise an exception");
		} catch (RuntimeException e) { // $JL-EXC$
		}
	}

	public void testGetDirtyConnections() {
		IProject project = getProject();
		ComponentPackage pack = (ComponentPackage) mConnection.getPackage(CONTAINER_NAME_WEBDYNPRO,
				PACKAGE_NAME_COMPONENT);
		pack.getComponent().refCreateInstance();

		Collection<Connection> dirtyConnections = mConnectionManager.getDirtyConnections(project);
		assertTrue("Connections " + dirtyConnections.toArray() + " should contain " + mConnection, dirtyConnections
				.contains(mConnection));

		Connection newConn = createConnection();
		dirtyConnections = mConnectionManager.getDirtyConnections(project);
		assertFalse("Connections " + dirtyConnections.toArray() + " must not contain " + newConn, dirtyConnections
				.contains(newConn));
	}

	public void testGetSaveConnections() {
		try {
			mConnectionManager.getSaveConnections((Connection) null, null);
			fail("Exception expected");
		} catch (RuntimeException expected) {
		}
		try {
			mConnectionManager.getSaveConnections((Command) null, null);
			fail("Exception expected");
		} catch (RuntimeException expected) {
		}

		{
			TestCommand cmd = new TestCommand(mConnection);
			Collection<Connection> connections = mConnectionManager.getSaveConnections(cmd, null);
			assertTrue("No connections expected: " + connections, connections.isEmpty());
		}

		PRI pri = getPri(getProject(), PARTITION_FOLDER.append("partitionTestGetSaveConnection"));
		ModelPartition partition = mConnection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = mConnection.createPartition(pri);
		assertConnectionSave(mConnection);

		{
			TestCommand cmd = new TestCommand(mConnection);
			cmd.setAffectedPartition(pri);
			Collection<Connection> connections = mConnectionManager
					.getSaveConnections(cmd, cmd.getAffectedPartitions());
			assertTrue("No connections expected: " + connections, connections.isEmpty());
		}
		{
			Connection connection2 = createConnection();
			connection2.createElementInPartition(Component.class, partition);

			TestCommand cmd = new TestCommand(mConnection);
			cmd.setAffectedPartition(pri);
			Collection<Connection> connections = mConnectionManager
					.getSaveConnections(cmd, cmd.getAffectedPartitions());
			assertEquals("One connection expected: " + connections, 1, connections.size());

			connections = mConnectionManager.getSaveConnections(cmd, null);
			assertEquals("One connection expected: " + connections, 1, connections.size());

			assertConnectionSave(connection2);
		}
	}

	public void testGetSaveConnections_TwoProjects() {
		PRI pri = getPri(getProject(), PARTITION_FOLDER.append("partitionTestGetSaveConnections_TwoProjects"));
		ModelPartition partition = mConnection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = mConnection.createPartition(pri);
		assertConnectionSave(mConnection);

		// second project with connection
		project2 = TestUtil.createLocalMoinDCProject(getDcName() + "_2");
		Connection connection2 = mCustomConnection = mConnectionManager.createConnection(project2);

		TestCommand cmd = new TestCommand(connection2);
		cmd.setAffectedPartition(pri);
		Collection<Connection> connections = mConnectionManager.getSaveConnections(cmd, cmd.getAffectedPartitions());
		// dirty connection from other project must not be considered
		assertTrue("No connections expected: " + connections, connections.isEmpty());
	}

	public void testSave() throws Exception {
		IProject project = getProject();
		final Connection connection = mConnectionManager.getOrCreateDefaultConnection(project);

		PRI pri = getPri(getProject(), PARTITION_FOLDER.append("partitionTestSave"));
		ModelPartition partition = connection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(pri);
		assertNotNull("Partition creation failed", partition);

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage(CONTAINER_NAME_WEBDYNPRO,
				PACKAGE_NAME_COMPONENT);
		Component component = (Component) compPackage.getComponent().refCreateInstance();
		component.setName("testComponent");
		assertNotNull(component);
		partition.assignElement(component);

		try {
			ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
				public void run(IProgressMonitor monitor) throws CoreException {
					try {
						mConnectionManager.save(connection);
					} catch (Exception e) {
						IStatus status = ErrorHandling.createStatus(IStatus.ERROR, 0, e.getMessage(), e,
								"com.sap.mi.fwk.test");
						throw new CoreException(status);
					}
				}
			}, null);
		} finally {
			connection.close();
		}
	}

	public void testIsDirty() {
		try {
			mConnectionManager.isDirty(null);
			fail("ConnectionManager.isDirty() must not accept null");
		} catch (Exception expected) {
		}

		mConnection.close();
		try {
			boolean dirty = mConnectionManager.isDirty(mConnection);
			assertFalse("Connection must not be dirty", dirty);
		} catch (Exception e) {
			fail("ConnectionManager.isDirty() must cope with closed connections", e);
		}
	}

	public void testIsTransient() {
		try {
			mConnectionManager.isTransient(null);
			fail("ConnectionManager.isTransient() must not accept null");
		} catch (Exception expected) {
		}

		mCustomConnection = mConnectionManager.createTransientConnection();
		boolean isTransient = mConnectionManager.isTransient(mCustomConnection);
		assertTrue("Connection must be transient: " + mCustomConnection, isTransient);

		mCustomConnection.close();
		try {
			mConnectionManager.isTransient(mCustomConnection);
			fail("ConnectionManager.isTransient() must fail with closed connections");
		} catch (Exception expected) {
		}
	}

	public void testLabelIsSet() {
		IProject project = getProject();

		{
			mCustomConnection = mConnectionManager.createConnection(project);
			String label = mCustomConnection.getLabel();
			assertEquals("Project name must be set as label of connection " + mCustomConnection, project.getName(),
					label);
		}
		{
			Connection connection = mConnectionManager.getOrCreateDefaultConnection(project);
			String label = connection.getLabel();
			assertFalse("Label must indicate default connection. Label: " + label, project.getName().equals(label));
		}
	}

	public void testCloseDefaultConnectionOnProjectClose() throws Exception {
		IProject project = getProject();

		Connection defConnection = mConnectionManager.getOrCreateDefaultConnection(project);
		assertTrue("Default connection must be alive", defConnection.isAlive());
		project.close(null);
		// closing happens async, see ConnectionManager.DefaultConnectionCloser
		Job.getJobManager().join("com.sap.mi.fwk.jobs.CloseConnection", null);
		assertFalse("Default connection must be closed after closing the project", defConnection.isAlive());
	}

	public void testCloseDefaultConnectionOnProjectDeletion() throws Exception {
		IProject project = getProject();

		Connection defConnection = mConnectionManager.getOrCreateDefaultConnection(project);
		assertTrue("Default connection must be alive", defConnection.isAlive());
		TestUtil.deleteLocalMoinDCProject(project);
		int i = 0;
		while (defConnection.isAlive() && i < 10) {
			// Wait in case of slow machine
			sleep(100);
			i++;
		}
		assertFalse("Default connection must be closed after deletion of the project", defConnection.isAlive());
	}

	private static final class TestCommand extends Command {

		private Set<PartitionOperation> partitions;

		protected TestCommand(Connection connection) {
			super(connection);
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			return partitions;
		}

		public void setAffectedPartition(PRI pri) {
			PartitionOperation op = new PartitionOperation(Operation.EDIT, pri);
			partitions = Collections.singleton(op);
		}

	}
}