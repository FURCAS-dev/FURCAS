/**
 * to test the import of the complete concrete syntax OCL.tcs in TCS.tcs 
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

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.ModularisedGeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.runtime.parser.testbase.StubModelElement;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

public class TCSImportsOCL_ConcreteSyntax extends GeneratedParserBasedTest {
	private static final String LANGUAGE = "TCSImportsOCLConcreteSyntax";
	private static final List<File> LANGUAGE2 = new ArrayList<File>();

	private static final File TCS = ScenarioFixtureData.TCS_IMPORTS_OCL_CONCRETE_SYNTAX_TCS;
	private static final File TCS1 = ScenarioFixtureData.OCL_TO_IMPORT_TCS;
	private static final File[] METAMODELS = {
			ScenarioFixtureData.TCS_WITH_OCL_METAMODEL,
			ScenarioFixtureData.OCL_METAMODEL,
			ScenarioFixtureData.OCL_ECORE_METAMODEL,
			ScenarioFixtureData.TEXTBLOCKS,
			ScenarioFixtureData.TEXTBLOCKDEFINITION };
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
		testConfig
				.addAdditionalClassPath("../../EMF/mdt/plugins/org.eclipse.ocl/bin");
		List<TCSSyntaxContainerBean> syntaxBean = modularParseSyntax(testConfig);
		for (TCSSyntaxContainerBean tcsSyntaxContainerBean : syntaxBean) {
			if (tcsSyntaxContainerBean.getSyntax().getName()
					.equalsIgnoreCase("TCSImportsOCLConcreteSyntax")) {
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
		String sample = "syntax mySyntax {\n"
				+ "  template ->ExpressionList main\n"
				+ "    : ->elements {query = let a : EInt = 1 in a }\n"
				+ "    ; \n" + "  \n" + "}";

		StubModelAdapter stubModelAdapter = new StubModelAdapter();
		stubModelAdapter.queryResult = EcorePackage.eINSTANCE.getEInt();
		ModelParsingResult result = parsingHelper.parseString(sample,
				stubModelAdapter);
		assertEquals("TCSWithOCL::ConcreteSyntax",
				((StubModelElement) result.getParsedModelElement()).type
						.toString());
		assertEquals("mySyntax",
				((StubModelElement) result.getParsedModelElement()).get("name")
						.toString());
		assertEquals("TCSWithOCL::ClassTemplate",
				((StubModelElement) ((StubModelElement) result
						.getParsedModelElement()).get("templates")).type
						.toString());
		assertEquals("ExpressionList",
				((StubModelElement) ((StubModelElement) result
						.getParsedModelElement()).get("templates"))
						.get("names"));
		assertEquals(
				"TCSWithOCL::Sequence",
				((StubModelElement) ((StubModelElement) ((StubModelElement) result
						.getParsedModelElement()).get("templates"))
						.get("templateSequence")).type.toString());
		
		assertEquals(1, stubModelAdapter.getElementsbyType("TCSWithOCL::Property").size());
		assertEquals(1, stubModelAdapter.getElementsbyType("TCSWithOCL::QueryPArg").size());
		assertEquals(1, stubModelAdapter.getElementsbyType("ocl::ecore2::LetExp").size());
		assertEquals(1, stubModelAdapter.getElementsbyType("ocl::ecore2::Variable").size());
		assertEquals(1, stubModelAdapter.getElementsbyType("ocl::ecore2::VariableExp").size());
		assertEquals(1, stubModelAdapter.getElementsbyType("ocl::ecore2::IntegerLiteralExp").size()); 
	
	}

}
