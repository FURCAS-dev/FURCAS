package com.sap.furcas.parser.tcs.property;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parser.tcs.scenario.ClassLookupImpl;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.EMFParsingHelper;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.test.fixture.FeatureFixtureData;

/**
 * A test for the combination of lookupScope and referenceBy property arguments,
 * which can be used to query for elements by an identifier (e.g., find a declaration by its name).
 * 
 * @author Stephan Erb
 */
public class TestReferenceByPArg extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "QueryByIdentifierFeatureTestSyntax";
    private static final File TCS = FeatureFixtureData.PARG_QUERY_BY_IDENTIFIER_TCS;
    private static final File METAMODEL = FeatureFixtureData.PARG_REFERENCE_BY_IDENTIFIER_METAMODEL;
    private static final String PACKAGE_URI = FeatureFixtureData.PARG_REFERENCE_BY_IDENTIFIER_PACKAGE_URI;

    private static EMFParsingHelper parsingHelper;
    

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODEL);
        TCSSyntaxContainerBean mappedEnumSyntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(mappedEnumSyntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new EMFParsingHelper(facade, testConfig, PACKAGE_URI);
    }
    
    /**
     * All queries used to bind a usage to its corresponding definition should succeed.  
     */
    @Test
    public void testResolvableBindings() throws Exception {
        ModelParsingResult result = parsingHelper.parseFile("PropertyArgument_ReferenceByIdentifier_WellDefined.sam", FeatureFixtureData.EXAMPLE_FOLDER,
                /* expected errors */ 0);
        
        // Make sure all references have been resolved as expected
        EObject defintionUsageList = (EObject) result.getParsedModelElement();
        Collection<?> usages = (Collection<?>) defintionUsageList.eGet(defintionUsageList.eClass().getEStructuralFeature("usages"));
        for (Object object : usages) {
            EObject usage = (EObject) object;
            assertTrue(usage.eIsSet(usage.eClass().getEStructuralFeature("boundDefinition")));
        }
    }
    
    /**
     * All queries used to bind a usage to its corresponding definition should fail.
     * It is searched for a non-existing definitions.  
     */
    @Test
    public void testUnResolvableBindings() throws Exception {
        ModelParsingResult result = parsingHelper.parseFile("PropertyArgument_ReferenceByIdentifier_UnDefined.sam", FeatureFixtureData.EXAMPLE_FOLDER,
                /* expected errors */ 2);
        
        // Make sure none of the references has been resolved
        EObject defintionUsageList = (EObject) result.getParsedModelElement();
        Collection<?> usages = (Collection<?>) defintionUsageList.eGet(defintionUsageList.eClass().getEStructuralFeature("usages"));
        for (Object object : usages) {
            EObject usage = (EObject) object;
            assertFalse(usage.eIsSet(usage.eClass().getEStructuralFeature("boundDefinition")));
        }
    }
    
}
