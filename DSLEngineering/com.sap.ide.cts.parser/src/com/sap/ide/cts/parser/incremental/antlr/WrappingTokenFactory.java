/**
 * 
 */
package com.sap.ide.cts.parser.incremental.antlr;

import org.antlr.runtime.CharStream;

import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.mi.textual.grammar.antlr3.ITokenFactory;
import com.sap.mi.textual.parsing.textblocks.LexedTokenWrapper;

/**
 *
 */
public class WrappingTokenFactory implements ITokenFactory<LexedTokenWrapper>{

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.antlr3.ITokenFactory#createToken(org.antlr.runtime.CharStream, int, int, int, int)
     */
    @Override
    public LexedTokenWrapper createToken(CharStream input, int type,
            int channel, int start, int stop) {
        if (input instanceof ANTLRIncrementalTokenStream) {
            // ANTLRIncrementalTokenStream stream = (ANTLRIncrementalTokenStream) input;
            // TODO get Lexed Token from input stream            
            LexedToken token = null;
            
            LexedTokenWrapper tokenWrapper = new LexedTokenWrapper(token);
            return tokenWrapper;
        } else {
            throw new IllegalArgumentException("Unexpected Token Stream class " + input.getClass());
        }
 
        
    }

}
