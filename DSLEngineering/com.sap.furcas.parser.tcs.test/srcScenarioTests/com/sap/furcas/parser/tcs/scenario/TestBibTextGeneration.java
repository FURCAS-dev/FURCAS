package com.sap.furcas.parser.tcs.scenario;

import static com.sap.furcas.test.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.stubs.StubModelElement;
import com.sap.furcas.runtime.parser.testbase.stubs.StubParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
/**
 * Simple Test for the custom BibText language
 */
public class TestBibTextGeneration extends GeneratedParserBasedTest {

    private static final String LANGUAGE = "Bibtext";
    private static final File TCS = ScenarioFixtureData.BIBTEXT_TCS;
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };
    private static final String DSLSAMPLEDIR = "./scenarioTestSample/";

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
        String sample = "article{" + "  Testing, \"John Doe\"," + "  year = \"2002\"" + "}" + "author = \"John Doe\".";
        StubModelAdapter stubModelHandler = parsingHelper.parseString(sample, 0);
        Collection<StubModelElement> authors = stubModelHandler.getElementsOfType("BibText::Author");
        assertEquals(1, authors.size());
        StubModelElement johnDoe = authors.iterator().next();

        Collection<Object> articles = stubModelHandler.getElementsOfType(list("BibText::Article"));
        assertEquals(1, articles.size());
        StubModelElement article = (StubModelElement) articles.iterator().next();

        // now check the reference was set using the right property name
        // assertNotNull(johnDoe.get("articles")); StubModelHandler not powerful enough
        assertNotNull(article.get("author"));

        assertEquals(johnDoe, article.get("author"));
    }

    @Test
    public void testSample1() throws Exception {
        StubModelAdapter stubModelHandler = parsingHelper.parseFile("BibTextSample01.sam", DSLSAMPLEDIR, 0);

        Collection<StubModelElement> authors = stubModelHandler.getElementsOfType("BibText::Author");
        assertEquals(3, authors.size());

        Collection<StubModelElement> articles = stubModelHandler.getElementsOfType("BibText::Article");
        assertEquals(3, articles.size());
    }

    @Test
    public void testSample2() throws Exception {

        StubModelAdapter stubModelHandler = parsingHelper.parseFile("BibTextSample02.sam", DSLSAMPLEDIR, 1);

        Collection<StubModelElement> authors = stubModelHandler.getElementsOfType("BibText::Author");
        assertEquals(3, authors.size());

        Collection<StubModelElement> articles = stubModelHandler.getElementsOfType("BibText::Article");
        assertEquals(3, articles.size());
    }

    @Test
    public void testMissingElement() throws Exception {
        IModelAdapter modelAdapter = new StubModelAdapter();
        String sample = "Article";
        ModelParsingResult result = parsingHelper.parseString(sample, modelAdapter);
        assertEquals(1, result.getErrors().size());
        assertEquals(1, result.getErrors().get(0).getLine());
        assertEquals(0, result.getErrors().get(0).getPosition());
        assertEquals(1, result.getErrors().get(0).getEndLine());
        assertEquals(7, result.getErrors().get(0).getEndPosition());
    }

    @Test
    public void testBadReference() throws Exception {
        IModelAdapter modelAdapter = new StubModelAdapter();
        String sample = "article {Testing, \"Harry\", year = \"2002\"}";
        ModelParsingResult result = parsingHelper.parseString(sample, modelAdapter);
        assertEquals(1, result.getErrors().size());
        assertEquals(1, result.getErrors().get(0).getLine());
        assertEquals(18, result.getErrors().get(0).getPosition());
        assertEquals(1, result.getErrors().get(0).getEndLine());
        assertEquals(25, result.getErrors().get(0).getEndPosition());
    }

    @Test
    public void testbadKeyword() throws Exception {
        IModelAdapter modelAdapter = new StubModelAdapter();
        String sample = "article22 {)}";
        ModelParsingResult result = parsingHelper.parseString(sample, modelAdapter);
        assertEquals(2, result.getErrors().size());
        assertEquals(1, result.getErrors().get(0).getLine());
        assertEquals(11, result.getErrors().get(0).getPosition());
        assertEquals(1, result.getErrors().get(0).getEndLine());
        assertEquals(11, result.getErrors().get(0).getEndPosition());
    }
}
