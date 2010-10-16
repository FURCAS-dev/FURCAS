package com.sap.furcas.runtime.parser.textblocks;

import java.util.List;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.sap.furcas.metamodel.textblocks.AbstractToken;

public interface ITextBlocksTokenStream extends TokenStream {

	/**
	 * Should return the {@link AbstractToken}model element for the corresponding
	 * {@link Token} from the parser.
	 *  
	 * @param parserToken
	 * @return
	 */
	public AbstractToken getTokenModelElementForParserToken(Token parserToken) ;
	
	/**
	 * Returns and consumes the corresponding {@link AbstractToken} for the given {@link Token}
	 * from the stream. 
	 * 
	 * @param parserToken
	 * @return
	 */
	public AbstractToken consumeTokenModelElementForParserToken(Token parserToken);

	/**
	 * Returns and consumes all model element tokens that are not recognizable or relevant for the parser.
	 * These are for example errornous or ignored tokens. 
	 * @param tokenToRelocate include tokens up to this token, or null to add all. // TODO: use addAll method instead of null to make intent explicit? 
	 * @return
	 */
	public List<? extends AbstractToken> consumeOffChannelTokensUpTo(AbstractToken tokenToRelocate);

	/**
	 * Seek to the position where token is in the stream.
	 * @param token
	 */
	public void seek(AbstractToken token);

	/**
	 * Returns the last consumed model element token ()
	 */
	public AbstractToken getLastConsumedToken();
}
