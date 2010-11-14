package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.test.fixture.FixtureData;

@Ignore("Already ignored in the moin codebase. Furthermore, not even included in the test suite.")
public class PartialTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "XPath";
    private static final File TCS = FixtureData.XPATH_TCS;
    private static final File[] METAMODELS = { FixtureData.XPATH1_METAMODEL };
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
        StubModelAdapter stubModelHandler = parsingHelper.parseFile("XPathSample01.sam", DSLSAMPLEDIR);
        stubModelHandler = parsingHelper.parseFile("XPathSample02.sam", DSLSAMPLEDIR, 0);
    }

}
