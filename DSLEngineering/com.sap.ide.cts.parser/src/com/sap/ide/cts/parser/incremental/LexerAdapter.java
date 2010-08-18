package com.sap.ide.cts.parser.incremental;

import java.util.List;

import com.sap.furcas.metamodel.textblocks.AbstractToken;

public interface LexerAdapter {
	
	List<? extends AbstractToken> moreTokens();

	int getState(AbstractToken tok);

	void setState(int state);

	/**
	 * Needed to call back the {@link IncrementalLexer#nextChar()} to retrieve next char of stream.
	 * @param incrementalLexer
	 */
	void setIncrementalLexer(IncrementalLexer incrementalLexer);

	boolean hasErrors();

}