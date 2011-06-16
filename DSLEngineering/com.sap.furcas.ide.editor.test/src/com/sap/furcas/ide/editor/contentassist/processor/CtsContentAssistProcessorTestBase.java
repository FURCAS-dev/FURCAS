package com.sap.furcas.ide.editor.contentassist.processor;

import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;

import com.sap.furcas.ide.editor.contentassist.CompletionListHelper;
import com.sap.furcas.ide.editor.contentassist.CtsContentAssistProcessor;
import com.sap.furcas.ide.editor.contentassist.TestCtsContentAssistParsingHandler;
import com.sap.furcas.ide.editor.contentassist.stubs.TextViewerStub;
import com.sap.furcas.ide.editor.test.utils.GeneratedTextblocksBasedTest;
import com.sap.furcas.ide.editor.test.utils.StringReplacement;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

public abstract class CtsContentAssistProcessorTestBase extends GeneratedTextblocksBasedTest {

    protected CtsContentAssistProcessor processor;
    protected ITextViewer viewer;

    /**
     * @param fixtureName
     * @param postFixtureParseReplacement
     *            this is used to insert unparsable text after the fixture has
     *            been parsed (emulating the user typing it in after a
     *            successful and correct save)
     * @param languageTcsFile
     */
    protected void initProcessorForFixture(String fixtureName, StringReplacement postFixtureParseReplacement,
            IncrementalParserFacade facade) throws ParserInstantiationException, SemanticParserException {

        String fixturePath = "fixtures/" + fixtureName + ".dsl";
        viewer = new TextViewerStub(fixturePath, postFixtureParseReplacement);
        InputStream in = TestCtsContentAssistParsingHandler.class.getResourceAsStream(fixturePath);

        initTbModel(in, facade, postFixtureParseReplacement);

        processor = new CtsContentAssistProcessor(facade);
    }

    /**
     * 
     * @param expected
     * @param line
     * @param charPositionInLine
     */
    protected void assertDisplayStrings(List<String> expected, int line, int charPositionInLine) {
        List<String> displayStrings = CompletionListHelper.collectDisplayStrings(processor.computeCompletionProposals(viewer,
                line, charPositionInLine, tbModel));

        boolean fail = false;
        String failMsg = "";

        if (expected.size() != displayStrings.size()) {
            fail = true;
            failMsg = "result number differs: expected " + expected.size() + " but was " + displayStrings.size();
        }

        for (int i = 0; i < displayStrings.size() && i < expected.size(); i++) {
            if (!fail) {
                String expectedString = expected.get(i);
                String displayString = displayStrings.get(i);
                if (!expectedString.equals(displayString)) {
                    fail = true;
                    failMsg = "position " + i + " differs. expected: " + expectedString + " but was: " + displayString;
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
