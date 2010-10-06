package com.sap.ide.cts.editor.contentassist.processor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.textual.common.exceptions.GrammarGenerationException;
import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;

public class TestCtsContentAssistProcessorQueryAndRefersToSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("QueryAndRefersTo");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException,
			UnknownProductionRuleException, InstantiationException,
			IllegalAccessException {
		initProcessorForPrefix("Simple");
	}

	@Test
	public void beginningOfBook() {
		List<String> expected = new ArrayList<String>();
		expected.add("title");
		expected.add("title by author");
		expected.add("}");

		assertDisplayStrings(expected, 3, 0);
	}

	@Test
	public void insideBookBeginningOfAuthor() {
		List<String> expected = new ArrayList<String>();
		expected.add("author");
		expected.add("hegel");

		// only hegel should return from query

		assertDisplayStrings(expected, 3, 11);
	}

	@Test
	public void insideBookInsideAuthor() {
		List<String> expected = new ArrayList<String>();
		expected.add("hegel");

		assertDisplayStrings(expected, 3, 13);
	}
}
