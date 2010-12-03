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
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.StringListHelper;

/**
 * Simple Test for the custom Expression language
 */
public class ATLTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "ATL";
    private static final File TCS = ScenarioFixtureData.ATL_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.ATL_METAMODEL };
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
    @Ignore("Already broken in the moin codebase. Was not even included in the test suite.")
    public void testSample1() throws Exception {
        StubModelAdapter stubModelHandler = getATLMetaConfiguredStubAdapter();
        parsingHelper.parseFile("ATLSample.sam", DSLSAMPLEDIR, 0, stubModelHandler);
    }

    private StubModelAdapter getATLMetaConfiguredStubAdapter() {
        StubModelAdapter adapter = new StubModelAdapter();
        // adding required superclass relationships to Stub
        adapter.supertypes.put("ATL::MatchedRule", StringListHelper.list("ATL::Rule"));
        adapter.supertypes.put("ATL::CalledRule", StringListHelper.list("ATL::Rule"));
        adapter.supertypes.put("ATL::LazyMatchedRule", StringListHelper.list("ATL::MatchedRule"));

        return adapter;
    }

}
