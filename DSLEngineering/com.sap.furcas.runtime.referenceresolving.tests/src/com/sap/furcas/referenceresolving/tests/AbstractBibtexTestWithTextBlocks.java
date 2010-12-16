package com.sap.furcas.referenceresolving.tests;

import java.io.File;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

/**
 * A test case that use a FURCAS mapping specification (".tcs" file) and based on this produce lexer and
 * parser, then parse a text resource and register all reference resolving callbacks. Then, the test
 * manipulates the model produced by the parser run and observes how OCL-based property assignments get re-assigned.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class AbstractBibtexTestWithTextBlocks extends GeneratedParserAndFactoryBasedTest {
    
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };
    private static final String MM_PACKAGE_NAME = "BibText";

    protected static IncrementalParserFacade incrementalParserFacade;
    protected TextBlocksModelElementFactory modelFactory;
    protected Resource transientParsingResource;
    protected TextBlock currentVersionTb;
    protected EObject bibtexFile;
    protected static ResourceSet resourceSet;

    private static SyntaxRegistry syntaxRegistry;
    protected static TriggerManager triggerManager;
    protected static ConcreteSyntax syntax;

    public static void setupParser(File TCS, String LANGUAGE) throws Exception {
        GeneratedParserAndFactoryTestConfiguration testConfig = new GeneratedParserAndFactoryTestConfiguration(LANGUAGE, TCS, MM_PACKAGE_NAME, METAMODELS);
        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        EditingDomain editingDomain = new AdapterFactoryEditingDomain(new AdapterFactoryImpl(),
                new BasicCommandStack(), resourceSet);
        OppositeEndFinder oppositeEndFinder = DefaultOppositeEndFinder.getInstance();
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        syntax = syntaxBean.getSyntax();
        incrementalParserFacade = generateParserAndParserFactoryForLanguage(syntaxBean, testConfig,
                editingDomain, oppositeEndFinder, new ClassLookupImpl());
        ECrossReferenceAdapter crossRefAdapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(crossRefAdapter);
        crossRefAdapter.setTarget(resourceSet);
        syntaxRegistry = SyntaxRegistry.getInstance();
        triggerManager = syntaxRegistry.getTriggerManagerForSyntax(syntax, DefaultOppositeEndFinder.getInstance(),
                /* progress monitor */ null);
    }

    @After
    public void cleanup() throws Exception {
        transientParsingResource.delete(/*options*/ null);
    }
    
    protected EObject parseBibtexFile(String textToParse) {
        modelFactory = new EMFTextBlocksModelElementFactory();
        transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);
        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);
        transientParsingResource.getContents().add(root);
        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, textToParse);
        currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        triggerManager.addToObservedResourceSets(resourceSet);
        EObject result = currentVersionTb.getCorrespondingModelElements().iterator().next();
        return result;
    }
    
}
