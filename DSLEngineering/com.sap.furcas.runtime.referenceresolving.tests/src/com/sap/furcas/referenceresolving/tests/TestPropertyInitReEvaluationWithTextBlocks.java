package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;

/**
 * A test case that use a FURCAS mapping specification (".tcs" file) and based on this produce lexer and
 * parser, then parse a text resource and register all reference resolving callbacks. Then, the test
 * manipulates the model produced by the parser run and observes how OCL-based property assignments get re-assigned.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class TestPropertyInitReEvaluationWithTextBlocks extends AbstractBibtexTestWithTextBlocks {
    
    private static final String LANGUAGE = "BibtexWithPropertyInits";
    private static final File TCS = new File("fixtures/BibtexWithPropertyInits.tcs");

    private EObject johnDoe;
    private EObject article;
    private EClass authorClass;
    private EClass articleClass;

    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(TCS, LANGUAGE);
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
        setupBibtexFileFromTextToParse(textToParse);
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

    @After
    public void removeModelFromResourceSet() {
        bibtexFile.eResource().getContents().remove(bibtexFile);
        resourceSet.getResources().remove(transientParsingResource);
        // make sure the next parser run isn't obstructed by an already subscribed trigger manager:
        triggerManager.removeFromObservedResourceSets(resourceSet);
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
            EObject theArticle = johnsArticlesIterator.next();
            assertSame(theArticle, revenue.eGet(revenue.eClass().getEStructuralFeature("article")));
            assertEquals(((String) ((EObject) theArticle.eGet(articleClass.getEStructuralFeature("author"))).eGet(
                    authorClass.getEStructuralFeature("name"))).length(), revenue.eGet(
                            revenue.eClass().getEStructuralFeature("revenueInEUR")));
        }
    }
    
    @Test
    public void testChangeOfExpressionValueUsingHashForeach() throws Exception {
        johnDoe.eSet(authorClass.getEStructuralFeature("name"), "The Only John Doe");
        testForeachPropertyInitValueInInitialModel();
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
    }

}
