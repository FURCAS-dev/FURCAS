package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;

/**
 * A test case that use a FURCAS mapping specification (".tcs" file) and based on this produce lexer and
 * parser, then parse a text resource and register all reference resolving callbacks. Then, the test
 * manipulates the model produced by the parser run and observes how OCL-based property assignments get re-assigned.
 * 
 * This specific test class deals with "when" clauses of "foreach" property initializations. Model changes
 * may affect the "foreach" expression itself or any of the "when" clauses. The test also manifests the
 * behavior of no matching when-clauses with no default clause.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class TestPropertyInitReEvaluationWithForeachWithWhen extends AbstractReferenceResolvingTestWithTextBlocks {
    
    private static final String LANGUAGE = "BibtexWithForeachWithWhen";
    private static final File TCS = new File("fixtures/BibtexWithForeachWithWhen.tcs");
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
    public void setupInitialModel() throws SemanticParserException {
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
    
    @Test
    public void testInitialModel() {
        assertNotNull(rootElement);
        EList<?> entries = (EList<?>) (rootElement).eGet((rootElement).eClass().getEStructuralFeature("entries"));
        assertEquals(5, entries.size());
        assertEquals(3, articles.size());
        assertNotNull(syntax);
        assertEquals("BibtexWithForeachWithWhen", syntax.getName());
        assertNotNull(johnDoe);
        assertFalse(((Collection<?>) johnDoe.eGet(authorClass.getEStructuralFeature("revenues"))).isEmpty());
        assertEquals(((Collection<?>) johnDoe.eGet(authorClass.getEStructuralFeature("articles"))).size(),
                ((Collection<?>) johnDoe.eGet(authorClass.getEStructuralFeature("revenues"))).size());
        assertEquals(2, ((Collection<?>) johnDoe.eGet(authorClass.getEStructuralFeature("revenues"))).size());
        assertNotNull(janeDoll);
        // Jane shouldn't have any revenues because her article's key is too long
        assertTrue(((Collection<?>) janeDoll.eGet(authorClass.getEStructuralFeature("revenues"))).isEmpty());
        // now check the reference was set using the right property name
        for (EObject article : articles) {
            assertNotNull(article.eGet(articleClass.getEStructuralFeature("author")));
        }
        for (EObject author : new EObject[] { johnDoe, janeDoll }) {
            @SuppressWarnings("unchecked")
            Collection<EObject> revenues = (Collection<EObject>) author.eGet(authorClass.getEStructuralFeature("revenues"));
            for (EObject revenue : revenues) {
                EObject articleOfRevenue = (EObject) revenue.eGet(revenue.eClass().getEStructuralFeature("article"));
                String articleName = (String) articleOfRevenue.eGet(articleClass.getEStructuralFeature("key"));
                assertEquals((articleName.length()<5 ? 1 : articleName.length()<10?2:3)*articleName.length(),
                        revenue.eGet(revenue.eClass().getEStructuralFeature("revenueInEUR")));
            }
        }
     }

    /**
     * By changing an article's "key" the article now matches a when-clause and should produce a revenue
     * element for Jane.
     */
    @Test
    public void testChangeArticleNameFromNoClauseToWhenClause() {
        testInitialModel(); // just to make sure that for this particular test case evaluation the model is correct, too
        for (EObject article : articles) {
            if (article.eGet(articleClass.getEStructuralFeature("key")).equals("LongLongLong")) {
                String newArticleName = "Long";
                article.eSet(articleClass.getEStructuralFeature("key"), newArticleName);
                // testInitialModel(); // test if everything is still alright after the change
                EObject author = (EObject) article.eGet(articleClass.getEStructuralFeature("author"));
                assertEquals("Expected Jane to have authored the article with the long key", janeDoll, author);
                @SuppressWarnings("unchecked")
                Collection<EObject> revenues = (Collection<EObject>) author.eGet(authorClass.getEStructuralFeature("revenues"));
                assertEquals(1, revenues.size());
                boolean found = false;
                for (EObject revenue : revenues) {
                    EObject articleOfRevenue = (EObject) revenue.eGet(revenue.eClass().getEStructuralFeature("article"));
                    if (articleOfRevenue == article) {
                        // We clearly had the case that the testInitialModel() call above succeeded but the following
                        // assertion failed. This makes it likely that the article.eSet call above cause a model change
                        // which can only have resulted from an event handler that reacted to the change
                        assertEquals(newArticleName.length(), revenue.eGet(revenue.eClass().getEStructuralFeature("revenueInEUR")));
                        found = true;
                    }
                }
                assertTrue(found);
            }
        }
    }
    
    /**
     * By changing an article's "key" the article now no longer matches a when-clause and should cause
     * the corresponding RevenueLedger object to be removed from author "John"
     */
    @Test
    public void testChangeArticleNameFromWhenClauseToNoClause() {
        testInitialModel(); // just to make sure that for this particular test case evaluation the model is correct, too
        for (EObject article : articles) {
            if (article.eGet(articleClass.getEStructuralFeature("key")).equals("Shrt")) {
                String newArticleName = "NotSoShortAnymore";
                article.eSet(articleClass.getEStructuralFeature("key"), newArticleName);
                // testInitialModel(); // test if everything is still alright after the change
                EObject author = (EObject) article.eGet(articleClass.getEStructuralFeature("author"));
                assertEquals("Expected John to have authored the article with the Shrt key", johnDoe, author);
                @SuppressWarnings("unchecked")
                Collection<EObject> revenues = (Collection<EObject>) author.eGet(authorClass.getEStructuralFeature("revenues"));
                assertEquals(1, revenues.size());
                boolean found = false;
                for (EObject revenue : revenues) {
                    EObject articleOfRevenue = (EObject) revenue.eGet(revenue.eClass().getEStructuralFeature("article"));
                    if (articleOfRevenue == article) {
                        found = true;
                    }
                }
                assertFalse(found);
            }
        }
    }
    
    /**
     * By changing an article's "key" the article now no longer matches a when-clause and should cause
     * the corresponding RevenueLedger object to be removed from author "John"
     */
    @Test
    public void testAddArticleForJane() {
        testInitialModel(); // just to make sure that for this particular test case evaluation the model is correct, too
        EObject newArticle = articleClass.getEPackage().getEFactoryInstance().create(articleClass);
        String newArticleName = "NewMedium";
        newArticle.eSet(articleClass.getEStructuralFeature("key"), newArticleName);
        @SuppressWarnings("unchecked")
        Collection<EObject> janesArticles = ((Collection<EObject>) janeDoll.eGet(authorClass
                .getEStructuralFeature("articles")));
        janesArticles.add(newArticle);
        @SuppressWarnings("unchecked")
        Collection<EObject> revenues = (Collection<EObject>) janeDoll.eGet(authorClass.getEStructuralFeature("revenues"));
        assertEquals(1, revenues.size());
        boolean found = false;
        for (EObject revenue : revenues) {
            EObject articleOfRevenue = (EObject) revenue.eGet(revenue.eClass().getEStructuralFeature("article"));
            if (articleOfRevenue == newArticle) {
                // We clearly had the case that the testInitialModel() call above succeeded but the following
                // assertion failed. This makes it likely that the article.eSet call above cause a model change
                // which can only have resulted from an event handler that reacted to the change
                assertEquals(2*newArticleName.length(),
                        revenue.eGet(revenue.eClass().getEStructuralFeature("revenueInEUR")));
                found = true;
            }
        }
        assertTrue(found);
    }

}
