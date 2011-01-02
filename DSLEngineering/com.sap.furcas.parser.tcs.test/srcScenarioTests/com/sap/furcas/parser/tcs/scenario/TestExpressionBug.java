package com.sap.furcas.parser.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelElement;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

/**
 * Simple Test for the custom Expression language
 */
public class TestExpressionBug extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "PrimTempBug";
    private static final File TCS = ScenarioFixtureData.PRIM_TEMP_BUG_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.EXPRESSION_METAMODEL };

    private static StubParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new StubParsingHelper(facade);
    }

    @Test
    public void testSampleDirect() throws Exception {
        StubModelAdapter handler = parsingHelper.parseString("2+2", 0);
        Collection<StubModelElement> list = handler.getElementsOfType("expression::ValueExpression");
        for (StubModelElement element : list) {
            assertEquals(new Integer(2), element.get("value"));
        }

    }
}
