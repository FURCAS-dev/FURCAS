package com.sap.furcas.unparser;

import java.io.File;
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
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.unparser.testutils.PrettyPrintAssertionUtil;
import com.sap.furcas.unparser.testutils.PrettyPrintTestHelper;

/**
 * Simple Test for the custom BibText language
 */
public class TestClassTemplate extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "Bibtext";
    private static final File TCS = ScenarioFixtureData.BIBTEXT_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };
    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";

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
        rootPackage = findPackage("BibText", testConfig.getSourceConfiguration().getResourceSet());
        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        referenceScope = testConfig.getSourceConfiguration().getReferenceScope();
    }

    @Test
    public void testParseAndReprint() throws Exception {
        IModelAdapter modelAdapter = createNewEMFModelAdapter();
        ModelParsingResult result = parsingHelper.parseFile("ClassTemplateBibTextSample.sam", DSLSAMPLEDIR, /*expected errors*/ 0, modelAdapter);
        
        String expected = PrettyPrintTestHelper.readFile(DSLSAMPLEDIR + "ClassTemplateBibTextSample.sam");
        String printed = PrettyPrintTestHelper.prettyPrintString((EObject) result.getParsedModelElement(), syntax);
        
        PrettyPrintAssertionUtil.assertEqualsIgnoreWhitespaces(expected, printed);
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
