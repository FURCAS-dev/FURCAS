package com.sap.ide.cts.editor.contentassist.parsinghandler;


import java.io.IOException;
import java.io.InputStream;

import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DelegationParsingObserver;
import com.sap.furcas.runtime.parser.textblocks.TextBlocksAwareModelAdapter;
import com.sap.ide.cts.editor.contentassist.CtsContentAssistParsingHandler;
import com.sap.ide.cts.editor.contentassist.TcsFixtureBase;
import com.sap.ide.cts.editor.contentassist.modeladapter.StubModelAdapter;
import com.sap.ide.cts.editor.test.util.ConcreteSyntaxBasedTest;

public abstract class CtsContentAssistParsingHandlerTestBase extends
		ConcreteSyntaxBasedTest {

	protected static CtsContentAssistParsingHandler observer;

	protected void observeFixture(String path)
			throws InvalidParserImplementationException, IOException,
			UnknownProductionRuleException {
		ParserFacade facade = new ParserFacade(TCSParser.class, TCSLexer.class, syntax);
		InputStream in = TcsFixtureBase.class
				.getResourceAsStream(path + ".dsl");
		IModelAdapter modelHandler = new TextBlocksAwareModelAdapter(
				new StubModelAdapter());

		initSyntax(TCSLexer.class.getResourceAsStream("TCS.tcs"));

		// use delegator to monitor exceptions
		DelegationParsingObserver delegator = new DelegationParsingObserver();
		observer = new CtsContentAssistParsingHandler(syntax);
		delegator.addParsingObserver(observer);

		facade.parseProductionRule(in, modelHandler, null, null, delegator);
	}
}
