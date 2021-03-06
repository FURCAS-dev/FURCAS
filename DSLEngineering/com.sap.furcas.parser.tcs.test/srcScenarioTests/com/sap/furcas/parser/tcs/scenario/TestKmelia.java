package com.sap.furcas.parser.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.StringListHelper;

/**
 * Simple Test for the custom Expression language
 */
public class TestKmelia extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "Kmelia";
    private static final File TCS = ScenarioFixtureData.KMELIA_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.KMELIA_METAMODEL };
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
        parsingHelper.parseFile("KmeliaSample.sam", DSLSAMPLEDIR, 0, getKmeliaMetaConfiguredStubAdapter());

    }

    private StubModelAdapter getKmeliaMetaConfiguredStubAdapter() {
        StubModelAdapter adapter = new StubModelAdapter();
        // adding required superclass relationships to Stub
        adapter.supertypes.put("Kmelia::ExternalService", StringListHelper.list("Kmelia::Service"));
        adapter.supertypes.put("Kmelia::InternalService", StringListHelper.list("Kmelia::Service"));
        return adapter;
    }

}
