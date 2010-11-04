package com.sap.ide.cts.editor.contentassist.processor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.ide.cts.editor.test.util.StringReplacement;

public class TestCtsContentAssistProcessorBug1976 extends
		CtsContentAssistProcessorTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		// use only default metamodel PRIs
		initMetamodelId("");
		generateParserForLanguage("Bug1976");
		generateParserFactoryForLanguage(getLanguage(),
				"com.sap.tc.moin.repository.mmi.model.ModelPackage",
				"com.sap.tc.moin.libraries.api");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException,
			UnknownProductionRuleException, InstantiationException,
			IllegalAccessException {
		initProcessorForFixture("Fixture" + "." + getLanguage(),
				new StringReplacement(3, 1, "as"),
				CtsContentAssistProcessorTestBase.class
						.getResourceAsStream("../fixtures/syntax/"
								+ getLanguage() + ".tcs"));
	}

	@Test
	public void afterAs() {
		List<String> expected = new ArrayList<String>();
		expected.add("association");
		expected.add("association name { ; }");

		assertDisplayStrings(expected, 3, 3);
	}
}
