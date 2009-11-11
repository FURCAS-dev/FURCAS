package com.sap.ide.moftool.editor.gen.cls.pages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.sap.ide.moftool.editor.gen.cls.pages.messages"; //$NON-NLS-1$

	public static String ClassOperationsPage_Operations;

	public static String ClassAttributesPage_Attributes;

	public static String ClassExceptionsPage_Exceptions;

	public static String ClassInnerDataTypesPage_InnerDataTypes;

	public static String ClassConstraintsPage_Constraints;

	public static String ClassReferencesPage_References;

	public static String ClassTagsPage_Tags;

	public static String ClassConstantsPage_Constants;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
