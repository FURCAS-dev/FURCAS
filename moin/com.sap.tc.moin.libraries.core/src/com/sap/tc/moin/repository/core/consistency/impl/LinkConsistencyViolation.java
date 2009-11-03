package com.sap.tc.moin.repository.core.consistency.impl;

import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.core.EndStorageLink;

/**
 * Internal interface for link consistency violations.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface LinkConsistencyViolation extends ConsistencyViolation {

    /**
     * Returns the affected {@link EndStorageLink}.
     * 
     * @return
     */
    EndStorageLink getAffectedLink( );

}
