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

public class TestCtsContentAssistProcessorForcedUpperPargSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		generateParserForLanguage("ForcedUpperParg");
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
	public void beginningOfFile() {
		List<String> expected = new ArrayList<String>();
		expected.add("library");
		expected.add("library { author }");

		assertDisplayStrings(expected, 0, 0);
	}

	@Test
	public void atForcedUpperProperty() {
		List<String> expected = new ArrayList<String>();
		expected.add("name");
		expected.add("}");

		assertDisplayStrings(expected, 0, 17);
	}

	@Test
	public void afterForcedUpperProperty() {
		List<String> expected = new ArrayList<String>();
		// should not list name again
		expected.add("}");

		assertDisplayStrings(expected, 0, 23);
	}
}
