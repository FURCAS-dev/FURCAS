package org.eclipse.emf.query2;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	
	private static final String BUNDLE_NAME = "org.eclipse.emf.query2.messages"; //$NON-NLS-1$
	
	public static String IndexQueryService_EObjectWithoutInclusiveScope;
	public static String IndexQueryService_UnIdentifiableURI;
	public static String Query2Core_IndexQueryService_EObjectWithoutInclusiveScope;
	public static String Query2Core_IndexQueryService_UnIdentifiableClass;

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

	public static String getString(String key, String params[]) {
		try {
			String value = RESOURCE_BUNDLE.getString(key);
			if (value != null)
				value = NLS.bind(key, params);
			return value;
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
