package org.eclipse.emf.query2;

import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	
	public static final String BUNDLE_NAME = "org.eclipse.emf.query2.messages"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	public static String IndexQueryService_EObjectWithoutInclusiveScope;
	public static String IndexQueryService_UnIdentifiableURI;
	public static String Query2Core_IndexQueryService_EObjectWithoutInclusiveScope;
	public static String Query2Core_IndexQueryService_UnIdentifiableClass;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

	public static String getString(String parameterizedString, String params[]) {
		return NLS.bind(parameterizedString, params);
	}

}
