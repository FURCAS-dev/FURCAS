package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Test using several (useless) layers of abstraction in the metamodel
 */
public class ExpressionAbstractTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "ExpressionAbstract";
    private static final File TCS = FixtureData.EXPRESSION_ABSTRACT_TCS;
    private static final File[] METAMODELS = { FixtureData.EXPRESSION_ABSTRACT_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean containerBean = parseSyntax(testConfig, testConfig.getSyntaxDefinitionFile());
        ParserFacade facade = generateParserForLanguage(testConfig, new ClassLookupImpl(), containerBean);
        parsingHelper = new ParsingHelper(facade);
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
