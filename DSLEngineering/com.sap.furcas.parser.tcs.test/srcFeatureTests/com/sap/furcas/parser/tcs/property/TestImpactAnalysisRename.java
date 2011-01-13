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
 * This test ensures that the TCS and ecore file, which will be used in ImpactAnalysis Rename tests,
 * work are defined correctly.
 *  
 * @author Sebastian Schlag (D049672)
 *
 */

public class TestImpactAnalysisRename  extends GeneratedParserBasedTest{
    
    private static final String LANGUAGE = "ImpactAnalysisRenameTestSyntax";
    private static final File TCS = FeatureFixtureData.IA_RENAME_TCS;
    private static final File METAMODEL = FeatureFixtureData.IA_RENAME_METAMODEL;
    private static final String PACKAGE_URI = FeatureFixtureData.IA_RENAME_PACKAGE_URI;
    
    private static EMFParsingHelper parsingHelper;
    
    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODEL);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new EMFParsingHelper(facade, testConfig, PACKAGE_URI);
    }
    
    
    /**
     * All queries used to bind a usage to its corresponding definition should succeed.  
     */
    @Test
    public void testResolvableBindings() throws Exception {
        ModelParsingResult result = parsingHelper.parseFile("ImpactAnalysisRename.sam", FeatureFixtureData.EXAMPLE_FOLDER,
                /* expected errors */ 0);
        
        // Make sure all references have been resolved as expected
        EObject defintionUsageList = (EObject) result.getParsedModelElement();
        Collection<?> usages = (Collection<?>) defintionUsageList.eGet(defintionUsageList.eClass().getEStructuralFeature("usages"));
        for (Object object : usages) {
            EObject usage = (EObject) object;
            assertTrue(usage.eIsSet(usage.eClass().getEStructuralFeature("boundDefinition")));
        }
    }

}
