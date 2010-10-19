package com.sap.mi.textual.test.scenarios;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.test.parsing.base.EcoreMetaModelLookUp;
import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.parsing.base.ParserGenerationTestHelper;

/**
 * Test using several (useless) layers of abstraction in the metamodel
 */
public class ExpressionAbstractTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "ExpressionAbstract";


	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("ExpressionAbstract.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	/**
	 * test syntax errors cause parsing errors
	 * @throws Exception
	 */
	@Test
	public void testSampleDirect() throws Exception {
	    parseString("trueS", LANGUAGE,  0);
	    parseString("\"someString\"", LANGUAGE,  0);
	    parseString("(trueS + falseS)", LANGUAGE,  0);
	    
	    parseString("trueS +", LANGUAGE,  1);
	}
	
}
