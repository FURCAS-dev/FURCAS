/**
 * 
 */
package com.sap.furcas.runtime.parser.antlr3;

import org.antlr.runtime.CharStream;

/**
 *
 */
public class DefaultANTLR3LocationTokenFactory implements ITokenFactory<ANTLR3LocationTokenImpl> {

    @Override
    public ANTLR3LocationTokenImpl createToken(CharStream input, int type, int channel, int start, int stop) {
        return new ANTLR3LocationTokenImpl(input, type, channel, start, stop);
    }
    
}
