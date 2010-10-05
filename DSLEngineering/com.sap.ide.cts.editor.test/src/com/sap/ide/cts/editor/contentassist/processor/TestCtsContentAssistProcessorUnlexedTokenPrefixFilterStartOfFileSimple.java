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
import com.sap.ide.cts.editor.test.util.StringReplacement;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;

public class TestCtsContentAssistProcessorUnlexedTokenPrefixFilterStartOfFileSimple
		extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("UnlexedTokenPrefixFilterStartOfFile");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException,
			UnknownProductionRuleException, InstantiationException,
			IllegalAccessException {
		initProcessorForPrefix("Simple", new StringReplacement(0, 0, "-</!"));
	}

	@Test
	public void beginningOfFile() {
		List<String> expected = new ArrayList<String>();
		expected.add("*(?=|");
		expected.add("*(?=| name");
		expected.add("-</!^>");
		expected.add("-</!^> name");

		assertDisplayStrings(expected, 0, 0);
	}

	@Test
	public void middleOfNonIdentifierTokenAtStartOfFile() {
		List<String> expected = new ArrayList<String>();
		expected.add("-</!^>");
		expected.add("-</!^> name");

		assertDisplayStrings(expected, 0, 3);
	}
}
