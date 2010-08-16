package com.sap.runlet.interpreter;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;
import com.sap.runlet.interpreter.repository.simpleimpl.RunletInMemoryRepository;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SapClass;
import data.classes.TypeDefinition;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sap.runlet.interpreter";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * A default repository that others who use the interpreter plugin may use as a
	 * kind of "central database"
	 */
	private Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> runletDataStore;
	
	/**
	 * The method call resolved used by the {@link RunletInterpreter interpreter} to dynamically
	 * resolve polymorphic method calls. Put here during plugin extension initialization because
	 * the {@link MethodCallResolver} acts as a global model listener and is therefore initialized
	 * when the repository comes up.
	 */
	private final MethodCallResolver methodCallResolver;
	
	private final ModelAdapter<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> modelAdapter;
	
	public ModelAdapter<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> getModelAdapter() {
	    return modelAdapter;
	}

	/**
	 * The constructor
	 */
	public Activator() {
	    modelAdapter = new RunletModelAdapter();
	    runletDataStore = new RunletInMemoryRepository(getModelAdapter());
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
	
	public Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> getRunletDataStore() {
	    return runletDataStore;
	}

	public MethodCallResolver getMethodCallResolver() {
	    return methodCallResolver;
	}

}
