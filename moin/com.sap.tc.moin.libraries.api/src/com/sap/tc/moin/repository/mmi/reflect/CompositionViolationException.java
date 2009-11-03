package com.sap.tc.moin.repository.mmi.reflect;

/**
 * Exception thrown when an instance object is going to become owned by more
 * than one element (in sense of aggregation semantics).
 */
public class CompositionViolationException extends JmiException {


    private static final long serialVersionUID = 1L;

    /**
     * Constructs a <code>CompositionViolationException</code> without detail
     * message.
     * 
     * @param objectInError An instance (component) that caused the composition
     * violation.
     * @param elementInError Attribute, Reference or Association that is being
     * updated to violate the composition.
     */
    public CompositionViolationException( Object objectInError, RefObject elementInError ) {

        super( objectInError, elementInError, JmiExceptionMessages.COMPOSITIONRULEVIOLATED );
    }


}