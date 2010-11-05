/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.furcas.runtime.common.exceptions.AbstractToolGenerationException;
import com.sap.furcas.runtime.parser.ParsingError;

/**
 *
 */
public class SyntaxToGrammarTransformationException extends AbstractToolGenerationException {

     /**
     * 
     */
    private static final long serialVersionUID = -7827732266750829055L;
    /** The error list. */
    Collection<ParsingError> errorList = new ArrayList<ParsingError>();

    /**
     * @param message
     * @param errorList 
     */
    public SyntaxToGrammarTransformationException(Collection<ParsingError> errorList) {
        super(getMultiMessage(errorList));
        this.errorList = errorList;
    }
    
//    public void addErrors(Collection<ParsingError> errors) {
//        errorList.addAll(errors);
//    }
//    
//    /**
//     * @param error
//     */
//    public void addError(ParsingError error) {
//        errorList.add(error);
//    }
//    

    /**
     * Gets the error list.
     * 
     * @return the error list
     */
    public Collection<ParsingError> getErrorList() {
        return errorList;
    }
    
    /**
     * @param errors
     * @return
     */
    private static String getMultiMessage(Collection<ParsingError> errors) {
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
    
}
