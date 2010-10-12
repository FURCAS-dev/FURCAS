package com.sap.mi.textual.test.scenarios;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.util.EcoreMetaModelLookUp;
import com.sap.furcas.test.util.StubModelAdapter;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;

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
