package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;



/**
 * Simple Test for the custom BibText language
 */
public class BibTextReferSubTypeTest extends GeneratedParserBasedTest {


    private static final String LANGUAGE = "BibtextReferSubType";
    private static final File TCS = ScenarioFixtureData.BIBTEXT_REFER_SUBTYPE_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_REFER_SUBTYPE_METAMODEL,  ScenarioFixtureData.BIBTEXT1_METAMODEL };
    
    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
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
