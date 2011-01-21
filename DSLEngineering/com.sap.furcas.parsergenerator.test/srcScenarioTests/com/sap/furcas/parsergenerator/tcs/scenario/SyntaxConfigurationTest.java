package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationPackage;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.ConfigurationImpl;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

public class SyntaxConfigurationTest extends GeneratedParserBasedTest {
	private static final String LANGUAGE = "SyntaxConfiguration";
	private static final File TCS = ScenarioFixtureData.SYNTAX_CONFIGURATION_TCS;
	private static final File[] METAMODELS = {
			ScenarioFixtureData.INTERFACE_CONFIGURATION_METAMODEL,
			ScenarioFixtureData.TCS_METAMODEL };
	private Template template;
	private static ParsingHelper parsingHelper;

	@BeforeClass
	public static void setupParser() throws Exception {
		GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(
				LANGUAGE, TCS, METAMODELS);
		TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
		ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig,
				new ClassLookupImpl());
		parsingHelper = new ParsingHelper(facade);

	}

	/**
	 * test syntax errors cause parsing errors
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSampleDirect() throws Exception {

		// first parse the provided syntaxes
		String providingLanguage = "BibtextImported";
		File providingTCS = ScenarioFixtureData.BIBTEXT_IMPORTED_TCS;
		File[] providingMetamodels = { ScenarioFixtureData.BIBTEXT_METAMODEL,
				ScenarioFixtureData.BIBTEXT1_METAMODEL, ScenarioFixtureData.INTERFACE_CONFIGURATION_METAMODEL,
				ScenarioFixtureData.TCS_METAMODEL  };
		GeneratedParserTestConfiguration testConfigProviding = new GeneratedParserTestConfiguration(
				providingLanguage, providingTCS, providingMetamodels);
		TCSSyntaxContainerBean syntaxBeanProviding = parseSyntax(testConfigProviding);
		// than parse the required syntaxes
		String requireingLanguage = "BibtextInterfaceTest";
		File requireingTCS = ScenarioFixtureData.BIBTEXT_INTERFACE_TCS;

		File[] requireingMetamodels = { ScenarioFixtureData.BIBTEXT_METAMODEL,
				ScenarioFixtureData.BIBTEXT1_METAMODEL };

		GeneratedParserTestConfiguration testConfigRequireing = new GeneratedParserTestConfiguration(
				requireingLanguage, requireingTCS, requireingMetamodels);
		TCSSyntaxContainerBean syntaxBeanRequireing = parseSyntax(testConfigRequireing);

		testConfigRequireing
				.getSourceConfiguration()
				.getResourceSet()
				.getResources()
				.addAll(testConfigProviding.getSourceConfiguration()
						.getResourceSet().getResources());

		// test the specification of the interface definition
		String sample = "Configuration Test{bind BibtextInterfaceTest:BibTextEntry to BibtextImported:BibTextEntry;}";
		ModelParsingResult result = parsingHelper.parseString(sample,
				new DefaultTextAwareModelAdapter(new EMFModelAdapter(
						InterfaceconfigurationPackage.eINSTANCE,
						testConfigRequireing.getSourceConfiguration()
								.getResourceSet(), new HashSet())));

		// ensure syntaxes have been correctly found
		ConfigurationImpl configuration = (ConfigurationImpl) result
				.getParsedModelElement();
		assertEquals(syntaxBeanRequireing.getSyntax(), configuration.getBindings().iterator()
				.next().getRequireingSyntax());
		assertEquals(syntaxBeanProviding.getSyntax(), configuration.getBindings().iterator()
				.next().getProvidingSyntax());

		// check template has been correctly found
		assertEquals(syntaxBeanRequireing.getSyntax().getRequiredTemplates()
				.iterator().next(), configuration.getBindings().iterator().next()
				.getRequiredTemplate());

		for (Template temp : syntaxBeanProviding.getSyntax().getTemplates()) {
			if (temp.getMetaReference()
					.getName()
					.equalsIgnoreCase(
							syntaxBeanRequireing.getSyntax()
									.getRequiredTemplates().iterator().next()
									.getMetaReference().getName())) {
				template = temp;
				break;
			}
		}
		assertEquals(template, configuration.getBindings().iterator().next().getProvidedTemplate());

	}
}
