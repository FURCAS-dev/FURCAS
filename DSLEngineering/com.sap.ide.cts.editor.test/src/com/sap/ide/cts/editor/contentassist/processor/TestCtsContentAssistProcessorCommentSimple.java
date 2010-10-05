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

public class TestCtsContentAssistProcessorCommentSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("Comment");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException,
			UnknownProductionRuleException, InstantiationException,
			IllegalAccessException {
		initProcessorForPrefix("Simple");
	}

	@Test
	public void beforeFirstTokenInComment() {
		List<String> expected = new ArrayList<String>();
		// no proposals in comment

		assertDisplayStrings(expected, 0, 3);
	}

	@Test
	public void beforeFirstTokenInWhitespace() {
		List<String> expected = new ArrayList<String>();
		expected.add("student");
		expected.add("student name");

		assertDisplayStrings(expected, 1, 1);
	}

	@Test
	public void beforeFirstTokenAfterWhitespace() {
		List<String> expected = new ArrayList<String>();
		expected.add("student");
		expected.add("student name");

		assertDisplayStrings(expected, 1, 3);
	}

	@Test
	public void beforeSecondComment() {
		List<String> expected = new ArrayList<String>();
		expected.add("name");

		assertDisplayStrings(expected, 1, 12);
	}

	@Test
	public void inSecondComment() {
		List<String> expected = new ArrayList<String>();
		// no proposal in comment line

		assertDisplayStrings(expected, 1, 15);
	}

	@Test
	public void beforeSecondKeyword() {
		List<String> expected = new ArrayList<String>();
		expected.add("name");

		assertDisplayStrings(expected, 2, 3);
	}
}
