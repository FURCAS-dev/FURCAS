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
import com.sap.ide.cts.editor.test.util.StringReplacement;

public class TestCtsContentAssistProcessorUnlexedTokenPrefixFilterSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("UnlexedTokenPrefixFilter");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException,
			UnknownProductionRuleException, InstantiationException,
			IllegalAccessException {
		initProcessorForPrefix("Simple", new StringReplacement(0, 0,
				"*(?=| peter $$"));
	}

	@Test
	public void beginningOfFile() {
		List<String> expected = new ArrayList<String>();
		expected.add("*(?=|");
		expected.add("*(?=| name $$$");

		assertDisplayStrings(expected, 0, 0);
	}

	@Test
	public void beforeNonIdentifierToken() {
		List<String> expected = new ArrayList<String>();
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