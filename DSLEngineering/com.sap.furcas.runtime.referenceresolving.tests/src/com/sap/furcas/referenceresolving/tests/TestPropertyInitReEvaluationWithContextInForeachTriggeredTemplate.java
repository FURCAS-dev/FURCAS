package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

/**
 * A test case that use a FURCAS mapping specification (".tcs" file) and based on this produce lexer and
 * parser, then parse a text resource and register all reference resolving callbacks. Then, the test
 * manipulates the model produced by the parser run and observes how OCL-based property assignments get re-assigned.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class TestPropertyInitReEvaluationWithContextInForeachTriggeredTemplate extends AbstractReferenceResolvingTestWithTextBlocks {
    
    private static final String LANGUAGE = "BibtexWithContextUsedInForeachTriggeredTemplate";
    private static final File TCS = new File("fixtures/BibtexWithContextUsedInForeachTriggeredTemplate.tcs");
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };
    private static final String MM_PACKAGE_URI = ScenarioFixtureData.BIBTEXT_PACKAGE_URI;

    private EObject johnDoe;
    private EObject article;
    private EClass authorClass;
    private EClass articleClass;

    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(TCS, LANGUAGE, MM_PACKAGE_URI, METAMODELS);
    }
    
    /**
     * Tests whether an simple addition to a textblock is correctly mapped to an insertion in the model without
     * re-creating the parent element.
     * 
     * @throws Exception
     */
    @Before
    public void setupInitialModel() throws IOException, UnknownProductionRuleException {
        String textToParse = "article{" + "  Testing, \"John Doe\"," + "  year = \"2002\"" + "}" +
                             "author = \"John Doe\"." + "author = \"Jane Doll\".";
        setupModelFromTextToParse(textToParse);
        johnDoe = null;
        article = null;
        authorClass = null;
        articleClass = null;
        assertNotNull(rootElement);
        EClass bibTexFileClass = rootElement.eClass();
        assertEquals("BibTextFile", bibTexFileClass.getName());
        @SuppressWarnings("unchecked")
        Collection<EObject> entries = (Collection<EObject>) rootElement.eGet(bibTexFileClass
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

    @After
    public void removeModelFromResourceSet() {
        rootElement.eResource().getContents().remove(rootElement);
        resourceSet.getResources().remove(transientParsingResource);
        // make sure the next parser run isn't obstructed by an already subscribed trigger manager:
        triggerManager.removeFromObservedResourceSets(resourceSet);
    }
    
    @Test
    public void testInitialModel() {
        assertNotNull(rootElement);
        EList<?> entries = (EList<?>) (rootElement).eGet((rootElement).eClass().getEStructuralFeature("entries"));
        assertEquals(3, entries.size());
        assertNotNull(syntax);
        assertEquals("BibtexWithContextUsedInForeachTriggeredTemplate", syntax.getName());
        assertNotNull(johnDoe);
        // now check the reference was set using the right property name
        // assertNotNull(johnDoe.get("articles")); StubModelHandler not powerful enough
        assertNotNull(article.eGet(articleClass.getEStructuralFeature("author")));
        assertEquals(johnDoe, article.eGet(articleClass.getEStructuralFeature("author")));
        assertEquals("Where John Doe wrote it", article.eGet(articleClass.getEStructuralFeature("location")));
     }

    @Test
    public void testChangeAuthorName() {
        johnDoe.eSet(authorClass.getEStructuralFeature("name"), "John Dough");
        assertEquals("Where John Dough wrote it", article.eGet(articleClass.getEStructuralFeature("location")));
    }
    
    @Test
    public void testAddArticleAndExpectRevenueLedgerCreation() throws Exception {
        EObject newArticle = articleClass.getEPackage().getEFactoryInstance().create(articleClass);
        newArticle.eSet(articleClass.getEStructuralFeature("location"), "Location of the New Article");
        @SuppressWarnings("unchecked")
        EList<EObject> johnsArticles = (EList<EObject>) johnDoe.eGet(authorClass.getEStructuralFeature("articles"));
        johnsArticles.add(newArticle);
        @SuppressWarnings("unchecked")
        EList<EObject> revenues = (EList<EObject>) johnDoe.eGet(authorClass.getEStructuralFeature("revenues"));
        assertEquals(johnsArticles.size(), revenues.size());
        // now ensure that a ForEachContext has been created for the RevenueLedger construction
        OppositeEndFinder oppositeEndFinder = DefaultOppositeEndFinder.getInstance();
        Set<EObject> johnsArticlesAsSet = new HashSet<EObject>(johnsArticles);
        Set<EObject> revenueLedgerArticles = new HashSet<EObject>();
        for (EObject revenueLedger : revenues) {
            revenueLedgerArticles.add((EObject) revenueLedger.eGet(revenueLedger.eClass().getEStructuralFeature("article")));
            assertEquals(
                    ((Collection<?>) rootElement.eGet(rootElement.eClass().getEStructuralFeature("entries"))).size(),
                    revenueLedger.eGet(
                            revenueLedger.eClass().getEStructuralFeature("revenueInEUR")));
            assertEquals("Expected to find exactly one ForEachContext for produced RevenueLedger element "+revenueLedger,
                    1, oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                    TextblocksPackage.eINSTANCE.getForEachExecution_ResultModelElement(), revenueLedger).size());
            EObject author = revenueLedger.eContainer();
            TextBlock authorCreationRecord = (TextBlock) oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                    TextblocksPackage.eINSTANCE.getDocumentNode_CorrespondingModelElements(), author).iterator().next();
            assertEquals("Expected exactly as many ForEachContext records as we have RevenueLedger objects for author "+
                    author, revenues.size(), authorCreationRecord.getForEachExecutions().size());
        }
        assertEquals("Mapping should have put ->first() of John's articles in here, no more, no less", 1, revenueLedgerArticles.size());
        assertTrue(johnsArticlesAsSet.containsAll(revenueLedgerArticles));
    }

}
