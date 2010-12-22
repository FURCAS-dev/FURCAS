package org.eclipse.emf.query2.internal.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.emf.query2.internal.ui.messages"; //$NON-NLS-1$
	public static String Query2StringSyntaxToolsUI_QueryResultView_Search;
	public static String Query2StringSyntaxToolsUI_QueryResultView_StatusLabelText;
	
	public static String Query2StringSyntaxToolsUI_RunQuery_OpeningResultView;
	public static String Query2StringSyntaxToolsUI_RunQuery_RunningQuery;
	public static String Query2StringSyntaxToolsUI_RunQuery_UpdateQueryView;
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
	
	public static String getString(String key, String params[]) {
		try {
			String value = RESOURCE_BUNDLE.getString(key);
			if(value!=null)
			value = NLS.bind(key,params);
				return value;
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
