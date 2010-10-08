package com.sap.ide.cts.editor.contentassist.processor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.junit.BeforeClass;

import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.test.base.ParserGenerationTestHelper;
import com.sap.ide.cts.editor.contentassist.CtsContentAssistProcessor;
import com.sap.ide.cts.editor.contentassist.CtsContentAssistUtil;
import com.sap.ide.cts.editor.contentassist.TcsFixtureBase;
import com.sap.ide.cts.editor.contentassist.stubs.TextViewerStub;
import com.sap.ide.cts.editor.test.util.GeneratedTextblocksBasedTest;
import com.sap.ide.cts.editor.test.util.StringReplacement;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

public abstract class CtsContentAssistProcessorTestBase extends
		GeneratedTextblocksBasedTest {

	protected CtsContentAssistProcessor processor;
	protected ITextViewer viewer;

	@BeforeClass
	public static void initParserGenerationTestHelper() {
		setParserGenerationTestHelper(new ParserGenerationTestHelper(
				"src/com/sap/ide/cts/editor/contentassist/fixtures/syntax",
				"generatedTemp", "generatedTemp/generated", "generated", false));
	}

	/**
	 * @param fixtureName
	 * @param postFixtureParseReplacement
	 *            this is used to insert unparsable text after the fixture has
	 *            been parsed (emulating the user typing it in after a
	 *            successful and correct save)
	 * @param languageTcsFile
	 * @throws IOException
	 * @throws UnknownProductionRuleException
	 * @throws InvalidParserImplementationException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	protected void initProcessorForFixture(String fixtureName,
			StringReplacement postFixtureParseReplacement,
			InputStream languageTcsFile) throws IOException,
			UnknownProductionRuleException,
			InvalidParserImplementationException, InstantiationException,
			IllegalAccessException {

		assertNotNull(metamodelId);
		initSyntax(languageTcsFile);

		String fixturePath = "fixtures/" + fixtureName + ".dsl";

		viewer = new TextViewerStub(fixturePath, postFixtureParseReplacement);

		InputStream in = TcsFixtureBase.class.getResourceAsStream(fixturePath);

		IncrementalParserFacade facade = getIncrementalFacade();

		initTbModel(in, facade, postFixtureParseReplacement);

		processor = new CtsContentAssistProcessor(syntax, facade
				.getLexerClass(), facade.getParserClass(), language);
	}

	/**
	 * compatibility version with tests that don't use dynamic parser
	 * generation. assumes initialized syntax
	 * 
	 * @param fixtureName
	 * @param facade
	 * @throws IOException
	 * @throws UnknownProductionRuleException
	 * @throws InvalidParserImplementationException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	protected void initProcessorForFixture(String fixtureName,
			StringReplacement postFixtureParseReplacement,
			IncrementalParserFacade facade, String language)
			throws IOException, UnknownProductionRuleException,
			InvalidParserImplementationException, InstantiationException,
			IllegalAccessException {

		assertNotNull(metamodelId);
		assertNotNull(syntax);

		String fixturePath = "fixtures/" + fixtureName + ".dsl";

		viewer = new TextViewerStub(fixturePath, postFixtureParseReplacement);

		InputStream in = TcsFixtureBase.class.getResourceAsStream(fixturePath);

		initTbModel(in, facade, postFixtureParseReplacement);

		processor = new CtsContentAssistProcessor(syntax, facade
				.getLexerClass(), facade.getParserClass(), language);
	}

	/**
	 * 
	 * @param expected
	 * @param line
	 * @param charPositionInLine
	 */
	protected void assertDisplayStrings(List<String> expected, int line,
			int charPositionInLine) {
		List<String> displayStrings = CtsContentAssistUtil
				.collectDisplayStrings(processor.computeCompletionProposals(
						viewer, line, charPositionInLine, tbModel));

		boolean fail = false;
		String failMsg = "";

		if (expected.size() != displayStrings.size()) {
			fail = true;
			failMsg = "result number differs";
		}

		for (int i = 0; i < displayStrings.size() && i < expected.size(); i++) {
			if (!fail) {
				String expectedString = expected.get(i);
				String displayString = displayStrings.get(i);
				if (!expectedString.equals(displayString)) {
					fail = true;
					failMsg = "position " + i + " differs. expected: "
							+ expectedString + " but was: " + displayString;
				}
			}
		}

		if (fail) {
			System.out.println("DEBUGINFO assertDisplayStrings failed:");
			System.out.println("EXPECTED:");
			for (String e : expected) {
				System.out.println("expected.add(\"" + e + "\");");
			}
			System.out.println("RESULT:");
			for (String r : displayStrings) {
				System.out.println("expected.add(\"" + r + "\");");
			}

			fail(failMsg);
		}
	}
}
