package com.sap.ide.cts.editor.contentassist.processor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.List;

import org.antlr.runtime.Lexer;
import org.antlr.runtime.Parser;
import org.eclipse.jface.text.ITextViewer;
import org.junit.BeforeClass;

import com.sap.ide.cts.editor.contentassist.CtsContentAssistProcessor;
import com.sap.ide.cts.editor.contentassist.CtsContentAssistUtil;
import com.sap.ide.cts.editor.contentassist.stubs.TextViewerStub;
import com.sap.ide.cts.editor.test.util.GeneratedParserBasedTest;
import com.sap.ide.cts.editor.test.util.ParserGenerationTestHelper;
import com.sap.mi.textual.grammar.ParserFacade;

public abstract class CtsContentAssistProcessorTestBase extends
		GeneratedParserBasedTest {

	protected CtsContentAssistProcessor processor;
	protected ITextViewer viewer;

	@BeforeClass
	public static void initParserGenerationTestHelper() {
		setParserGenerationTestHelper(new ParserGenerationTestHelper(
				"src/com/sap/ide/cts/editor/contentassist/fixtures/syntax",
				"generatedTemp", "generatedTemp/generated", "generated", false));
	}

	protected void initProcessorForFixture(String fixtureName,
			Class<? extends Lexer> lexerClass,
			Class<? extends Parser> parserClass, String language,
			InputStream languageTcsFile) {

		assertNotNull(metamodelId);
		initSyntax(languageTcsFile);

		viewer = new TextViewerStub("fixtures/" + fixtureName + ".dsl");

		processor = new CtsContentAssistProcessor(syntax, lexerClass,
				parserClass, language);
	}

	protected void initProcessorForFixture(String fixtureName,
			ParserFacade facade, String language, InputStream languageTcsFile) {
		initProcessorForFixture(fixtureName, facade.getLexerClass(), facade
				.getParserClass(), language, languageTcsFile);
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
						viewer, line, charPositionInLine));

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
