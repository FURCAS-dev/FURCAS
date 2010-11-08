package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.base.StubModelAdapter;
import com.sap.furcas.test.base.StubModelElement;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Simple Test for the custom Expression language
 */
public class ExpressionTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "Expression";
    private static final File TCS = FixtureData.EXPRESSION_TCS;
    private static final File[] METAMODELS = { FixtureData.EXPRESSION_METAMODEL };
    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ParserFacade facade = generateParserForLanguage(testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {

        StubModelAdapter stubModelHandler = parsingHelper.parseFile("ExpressionSample01.sam", DSLSAMPLEDIR, 0);
        Set<StubModelElement> values = stubModelHandler.getElementsbyType("expression::ExpressionList");
        assertEquals(1, values.size());

        values = stubModelHandler.getElementsbyType("expression::BinaryExpression");
        assertEquals(6, values.size());

        values = stubModelHandler.getElementsbyType("expression::ValueExpression");
        assertEquals(9, values.size());
    }

    @Test
    public void testSample2() throws Exception {

        parsingHelper.parseFile("ExpressionSample02.sam", DSLSAMPLEDIR, 1);

    }

    /**
     * test syntax errors cause parsing errors
     * 
     * @throws Exception
     */
    @Test
    public void testSampleDirect() throws Exception {

        parsingHelper.parseString("1+1+2", 0);

        parsingHelper.parseString("1+1+", 1);
        parsingHelper.parseString("1+1+a", 1);
        parsingHelper.parseString("1+1+b, 2+c", 2);

    }
}
