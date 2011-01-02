package com.sap.furcas.parser.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

/**
 * Simple Test for the a custom language having a metamodel with several subpackages and classnames that are not unique (only
 * unique within package)
 */
public class TestMultiPackage extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "MultiPackage";
    private static final File TCS = ScenarioFixtureData.MULTIPACKAGE_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.MULTIPACKAGE_METAMODEL };
    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";

    private static StubParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new StubParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {

        StubModelAdapter stubModelHandler = parsingHelper.parseFile("ExpressionSample01.sam", DSLSAMPLEDIR, 0);
        Collection<?> values = stubModelHandler.getElementsOfType("expression::rightPackage::ExpressionList");
        assertNotNull(values);
        assertEquals(1, values.size());

        values = stubModelHandler.getElementsOfType("expression::rightPackage::BinaryExpression");
        assertNotNull(values);
        assertEquals(6, values.size());

        values = stubModelHandler.getElementsOfType("expression::rightPackage::ValueExpression");
        assertNotNull(values);
        assertEquals(9, values.size());
    }

    @Test
    public void testSample2() throws Exception {

        parsingHelper.parseFile("ExpressionSample02.sam", DSLSAMPLEDIR, 1);

    }

    @Test
    public void testSampleDirect() throws Exception {

        parsingHelper.parseString("1+1+2", 0);

        parsingHelper.parseString("1+1+", 1);
        parsingHelper.parseString("1+1+a", 1);
        parsingHelper.parseString("1+1+b, 2+c", 2);

    }
}
