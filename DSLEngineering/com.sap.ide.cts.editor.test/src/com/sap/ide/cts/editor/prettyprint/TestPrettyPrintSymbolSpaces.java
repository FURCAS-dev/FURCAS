package com.sap.ide.cts.editor.prettyprint;

import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;

public class TestPrettyPrintSymbolSpaces extends CtsPrettyPrinterTestBase {

	@Before
	public void init() {
		initMetamodelId("demo.sap.com/tcsmeta");
		initSyntax("SymbolSpaces", CtsPrettyPrinterTestBase.class
				.getResourceAsStream("fixtures/syntax/SymbolSpaces.tcs"));
	}

	@Test
	public void testCombinations() throws SyntaxAndModelMismatchException {
		ConcreteSyntax s = modelFactory.createConcreteSyntax();
		s.setName("name");

		String output = TcsPrettyPrinterTestHelper.prettyPrintString(s, syntax);
		assertOutput(output, "Combinations");
	}

}
