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

public class TestCtsContentAssistProcessorOperatorMainTemplatelSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("OperatorMainTemplate");
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
		expected.add("-");
		expected.add("value");

		assertDisplayStrings(expected, 0, 0);
	}

	@Test
	public void afterFirstExpression() {
		List<String> expected = new ArrayList<String>();
		expected.add("*");
		expected.add("+");
		expected.add("-");
		expected.add("/");
		expected.add("[");
		expected.add("^^");
		expected.add("sqrt");

		assertDisplayStrings(expected, 0, 2);
	}

	@Test
	public void afterOperator() {
		List<String> expected = new ArrayList<String>();
		expected.add("-");
		expected.add("value");

		assertDisplayStrings(expected, 0, 4);
	}

	@Test
	public void inOperator() {
		List<String> expected = new ArrayList<String>();
		expected.add("^^");

		assertDisplayStrings(expected, 0, 20);
	}
}
