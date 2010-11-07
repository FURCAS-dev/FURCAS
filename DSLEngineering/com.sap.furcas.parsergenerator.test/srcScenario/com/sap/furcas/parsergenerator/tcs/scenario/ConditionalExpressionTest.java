package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.GeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.GeneratedParserTestConfiguration;
import com.sap.furcas.parsergenerator.base.ParsingHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.parsergenerator.base.StubModelElement;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Simple Test for the custom Expression language that uses lots of conditionals.
 */
public class ConditionalExpressionTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "ExpressionConditional";
    private static final File TCS = FixtureData.EXPRESSION_CONDITIONAL_TCS;
    private static final File[] METAMODELS = { FixtureData.EXPRESSION_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ParserFacade facade = generateParserForLanguage(testConfig);
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testAcceptSamples() throws Exception {
        // samples don't make much sense unless you understand the templates of the syntax

        parsingHelper.parseString("fourty-two", 0);
        parsingHelper.parseString("noInt", 0);
        parsingHelper.parseString("-twelve", 0);
        parsingHelper.parseString("nothing", 0);
        parsingHelper.parseString("Hello", 0);
        parsingHelper.parseString("trueS", 0);
        parsingHelper.parseString("falseS", 0);
        parsingHelper.parseString("falseS, trueS, Hello, nothing, -twelve, fourty-two", 0);
    }

    @Test
    public void testIntValConditional() throws Exception {

        StubModelAdapter stubModelHandler = parsingHelper.parseString("fourty-two", 0);
        Set<StubModelElement> values = stubModelHandler.getElementsbyType("expression::ValueExpression");
        assertEquals(1, values.size());
        StubModelElement element = values.iterator().next();
        assertEquals(new Integer(42), element.get("value"));

        // in this case, we should still get a ValueExpression, but with value property not set
        stubModelHandler = parsingHelper.parseString("noInt", 0);
        values = stubModelHandler.getElementsbyType("expression::ValueExpression");
        assertEquals(1, values.size());
        element = values.iterator().next();
        assertEquals(null, element.get("value"));
    }

    @Test
    public void testNegIntValConditional() throws Exception {
        // here, 2 properties should be set in the then case, and one in the else case
        StubModelAdapter stubModelHandler = parsingHelper.parseString("-twelve", 0);
        Set<StubModelElement> values = stubModelHandler.getElementsbyType("expression::NegativeIntExpression");
        assertEquals(1, values.size());
        StubModelElement element = values.iterator().next();
        assertEquals(new Integer(12), element.get("value"));
        assertEquals(Boolean.TRUE, element.get("isNegative"));

        stubModelHandler = parsingHelper.parseString("nothing", 0);
        values = stubModelHandler.getElementsbyType("expression::NegativeIntExpression");
        assertEquals(1, values.size());
        element = values.iterator().next();
        assertEquals(Boolean.FALSE, element.get("isNegative"));
    }

    @Test
    public void testStringValConditional() throws Exception {

        StubModelAdapter stubModelHandler = parsingHelper.parseString("Hello", 0);
        Set<StubModelElement> values = stubModelHandler.getElementsbyType("expression::StringExpression");
        assertEquals(1, values.size());
        StubModelElement element = values.iterator().next();
        assertEquals("World", element.get("value"));

        // in this case, we should still get a StringExpression, but with value property not set
        stubModelHandler = parsingHelper.parseString("Bye", 0);
        values = stubModelHandler.getElementsbyType("expression::StringExpression");
        assertEquals(1, values.size());
        element = values.iterator().next();
        assertEquals(null, element.get("value"));
    }

    @Test
    public void testBoolConditional() throws Exception {

        StubModelAdapter stubModelHandler = parsingHelper.parseString("trueS", 0);
        Set<StubModelElement> values = stubModelHandler.getElementsbyType("expression::BooleanExpression");
        assertEquals(1, values.size());
        StubModelElement element = values.iterator().next();
        assertEquals(Boolean.TRUE, element.get("value"));

        // in this case, we should still get a BooleanExpression, but with value false
        stubModelHandler = parsingHelper.parseString("falseS", 0);
        values = stubModelHandler.getElementsbyType("expression::BooleanExpression");
        assertEquals(1, values.size());
        element = values.iterator().next();
        assertEquals(Boolean.FALSE, element.get("value"));
    }
}