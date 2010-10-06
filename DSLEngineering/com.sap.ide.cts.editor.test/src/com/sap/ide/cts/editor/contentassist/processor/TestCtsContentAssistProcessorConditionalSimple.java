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

public class TestCtsContentAssistProcessorConditionalSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("Conditional");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException,
			UnknownProductionRuleException, InstantiationException,
			IllegalAccessException {
		initProcessorForPrefix("Simple");
	}

	@Test
	public void beginningOfFile() {
		List<String> expected = new ArrayList<String>();
		expected.add("evaluated");
		expected.add("expression");
		expected.add("expression { value }");

		assertDisplayStrings(expected, 0, 0);
	}

	@Test
	public void inConditional() {
		List<String> expected = new ArrayList<String>();
		expected.add("evaluated");

		assertDisplayStrings(expected, 0, 4);
	}

	@Test
	public void afterConditional() {
		List<String> expected = new ArrayList<String>();
		expected.add("expression");
		expected.add("expression { value }");

		assertDisplayStrings(expected, 0, 10);
	}
}
