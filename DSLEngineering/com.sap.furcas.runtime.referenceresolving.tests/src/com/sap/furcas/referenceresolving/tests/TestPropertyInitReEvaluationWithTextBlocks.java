package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
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
public class TestPropertyInitReEvaluationWithTextBlocks extends GeneratedParserAndFactoryBasedTest {
    
    private static final String LANGUAGE = "BibtexWithPropertyInits";
    private static final File TCS = new File("fixtures/BibtexWithPropertyInits.tcs");

    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };
    private static final String MM_PACKAGE_NAME = "BibText";

    private static IncrementalParserFacade incrementalParserFacade;
    
    private TextBlocksModelElementFactory modelFactory;
    private Resource transientParsingResource;
    private TextBlock currentVersionTb;
    private EObject bibtexFile;
    private static ResourceSet resourceSet;

    private static SyntaxRegistry syntaxRegistry;
    private static TriggerManager triggerManager;
    private static ConcreteSyntax syntax;
    private EObject johnDoe;
    private EObject article;
    private EClass authorClass;
    private EClass articleClass;

    @BeforeClass
    public static void setupParser() throws Exception {
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
    
    /**
     * Tests whether an simple addition to a textblock is correctly mapped to an insertion in the model without
     * re-creating the parent element.
     * 
     * @throws Exception
     */
    @Before
    public void setupInitialModel() throws IOException, UnknownProductionRuleException {
        modelFactory = new EMFTextBlocksModelElementFactory();
        transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);
        AbstractToken content = modelFactory.createToken("");
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);
        transientParsingResource.getContents().add(root);
        TextBlocksModel tbModel = new TextBlocksModel(root, null);
        tbModel.replace(0, 0, "article{" + "  Testing, \"John Doe\"," + "  year = \"2002\"" + "}" +
                "author = \"John Doe\"." + "author = \"Jane Doll\".");
        currentVersionTb = incrementalParserFacade.parseIncrementally(root);
        bibtexFile = currentVersionTb.getCorrespondingModelElements().iterator().next();
        triggerManager.addToObservedResourceSets(resourceSet);
        johnDoe = null;
        article = null;
        authorClass = null;
        articleClass = null;
        assertNotNull(bibtexFile);
        EClass bibTexFileClass = bibtexFile.eClass();
        assertEquals("BibTextFile", bibTexFileClass.getName());
        @SuppressWarnings("unchecked")
        Collection<EObject> entries = (Collection<EObject>) bibtexFile.eGet(bibTexFileClass
                .getEStructuralFeature("entries"));
        for (EObject entry : entries) {
            if (entry.eClass().getName().equals("Author")) {
                authorClass = entry.eClass();
                if (entry.eGet(authorClass.getEStructuralFeature("name")).equals("John Doe")) {
                    johnDoe = entry;
                }
            } else if (entry.eClass().getName().equals("Article")) {
                articleClass = entry.eClass();
                article = entry;
            }
        }
    }
    
    @Test
    public void testInitialModel() {
        assertNotNull(bibtexFile);
        EList<?> entries = (EList<?>) (bibtexFile).eGet((bibtexFile).eClass().getEStructuralFeature("entries"));
        assertEquals(3, entries.size());
        assertNotNull(syntax);
        assertEquals("BibtexWithPropertyInits", syntax.getName());
        assertNotNull(johnDoe);
        // now check the reference was set using the right property name
        // assertNotNull(johnDoe.get("articles")); StubModelHandler not powerful enough
        assertNotNull(article.eGet(articleClass.getEStructuralFeature("author")));
        assertEquals(johnDoe, article.eGet(articleClass.getEStructuralFeature("author")));
        assertEquals("Where John Doe wrote it", article.eGet(articleClass.getEStructuralFeature("location")));
     }

    @Test
    public void testForeachPropertyInitValueInInitialModel() throws Exception {
        @SuppressWarnings("unchecked")
        EList<EObject> revenues = (EList<EObject>) johnDoe.eGet(authorClass.getEStructuralFeature("revenues"));
        @SuppressWarnings("unchecked")
        EList<EObject> johnsArticles = (EList<EObject>) johnDoe.eGet(authorClass.getEStructuralFeature("articles"));
        assertEquals(johnsArticles.size(), revenues.size());
        Iterator<EObject> johnsArticlesIterator = johnsArticles.iterator();
        for (EObject revenue : revenues) {
            assertSame(johnsArticlesIterator.next(), revenue.eGet(revenue.eClass().getEStructuralFeature("article")));
        }
    }

    @Test
    public void testChangeAuthorName() {
        johnDoe.eSet(authorClass.getEStructuralFeature("name"), "John Dough");
        assertEquals("Where John Dough wrote it", article.eGet(articleClass.getEStructuralFeature("location")));
    }

}
