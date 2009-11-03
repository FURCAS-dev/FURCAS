package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Is thrown if {@link Connection#save()} is called but there is at least one
 * link from a non-transient element (an element which is assigned to a
 * non-transient partition) to a transient element (an element which is assigned
 * to a {@link Connection#getTransientPartitions() transient partition}. The
 * referenced transient elements can be retrieved via
 * {@link Connection#getReferencedTransientElements()}.
 */
public class ReferencedTransientElementsException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     * @param args
     */
    public ReferencedTransientElementsException( MoinLocalizedString message, Object... args ) {

        super( message, args );

    }

}
