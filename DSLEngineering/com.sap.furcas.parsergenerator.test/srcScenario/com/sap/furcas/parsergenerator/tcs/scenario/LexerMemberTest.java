package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.parsergenerator.emf.lookup.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.test.scenario.FixtureData;

/**
 * Simple Test for the custom BibText language
 */
public class LexerMemberTest extends ExtendedGeneratedParserBasedTest {

	private static final String LANGUAGE = "LexerMember";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new FileBasedEcoreMetaModelLookUp(FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL));
		generateParserForLanguage(LANGUAGE);
	}
	
	    
	    @Test
	    public void testbadKeyword() throws Exception {
	        IModelAdapter modelAdapter = new StubModelAdapter();
	        String sample = "test";
	        ModelParsingResult result = parseString(sample, LANGUAGE, modelAdapter );
	        assertEquals(0, result.getErrors().size());

	    }
}
