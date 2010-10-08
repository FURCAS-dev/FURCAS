/**
 * 
 */
package com.sap.furcas.runtime.common.exceptions;


/**
 *
 */
public class DeferredModelElementCreationException extends ModelAdapterException {

    /**
     * 
     */
    private static final long serialVersionUID = -6987101274526944374L;
    
    private Object errorCausingMockObject;

    /**
     * @param message
     */
    public DeferredModelElementCreationException(String message, Object causingObject) {
        super(message);
        errorCausingMockObject = causingObject;
    }

    /**
     * @return the errorCausingMockObject
     */
    public Object getErrorCausingMockObject() {
        return errorCausingMockObject;
    }

    
    
}
