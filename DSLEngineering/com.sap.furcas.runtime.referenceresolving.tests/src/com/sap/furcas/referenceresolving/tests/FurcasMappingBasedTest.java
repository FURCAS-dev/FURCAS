package com.sap.furcas.referenceresolving.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.base.StubModelAdapter;
import com.sap.furcas.test.base.StubModelElement;
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

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        ParserFacade facade = generateParserForLanguage(testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    @Test
    public void testSample1() throws Exception {
        String sample = "article{" + "  Testing, \"John Doe\"," + "  year = \"2002\"" + "}" + "author = \"John Doe\"."
        + "author = \"Jane Doll\".";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);
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
    }

}
