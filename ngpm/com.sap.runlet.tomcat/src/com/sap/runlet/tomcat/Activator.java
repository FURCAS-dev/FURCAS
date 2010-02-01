package com.sap.runlet.tomcat;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.catalina.Context;
import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Embedded;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.ui.IStartup;
import org.osgi.framework.BundleContext;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.tc.moin.repository.Connection;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SapClass;
import data.classes.TypeDefinition;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin implements IStartup {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.runlet.tomcat";

    /**
     * The name of the top-level directory in a (target) workspace project that
     * contains a web application for deployment in Tomcat
     */
    private static final String WEBAPP_DIR_NAME = "war";

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
	super.start(context);
	plugin = this;
	startTomcat();
    }

    private void startTomcat() throws LifecycleException {
	final String SERVER_AND_ENGINE_NAME = "Runlet";
	IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
	IProject tomcatRoot = workspaceRoot.getProject("com.sap.runlet.tomcat");
	if (!tomcatRoot.getFolder("apache-tomcat-6.0.20").exists()) {
	    return;  // Tomcat not installed. Do nothing.
	}
	File CATALINAHOME = tomcatRoot.getFolder("apache-tomcat-6.0.20").getLocation().toFile();
	Embedded server = new Embedded();
	server.setName(SERVER_AND_ENGINE_NAME);
	server.setCatalinaHome(CATALINAHOME.getAbsolutePath());

	Engine engine = server.createEngine();
	engine.setName(SERVER_AND_ENGINE_NAME);
	engine.setDefaultHost("localhost");

	try {
	    Thread.sleep(2000);
	} catch (InterruptedException e) {
	}

	for (IFolder webappFolder : getWebappsInWorkspace()) {
	    File WEBAPPS = webappFolder.getLocation().toFile();
	    Host host = server.createHost("localhost", WEBAPPS.getAbsolutePath());
	    Context context = server.createContext("/runlet", WEBAPPS.getAbsolutePath()); //FIXME: context names must be unique!
	    context.setReloadable(true);
	    context.setParentClassLoader(Thread.currentThread().getContextClassLoader());
	    host.addChild(context);
	    engine.addChild(host);
	}
	server.addEngine(engine);
	Connector http = server.createConnector("localhost", 8282, false);
	server.addConnector(http);
	server.start();
    }

    private Collection<IFolder> getWebappsInWorkspace() {
	Collection<IFolder> result = new LinkedList<IFolder>();
	IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
	for (IProject project : workspaceRoot.getProjects()) {
	    IFolder webappFolder = project.getFolder(WEBAPP_DIR_NAME);
	    if (webappFolder.exists()) {
		result.add(webappFolder);
	    }
	}
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
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

    @Override
    public void earlyStartup() {
	// doesn't have to do anything; OSGi bundle will be started because this
	// class has to be loaded in order to do nothing here; this will then
	// pull
	// up Tomcat.
    }

    public Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> getRunletDataStore() {
	return com.sap.runlet.interpreter.Activator.getDefault().getRunletDataStore();
    }

    public static IProject getStdlibProject() {
	return getProject("ngpm.stdlib");
    }

    public static IProject getProject(String projectName) {
	IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
	return project;
    }

    public static Connection createConnection(final IProject project) {
	return ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
    }

    public static Connection createConnection(String projectName) {
	return createConnection(getProject(projectName));
    }

}
