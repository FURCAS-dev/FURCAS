package com.sap.ide.moftool.editor.gen.datatype.pages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.sap.ide.moftool.editor.gen.datatype.pages.messages"; //$NON-NLS-1$

	public static String StructureTypeConstraintsPage_Constraints;

	public static String EnumTypeTagsPage_Tags;

	public static String EnumTypeConstraintsPage_Constraints;

	public static String StructureTypeTagsPage_Tags;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
