package com.sap.furcas.parsergenerator.tcs.scenario;

import java.io.File;

import org.eclipse.emf.ecore.EcorePackage;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.parser.testbase.ParsingHelper;
import com.sap.furcas.runtime.parser.testbase.StubModelAdapter;
import com.sap.furcas.test.fixture.ScenarioFixtureData;

public class OCLNewTest extends GeneratedParserBasedTest {

	private static final String LANGUAGE = "OCL";
	private static final File TCS = ScenarioFixtureData.OCL_TCS;
	private static final File[] METAMODELS = {
			ScenarioFixtureData.OCL_METAMODEL,
			ScenarioFixtureData.OCL_ECORE_METAMODEL };

	private static ParsingHelper parsingHelper;

	@BeforeClass
	public static void setupParser() throws Exception {
		GeneratedParserTestConfiguration testConfig = new GeneratedParserTestConfiguration(
				LANGUAGE, TCS, METAMODELS);
		testConfig
				.addAdditionalClassPath("../../EMF/mdt/plugins/org.eclipse.ocl/bin");
		TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
		ParserFacade facade = generateParserForLanguage(syntaxBean, testConfig,
				new ClassLookupImpl());
		parsingHelper = new ParsingHelper(facade);
	}

	@Test
	public void testAcceptSample1() throws Exception {
		String sample = "self.articles->forAll(p1, p2 | true)";
		String sample1 = "Class.allInstances()->collect(e|true)";
		String sample2 = "let a : EInt = 1 in a";
		StubModelAdapter stubModelAdapter = new StubModelAdapter();
		stubModelAdapter.queryResult = EcorePackage.eINSTANCE.getEInt();
		ModelParsingResult result = parsingHelper.parseString(sample2, stubModelAdapter);
//		StubModelAdapter stubModelHandler2 = parsingHelper.parseString(sample2,
//				0);
		// parsingHelper.parseString("self.vertices->forAll(p1, p2 |\r\n" +
		// "(p1.x = p2.x and p1.y = p2.y) implies p1 = p2)", 0);
		// parsingHelper.parseString("Student.allInstances->forAll( p1, p2 | p1 <> p2 implies p1.name <> p2.name )",
		// 0);
		// parsingHelper.parseString("Class.allInstances()->collect(e|e.name)",
		// 0);
		// parsingHelper.parseString("let a : Integer = 1 in a + 1", 0);
	}

}
