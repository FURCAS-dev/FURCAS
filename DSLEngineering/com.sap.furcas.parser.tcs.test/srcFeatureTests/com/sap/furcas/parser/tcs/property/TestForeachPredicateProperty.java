package com.sap.furcas.parser.tcs.property;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parser.tcs.scenario.ClassLookupImpl;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.EMFParsingHelper;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.test.fixture.FeatureFixtureData;

/**
 * A test case that tests if foreach predicate property inits are executed correctly.
 * 
 * The revenues of an author are defined by the following expression: <code>{{ revenues=foreach("OCL:self.articles", as=RevenueLedger) }}</code>.
 * Thus for each article of an author a new RevenueLedger model element should be created.
 * 
 * When a new RevenueLedger model element is created the feature revenueInEUR is evaluated according to the following expression:
 * <code>revenueInEUR=lookIn("OCL:#foreach(BibText::Article).author.name.size()") }}</code>.
 * 
 * This testcase tests both cases using an example that contains one article and two authors.
 * 
 * @author Sebastian Schlag (D049672)
 * 
 */

public class TestForeachPredicateProperty extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "ForeachPredicatePropertyInit";
    private static final File TCS = FeatureFixtureData.FOREACH_PREDICATE_PROPERTY_INIT_TCS;
    private static final File METAMODEL = FeatureFixtureData.FOREACH_PREDICATE_PROPERTY_INIT_METAMODEL;
    private static final String PACKAGE_URI =  FeatureFixtureData.FOREACH_PREDICATE_PROPERTY_INIT_PACKAGE_URI;

    private static EMFParsingHelper parsingHelper;
    
    private EObject johnDoe = null;
    private EObject janeDoll = null;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODEL);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new EMFParsingHelper(facade, testConfig, PACKAGE_URI);
    }

    @Before
    public void initializeModel() throws Exception {
        String sample = "article{" + "  Testing, \"John Doe\"," + "}" + "author = \"John Doe\"."
                + "author = \"Jane Doll\".";

        ModelParsingResult parsingResult = parsingHelper.parseString(sample, /*expected errors*/ 0);

        EObject bibTexFile = (EObject) parsingResult.getParsedModelElement();
        assertNotNull(bibTexFile);
        
        EClass bibTexFileClass = bibTexFile.eClass();
        assertEquals("BibTextFile", bibTexFileClass.getName());
        
        @SuppressWarnings("unchecked")
        Collection<EObject> entries = (Collection<EObject>) bibTexFile.eGet(bibTexFileClass.getEStructuralFeature("entries"));
        assertEquals(3, entries.size());

        for (EObject entry : entries) {
            if (entry.eClass().getName().equals("Author")) {
                if (entry.eGet(entry.eClass().getEStructuralFeature("name")).equals("John Doe")) {
                    johnDoe = entry;
                } else if (entry.eGet(entry.eClass().getEStructuralFeature("name")).equals("Jane Doll")) {
                    janeDoll = entry;
                }
            }
        }

    }
    
    /**
     * Since the sample code has two authors (John Doe, Jane Doll) and one article (written by John Doe),
     * the Jane Doll object should <em>not</em> contain a RevenueLedger model element. Since the article is written by John Doe,
     * the John Doe object should contain <em>one</em> RevenueLedger model element, which's revenueInEUR should be set to "John Doe".length() = 8.
     */
    @Test
    public void testForeachPredicatePropertyInits() {
        
        // According to the example, no RevenueLedger model elements should have been created for author Jane Doll.
        Collection<?> janesRevenueLedgers = (Collection<?>) janeDoll.eGet( janeDoll.eClass().getEStructuralFeature("revenues"));
        assertEquals(0, janesRevenueLedgers.size());
        
        // According to the example, only one RevenueLedger model element should have been created for author John Doe.
        Collection<?> johnsRevenueLedgers = (Collection<?>) johnDoe.eGet(johnDoe.eClass().getEStructuralFeature("revenues"));
        assertEquals(1, johnsRevenueLedgers.size());

        // According to the TCS file revenueInEUR should be set to the length of the author's name.
        EObject revenueLedger = (EObject) johnsRevenueLedgers.toArray()[0];
        int revenueInEUR = (Integer) revenueLedger.eGet(revenueLedger.eClass().getEStructuralFeature("revenueInEUR"));
        assertEquals("John Doe".length(), revenueInEUR);

    }

}
