package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.parsergenerator.base.StubModelElement;
import com.sap.furcas.parsergenerator.emf.lookup.FileBasedEcoreMetaModelLookUp;

/**
 * Simple Test for the custom Expression language
 */
public class ExpressionBugTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "PrimTempBug";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new FileBasedEcoreMetaModelLookUp("Expression.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	   @Test
	    public void testSampleDirect() throws Exception {
	        
	        StubModelAdapter handler = parseString("2+2", LANGUAGE,  0);
	        Set list = handler.getElementsbyType("expression::ValueExpression");
	        for (Object object : list) {
	            StubModelElement element = (StubModelElement) object;
	            assertEquals(new Integer(2), element.get("value"));
	        }
	        
	    }
}
