package com.sap.furcas.parser.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelElement;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

/**
 * Simple Test for the custom BibText language, using a syntax variant with function templates
 */
public class TestBibTextWithFunction extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "BibtextWithFunction";
    private static final File TCS = ScenarioFixtureData.BIBTEXT_WITH_FUNCTION_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };

    private static StubParsingHelper parsingHelper;

    @BeforeClass
    public static void setupParser() throws Exception {
        GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(LANGUAGE, TCS, METAMODELS);
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig, new ClassLookupImpl());
        parsingHelper = new StubParsingHelper(facade);
    }

    /**
     * Tests references are set, this protects against bugs relating to naming of classes.
     * 
     * @throws Exception
     */
    @Test
    public void testReferences() throws Exception {
        String sample = "article{" + "  Testing, \"John Doe\"," + "  year = \"2002\"" + "}" + "author = testKey, \"John Doe\".";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);
        Collection<StubModelElement> authors = stubModelHandler.getElementsOfType("BibText::Author");
        assertEquals(1, authors.size());
        StubModelElement johnDoe = authors.iterator().next();

        Collection<StubModelElement> articles = stubModelHandler.getElementsOfType("BibText::Article");
        assertEquals(1, articles.size());
        StubModelElement article = articles.iterator().next();

        // now check the reference was set using the right property name
        // assertNotNull(johnDoe.get("articles")); StubModelHandler not powerful enough
        assertNotNull(article.get("author"));

        assertEquals(johnDoe, article.get("author"));

        assertEquals("testKey", johnDoe.get("key"));
        assertEquals("Testing", article.get("key"));
    }

}
