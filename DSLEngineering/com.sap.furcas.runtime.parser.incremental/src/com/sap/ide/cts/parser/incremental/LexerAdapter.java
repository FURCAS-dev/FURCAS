package com.sap.ide.cts.parser.incremental;

import java.util.List;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;

public interface LexerAdapter {

    List<? extends AbstractToken> moreTokens();

    /**
     * Needed to call back the {@link IncrementalLexer#nextChar()} to retrieve next char of stream.
     */
    void setIncrementalLexer(IncrementalLexer incrementalLexer);

    boolean hasErrors();

}