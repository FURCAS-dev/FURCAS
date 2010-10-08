/**
 * 
 */
package com.sap.furcas.runtime.parser;

/**
 * to be thrown when during injecting, a modelElement could not be created
 */
public class ModelElementCreationException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 2437811906233344541L;

    /**
     * @param message
     * @param cause
     */
    public ModelElementCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ModelElementCreationException(String message) {
        super(message);
    }

}
