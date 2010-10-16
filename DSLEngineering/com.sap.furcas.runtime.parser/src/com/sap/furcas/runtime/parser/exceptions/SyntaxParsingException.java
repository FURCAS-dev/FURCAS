/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-09-18 14:13:44 +0200 (Fr, 18 Sep 2009) $
 * Revision: $Revision: 7886 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.exceptions;

import java.util.List;

import com.sap.furcas.runtime.parser.impl.ParsingError;




/**
 * to be thrown when parsing of a syntax definition fails for parsing reasons (i.e. not for FileNotFound)
 * 
 * @author C5107456
 */
public class SyntaxParsingException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8051131975529299987L;

    /** The error list. */
    List<ParsingError> errorList;

//    /**
//     * The Constructor.
//     * 
//     * @param message the message
//     * @param position the position
//     * @param line the line
//     */
//    public SyntaxParsingException(String message, int index, int length, int line, int position, int endLine, int endPosition) {
//        super(message);
//        ParsingError pe = new ParsingError(message, index, length, line, position, endLine, endPosition);
//        errorList = new ArrayList<ParsingError>(1);
//        errorList.add(pe);
//    }

    /**
     * Instantiates a new syntax parsing exception.
     * 
     * @param errors the errors
     */
    public SyntaxParsingException(List<ParsingError> errors) {
        super(getMultiMessage(errors));
        errorList = errors;
    }
    
    /**
     * Instantiates a new syntax parsing exception.
     * 
     * @param errors the errors
     */
    public SyntaxParsingException(String message, SyntaxParsingException spe) {
        super(message, spe);
        errorList = spe.getErrorList();
    }

//  /**
//     * @param string
//     * @param location
//     * @param object
//     */
//    public InvalidSyntaxDefinitionException(String message, String location, Throwable cause) {
////        this(message, cause);
//      super(message, cause);
//      TextLocation loc = new TextLocation(location); 
//      errorList = new ArrayList<ParsingError>(1);
//      String locatedMessage = message;
//      if (location != null) {
//          locatedMessage = locatedMessage + " at " + location;
//      }
//      errorList.add(new ParsingError(locatedMessage, loc.getStartLine(), loc.getStartPosition(), loc.getEndLine(), loc.getEndPosition()));
//    }
//
//    /**
//     * @param string
//     * @param location
//     */
//    public InvalidSyntaxDefinitionException(String message, String location) {
//        this(message, location, null);
//    }

    
    /**
     * @param errors
     * @return
     */
    private static String getMultiMessage(List<ParsingError> errors) {
        if (errors == null || errors.size() == 0) {
            return "BUG: Error List null or without members.";
        }
        
        StringBuilder buf = new StringBuilder();
        buf.append(errors.size() + " Error(s) occured:\n");
        for (ParsingError parsingError : errors) {
            buf.append(parsingError.getMessage() + " in line " + parsingError.getLine() + "\n");
        }
        return buf.toString();
    }

    /**
     * Gets the error list.
     * 
     * @return the error list
     */
    public List<ParsingError> getErrorList() {
        return errorList;
    }

	
}
