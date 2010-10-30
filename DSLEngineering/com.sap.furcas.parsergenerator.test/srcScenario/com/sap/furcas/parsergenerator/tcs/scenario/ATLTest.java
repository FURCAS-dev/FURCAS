package com.sap.furcas.parsergenerator.tcs.scenario;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.EcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.test.parsing.testutils.StringListHelper;

/**
 * Simple Test for the custom Expression language
 */
@Ignore("Already broken in the moin codebase")
public class ATLTest extends ExtendedGeneratedParserBasedTest {

    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
    private static final String LANGUAGE = "ATL";

    // Problems with OperatorCalls
    @BeforeClass
    public static void setupParser() throws Exception {
        setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
        setLookup(new EcoreMetaModelLookUp("ATL.ecore"));
        generateParserForLanguage(LANGUAGE);
    }

    @Test
    public void testSample1() throws Exception {

        StubModelAdapter stubModelHandler = getATLMetaConfiguredStubAdapter();
        parseFile("ATLSample.sam", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);

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
