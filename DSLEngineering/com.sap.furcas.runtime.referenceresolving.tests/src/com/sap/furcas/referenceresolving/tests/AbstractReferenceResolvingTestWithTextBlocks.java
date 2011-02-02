package com.sap.furcas.referenceresolving.tests;

import java.io.File;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.junit.After;

import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryBasedTest;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryTestConfiguration;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.incremental.DefaultPartitionAssignmentHandlerImpl;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

/**
 * A test base class that use a FURCAS mapping specification (".tcs" file) and based on this produce lexer and
 * parser, then parse a text resource and register all reference resolving callbacks. 
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public abstract class AbstractReferenceResolvingTestWithTextBlocks extends GeneratedParserAndFactoryBasedTest {

    protected static IncrementalParserFacade incrementalParserFacade;
    protected TextBlocksModelElementFactory modelFactory;
    protected Resource transientParsingResource;
    protected EObject file;
    protected static ResourceSet resourceSet;
    protected static EPackage.Registry testMetamodelPackageRegistry;

    private static SyntaxRegistry syntaxRegistry;
    protected static TriggerManager triggerManager;
    protected static ConcreteSyntax syntax;

    /**
     * Call from a @BeforeClass operation in your subclass
     * 
     * @param TCS
     *            the .tcs file containing the mapping definition
     * @param LANGUAGE
     *            name of the language; should conform to the name of the language as specified in the mapping
     *            definition file
     */
    public static void setupParser(File TCS, String LANGUAGE, String MM_PACKAGE_URI, File... METAMODELS) throws Exception {
        GeneratedParserAndFactoryTestConfiguration testConfig = new GeneratedParserAndFactoryTestConfiguration(LANGUAGE, TCS, MM_PACKAGE_URI, METAMODELS);
        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        EditingDomain editingDomain = new AdapterFactoryEditingDomain(new AdapterFactoryImpl(),
                new BasicCommandStack(), resourceSet);
        OppositeEndFinder oppositeEndFinder = DefaultOppositeEndFinder.getInstance();
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        syntax = syntaxBean.getSyntax();
        incrementalParserFacade = generateParserAndParserFactoryForLanguage(syntaxBean, testConfig,
                editingDomain, oppositeEndFinder, new DefaultPartitionAssignmentHandlerImpl(), new ClassLookupImpl());
        ECrossReferenceAdapter crossRefAdapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(crossRefAdapter);
        crossRefAdapter.setTarget(resourceSet);
        syntaxRegistry = SyntaxRegistry.getInstance();
        testMetamodelPackageRegistry = addMetamodelPackagesToLocalRegistry(resourceSet);
        triggerManager = syntaxRegistry.getTriggerManagerForSyntax(syntax, testMetamodelPackageRegistry,
                DefaultOppositeEndFinder.getInstance(), /* progress monitor */ null,
                incrementalParserFacade.getParserFactory());
    }

    private static EPackage.Registry addMetamodelPackagesToLocalRegistry(ResourceSet resourceSet) {
        // delegate to the default registry if something is not found; then it may be found, e.g., in
        // metamodels deployed in the current configuration as OSGi bundles
        EPackageRegistryImpl result = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
        for (Resource r : resourceSet.getResources()) {
            for (EObject e : r.getContents()) {
                if (e instanceof EPackage) {
                    addPackageAndSubpackages((EPackage) e, result);
                }
            }
        }
        return result;
    }

    private static void addPackageAndSubpackages(EPackage e, EPackageRegistryImpl result) {
        result.put(e.getNsURI(), e);
        for (EPackage sub : e.getESubpackages()) {
            addPackageAndSubpackages(sub, result);
        }
    }

    @After
    public void cleanup() throws Exception {
        transientParsingResource.delete(/*options*/ null);
    }

    /**
     * Call from an @Before operation to parse some text into the {@link #file} attribute
     * 
     * @param textToParse
     *            this text is parsed using the grammar passed to {@link #setupParser(File, String, String, File...)} as first argument.
     */
    protected void setupFileFromTextToParse(String textToParse) {
        file = parseFile(textToParse);
    }

    protected EObject parseFile(String textToParse) {
        modelFactory = new EMFTextBlocksModelElementFactory();
        transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);
        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);
        transientParsingResource.getContents().add(root);
        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, textToParse);
        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        triggerManager.addToObservedResourceSets(resourceSet);
        EObject result = currentVersionTb.getCorrespondingModelElements().iterator().next();
        return result;
    }
    
}
