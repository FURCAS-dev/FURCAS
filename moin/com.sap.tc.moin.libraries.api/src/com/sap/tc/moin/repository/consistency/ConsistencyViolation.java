package com.sap.tc.moin.repository.consistency;

import java.util.Locale;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;

/**
 * Consistency violation interface. This is the root interface for all
 * consistency violations. The consistency violation contains all information
 * available when the consistency violation occurred.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface ConsistencyViolation {

    /**
     * Returns the unique id of the consistency violation.
     * 
     * @return id as {@link String}
     */
    String getId( );

    /**
     * Returns a description of the violation.
     * 
     * @param connection
     * @return Description as {@link String}
     */
    String getDescription( Connection connection );

    /**
     * Returns a description of the violation.
     * 
     * @param connection
     * @param locale
     * @return Description as {@link String}
     */
    String getDescription( Connection connection, Locale locale );

    /**
     * Returns the MRI of the element causing the consistency violation.
     * 
     * @return Affected Element as {@link MRI}
     */
    MRI getAffectedElement( );

    /**
     * Returns a set of inconsistency correction handles.
     * 
     * @param connection
     * @return Array of {@link ConsistencyCorrectionHandle}s
     */
    ConsistencyCorrectionHandle[] getCorrectionHandles( Connection connection );

    /**
     * Returns if the violation is still valid. If not, the violation registry
     * will be updated accordingly.
     * 
     * @param connection
     * @return true if the violation is still valid, false otherwise.
     */
    boolean validate( Connection connection );
}
