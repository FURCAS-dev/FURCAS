package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Tests currently fail for unknown reason, maybe tcs syntax is corrupt
 */
public class XPathRedGenerationTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "XPathReduced";
    private static final File TCS = FixtureData.XPATH_REDUCED_TCS;
    private static final File[] METAMODELS = { FixtureData.XPATH_REDUCED_METAMODEL, FixtureData.XPATH_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ParserFacade facade = generateParserForLanguage(testConfig);
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {

        parsingHelper.parseString("$a=2*3", 0);

    }

}
