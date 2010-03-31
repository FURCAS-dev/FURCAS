package com.sap.mi.fwk.test.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.tc.moin.nwdi.dctype.MoinTestDcType;
import com.sap.tc.moin.repository.Connection;

/**
 * Base class for tests that store test data in one project. This project is
 * created on {@link #setUp()} and by default deleted on {@link #dispose()},
 * which is e.g. called by {@link DisposingTestSuite} when the whole test suite
 * has finished.
 * <p>
 * Optionally override {@link #getProjectContentAsStream()} to fill the project
 * with data.
 * <p>
 * Override {@link #getMetamodels()} to specify metamodels that should be
 * imported on {@link #setUp()}.
 * 
 * @author d031150
 */
public abstract class ProjectBasedTest extends MetamodelBasedTest implements DisposableTest {

	/**
	 * The source folder of the Moin test DC type (value is <code>src</code>).
	 * Since other DC types may define other paths, <b>only use it for projects
	 * that have been created by this test</b>.
	 */
	public static final IPath SOURCE_FOLDER = MoinTestDcType.SOURCE_FOLDER;

	/**
	 * The test's project. Not available before {@link #setUp()}.
	 */
	private IProject mProject;

	/**
	 * Indicates the project to be deleted on {@link #tearDown()}
	 */
	private boolean mDeleteOnTearDown = false;

	private final Set<Connection> mConnections = new HashSet<Connection>();

	/**
	 * Creates a test
	 * 
	 * @see TestCase#TestCase()
	 */
	public ProjectBasedTest() {
		super();
	}

	/**
	 * Creates the test with the given name
	 * 
	 * @param name
	 *            the test name
	 * 
	 * @see TestCase#TestCase(String)
	 */
	public ProjectBasedTest(String name) {
		super(name);
	}

	/**
	 * @return the name of the DC test data should be stored in. A corresponding
	 *         project can be obtained by {@link #getProject()}. Note that the
	 *         project has a different name than the DC.
	 */
	protected abstract String getDcName();

	/**
	 * @return the type of the DC test data should be stored in. A corresponding
	 *         project can be obtained by {@link #getProject()}. Note that the
	 *         project has a different name than the DC.
	 */
	protected IComponentType getDcType() {
		return MoinTestDcType.getDcType();
	}

	/**
	 * Returns an {@link InputStream} containing the future project content. The
	 * Moin content can be exported by zipping the DC project folder, e.g. if
	 * your DC was <code>fooBar</code>, zip
	 * <code>New_configuration.jdi\LocalDevelopment\DCs\sap.com\fooBar\_comp\src</code>
	 * (click zip on the <code>src</code> folder so that the zip is next to the
	 * <code>src</code> folder).
	 * 
	 * @return such a stream or <code>null</code> (default implementation),
	 *         which means that an empty project is created
	 * 
	 * @see Class#getResourceAsStream(String)
	 * @see FileInputStream
	 */
	protected InputStream getProjectContentAsStream() {
		return null;
	}

	/**
	 * @return {@link #NO_METAMODELS}
	 */
	protected String[] getMetamodels() {
		return NO_METAMODELS;
	}

	/**
	 * @return <code>true</code> if the project should be deleted for each test
	 *         (method) during {@link #tearDown()}. This implementation returns
	 *         whatever has been set by {@link #setDeleteProjectOnTearDown()}
	 *         (which defaults to <code>false</code>).
	 * 
	 * @see #setDeleteProjectOnTearDown()
	 * @see #tearDown()
	 */
	protected boolean deleteProjectOnTearDown() {
		return mDeleteOnTearDown;
	}

	/**
	 * Marks the test's project for deletion after this test has finished.
	 * Single test (methods) should call this after they have persistently
	 * modified the project contents (usually after {@link Connection#save()}).
	 * Transient changes, however, can more easily be rollbacked by reverting
	 * the corresponding connections.
	 * 
	 * @see #deleteProjectOnTearDown()
	 * @see #assertConnectionSave(Connection, boolean)
	 */
	protected void setDeleteProjectOnTearDown() {
		mDeleteOnTearDown = true;
	}

	/**
	 * @return <code>true</code> if the project should be deleted for each test
	 *         (method) during {@link #setUp()}. Default is <code>false</code>,
	 *         i.e. an existing project with the same name as
	 *         {@link #getDcName()} will be used.
	 * 
	 * @see #deleteProjectOnTearDown()
	 * @see #setUp()
	 */
	protected boolean deleteProjectOnSetUp() {
		return false;
	}

