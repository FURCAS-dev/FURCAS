package com.sap.furcas.parsergenerator.tcs.scenario;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.EcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;

/**
 * Tests currently fail for unknown reason, maybe tcs syntax is corrupt
 */
public class XPathGenerationTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "XPath";
	private static IMetaModelLookup lookup;

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("XPath1.ecore", "XPath.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	@Test
	public void testSample1() throws Exception {
		
		parseFile("XPathSample01.sam", LANGUAGE, DSLSAMPLEDIR);
		
	}
	
	@Test
	public void testSample2() throws Exception {
		
		parseFile("XPathSample02.sam", LANGUAGE, DSLSAMPLEDIR, 0);
		
	}
}