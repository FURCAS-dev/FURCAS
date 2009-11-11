package com.sap.ide.moftool.editor.gen.pkg.pages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.sap.ide.moftool.editor.gen.pkg.pages.messages"; //$NON-NLS-1$

	public static String PackageTagsPage_Tags;

	public static String PackageConstantsPage_Constants;

	public static String PackageImportsPage_Imports;

	public static String PackageConstraintsPage_Constraints;

	public static String PackageAssociationsPage_Associations;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
