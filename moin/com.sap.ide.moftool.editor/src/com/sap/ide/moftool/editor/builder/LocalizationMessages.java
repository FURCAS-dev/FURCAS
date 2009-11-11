package com.sap.ide.moftool.editor.builder;

import org.eclipse.osgi.util.NLS;

public class LocalizationMessages extends NLS {
	private static final String BUNDLE_NAME = "com.sap.ide.moftool.editor.builder.messages"; //$NON-NLS-1$
	public static String MOFQuickfix_0_XMSG;
	public static String MOFQuickfix_1_XMSG;
	public static String MOFQuickfix_2_XMSG;
	public static String MOFQuickfix_3_XMSG;
	public static String MOFQuickfix_5_XMSG;
	public static String MOFQuickfix_errorMsg;
	public static String MOFQuickfix_errorTitle;
	public static String MOFQuickfix_gettingConnection;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, LocalizationMessages.class);
	}

	private LocalizationMessages() {
	}
}
