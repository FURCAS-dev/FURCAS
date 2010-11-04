package com.sap.furcas.parsergenerator.tcs.scenario;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.parsergenerator.emf.lookup.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.test.parsing.testutils.StringListHelper;

/**
 * Simple Test for the custom Expression language
 */
public class KmeliaTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "Kmelia";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new FileBasedEcoreMetaModelLookUp("Kmelia.ecore"));
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
