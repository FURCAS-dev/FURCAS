package com.sap.mi.textual.test.scenarios;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.util.EcoreMetaModelLookUp;
import com.sap.furcas.test.util.StubModelAdapter;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;

/**
 * Simple Test for the custom Expression language
 */
public class SQLDDLTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "SQLDDL";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("SQLDDL.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	@Test
	public void testSample1() throws Exception {
		
		StubModelAdapter stubModelHandler = parseFile("SQLDDLSample.sam", LANGUAGE, DSLSAMPLEDIR, 0);
		
	}
	
}