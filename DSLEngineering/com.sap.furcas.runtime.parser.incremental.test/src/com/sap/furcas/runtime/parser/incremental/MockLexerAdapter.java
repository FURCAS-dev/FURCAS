package com.sap.furcas.runtime.parser.incremental;

import java.util.Collections;
import java.util.List;

import org.antlr.runtime.Lexer;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.ide.cts.parser.incremental.IncrementalLexer;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRLexerAdapter;

public class MockLexerAdapter extends ANTLRLexerAdapter {
	
	public MockLexerAdapter(Lexer antlrLexer) {
		super(antlrLexer, null);
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
