package com.sap.ide.cts.editor.contentassist.processor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.mi.textual.common.exceptions.GrammarGenerationException;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;

public class TestCtsContentAssistProcessorEnumerationSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		generateParserForLanguage("Enumeration");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException {
		initProcessorForFixture("Simple" + "." + getLanguage(), getFacade(),
				getLanguage(), CtsContentAssistProcessorTestBase.class
						.getResourceAsStream("../fixtures/syntax/"
								+ getLanguage() + ".tcs"));
	}

	@Test
	public void allEnumerationOptions() {
		List<String> expected = new ArrayList<String>();
		expected.add("a_workaholic");
		expected.add("type");
		expected.add("very_lazy");
		expected.add("very_studious");

		assertDisplayStrings(expected, 0, 17);
	}

	@Test
	public void middleOfEnumerationOption() {
		List<String> expected = new ArrayList<String>();
		expected.add("very_lazy");
		expected.add("very_studious");

		assertDisplayStrings(expected, 0, 19);
	}
}
