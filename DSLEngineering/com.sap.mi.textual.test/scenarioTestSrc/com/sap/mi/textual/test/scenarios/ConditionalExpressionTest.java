package com.sap.mi.textual.test.scenarios;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.parsing.base.StubModelElement;
import com.sap.furcas.test.util.EcoreMetaModelLookUp;
import com.sap.furcas.test.util.StubModelAdapter;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;

/**
 * Simple Test for the custom Expression language that uses lots of conditionals.
 */
public class ConditionalExpressionTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "ExpressionConditional";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("Expression.ecore"));
		generateParserForLanguage(LANGUAGE);
	}


	@Test
	public void testAcceptSamples() throws Exception {
	    // samples don't make much sense unless you understand the templates of the syntax
	    
	    parseString("fourty-two", LANGUAGE, 0);
	    parseString("noInt", LANGUAGE, 0);
	    parseString("-twelve", LANGUAGE, 0);
	    parseString("nothing", LANGUAGE, 0);
	    parseString("Hello", LANGUAGE, 0);
	    parseString("trueS", LANGUAGE, 0);
	    parseString("falseS", LANGUAGE, 0);
	    parseString("falseS, trueS, Hello, nothing, -twelve, fourty-two", LANGUAGE, 0);
	}
	
	@Test
    public void testIntValConditional() throws Exception {
        
	    StubModelAdapter stubModelHandler = parseString("fourty-two", LANGUAGE, 0);
        Set<StubModelElement> values = stubModelHandler.getElementsbyType("expression::ValueExpression");
        assertEquals(1, values.size());
        StubModelElement element = values.iterator().next();
        assertEquals(new Integer(42), element.get("value"));
        
        // in this case, we should still get a ValueExpression, but with value property not set
        stubModelHandler = parseString("noInt", LANGUAGE, 0);
        values = stubModelHandler.getElementsbyType("expression::ValueExpression");
        assertEquals(1, values.size());
        element = values.iterator().next();
        assertEquals(null, element.get("value"));
	}       
	
	   @Test
	    public void testNegIntValConditional() throws Exception {
	        // here, 2 properties should be set in the then case, and one in the else case
	        StubModelAdapter stubModelHandler = parseString("-twelve", LANGUAGE, 0);
	        Set<StubModelElement> values = stubModelHandler.getElementsbyType("expression::NegativeIntExpression");
	        assertEquals(1, values.size());
	        StubModelElement element = values.iterator().next();
	        assertEquals(new Integer(12), element.get("value"));
	        assertEquals(Boolean.TRUE, element.get("isNegative"));
	        

	        stubModelHandler = parseString("nothing", LANGUAGE, 0);
	        values = stubModelHandler.getElementsbyType("expression::NegativeIntExpression");
	        assertEquals(1, values.size());
	        element = values.iterator().next();
	        assertEquals(Boolean.FALSE, element.get("isNegative"));
	    }       
	
	@Test
    public void testStringValConditional() throws Exception {
        
        StubModelAdapter stubModelHandler = parseString("Hello", LANGUAGE, 0);
        Set<StubModelElement> values = stubModelHandler.getElementsbyType("expression::StringExpression");
        assertEquals(1, values.size());
        StubModelElement element = values.iterator().next();
        assertEquals("World", element.get("value"));
        
        // in this case, we should still get a StringExpression, but with value property not set
        stubModelHandler = parseString("Bye", LANGUAGE, 0);
        values = stubModelHandler.getElementsbyType("expression::StringExpression");
        assertEquals(1, values.size());
        element = values.iterator().next();
        assertEquals(null, element.get("value"));
    }  
	

    @Test
    public void testBoolConditional() throws Exception {
        
        StubModelAdapter stubModelHandler = parseString("trueS", LANGUAGE, 0);
        Set<StubModelElement> values = stubModelHandler.getElementsbyType("expression::BooleanExpression");
        assertEquals(1, values.size());
        StubModelElement element = values.iterator().next();
        assertEquals(Boolean.TRUE, element.get("value"));
        
        // in this case, we should still get a BooleanExpression, but with value false
        stubModelHandler = parseString("falseS", LANGUAGE, 0);
        values = stubModelHandler.getElementsbyType("expression::BooleanExpression");
        assertEquals(1, values.size());
        element = values.iterator().next();
        assertEquals(Boolean.FALSE, element.get("value"));
    }  
}