package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.base.StubModelAdapter;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Simple Test for the custom Expression language
 */
public class LOTOSTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "LOTOS";
    private static final File TCS = FixtureData.LOTOS_TCS;
    private static final File[] METAMODELS = { FixtureData.LOTOS_METAMODEL };
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

        StubModelAdapter stubModelHandler = parsingHelper.parseFile("LOTOSSample.sam", DSLSAMPLEDIR, 0);

    }

}
