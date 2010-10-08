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
import com.sap.ide.cts.editor.test.util.StringReplacement;

public class TestCtsContentAssistProcessorQueryAndFilterSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("QueryAndFilter");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException,
			UnknownProductionRuleException, InstantiationException,
			IllegalAccessException {
		initProcessorForPrefix("Simple", new StringReplacement(4, 0,
				";\n\"dubry\" by obrian"));
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
	public void insideBookBeginningOfAuthorParsed() {
		List<String> expected = new ArrayList<String>();
		expected.add("author");
		expected.add("hegel");
		expected.add("henderson");
		expected.add("obrian");

		assertDisplayStrings(expected, 3, 11);
	}

	@Test
	public void insideBookInsideAuthorParsed() {
		List<String> expected = new ArrayList<String>();
		expected.add("hegel");
		expected.add("henderson");

		assertDisplayStrings(expected, 3, 13);
	}
	
	@Test
	public void insideBookBeginningOfAuthorUnparsed() {
		List<String> expected = new ArrayList<String>();
		expected.add("author");

		assertDisplayStrings(expected, 5, 11);
	}

	@Test
	public void insideBookInsideAuthorUnparsed() {
		List<String> expected = new ArrayList<String>();

		assertDisplayStrings(expected, 5, 13);
	}
}
