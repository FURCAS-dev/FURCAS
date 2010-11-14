package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Simple Test for the custom BibText language
 */
public class LexerMemberTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "LexerMember";
    private static final File TCS = FixtureData.LEXER_MEMBER_TCS;
    private static final File[] METAMODELS = { FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testbadKeyword() throws Exception {
        IModelAdapter modelAdapter = new StubModelAdapter();
        String sample = "test";
        ModelParsingResult result = parsingHelper.parseString(sample, modelAdapter);
        assertEquals(0, result.getErrors().size());

    }
}
