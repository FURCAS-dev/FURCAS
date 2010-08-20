package com.sap.runlet.interpreter.test;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
	    return getProject("de.hpi.sam.bp2009.solution.testutils");
	}
	
	static IProject getProject(String projectName) {
	    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
	    	projectName);
	    return project;
	}

	static ResourceSet createResourceSet(final IProject project) {
	    ResourceSet result = new ResourceSetImpl();
//	    result.getResources().add(result.createResource(
//	            URI.createURI("platform:/plugin/de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark/src/de/hpi/sam/bp2009/solution/impactAnalyzer/benchmark/preparation/notifications/fixtures/models/NgpmModel.xmi")));
	    return result;
	}
	
	static ResourceSet createConnection(String projectName) {
	    return createResourceSet(getProject(projectName));
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
