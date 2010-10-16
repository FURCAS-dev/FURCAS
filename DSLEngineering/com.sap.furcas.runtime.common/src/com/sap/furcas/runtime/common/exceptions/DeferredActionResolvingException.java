/**
 * 
 */
package com.sap.furcas.runtime.common.exceptions;

import java.util.List;

/**
 *
 */
public class DeferredActionResolvingException extends Exception {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3946766193639084806L;
    private List<DeferredModelElementCreationException> causes;
    

    /**
     * Instantiates a new model handler exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public DeferredActionResolvingException(String message, List<DeferredModelElementCreationException> causes) {
        super(message);
        
        this.causes = causes;
    }


    /**
     * @return the causes
     */
    public List<DeferredModelElementCreationException> getCauses() {
        return causes;
    }
    
}
