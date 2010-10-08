package com.sap.mi.textual.test.scenarios;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;
import com.sap.mi.textual.test.util.EcoreMetaLookUp;
import com.sap.mi.textual.test.util.StringListHelper;
import com.sap.mi.textual.test.util.StubModelAdapter;

/**
 * Simple Test for the custom Expression language
 */
public class KM3Test extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "KM3";

	 // because of operatorCalls (maybe nonPrimary?)
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaLookUp("KM3.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	@Test
	public void testKM3Sample() throws Exception {
		
		StubModelAdapter stubModelHandler = getKM3MetaConfiguredStubAdapter();
		parseFile("KM3.km3", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
	}
	
	@Test
    public void testTCSSample() throws Exception {
        
        StubModelAdapter stubModelHandler = getKM3MetaConfiguredStubAdapter();
        parseFile("TCS.km3", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);
    }
	
	@Test
    public void testATLSample() throws Exception {
        StubModelAdapter stubModelHandler = getKM3MetaConfiguredStubAdapter();
        parseFile("ATL.km3", LANGUAGE, DSLSAMPLEDIR, 0, stubModelHandler);

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
