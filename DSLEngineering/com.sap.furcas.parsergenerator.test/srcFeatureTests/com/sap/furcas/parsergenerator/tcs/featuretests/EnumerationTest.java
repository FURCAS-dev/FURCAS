package com.sap.furcas.parsergenerator.tcs.featuretests;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.tcs.scenario.ClassLookupImpl;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.FixtureData;

public class EnumerationTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "EnumerationFeature";
    private static final File TCS = FixtureData.ENUM_FEATURE_TCS;
    private static final File METAMODEL = FixtureData.ENUM_FEATURE_METAMODEL;

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODEL);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testEnum() throws Exception {

        parsingHelper.parseString("foobar",0);
        parsingHelper.parseString("BAR",0);
        
        parsingHelper.parseString("FOO", 1);
        parsingHelper.parseString("bar",1);
        
    }

}
