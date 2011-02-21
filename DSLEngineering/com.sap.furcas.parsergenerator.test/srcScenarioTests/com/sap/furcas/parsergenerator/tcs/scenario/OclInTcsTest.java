/**
 * to test the interface specification of template OCLExpression of OCL.tcs in TCS.tcs 
 * @author siani christian
 *
 */
package com.sap.furcas.parsergenerator.tcs.scenario;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EcorePackage;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBeanWithConfig;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestWithConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.StubModelElement;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

public class OclInTcsTest extends GeneratedParserBasedTest {

	private static ParsingHelper parsingHelper;
	private static final String DEFAULT_GENERATIONDIR_SOURCEROOT = "./generationTemp";
	private static final String DEFAULT_PACKAGE = "generated";
	private static final String DEFAULT_GENERATIONDIR = DEFAULT_GENERATIONDIR_SOURCEROOT
			+ "/" + DEFAULT_PACKAGE + "/";

	private static List<File> tcsFiles = new ArrayList<File>();

	private static final File CONFIG_TCS_WITH_OCL = ScenarioFixtureData.CONFIG_TCS_WITH_OCL;
	private static final File[] METAMODELS = {
			ScenarioFixtureData.INTERFACE_CONFIGURATION_METAMODEL,
			ScenarioFixtureData.TCS_WITH_OCL_METAMODEL,
			ScenarioFixtureData.OCL_METAMODEL,
			ScenarioFixtureData.OCL_ECORE_METAMODEL,
			ScenarioFixtureData.TEXTBLOCKS,
			ScenarioFixtureData.TEXTBLOCKDEFINITION };

	private static final File providingTCS = ScenarioFixtureData.TCS_WITH_OCL_TCS;
	private static final String requireingLanguage = "TCSWithOCL";
	private static final File requireingTCS = ScenarioFixtureData.OCL_TO_IMPORT_TCS;

	@BeforeClass
	public static void setupParser() throws Exception {

		tcsFiles.add(providingTCS);
		tcsFiles.add(requireingTCS);

		GeneratedParserTestWithConfiguration config = new GeneratedParserTestWithConfiguration(
				requireingLanguage, CONFIG_TCS_WITH_OCL, DEFAULT_GENERATIONDIR,
				DEFAULT_PACKAGE, METAMODELS, tcsFiles);
		config
		.addAdditionalClassPath("../../EMF/mdt/plugins/org.eclipse.ocl/bin");

		TCSSyntaxContainerBeanWithConfig syntaxBeanWithConfiguration = parse(config);

		ParserFacade facade = generateParserForLanguageWithConfig(
				syntaxBeanWithConfiguration, config, new ClassLookupImpl());
		parsingHelper = new ParsingHelper(facade);
	}

	@Test
	public void testSample1() throws Exception {
		String sample = "syntax mySyntax {\n"
				+ "  template ->ExpressionList main\n"
				+ "    : ->elements{query = let a : EInt = 1 in a }\n"
				+ "    ;\n" + "    \n" + "}";


	StubModelAdapter stubModelAdapter = new StubModelAdapter();
	stubModelAdapter.queryResult = EcorePackage.eINSTANCE.getEInt();
	ModelParsingResult result = parsingHelper.parseString(sample,
			stubModelAdapter);
	assertEquals("TCSWithOCL::ConcreteSyntax",
			((StubModelElement) result.getParsedModelElement()).type.toString());
	assertEquals("mySyntax",
			((StubModelElement) result.getParsedModelElement()).get("name").toString());
	assertEquals("TCSWithOCL::ClassTemplate",
			((StubModelElement)((StubModelElement) result.getParsedModelElement()).get("templates")).type.toString());
	assertEquals("ExpressionList",
			((StubModelElement)((StubModelElement) result.getParsedModelElement()).get("templates")).get("names"));
	assertEquals("TCSWithOCL::Sequence",
			((StubModelElement)((StubModelElement)((StubModelElement) result.getParsedModelElement()).get("templates")).get("templateSequence")).type.toString());
	assertEquals(1, stubModelAdapter.getElementsbyType("TCSWithOCL::Property").size());
	assertEquals(1, stubModelAdapter.getElementsbyType("TCSWithOCL::QueryPArg").size());
	assertEquals(1, stubModelAdapter.getElementsbyType("ocl::ecore2::LetExp").size());
	assertEquals(1, stubModelAdapter.getElementsbyType("ocl::ecore2::Variable").size());
	assertEquals(1, stubModelAdapter.getElementsbyType("ocl::ecore2::VariableExp").size());
	assertEquals(1, stubModelAdapter.getElementsbyType("ocl::ecore2::IntegerLiteralExp").size());
	}
}
