package com.sap.runlet.interpreter.test;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.osgi.framework.BundleContext;



/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sap.runlet.interpreter.test";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	static IProject getStdlibProject() {
	    return getProject("ngpm.stdlib");
	}
	
	static IProject getProject(String projectName) {
	    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
	    	projectName);
	    return project;
	}

	static ResourceSet createConnection(final IProject project) {
	    final ResourceSet[] conn = new ResourceSet[1];
	    IRunnableWithProgress operation = new IRunnableWithProgress() {
	        public void run(IProgressMonitor monitor) {
	    	// non UI thread
	    	conn[0] = ConnectionManager.getInstance()
	    		.getOrCreateDefaultConnection(project);
	        }
	    };
	    IProgressService ps = PlatformUI.getWorkbench().getProgressService();
	    try {
	        ps.busyCursorWhile(operation);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	    return conn[0];
	}
	
	static ResourceSet createConnection(String projectName) {
	    return createConnection(getProject(projectName));
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
