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

public class TestCtsContentAssistProcessorUnlexedTokenPrefixFilterSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		generateParserForLanguage("UnlexedTokenPrefixFilter");
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
		expected.add("*(?=|");
		expected.add("*(?=| name !!!");
		expected.add("*(?=| name $$$");

		assertDisplayStrings(expected, 0, 0);
	}

	@Test
	public void beforeNonIdentifierToken() {
		List<String> expected = new ArrayList<String>();
		expected.add("!!!");
		expected.add("$$$");

		assertDisplayStrings(expected, 0, 12);
	}

	@Test
	public void middleOfNonIdentifierToken() {
		List<String> expected = new ArrayList<String>();
		expected.add("$$$");

		assertDisplayStrings(expected, 0, 13);
	}
}
