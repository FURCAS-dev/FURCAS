package com.sap.furcas.parsergenerator.tcs.scenario;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.test.parsing.base.EcoreMetaModelLookUp;
import com.sap.furcas.test.parsing.base.ExtendedGeneratedParserBasedTest;
import com.sap.furcas.test.parsing.base.ParserGenerationTestHelper;

/**
 * Simple Test for the custom BibText language
 */
public class BibTextReferSubTypeTest extends ExtendedGeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "BibtextReferSubType";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new EcoreMetaModelLookUp("BibTextReferSubType.ecore",
				"BibText1.ecore"));
		generateParserForLanguage(LANGUAGE);
	}
	
	
	/**
     * tests metamodel upper and lower bounds are used and cause errors when violated
     * @throws Exception
     */
    @Test
    public void testSample() throws Exception {
        String sample = "";
  
        sample = "article{" + 
        "  Testing, \"John Doe\" : " + 
        "  year=\"2002\"" + 
        "}" + 
        "author = \"John Doe\"." 
        + "author = \"Jane Doll\"."
        ;

        parseString(sample, LANGUAGE, 0);
    }
}
