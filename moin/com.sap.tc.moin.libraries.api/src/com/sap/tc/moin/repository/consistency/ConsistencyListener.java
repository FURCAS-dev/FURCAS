package com.sap.tc.moin.repository.consistency;

import com.sap.tc.moin.repository.Connection;

/**
 * Interface for consistency violation listeners. This interface has to be
 * implemented by classes that are registered at the consistency violation
 * registry (
 * {@link ConsistencyViolationListenerRegistry#addListener(ConsistencyListener)}
 * ).
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 * 
 * @author d026715
 */
public interface ConsistencyListener {

    /**
     * Called when an inconsistency is encountered.
     * 
     * @param consistencyViolation Array of consistency violations that have
     * occurred.
     * @param connection Connection created by MOIN.
     */
    void onConsistencyViolation( ConsistencyViolation[] consistencyViolation, Connection connection );

    /**
     * Called when an inconsistency has been resolved.
     * 
     * @param consistencyViolation Array of consistency violation that have been
     * resolved.
     * @param connection Connection created by MOIN.
     */
    void onConsistencyResolution( ConsistencyViolation[] consistencyViolation, Connection connection );

}
