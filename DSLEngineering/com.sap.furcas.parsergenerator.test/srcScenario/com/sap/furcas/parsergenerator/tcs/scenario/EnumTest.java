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
public class EnumTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "EnumTest";
    private static final File TCS = FixtureData.ENUMTEST_TCS;
    private static final File[] METAMODELS = { FixtureData.ENUMERATION_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ParserFacade facade = generateParserForLanguage(testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    /**
     * test syntax errors cause parsing errors
     * 
     * @throws Exception
     */
    @Test
    public void testSampleDirect() throws Exception {

        StubModelAdapter stubModelHandler = parsingHelper.parseString("mars with speed slow", 0);

        Set<StubModelElement> expressions = stubModelHandler.getElementsbyType("enumtest::PlanetExpression");
        assertEquals(1, expressions.size());
        StubModelElement element = expressions.iterator().next();
        StubModelElement planet = (StubModelElement) element.get("planet");
        assertEquals("mars", planet.type);
        StubModelElement speed = (StubModelElement) element.get("speed");
        assertEquals("slow", speed.type);
    }
}