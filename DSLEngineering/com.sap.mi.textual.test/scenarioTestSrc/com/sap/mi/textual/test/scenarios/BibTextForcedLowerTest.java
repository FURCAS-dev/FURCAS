package com.sap.mi.textual.test.scenarios;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;
import com.sap.mi.textual.test.util.EcoreMetaLookUp;

/**
 * Simple Test for the custom BibText language, using the ForcedLower property arg.
 */
public class BibTextForcedLowerTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "BibtextForcedLower";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaLookUp( "BibText.ecore", "BibText1.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	/**
	 * Tests references are set, this protects against bugs relating to naming of classes.
	 * @throws Exception
	 */
	@Test
    public void testForcedLower() throws Exception {
	    // this specific syntax variant requires at least 3 entries in the sample
	    String sample = "article{" + 
	    		"  Testing, \"John Doe\"," + 
	    		"  year = \"2002\"" + 
	    		"}" + 
	    		"author = \"John Doe\"." 
	    		;
	    
	    // expect one error
	    parseString(sample, LANGUAGE, 1);

	    sample = "author = \"Jane Doll\"." +
	    "author = \"John Doe\"." ;

//	    expect one error
	    parseString(sample, LANGUAGE, 1);

	    sample = "author = \"John Doe\"." ;

//	    expect one error
	    parseString(sample, LANGUAGE, 1);

	    // expect no errors

	    sample = "author = \"John Doe\"."
	    + "author = \"Jane Doll\"."
	    + "author = \"Tom Dooley\".";

	    parseString(sample, LANGUAGE, 0);

	    sample = "article{" + 
	    "  Testing, \"John Doe\"," + 
	    "  year = \"2002\"" + 
	    "}" + 
	    "author = \"John Doe\"." 
	    + "author = \"Jane Doll\"."
	    ;

	    parseString(sample, LANGUAGE, 0);

	}

}