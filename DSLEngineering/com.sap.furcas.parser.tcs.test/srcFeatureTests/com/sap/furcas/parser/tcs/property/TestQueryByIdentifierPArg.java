package com.sap.furcas.parser.tcs.property;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.parser.tcs.scenario.ClassLookupImpl;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.FeatureFixtureData;
import com.sap.furcas.test.testutils.ResourceTestHelper;

/**
 * A test for the queryByIdentifier property argument, which can be used to
 * query for elements by an identifier (e.g., find a declaration by its name).
 * 
 * @author Stephan Erb
 */
public class TestQueryByIdentifierPArg extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "QueryByIdentifierFeatureTestSyntax";
    private static final File TCS = FeatureFixtureData.PARG_QUERY_BY_IDENTIFIER_TCS;
    private static final File METAMODEL = FeatureFixtureData.PARG_QUERY_BY_IDENTIFIER_METAMODEL;

    private static ParsingHelper parsingHelper;
    private static EPackage rootPackage;
    

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODEL);
        TCSSyntaxContainerBean mappedEnumSyntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(mappedEnumSyntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
        
        rootPackage = findPackage("QueryByIdentifier", testConfig.getSourceConfiguration().getResourceSet());
    }
    
    /**
     * All queries used to bind a usage to its corresponding definition should succeed.  
     */
    @Test
    public void testResolvableBindings() throws Exception {
        IModelAdapter modelAdapter = createNewEMFModelAdapter();
        
        ModelParsingResult result = parsingHelper.parseFile("PropertyArgument_QueryByIdentifier_WellDefined.sam", FeatureFixtureData.EXAMPLE_FOLDER,
                /* expected errors */ 0, modelAdapter);
        
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
        IModelAdapter modelAdapter = createNewEMFModelAdapter();
        
        ModelParsingResult result = parsingHelper.parseFile("PropertyArgument_QueryByIdentifier_UnDefined.sam", FeatureFixtureData.EXAMPLE_FOLDER,
                /* expected errors */ 2, modelAdapter);
        
        // Make sure none of the references has been resolved
        EObject defintionUsageList = (EObject) result.getParsedModelElement();
        Collection<?> usages = (Collection<?>) defintionUsageList.eGet(defintionUsageList.eClass().getEStructuralFeature("usages"));
        for (Object object : usages) {
            EObject usage = (EObject) object;
            assertFalse(usage.eIsSet(usage.eClass().getEStructuralFeature("boundDefinition")));
        }
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
