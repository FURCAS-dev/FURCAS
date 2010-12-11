package com.sap.furcas.parsergenerator.tcs.property;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.tcs.scenario.ClassLookupImpl;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.FeatureFixtureData;

/**
 * A test for the queryByIdentifier property argument, which can be used to
 * query for elements by an identifier.
 * 
 * @author Stephan Erb
 */
public class TestQueryByIdentifierPArg extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "EnumerationFeatureMapped";
    private static final File TCS = FeatureFixtureData.ENUM_FEATURE_TCS;
    private static final File METAMODEL = FeatureFixtureData.ENUM_FEATURE_METAMODEL;

    private static ParsingHelper parsingHelper;
    

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration mappedEnumTestConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODEL);
        TCSSyntaxContainerBean mappedEnumSyntaxBean = parseSyntax(mappedEnumTestConfig);
        ParserFacade facade = generateParserForLanguage(mappedEnumSyntaxBean, mappedEnumTestConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }
    
    @Test
    @Ignore
    public void testValidResolve() throws Exception {
        parsingHelper.parseFile("PropertyArgument_QueryByIdentifier_WellDefined.sam", FeatureFixtureData.EXAMPLE_FOLDER.getAbsolutePath());
    }
    
    @Test
    @Ignore
    public void testInValidResolve() throws Exception {
        parsingHelper.parseFile("PropertyArgument_QueryByIdentifier_UnDefined.sam", FeatureFixtureData.EXAMPLE_FOLDER.getAbsolutePath());
    }
    
}
