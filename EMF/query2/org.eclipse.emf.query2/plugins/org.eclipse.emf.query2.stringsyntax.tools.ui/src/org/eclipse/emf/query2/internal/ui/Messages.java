package org.eclipse.emf.query2.internal.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	public static final String BUNDLE_NAME = "org.eclipse.emf.query2.internal.ui.messages"; //$NON-NLS-1$
	public static String Query2StringSyntaxToolsUI_QueryResultView_Search;
	public static String Query2StringSyntaxToolsUI_QueryResultView_StatusLabelText;
	
	public static String Query2StringSyntaxToolsUI_RunQuery_OpeningResultView;
	public static String Query2StringSyntaxToolsUI_RunQuery_RunningQuery;
	public static String Query2StringSyntaxToolsUI_RunQuery_UpdateQueryView;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
	
	public static String getString(String parameterizedString, String params[]) {
		return NLS.bind(parameterizedString, params);
	}
}
