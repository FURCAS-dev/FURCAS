package com.sap.furcas.parser.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

/**
 * Test using several (useless) layers of abstraction in the metamodel
 */
public class TestExpressionAbstract extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "ExpressionAbstract";
    private static final File TCS = ScenarioFixtureData.EXPRESSION_ABSTRACT_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.EXPRESSION_ABSTRACT_METAMODEL };

    private static StubParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new StubParsingHelper(facade);
    }

    /**
     * test syntax errors cause parsing errors
     * 
     * @throws Exception
     */
    @Test
    public void testSampleDirect() throws Exception {
        parsingHelper.parseString("trueS", 0);
        parsingHelper.parseString("\"someString\"", 0);
        parsingHelper.parseString("(trueS + falseS)", 0);

        parsingHelper.parseString("trueS +", 1);
    }

}
