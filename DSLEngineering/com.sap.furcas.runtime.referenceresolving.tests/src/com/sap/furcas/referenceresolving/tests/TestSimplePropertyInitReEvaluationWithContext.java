package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
public class TestSimplePropertyInitReEvaluationWithContext extends AbstractReferenceResolvingTestWithTextBlocks {
    
    private static final String LANGUAGE = "BibtexWithPropertyInitsWithContext";
    private static final File TCS = new File("fixtures/BibtexWithPropertyInitsWithContext.tcs");
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };
    private static final String MM_PACKAGE_URI = ScenarioFixtureData.BIBTEXT_PACKAGE_URI;

    private EObject johnDoe;
    private EObject janeDoll;
    private EObject article;
    private EClass authorClass;
    private EClass articleClass;

    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(TCS, LANGUAGE,MM_PACKAGE_URI,METAMODELS);
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
                             "author = \"John Doe\". humba " + "author = \"Jane Doll\". trala";
        setupModelFromTextToParse(textToParse);
        johnDoe = null;
        janeDoll = null;
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
                } else if (entry.eGet(authorClass.getEStructuralFeature("name")).equals("Jane Doll")) {
                    janeDoll = entry;
                }

            } else if (entry.eClass().getName().equals("Article")) {
                articleClass = entry.eClass();
                article = entry;
            }
        }
    }

    @Test
    public void testInitialModel() {
        assertNotNull(rootElement);
        EList<?> entries = (EList<?>) (rootElement).eGet((rootElement).eClass().getEStructuralFeature("entries"));
        assertEquals(3, entries.size());
        assertNotNull(syntax);
        assertEquals("BibtexWithPropertyInitsWithContext", syntax.getName());
        assertNotNull(johnDoe);
        // now check the reference was set using the right property name
        // assertNotNull(johnDoe.get("articles")); StubModelHandler not powerful enough
        assertNotNull(article.eGet(articleClass.getEStructuralFeature("author")));
        assertEquals(johnDoe, article.eGet(articleClass.getEStructuralFeature("author")));
        assertEquals("Where John Doe wrote it", article.eGet(articleClass.getEStructuralFeature("location")));
     }

    @Test
    public void testContextPropertyInitValueInInitialModel() throws Exception {
        @SuppressWarnings("unchecked")
        EList<EObject> revenues = (EList<EObject>) johnDoe.eGet(authorClass.getEStructuralFeature("revenues"));
        assertEquals(1, revenues.size());
        for (EObject revenue : revenues) {
            assertEquals(((String) johnDoe.eGet(
                    authorClass.getEStructuralFeature("name"))).length(), revenue.eGet(
                            revenue.eClass().getEStructuralFeature("revenueInEUR")));
        }
    }
    
    @Test
    public void testChangeOfExpressionValueUsingHashContext() throws Exception {
        johnDoe.eSet(authorClass.getEStructuralFeature("name"), "The Only John Doe");
        testContextPropertyInitValueInInitialModel();
    }

    @Test
    public void testChangeOfExpressionValueUsingHashContextInSecondAlternative() throws Exception {
        janeDoll.eSet(authorClass.getEStructuralFeature("name"), "The Only Dane Doll");
        @SuppressWarnings("unchecked")
        EList<EObject> revenues = (EList<EObject>) janeDoll.eGet(authorClass.getEStructuralFeature("revenues"));
        assertEquals(1, revenues.size());
        for (EObject revenue : revenues) {
            assertEquals(((String) janeDoll.eGet(
                    authorClass.getEStructuralFeature("name"))).length()*2, revenue.eGet(
                            revenue.eClass().getEStructuralFeature("revenueInEUR")));
        }
    }

}
