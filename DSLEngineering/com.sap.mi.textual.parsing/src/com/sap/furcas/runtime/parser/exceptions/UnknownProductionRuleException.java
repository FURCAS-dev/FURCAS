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
 * to be thrown when parser is called passing a production rule that does not exist in the Parser.
 */
public class UnknownProductionRuleException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 6515713510828668903L;

    public UnknownProductionRuleException(String message) {
        super(message);
    }

}
