package com.sap.tc.moin.repository.ocl.freestyle;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;

/**
 * The listener interface for {@link OclExpressionRegistration}s.
 * <p>
 * This will be notified once the value returned by the expression has
 * (potentially) changed.
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 */
public interface ExpressionInvalidationListener {

    /**
     * @param affectedModelElements the objects for which the expression was
     * (potentially) invalidated
     * @param registration the {@link OclExpressionRegistration} for which this
     * invalidation was detected; can be used to re-evaluate the expression for
     * the relevant objects
     * @param eventTriggerConnection the {@link Connection} that triggered the
     * invalidationO 
     */
    public void notify(Collection<MRI> affectedModelElements,
	    OclExpressionRegistration registration,
	    Connection eventTriggerConnection);
}
