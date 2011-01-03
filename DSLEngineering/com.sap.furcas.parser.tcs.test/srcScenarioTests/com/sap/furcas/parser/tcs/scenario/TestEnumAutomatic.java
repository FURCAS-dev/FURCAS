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
public class TestEnumAutomatic extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "EnumTestAutomatic";
    private static final File TCS = ScenarioFixtureData.ENUMTEST_AUTOMATIC_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.ENUMERATION_METAMODEL };

    private static StubParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new StubParsingHelper(facade);
    }

    /**
     * test syntax errors cause parsing errors
     * 
     * @throws Exception
     */
    @Test
    public void testSampleDirect() throws Exception {

        StubModelAdapter stubModelHandler = parsingHelper.parseString("mars with speed slow", 0);

        Collection<StubModelElement> expressions = stubModelHandler.getElementsOfType("enumtest::PlanetExpression");
        assertEquals(1, expressions.size());
        StubModelElement element = expressions.iterator().next();
        StubModelElement planet = (StubModelElement) element.get("planet");
        assertEquals("mars", planet.type);
        StubModelElement speed = (StubModelElement) element.get("speed");
        assertEquals("slow", speed.type);
    }
}
