package com.sap.furcas.parsergenerator.tcs.scenario;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.GeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.emf.lookup.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Tests currently fail for unknown reason, maybe tcs syntax is corrupt
 */
public class XPathRedGenerationTest extends GeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "XPathReduced";
	private static IMetaModelLookup lookup;

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new FileBasedEcoreMetaModelLookUp(FixtureData.XPATH_REDUCED_METAMODEL, FixtureData.XPATH_METAMODEL));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	@Test
	public void testSample1() throws Exception {
		
		parseString("$a=2*3", LANGUAGE, 0);
		
	}

}
