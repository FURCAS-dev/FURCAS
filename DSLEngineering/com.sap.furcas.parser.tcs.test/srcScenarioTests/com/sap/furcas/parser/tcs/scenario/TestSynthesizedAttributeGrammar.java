package com.sap.furcas.parser.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.EMFParsingHelper;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

/**
 * A simple expression language with a built-in calculator.
 * 
 * Introductory courses to attribute grammars often feature
 * the idea of an expression language that is evaluated
 * during parsing. The evaluation is performed bottom-up and
 * solely based on synthesized attributes.
 *
 * The same is realized here with the help of OCL and property-inits.
 * After parsing, the "calculatedValue" property holds the value of
 * an (sub)-expression
 * 
 * TODO: Refactoring required. This class duplicates code (e.g. findPackage)
 * 
 * @author Stephan Erb
 * 
 */
public class TestSynthesizedAttributeGrammar extends GeneratedParserBasedTest {
    
    private static final String LANGUAGE = "ExpressionWithSynthesizedAttributes";
    private static final File TCS = ScenarioFixtureData.EXPRESSION_WITH_SYNTHESIZED_ATTRIBUTE_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.EXPRESSION_WITH_SYNTHESIZED_ATTRIBUTE_METAMODEL };
    private static final String PACKAGE_URI = ScenarioFixtureData.EXPRESSION_WITH_SYNTHESIZED_ATTRIBUTE_METAMODEL_PACKAGE_URI;
    
    private static EMFParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new EMFParsingHelper(facade, testConfig, PACKAGE_URI);
    }

    @Test
    public void testSimpleCaluclations() throws Exception {
        assertEquals(1, calculate("1"));
        assertEquals(2, calculate("1+1"));
        assertEquals(15, calculate("1+2+3+4+5"));

        assertEquals(25, calculate("5*5"));
        assertEquals(27, calculate("3*3*3"));
    }
    
    @Test
    public void testParentheses() throws Exception {
        assertEquals(1, calculate("(1)"));
        assertEquals(2, calculate("(1+1)"));
        assertEquals(6, calculate("1+(2+3)"));
        
        assertEquals(1, calculate("(((1)))"));
    } 
    
    @Test
    public void testNegation() throws Exception {
        assertEquals(-1, calculate("-1"));
        assertEquals(-2, calculate("-1*2"));
        assertEquals(2, calculate("-1*-2"));

        assertEquals(-10, calculate("2*-5"));
        assertEquals(-10, calculate("-2*5"));
        
        assertEquals(1, calculate("-(-1)"));
    }
    
    @Test
    @Ignore("Fails for unknown reasons")
    public void testDoubleNegation() throws Exception {
        assertEquals(1, calculate("-(-1)"));
        assertEquals(1, calculate("--1"));
    }
    
    @Test
    public void testPreceedenceSimple() throws Exception {
        assertEquals(9, calculate("(1+2)*3"));
        assertEquals(7, calculate("1+(2*3)"));
        
        assertEquals(7, calculate("1+2*3"));
    }
    
    @Test
    public void testPreceedenceComplex() throws Exception {
        // Test indivudually
        assertEquals(20, calculate("2*10"));
        assertEquals(-10, calculate("2*-5"));
        assertEquals(0, calculate("10+-10"));
        
        // Test in total
        assertEquals(0, calculate("2*10+2*-5+-10"));
    }

    private int calculate(String expressionToCalculate) throws Exception {
        ModelParsingResult result = parsingHelper.parseString(expressionToCalculate, /*expected errors*/ 0);
        EObject exprStatement = (EObject) result.getParsedModelElement();
        
        EObject expression = (EObject) exprStatement.eGet(exprStatement.eClass().getEStructuralFeature("expression"));
        return (Integer) expression.eGet(expression.eClass().getEStructuralFeature("calculatedValue"));
    }
    
}
