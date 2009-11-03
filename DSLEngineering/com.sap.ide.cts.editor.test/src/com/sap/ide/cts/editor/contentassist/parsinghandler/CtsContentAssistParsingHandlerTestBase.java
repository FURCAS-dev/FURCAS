package com.sap.ide.cts.editor.contentassist.parsinghandler;

import generated.TCSLexer;
import generated.TCSParser;

import java.io.IOException;
import java.io.InputStream;

import com.sap.ide.cts.editor.contentassist.CtsContentAssistParsingHandler;
import com.sap.ide.cts.editor.contentassist.TcsFixtureBase;
import com.sap.ide.cts.editor.contentassist.modeladapter.StubModelAdapter;
import com.sap.ide.cts.editor.test.util.ConcreteSyntaxBasedTest;
import com.sap.mi.textual.grammar.IModelAdapter;
import com.sap.mi.textual.grammar.ParserFacade;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.grammar.impl.DelegationParsingObserver;
import com.sap.mi.textual.parsing.textblocks.TextBlocksAwareModelAdapter;

public abstract class CtsContentAssistParsingHandlerTestBase extends
		ConcreteSyntaxBasedTest {

	protected static CtsContentAssistParsingHandler observer;

	protected void observeFixture(String path)
			throws InvalidParserImplementationException, IOException,
			UnknownProductionRuleException {
		ParserFacade facade = new ParserFacade(TCSParser.class, TCSLexer.class);
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
