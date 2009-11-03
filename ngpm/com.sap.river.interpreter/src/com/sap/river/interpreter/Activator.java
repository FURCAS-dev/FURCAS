package com.sap.river.interpreter;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.sap.river.interpreter.repository.Repository;
import com.sap.river.interpreter.repository.simpleimpl.InMemoryRepository;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sap.river.interpreter";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * A default repository that others who use the interpreter plugin may use as a
	 * kind of "central database"
	 */
	private Repository runletDataStore;
	
	/**
	 * The method call resolved used by the {@link RiverInterpreter interpreter} to dynamically
	 * resolve polymorphic method calls. Put here during plugin extension initialization because
	 * the {@link MethodCallResolver} acts as a global model listener and is therefore initialized
	 * when the repository comes up.
	 */
	private MethodCallResolver methodCallResolver;
	
	public MethodCallResolver getMethodCallResolver() {
	    return methodCallResolver;
	}

	/**
	 * The constructor
	 */
	public Activator() {
	    runletDataStore = new InMemoryRepository();
	    methodCallResolver = new MethodCallResolver();
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

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	public Repository getRunletDataStore() {
	    return runletDataStore;
	}

}
