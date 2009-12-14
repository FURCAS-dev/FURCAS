package com.sap.ide.cts.editor.contentassist.processor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import test.reference.Author;
import test.reference.Library;
import test.reference.ReferencePackage;

import com.sap.mi.textual.common.exceptions.GrammarGenerationException;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;

public class TestCtsContentAssistProcessorQueryAndRefersToSimple extends
		CtsContentAssistProcessorEditorTestMetamodelTestBase {

	@BeforeClass
	public static void generateParser() throws FileNotFoundException,
			GrammarGenerationException, SyntaxParsingException,
			ModelAdapterException, IOException {
		initMetamodelTestbase("QueryAndRefersTo");
	}

	@Before
	public void initProcessor() throws IOException,
			InvalidParserImplementationException,
			UnknownProductionRuleException, InstantiationException,
			IllegalAccessException {
		initProcessorForPrefix("Simple");
	}

	@Before
	public void populateModel() {
		// populate model as if the fixture had been parsed
		ReferencePackage refPack = connection
				.getPackage(ReferencePackage.PACKAGE_DESCRIPTOR);

		Library lib = (Library) refPack.getLibrary().refCreateInstance();

		Author henderson = (Author) refPack.getAuthor().refCreateInstance();
		henderson.setName("henderson");

		Author obrian = (Author) refPack.getAuthor().refCreateInstance();
		obrian.setName("obrian");

		Author hegel = (Author) refPack.getAuthor().refCreateInstance();
		hegel.setName("hegel");

		lib.getAuthors().add(henderson);
		lib.getAuthors().add(obrian);
		lib.getAuthors().add(hegel);

		// no need to supply books as we only test referring to an author
	}

	@Test
	public void beginningOfBook() {
		List<String> expected = new ArrayList<String>();
		expected.add("title");
		expected.add("title by author");
		expected.add("}");

		assertDisplayStrings(expected, 3, 0);
	}

	/**
	 * Ignored until content assist support for query and refersTo is
	 * implemented.
	 */
	@Ignore
	@Test
	public void insideBookBeginningOfAuthor() {
		List<String> expected = new ArrayList<String>();
		expected.add("author");
		expected.add("hegel");
		expected.add("henderson");

		// other authors filtered out, their names don't start with an 'h'

		assertDisplayStrings(expected, 3, 11);
	}

	@Test
	public void insideBookInsideAuthor() {
		List<String> expected = new ArrayList<String>();
		expected.add("hegel");
		expected.add("henderson");

		assertDisplayStrings(expected, 3, 13);
	}
}
