package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.test.fixture.FixtureData;
import com.sap.furcas.test.testutils.StringListHelper;

/**
 * Simple Test for the custom Expression language
 */
public class KM3Test extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "KM3";
    private static final File TCS = FixtureData.KM3_TCS;
    private static final File[] METAMODELS = { FixtureData.KM3_METAMODEL };
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
    public void testKM3Sample() throws Exception {

        StubModelAdapter stubModelHandler = getKM3MetaConfiguredStubAdapter();
        parsingHelper.parseFile("KM3.km3", DSLSAMPLEDIR, 0, stubModelHandler);
    }

    @Test
    public void testTCSSample() throws Exception {

        StubModelAdapter stubModelHandler = getKM3MetaConfiguredStubAdapter();
        parsingHelper.parseFile("TCS.km3", DSLSAMPLEDIR, 0, stubModelHandler);
    }

    @Test
    public void testATLSample() throws Exception {
        StubModelAdapter stubModelHandler = getKM3MetaConfiguredStubAdapter();
        parsingHelper.parseFile("ATL.km3", DSLSAMPLEDIR, 0, stubModelHandler);

    }

    private StubModelAdapter getKM3MetaConfiguredStubAdapter() {
        StubModelAdapter adapter = new StubModelAdapter();
        // adding required superclass relationships to Stub
        adapter.supertypes.put("KM3::Class", StringListHelper.list("KM3::Classifier"));
        adapter.supertypes.put("KM3::DataType", StringListHelper.list("KM3::Classifier"));
        adapter.supertypes.put("KM3::Enumeration", StringListHelper.list("KM3::Classifier"));
        return adapter;
    }
}
