package com.sap.mi.textual.test.scenarios;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.util.EcoreMetaModelLookUp;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;

/**
 * Tests currently fail for unknown reason, maybe tcs syntax is corrupt
 */
public class XPathRedGenerationTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "XPathReduced";
	private static IMetaModelLookup lookup;

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("XPathReduced.ecore", "XPath.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	@Test
	public void testSample1() throws Exception {
		
		parseString("$a=2*3", LANGUAGE, 0);
		
	}

}