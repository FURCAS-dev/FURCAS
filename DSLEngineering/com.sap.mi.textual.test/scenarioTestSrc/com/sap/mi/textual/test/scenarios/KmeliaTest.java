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
public class KmeliaTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "Kmelia";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaLookUp("Kmelia.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	@Test
	public void testSample1() throws Exception {
		parseFile("KmeliaSample.sam", LANGUAGE, DSLSAMPLEDIR, 0, getKmeliaMetaConfiguredStubAdapter());

	}
	
	   private StubModelAdapter getKmeliaMetaConfiguredStubAdapter() {
	        StubModelAdapter adapter = new StubModelAdapter();
	        // adding required superclass relationships to Stub
	        adapter.supertypes.put("Kmelia::ExternalService", StringListHelper.list("Kmelia::Service"));
	        adapter.supertypes.put("Kmelia::InternalService", StringListHelper.list("Kmelia::Service"));
	        return adapter;
	    }
	
}
