package com.sap.ide.moftool.editor.gen.datatype.enumeration;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.sap.ide.moftool.editor.gen.datatype.enumeration.messages"; //$NON-NLS-1$

	public static String EnumEditor_Labels;

	public static String EnumEditor_Overview;

	public static String EnumEditor_Constraints;

	public static String EnumEditor_Tags;

	public static String EnumEditor_ErrorCreatingPage;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
