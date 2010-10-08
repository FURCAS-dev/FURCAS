package com.sap.mi.textual.test.scenarios;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.testutils.StringListHelper;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;
import com.sap.mi.textual.test.util.EcoreMetaLookUp;
import com.sap.mi.textual.test.util.StubModelAdapter;

/**
 * Simple Test for the custom Expression language
 */
public class ATLTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "ATL";

	
	// Problems with OperatorCalls
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaLookUp("ATL.ecore"));
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
