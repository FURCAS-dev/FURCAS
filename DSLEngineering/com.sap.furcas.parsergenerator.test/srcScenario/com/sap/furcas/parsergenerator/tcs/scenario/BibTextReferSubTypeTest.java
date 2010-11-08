package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.fixture.FixtureData;



/**
 * Simple Test for the custom BibText language
 */
public class BibTextReferSubTypeTest extends GeneratedParserBasedTest {


    private static final String LANGUAGE = "BibtextReferSubType";
    private static final File TCS = FixtureData.BIBTEXT_REFER_SUBTYPE_TCS;
    private static final File[] METAMODELS = { FixtureData.BIBTEXT_REFER_SUBTYPE_METAMODEL,  FixtureData.BIBTEXT1_METAMODEL };
    
    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ParserFacade facade = generateParserForLanguage(testConfig);
        parsingHelper = new ParsingHelper(facade);
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

        parsingHelper.parseString(sample, 0);
    }
}
