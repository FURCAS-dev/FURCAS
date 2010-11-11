package com.sap.ide.cts.editor.prettyprint;

import org.junit.Before;
import org.junit.Test;

import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;

import structure.FinexClass;
import finex.FinexPackage;

public class TestPrettyPrintBug2091 extends CtsPrettyPrinterTestBase {

	public static String language = "Bug2091";

	@Before
	public void init() {
		initMetamodelId("sap.com/finex/metamodel");
		initSyntax(language, CtsPrettyPrinterTestBase.class
				.getResourceAsStream("fixtures/syntax/" + language + ".tcs"));
	}

	@Test
	public void emptyClass() throws SyntaxAndModelMismatchException {
		FinexPackage finexPackage = connection
				.getPackage(FinexPackage.PACKAGE_DESCRIPTOR);

		FinexClass fc = (FinexClass) finexPackage.getStructure()
				.getFinexClass().refCreateInstance();
		fc.setValueType(true);
		fc.setName("TestClass");

		String output = TcsPrettyPrinterTestHelper
				.prettyPrintString(fc, syntax);
		assertOutput(output, "emptyClass");
	}

}
