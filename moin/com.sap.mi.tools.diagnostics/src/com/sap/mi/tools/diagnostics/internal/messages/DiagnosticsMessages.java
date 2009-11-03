package com.sap.mi.tools.diagnostics.internal.messages;

import org.eclipse.osgi.util.NLS;

public final class DiagnosticsMessages extends NLS {
	
	private static final String BUNDLE_NAME = "com.sap.mi.tools.diagnostics.internal.messages.messages"; //$NON-NLS-1$
	
	public static String CloseConnectionAction_closeDialog_text;
	public static String CloseConnectionAction_closeDialog_title;
	public static String CloseConnectionAction_dirtyDialog_text;
	public static String CloseConnectionAction_dirtyDialog_title;
	
	public static String ConnectionNode_closed_label;
	
	public static String ConnectionsNode_connections_label;
	public static String ConnectionsNode_emptyConnections_label;
	
	public static String DoubleClick_noJmxDialog_text;
	public static String DoubleClick_noJmxDialog_title;
	
	public static String NoJmxNode_jmxNotAvailable_label;
	
	public static String MoinNode_moin_label;
	
	public static String PartitionNode_nullPartition_label;
	
	public static String EditorRegistryNode_label;
	
	public static String MoinBeanPropertySource_startedAt_label;
	public static String MoinBeanPropertySource_uptime_label;
	public static String MoinBeanPropertySource_host_label;
	public static String MoinBeanPropertySource_version_label;
	
	public static String MoinVersionPropertySource_comment_label;
	public static String MoinVersionPropertySource_date_label;
	public static String MoinVersionPropertySource_number_label;
	
	public static String PartitionableNodePropertySource_attributes_label;
	public static String PartitionableNodePropertySource_mofId_label;
	public static String PartitionableNodePropertySource_mri_label;
	public static String PartitionableNodePropertySource_type_label;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DiagnosticsMessages.class);
	}

	private DiagnosticsMessages() {
	}
}
