package com.sap.ide.cts.editor.contentassist.parsinghandler;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;

public class TestCtsContentAssistParsingHandlerEnumeration extends
		CtsContentAssistParsingHandlerTestBase {

	@Before
	public void initObserver() throws InvalidParserImplementationException,
			IOException, UnknownProductionRuleException {
		observeFixture("fixtures/Enumeration.tcs");
	}

	@Test
	public void testValidFinishState() {
		observer.assertValidFinishState();
	};
}
