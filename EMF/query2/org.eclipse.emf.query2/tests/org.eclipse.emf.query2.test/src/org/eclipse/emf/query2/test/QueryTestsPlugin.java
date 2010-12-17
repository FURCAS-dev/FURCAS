package org.eclipse.emf.query2.test;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;


public class QueryTestsPlugin extends Plugin {
	
	private static QueryTestsPlugin plugin;
	
	public static final String PLUGIN_ID = "org.eclipse.emf.query.index.ui";

	
	public static QueryTestsPlugin getPluginInstance(){
		return plugin;
	}
	
	
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		super.start(context);
		plugin = this;
	}
	
	
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

}
