package org.eclipse.emf.query.index.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.emf.query.index.ui.messages"; //$NON-NLS-1$
	public static String Query2IndexUI_QueryIndexBuilder_IndexingResource;
	public static String QueryIndexUI_IndexFactory_ErrorIndexingURI;
	public static String QueryIndexUI_IndexFactory_TimeTakenToDump;
	public static String QueryIndexUI_IndexFactory_TimeTakenToLoad;

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
