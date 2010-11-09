package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.modeladaptation.emf.EMFModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Base class for test cases that use a FURCAS mapping specification (".tcs" file) and based on this
 * produce lexer and parser, then parse a text resource and register all reference resolving callbacks.
 * Then, the tests can start to manipulate the model produced by the parser run and observe how
 * OCL-based property assignments get re-assigned.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class FurcasMappingBasedTest extends GeneratedParserBasedTest {
    private static final String LANGUAGE = "BibtexWithPropertyInits";
    private static final File TCS = new File("fixtures/BibtexWithPropertyInits.tcs");

    private static final File[] METAMODELS = { FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL };
    
    private static ParsingHelper parsingHelper;
	private static ResourceSet resourceSet;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        ParserFacade facade = generateParserForLanguage(testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {
        String sample = "article{" + "  Testing, \"John Doe\"," + "  year = \"2002\"" + "}" + "author = \"John Doe\"."
        + "author = \"Jane Doll\".";
        Set<URI> referenceScope = Collections.emptySet();
        EPackage ePackage = findPackage("BibText");
    	EMFModelAdapter handler = new EMFModelAdapter(ePackage, new ResourceSetImpl(), referenceScope);
    	DefaultTextAwareModelAdapter handlerWrapper = new DefaultTextAwareModelAdapter(handler);

        ModelParsingResult parsingResult = parsingHelper.parseString(sample, handlerWrapper);
        EObject bibTexFile = (EObject) parsingResult.getParsedModelElement();
        assertNotNull(bibTexFile);
        /*
        Set<StubModelElement> authors = stubModelHandler.getElementsbyType("BibText::Author");
        assertEquals(2, authors.size());
        StubModelElement johnDoe = null;
        for (StubModelElement author : authors) {
        	if (author.get("name").equals("John Doe")) {
        		johnDoe = author;
        	}
        }
        assertNotNull(johnDoe);
        Set<StubModelElement> articles = stubModelHandler.getElementsbyType("BibText::Article");
        assertEquals(1, articles.size());
        StubModelElement article = articles.iterator().next();

        // now check the reference was set using the right property name
        // assertNotNull(johnDoe.get("articles")); StubModelHandler not powerful enough
        assertNotNull(article.get("author"));
        assertEquals(johnDoe, article.get("author"));
        // assertEquals("somewhere", article.get("location"));
         */
    }

    /**
     * Finds an EPackage in the {@link #resourceSet} by the <code>name</code> specified 
     */
	private EPackage findPackage(String name) {
		for (Resource r : resourceSet.getResources()) {
			for (EObject c : r.getContents()) {
				if (c instanceof EPackage && ((EPackage) c).getName().equals(name)) {
					return (EPackage) c;
				}
			}
		}
		return null;
	}

}
