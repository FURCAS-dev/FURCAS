/**
 * 
 */
package com.sap.mi.textual.parsing.textblocks.observer;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream;

/**
 *
 */
public class TokenStreamMock extends CommonTokenStream implements ITextBlocksTokenStream {

    public ArrayList<AbstractToken> offChannelTokens = new ArrayList<AbstractToken>();
    public AbstractToken nextToken;

    /* (non-Javadoc)
     * @see com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream#consumeOffChannelTokensUpTo(textblocks.AbstractToken)
     */
    @Override
    public List<? extends AbstractToken> consumeOffChannelTokensUpTo(
            AbstractToken tokenToRelocate) {
        return offChannelTokens;
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream#consumeTokenModelElementForParserToken(org.antlr.runtime.Token)
     */
    @Override
    public AbstractToken consumeTokenModelElementForParserToken(
            Token parserToken) {
        return nextToken;
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream#getTokenModelElementForParserToken(org.antlr.runtime.Token)
     */
    @Override
    public AbstractToken getTokenModelElementForParserToken(
            Token parserToken) {
        return nextToken;
    }

	@Override
	public void seek(AbstractToken token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AbstractToken getLastConsumedToken() {
	    // TODO Auto-generated method stub
	    return null;
	}
    
}