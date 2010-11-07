package com.sap.furcas.runtime.common.exceptions;

public class ParserGeneratorInvocationException extends AbstractToolGenerationException {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2776720335758453500L;

    public ParserGeneratorInvocationException(Throwable cause){
        super(cause);
    }
    
    public ParserGeneratorInvocationException(String msg) {
        super(msg);
    }
    
    public ParserGeneratorInvocationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
