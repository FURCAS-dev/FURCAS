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

public class TestCtsContentAssistProcessorAlternativeIsMultiSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("AlternativeIsMulti");
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
		expected.add("library");
		expected.add("library { }");

		// isMulti Alternatives are optional, should not come up
		// with template proposals

		assertDisplayStrings(expected, 0, 0);
	}

	@Test
	public void afterOpeningBracket() {
		List<String> expected = new ArrayList<String>();
		expected.add("author");
		expected.add("author name ;");
		expected.add("book");
		expected.add("book title ;");
		expected.add("}");

		assertDisplayStrings(expected, 1, 0);
	}

	@Test
	public void inBookAlternativeAfterFirstKeyword() {
		List<String> expected = new ArrayList<String>();
		expected.add("title");

		assertDisplayStrings(expected, 4, 6);
	}

	@Test
	public void inAuthorAlternativeAfterFirstKeyword() {
		List<String> expected = new ArrayList<String>();
		expected.add("name");

		assertDisplayStrings(expected, 5, 8);
	}

	@Test
	public void inAlternativeAfterFirstEntry() {
		List<String> expected = new ArrayList<String>();

		// isMulti allows the same content after one alternative

		expected.add("author");
		expected.add("author name ;");
		expected.add("book");
		expected.add("book title ;");
		expected.add("}");

		assertDisplayStrings(expected, 6, 0);
	}
}
