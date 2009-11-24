package com.sap.finex.interpreter;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;

import com.sap.runlet.abstractinterpreter.repository.Repository;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sap.finex.interpreter";

	// The shared instance
	private static Activator plugin;
	
	private final FinexModelAdapter modelAdapter;

	/**
	 * A default repository that others who use the interpreter plugin may use as a
	 * kind of "central database"
	 */
	private final Repository<Association, Field, FinexClass, Type, FinexClass> finexDataStore;
	
	/**
	 * The constructor
	 */
	public Activator() {
	    modelAdapter = new FinexModelAdapter();
	    finexDataStore = new FinexInMemoryRepository(getModelAdapter());
	}

	public FinexModelAdapter getModelAdapter() {
	    return modelAdapter;
	}

	public Repository<Association, Field, FinexClass, Type, FinexClass> getRunletDataStore() {
	    return finexDataStore;
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

}
