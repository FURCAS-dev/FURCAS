package com.sap.ide.cts.parser.incremental.antlr;

import org.antlr.runtime.Lexer;

import com.sap.ide.cts.parser.incremental.IncrementalLexer;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream;

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
