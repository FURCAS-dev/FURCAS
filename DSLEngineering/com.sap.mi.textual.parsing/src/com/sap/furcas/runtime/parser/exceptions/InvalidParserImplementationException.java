/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * Revision: $Revision: 6272 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.exceptions;

/**
 * to be thrown when a generated Parser is not compatible with the current ParserWrapper implementation
 */
public class InvalidParserImplementationException extends Exception {

    public InvalidParserImplementationException(Throwable cause) {
        super(cause);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1774905909267682394L;

    public InvalidParserImplementationException(String message) {
        super(message);
    }

}
