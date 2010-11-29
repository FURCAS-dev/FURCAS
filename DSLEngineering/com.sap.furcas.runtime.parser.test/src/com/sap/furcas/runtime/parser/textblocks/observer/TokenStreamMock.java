/**
 * 
 */
package com.sap.furcas.runtime.parser.textblocks.observer;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;


public class TokenStreamMock extends CommonTokenStream implements ITextBlocksTokenStream {

    public ArrayList<AbstractToken> offChannelTokens = new ArrayList<AbstractToken>();
    public AbstractToken nextToken;

    @Override
    public List<? extends AbstractToken> consumeOffChannelTokensUpTo(AbstractToken tokenToRelocate) {
        return offChannelTokens;
    }

    @Override
    public AbstractToken consumeTokenModelElementForParserToken(Token parserToken) {
        return nextToken;
    }

    @Override
    public AbstractToken getTokenModelElementForParserToken(Token parserToken) {
        return nextToken;
    }

    @Override
    public void seek(AbstractToken token) {
        fail("Not implemented");
    }

    @Override
    public AbstractToken getLastConsumedToken() {
        fail("Not implemented");
        return null;
    }

}