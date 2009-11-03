package com.sap.ide.cts.editor.contentassist.parsinghandler;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;

public class TestCtsContentAssistParsingHandlerFunctionCall extends
		CtsContentAssistParsingHandlerTestBase {

	@Before
	public void initObserver() throws InvalidParserImplementationException,
			IOException, UnknownProductionRuleException {
		observeFixture("fixtures/FunctionCall.tcs");
	}

	@Test
	public void testValidFinishState() {
		observer.assertValidFinishState();
	};
}
