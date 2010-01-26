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
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.junit.After;
import org.junit.Before;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sap.ide.cts.editor.CtsActivator;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.services.local.FileServices;
import com.sap.mi.fwk.services.local.ZipService;
import com.sap.tc.moin.globalmodellistener.GlobalEventListenerRegistry;
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
	
	private static final String MOIN_NATURE = "com.sap.mi.fwk.dcfwk.MoinNature";
	private static final String PLUGIN_NATURE = org.eclipse.pde.internal.core.natures.PDE.PLUGIN_NATURE;


	//@Override
	@Before
	public void setUp() throws CoreException, IOException {
		InputStream data = getProjectContentAsStream();
		mProject = createProjectWithData(getProjectName(), data);
		refreshProject(mProject);
	}

	//@Override
	@After
	public void tearDown() throws Exception {		
		closeConnections();
		mConnections.clear();
		deleteProject();
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
		IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				try {
					prj.refreshLocal(IResource.DEPTH_INFINITE, null);
					// force a full refresh 
					ModelManager.getInstance().refreshFromFileSystem(mProject, null);
				} catch (CoreException e) {
					fail("Failed to refresh project");
				}
			    }
			};
			IProgressService ps = PlatformUI.getWorkbench().getProgressService();
			try {
			    ps.busyCursorWhile(operation);
			} catch (Exception e) {
			    throw new RuntimeException(e);
			}
	}

	private void deleteProject() throws CoreException {
		// align MOIN DB to prevent testcases influencing each other 
		IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
			    // avoid that the many delete events that occur during deleting all partitions
			    // trigger the event listeners through the global event listener registry
			    getGlobalEventListenerRegistry().executeWithoutRegisteringListenersForNewSessions(new Runnable() {
				public void run() {
				    PartitionService.getInstance().deletePartitions(getProject(), null);
				}
			    });
			}

			private GlobalEventListenerRegistry getGlobalEventListenerRegistry() {
			    BundleContext context = CtsActivator.getDefault().getBundle().getBundleContext();
			    ServiceReference ref = context.getServiceReference(GlobalEventListenerRegistry.class.getName());
			    GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context.getService(ref);
			    return registry;
			}
		};
		IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		try {
			ps.busyCursorWhile(operation);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		if (mProject != null) {
			mProject.delete(true, true, null);
			mProject = null;
		}
	}
	
	private static void loadData(InputStream data, IProject project) throws IOException {
		String zipFilename = FileServices.getTempDir() + File.separator + "moin_sample_data.zip"; //$NON-NLS-1$
		FileServices.streamToFile(zipFilename, data); //$NON-NLS-1$
		
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
		IRunnableWithProgress operation = new IRunnableWithProgress() {
		    public void run(IProgressMonitor monitor) {
				con[0] = ConnectionManager.getInstance().createConnection(getProject());
		    }
		};
		IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		try {
		    ps.busyCursorWhile(operation);
		} catch (Exception e) {
		    throw new RuntimeException(e);
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
