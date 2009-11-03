package com.sap.tc.moin.repository.mmi.reflect;

import java.util.List;

/**
 * The superclass that is extended by instances of modeled exceptions. That is,
 * all M1 instances of exceptions modeled in the respective M2 (i.e., instances
 * of <code>RefException</code>), must extend the reflective
 * <code>RefException</code> class. <code>RefException</code> is intended to
 * be a checked exception, and as such, it extends {@link java.lang.Exception}.
 */
public abstract class RefException extends Exception {

    /**
     * Creates a new instance.
     */
    public RefException( ) {

    }

    /**
     * Creates a new instance.
     * 
     * @param msg The message text
     */
    public RefException( String msg ) {

        super( msg );
    }

    /**
     * Returns the actual parameters given to the exception constructor at
     * creation time, to enable wrapping of RefObject instances.
     * <p>
     * This method is for internal use only!
     * 
     * @return The list of the parameters
     */
    public abstract List<Object> get___Parameters( );

    /**
     * Sets the list of parameters after they have been wrapped (if necessary).
     * <p>
     * This method is for internal use only!
     * 
     * @param parameters The list of the parameters
     */
    public abstract void set___Parameters( List<Object> parameters );
}
