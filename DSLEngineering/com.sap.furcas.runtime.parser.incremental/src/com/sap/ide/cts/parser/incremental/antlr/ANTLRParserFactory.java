package com.sap.ide.cts.parser.incremental.antlr;

import org.antlr.runtime.Lexer;

import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;

public abstract class ANTLRParserFactory<P extends ObservableInjectingParser, L extends Lexer> implements ParserFactory<P, L> {

    @Override
    public ITextBlocksTokenStream createIncrementalTokenStream(Object incrementalLexer) {
        if (incrementalLexer instanceof ANTLRIncrementalLexerAdapter) {
            return new ANTLRIncrementalTokenStream((ANTLRIncrementalLexerAdapter) incrementalLexer);
        } else {
            throw new IllegalArgumentException(
                    "ANTLRIncrementalTokenStream can only be instantiated with an ANTLRIncrementalLexerAdapter, but got: "
                            + incrementalLexer);
        }

    }

}
