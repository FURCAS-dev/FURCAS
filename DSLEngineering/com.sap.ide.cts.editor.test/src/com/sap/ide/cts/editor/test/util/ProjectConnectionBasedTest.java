package com.sap.ide.cts.editor.test.util;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.junit.After;
import org.junit.Before;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.services.local.FileServices;
import com.sap.mi.fwk.services.local.ZipService;
import com.sap.tc.moin.repository.Connection;

/**
 * A JUnit 4 compatible, lightweight version of {@link ProjectBasedTest}
 * 
 * @author C5126871, D049157
 *
 */
@SuppressWarnings("restriction")
public abstract class ProjectConnectionBasedTest {

	private IProject mProject;
	private final Set<Connection> mConnections = new HashSet<Connection>();
	
	/**
	 * Set this to true in your testclass constructor to retrieve inMemory connections only.
	 * Those cannot be saved, but instead come with a great speed improvement.
	 */
	protected boolean memoryChangesOnly = false;
	
	private static final String MOIN_NATURE = "com.sap.mi.fwk.dcfwk.MoinNature";
	private static final String PLUGIN_NATURE = org.eclipse.pde.internal.core.natures.PDE.PLUGIN_NATURE;


	@Before
	public void setUp() throws CoreException, IOException {
	    	mProject = ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName());
		if (!memoryChangesOnly || !mProject.exists()) {
		    if (mProject.exists()) {
			// always delete old project before trying to write a new project
			// allows to mix memory only and persistent tests in the same suite
			deleteProject();
		    }
		    InputStream data = getProjectContentAsStream();
		    mProject = createProjectWithData(getProjectName(), data);
		    refreshProject(mProject);
		}
	}

	@After
	public void tearDown() throws Exception {		
		closeConnections();
		mConnections.clear();
		if (!memoryChangesOnly) {
		    deleteProject();
		}
	}
	
	private IProject createProjectWithData(String projectName, InputStream data) throws CoreException, IOException {
		final IProject prj = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		IProjectDescription desc;
		prj.create(null);
		prj.open(null);
		desc = ResourcesPlugin.getWorkspace().newProjectDescription(projectName);
		desc.setNatureIds(new String[] {PLUGIN_NATURE, MOIN_NATURE });
		prj.setDescription(desc, null);
		loadData(ProjectConnectionBasedTest.class.getResourceAsStream("project.zip"), prj);
		loadData(data, prj);
		return prj;
	}
	
	/** 
	 * This long running method forces a full refresh of the project.
	 * 
	 * The project and all partitions are completely re-read from
	 * the filesystem and MOIN is in a clean state again.
	 * 
	 * @param project
	 */
	private void refreshProject(final IProject prj) {
	    
	    	Job refresh = new Job("Refresh project") {
		    @Override
		    protected IStatus run(IProgressMonitor monitor) {
		    	monitor.beginTask("Refresh Test Project from Filesystem", 20);
			try {
				prj.refreshLocal(IResource.DEPTH_INFINITE, new SubProgressMonitor(monitor, 10));
				// force a full refresh 
				ModelManager.getInstance().refreshFromFileSystem(mProject, new SubProgressMonitor(monitor, 10));
			} catch (CoreException e) {
				fail("Failed to refresh project");
			}
			monitor.done();
			return Status.OK_STATUS;
		    } 
	    	};
	    	refresh.schedule();
	    	try {
		    refresh.join();
		} catch (InterruptedException e) {
		    fail("Failed to refresh project");
		}
	}

	private void deleteProject() throws CoreException {
		if (mProject != null) {
			mProject.delete(true, true, null);
			mProject = null;
		}
	}
	
	private static void loadData(InputStream data, IProject project) throws IOException {
		String zipFilename = FileServices.getTempDir() + File.separator + "moin_sample_data.zip"; //$NON-NLS-1$
		FileServices.streamToFile(zipFilename, data); 
		
		// unzip into the project directory:
		String targetDirectory = project.getLocation().toOSString();
		ZipService.unzipDir(zipFilename, targetDirectory);
	}	
	
	public IProject getProject() {
		return mProject;
	}

	/** 
	 * Data for the desired project.
	 * Will be called before each testcase.
	 * 
	 * @return
	 */
	protected abstract InputStream getProjectContentAsStream();

	/** 
	 * Name of the desired project.
	 * Will be recreated upon each testcase.
	 * 
	 * @return
	 */
	protected abstract String getProjectName();
	
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
		final Connection[] con = new Connection[1];
		
		Job creator = new Job("Create Connection") {
		    @Override
		    protected IStatus run(IProgressMonitor monitor) {
			con[0] = ConnectionManager.getInstance().createConnection(getProject());
			return Status.OK_STATUS;
		    }
		};
		creator.schedule();
		try {
		    creator.join();
		} catch (InterruptedException e) {
		    fail(e.getMessage());
		}
	
		if (memoryChangesOnly) {
		    con[0].enableMemoryChangeOnly();
		}
		mConnections.add(con[0]);
		return con[0];
	}
	
	/**
	 * @return all connections that this test has created up to now
	 * 
	 * @see #createConnection()
	 */
	protected Set<Connection> getConnections() {
		return mConnections;
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
}
