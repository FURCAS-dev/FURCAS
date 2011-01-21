package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.ModularisedGeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.StubModelElement;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

public class BibTextRecursiveImport extends GeneratedParserBasedTest {
	private static final String LANGUAGE = "BibtextRecursiveImport";
	private static final List<File> LANGUAGE2 = new ArrayList<File>();

	private static final File TCS = ScenarioFixtureData.BIBTEXT_RECURSIVE_IMPORT_TCS;
	private static final File TCS1 = ScenarioFixtureData.BIBTEXT_IMPORTED_TCS;
	private static final File[] METAMODELS = {
			ScenarioFixtureData.BIBTEXT_METAMODEL,
			ScenarioFixtureData.BIBTEXT1_METAMODEL };
	private static ParsingHelper parsingHelper;
	private static final String DEFAULT_GENERATIONDIR_SOURCEROOT = "./generationTemp";
	private static final String DEFAULT_PACKAGE = "generated";
	private static final String DEFAULT_GENERATIONDIR = DEFAULT_GENERATIONDIR_SOURCEROOT
			+ "/" + DEFAULT_PACKAGE + "/";
	private static TCSSyntaxContainerBean syntaxBean1;

	@BeforeClass
	public static void setupParser() throws Exception {
		LANGUAGE2.add(TCS1);
		ModularisedGeneratedParserTestConfiguration testConfig = new ModularisedGeneratedParserTestConfiguration(
				LANGUAGE, TCS, DEFAULT_GENERATIONDIR, DEFAULT_PACKAGE,
				METAMODELS, LANGUAGE2);
		List<TCSSyntaxContainerBean> syntaxBean = modularParseSyntax(testConfig);
		for (TCSSyntaxContainerBean tcsSyntaxContainerBean : syntaxBean) {
			if (tcsSyntaxContainerBean.getSyntax().getName()
					.equalsIgnoreCase("BibtextRecursiveImport")) {
				syntaxBean1 = tcsSyntaxContainerBean;
			}
		}
		ParserFacade facade = generateParserForLanguage(syntaxBean1,
				testConfig, new ClassLookupImpl());
		parsingHelper = new ParsingHelper(facade);

	}

	/**
	 * Tests references are set, this protects against bugs relating to naming
	 * of classes.
	 * 
	 * @throws Exception
	 */
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
