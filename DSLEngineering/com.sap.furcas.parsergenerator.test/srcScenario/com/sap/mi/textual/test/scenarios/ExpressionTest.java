package com.sap.mi.textual.test.scenarios;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.test.parsing.base.EcoreMetaModelLookUp;
import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.parsing.base.ParserGenerationTestHelper;
import com.sap.furcas.test.parsing.base.StubModelAdapter;
import com.sap.furcas.test.parsing.base.StubModelElement;


/**
 * Simple Test for the custom Expression language
 */
public class ExpressionTest extends ExtendedGeneratedParserBasedTest {

	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "Expression";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("Expression.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	@Test
	public void testSample1() throws Exception {
		
		StubModelAdapter stubModelHandler = parseFile("ExpressionSample01.sam", LANGUAGE, DSLSAMPLEDIR, 0);
		Set<StubModelElement> values = stubModelHandler.getElementsbyType("expression::ExpressionList");
        assertEquals(1, values.size());
        
		values = stubModelHandler.getElementsbyType("expression::BinaryExpression");
        assertEquals(6, values.size());
        
		values = stubModelHandler.getElementsbyType("expression::ValueExpression");
		assertEquals(9, values.size());
	}
	
	@Test
	public void testSample2() throws Exception {

	    parseFile("ExpressionSample02.sam", LANGUAGE, DSLSAMPLEDIR, 1);

	}

	/**
	 * test syntax errors cause parsing errors
	 * @throws Exception
	 */
	@Test
	public void testSampleDirect() throws Exception {

	    parseString("1+1+2", LANGUAGE,  0);

	    parseString("1+1+", LANGUAGE,  1);
	    parseString("1+1+a", LANGUAGE,  1);
	    parseString("1+1+b, 2+c", LANGUAGE,  2);


	}
}