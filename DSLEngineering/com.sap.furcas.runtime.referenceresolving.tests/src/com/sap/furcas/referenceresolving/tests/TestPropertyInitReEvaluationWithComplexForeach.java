package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;

/**
 * A test case that use a FURCAS mapping specification (".tcs" file) and based on this produce lexer and
 * parser, then parse a text resource and register all reference resolving callbacks. Then, the test
 * manipulates the model produced by the parser run and observes how OCL-based property assignments get re-assigned.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class TestPropertyInitReEvaluationWithComplexForeach extends AbstractReferenceResolvingTest {
    
    private static final String LANGUAGE = "BibtexWithComplexForeachPropertyInits";
    private static final File TCS = new File("fixtures/BibtexWithComplexForeachPropertyInits.tcs");
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };

    private EObject johnDoe;
    private EObject janeDoll;
    private List<EObject> articles;
    private EClass authorClass;
    private EClass articleClass;

    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(LANGUAGE, TCS, METAMODELS);
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
        for (EObject entry : getECollection(rootElement, "entries")) {
            if (entry.eClass().getName().equals("Author")) {
                authorClass = entry.eClass();
                if (getFeature(entry, "name").equals("John Doe")) {
                    johnDoe = entry;
                } else if (getFeature(entry, "name").equals("Jane Doll")) {
                    janeDoll = entry;
                }
            } else if (entry.eClass().getName().equals("Article")) {
                articleClass = entry.eClass();
                articles.add(entry);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private List<EObject> getECollection(EObject obj, String feature) {
        return (List<EObject>) getFeature(obj, feature);
    }
    
    private EObject getEFeature(EObject obj, String feature) {
        return (EObject) getFeature(obj, feature);
    }
    
    private Object getFeature(EObject obj, String feature) {
        return obj.eGet(obj.eClass().getEStructuralFeature(feature));
    }
    
    @Test
    public void testInitialModel() {
        assertNotNull(rootElement);
        EList<?> entries = (EList<?>) (rootElement).eGet((rootElement).eClass().getEStructuralFeature("entries"));
        assertEquals(5, entries.size());
        assertEquals(3, articles.size());
        
        assertNotNull(johnDoe);
        assertFalse(getECollection(johnDoe, "revenues").isEmpty());
        assertEquals(getECollection(johnDoe, "articles").size(), getECollection(johnDoe, "revenues").size());
        
        assertNotNull(janeDoll);
        assertFalse(getECollection(janeDoll, "revenues").isEmpty());
        assertEquals(getECollection(janeDoll, "articles").size(), getECollection(janeDoll, "revenues").size());
        
        // now check the reference was set using the right property name
        for (EObject article : articles) {
            assertNotNull(getEFeature(article, "author"));
        }
        for (EObject author : new EObject[] { johnDoe, janeDoll }) {
            for (EObject revenue : getECollection(author, "revenues")) {
                EObject articleOfRevenue = getEFeature(revenue, "article");
                String articleName = (String) getFeature(articleOfRevenue, "key");
                assertEquals((articleName.length()<5 ? 1 : articleName.length()<10?2:3)*articleName.length(),
                        getFeature(revenue, "revenueInEUR"));
            }
        }
     }

    @Test
    public void testChangeArticleNameWithinSameWhenClause() {
        testInitialModel(); // just to make sure that for this particular test case evaluation the model is correct, too
        for (EObject article : articles) {
            if (article.eGet(articleClass.getEStructuralFeature("key")).equals("Shrt")) {
                String newArticleName = "Sht";
                article.eSet(articleClass.getEStructuralFeature("key"), newArticleName);
                // testInitialModel(); // test if everything is still alright after the change
                EObject author = (EObject) article.eGet(articleClass.getEStructuralFeature("author"));
                @SuppressWarnings("unchecked")
                Collection<EObject> revenues = (Collection<EObject>) author.eGet(authorClass.getEStructuralFeature("revenues"));
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
    
    @Test
    public void testChangeArticleNameCausingWhenClauseSelectionToChange() {
        testInitialModel(); // just to make sure that for this particular test case evaluation the model is correct, too
        for (EObject article : articles) {
            if (article.eGet(articleClass.getEStructuralFeature("key")).equals("Shrt")) {
                String newArticleName = "Short";
                article.eSet(articleClass.getEStructuralFeature("key"), newArticleName); // takes it to >= 5, expecting revenue to double
                // testInitialModel(); // test if everything is still alright after the change
                EObject author = (EObject) article.eGet(articleClass.getEStructuralFeature("author"));
                @SuppressWarnings("unchecked")
                Collection<EObject> revenues = (Collection<EObject>) author.eGet(authorClass.getEStructuralFeature("revenues"));
                boolean found = false;
                for (EObject revenue : revenues) {
                    EObject articleOfRevenue = (EObject) revenue.eGet(revenue.eClass().getEStructuralFeature("article"));
                    if (articleOfRevenue == article) {
                        // We clearly had the case that the testInitialModel() call above succeeded but the following
                        // assertion failed. This makes it likely that the article.eSet call above cause a model change
                        // which can only have resulted from an event handler that reacted to the change
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
    
    @Test
    public void testAddArticleAndExpectRevenueLedgerCreation() throws Exception {
        EObject newArticle = articleClass.getEPackage().getEFactoryInstance().create(articleClass);
        newArticle.eSet(articleClass.getEStructuralFeature("key"), "New Article's Name");
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
            EObject articleOfRevenue = (EObject) revenueLedger.eGet(revenueLedger.eClass().getEStructuralFeature("article"));
            String articleName = (String) articleOfRevenue.eGet(articleClass.getEStructuralFeature("key"));
            assertEquals((articleName.length()<5 ? 1 : articleName.length()<10?2:3)*articleName.length(),
                    revenueLedger.eGet(revenueLedger.eClass().getEStructuralFeature("revenueInEUR")));
            revenueLedgerArticles.add(articleOfRevenue);
            assertEquals(
                    "Expected to find exactly one ForEachContext for produced RevenueLedger element " + revenueLedger,
                    1,
                    oppositeEndFinder.navigateOppositePropertyWithBackwardScope(
                            TextblocksPackage.eINSTANCE.getForEachExecution_ResultModelElement(), revenueLedger).size());
            EObject author = revenueLedger.eContainer();
            TextBlock authorCreationRecord = (TextBlock) oppositeEndFinder
                    .navigateOppositePropertyWithBackwardScope(
                            TextblocksPackage.eINSTANCE.getTextBlock_CorrespondingModelElements(), author)
                    .iterator().next();
            assertEquals("Expected exactly as many ForEachContext records as we have RevenueLedger objects for author "
                    + author, revenues.size(), authorCreationRecord.getForEachExecutions().size());
        }
        assertEquals(johnsArticlesAsSet, revenueLedgerArticles);
    }

}
