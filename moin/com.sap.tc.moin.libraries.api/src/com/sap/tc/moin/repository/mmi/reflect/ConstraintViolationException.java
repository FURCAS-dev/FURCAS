package com.sap.tc.moin.repository.mmi.reflect;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Exception thrown when a constraint is violated.
 */
public class ConstraintViolationException extends JmiException {

    private static final long serialVersionUID = 1L;

    private final String violationId;

    /**
     * Constructs an <code>ConstraintViolationException</code> with the
     * specified detail message.
     * 
     * @param objectInError object violating the constraint.
     * @param elementInError violated constraint object.
     * @param msg the detail message.
     * @param id the violation ID, must not be <code>null</code>
     */
    public ConstraintViolationException( Object objectInError, RefObject elementInError, MoinLocalizedString msg, String id ) {

        super( objectInError, elementInError, msg );
        this.violationId = id;
    }

    /**
     * @return a repeatable String identifying the violation, never
     * <code>null</code>
     */
    public String getViolationId( ) {

        return this.violationId;
    }
}
