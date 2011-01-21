package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBeanWithConfig;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestWithConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.StubModelElement;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

public class CompleteInterfaceTest extends GeneratedParserBasedTest {
	private static ParsingHelper parsingHelper;
	private static final String DEFAULT_GENERATIONDIR_SOURCEROOT = "./generationTemp";
	private static final String DEFAULT_PACKAGE = "generated";
	private static final String DEFAULT_GENERATIONDIR = DEFAULT_GENERATIONDIR_SOURCEROOT
			+ "/" + DEFAULT_PACKAGE + "/";
	
	private static  List<File> tcsFiles = new ArrayList<File>();
	
	private static final File CONFIG = ScenarioFixtureData.CONFIGURATION_TCS;
	private static final File[] METAMODELS = {
			ScenarioFixtureData.INTERFACE_CONFIGURATION_METAMODEL,
			ScenarioFixtureData.TCS_METAMODEL,
			ScenarioFixtureData.BIBTEXT_METAMODEL,
			ScenarioFixtureData.BIBTEXT1_METAMODEL };

	private static final File providingTCS = ScenarioFixtureData.BIBTEXT_IMPORTED_TCS;
	private static final String requireingLanguage = "BibtextInterfaceTest";
	private static final File requireingTCS = ScenarioFixtureData.BIBTEXT_INTERFACE_TCS;
	
	@BeforeClass
	public static void setupParser() throws Exception {
		
		tcsFiles.add(providingTCS);
		tcsFiles.add(requireingTCS);

		GeneratedParserTestWithConfiguration config = new GeneratedParserTestWithConfiguration(
				requireingLanguage, CONFIG,DEFAULT_GENERATIONDIR, DEFAULT_PACKAGE, METAMODELS, tcsFiles);
		
		TCSSyntaxContainerBeanWithConfig syntaxBeanWithConfiguration = parse(config);

		ParserFacade facade = generateParserForLanguageWithConfig(syntaxBeanWithConfiguration,
				config, new ClassLookupImpl());
		parsingHelper = new ParsingHelper(facade);
	}

	@Test
	public void testReference() throws Exception {
		String sample = "article{" + "  Testing, \"John Doe\","
				+ "  year = \"2002\"" + "}" + "author = \"John Doe\".";

		StubModelAdapter stubModelHandler = parsingHelper
				.parseString(sample, 0);
		Set<StubModelElement> authors = stubModelHandler
				.getElementsbyType("BibText::Author");
		assertEquals(1, authors.size());
		StubModelElement johnDoe = authors.iterator().next();

		Set<StubModelElement> articles = stubModelHandler
				.getElementsbyType("BibText::Article");
		assertEquals(1, articles.size());
		StubModelElement article = articles.iterator().next();

		Set<StubModelElement> year = stubModelHandler
				.getElementsbyType("BibText::Year");
		assertEquals(1, year.size());
		StubModelElement year2002 = year.iterator().next();

		// now check the reference was set using the right property name
		// assertNotNull(johnDoe.get("articles")); StubModelHandler not powerful
		// enough
		assertNotNull(article.get("author"));

		assertEquals(johnDoe, article.get("author"));

		// check the imported property year was really set(here with attributes)
		assertNotNull(article.get("attributes"));

		assertEquals(year2002, article.get("attributes"));

	}

}
