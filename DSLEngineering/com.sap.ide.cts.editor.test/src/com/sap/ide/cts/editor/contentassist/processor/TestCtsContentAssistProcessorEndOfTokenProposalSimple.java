package com.sap.ide.cts.editor.contentassist.processor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.runtime.common.exceptions.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;

public class TestCtsContentAssistProcessorEndOfTokenProposalSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("EndOfTokenProposal");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException,
			UnknownProductionRuleException, InstantiationException,
			IllegalAccessException {
		initProcessorForPrefix("Simple");
	}

	@Test
	public void beforeStudentToken() {
		List<String> expected = new ArrayList<String>();
		expected.add("student");
		expected.add("student { name }");

		assertDisplayStrings(expected, 0, 0);
	}

	@Test
	public void inStudentToken() {
		List<String> expected = new ArrayList<String>();
		expected.add("student");
		expected.add("student { name }");

		assertDisplayStrings(expected, 0, 4);
	}

	@Test
	public void atEndOfStudentToken() {
		List<String> expected = new ArrayList<String>();
		expected.add("{");

		assertDisplayStrings(expected, 0, 7);
	}

	@Test
	public void atEndOfBracketToken() {
		List<String> expected = new ArrayList<String>();
		// prefix-filtered tokens should always be at the top
		expected.add("{");
		expected.add("name");

		assertDisplayStrings(expected, 0, 8);
	}

	@Test
	public void atEndOfJonesToken() {
		List<String> expected = new ArrayList<String>();
		expected.add("}");

		assertDisplayStrings(expected, 0, 14);
	}
}
