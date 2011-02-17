package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
public class TestPropertyInitReEvaluationWithComplexForeach extends AbstractReferenceResolvingTestWithTextBlocks {
    
    private static final String LANGUAGE = "BibtexWithComplexForeachPropertyInits";
    private static final File TCS = new File("fixtures/BibtexWithComplexForeachPropertyInits.tcs");
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };
    private static final String MM_PACKAGE_URI = ScenarioFixtureData.BIBTEXT_PACKAGE_URI;

    private EObject johnDoe;
    private EObject janeDoll;
    private List<EObject> articles;
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
        String textToParse = "article{ Shrt, \"John Doe\"}" +
                             "article{ Medium, \"John Doe\"}" +
                             "article{ LongLongLong, \"Jane Doll\"}" +
                             "author = \"John Doe\"." +
                             "author = \"Jane Doll\".";
        setupModelFromTextToParse(textToParse);
        johnDoe = null;
        articles = new ArrayList<EObject>(3);
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
                } else if (entry.eGet(authorClass.getEStructuralFeature("name")).equals("Jane Doll")) {
                    janeDoll = entry;
                }
            } else if (entry.eClass().getName().equals("Article")) {
                articleClass = entry.eClass();
                articles.add(entry);
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
    
    @Ignore("Still working on getting the foreach handling with textblocks right")
    @Test
    public void testInitialModel() {
        assertNotNull(rootElement);
        EList<?> entries = (EList<?>) (rootElement).eGet((rootElement).eClass().getEStructuralFeature("entries"));
        assertEquals(5, entries.size());
        assertEquals(3, articles.size());
        assertNotNull(syntax);
        assertEquals("BibtexWithComplexForeachPropertyInits", syntax.getName());
        assertNotNull(johnDoe);
        assertFalse(((Collection<?>) johnDoe.eGet(authorClass.getEStructuralFeature("revenues"))).isEmpty());
        assertEquals(((Collection<?>) johnDoe.eGet(authorClass.getEStructuralFeature("articles"))).size(),
                ((Collection<?>) johnDoe.eGet(authorClass.getEStructuralFeature("revenues"))).size());
        assertNotNull(janeDoll);
        assertFalse(((Collection<?>) janeDoll.eGet(authorClass.getEStructuralFeature("revenues"))).isEmpty());
        assertEquals(((Collection<?>) janeDoll.eGet(authorClass.getEStructuralFeature("articles"))).size(),
                ((Collection<?>) janeDoll.eGet(authorClass.getEStructuralFeature("revenues"))).size());
        // now check the reference was set using the right property name
        for (EObject article : articles) {
            assertNotNull(article.eGet(articleClass.getEStructuralFeature("author")));
        }
     }

    @Test
    public void testChangeArticleName() {
        for (EObject article : articles) {
            if (article.eGet(articleClass.getEStructuralFeature("key")).equals("Shrt")) {
                String newArticleName = "Short";
                article.eSet(articleClass.getEStructuralFeature("key"), newArticleName); // takes it to >= 5, expecting revenue to double
                EObject author = (EObject) article.eGet(articleClass.getEStructuralFeature("author"));
                @SuppressWarnings("unchecked")
                Collection<EObject> revenues = (Collection<EObject>) author.eGet(authorClass.getEStructuralFeature("revenues"));
                boolean found = false;
                for (EObject revenue : revenues) {
                    EObject articleOfRevenue = (EObject) revenue.eGet(revenue.eClass().getEStructuralFeature("article"));
                    if (articleOfRevenue == article) {
                        assertEquals(2*newArticleName.length(), revenue.eGet(revenue.eClass().getEStructuralFeature("revenueInEUR")));
                        found = true;
                    }
                }
                assertTrue(found);
            }
        }
    }
    
    /**
     * Tests that updating an author's name does not trigger the property init through the
     * impact analysis in case the author hasn't been created using concrete syntax and
     * therefore no text block exists for the property init's execution.
     */
    @Ignore
    @Test
    public void testChangeAuthorNameForAuthorNotCreatedByConcreteSyntax() {
        EObject newAuthor = authorClass.getEPackage().getEFactoryInstance().create(authorClass);
        johnDoe.eResource().getContents().add(newAuthor);
        EObject newAuthorsArticle = articleClass.getEPackage().getEFactoryInstance().create(articleClass);
        @SuppressWarnings("unchecked")
        EList<EObject> articleList = (EList<EObject>) newAuthor.eGet(authorClass.getEStructuralFeature("articles"));
        articleList.add(newAuthorsArticle);
        newAuthor.eSet(authorClass.getEStructuralFeature("name"), "The New Author");
        assertNull(newAuthorsArticle.eGet(articleClass.getEStructuralFeature("location")));
    }
    
    @Ignore
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
                    ((String) ((EObject) ((EObject) revenueLedger.eGet(revenueLedger.eClass().getEStructuralFeature(
                            "article"))).eGet(articleClass.getEStructuralFeature("author"))).eGet(                    authorClass.getEStructuralFeature("name"))).length(), revenueLedger.eGet(
                            revenueLedger.eClass().getEStructuralFeature("revenueInEUR")));
            assertEquals("Expected to find exactly one ForEachContext for produced RevenueLedger element "+revenueLedger,
                    1, oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                    TextblocksPackage.eINSTANCE.getForEachContext_ResultModelElement(), revenueLedger).size());
            EObject author = revenueLedger.eContainer();
            TextBlock authorCreationRecord = (TextBlock) oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                    TextblocksPackage.eINSTANCE.getDocumentNode_CorrespondingModelElements(), author).iterator().next();
            assertEquals("Expected exactly as many ForEachContext records as we have RevenueLedger objects for author "+
                    author, revenues.size(), authorCreationRecord.getForEachContext().size());
        }
        assertEquals(johnsArticlesAsSet, revenueLedgerArticles);
    }

}
