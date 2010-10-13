/**
 * 
 */
package com.sap.furcas.runtime.parser.antlr3;

import org.antlr.runtime.CharStream;

/**
 * creates tokens during lexing of Strings from a CharStream. May reuse existing token objects e.g. from earlier lexing activities.
 */
public interface ITokenFactory<Type extends ANTLR3LocationToken> {

    /**
     * create a token from the input stream using the chars in the input stream, 
     * and possibly other information contained in the CharStream subclass. 
     * @param input
     * @param type
     * @param channel
     * @param start
     * @param stop
     * @return
     */
    public Type createToken(CharStream input, int type, int channel, int start, int stop);
    
}
