package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.ResourceTestHelper;

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

    private static ParsingHelper parsingHelper;
    private static EPackage rootPackage;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
        rootPackage = findPackage("expression", testConfig.getSourceConfiguration().getResourceSet());
    }

    @Test
    public void testSimpleCaluclations() throws Exception {
        assertEquals(1, calculate("1"));
        assertEquals(2, calculate("1+1"));
        assertEquals(6, calculate("1+2+3"));

        assertEquals(25, calculate("5*5"));
        assertEquals(27, calculate("3*3*3"));
    }
    
    @Test
    @Ignore("Fails for unknown reasons")
    public void testNegation() throws Exception {
        assertEquals(-2, calculate("-1*2"));
        assertEquals(1, calculate("--1"));
    }
    
    @Test
    public void testParentheses() throws Exception {
        assertEquals(1, calculate("(1)"));
        assertEquals(2, calculate("(1+1)"));
        assertEquals(6, calculate("1+(2+3)"));
    } 
    
    @Test
    public void testPreceedence() throws Exception {
        assertEquals(7, calculate("1+2*3"));

        assertEquals(9, calculate("(1+2)*3"));
        assertEquals(7, calculate("1+(2*3)"));
    }
    
    private int calculate(String expressionToCalculate) throws Exception {
        IModelAdapter modelAdapter = createNewEMFModelAdapter();
        ModelParsingResult result = parsingHelper.parseString(expressionToCalculate, modelAdapter);
        EObject exprStatement = (EObject) result.getParsedModelElement();
        
        EObject expression = (EObject) exprStatement.eGet(exprStatement.eClass().getEStructuralFeature("expression"));
        return (Integer) expression.eGet(expression.eClass().getEStructuralFeature("calculatedValue"));
    }
    
    private IModelAdapter createNewEMFModelAdapter() {
        return new DefaultTextAwareModelAdapter(
                new EMFModelAdapter(rootPackage, ResourceTestHelper.createResourceSet(), Collections.singleton(rootPackage.eResource().getURI())));
    }
    
    /**
     * Finds an EPackage in the {@link #resourceSet} by the <code>name</code> specified 
     */
    private static EPackage findPackage(String name, ResourceSet resourceSet) {
        for (Resource r : resourceSet.getResources()) {
            for (EObject c : r.getContents()) {
                if (c instanceof EPackage && ((EPackage) c).getName().equals(name)) {
                    return (EPackage) c;
                }
            }
        }
        return null;
    }
}
