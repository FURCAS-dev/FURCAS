package com.sap.furcas.parser.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

@Ignore("Already ignored in the moin codebase. Furthermore, not even included in the test suite.")
public class TestPartial extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "XPath";
    private static final File TCS = ScenarioFixtureData.XPATH_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.XPATH1_METAMODEL };
    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {
        parsingHelper.parseFile("XPathSample01.sam", DSLSAMPLEDIR, /*expected errors*/ 0);
        parsingHelper.parseFile("XPathSample02.sam", DSLSAMPLEDIR, /*expected errors*/ 0);
    }

}
