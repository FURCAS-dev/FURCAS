package com.sap.furcas.parsergenerator.tcs.scenario;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.GeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.parsergenerator.emf.lookup.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.test.fixture.FixtureData;


/**
 * Simple Test for the custom Expression language
 */
public class LOTOSTest extends GeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "LOTOS";


	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new FileBasedEcoreMetaModelLookUp(FixtureData.LOTOS_METAMODEL));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	@Test
	public void testSample1() throws Exception {
		
		StubModelAdapter stubModelHandler = parseFile("LOTOSSample.sam", LANGUAGE, DSLSAMPLEDIR, 0);
		
	}
	
}
