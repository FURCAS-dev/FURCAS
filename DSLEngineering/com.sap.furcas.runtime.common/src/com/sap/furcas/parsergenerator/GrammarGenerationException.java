package com.sap.furcas.parsergenerator;

import com.sap.furcas.runtime.common.exceptions.AbstractToolGenerationException;

/**
 * Thrown when the grammar generation fails.
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
