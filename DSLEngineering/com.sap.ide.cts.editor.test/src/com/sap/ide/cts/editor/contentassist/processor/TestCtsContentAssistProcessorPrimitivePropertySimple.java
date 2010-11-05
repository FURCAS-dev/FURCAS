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

public class TestCtsContentAssistProcessorPrimitivePropertySimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("PrimitiveProperty");
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
		expected.add("student");
		expected.add("student name nicknames");

		assertDisplayStrings(expected, 0, 0);
	}

	@Test
	public void beginningOfProperty() {
		List<String> expected = new ArrayList<String>();
		expected.add("name");

		assertDisplayStrings(expected, 0, 8);
	}

	@Test
	public void middleOfProperty() {
		List<String> expected = new ArrayList<String>();

		assertDisplayStrings(expected, 0, 10);
	}

	@Test
	public void afterProperty() {
		List<String> expected = new ArrayList<String>();
		expected.add("nicknames");

		assertDisplayStrings(expected, 0, 14);
	}

	@Test
	public void beginningOfMultivaluedProperty() {
		List<String> expected = new ArrayList<String>();
		expected.add("nicknamesEntry");

		assertDisplayStrings(expected, 0, 28);
	}

	@Test
	public void middleOfMultivaluedProperty() {
		List<String> expected = new ArrayList<String>();

		assertDisplayStrings(expected, 0, 30);
	}

	@Test
	public void afterMultivaluedProperty() {
		List<String> expected = new ArrayList<String>();
		expected.add("nicknamesEntry");

		assertDisplayStrings(expected, 0, 33);
	}
}
