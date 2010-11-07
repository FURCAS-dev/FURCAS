package com.sap.furcas.parsergenerator.tcs.scenario;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.base.GeneratedParserBasedTest;
import com.sap.furcas.parsergenerator.base.ParserGenerationTestHelper;
import com.sap.furcas.parsergenerator.emf.lookup.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.test.fixture.FixtureData;



/**
 * Simple Test for the custom BibText language
 */
public class BibTextReferSubTypeTest extends GeneratedParserBasedTest {


	private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
	private static final String LANGUAGE = "BibtextReferSubType";

	
	@BeforeClass
	public static void setupParser() throws Exception {
		setParserGenerationTestHelper(ParserGenerationTestHelper.getDefault());
		setLookup(new FileBasedEcoreMetaModelLookUp(FixtureData.BIBTEXT_REFER_SUBTYPE_METAMODEL,
		        FixtureData.BIBTEXT1_METAMODEL));
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
