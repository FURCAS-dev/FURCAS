package com.sap.mi.tools.mmdeploy.internal.messages;

import org.eclipse.osgi.util.NLS;

/**
 * UI text accessor for plugin <code>com.sap.mi.tools.mmdeployment</code>
 * 
 * @author d031150
 */
public final class MmDeploymentMessages extends NLS {

	private static final String BUNDLE_NAME = "com.sap.mi.tools.mmdeploy.internal.messages.messages"; //$NON-NLS-1$

	public static String view_column_containerName;
	public static String view_column_label;
	public static String view_column_plugin;
	public static String view_column_status;
	public static String view_column_version;
	
	public static String contentProvider_loading;
	public static String contentProvider_updating;
	
	public static String labelProvider_loading;
	
	public static String plugin_imageAcc_workingSet;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, MmDeploymentMessages.class);
	}

	private MmDeploymentMessages() {
	}
}
