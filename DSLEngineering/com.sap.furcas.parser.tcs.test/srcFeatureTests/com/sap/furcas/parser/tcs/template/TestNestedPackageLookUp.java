package com.sap.furcas.parser.tcs.template;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parser.tcs.scenario.ClassLookupImpl;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.FeatureFixtureData;

/**
 * This class tests the lookup of nested EPackages within templates.
 * 
 * @author Thomas Goldschmidt
 *
 */
public class TestNestedPackageLookUp extends GeneratedParserBasedTest {

    private static final String LANGUAGE_NESTEDPACKAGE = "NestedPackageLookUp";
    private static final File nestedPackageLookupTCS = FeatureFixtureData.NESTED_PACKAGE_TCS;
    private static final File METAMODEL = FeatureFixtureData.NESTED_PACKAGE_METAMODEL;

    private static StubParsingHelper nestedPackageLookupHelper;
    

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration nestedPackageLookupTestConfig = new GeneratedParserTestConfiguration(LANGUAGE_NESTEDPACKAGE, nestedPackageLookupTCS, METAMODEL);
        TCSSyntaxContainerBean nestedPackageLookupSyntaxBean = parseSyntax(nestedPackageLookupTestConfig);
        ParserFacade nestedPackageLookupFacade = generateParserForLanguage(nestedPackageLookupSyntaxBean, nestedPackageLookupTestConfig, new ClassLookupImpl());
        nestedPackageLookupHelper = new StubParsingHelper(nestedPackageLookupFacade);             
    }
    
  
    @Test
    public void testMappedEnum() throws Exception {
        nestedPackageLookupHelper.parseString("rootTest nestedTest");
        
    }
    
}
