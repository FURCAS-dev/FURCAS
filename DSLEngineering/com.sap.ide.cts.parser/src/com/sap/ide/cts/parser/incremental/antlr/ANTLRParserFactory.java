package com.sap.ide.cts.parser.incremental.antlr;

import org.antlr.runtime.Lexer;

import com.sap.furcas.parsing.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.ide.cts.parser.incremental.IncrementalLexer;
import com.sap.ide.cts.parser.incremental.ParserFactory;

public abstract class ANTLRParserFactory<P extends ObservableInjectingParser,
	L extends Lexer> implements ParserFactory<P, L> {

	@Override
	public ITextBlocksTokenStream createIncrementalTokenStream(IncrementalLexer incrementalLexer) {
		if(incrementalLexer instanceof ANTLRIncrementalLexerAdapter) {
			return new ANTLRIncrementalTokenStream((ANTLRIncrementalLexerAdapter) incrementalLexer);
		} else {
			throw new RuntimeException("ANTLRIncrementalTokenStream can only be instantiated with an ANTLRIncrementalLexerAdapter, but got: " + incrementalLexer);
		}
		
	}

}
