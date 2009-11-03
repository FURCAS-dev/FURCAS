package com.sap.mi.fwk.dcfwk.internal.messages;

import org.eclipse.osgi.util.NLS;

/**
 * UI texts for plugin <code>com.sap.mi.fwk.dcfwk</code>
 *
 * @author d031150
 */
public final class DcFwkMessages extends NLS {

	private static final String BUNDLE_NAME = "com.sap.mi.fwk.dcfwk.internal.messages.messages"; //$NON-NLS-1$

	static {
		// initialize resource bundle
		initializeMessages(BUNDLE_NAME, DcFwkMessages.class);
	}

	public static String MoinProject_configuring;
	public static String MoinProject_deconfiguring;
	public static String MoinProject_deletingProject;

	public static String ProjPropPage_ButtonCreatePpComp_text;
	public static String ProjPropPage_ButtonCreatePpComp_tooltip;
	public static String ProjPropPage_ButtonCreatePpAssmbl_text;
	public static String ProjPropPage_ButtonCreatePpAssmbl_tooltip;
	public static String ProjPropPage_ButtonCreatePpInfra_text;
	public static String ProjPropPage_ButtonCreatePpInfra_tooltip;
	public static String ProjPropPage_Desc;
	public static String ProjPropPage_Title;

	public static String RepairDcAction_repairing;

	public static String Wizard_title;

	private DcFwkMessages() {
	}
}
