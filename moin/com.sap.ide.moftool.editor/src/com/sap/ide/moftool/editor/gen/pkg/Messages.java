package com.sap.ide.moftool.editor.gen.pkg;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.sap.ide.moftool.editor.gen.pkg.messages"; //$NON-NLS-1$

	public static String PackageEditor_Constants;

	public static String PackageEditor_Tags;

	public static String PackageEditor_Associations;

	public static String PackageEditor_Overview;

	public static String PackageEditor_Constraints;

	public static String PackageEditor_Imports;

	public static String PackageEditor_ErrorCreatingPage;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
