package com.sap.tc.moin.repository.consistency;


/**
 * Correction handle interface. Each {@link ConsistencyViolation} returns a set
 * of correction handles. The correction handle contains a text describing the
 * correction and an id.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface ConsistencyCorrectionHandle {

    /**
     * Returns a human readable description of the correction.
     * 
     * @return description of the correction
     */
    String getDescription( );

    /**
     * Returns the id of the correction. This id is used to apply the correction
     * using
     * {@link ConsistencyViolationListenerRegistry#applyCorrection(String)}.
     * 
     * @return id of the correction
     */
    String getId( );
}
