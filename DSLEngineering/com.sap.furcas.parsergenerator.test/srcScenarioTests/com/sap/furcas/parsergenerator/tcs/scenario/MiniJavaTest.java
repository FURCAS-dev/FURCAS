package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.ScopeHelper;

/**
 * Simple Test for a simple, java like language.
 * 
 * TODO: pull up findPackage or createModelAdapter into an additional base clase
 */
public class MiniJavaTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "MiniJava";
    private static final File TCS = ScenarioFixtureData.MINI_JAVA_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.MINI_JAVA_METAMODEL};
    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";
    
    private static ParsingHelper parsingHelper;
    private static EPackage rootPackage;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
        rootPackage = findPackage("MiniJava", testConfig.getSourceConfiguration().getResourceSet());
    }

    /**
     * Parse a simple, self-contained MiniJava compilation unit. It just contains one basic class. 
     */
    @Test
    public void testParseSimpleSample() throws Exception {
        IModelAdapter modelAdapter = createNewEMFModelAdapter();
        parsingHelper.parseFile("MiniJava_TestSimple.sam", DSLSAMPLEDIR, /*expected errors*/ 0, modelAdapter);
    }

    private IModelAdapter createNewEMFModelAdapter() {
        return new DefaultTextAwareModelAdapter(
                new EMFModelAdapter(rootPackage, ScopeHelper.createResourceSet(), Collections.singleton(rootPackage.eResource().getURI())));
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
