package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.test.base.GeneratedParserBasedTest;
import com.sap.furcas.test.base.GeneratedParserTestConfiguration;
import com.sap.furcas.test.base.ParsingHelper;
import com.sap.furcas.test.base.StubModelAdapter;
import com.sap.furcas.test.base.StubModelElement;
import com.sap.furcas.test.fixture.FixtureData;

/**
 * Simple Test for the custom BibText language
 */
public class BibTextModesTest extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "BibtextModes";
    private static final File TCS = FixtureData.BIBTEXT_MODES_TCS;
    private static final File[] METAMODELS = { FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL };

    private static ParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new ParsingHelper(facade);
    }

    /**
     * Tests references are set, this protects against bugs relating to naming of classes.
     * 
     * @throws Exception
     */
    @Test
    public void testReference() throws Exception {
        String sample = "article{" + "  Testing, \"John Doe\" " + "} ;" + "author = \"John Doe\";";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);
        Set<StubModelElement> authors = stubModelHandler.getElementsbyType("BibText::Author");
        assertEquals(1, authors.size());
        StubModelElement johnDoe = authors.iterator().next();

        Set<StubModelElement> articles = stubModelHandler.getElementsbyType("BibText::Article");
        assertEquals(1, articles.size());
        StubModelElement article = articles.iterator().next();

        // now check the reference was set using the right property name
        // assertNotNull(johnDoe.get("articles")); StubModelHandler not powerful enough
        assertNotNull(article.get("author"));

        assertEquals(johnDoe, article.get("author"));
    }

    /**
	 * */
    @Test
    public void testSingleAuthor() throws Exception {
        // in this special syntax, a single author must not have a ';' in the end
        String sample = "author = \"John Doe\"";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);
        Set<StubModelElement> authors = stubModelHandler.getElementsbyType("BibText::Author");
        assertEquals(1, authors.size());

    }

    /**
     * */
    @Test
    public void testSingleArticle() throws Exception {
        // in this special syntax, a single author must not have a ';' in the end
        String sample = "article {" + "  Testing }";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);
        Set<StubModelElement> articles = stubModelHandler.getElementsbyType("BibText::Article");
        assertEquals(1, articles.size());

    }

}
