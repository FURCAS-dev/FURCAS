/**
 * 
 */
package com.sap.furcas.runtime.parser.impl;

import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;

/**
 *
 */
class LookupPathNavigationException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -8745795529098705818L;
    private ANTLR3LocationToken token;

    public ANTLR3LocationToken getToken() {
        return token;
    }

    /**
     * @param message
     * @param token 
     */
    public LookupPathNavigationException(String message, ANTLR3LocationToken token) {
        super(message);
        this.token = token;
    }

}
