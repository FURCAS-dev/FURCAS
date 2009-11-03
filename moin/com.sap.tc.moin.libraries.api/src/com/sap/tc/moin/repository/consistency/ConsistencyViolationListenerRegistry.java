package com.sap.tc.moin.repository.consistency;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * Registry for consistency violations.
 * <p>
 * This registry allows to register listeners for consistency violations. In
 * addition, it provides an explicit consistency check for partitions and an API
 * for applying corrections.<br>
 * Two types of listeners can be registered: One default listener and a list of
 * additional listeners. The default listener is only called if no additional
 * listeners are registered. Additional listeners are intended to be used for
 * application specific listeners. The default listener is intended to be used
 * for a generic listener that is called if no application specific listener is
 * available.<br>
 * The registry is attached to the session. It can be obtained by calling
 * {@link Connection#getConsistencyViolationListenerRegistry()}.
 * </p>
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface ConsistencyViolationListenerRegistry {

    /**
     * Sets the default listener. This listener will be called if no other
     * listeners are registered using {@link #addListener(ConsistencyListener)}.
     * 
     * @param listener Default listener to be registered. If it is
     * <code>null</code>, the existing default listener will be removed.
     */
    void setDefaultListener( ConsistencyListener listener );

    /**
     * Returns the default consistency listener.
     * 
     * @return Default {@link ConsistencyListener}
     */
    ConsistencyListener getDefaultListener( );

    /**
     * Registers a consistency listener. The listener is called if an
     * inconsistency occurs or is resolved. The listener added here overrides
     * the default listener. The default listener is not called as long as any
     * listener is registered using {{@link #addListener(ConsistencyListener)}.
     * 
     * @param listener
     */
    void addListener( ConsistencyListener listener );

    /**
     * Returns if a listener is registered. I no listener is registered, the
     * default listener is called if one was registered.
     * 
     * @return True if a {@link ConsistencyListener} is registered.
     */
    boolean listenersRegistered( );

    /**
     * Unregisters a consistency listener.
     * 
     * @param listener
     */
    void removeListener( ConsistencyListener listener );

    /**
     * Returns an existing consistency violation.
     * 
     * @param id Id of the consistency violation
     * @return consistency violation, if existing. <code>null</code> otherwise.
     */
    ConsistencyViolation getConsistencyViolation( String id );

    /**
     * Returns all existing consistency violations.
     * 
     * @return Collection of the existing consistency violations.
     */
    Collection<ConsistencyViolation> getAllConsistencyViolations( );

    /**
     * Performs a consistency check for all links contained in a given
     * partition. The inconsistencies will be collected/notified by the
     * registry.
     * 
     * @param partition
     */
    void performConsistencyCheck( PRI partition );

    /**
     * Checks the consistency of the DC dependencies for all links in the
     * partition. The inconsistencies will be collected/notified by the
     * registry.
     * 
     * @param partition
     * @param connection
     */
    void performDcDependencyCheck( PRI partition );

    /**
     * Applies a correction. The correction is applied using the session that
     * this listener registry is attached to.
     * 
     * @param correctionId Id of the correction
     */
    void applyCorrection( String correctionId );

    /**
     * Returns the partitions that are affected by a given correction
     * 
     * @param correctionId Id of the correction
     * @return
     */
    public Collection<PartitionOperation> getAffectedPartitions( String correctionId );
}