	/**
	 * @return the project for the test. Not available before {@link #setUp()}
	 *         is called.
	 */
	protected final IProject getProject() {
		String dcName = getDcName();
		assertNotNull("No project for DC '" + dcName + "' found.", mProject); //$NON-NLS-1$ //$NON-NLS-2$
		assertTrue("Project with name '" + mProject.getName() + "' is not open.", mProject.isAccessible()); //$NON-NLS-1$ //$NON-NLS-2$
		return mProject;
	}

	/**
	 * Creates a connection for the test's project. The returned is always a new
	 * one, and is closed on {@link #tearDown()} latest.
	 * 
	 * @return a new connection
	 * 
	 * @see #getConnections()
	 * @see #closeConnections()
	 */
	protected Connection createConnection() {
		IProject project = getProject();
		Connection connection = TestUtil.createConnection(project, getName());
		mConnections.add(connection);
		return connection;
	}

	/**
	 * @return all connections that this test has created up to now
	 * 
	 * @see #createConnection()
	 */
	protected final Set<Connection> getConnections() {
		return mConnections;
	}

	/**
	 * Saves the connection, fails if it could not be saved
	 * 
	 * @param connection
	 *            the connection to save
	 * @param deleteProjectOnTearDown
	 *            if <code>true</code>, the project is marked as to be deleted
	 *            on {@link #tearDown()}
	 * 
	 * @see #assertConnectionSave(Connection)
	 * @see #setDeleteProjectOnTearDown()
	 */
	protected final void assertConnectionSave(Connection connection, boolean deleteProjectOnTearDown) {
		assertConnectionSave(connection);
		if (deleteProjectOnTearDown)
			setDeleteProjectOnTearDown();
	}

	/**
	 * Saves the connection, fails if it could not be saved
	 * 
	 * @param connection
	 *            the connection to save
	 * 
	 * @see #assertConnectionSave(Connection, boolean)
	 */
	protected static final void assertConnectionSave(Connection connection) {
		try {
			connection.save();
		} catch (Exception cause) { // $JL-EXC$
			// We do not use an AssertionFailedError since central test result
			// preparation
			// swallows causes of throw AssertionFailedErrors.
			RuntimeException e = new RuntimeException("Connection " + connection.getId() + //$NON-NLS-1$
					" (" + connection.getLabel() + ") could not be saved."); //$NON-NLS-1$ //$NON-NLS-2$
			e.initCause(cause);
			throw e;
		}
	}

	/**
	 * Creates a project for the returned DC name and fills it with test data if
	 * requested. Does nothing if the project already exists.
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		mConnections.clear();
		mDeleteOnTearDown = false;
		String dcName = getDcName();
		if (dcName == null)
			return;

		IComponentType dcType = getDcType();
		InputStream data = getProjectContentAsStream();

		if (deleteProjectOnSetUp())
			mProject = TestUtil.createLocalMoinDCProjectDeletingLoadingData(dcName, dcType, data);
		else
			mProject = TestUtil.getExistingLocalMoinDCProjectCreating(dcName, dcType, data);
	}

	/**
	 * Deletes the test's project if requested. Closes all connections of this
	 * test.
	 * 
	 * @see #deleteProjectOnTearDown()
	 * @see #closeConnections()
	 */
	@Override
	protected void tearDown() throws Exception {
		closeConnections();
		mConnections.clear();

		if (mProject != null && deleteProjectOnTearDown()) {
			TestUtil.deleteLocalMoinDCProject(mProject);
			mProject = null;
		}

		super.tearDown();
	}

	/**
	 * Closes all connections that this test has created, i.e. <em>only the ones 
	 * that have been created with {@link #createConnection()}</em>.
	 * 
	 * @see #getConnections()
	 * @see #createConnection()
	 */
	protected void closeConnections() {
		Set<Connection> connections = getConnections();
		for (Connection connection : connections) {
			if (connection != null && connection.isAlive()) {
				connection.close();
			}
		}
	}

	/**
	 * Deletes the project. Called automatically if one of the surrounding test
	 * suites is a {@link DisposingTestSuite}.
	 */
	public void dispose() throws Exception {
		if (mProject != null) {
			TestUtil.deleteLocalMoinDCProject(mProject);
			mProject = null;
		}
	}

}
