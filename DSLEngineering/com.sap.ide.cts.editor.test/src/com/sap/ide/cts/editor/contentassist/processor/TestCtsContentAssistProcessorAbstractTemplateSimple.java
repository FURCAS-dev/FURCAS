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

public class TestCtsContentAssistProcessorAbstractTemplateSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("AbstractTemplate");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException,
			UnknownProductionRuleException, InstantiationException,
			IllegalAccessException {
		initProcessorForPrefix("Simple");
	}

	@Test
	public void beginningOfLine() {
		List<String> expected = new ArrayList<String>();
		expected.add("employee");
		expected.add("employee nickname");
		expected.add("manager");
		expected.add("manager num_employees");

		assertDisplayStrings(expected, 3, 0);
	}

	@Test
	public void inManagerEntryKeyword() {
		List<String> expected = new ArrayList<String>();
		expected.add("manager");
		expected.add("manager num_employees");

		assertDisplayStrings(expected, 3, 3);
	}

	@Test
	public void inManagerEntryBeforeProperty() {
		List<String> expected = new ArrayList<String>();
		expected.add("num_employees");

		assertDisplayStrings(expected, 3, 8);
	}

	@Test
	public void inEmployeeEntryKeyword() {
		List<String> expected = new ArrayList<String>();
		expected.add("employee");
		expected.add("employee nickname");

		assertDisplayStrings(expected, 4, 1);
	}

	@Test
	public void inEmployeeEntryBeforeProperty() {
		List<String> expected = new ArrayList<String>();
		expected.add("nickname");

		assertDisplayStrings(expected, 4, 9);
	}

	@Test
	public void inEmployeeEntryInProperty() {
		List<String> expected = new ArrayList<String>();

		assertDisplayStrings(expected, 4, 11);
	}
}
