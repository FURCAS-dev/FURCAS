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
import com.sap.furcas.test.fixture.FeatureFixtureData;
import com.sap.furcas.unparser.testutils.PrettyPrintAssertionUtil;
import com.sap.furcas.unparser.testutils.PrettyPrintTestHelper;


/**
 * A testcase based on {@linkplain TestSynthesizedAttributeGrammar} asserting that the pretty printer
 * can serialize OperatorTemplates. 
 * 
 * @author Stephan Erb
 * 
 */
public class TestPrimitiveTemplate extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "PrimitiveTemplate";
    private static final File TCS = FeatureFixtureData.PRIMITIVE_TEMPLATE_TCS;
    private static final File[] METAMODELS = { FeatureFixtureData.PRIMITIVE_TEMPLATE_METAMODEL };
    private static final String PACKAGE_URI = FeatureFixtureData.PRIMITIVE_PACKAGE_URI;

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
    public void testParseAndReprint() throws Exception {
        reprintAndAssertIsEqual("1 2 0.333 foo \"bar\"");
    }
            
    private void reprintAndAssertIsEqual(String text) throws IOException, UnknownProductionRuleException, SyntaxAndModelMismatchException {
        String printed = parseAndReprintString(text);
        PrettyPrintAssertionUtil.assertEqualsIgnoreWhitespaces(text, printed);
    }
        
    private String parseAndReprintString(String text) throws IOException, UnknownProductionRuleException, SyntaxAndModelMismatchException {
        ModelParsingResult result = parsingHelper.parseString(text, /*expected errors*/ 0);
        String printed = PrettyPrintTestHelper.prettyPrintString((EObject) result.getParsedModelElement(), syntax);
        return printed;
    }
    
}
