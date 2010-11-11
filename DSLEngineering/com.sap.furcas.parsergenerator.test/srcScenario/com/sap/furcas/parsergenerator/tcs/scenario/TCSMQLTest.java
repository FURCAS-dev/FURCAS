package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.base.StubModelAdapter;
import com.sap.furcas.test.base.StubModelElement;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Tests generation of TCS Parsers using metamodel in MOIN.
 */
@Ignore("Already ignored in the moin codebase")
public class TCSMQLTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "TCSMQLTest";
    private static final File TCS = FixtureData.TCS_MQL_TEST_TCS;
    private static final File[] METAMODELS = { FixtureData.TCS_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig, testConfig.getSyntaxDefinitionFile());
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {
        // using old obsolete TCS syntax
        String sample = "syntax mySyntax {\n" + "  primitiveTemplate identifier for String default using NAME:\n"
                + "        value = \"%token%\";\n" + "  template ->ExpressionList main operatored (myOperators)\n"
                + "    : elements{separator=\",\"}\n" + "    ;\n" + " operatorTemplate ->BinaryExpression(operators =\r\n"
                + "            opPlus, source = \'left\', storeRightTo = \'right\');" + "    \n" + "operators myOperators{\n"
                + "        priority 0 {\n" + "            opPlus = \"+\", 2;\n" + "        }\n" + "    }\n" + "}";

        // now test the mql query, requires new parsing
        StubModelAdapter stubModelHandler = new StubModelAdapter();
        Object expected = new Object();
        stubModelHandler.queryResult = expected;

        ModelParsingResult result = parsingHelper.parseString(sample, stubModelHandler);
        assertEquals(result.getErrors().toString(), 0, result.getErrors().size());

        StubModelElement ct = stubModelHandler.getElementsbyType("TCS::ClassTemplate").iterator().next();
        assertEquals(expected, ct.get("operatorList"));

        assertEquals("test 'my' query", stubModelHandler.oclQuery);
    }

}
