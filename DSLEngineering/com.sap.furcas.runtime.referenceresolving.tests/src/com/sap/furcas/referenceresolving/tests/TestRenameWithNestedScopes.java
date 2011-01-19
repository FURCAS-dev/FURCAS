package com.sap.furcas.referenceresolving.tests;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.EMFParsingHelper;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.test.fixture.FeatureFixtureData;

/**
 * Tests NestedScopes TCS and metamodel, which will be used to test impact analysis
 * behavior on renames.
 *  
 * @author Sebastian Schlag (D049672)
 *
 */

public class TestRenameWithNestedScopes  extends GeneratedParserBasedTest{
    
    private static final String LANGUAGE = "ImpactAnalysisRenameTestSyntax";
    private static final File TCS = FeatureFixtureData.NESTED_SCOPES_TCS;
    private static final File METAMODEL = FeatureFixtureData.NESTED_SCOPES_METAMODEL;
    private static final String PACKAGE_URI = FeatureFixtureData.NESTED_SCOPES_PACKAGE_URI;
    
    private static EMFParsingHelper parsingHelper;
    
    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODEL);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new EMFParsingHelper(facade, testConfig, PACKAGE_URI);
    }
    
    
    /**
     * All queries used to bind a usage to its corresponding definition should succeed.  
     */
    @Test
    public void testResolvableBindings() throws Exception {
        ModelParsingResult result = parsingHelper.parseFile("NestedScopes.sam", FeatureFixtureData.EXAMPLE_FOLDER,
                /* expected errors */ 0);
        
        //TODO: Make sure all references have been resolved as expected

    }

}
