package com.sap.ide.moftool.editor.gen.datatype.structuretype;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.sap.ide.moftool.editor.gen.datatype.structuretype.messages"; //$NON-NLS-1$

	public static String StructureTypeEditor_Tags;

	public static String StructureTypeEditor_Fields;

	public static String StructureTypeEditor_Overview;

	public static String StructureTypeEditor_Constraints;

	public static String StructureTypeEditor_ErrorCreatingPage;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
