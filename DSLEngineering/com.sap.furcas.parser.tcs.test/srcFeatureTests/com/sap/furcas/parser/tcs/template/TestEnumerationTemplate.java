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
 * This class tests the TCS Enumeration feature.
 * 
 * @author Sebastian Schlag (D049672)
 *
 */
public class TestEnumerationTemplate extends GeneratedParserBasedTest {

    private static final String LANGUAGE_MAPPEDENUM = "EnumerationFeatureMapped";
    private static final String LANGUAGE_AUTOENUM = "EnumerationFeatureAuto";
    private static final File mappedEnumTCS = FeatureFixtureData.ENUM_FEATURE_TCS;
    private static final File autoEnumTCS = FeatureFixtureData.ENUM_FEATURE_AUTO_TCS;
    private static final File METAMODEL = FeatureFixtureData.ENUM_FEATURE_METAMODEL;

    private static StubParsingHelper mappedEnumParsingHelper;
    private static StubParsingHelper autoEnumParsingHelper;
    

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration mappedEnumTestConfig = new GeneratedParserTestConfiguration(LANGUAGE_MAPPEDENUM, mappedEnumTCS, METAMODEL);
        TCSSyntaxContainerBean mappedEnumSyntaxBean = parseSyntax(mappedEnumTestConfig);
        ParserFacade mappedEnumFacade = generateParserForLanguage(mappedEnumSyntaxBean, mappedEnumTestConfig, new ClassLookupImpl());
        mappedEnumParsingHelper = new StubParsingHelper(mappedEnumFacade);
        
        GeneratedParserTestConfiguration autoEnumTestConfig = new GeneratedParserTestConfiguration(LANGUAGE_AUTOENUM, autoEnumTCS, METAMODEL);
        TCSSyntaxContainerBean autoEnumSyntaxBean = parseSyntax(autoEnumTestConfig);
        ParserFacade autoEnumFacade = generateParserForLanguage(autoEnumSyntaxBean, autoEnumTestConfig, new ClassLookupImpl());
        autoEnumParsingHelper = new StubParsingHelper(autoEnumFacade);
        
    }
    
    /**
     * Enum literals defined in metamodel are "FOO" and "BAR".
     * Using the enumerationTemplate a different literal for "FOO" ("foobar") is defined.
     * Thus only "foobar" and "BAR" should be parsable.
     * @throws Exception
     */
    @Test
    public void testMappedEnum() throws Exception {

        mappedEnumParsingHelper.parseString("foobar",0);
        mappedEnumParsingHelper.parseString("BAR",0);
        
        mappedEnumParsingHelper.parseString("FOO", 1);
        mappedEnumParsingHelper.parseString("bar",1);
        
    }
    
    /**
     * This test is based on the same metamodel, but uses the auto keyword in TCS to make sure 
     * that the grammar considers all literals included in the metamodel.
     * Thus only "FOO" and "BAR" should be parsable.
     * @throws Exception
     */
    @Test
    public void testAutoEnum() throws Exception{
        
        autoEnumParsingHelper.parseString("FOO", 0);
        autoEnumParsingHelper.parseString("BAR", 0);
        
        autoEnumParsingHelper.parseString("foobar", 1);
        autoEnumParsingHelper.parseString("bar", 1);
    }

}
