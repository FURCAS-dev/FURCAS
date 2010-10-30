package com.sap.furcas.parsergenerator.tcs.scenario;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.EcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;

/**
 * Simple Test for the custom BibText language, using the lower and upper bounds for entries in the metamodel.
 */
public class BibTextLowerUpperBoundsTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "BibtextUpperLower";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("BibTextUpperLower.ecore",
				"BibText1.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	/**
	 * tests metamodel upper and lower bounds are used and cause errors when violated
	 * @throws Exception
	 */
	@Test
    public void testBoundedEntries() throws Exception {
	    // this specific metamodel variant requires 2-4 entries in the sample
	    String sample = "";
	    parseString(sample, LANGUAGE, 1);
	    
	    sample ="author = \"Jane Doll\".";
	    
	    // expect one error
	    parseString(sample, LANGUAGE, 1);

	    sample = "author = \"Jane Doll\"." +
	    "author = \"John Doe\"." ;

//	    expect one error
	    parseString(sample, LANGUAGE, 0);

	  
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
	    
	    sample = "author = \"John Doe\"."
	        + "author = \"Jane Doll\"."
	        + "author = \"Jim Jones\"."
	        + "author = \"Tom Dooley\".";

	        parseString(sample, LANGUAGE, 0);

	        sample = "article{" + 
	        "  Testing, \"John Doe\"," + 
	        "  year = \"2002\"" + 
	        "}" + 
	        "author = \"John Doe\"." 
	        + "author = \"Jim Jones\"."
	        + "author = \"Jane Doll\"."
	        ;

	        parseString(sample, LANGUAGE, 0);
	        
	        // now expect errors because upper bound has been breached

	        sample = "author = \"John Doe\"."
	            + "author = \"Jane Doll\"."
	            + "author = \"Jim Jones\"."
	            + "author = \"Will Bright\"."
	            + "author = \"Tom Dooley\".";

	            parseString(sample, LANGUAGE, 1);

	            sample = "article{" + 
	            "  Testing, \"John Doe\"," + 
	            "  year = \"2002\"" + 
	            "}" + 
	            "author = \"John Doe\"." 
	            + "author = \"Jim Jones\"."
	            + "author = \"Will Bright\"."
	            + "author = \"Jane Doll\"."
	            ;

	            parseString(sample, LANGUAGE, 1);

	}

}
