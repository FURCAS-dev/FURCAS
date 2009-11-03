package com.sap.ide.cts.editor.contentassist.processor;

import org.junit.BeforeClass;

public abstract class CtsContentAssistProcessorEditorTestMetamodelTestBase
		extends CtsContentAssistProcessorTestBase {

	@BeforeClass
	public static void initMetamodelId() {
		initMetamodelId("sap.com/moin/mm/editor.test.metamodel");
	}
}
