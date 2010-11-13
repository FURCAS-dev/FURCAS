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
import com.sap.furcas.test.parsing.testutils.StringListHelper;

/**
 * Simple Test for the custom Expression language
 */
public class KmeliaTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "Kmelia";
    private static final File TCS = FixtureData.KMELIA_TCS;
    private static final File[] METAMODELS = { FixtureData.KMELIA_METAMODEL };
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
