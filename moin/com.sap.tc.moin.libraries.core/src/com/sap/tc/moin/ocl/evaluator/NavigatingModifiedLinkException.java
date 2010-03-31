package com.sap.tc.moin.ocl.evaluator;

/**
 * Thrown by the OCL evaluator when a navigation is attempted across a link that
 * has been reported as changed which would incorrectly taint the evaluation results.
 */
public class NavigatingModifiedLinkException extends RuntimeException {

    public NavigatingModifiedLinkException(String message) {
	super(message);
    }

    /**
     * 
     */
    private static final long serialVersionUID = -5919236888029949438L;

}
