package com.sap.ide.cts.parser.incremental;

import java.util.Collections;
import java.util.List;

import org.antlr.runtime.Lexer;

import textblocks.AbstractToken;

import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRLexerAdapter;
import com.sap.tc.moin.repository.Connection;

public class MockLexerAdapterWithLookaheadLLStar extends ANTLRLexerAdapter {
	
	public MockLexerAdapterWithLookaheadLLStar(Lexer antlrLexer, Connection conn) {
		super(antlrLexer, null, conn);
		// TODO Auto-generated constructor stub
	}

	private List<AbstractToken> nextTokens;
	private ANTLRIncrementalLexerAdapter callbackLexer;
	private int nextTokenIndex = 0;

	@Override
	public int getState(AbstractToken tok) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AbstractToken> moreTokens() {
		//simulate a lookahead of 1 within a LL(*) parser
		int mark = callbackLexer.mark();
		callbackLexer.LA(1);
		callbackLexer.consume();
		callbackLexer.rewind(mark);
		//simulate token consumption on callbacked lexer
		callbackLexer.consume();
		return Collections.singletonList(nextTokens.get(nextTokenIndex++));
	}

	@Override
	public void setIncrementalLexer(IncrementalLexer incrementalLexer) {
		this.callbackLexer = (ANTLRIncrementalLexerAdapter) incrementalLexer;
	}

	@Override
	public void setState(int state) {
		// TODO Auto-generated method stub

	}

	public void setNextTokens( List<AbstractToken> nextTokens) {
		this.nextTokens = nextTokens;
	}


}
