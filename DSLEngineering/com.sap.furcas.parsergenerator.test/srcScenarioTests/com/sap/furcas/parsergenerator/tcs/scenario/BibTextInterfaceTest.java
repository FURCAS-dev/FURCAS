package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.RequiredInterfaceTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationFactory;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.InterfaceconfigurationPackageImpl;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBeanWithConfig;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.ModularisedGeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.StubModelElement;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

public class BibTextInterfaceTest extends GeneratedParserBasedTest {

	private static final String LANGUAGE = "BibtextInterfaceTest";
	private static final List<File> LANGUAGE2 = new ArrayList<File>();

	private static final File TCS = ScenarioFixtureData.BIBTEXT_INTERFACE_TCS;
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
	private static TCSSyntaxContainerBean syntaxBean2;
	private static Template template;

	@BeforeClass
	public static void setupParser() throws Exception {
		LANGUAGE2.add(TCS1);
		
		ModularisedGeneratedParserTestConfiguration testConfig = new ModularisedGeneratedParserTestConfiguration(
				LANGUAGE, TCS, DEFAULT_GENERATIONDIR, DEFAULT_PACKAGE,
				METAMODELS, LANGUAGE2);
		
		List<TCSSyntaxContainerBean> syntaxBean = modularParseSyntax(testConfig);
		
		for (TCSSyntaxContainerBean tcsSyntaxContainerBean : syntaxBean) {
			if (tcsSyntaxContainerBean.getSyntax().getName()
					.equalsIgnoreCase("BibtextInterfaceTest")) {
				syntaxBean1 = tcsSyntaxContainerBean;
			}
			if (tcsSyntaxContainerBean.getSyntax().getName()
					.equalsIgnoreCase("BibtextImported")) {
				syntaxBean2 = tcsSyntaxContainerBean;
			}
		}

		Collection<Template> templateList = new ArrayList<Template>();
		templateList.addAll(syntaxBean2.getSyntax().getTemplates());

		for (Template interfaceTemplate : templateList) {
			if (interfaceTemplate
					.getMetaReference()
					.getName()
					.equalsIgnoreCase(
							((RequiredInterfaceTemplate) syntaxBean1
									.getSyntax().getRequiredTemplates().get(0))
									.getMetaReference().getName())) {
				template = interfaceTemplate;
				break;
			}
		}

		Configuration configure = getConfigurationOfInterface(
				syntaxBean1.getSyntax(), syntaxBean2.getSyntax(), template,
				syntaxBean1.getSyntax().getRequiredTemplates().get(0));
		
		TCSSyntaxContainerBeanWithConfig syntaxBeanWithConfig = new TCSSyntaxContainerBeanWithConfig();
		syntaxBeanWithConfig.setElementToLocationMap(syntaxBean1
				.getElementToLocationMap());
		syntaxBeanWithConfig.setKeywords(syntaxBean1.getKeywords());
		syntaxBeanWithConfig.setSyntax(syntaxBean1.getSyntax());
		syntaxBeanWithConfig.setConfiguration(configure);
		
		ParserFacade facade = generateParserForLanguageWithConfig(
				syntaxBeanWithConfig, testConfig, new ClassLookupImpl());
		parsingHelper = new ParsingHelper(facade);

	}

	/*
	 * to get the Configuration from the TCS data
	 * 
	 * @return the configuration specified from the configuration data
	 */
	public static Configuration getConfigurationOfInterface(
			ConcreteSyntax providingSyntax, ConcreteSyntax requireingSyntax,
			Template providedTemplate,
			RequiredInterfaceTemplate requiredTemplate) {
//		InterfaceconfigurationPackageImpl.init();
		InterfaceconfigurationFactory factory = InterfaceconfigurationFactory.eINSTANCE;
		Configuration configuration = factory.createConfiguration();
		configuration.setName("test");
		Binding binding = factory.createBinding();
		binding.setMode(null);
		binding.setProvidingSyntax(providingSyntax);
		binding.setProvidedTemplate(providedTemplate);
		binding.setRequireingSyntax(requireingSyntax);
		binding.setRequiredTemplate(requiredTemplate);
		configuration.getBindings().add(binding);

		return configuration;
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
