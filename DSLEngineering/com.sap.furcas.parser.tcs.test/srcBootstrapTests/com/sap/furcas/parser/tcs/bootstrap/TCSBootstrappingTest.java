package com.sap.furcas.parser.tcs.bootstrap;

import java.io.File;
import java.io.FileInputStream;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.parser.tcs.TCSSyntaxDefinition;
import com.sap.furcas.parser.tcs.scenario.ClassLookupImpl;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandlerBaseImpl;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.testutils.ResourceTestHelper;

/**
 * This class runs a full bootstrap cycle, if started with the useBootstrappedTCSParser = true system property.
 * 
 * The bootstrapped parser is used to create a new TCSParser based on the same TCS.tcs that was used
 * to create the bootstrapped parser himself. The new TCSParser is then used to parse the TCS.tcs again.
 * 
 * If this test passes, then it is known that bootstrapped parser is capable of performing a full bootstrap
 * cycle. The old stable TCSParser can be replaced by the boostrapped one with confidence.
 * 
 * 
 * @author Stephan Erb (d049157)
 * 
 */
public class TCSBootstrappingTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "TCS";
    private static final File TCS = TCSSyntaxDefinition.TCS_TCS;
    private static final File[] METAMODELS = { }; // keep empty. The FURCAS metamodel is added below

    private static StubParsingHelper parsingHelper;
    private static IModelAdapter modelAdapter;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ResourceSet resourceSet = testConfig.getSourceConfiguration().getResourceSet();

        Set<URI> metamodels = testConfig.getSourceConfiguration().getReferenceScope();
        metamodels.addAll(ResourceTestHelper.createEcoreReferenceScope());
        metamodels.addAll(ResourceTestHelper.createFURCASReferenceScope());

        IMetaModelLookup<EObject> metamodelLookup = new QueryBasedEcoreMetaModelLookUp(resourceSet, metamodels);
        
        TCSSyntaxContainerBean syntaxBeanyntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBeanyntaxBean, testConfig, new ClassLookupImpl());

        Resource transientResource = EcoreHelper.createTransientParsingResource(resourceSet, FURCASPackage.eINSTANCE.getNsURI());        
        parsingHelper = new StubParsingHelper(facade);
        modelAdapter = new DefaultTextAwareModelAdapter(new EMFModelAdapter(testConfig.getSourceConfiguration().getResourceSet(), 
                new PartitionAssignmentHandlerBaseImpl(transientResource), metamodelLookup, metamodels, new TCSSpecificOCLEvaluator(),
                DefaultOppositeEndFinder.getInstance()));
    }

    @Test
    public void testParseTCSTCSWithoutErrors() throws Exception {
        parsingHelper.parseStream(new FileInputStream(TCS), /* expected errors */ 0, modelAdapter);
    }

}
