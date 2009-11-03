package com.sap.mi.tools.mmbuilder.internal;

import org.eclipse.osgi.util.NLS;

/**
 * Text accessor for plugin <code>com.sap.mi.fwk.ui</code>
 * 
 * @author d024127
 */
public final class MMBuilderMessages extends NLS {

	private static final String BUNDLE_NAME = "com.sap.mi.tools.mmbuilder.internal.messages"; //$NON-NLS-1$

	public static String AddNatureHandler_errorMsg;

	public static String AddNatureHandler_errorTitle;

	public static String AddNatureHandler_no_dc;

	public static String AddNatureHandler_no_selection;

	public static String AddNatureHandler_SelectMetamodel;
	public static String AddNatureHandler_SelMetamodelText;

	public static String ConvertXMI_ErrorMsg;
	public static String ConvertXMI_ErrorTitle;
	public static String ConvertXMI_WarningMsg;
	public static String ConvertXMI_convertingFiles;
	public static String ConvertXMI_convertProj;
	public static String ConvertXMI_gettingFiles;

	public static String ConvertXMI_refreshing;

	public static String ConvertXMIHandler_checkoutErrMsg;

	public static String MB_Cleaning;
	public static String MB_Creating;
	public static String MB_Refreshing;
	public static String MB_Scanning;

	public static String selectionDialog_Message;
	public static String selectionDialog_Text;

	public static String RemoveNatureHandler_project;
	public static String RemoveNatureHandler_removing;

	public static String RemoveNatureHandler_errorMsg;
	public static String RemoveNatureHandler_errorTitle;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, MMBuilderMessages.class);
	}

	private MMBuilderMessages() {
	}
}
