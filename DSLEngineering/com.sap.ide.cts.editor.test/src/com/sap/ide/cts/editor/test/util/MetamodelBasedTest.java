package com.sap.ide.cts.editor.test.util;

import com.sap.furcas.test.base.StandaloneConnectionBasedTest;

public class MetamodelBasedTest extends StandaloneConnectionBasedTest {

	protected static String metamodelId;

	public static void initMetamodelId(String metamodelId) {
		MetamodelBasedTest.metamodelId = metamodelId;
	}

}
