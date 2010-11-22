package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Tests currently fail for unknown reason, maybe tcs syntax is corrupt
 */
public class XPathGenerationTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "XPath";
    private static final File TCS = FixtureData.XPATH_TCS;
    private static final File[] METAMODELS = { FixtureData.XPATH1_METAMODEL, FixtureData.XPATH_METAMODEL };
    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
    
    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBeanyntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBeanyntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {
        parsingHelper.parseFile("XPathSample01.sam", DSLSAMPLEDIR);
    }

    @Test
    public void testSample2() throws Exception {
        parsingHelper.parseFile("XPathSample02.sam", DSLSAMPLEDIR, 0);
    }
}
