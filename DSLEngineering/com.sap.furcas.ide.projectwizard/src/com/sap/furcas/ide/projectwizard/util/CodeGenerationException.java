package com.sap.furcas.ide.projectwizard.util;

import com.sap.furcas.runtime.common.exceptions.AbstractToolGenerationException;

public class CodeGenerationException extends AbstractToolGenerationException {

    /**
     * 
     */
    private static final long serialVersionUID = -6516709436487981645L;

    public CodeGenerationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodeGenerationException(String message) {
        super(message);
    }

    public CodeGenerationException(Throwable cause) {
        super(cause);
    }

}
