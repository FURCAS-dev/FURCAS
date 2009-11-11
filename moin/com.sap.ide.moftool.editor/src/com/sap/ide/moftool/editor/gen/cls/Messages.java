package com.sap.ide.moftool.editor.gen.cls;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.sap.ide.moftool.editor.gen.cls.messages"; //$NON-NLS-1$

	public static String ClassEditor_References;

	public static String ClassEditor_Tags;

	public static String ClassEditor_Operations;

	public static String ClassEditor_Overview;

	public static String ClassEditor_Attributes;

	public static String ClassEditor_Constraints;

	public static String ClassEditor_Constants;

	public static String ClassEditor_InnerDataTypes;

	public static String ClassEditor_Exceptions;

	public static String ClassEditor_ErrorCreatingPage;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
