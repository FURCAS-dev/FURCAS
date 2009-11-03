package com.sap.tc.moin.repository.mmi.reflect;

/**
 * Exception thrown when Composition Closure or Reference Closure rules are
 * violated. (Supertype Closure rule can never be violated in JMI).
 */
public class ClosureViolationException extends JmiException {


    private static final long serialVersionUID = 1L;

    /**
     * Constructs an <code>ClosureViolationException</code> without detail
     * message.
     * 
     * @param objectInError An instance that violated the closure rule.
     * @param elementInError Reference, Attribute or Association for which the
     * closure rule is violated.
     */
    public ClosureViolationException( Object objectInError, RefObject elementInError ) {

        super( objectInError, elementInError, JmiExceptionMessages.CLOSURERULESVIOLATED );
    }

}