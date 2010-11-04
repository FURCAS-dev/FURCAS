package com.sap.furcas.runtime.common.exceptions;

/**
 * to be thrown when generating of Grammar fails
 * 
 * @author C5107456
 */
public class GrammarGenerationException extends AbstractToolGenerationException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2572469490061019266L;

    public GrammarGenerationException(String message) {
        super(message);
    }

    public GrammarGenerationException(String message, Throwable cause) {
        super(message, cause);
    }

}
