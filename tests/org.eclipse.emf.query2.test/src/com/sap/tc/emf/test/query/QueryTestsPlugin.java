package com.sap.tc.emf.test.query;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;


public class QueryTestsPlugin extends Plugin {
	
	private static QueryTestsPlugin plugin;
	
	public static final String PLUGIN_ID = "org.eclipse.emf.query.index.ui";

	
	public static QueryTestsPlugin getPluginInstance(){
		return plugin;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		super.start(context);
		plugin = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

}
