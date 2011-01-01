package com.sap.furcas.unparser;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.unparser.testutils.PrettyPrintAssertionUtil;
import com.sap.furcas.unparser.testutils.PrettyPrintTestHelper;
import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;


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

    private static ParsingHelper parsingHelper;
    
    private static EPackage rootPackage;
    private static Set<URI> referenceScope;
    private static ResourceSet resourceSet;
    private static ConcreteSyntax syntax;


    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        syntax = syntaxBean.getSyntax();
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
        rootPackage = findPackage("expression", testConfig.getSourceConfiguration().getResourceSet());
        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        referenceScope = testConfig.getSourceConfiguration().getReferenceScope();
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
    
    private String parseAndReprintString(String text) throws IOException, UnknownProductionRuleException,
            SyntaxAndModelMismatchException {
        IModelAdapter modelAdapter = createNewEMFModelAdapter();
        ModelParsingResult result = parsingHelper.parseString(text, /*expected errors*/ 0, modelAdapter);
        String printed = PrettyPrintTestHelper.prettyPrintString((EObject) result.getParsedModelElement(), syntax);
        return printed;
    }
    
    
    private IModelAdapter createNewEMFModelAdapter() {
        return new DefaultTextAwareModelAdapter(new EMFModelAdapter(rootPackage, resourceSet, referenceScope));
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
