package com.sap.furcas.unparser;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.testbase.EMFParsingHelper;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.unparser.testutils.PrettyPrintAssertionUtil;
import com.sap.furcas.unparser.testutils.PrettyPrintTestHelper;


/**
 * A testcase based on {@linkplain TestSynthesizedAttributeGrammar} asserting that the pretty printer
 * can serialize OperatorTemplates. 
 * 
 * @author Stephan Erb
 * 
 */
public class TestOperatorTemplate extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "ExpressionWithSynthesizedAttributes";
    private static final File TCS = ScenarioFixtureData.EXPRESSION_WITH_SYNTHESIZED_ATTRIBUTE_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.EXPRESSION_WITH_SYNTHESIZED_ATTRIBUTE_METAMODEL };
    private static final String PACKAGE_URI = ScenarioFixtureData.EXPRESSION_WITH_SYNTHESIZED_ATTRIBUTE_METAMODEL_PACKAGE_URI;

    private static EMFParsingHelper parsingHelper;
    private static ConcreteSyntax syntax;


    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        syntax = syntaxBean.getSyntax();
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new EMFParsingHelper(facade, testConfig, PACKAGE_URI);
    }

    @Test
    public void testSimple() throws Exception {
        reprintAndAssertIsEqual("1+2+3+4+5");
        reprintAndAssertIsEqual("3*3*3");
    }
    
    @Test
    public void testParentheses() throws Exception {
        // These parentheses are optional. The pretty printer cannot know that he should print them.
        reprintAndAssertIsEqualTo("(1)", "1");
        reprintAndAssertIsEqualTo("(1+1)", "1+1");
        reprintAndAssertIsEqualTo("(((1)))", "1");
    }
    
    @Test
    public void testPreceedence() throws Exception {
        reprintAndAssertIsEqual("1+2*3");
        reprintAndAssertIsEqual("2*10+2*-5+-10");
        
        // These parentheses are optional. The pretty printer cannot know that he should print them.
        reprintAndAssertIsEqualTo("1+(2*3)", "1+2*3");
        reprintAndAssertIsEqualTo("((2*10)+(2*(-5)))+-10", "2*10+2*-5+-10");

        // These parenthesis are required. Otherwise a different result would be calculated.
        reprintAndAssertIsEqual("(1+2)*3");
        reprintAndAssertIsEqual("2*(10+2)*(-5+-10)");
    }
        
    private void reprintAndAssertIsEqual(String text) throws IOException, UnknownProductionRuleException, SyntaxAndModelMismatchException {
        String printed = parseAndReprintString(text);
        PrettyPrintAssertionUtil.assertEqualsIgnoreWhitespaces(text, printed);
    }
    
    private void reprintAndAssertIsEqualTo(String text, String expectedResult) throws IOException, UnknownProductionRuleException, SyntaxAndModelMismatchException {
        String printed = parseAndReprintString(text);
        PrettyPrintAssertionUtil.assertEqualsIgnoreWhitespaces(expectedResult, printed);
    }
    
    private String parseAndReprintString(String text) throws IOException, UnknownProductionRuleException, SyntaxAndModelMismatchException {
        ModelParsingResult result = parsingHelper.parseString(text, /*expected errors*/ 0);
        String printed = PrettyPrintTestHelper.prettyPrintString((EObject) result.getParsedModelElement(), syntax);
        return printed;
    }
    
}
