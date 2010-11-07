package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.GeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.GeneratedParserTestConfiguration;
import com.sap.furcas.parsergenerator.base.ParsingHelper;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Simple Test for the custom BibText language, using the lower and upper bounds for entries in the metamodel.
 */
public class BibTextLowerUpperBoundsTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "BibtextUpperLower";
    private static final File TCS = FixtureData.BIBTEXT_UPPER_LOWER_TCS;
    private static final File[] METAMODELS = { FixtureData.BIBTEXT_UPPER_LOWER_METAMODEL, FixtureData.BIBTEXT1_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ParserFacade facade = generateParserForLanguage(testConfig);
        parsingHelper = new ParsingHelper(facade);
    }

    /**
     * tests metamodel upper and lower bounds are used and cause errors when violated
     * 
     * @throws Exception
     */
    @Test
    public void testBoundedEntries() throws Exception {
        // this specific metamodel variant requires 2-4 entries in the sample
        String sample = "";
        parsingHelper.parseString(sample, 1);

        sample = "author = \"Jane Doll\".";

        // expect one error
        parsingHelper.parseString(sample, 1);

        sample = "author = \"Jane Doll\"." + "author = \"John Doe\".";

        // expect one error
        parsingHelper.parseString(sample, 0);

        // expect no errors

	    sample = "author = \"John Doe\"."
	    + "author = \"Jane Doll\"."
	    + "author = \"Tom Dooley\".";

	    parsingHelper.parseString(sample, 0);

	    sample = "article{" + 
	    "  Testing, \"John Doe\"," + 
	    "  year = \"2002\"" + 
	    "}" + 
	    "author = \"John Doe\"." 
	    + "author = \"Jane Doll\"."
	    ;

	    parsingHelper.parseString(sample, 0);
	    
	    sample = "author = \"John Doe\"."
	        + "author = \"Jane Doll\"."
	        + "author = \"Jim Jones\"."
	        + "author = \"Tom Dooley\".";

	    parsingHelper.parseString(sample, 0);

	        sample = "article{" + 
	        "  Testing, \"John Doe\"," + 
	        "  year = \"2002\"" + 
	        "}" + 
	        "author = \"John Doe\"." 
	        + "author = \"Jim Jones\"."
	        + "author = \"Jane Doll\"."
	        ;

	        parsingHelper.parseString(sample, 0);
	        
	        // now expect errors because upper bound has been breached

	        sample = "author = \"John Doe\"."
	            + "author = \"Jane Doll\"."
	            + "author = \"Jim Jones\"."
	            + "author = \"Will Bright\"."
	            + "author = \"Tom Dooley\".";

        parsingHelper.parseString(sample, 1);

	            sample = "article{" + 
	            "  Testing, \"John Doe\"," + 
	            "  year = \"2002\"" + 
	            "}" + 
	            "author = \"John Doe\"." 
	            + "author = \"Jim Jones\"."
	            + "author = \"Will Bright\"."
	            + "author = \"Jane Doll\"."
	            ;

	            parsingHelper.parseString(sample, 1);

	}

}
