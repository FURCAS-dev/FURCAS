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
public class ExpressionBugTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "PrimTempBug";
    private static final File TCS = FixtureData.PRIM_TEMP_BUG_TCS;
    private static final File[] METAMODELS = { FixtureData.EXPRESSION_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ParserFacade facade = generateParserForLanguage(testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testSampleDirect() throws Exception {

        StubModelAdapter handler = parsingHelper.parseString("2+2", 0);
        Set list = handler.getElementsbyType("expression::ValueExpression");
        for (Object object : list) {
            StubModelElement element = (StubModelElement) object;
            assertEquals(new Integer(2), element.get("value"));
        }

    }
}
