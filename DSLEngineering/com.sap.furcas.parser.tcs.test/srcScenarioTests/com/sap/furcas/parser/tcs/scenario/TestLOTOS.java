package com.sap.furcas.parser.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

/**
 * Simple Test for the custom Expression language
 */
public class TestLOTOS extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "LOTOS";
    private static final File TCS = ScenarioFixtureData.LOTOS_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.LOTOS_METAMODEL };
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
        parsingHelper.parseFile("LOTOSSample.sam", DSLSAMPLEDIR, 0);
    }

}
