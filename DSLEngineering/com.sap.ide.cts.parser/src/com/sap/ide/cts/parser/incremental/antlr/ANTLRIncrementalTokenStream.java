package com.sap.ide.cts.parser.incremental.antlr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.textual.textblocks.TbNavigationUtil;
import com.sap.furcas.textual.textblocks.TbUtil;
import com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream;

/**
 * This is an ANTLR specific implementation of a token stream that is used to
 * not only pass the antlr tokens to the parser but also tracks the
 * corresponding model elements and {@link AbstractToken}s hat were produced
 * during lexing.
 * 
 * @author C5106462
 */
public class ANTLRIncrementalTokenStream extends CommonTokenStream implements
		ITextBlocksTokenStream {


	private List<AbstractToken> offChannelTokens = new ArrayList<AbstractToken>();
	private Token lastConsumed;
	private AbstractToken lastConsumedModelElementToken;

	public ANTLRIncrementalTokenStream(ANTLRIncrementalLexerAdapter lexer) {
		super(lexer);
	}

	protected ANTLRIncrementalLexerAdapter getCtsLexer() {
		return (ANTLRIncrementalLexerAdapter) tokenSource;
	}
	
	/**
	 * Resets all states to the intial values.
	 */
	public void reset(){
		seek(-1);
		tokens.clear();
		lastConsumed = null;
		lastConsumedModelElementToken = null;
		offChannelTokens.clear();
		getCtsLexer().getTokenToModelElement().clear();
	}

	@Override
	public void seek(int index) {
		super.seek(index);
		if(index == -1) {
			lastConsumed = null;
			lastConsumedModelElementToken = null;
		} else {
			if(tokens.size() > index) {
				lastConsumed = (Token) tokens.get(index);
				lastConsumedModelElementToken = getCtsLexer()
						.getTokenToModelElement().get(lastConsumed);
			} else {
				//might be end of stream
				//set index to EOF
				lastConsumed = Token.EOF_TOKEN;
				lastConsumedModelElementToken = getCtsLexer()
					.getTokenToModelElement().get(lastConsumed);;
			}
		}
	}

	/**
	 * @see CommonTokenStream#skipOffTokenChannels, also prepares the model
	 *      element token for consumption.
	 */
	@Override
	public void consume() {
		if (p < tokens.size()) {
			lastConsumed = (Token) tokens.get(p);
			lastConsumedModelElementToken = getCtsLexer()
					.getTokenToModelElement().get(lastConsumed);
		}
		super.consume();
	}

	/**
	 * @see CommonTokenStream#skipOffTokenChannels , also skips the
	 *      corresponding model element tokens.
	 */
	@Override
	protected int skipOffTokenChannels(int i) {
		int nextOnChannelTokenIndex = super.skipOffTokenChannels(i);
		skipOffChannelsModelElementTokens(i, nextOnChannelTokenIndex);
		return nextOnChannelTokenIndex;
	}

	/**
	 * Adds all tokens from the given <code>startIndex</code> to
	 * <code>nextOnChannelTokenIndex</code> to the {@link #offChannelTokens}
	 * and removes them from the tokenToModelElement list of the lexer.
	 * 
	 * @param startIndex
	 * @param nextOnChannelTokenIndex
	 */
	private void skipOffChannelsModelElementTokens(int startIndex,
			int nextOnChannelTokenIndex) {
		while (startIndex < nextOnChannelTokenIndex) {
		    Object startToken = tokens.get(startIndex);
		    AbstractToken lexedToken = getCtsLexer().getTokenToModelElement().remove(startToken);
			if (lexedToken != null) { 
			    offChannelTokens.add(lexedToken);
			} else { // lexer map did not contain token
			    // TODO Thomas confirm: probably harmless due to tokens skipped several times			    
			}
			startIndex++;
		}
	}

	@Override
	public List<AbstractToken> consumeOffChannelTokensUpTo(AbstractToken endToken) {
	    List<AbstractToken> returnList = new ArrayList<AbstractToken>();
	    if (endToken != null) { // need to check token offsets to see whether they are before endToken or not
	        for (Iterator<AbstractToken> iterator = offChannelTokens.iterator(); iterator.hasNext();) {
	            AbstractToken offChannelToken = (AbstractToken) iterator.next();
	            if (TbUtil.getAbsoluteOffset(offChannelToken) < TbUtil.getAbsoluteOffset(endToken)) {
	                returnList.add(offChannelToken);
	            } else { // do not add token
	                // we could break here if we assume perfect order 
	            }
	        }
	        // remove tokens that are being returned, cannot do so in the loop above because of concurrent modfication
	        if (returnList.size() == offChannelTokens.size()) { // the expected case, optimized to avoid loop
	            offChannelTokens.clear();
	        } else { // can happen for great lookaheads.
	            for (Iterator<AbstractToken> iterator = returnList.iterator(); iterator.hasNext();) {
	                AbstractToken addedToken = (AbstractToken) iterator.next();
	                offChannelTokens.remove(addedToken); 
	            }
	        }
	    } else { // add all, as no end token was passed
	        returnList.addAll(offChannelTokens);
	        offChannelTokens.clear();
	    }
	    return returnList;
	}

	/**
	 * 
	 */
	@Override
	public AbstractToken consumeTokenModelElementForParserToken(
			Token parserToken) {
		AbstractToken result = null;
		if (parserToken == lastConsumed) {
			result = lastConsumedModelElementToken;
		} 
		if(result == null) {
			result = getCtsLexer().getTokenToModelElement().get(parserToken);
		}
		if (result == null) {
			throw new RuntimeException("No ModelElement Token found for:"
					+ parserToken);
		}
		return result;
	}

	@Override
	public AbstractToken getTokenModelElementForParserToken(Token parserToken) {
		return getCtsLexer().getTokenToModelElement().get(parserToken);
	}

	@Override
	public void seek(AbstractToken token) {
		//set to one token before as first call to
		//nextToken will then move to the actual token
		//this will also work for the first token as 
		//then the previous token is simply the BOS token.
		reset();
		getCtsLexer().setCurrentTokenForParser(TbNavigationUtil.previousToken(token));
		//set the local read to back to the start
	}

	public AbstractToken getLastConsumedToken() {
	    return this.lastConsumedModelElementToken;
	}

}
