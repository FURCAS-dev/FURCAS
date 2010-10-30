package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.EcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.base.StubModelAdapter;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;

/**
 * Simple Test for the custom BibText language
 */
public class LexerMemberTest extends ExtendedGeneratedParserBasedTest {

	private static final String LANGUAGE = "LexerMember";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("BibText.ecore", "BibText1.ecore"));
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
